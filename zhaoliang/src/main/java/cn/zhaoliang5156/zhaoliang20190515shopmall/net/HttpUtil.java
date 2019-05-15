package cn.zhaoliang5156.zhaoliang20190515shopmall.net;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

import cn.zhaoliang5156.zhaoliang20190515shopmall.MyApplication;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 11:19 AM
 * Description: 网络工具类
 * 封装get和POST请求
 */
public class HttpUtil {
    private static final HttpUtil ourInstance = new HttpUtil();

    public static HttpUtil getInstance() {
        return ourInstance;
    }

    private HttpUtil() {
    }

    /**
     * Volley 封装的GET请求
     *
     * @param url
     * @param callback
     */
    public void doVolleyGet(String url, final Callback callback) {
        // 创建请求对象
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onError(error.getMessage());
                    }
                }
        );
        // 标记TAG
        request.setTag("gettag");
        // 添加到请求队列
        MyApplication.getQueue().add(request);
    }

    public void doVolleyPost(String url, final Map<String, String> param, final Callback callback) {
        StringRequest request = new StringRequest(
                Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.onSuccess(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        callback.onError(error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return param;
            }
        };

        // 标记tag
        request.setTag("posttag");
        MyApplication.getQueue().add(request);
    }
}
