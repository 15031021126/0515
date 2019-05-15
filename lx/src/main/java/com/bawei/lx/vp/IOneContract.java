package com.bawei.lx.vp;

import com.bawei.lx.vp.CallBackStr;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public interface IOneContract {
    interface oneView {
        void showData(String result);
    }

    interface oneModel {
        void doDataStr(String url, CallBackStr backStr);
    }

    interface onePersenter {
        void attach(oneView view);

        void dettach();

        void request(String url);
    }
}
