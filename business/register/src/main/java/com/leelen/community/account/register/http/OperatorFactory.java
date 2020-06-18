package com.leelen.community.account.register.http;


import com.leelen.community.account.register.base.CommunityApplication;

/**
 * @description: 操作工厂类
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/22
 * @version: 1.00
 * @history:
 */
public class OperatorFactory {
    private HttpOperator mHttpOperator;

    private OperatorFactory() {
    }

    private static class SingleTonHolder {
        private static OperatorFactory INSTANCE = new OperatorFactory();
    }

    public static OperatorFactory getInstance() {
        return OperatorFactory.SingleTonHolder.INSTANCE;
    }

    public HttpOperator getHttpOperator() {
        if (mHttpOperator == null) {
            mHttpOperator = new HttpOperatorImpl(CommunityApplication.getAppContext());
        }
        return mHttpOperator;
    }

    public void refreshHttpOperator() {
        mHttpOperator = new HttpOperatorImpl(CommunityApplication.getAppContext());
    }
}
