package com.bawei.lxxx.showmvp;

import com.bawei.lxxx.net.CallBackStr;
import com.bawei.lxxx.net.HttpUntil;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class OnePreenterImpl implements IshowMvp.onePersenter {
    private IshowMvp.oneView view;
    private OneModelImpl model;
    private HttpUntil until;

    @Override
    public void attach(IshowMvp.oneView view) {
        model = new OneModelImpl();
        this.view=view;
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
    public void requestData(String url) {
        until = new HttpUntil();
        until.doGetStr(url, new CallBackStr() {
            @Override
            public void success(String result) {
                view.showData(result);
            }

            @Override
            public void err() {

            }
        });
    }
}
