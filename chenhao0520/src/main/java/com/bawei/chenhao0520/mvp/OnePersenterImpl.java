package com.bawei.chenhao0520.mvp;

import com.bawei.chenhao0520.net.CallBackStr;
import com.bawei.chenhao0520.net.HttpUntil;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:9:12
 *@Description:${DESCRIPTION}
 * */public class OnePersenterImpl implements IoneContract.IonePersenter {
    private IoneContract.IoneView view;
    private OneModelImpl model;
    private HttpUntil until1;

    @Override
    public void attach(IoneContract.IoneView view) {
        model = new OneModelImpl();
        this.view = view;
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
    public void requestData(String url) {
        until1 = new HttpUntil();
        until1.doGetStr(url, new CallBackStr() {
            @Override
            public void success(String result) {
                view.showData(result);
            }
        });
    }


}
