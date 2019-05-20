package com.bawei.chenhao0520.bean;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:9:28
 *@Description:${DESCRIPTION}
 * */public class Bean {
     private String commodityId;
     private String commodityName;
     private String masterPic;

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

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
                "commodityId='" + commodityId + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", masterPic='" + masterPic + '\'' +
                '}';
    }

    public Bean() {
    }

    public Bean(String commodityId, String commodityName, String masterPic) {
        this.commodityId = commodityId;
        this.commodityName = commodityName;
        this.masterPic = masterPic;
    }
}
