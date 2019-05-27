package com.bawei.lx527.dlmvp;

import com.bawei.lx527.net.CallBackStr;
import com.bawei.lx527.net.HttpUntil;

/*
 *@Auther:陈浩
 *@Date: 2019/5/27
 *@Time:20:02
 *@Description:${DESCRIPTION}
 * */public class OneModelImpl implements Ionecontract.IoneMolde {
    private HttpUntil until;
    @Override
    public void doGetDl(String url, String phone, String pwd, CallBackStr callBackStr) {
        until = new HttpUntil();
        until.dopostStr(url, phone, pwd, callBackStr);
    }

    @Override
    public void doGetZc(String url, String phone, String pwd, CallBackStr callBackStr) {
        until = new HttpUntil();
        until.dopostStr(url, phone, pwd, callBackStr);
    }
}
