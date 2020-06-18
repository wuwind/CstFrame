package com.leelen.community.account.register.constance;

/**
 * Created by wuhf on 2020/6/17.
 * Description ：
 */
public interface CommunityConst {
    /**
     * 手机号长度
     */
    int PHONE_NUM_LENGTH = 11;

    /**
     * 密码最短长度
     */
    int MIN_PASSWORD_LENGTH = 8;


    /**
     * 获取验证码倒计时
     */
    int GET_VERIFY_CODE_TIME = 120;


    String BUNDLE_VERIFY_CODE_TYPE = "BUNDLE_VERIFY_CODE_TYPE";

    String BUNDLE_USER_NAME = "BUNDLE_USER_NAME";

    /**
     * 验证码类型
     */
    interface VerifyCodeType {
        /**
         * 帐号注册
         */
        int TYPE_ACCOUNT_REGISTER = 1;
        /**
         * 修改密码
         */
        int TYPE_MODIFY_PASSWORD = 2;
        /**
         * 修改手机号
         */
        int TYPE_MODIFY_PHONE_NUM = 6;
        /**
         * 设备授权
         */
        int TYPE_DEVICE_AUTH = 7;
        /**
         * 通知用户手动下载app
         */
        int TYPE_NOTIFY_MANUAL_DOWNLOAD_APP = 8;
    }

    /**
     * 验证方式
     */
    interface VerifyModel {
        /**
         * 短信验证
         */
        int TYPE_SMS = 1;
        /**
         * 邮箱验证
         */
        int TYPE_MAIL = 2;
    }

    /**
     * 电话区号
     */
    interface MobileAreaCode {
        /**
         * 中国电话区号
         */
        int CODE_CHINESE = 86;
    }

    /**
     * 语言类型
     */
    interface LanguageType {
        /**
         * 中文（简体）
         */
        String TYPE_CN = "zh-CN";
        /**
         * 中文（台湾）
         */
        String TYPE_TW = "zh-TW";
        /**
         * 中文（香港）
         */
        String TYPE_HK = "zh-HK";
        /**
         * 英文（美国）
         */
        String TYPE_US = "en-us";
    }

    /**
     * 帐号类型
     */
    interface AccountType {
        /**
         * 手机号
         */
        int TYPE_PHONE = 1;
        /**
         * 邮箱
         */
        int TYPE_MAIL = 2;
        /**
         * 自定义名称
         */
        int TYPE_CUSTOMIZE_NAME = 3;

        /**
         * 主帐号
         */
        int MAIN_ACCOUNT = 1;
        /**
         * 子帐号
         */
        int SON_ACCOUNT = 2;
    }

    /**
     * 操作系统类型
     */
    public interface OsType {
        /**
         * Android手机
         */
        int TYPE_ANDROID_PHONE = 1;
        /**
         * Android pad
         */
        int TYPE_ANDROID_PAD = 2;
        /**
         * IPhone手机
         */
        int TYPE_IPHONE = 3;
        /**
         * IPAD
         */
        int TYPE_IPAD = 4;
        /**
         * 微信公众号
         */
        int TYPE_WECHAT = 5;
    }
}