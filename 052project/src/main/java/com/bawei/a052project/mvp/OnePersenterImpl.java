package com.bawei.a052project.mvp;

import com.bawei.a052project.net.CallBackStr;
import com.bawei.a052project.net.HttpUntil;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:16:35
 *@Description:${DESCRIPTION}
 * */public class OnePersenterImpl implements IOnecontract.IOnePersenter {
    private IOnecontract.IOneView view;
    private OneModelImpl model;
    private HttpUntil until;

    @Override
    public void attach(IOnecontract.IOneView view) {
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
    public void RequestData(String url) {
        until = new HttpUntil();
        until.doGetStr(url, new CallBackStr() {
            @Override
            public void succes(String result) {
                view.showData(result);
            }
        });
    }
}
