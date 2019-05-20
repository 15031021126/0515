package com.bawei.chenhao0520.mvp;

import com.bawei.chenhao0520.net.CallBackStr;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:9:10
 *@Description:${契约接口}
 * */public interface IoneContract {
    interface IoneView {
        void showData(String url);
    }

    interface IoneModel {
        void doGetData(String url, CallBackStr callBackStr);
    }

    interface IonePersenter {
        void attach(IoneView view);

        void dettach();

        void requestData(String url);
    }
}
