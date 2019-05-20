package com.bawei.chenhao0520.mvp;

import com.bawei.chenhao0520.net.CallBackStr;
import com.bawei.chenhao0520.net.HttpUntil;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:9:12
 *@Description:${DESCRIPTION}
 * */public class OneModelImpl implements IoneContract.IoneModel {

    private HttpUntil until;

    @Override
    public void doGetData(String url, CallBackStr callBackStr) {
        until = new HttpUntil();
        until.doGetStr(url,callBackStr);
    }
}
