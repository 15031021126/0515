package com.bawei.a052project.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bawei.a052project.R;
import com.bawei.a052project.bean.Bean;
import com.bawei.a052project.holder.Recy033;
import com.bawei.a052project.holder.Recy04;
import com.bawei.a052project.holder.Recy044;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:19:30
 *@Description:${DESCRIPTION}
 * */public class Recy04Adpter extends RecyclerView.Adapter<Recy044> {
    private ArrayList<Bean> list;
    private Context context;

    public Recy04Adpter(ArrayList<Bean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Recy044 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);

        return new Recy044(inflater.inflate(R.layout.recy044, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Recy044 recy044, int i) {
        recy044.tv4.setText(list.get(i+6).getCommodityName());
            Glide.with(context).load(list.get(i+6).getMasterPic()).into(recy044.img4);
        Log.e("000", "onBindViewHolder: "+list.size() );
    }


    @Override
    public int getItemCount() {
        return 3;
    }
}
