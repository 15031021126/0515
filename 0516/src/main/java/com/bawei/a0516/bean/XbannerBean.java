package com.bawei.a0516.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class XbannerBean extends SimpleBannerInfo {

    public XbannerBean() {
    }

    public  String imageUrl;

    @Override
    public String toString() {
        return "XbannerBean{" +
                "imageUrl='" + imageUrl + '\'' +
                '}';
    }

    public XbannerBean(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String getXBannerUrl() {
        return imageUrl;
    }
}
