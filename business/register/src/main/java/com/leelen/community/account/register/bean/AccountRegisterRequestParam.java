package com.leelen.community.account.register.bean;

import com.leelen.common.bean.EncryptParam;
import com.leelen.community.account.register.constance.CommunityConst;

/**
 * @description: 帐号注册请求参数集
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/22
 * @version: 1.00
 * @history:
 */
public class AccountRegisterRequestParam extends EncryptParam {

    /**
     * 用户名，可手机号、邮箱、自定义名称
     */
    private String username;

    /**
     * 密码（SHA256加密）
     */
    private String password;

    /**
     * 国际电话区号，手机注册时必填，默认86
     */
    private int intlPhoneCode = CommunityConst.MobileAreaCode.CODE_CHINESE;

    /**
     * 帐号类型 1：手机号 2：邮箱 3：用户名
     */
    private int accountType = CommunityConst.AccountType.TYPE_PHONE;

    /**
     * 获取成功返回的验证码标识
     */
    private String verifyCodeSign;

    /**
     * 验证码
     */
    private String verifyCode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIntlPhoneCode() {
        return intlPhoneCode;
    }

    public void setIntlPhoneCode(int intlPhoneCode) {
        this.intlPhoneCode = intlPhoneCode;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getVerifyCodeSign() {
        return verifyCodeSign;
    }

    public void setVerifyCodeSign(String verifyCodeSign) {
        this.verifyCodeSign = verifyCodeSign;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
