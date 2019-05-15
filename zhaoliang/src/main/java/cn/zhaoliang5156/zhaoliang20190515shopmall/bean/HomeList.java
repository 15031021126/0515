package cn.zhaoliang5156.zhaoliang20190515shopmall.bean;

import java.util.List;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 3:15 PM
 * Description:
 * 首页列表的bean
 */
public class HomeList {

    public Result result;
    public String message;
    public String status;

    public static class Result {
        public Item rxxp;
        public Item pzsh;
        public Item mlss;
    }

    public static class Item {
        public List<Commodity> commodityList;
        public int id;
        public String name;
    }

    public static class Commodity {
        public int commodityId;
        public String commodityName;
        public String masterPic;
        public int price;
        public int saleNum;
    }
}
