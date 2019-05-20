package com.bawei.lx.shopmvp;

import com.bawei.lx.net.CallBackStr;

/*
 *@Auther:陈浩
 *@Date: 2019/5/17
 *@Time:21:25
 *@Description:${DESCRIPTION}
 * */public interface IShopContract {
    interface shopView {
        void showData(String result);
    }

    interface shopModel {
        void doGetData(String url, CallBackStr callBackStr);
    }

    interface shopPersenter {
        void attach(shopView view);

        void dettach();

        void requestData(String url);
    }


}
