package com.bawei.lx.net;

/*
 *@Auther:陈浩
 *@Date: 2019/5/17
 *@Time:21:13
 *@Description:${DESCRIPTION}
 * */

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.lx.MyAppliaction;

import java.util.HashMap;
import java.util.Map;

public class HttpUntil {

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
        MyAppliaction.getQueue().add(request);
    }

    public void doPostStr(String url, final String phone, final String pwd, final CallBackStr callBackStr) {
        StringRequest request2 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBackStr.success(response);
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
        request2.setTag("post");
        MyAppliaction.getQueue().add(request2);
    }

}
