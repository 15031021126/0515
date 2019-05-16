package com.bawei.a0516.mvp;

import com.bawei.a0516.HttpUntil;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public interface Icontract {
    interface IsView {
        void showData(String result);
    }

    interface IsModel {
        void doGetStrs(String url, HttpUntil.callBackStr callBackStr);
    }

    interface IsPersenter {
       void attach(IsView view);
       void dettach();
       void requestData(String url);
    }
}
