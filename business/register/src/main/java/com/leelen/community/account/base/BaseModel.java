package com.leelen.community.account.base;


import com.leelen.community.account.http.HttpOperator;
import com.leelen.community.account.http.OperatorFactory;

/**
 * @description:
 * @copyright: Copyright (c) 2019 厦门立林科技有限公司
 * @author: cwx
 * @date: 2019/4/27
 * @version: 1.00
 * @history:
 */
public class BaseModel {
    protected HttpOperator mHttpOperator;

    public BaseModel() {
        mHttpOperator = OperatorFactory.getInstance().getHttpOperator();
    }
}
