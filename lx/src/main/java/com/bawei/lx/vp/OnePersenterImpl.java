package com.bawei.lx.vp;

import com.bawei.lx.HttpUntil;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class OnePersenterImpl implements IOneContract.onePersenter {
    private IOneContract.oneView view;
    private OneModelImpl model;
    private HttpUntil until;

    @Override
    public void attach(IOneContract.oneView view) {
        this.view = view;
        model = new OneModelImpl();
    }

    @Override
    public void dettach() {
        if (view != null) {
            view = null;
        }
        if (model != null) {
            model = null;
        }

    }

    @Override
    public void request(String url) {
        until = new HttpUntil();
        until.doGetData(url, new CallBackStr() {
            @Override
            public void success(String result) {
                view.showData(result);
            }

            @Override
            public void err() {

            }
        });
    }
}
