package com.bawei.loginandzc.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bawei.loginandzc.R;
import com.bawei.loginandzc.bean.XbannerBean;
import com.bawei.loginandzc.holder.OneHolder;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/5/17
 *@Time:15:54
 *@Description:${DESCRIPTION}
 * */public class OneAdpter extends RecyclerView.Adapter<OneHolder> {
    private ArrayList<String> bens;
    private Context context;

    public OneAdpter(ArrayList<String> bens, Context context) {
        this.bens = bens;
        this.context = context;
    }

    @NonNull
    @Override
    public OneHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new OneHolder(inflater.inflate(R.layout.one, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder oneHolder, int i) {
        oneHolder.tv1.setText(bens.get(i));
        Glide.with(context).load(bens.get(i)).into(oneHolder.img1);

    }

    @Override
    public int getItemCount() {
        return bens.size();
    }
}
