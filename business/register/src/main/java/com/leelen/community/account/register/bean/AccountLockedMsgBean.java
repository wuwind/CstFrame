package com.leelen.community.account.register.bean;

/**
 * @description: 帐号被锁定消息类
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/25
 * @version: 1.00
 * @history:
 */
public class AccountLockedMsgBean {
    /**
     * 解锁时间，单位秒
     */
    private long time;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
