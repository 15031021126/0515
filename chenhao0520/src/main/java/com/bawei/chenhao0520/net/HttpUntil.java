package com.bawei.chenhao0520.net;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:8:51
 *@Description:${网络请求}
 * */public class HttpUntil {

    private HttpUntil until;

    public HttpUntil() {
    }

    public HttpUntil getUntil() {
        if (until == null) {
            until = new HttpUntil();
        }
        return until;
    }

    public void doGetStr(String url, final CallBackStr callBackStr) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBackStr.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.setTag("get");
        MyApplication.queue.add(request);
    }
//判断网络
    public boolean isNet(Context context){
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if(info!=null){
            return info.isAvailable();
        }
        return false;
    }

}
