package com.bawei.chenhao0527.excpotion;

import android.app.Application;

/*
 *@Auther:陈浩
 *@Date: 2019/5/27
 *@Time:8:56
 *@Description:${异常处理}
 * */public class MyApplication extends Application {

    private MyExcetion excetion;

    @Override
    public void onCreate() {
        super.onCreate();
        excetion = new MyExcetion(MyApplication.this);
        Thread.setDefaultUncaughtExceptionHandler(excetion);
    }
}
