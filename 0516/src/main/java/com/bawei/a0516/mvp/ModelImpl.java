package com.bawei.a0516.mvp;

import com.bawei.a0516.HttpUntil;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class ModelImpl implements Icontract.IsModel {

    private HttpUntil until;

    @Override
    public void doGetStrs(String url, HttpUntil.callBackStr callBackStr) {
        until = new HttpUntil();
        until.doGetStr(url, callBackStr);
    }
}
