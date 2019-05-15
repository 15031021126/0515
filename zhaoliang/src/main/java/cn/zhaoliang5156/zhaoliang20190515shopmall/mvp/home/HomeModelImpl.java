package cn.zhaoliang5156.zhaoliang20190515shopmall.mvp.home;

import cn.zhaoliang5156.zhaoliang20190515shopmall.net.Callback;
import cn.zhaoliang5156.zhaoliang20190515shopmall.net.HttpUtil;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 11:39 AM
 * Description:
 */
public class HomeModelImpl implements IHomeContract.IHomeModel {

    private HttpUtil util;

    public HomeModelImpl() {
        util = HttpUtil.getInstance();
    }

    @Override
    public void doHttpGet(String url, Callback callback) {
        util.doVolleyGet(url, callback);
    }
}
