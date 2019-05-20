package com.bawei.chenhao0520.net;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:8:52
 *@Description:${DESCRIPTION}
 * */public class MyApplication extends Application {
    public static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());
    }

    public RequestQueue getQueue() {
        return queue;
    }
}
