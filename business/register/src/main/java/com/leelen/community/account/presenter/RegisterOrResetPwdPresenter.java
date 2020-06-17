package com.leelen.community.account.presenter;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Lifecycle;
import android.text.TextUtils;
import android.util.Log;

import com.leelen.common.http.bean.BaseResponse;
import com.leelen.community.account.base.BaseAppPresenter;
import com.leelen.community.account.base.GetUuidResponseParam;
import com.leelen.community.account.constance.CommunityConst;
import com.leelen.community.account.contract.RegisterOrResetPwdContract;
import com.leelen.community.account.model.RegisterOrResetPwdModel;
import com.leelen.community.account.model.SharePreferenceModel;
import com.leelen.community.register.R;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * @description:
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/25
 * @version: 1.00
 * @history:
 */
public class RegisterOrResetPwdPresenter extends BaseAppPresenter implements RegisterOrResetPwdContract.Presenter {

    private RegisterOrResetPwdContract.View mView;
    private String mVerifyCodeSign;
    private RegisterOrResetPwdModel mModel;

    public RegisterOrResetPwdPresenter() {
        mModel = new RegisterOrResetPwdModel();
    }

    @Override
    public void attachView(RegisterOrResetPwdContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    /**
     * 获取验证码
     */
    public void getVerifyCode() {
        if (!checkNet(mView)) {
            return;
        }
        mView.showLoading(R.string.getting_verify_code);
        String userName = mView.getUserName();
        int verifyCodeType = mView.getVerifyCodeType();
        int verifyModel = CommunityConst.VerifyModel.TYPE_SMS;
        mModel.getVerifyCode(userName, verifyCodeType, verifyModel)
                .observeOn(AndroidSchedulers.mainThread())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mOwner, Lifecycle.Event.ON_DESTROY)))
                .subscribe(new GetVerifyCodeCallback());
    }

    /**
     * 获取uuid
     */
    public void getUuid() {
        mModel.getUuid()
                .observeOn(AndroidSchedulers.mainThread())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mOwner, Lifecycle.Event.ON_DESTROY)))
                .subscribe(new Consumer<BaseResponse<GetUuidResponseParam>>() {
                    @Override
                    public void accept(BaseResponse<GetUuidResponseParam> baseResponse) throws Exception {
                        if (baseResponse.isOk()) {
                            clickSure();
                        } else {
                            mView.showToast(R.string.login_fail);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.showToast(R.string.login_fail);
                    }
                });
    }

    /**
     * 点击确认去注册帐号或重置密码
     */
    @SuppressLint("CheckResult")
    public void clickSure() {
        if (!checkNet(mView) || !checkPassword()) {
            return;
        }
        String userName = mView.getUserName();
        String password = mView.getPassword();
        String verifyCode = mView.getVerifyCode();
        int verifyCodeType = mView.getVerifyCodeType();
        if (verifyCodeType == CommunityConst.VerifyCodeType.TYPE_ACCOUNT_REGISTER) {
            mView.showLoading(R.string.account_registration_in_progress);
            if (TextUtils.isEmpty(mVerifyCodeSign)) {
                mVerifyCodeSign = SharePreferenceModel.getRegisterSecurityVerifyCodeSign();
            }
            // 注册帐号，如果注册成功则直接登录
            mModel.register(userName, password, mVerifyCodeSign, verifyCode)
                    .subscribe(new Consumer<BaseResponse>() {
                        @Override
                        public void accept(BaseResponse baseResponse) throws Exception {
                            mView.hideLoading();
                            if (!baseResponse.isOk()) {
                                if (baseResponse.getResult() == 0) {
                                    mView.showToast(R.string.register_fail);
                                } else {
                                    showHttpRequestErrorTips(mView, baseResponse.getResult(), baseResponse.getMessage());
                                }
                            } else {
                                Log.e(TAG, "注册成功");
                            }
                        }
                    }, new Consumer<Throwable>() {
                        @Override
                        public void accept(Throwable throwable) throws Exception {
                            mView.hideLoading();
                            mView.showToast(R.string.register_fail);
                            Log.e(TAG, "注册失败");
                        }
                    });
        } else {
            mView.showLoading(R.string.reset_password);
            if (TextUtils.isEmpty(mVerifyCodeSign)) {
                mVerifyCodeSign = SharePreferenceModel.getForgetPwdVerifyCodeSign();
            }
//            重置密码
            mModel.resetPassword(userName, password, mVerifyCodeSign, verifyCode)
                    .observeOn(AndroidSchedulers.mainThread())
                    .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mOwner,
                            Lifecycle.Event.ON_DESTROY)))
                    .subscribe(new CheckVerifyCodeCallback());
        }
    }

    /**
     * 检查密码
     */
    private boolean checkPassword() {
        String newPwd = mView.getPassword();
        String regexEnglish = ".*[a-zA-z].*";
        boolean containEnglish = newPwd.matches(regexEnglish);
        String regexNum = ".*[0-9].*";
        boolean containNum = newPwd.matches(regexNum);
        if (!containEnglish || !containNum) {
            mView.showToast(R.string.pwd_format_error);
            return false;
        }
        return true;
    }


    /**
     * 获取验证倒计时
     */
    private void doCountDown() {
        mView.setGetCodeEnable(false);
        int countTime = CommunityConst.GET_VERIFY_CODE_TIME;
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(Long aLong) throws Exception {
                        return countTime - aLong.intValue();
                    }
                }).take(countTime + 1)
                .observeOn(AndroidSchedulers.mainThread())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mOwner, Lifecycle.Event.ON_DESTROY)))
                .subscribe(new Observer<Integer>() {
                    private Disposable mDisposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(Integer integer) {
                        mView.setGetVerifyCodeText(integer);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                        mDisposable.dispose();
                        mView.setGetCodeEnable(true);
                        mView.setGetVerifyCodeText(-1);
                    }
                });
    }

    /**
     * 获取验证码回调
     */
    private class GetVerifyCodeCallback implements Observer<BaseResponse> {
        @Override
        public void onSubscribe(Disposable d) {
        }

        @Override
        public void onNext(BaseResponse baseResponse) {
            mView.hideLoading();
            if (baseResponse.isOk()) {
                mVerifyCodeSign = (String) baseResponse.getParams();
                int verifyType = mView.getVerifyCodeType();
                if (verifyType == CommunityConst.VerifyCodeType.TYPE_ACCOUNT_REGISTER) {
                    SharePreferenceModel.setRegisterVerifyCodeSign(mVerifyCodeSign);
                } else if (verifyType == CommunityConst.VerifyCodeType.TYPE_MODIFY_PASSWORD) {
                    SharePreferenceModel.setForgetPwdVerifyCodeSign(mVerifyCodeSign);
                }
                doCountDown();
            } else {
                if (baseResponse.getResult() == 0) {
                    mView.showToast(R.string.verify_code_send_fail);
                } else {
                    showHttpRequestErrorTips(mView, baseResponse.getResult(), baseResponse.getMessage());
                }
            }
        }

        @Override
        public void onError(Throwable e) {
            mView.hideLoading();
            mView.showToast(R.string.verify_code_send_fail);
        }

        @Override
        public void onComplete() {
        }
    }

    /**
     * 校验验证码回调
     */
    private class CheckVerifyCodeCallback implements Observer<BaseResponse> {
        @Override
        public void onSubscribe(Disposable d) {
        }

        @Override
        public void onNext(BaseResponse baseResponse) {
            mView.hideLoading();
            if (baseResponse.isOk()) {
                mView.showToast(R.string.reset_success_plz_re_login);
                String userName = mView.getUserName();
//                ResetPwdEvent event = new ResetPwdEvent();
//                event.setUserName(userName);
//                RxBus.getInstance().post(event);
                mView.finishActivity();
            } else {
                showHttpRequestErrorTips(mView, baseResponse.getResult(), baseResponse.getMessage());
            }
        }

        @Override
        public void onError(Throwable e) {
            mView.hideLoading();
            mView.showToast(R.string.reset_failed);
        }

        @Override
        public void onComplete() {
        }
    }

}
