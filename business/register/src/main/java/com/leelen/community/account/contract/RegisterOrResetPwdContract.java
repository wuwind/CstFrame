package com.leelen.community.account.contract;

import com.leelen.core.base.BaseContract;

/**
 * @description:
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/25
 * @version: 1.00
 * @history:
 */
public interface RegisterOrResetPwdContract extends BaseContract {
    interface Model {
    }

    interface View extends BaseView {
        /**
         * 获取帐号输入框的内容
         *
         * @return 用户名
         */
        String getUserName();

        /**
         * 获取密码输入框的内容
         *
         * @return 密码
         */
        String getPassword();

        /**
         * 获取验证码输入框内容
         *
         * @return 验证码
         */
        String getVerifyCode();

        /**
         * 获取验证码类型
         *
         * @return
         */
        int getVerifyCodeType();

        /**
         * 设置获取验证码控件内容，正数为倒计时数字，-1为获取内容
         *
         * @param num 倒计时数字
         */
        void setGetVerifyCodeText(int num);

        /**
         * 设置是否允许点击获取验证码
         *
         * @param enable 是否允许
         */
        void setGetCodeEnable(boolean enable);

        /**
         * 跳转到主页面
         */
        void toMainActivity();
    }

    interface Presenter extends BasePresenter<View> {
    }
}
