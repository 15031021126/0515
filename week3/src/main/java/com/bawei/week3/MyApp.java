package com.bawei.week3;

import android.app.Application;
import android.database.DefaultDatabaseErrorHandler;

/*
 *@Auther:陈浩
 *@Date: 2019/5/26
 *@Time:19:53
 *@Description:${DESCRIPTION}
 * */public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MyErrIO io = new MyErrIO(MyApp.this);
       Thread.setDefaultUncaughtExceptionHandler(io);
    }
}
