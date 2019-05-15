package com.bawei.lx.vp;

import com.bawei.lx.HttpUntil;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class OneModelImpl implements IOneContract.oneModel {

    private HttpUntil until;

    @Override
    public void doDataStr(String url, CallBackStr backStr) {
        until = new HttpUntil();
        until.doGetData(url, backStr);
    }
}
