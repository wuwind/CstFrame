package com.wuwind.business_3.services.impl;

import android.content.Context;
import android.widget.Toast;

import com.wuwind.common.RouterPathConst;
import com.wuwind.zrouter_annotation.ZRoute;

import com.wuwind.business_3.services.api.MineOpenServiceApi;

@ZRoute(RouterPathConst.PATH_PROVIDER_MINE) // 数据交互的Provider，必须用接口SimpleName来注册
public class MineOpenServiceApiImpl implements MineOpenServiceApi<Context> {
    @Override
    public String accountNo() {
        Toast.makeText(mContext, "234", Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public void showAccountNo() {

    }

    private Context mContext;

    @Override
    public void init(Context mContext) {
        this.mContext = mContext;
    }
}
