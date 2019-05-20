package com.bawei.lx.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.lx.R;
import com.stx.xhb.xbanner.XBanner;

/*
 *@Auther:陈浩
 *@Date: 2019/5/18
 *@Time:10:43
 *@Description:${DESCRIPTION}
 * */public class XabnnerHolder extends RecyclerView.ViewHolder {

    public  XBanner xBanner;

    public XabnnerHolder(@NonNull View itemView) {
        super(itemView);
        xBanner = itemView.findViewById(R.id.xbanner);
    }
}
