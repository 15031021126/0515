package com.bawei.lxx.mvp;

import com.bawei.lxx.HttpUntil;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class HomePersenterImpl implements IhomeContract.IhomePresenter {
    private IhomeContract.IhomeView view;
    private HomeModelImpl model;
    private HttpUntil until;

    @Override
    public void attach(IhomeContract.IhomeView view) {
        this.view = view;
        model = new HomeModelImpl();
    }

    @Override
    public void detach() {
        if (view != null) {
            view = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void requestList(String url) {
        until = new HttpUntil();
        until.AsyStr(url, new HttpUntil.callBackStr() {
            @Override
            public void success(String result) {
                view.showList(result);
            }
        });
    }
}
