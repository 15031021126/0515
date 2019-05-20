package com.bawei.lxxx.net;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.lxxx.MyAppliction;

import java.util.HashMap;
import java.util.Map;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class HttpUntil {

    private HttpUntil until;

    public HttpUntil() {
    }

    private HttpUntil getUntil() {
        if (until != null) {
            until = new HttpUntil();
        }
        return until;
    }


    public void doPostStr(String url, final String phone, final String pwd, final CallBackStr backStr) {


        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                backStr.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                backStr.err();
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

    public void doGetStr(String url, final CallBackStr backStr) {

        StringRequest request2 = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                backStr.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                backStr.err();
            }
        });
        request2.setTag("get");
        MyAppliction.getQueue().add(request2);
    }


}
