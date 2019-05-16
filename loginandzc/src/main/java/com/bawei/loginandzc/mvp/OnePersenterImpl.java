package com.bawei.loginandzc.mvp;

import android.content.Context;

import com.bawei.loginandzc.net.CallBackStr;
import com.bawei.loginandzc.net.HttpUntil;

import java.util.HashMap;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class OnePersenterImpl implements Ionecontract.iOnePersenter {
    private Ionecontract.iOneView view;
    private OneModelImmpl mode;
    private HttpUntil until;

    @Override
    public void attach(Ionecontract.iOneView view) {
        this.view = view;
        mode = new OneModelImmpl();
    }

    @Override
    public void detach() {
        if (view != null) {
            view = null;
        }
        if (mode != null) {
            mode = null;
        }
    }

    @Override
    public void requestLogin(Context context, String url, String phone, String pwd) {
        until = new HttpUntil();
        until.doPostStr(url, phone, pwd, new CallBackStr() {
            @Override
            public void success(String result) {
                view.getData(result);
            }

            @Override
            public void err() {

            }
        });
    }

    @Override
    public void reauestZc(Context context, String url, String phone, String pwd) {
        until = new HttpUntil();
        until.doPostStr(url, phone, pwd, new CallBackStr() {
            @Override
            public void success(String result) {
                view.getData(result);
            }

            @Override
            public void err() {

            }
        });
    }
}
