package com.leelen.community.account.register.base;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.leelen.common.manager.CommonManager;
import com.leelen.community.account.register.model.SharePreferenceModel;
import com.wuwind.common.IComponentApplication;
import com.wuwind.zrouter_api.ZRouter;

/**
 * Created by wuhf on 2020/6/17.
 * Description ：
 */
public class CommunityApplication extends Application implements IComponentApplication {

    public static Application mApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
    }

    public static Context getAppContext() {
        return mApplication.getApplicationContext();
    }

    @Override
    public void init(Application application) {
        Log.e("CommunityApplication","CommunityApplication-------");
        mApplication = application;
        CommonManager.getInstance().init(application);
        SharePreferenceModel.init(application);
        ZRouter.init(application);
    }
}
