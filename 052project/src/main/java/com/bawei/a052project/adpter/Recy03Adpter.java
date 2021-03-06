package com.bawei.a052project.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bawei.a052project.R;
import com.bawei.a052project.bean.Bean;
import com.bawei.a052project.holder.Recy022Holder;
import com.bawei.a052project.holder.Recy033;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:19:30
 *@Description:${DESCRIPTION}
 * */public class Recy03Adpter extends RecyclerView.Adapter<Recy033> {
    private ArrayList<Bean> list;
    private Context context;

    public Recy03Adpter(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Recy033 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);

        return new Recy033(inflater.inflate(R.layout.recy033, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Recy033 recy033, int i) {
            recy033.tv3.setText(list.get(i+3).getCommodityName());
            Glide.with(context).load(list.get(i+3).getMasterPic()).into( recy033.img3);
    }


    @Override
    public int getItemCount() {
        return 3;
    }
}
