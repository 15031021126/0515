package com.bawei.lxx;

import android.util.Log;

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

    public void AsyStr(String uu, final callBackStr backStr) {
        StringRequest request = new StringRequest(Request.Method.GET, uu, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                backStr.success(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("123", "onErrorResponse: " + "失败");
            }
        });
        request.setTag("get");
        MyApplication.queue.add(request);
    }

}
