package com.bawei.a052project.net;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.a052project.MyAppliction;

import java.util.HashMap;
import java.util.Map;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:16:18
 *@Description:${DESCRIPTION}
 * */public class HttpUntil {

    private  HttpUntil until;

    public HttpUntil() {
    }

    public  HttpUntil getUntil() {

        if (until == null) {
            until = new HttpUntil();
        }
        return until;
    }

    public void doGetStr(String url, final CallBackStr callBackStr) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBackStr.succes(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.setTag("get");
        MyAppliction.getQueue().add(request);
    }

    public void doPostStr(String url, final String phone, final String pwd, final CallBackStr callBackStr) {
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBackStr.succes(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> map = new HashMap<>();
                map.put("phone", phone);
                map.put("pwd", pwd);
                return map;
            }
        };
        request.setTag("post");
        MyAppliction.getQueue().add(request);
    }

}
