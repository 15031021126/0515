package com.bawei.loginandzc.showmvp;

import com.bawei.loginandzc.net.CallBackStr;
import com.bawei.loginandzc.net.HttpUntil;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class OneModelImpl implements IshowMvp.oneModel {

    private HttpUntil until;

    @Override
    public void doGetString(String url, CallBackStr callBackStr) {
        until = new HttpUntil();
        until.doGetStr(url,callBackStr);
    }
}
