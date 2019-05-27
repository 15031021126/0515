package com.bawei.a052project;

import android.app.Application;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.a052project.net.CallBackStr;

import java.util.HashMap;
import java.util.Map;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:16:20
 *@Description:${DESCRIPTION}
 * */public class MyAppliction extends Application {
    public static RequestQueue queue;

    @Override
    public void onCreate() {
        super.onCreate();
        queue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getQueue() {
        return queue;
    }


}
