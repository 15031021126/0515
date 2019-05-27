package com.bawei.lx527.dlmvp;

import android.content.Context;
import android.widget.ImageView;

import com.bawei.lx527.net.CallBackStr;
import com.bawei.lx527.net.HttpUntil;

import java.util.HashMap;

/*
 *@Auther:陈浩
 *@Date: 2019/5/27
 *@Time:20:05
 *@Description:${DESCRIPTION}
 * */public class OnePresenterImpl implements Ionecontract.IOnePresenter {
    private Ionecontract.IOneView view;
    private OneModelImpl model;
    private HttpUntil until1;


    @Override
    public void attach(Ionecontract.IOneView view) {
        this.view = view;
        model = new OneModelImpl();
    }

    @Override
    public void dettach() {
        if (view != null) {
            view = null;
        }
        if (model != null) {
            model = null;
        }
    }

    @Override
    public void requestDL(Context context, String url, String phone, String pwd) {
        until1 = new HttpUntil();
        until1.dopostStr(url, phone, pwd, new CallBackStr() {
            @Override
            public void success(String result) {
                view.showData(result);
            }
        });

    }

    @Override
    public void requestZC(Context context, String url, String phone, String pwd) {

        until1 = new HttpUntil();
        until1.dopostStr(url, phone, pwd, new CallBackStr() {
            @Override
            public void success(String result) {
                view.showData(result);
            }
        });

    }


}
