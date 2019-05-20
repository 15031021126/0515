package com.bawei.lxxx.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.lxxx.R;
import com.stx.xhb.xbanner.XBanner;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:20:00
 *@Description:${DESCRIPTION}
 * */public class XbannerHolder extends RecyclerView.ViewHolder {

    public  XBanner xbanner;

    public XbannerHolder(@NonNull View itemView) {
            super(itemView);
        xbanner = itemView.findViewById(R.id.xbanner);
    }
}
