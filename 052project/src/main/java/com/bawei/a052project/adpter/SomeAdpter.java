package com.bawei.a052project.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.a052project.R;
import com.bawei.a052project.bean.Bean;
import com.bawei.a052project.holder.Recy02Holder;
import com.bawei.a052project.holder.Recy03;
import com.bawei.a052project.holder.Recy04;
import com.bawei.a052project.holder.XbannerHolder;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:19:17
 *@Description:${DESCRIPTION}
 * */public class SomeAdpter extends RecyclerView.Adapter {
    private ArrayList<Bean> list;
    private Context context;

    public SomeAdpter(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        switch (getItemViewType(i)) {
            case 0:
                return new XbannerHolder(inflater.inflate(R.layout.xbanner, viewGroup, false));
            case 1:
                return new Recy02Holder(inflater.inflate(R.layout.recy02, viewGroup, false));
            case 2:
                return new Recy03(inflater.inflate(R.layout.recy03, viewGroup, false));
            case 3:
                return new Recy04(inflater.inflate(R.layout.recy04, viewGroup, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case 0:
                ((XbannerHolder) viewHolder).xBanner.setBannerData(list);
                ((XbannerHolder) viewHolder).xBanner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Bean model1 = (Bean) model;
                        String s = model1.getMasterPic();
                        Glide.with(context).load(s).into((ImageView) view);

                    }
                });
                break;
            case 1:
                Recy02Adpter adpter2 = new Recy02Adpter(list, context);
                ((Recy02Holder) viewHolder).recy02.setAdapter(adpter2);
                ((Recy02Holder) viewHolder).recy02.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                break;
            case 2:
                Recy03Adpter adpter3 = new Recy03Adpter(list, context);
                ((Recy03) viewHolder).recy03.setAdapter(adpter3);
                ((Recy03) viewHolder).recy03.setLayoutManager(new GridLayoutManager(context, 2));
                break;
            case 3:
                Recy04Adpter adpter4 = new Recy04Adpter(list, context);
                ((Recy04) viewHolder).recy04.setAdapter(adpter4);
                ((Recy04) viewHolder).recy04.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 4;
    }
}
