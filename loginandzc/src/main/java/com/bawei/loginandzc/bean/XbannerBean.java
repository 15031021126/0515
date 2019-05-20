package com.bawei.loginandzc.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class XbannerBean extends SimpleBannerInfo {
    private String url;

    @Override
    public String toString() {
        return "XbannerBean{" +
                "url='" + url + '\'' +
                '}';
    }

    public XbannerBean(String url) {
        this.url = url;
    }

    @Override
    public String getXBannerUrl() {
        return url;
    }
}
