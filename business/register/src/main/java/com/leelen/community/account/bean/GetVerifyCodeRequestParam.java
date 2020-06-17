package com.leelen.community.account.bean;


import com.leelen.community.account.constance.CommunityConst;

/**
 * @description: 获取验证码请求体
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/22
 * @version: 1.00
 * @history:
 */
public class GetVerifyCodeRequestParam {
    /**
     * 用户名，可手机号、邮箱
     */
    private String username;

    /**
     * 验证码类型
     */
    private int verifyCodeType;

    /**
     * 验证方式
     */
    private int verifyModel = CommunityConst.VerifyModel.TYPE_SMS;

    /**
     * 国际电话区号，短信验证时必填，默认86
     */
    private int intlPhoneCode = CommunityConst.MobileAreaCode.CODE_CHINESE;

    /**
     * 发送内容语言
     */
    private String language = CommunityConst.LanguageType.TYPE_CN;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getVerifyCodeType() {
        return verifyCodeType;
    }

    public void setVerifyCodeType(int verifyCodeType) {
        this.verifyCodeType = verifyCodeType;
    }

    public int getVerifyModel() {
        return verifyModel;
    }

    public void setVerifyModel(int verifyModel) {
        this.verifyModel = verifyModel;
    }

    public int getIntlPhoneCode() {
        return intlPhoneCode;
    }

    public void setIntlPhoneCode(int intlPhoneCode) {
        this.intlPhoneCode = intlPhoneCode;
    }
}
