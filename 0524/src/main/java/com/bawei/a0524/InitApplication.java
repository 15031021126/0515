package com.bawei.a0524;

import android.app.Application;

/*
 *@Auther:陈浩
 *@Date: 2019/5/24
 *@Time:15:08
 *@Description:${DESCRIPTION}
 * */public class InitApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AppUncaughtExceptionHandler handler = AppUncaughtExceptionHandler.getInstance(this);
        Thread.setDefaultUncaughtExceptionHandler(handler);
    }
}
