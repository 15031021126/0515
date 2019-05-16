package com.bawei.a0516;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
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

    public interface callBackStr {
        void success(String result);
    }

    public void doGetStr(String url, final callBackStr backStr) {
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                backStr.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.setTag("get");
        MyApplication.getQueue().add(request);
    }
}
