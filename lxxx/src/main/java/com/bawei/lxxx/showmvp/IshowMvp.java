package com.bawei.lxxx.showmvp;


import com.bawei.lxxx.net.CallBackStr;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public interface IshowMvp {
    interface oneView {
        void showData(String result);
    }

    interface oneModel {
        void doGetString(String url, CallBackStr callBackStr);
    }

    interface onePersenter {
        void attach(oneView view);

        void dettach();

        void requestData(String url);
    }
}
