package com.leelen.community.account.register.model;

import com.leelen.common.http.SeqSingleton;
import com.leelen.common.http.bean.BaseResponse;
import com.leelen.common.model.Uuid;
import com.leelen.community.account.register.base.BaseModel;
import com.leelen.community.account.register.base.GetUuidResponseParam;
import com.leelen.community.account.register.bean.AccountRegisterRequestParam;
import com.leelen.community.account.register.bean.GetVerifyCodeRequestParam;
import com.leelen.community.account.register.bean.ResetPasswordRequestParam;
import com.leelen.community.account.register.contract.RegisterOrResetPwdContract;
import com.leelen.core.utils.SHA256Utils;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

/**
 * @description:
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/25
 * @version: 1.00
 * @history:
 */
public class RegisterOrResetPwdModel extends BaseModel implements RegisterOrResetPwdContract.Model {
    /**
     * 获取验证码
     *
     * @param userName       用户名
     * @param verifyCodeType 验证码类型
     * @param verifyModel    验证方式
     */
    public Observable<BaseResponse> getVerifyCode(String userName, int verifyCodeType, int verifyModel) {
        int seq = SeqSingleton.getInstance().getSeq();
        GetVerifyCodeRequestParam param = new GetVerifyCodeRequestParam();
        param.setUsername(userName);
        param.setVerifyCodeType(verifyCodeType);
        param.setVerifyModel(verifyModel);
        return mHttpOperator.getVerifyCode(seq, param);
    }

    /**
     * 获取uuid
     *
     * @return
     */
    public Observable<BaseResponse<GetUuidResponseParam>> getUuid() {
        int seq = SeqSingleton.getInstance().getSeq();
        return mHttpOperator.getUuid(seq).doOnNext(new Consumer<BaseResponse<GetUuidResponseParam>>() {
            @Override
            public void accept(BaseResponse<GetUuidResponseParam> baseResponse) throws Exception {
                if (baseResponse.isOk()) {
                    Uuid.getInstance().setUuid(baseResponse.getParams().getUuid());
                }
            }
        });
    }

    /**
     * 帐号注册
     *
     * @param userName            用户名
     * @param password            密码
     * @param verifyCodeSign      验证码标识
     * @param verifyCode          验证码
     */
    public Observable<BaseResponse> register(String userName, String password, String verifyCodeSign, String verifyCode) {
        int seq = SeqSingleton.getInstance().getSeq();
        String pwd = SHA256Utils.Encrypt(password);
        AccountRegisterRequestParam param = new AccountRegisterRequestParam();
        param.setTimestamp(System.currentTimeMillis());
        param.setUsername(userName);
        param.setPassword(pwd);
        param.setVerifyCode(verifyCode);
        param.setVerifyCodeSign(verifyCodeSign);
        Observable<BaseResponse> registerObservable;
        if(SharePreferenceModel.getIsEncryptAccountEnable()){
            registerObservable = mHttpOperator.encryptAccountRegister(seq, param);
        }else{
            registerObservable = mHttpOperator.accountRegister(seq, param);
        }
        return registerObservable;
    }

    /**
     * 重置密码
     *
     * @param userName       用户名
     * @param password       密码
     * @param verifyCodeSign 验证码标识
     * @param verifyCode     验证码
     */
    public Observable<BaseResponse> resetPassword(String userName, String password, String verifyCodeSign,
                                                  String verifyCode) {
        int seq = SeqSingleton.getInstance().getSeq();
        String pwd = SHA256Utils.Encrypt(password);
        ResetPasswordRequestParam param = new ResetPasswordRequestParam();
        param.setTimestamp(System.currentTimeMillis());
        param.setUsername(userName);
        param.setNewPwd(pwd);
        param.setVerifyCodeSign(verifyCodeSign);
        param.setVerifyCode(verifyCode);
        if(SharePreferenceModel.getIsEncryptAccountEnable()){
            return mHttpOperator.encryptResetPassword(seq, param);
        }else{
            return mHttpOperator.resetPassword(seq, param);
        }
    }
}
