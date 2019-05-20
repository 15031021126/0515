package com.bawei.loginandzc.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.loginandzc.R;
import com.bawei.loginandzc.bean.XbannerBean;
import com.bawei.loginandzc.holder.One1;
import com.bawei.loginandzc.holder.OneHolder;
import com.bawei.loginandzc.holder.XbannerHolder;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;


public class XbannerAdpter extends RecyclerView.Adapter {
    private ArrayList<XbannerBean> list;
    private Context context;
    private ArrayList<String> bens;

    public XbannerAdpter(ArrayList<XbannerBean> list, Context context, ArrayList<String> bens) {
        this.list = list;
        this.context = context;
        this.bens = bens;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        switch (getItemViewType(i)) {
            case 0:
                return new XbannerHolder(inflater.inflate(R.layout.xbannerlayout, viewGroup, false));
            case 1:
                return new One1(inflater.inflate(R.layout.one1, viewGroup, false));
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
                        Glide.with(context).load(((XbannerBean) model).getXBannerUrl()).into((ImageView) view);
                    }
                });
                break;
            case 1:
                ((One1) viewHolder).recy2.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
                ((One1) viewHolder).recy2.setAdapter(new OneAdpter(bens, context));
                break;
        }
    }


    @Override
    public int getItemCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

}
