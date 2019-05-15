package com.bawei.lxx.mvp;

import com.android.volley.toolbox.StringRequest;
import com.bawei.lxx.HttpUntil;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public interface IhomeContract {

    public interface IhomeView {
        void showList(String result);
    }

    public interface IhomeModel {
        void getString(String url, HttpUntil.callBackStr backStr);
    }

    public interface IhomePresenter {
        void attach(IhomeView view);

        void detach();

        void requestList(String url);
    }
}
