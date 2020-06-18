package com.leelen.community.account.register.http;

import com.leelen.common.http.bean.BaseResponse;
import com.leelen.community.account.register.base.GetUuidResponseParam;
import com.leelen.community.account.register.bean.AccountRegisterRequestParam;
import com.leelen.community.account.register.bean.GetVerifyCodeRequestParam;
import com.leelen.community.account.register.bean.ResetPasswordRequestParam;

import io.reactivex.Observable;

/**
 * @description: http请求接口类
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/22
 * @version: 1.00
 * @history:
 */
public interface HttpOperator {

    /**
     * 获取授权码(默认中文)
     *
     * @param seq   请求唯一标识
     * @param param 获取验证码参数集
     */
    Observable<BaseResponse> getVerifyCode(int seq, GetVerifyCodeRequestParam param);

    /**
     * 获取uuid
     *
     * @param seq   请求唯一标识
     */
    Observable<BaseResponse<GetUuidResponseParam>> getUuid(int seq );

    /**
     * 加密手机号注册
     *
     * @param seq   请求唯一标识
     * @param param 请求参数集
     */
    Observable<BaseResponse> encryptAccountRegister(int seq, AccountRegisterRequestParam param);

    /**
     * 手机号注册
     *
     * @param seq   请求唯一标识
     * @param param 请求参数集
     */
    Observable<BaseResponse> accountRegister(int seq, AccountRegisterRequestParam param);

    /**
     * 重置密码
     *
     * @param seq   请求唯一标识
     * @param param 重置密码参数集
     */
    Observable<BaseResponse> resetPassword(int seq, ResetPasswordRequestParam param);

    /**
     * 加密重置密码
     *
     * @param seq   请求唯一标识
     * @param param 重置密码参数集
     */
    Observable<BaseResponse> encryptResetPassword(int seq, ResetPasswordRequestParam param);
}

























