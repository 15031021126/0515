package com.bawei.lx;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.lang.ref.ReferenceQueue;

/*
 *@Auther:陈浩
 *@Date: 2019/5/17
 *@Time:21:10
 *@Description:${DESCRIPTION}
 * */public class MyAppliaction extends Application {
    private static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getQueue() {
        return queue;
    }
}
