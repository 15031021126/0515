package com.bawei.lxx.mvp;

import com.bawei.lxx.HttpUntil;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class HomeModelImpl implements IhomeContract.IhomeModel {

    private HttpUntil until;

    @Override
    public void getString(String url, HttpUntil.callBackStr backStr) {
        until = new HttpUntil();
        until.AsyStr(url,backStr);
    }
}
