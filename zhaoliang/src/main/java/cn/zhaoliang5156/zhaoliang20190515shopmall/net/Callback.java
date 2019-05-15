package cn.zhaoliang5156.zhaoliang20190515shopmall.net;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 11:21 AM
 * Description:
 * 网络回调
 */
public interface Callback {

    void onSuccess(String result);

    void onError(String msg);
}
