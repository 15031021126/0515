package com.bawei.a052project.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.a052project.R;
import com.stx.xhb.xbanner.XBanner;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:19:16
 *@Description:${DESCRIPTION}
 * */public class XbannerHolder extends RecyclerView.ViewHolder {

    public XBanner xBanner;

    public XbannerHolder(@NonNull View itemView) {
        super(itemView);
        xBanner = itemView.findViewById(R.id.xbanner);
    }
}
