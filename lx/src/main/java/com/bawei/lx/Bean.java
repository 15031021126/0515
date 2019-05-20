package com.bawei.lx;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

/*
 *@Auther:陈浩
 *@Date: 2019/5/17
 *@Time:22:05
 *@Description:${DESCRIPTION}
 * */public class Bean  extends SimpleBannerInfo {
     private String commodityName;
     private String masterPic;

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getMasterPic() {
        return masterPic;
    }

    public void setMasterPic(String masterPic) {
        this.masterPic = masterPic;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "commodityName='" + commodityName + '\'' +
                ", masterPic='" + masterPic + '\'' +
                '}';
    }

    public Bean() {
    }

    public Bean(String commodityName, String masterPic) {
        this.commodityName = commodityName;
        this.masterPic = masterPic;
    }

    @Override
    public String getXBannerUrl() {
        return masterPic;
    }
}
