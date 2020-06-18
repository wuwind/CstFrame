package com.leelen.community.account.register.model;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * @description: SharePreference 类，存储简单的信息
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/21
 * @version: 1.00
 * @history:
 */
public class SharePreferenceModel {
    private static SharedPreferences mPrefs = null;
    private static SharedPreferences.Editor mEditor = null;
    private static String PREFS_NAME = "sp_community";//SharePreference文件名

    private static final String REGISTER_VERIFY_CODE_SIGN = "REGISTER_VERIFY_CODE_SIGN";// 注册验证码标识
    private static final String FORGET_PWD_VERIFY_CODE_SIGN = "FORGET_PWD_VERIFY_CODE_SIGN";// 忘记密码验证码标识
    private static final String IS_SMART_ENCRYPT_ACCOUNT = "IS_SMART_ENCRYPT_ACCOUNT";// 是否启用帐号加密

    public static void init(Context context) {
        mPrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        mEditor = mPrefs.edit();
    }

    /**
     * 注册验证码标识
     */
    public static void setRegisterVerifyCodeSign(String sign) {
        mEditor.putString(REGISTER_VERIFY_CODE_SIGN, sign).commit();
    }

    public static String getRegisterSecurityVerifyCodeSign() {
        return mPrefs.getString(REGISTER_VERIFY_CODE_SIGN, "");
    }

    /**
     * 忘记密码验证码标识
     */
    public static void setForgetPwdVerifyCodeSign(String sign) {
        mEditor.putString(FORGET_PWD_VERIFY_CODE_SIGN, sign).commit();
    }

    public static String getForgetPwdVerifyCodeSign() {
        return mPrefs.getString(FORGET_PWD_VERIFY_CODE_SIGN, "");
    }

    /**
     * 是否启用加密帐号
     */
    public static void setIsEncryptAccountEnable(boolean b) {
        mEditor.putBoolean(IS_SMART_ENCRYPT_ACCOUNT, b).commit();
    }

    public static boolean getIsEncryptAccountEnable() {
        return mPrefs.getBoolean(IS_SMART_ENCRYPT_ACCOUNT, true);
    }
}
