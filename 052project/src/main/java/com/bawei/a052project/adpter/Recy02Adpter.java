package com.bawei.a052project.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bawei.a052project.R;
import com.bawei.a052project.bean.Bean;
import com.bawei.a052project.holder.Recy022Holder;
import com.bawei.a052project.holder.Recy02Holder;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:19:30
 *@Description:${DESCRIPTION}
 * */public class Recy02Adpter extends RecyclerView.Adapter<Recy022Holder> {
    private ArrayList<Bean> list;
    private Context context;

    public Recy02Adpter(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Recy022Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);

        return new Recy022Holder(inflater.inflate(R.layout.recy022, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Recy022Holder recy02Holder, int i) {
        if (i <= 1) {
            recy02Holder.tv2.setText(list.get(i).getCommodityName());
            Glide.with(context).load(list.get(i).getMasterPic()).into(recy02Holder.img2);
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
