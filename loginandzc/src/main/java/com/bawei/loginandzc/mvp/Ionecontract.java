package com.bawei.loginandzc.mvp;

import android.content.Context;

import com.bawei.loginandzc.net.CallBackStr;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public interface Ionecontract {
    interface iOneView {
        void getData(String data);
    }

    interface iOneModel {
        void dl(String url, String phone, String pwd, CallBackStr callBackStr);

        void zc(String url, String phone, String pwd, CallBackStr callBackStr);
    }

    interface iOnePersenter {
        void attach(iOneView view);

        void detach();

        void requestLogin(Context context, String url, String phone, String pwd);

        void reauestZc(Context context, String url, String phone, String pwd);
    }

}
