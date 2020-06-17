package com.leelen.community.account.bean;

import com.leelen.common.bean.EncryptParam;
import com.leelen.community.account.constance.CommunityConst;

/**
 * @description: 重置密码实体类
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/22
 * @version: 1.00
 * @history:
 */
public class ResetPasswordRequestParam extends EncryptParam {

    /**
     * 用户名，可手机号、邮箱
     */
    private String username;

    /**
     * 帐号类型 1：手机号 2：邮箱 3：用户名
     */
    private int accountType = CommunityConst.AccountType.TYPE_PHONE;

    /**
     * 国际电话区号，短信验证时必填，默认86
     */
    private int intlPhoneCode = CommunityConst.MobileAreaCode.CODE_CHINESE;

    /**
     * 新密码
     */
    private String newPwd;

    /**
     * 用户输入的验证码
     */
    private String verifyCode;

    /**
     * 验证码获取接口返回的验证码标识
     */
    private String verifyCodeSign;

    /**
     * 登录设备的操作系统
     */
    private int osType = CommunityConst.OsType.TYPE_ANDROID_PHONE;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public int getIntlPhoneCode() {
        return intlPhoneCode;
    }

    public void setIntlPhoneCode(int intlPhoneCode) {
        this.intlPhoneCode = intlPhoneCode;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getVerifyCodeSign() {
        return verifyCodeSign;
    }

    public void setVerifyCodeSign(String verifyCodeSign) {
        this.verifyCodeSign = verifyCodeSign;
    }

    public int getOsType() {
        return osType;
    }

    public void setOsType(int osType) {
        this.osType = osType;
    }

}
