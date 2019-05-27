package com.bawei.a052project.mvp;

import com.bawei.a052project.net.CallBackStr;
import com.bawei.a052project.net.HttpUntil;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:16:32
 *@Description:${DESCRIPTION}
 * */public class OneModelImpl implements IOnecontract.IOneModel {

    private HttpUntil until;

    @Override
    public void getData(String url, CallBackStr callBackStr) {
        until = new HttpUntil();
        until.doGetStr(url,callBackStr);
    }
}
