package com.bawei.lx.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.lx.Bean;
import com.bawei.lx.CallBackClick;
import com.bawei.lx.R;
import com.bawei.lx.holder.OneHolder;
import com.bawei.lx.holder.RecyHolder;
import com.bawei.lx.holder.XabnnerHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/5/17
 *@Time:22:12
 *@Description:${DESCRIPTION}
 * */public class OneAdpter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<Bean> beans;
    private CallBackClick backClick;

    public OneAdpter(Context context, ArrayList<Bean> beans) {
        this.context = context;
        this.beans = beans;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        switch (getItemViewType(i)) {
            case 0:
                return new OneHolder(inflater.inflate(R.layout.one, viewGroup, false));
           // case 1:
              //  return new RecyHolder(inflater.inflate(R.layout.recyxbanner, viewGroup, false));
        }
        return null;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {

        switch (getItemViewType(i)) {
            case 0:
                ((OneHolder) viewHolder).tv1.setText(beans.get(i).getCommodityName());
                Glide.with(context).load(beans.get(i).getMasterPic()).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.err).placeholder(R.drawable.f)).into(((OneHolder) viewHolder).img1);
                ((OneHolder) viewHolder).img1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (backClick != null) {
                            backClick.clickLin(beans.get(i).getCommodityName());
                        }
                    }
                });
                ((OneHolder) viewHolder).img1.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        if (backClick != null) {
                            backClick.longLin(beans.get(i).getCommodityName(), beans.get(i).getMasterPic());
                        }
                        return true;
                    }
                });
                break;
//            case 1:
//                ((RecyHolder)viewHolder).recyclerView.setLayoutManager(new LinearLayoutManager(context));
//                ((RecyHolder)viewHolder).recyclerView.setAdapter(new XbannerAdpter(beans, context));
//                break;
        }
    }


    @Override
    public int getItemCount() {
        return beans.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 1;
    }

    public void getData(CallBackClick callBackClick) {
        this.backClick = callBackClick;
    }

}
