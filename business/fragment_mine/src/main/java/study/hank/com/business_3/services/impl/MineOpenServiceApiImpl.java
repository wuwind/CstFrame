package study.hank.com.business_3.services.impl;

import android.content.Context;
import android.widget.Toast;

import com.wuwind.common.RouterPathConst;
import com.wuwind.zrouter_annotation.ZRoute;

import study.hank.com.business_3.services.api.MineOpenServiceApi;

@ZRoute(RouterPathConst.PATH_PROVIDER_MINE) // 数据交互的Provider，必须用接口SimpleName来注册
public class MineOpenServiceApiImpl implements MineOpenServiceApi {
    private Context mContext;

    @Override
    public String accountNo() {
        return "accountNo,hank zhou!";
    }

    @Override
    public void showAccountNo() {
        Toast.makeText(mContext, accountNo(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        mContext = context;
    }
}
