package com.bawei.lx.shopmvp;

import com.bawei.lx.net.CallBackStr;
import com.bawei.lx.net.HttpUntil;

/*
 *@Auther:陈浩
 *@Date: 2019/5/17
 *@Time:21:27
 *@Description:${DESCRIPTION}
 * */public class ShopModelImpl implements IShopContract.shopModel {

    private HttpUntil until;

    @Override
    public void doGetData(String url, CallBackStr callBackStr) {
        until = new HttpUntil();
        until.doGetStr(url,callBackStr);
    }
}
