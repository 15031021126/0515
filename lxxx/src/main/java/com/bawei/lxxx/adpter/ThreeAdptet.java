package com.bawei.lxxx.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bawei.lxxx.R;
import com.bawei.lxxx.holder.Recy2;
import com.bawei.lxxx.holder.Recy22;
import com.bawei.lxxx.holder.Recy3;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:21:36
 *@Description:${DESCRIPTION}
 * */public class ThreeAdptet extends RecyclerView.Adapter<Recy22> {
    private Context context;
    private ArrayList<String> bens;

    public ThreeAdptet(Context context, ArrayList<String> bens) {
        this.context = context;
        this.bens = bens;
    }


    @NonNull
    @Override
    public Recy22 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new Recy22(inflater.inflate(R.layout.two2, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Recy22 recy22, int i) {
        recy22.tv2.setText(bens.get(i));
        Glide.with(context).load(bens.get(i)).into(recy22.img2);
    }

    @Override
    public int getItemCount() {
        return bens.size();
    }
}
