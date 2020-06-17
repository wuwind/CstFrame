package com.leelen.community.account.base;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;

import com.alibaba.fastjson.JSON;
import com.leelen.community.account.bean.AccountLockedMsgBean;
import com.leelen.community.account.bean.ErrorPwdMsgBean;
import com.leelen.community.account.bean.VerifyCodeLimitMsgBean;
import com.leelen.community.account.constance.HttpConst;
import com.leelen.community.register.R;
import com.leelen.core.base.BaseContract;
import com.leelen.core.utils.NetworkUtil;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * @description:
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/27
 * @version: 1.00
 * @history:
 */
public abstract class BaseAppPresenter {
    public String TAG = getClass().getSimpleName();
    protected LifecycleOwner mOwner;

    public void setLifecycleOwner(LifecycleOwner owner) {
        mOwner = owner;
    }

    /**
     * mqtt等待倒计时
     *
     * @param seq      请求唯一标识
     * @param waitTime 倒计时时间，单位毫秒
     */
    public Disposable startWaitTimeCountDown(int seq, int waitTime, MqttTimeOutListener listener) {
        return Observable.timer(waitTime, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mOwner, Lifecycle.Event.ON_DESTROY)))
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        listener.onTimeOut(seq);
                    }
                });
    }

    /**
     * 注册Rxbus事件
     */
    public void registerRxBusEvent() {
    }

    /**
     * rxjava 解除注册
     */
    public void disposeRx(Disposable d) {
        if (d != null && !d.isDisposed()) {
            d.dispose();
        }
    }

    /**
     * 检查网络是否正常连接
     */
    public boolean checkNet(BaseContract.BaseView view) {
        if (!NetworkUtil.isConnected(CommunityApplication.getAppContext())) {
            view.showToast(R.string.no_network_connect);
            return false;
        }
        return true;
    }

    /**
     * 显示网络请求错误提示
     *
     * @param view view接口类
     * @param code 错误码
     * @param msg  错误内容
     */
    public void showHttpRequestErrorTips(BaseContract.BaseView view, int code, String msg) {
        switch (code) {
            case HttpConst.RESULT_CODE_ILLEGAL_REQUEST:
                view.showToast(R.string.illegal_request);
                break;
            case HttpConst.RESULT_CODE_OLD_PASSWORD_ERROR:
                view.showToast(R.string.old_password_error);
                break;
            case HttpConst.RESULT_CODE_ACCOUNT_NO_REGISTER:
                view.showTipDialog(R.string.account_unregister);
                break;
            case HttpConst.RESULT_CODE_ACCOUNT_EXIST:
                view.showTipDialog(R.string.account_exist);
                break;
            case HttpConst.RESULT_CODE_INVALID_VERIFY_CODE:
                view.showToast(R.string.verify_code_invalid);
                break;
            case HttpConst.RESULT_CODE_VERIFY_CODE_EXPIRED:
                view.showToast(R.string.verify_code_expired);
                break;
            case HttpConst.RESULT_CODE_VERIFY_CODE_SEND_FREQUENTLY:
                VerifyCodeLimitMsgBean limitMsgBean = JSON.parseObject(msg, VerifyCodeLimitMsgBean.class);
                if ("day".equals(limitMsgBean.getUnit())) {
                    view.showToast(R.string.today_verify_code_out_limit);
                } else {
                    view.showToast(R.string.verify_code_send_frequently);
                }
                break;
            case HttpConst.RESULT_CODE_ACCOUNT_DISABLED:
                view.showTipDialog(R.string.account_disable);
                break;
            case HttpConst.RESULT_CODE_LOGIN_PASSWORD_ERROR:
                ErrorPwdMsgBean bean = JSON.parseObject(msg, ErrorPwdMsgBean.class);
                view.showTipDialog(String.format(view.getContextResource().getString(R.string.password_error_retry_tip),
                        bean.getNum()));
                break;
            case HttpConst.RESULT_CODE_ACCOUNT_LOCKED:
                AccountLockedMsgBean lockedMsgBean = JSON.parseObject(msg, AccountLockedMsgBean.class);
                String lockedTime = getTimeBySeconds(lockedMsgBean.getTime());
                view.showTipDialog(String.format(
                        view.getContextResource().getString(R.string.account_locked_time_to_unlock), lockedTime));
                break;
            case HttpConst.RESULT_CODE_PROPERTY_OFFLINE:
                view.showToast(R.string.property_offline);
                break;
            case HttpConst.RESULT_CODE_PHONE_TIME_ABNORMAL:
                view.showToast(R.string.phone_time_abnormal);
                break;
            default:
                view.showToast(R.string.request_fail);
        }
    }

    /**
     * 通过秒数转成时间字符串 00:00:00
     *
     * @param seconds 秒数
     */
    private String getTimeBySeconds(long seconds) {
        long hours = seconds / 3600;
        seconds = seconds % 3600;

        long minutes = seconds / 60;
        seconds = seconds % 60;

        StringBuilder sb = new StringBuilder();
        if (hours < 10) {
            sb.append("0");

        }
        sb.append(hours).append(":");
        if (minutes < 10) {
            sb.append("0");
        }
        sb.append(minutes).append(":");
        if (seconds < 10) {
            sb.append("0");
        }
        sb.append(seconds);
        return sb.toString();
    }

    public interface MqttTimeOutListener {
        void onTimeOut(int seq);
    }

    public void doOnActivityCreate() {
    }
}
