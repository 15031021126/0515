package cn.zhaoliang5156.zhaoliang20190515shopmall.holder.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.stx.xhb.xbanner.XBanner;

import cn.zhaoliang5156.zhaoliang20190515shopmall.R;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 3:05 PM
 * Description:
 * 轮播的ViewHolder
 */
public class BannerHolder extends RecyclerView.ViewHolder {

    public XBanner banner;

    public BannerHolder(View itemView) {
        super(itemView);

        banner = itemView.findViewById(R.id.xbanner);
    }
}
