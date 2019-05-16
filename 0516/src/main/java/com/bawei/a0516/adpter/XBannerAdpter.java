package com.bawei.a0516.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.a0516.R;
import com.bawei.a0516.bean.Bean;
import com.bawei.a0516.bean.XbannerBean;
import com.bawei.a0516.holder.BannerHolder;
import com.bawei.a0516.holder.OneHolder;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class XBannerAdpter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<XbannerBean> list;
    private ArrayList<Bean> beans;

    public XBannerAdpter(Context context, ArrayList<XbannerBean> list, ArrayList<Bean> beans) {
        this.context = context;
        this.list = list;
        this.beans = beans;
    }

    @NonNull
    @Override
    public BannerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        switch (getItemViewType(i)) {
            case 0:
                return new BannerHolder(inflater.inflate(R.layout.xbanner, viewGroup, false));
            case 1:
                return new BannerHolder(inflater.inflate(R.layout.one,viewGroup,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case 0:
                ((BannerHolder) viewHolder).xBanner.setBannerData(list);
                ((BannerHolder) viewHolder).xBanner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        String s = ((XbannerBean) model).getXBannerUrl();
                        Glide.with(context).load(s).into((ImageView) view);
                        Log.e("123", "loadBanner: " + s);
                    }
                });
                break;
            case 1:
                break;
        }
    }


    @Override
    public int getItemCount() {
        if (list != null) {
            return 2;
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }
}
