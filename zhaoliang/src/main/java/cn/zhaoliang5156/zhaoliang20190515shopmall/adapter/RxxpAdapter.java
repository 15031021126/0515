package cn.zhaoliang5156.zhaoliang20190515shopmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import cn.zhaoliang5156.zhaoliang20190515shopmall.R;
import cn.zhaoliang5156.zhaoliang20190515shopmall.bean.HomeList;
import cn.zhaoliang5156.zhaoliang20190515shopmall.holder.home.RxxpItemHolder;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 4:17 PM
 * Description:
 */
public class RxxpAdapter extends RecyclerView.Adapter<RxxpItemHolder> {

    private Context context;
    private List<HomeList.Commodity> rxxpList;

    public RxxpAdapter(Context context, List<HomeList.Commodity> rxxpList) {
        this.context = context;
        this.rxxpList = rxxpList;
    }

    @NonNull
    @Override
    public RxxpItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new RxxpItemHolder(inflater.inflate(R.layout.rxxp_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RxxpItemHolder holder, int position) {
        HomeList.Commodity commodity = rxxpList.get(position);
        holder.tvName.setText(commodity.commodityName);
        holder.tvPrice.setText(String.valueOf(commodity.price));
        Glide.with(context).load(commodity.masterPic).into(holder.icon);
    }

    @Override
    public int getItemCount() {
        return rxxpList.size();
    }
}
