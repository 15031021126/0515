package com.bawei.chenhao0520.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.chenhao0520.Onclick;
import com.bawei.chenhao0520.R;
import com.bawei.chenhao0520.bean.Bean;
import com.bawei.chenhao0520.holder.OneHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:9:26
 *@Description:${适配器}
 * */public class OneAdpter extends RecyclerView.Adapter<OneHolder> {
    private ArrayList<Bean> list;
    private Context context;
    private Onclick onclick;

    public OneAdpter(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public OneHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new OneHolder(inflater.inflate(R.layout.lv, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder oneHolder, final int i) {
        oneHolder.tv1.setText(list.get(i).getCommodityName());
        Glide.with(context).load(list.get(i).getMasterPic()).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).error(R.drawable.black_background).placeholder(R.drawable.ic_launcher_background)).into(oneHolder.img1);
        oneHolder.img1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onclick.click(list.get(i).getCommodityName(),list.get(i).getMasterPic());
                return true;
            }
        });
        oneHolder.img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick.click(list.get(i).getCommodityName(),list.get(i).getMasterPic());
            }
        });
    }

    public void getData(Onclick onclick) {
        this.onclick=onclick;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
