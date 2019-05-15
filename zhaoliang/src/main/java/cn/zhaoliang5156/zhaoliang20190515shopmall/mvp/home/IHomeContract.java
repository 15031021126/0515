package cn.zhaoliang5156.zhaoliang20190515shopmall.mvp.home;

import cn.zhaoliang5156.zhaoliang20190515shopmall.net.Callback;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 11:29 AM
 * Description:
 * home MVP
 */
public interface IHomeContract {

    interface IHomeView {

        void showBanner(String data);

        void showList(String data);
    }

    interface IHomeModel {

        void doHttpGet(String url, Callback callback);
    }

    interface IHomePresenter {

        // 绑定和解绑
        void attach(IHomeView view);

        void detach();

        void getBanner(String url);

        void getList(String url);
    }
}
