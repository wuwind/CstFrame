package com.leelen.community.account.bean;

/**
 * @description: 验证码发送频繁消息类
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/25
 * @version: 1.00
 * @history:
 */
public class VerifyCodeLimitMsgBean {
    /**
     * 条数
     */
    private int num;
    /**
     * 时间单位
     */
    private String unit;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
