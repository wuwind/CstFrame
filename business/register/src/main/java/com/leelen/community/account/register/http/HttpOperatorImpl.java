package com.leelen.community.account.register.http;

import android.content.Context;

import com.leelen.common.http.CommonHttpOperator;
import com.leelen.common.http.bean.BaseRequest;
import com.leelen.common.http.bean.BaseResponse;
import com.leelen.common.model.Uuid;
import com.leelen.community.account.register.base.GetUuidResponseParam;
import com.leelen.community.account.register.bean.AccountRegisterRequestParam;
import com.leelen.community.account.register.bean.GetVerifyCodeRequestParam;
import com.leelen.community.account.register.bean.ResetPasswordRequestParam;
import com.leelen.core.http.RetrofitUtil;
import com.leelen.core.utils.EncryptDecryptUtils;

import io.reactivex.Observable;

/**
 * @description: http请求实现类
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2017/5/12.
 * @version: 1.00
 * @history:
 */
@SuppressWarnings("unchecked")
public class HttpOperatorImpl implements HttpOperator {
    private static final String TAG = HttpOperatorImpl.class.getSimpleName();

    private static final int CONNECT_TIME = 5;
    private static final int READ_TIME = 20;

    private Context mContext;
    private ServerApi mServerApi;

    public HttpOperatorImpl(Context context) {
        mContext = context;

        mServerApi = RetrofitUtil.getInstance().createApi(ServerApi.class);
    }

    /**
     * 组装请求体
     *
     * @param seq   请求唯一标识
     * @param param 请求参数集，空的时候传null
     * @return 请求体
     */
    private BaseRequest wrapRequest(int seq, Object param) {
        return CommonHttpOperator.getInstance().wrapRequest(seq, param);
    }

    private synchronized Observable wrapperObservable(Observable request) {
        return CommonHttpOperator.getInstance().wrapperObservable(request);
    }

    @Override
    public Observable<BaseResponse> getVerifyCode(int seq, GetVerifyCodeRequestParam param) {
        BaseRequest request = wrapRequest(seq, param);
        return wrapperObservable(mServerApi.getVerifyCode(request));
    }

    @Override
    public Observable<BaseResponse<GetUuidResponseParam>> getUuid(int seq) {
        BaseRequest request = wrapRequest(seq, null);
        return wrapperObservable(mServerApi.getUuid(request));
    }


    @Override
    public Observable<BaseResponse> accountRegister(int seq, AccountRegisterRequestParam param) {
        BaseRequest request = wrapRequest(seq, param);
        return wrapperObservable(mServerApi.accountRegister(request));
    }

    @Override
    public Observable<BaseResponse> encryptAccountRegister(int seq, AccountRegisterRequestParam param) {
        BaseRequest request = wrapRequest(seq, EncryptDecryptUtils.encryptParams(param, Uuid.getInstance().getUuid()));
        return wrapperObservable(mServerApi.encryptV1AccountRegister(request));
    }

    @Override
    public Observable<BaseResponse> resetPassword(int seq, ResetPasswordRequestParam param) {
        BaseRequest request = wrapRequest(seq, param);
        return wrapperObservable(mServerApi.resetPassword(request));
    }

    @Override
    public Observable<BaseResponse> encryptResetPassword(int seq, ResetPasswordRequestParam param) {
        BaseRequest request = wrapRequest(seq, EncryptDecryptUtils.encryptParams(param, Uuid.getInstance().getUuid()));
        return wrapperObservable(mServerApi.encryptV1ResetPassword(request));
    }
}
