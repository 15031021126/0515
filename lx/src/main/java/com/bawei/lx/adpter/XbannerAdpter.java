package com.bawei.lx.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.lx.Bean;
import com.bawei.lx.R;
import com.bawei.lx.holder.XabnnerHolder;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/5/18
 *@Time:10:43
 *@Description:${DESCRIPTION}
 * */public class XbannerAdpter extends RecyclerView.Adapter<XabnnerHolder> {
    private ArrayList<Bean> beans;
    private Context context;

    public XbannerAdpter(ArrayList<Bean> beans, Context context) {
        this.beans = beans;
        this.context = context;
    }

    @NonNull
    @Override
    public XabnnerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new XabnnerHolder(inflater.inflate(R.layout.xbannerlayout, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull XabnnerHolder xabnnerHolder, int i) {
        xabnnerHolder.xBanner.setBannerData(beans);
        xabnnerHolder.xBanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Bean o = (Bean) model;
                String s = o.getMasterPic();
                Glide.with(context).load(s).into((ImageView) view);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
