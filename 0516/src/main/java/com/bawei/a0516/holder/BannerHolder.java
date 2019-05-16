package com.bawei.a0516.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.a0516.R;
import com.stx.xhb.xbanner.XBanner;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class BannerHolder extends RecyclerView.ViewHolder {

    public  XBanner xBanner;

    public BannerHolder(@NonNull View itemView) {
        super(itemView);
        xBanner = itemView.findViewById(R.id.xbanner);
    }
}
