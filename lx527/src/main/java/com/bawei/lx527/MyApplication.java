package com.bawei.lx527;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/*
 *@Auther:陈浩
 *@Date: 2019/5/27
 *@Time:19:39
 *@Description:${DESCRIPTION}
 * */public class MyApplication extends Application {
    private static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(MyApplication.this);
    }

    public static RequestQueue getQueue() {
        return queue;
    }

}
