package cn.zhaoliang5156.zhaoliang20190515shopmall;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 11:20 AM
 * Description: 自定义Application
 */
public class MyApplication extends Application {

    private static RequestQueue queue;  // 请求队列

    @Override
    public void onCreate() {
        super.onCreate();

        queue = Volley.newRequestQueue(getApplicationContext());
    }

    public static RequestQueue getQueue() {
        return queue;
    }
}
