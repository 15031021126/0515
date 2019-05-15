package cn.zhaoliang5156.zhaoliang20190515shopmall.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

import java.util.List;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 3:15 PM
 * Description:
 * 首页轮播Bean
 */
public class HomeBanner {

    public String message;
    public String status;
    public List<BannerItem> result;

    public static class BannerItem extends SimpleBannerInfo {
        public String imageUrl;
        public String jumpUrl;
        public int rank;
        public String title;

        @Override
        public String getXBannerUrl() {
            return imageUrl;
        }
    }
}
