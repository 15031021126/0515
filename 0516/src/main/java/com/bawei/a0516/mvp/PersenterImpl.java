package com.bawei.a0516.mvp;

import com.bawei.a0516.HttpUntil;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class PersenterImpl implements Icontract.IsPersenter {
    private Icontract.IsView view;
    private ModelImpl model;
    private HttpUntil until;

    @Override
    public void attach(Icontract.IsView view) {
        this.view = view;
        model = new ModelImpl();
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
        until = new HttpUntil();
        until.doGetStr(url, new HttpUntil.callBackStr() {
            @Override
            public void success(String result) {
                view.showData(result);
            }
        });
    }
}
