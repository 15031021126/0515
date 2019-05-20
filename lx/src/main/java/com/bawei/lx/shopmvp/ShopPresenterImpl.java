package com.bawei.lx.shopmvp;

import com.bawei.lx.net.CallBackStr;
import com.bawei.lx.net.HttpUntil;

/*
 *@Auther:陈浩
 *@Date: 2019/5/17
 *@Time:21:27
 *@Description:${DESCRIPTION}
 * */public class ShopPresenterImpl implements IShopContract.shopPersenter {
    private IShopContract.shopView view;
    private ShopModelImpl model;
    private HttpUntil until;

    @Override
    public void attach(IShopContract.shopView view) {
        model = new ShopModelImpl();
        this.view = view;
    }

    @Override
    public void dettach() {
        if (model != null) {
            model = null;
        }
        if (view != null) {
            view = null;
        }
    }

    @Override
    public void requestData(String url) {
        until = new HttpUntil();
        until.doGetStr(url, new CallBackStr() {
            @Override
            public void success(String result) {
                view.showData(result);
            }
        });
    }
}
