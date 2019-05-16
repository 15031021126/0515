package com.bawei.lx.bean;


import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class BannerBean extends SimpleBannerInfo {

    public String imageUrl;

    public BannerBean(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String getXBannerUrl() {
        return imageUrl;
    }

}
