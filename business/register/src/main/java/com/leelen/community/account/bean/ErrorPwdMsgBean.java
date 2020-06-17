package com.leelen.community.account.bean;

/**
 * @description: 密码错误提示消息类
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/25
 * @version: 1.00
 * @history:
 */
public class ErrorPwdMsgBean {
    /**
     * 帐号登录密码错误，剩余x次
     */
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
