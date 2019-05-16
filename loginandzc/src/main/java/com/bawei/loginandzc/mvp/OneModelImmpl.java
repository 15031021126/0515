package com.bawei.loginandzc.mvp;

import com.bawei.loginandzc.net.CallBackStr;
import com.bawei.loginandzc.net.HttpUntil;

import java.util.HashMap;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class OneModelImmpl implements Ionecontract.iOneModel {

    private HttpUntil until;
    private HashMap<String, String> map;


    @Override
    public void dl(String url, String phone, String pwd, final CallBackStr callBackStr) {
        until = new HttpUntil();
        until.doPostStr(url, phone, pwd, callBackStr);
    }

    @Override
    public void zc(String url, String phone, String pwd, CallBackStr callBackStr) {
        until = new HttpUntil();
        until.doPostStr(url, phone, pwd, callBackStr);
    }
}
