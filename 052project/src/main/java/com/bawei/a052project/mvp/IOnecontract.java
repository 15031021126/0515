package com.bawei.a052project.mvp;

import com.android.volley.toolbox.StringRequest;
import com.bawei.a052project.net.CallBackStr;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:16:30
 *@Description:${DESCRIPTION}
 * */public interface IOnecontract {
    interface IOneView {
        void showData(String result);
    }

    interface IOneModel {
        void getData(String url, CallBackStr callBackStr);
    }

    interface IOnePersenter {
        void attach(IOneView view);

        void dettach();

        void RequestData(String url);
    }
}
