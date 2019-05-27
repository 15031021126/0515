package com.bawei.lx527.dlmvp;

import android.content.Context;

import com.bawei.lx527.net.CallBackStr;

/*
 *@Auther:陈浩
 *@Date: 2019/5/27
 *@Time:19:55
 *@Description:${DESCRIPTION}
 * */public interface Ionecontract {
    interface IOneView {
        void showData(String result);
    }

    interface IoneMolde {
        void doGetDl(String url, String phone, String pwd, CallBackStr callBackStr);

        void doGetZc(String url, String phone, String pwd, CallBackStr callBackStr);
    }

    interface IOnePresenter {
        void attach(IOneView view);

        void dettach();

        void requestDL(Context context, String url, String phone, String pwd);

        void requestZC(Context context, String url, String phone, String pwd);
    }

}
