package com.bawei.lx;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.bawei.lx.vp.CallBackStr;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class HttpUntil {

    private HttpUntil until;

    public HttpUntil() {
    }

    public HttpUntil until() {
        if (until == null) {
            until = new HttpUntil();
        }
        return until;
    }

    public void doGetData(String url, final CallBackStr backStr) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
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
        request.setTag("get");
        MyApplication.queue.add(request);
    }

}
