package com.leelen.community.account.register.http;


import com.leelen.common.http.bean.BaseRequest;
import com.leelen.common.http.bean.BaseResponse;
import com.leelen.community.account.register.base.GetUuidResponseParam;
import com.leelen.community.account.register.bean.AccountRegisterRequestParam;
import com.leelen.community.account.register.bean.GetVerifyCodeRequestParam;
import com.leelen.community.account.register.bean.ResetPasswordRequestParam;
import com.leelen.community.account.register.constance.HttpConst;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * @description: http请求api
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/22
 * @version: 1.00
 * @history:
 */
public interface ServerApi {
    /**
     * 获取验证码
     *
     * @param request 获取验证码请求体
     */
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST(HttpConst.GET_VERIFY_CODE)
    Observable<BaseResponse> getVerifyCode(@Body BaseRequest<GetVerifyCodeRequestParam> request);

    /**
     * 获取uuid
     *
     * @param request 帐号注册请求体
     */
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST(HttpConst.GET_UUID)
    Observable<BaseResponse<GetUuidResponseParam>> getUuid(@Body BaseRequest request);

    /**
     * 帐号注册
     *
     * @param request 帐号注册请求体
     */
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST(HttpConst.ACCOUNT_REGISTER)
    Observable<BaseResponse> accountRegister(@Body BaseRequest<AccountRegisterRequestParam> request);

    /**
     * 加密帐号注册
     *
     * @param request 帐号注册请求体
     */
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST(HttpConst.ENCRYPT_V1_ACCOUNT_REGISTER)
    Observable<BaseResponse> encryptV1AccountRegister(@Body BaseRequest<AccountRegisterRequestParam> request);

    /**
     * 重置密码
     *
     * @param request 重置请求体
     */
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST(HttpConst.RESET_PASSWORD)
    Observable<BaseResponse> resetPassword(@Body BaseRequest<ResetPasswordRequestParam> request);

    /**
     * 加密重置密码
     *
     * @param request 重置请求体
     */
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    @POST(HttpConst.ENCRYPT_V1_RESET_PASSWORD)
    Observable<BaseResponse> encryptV1ResetPassword(@Body BaseRequest<ResetPasswordRequestParam> request);
}

















