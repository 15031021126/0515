package com.bawei.lx;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class MyApplication extends Application {
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
