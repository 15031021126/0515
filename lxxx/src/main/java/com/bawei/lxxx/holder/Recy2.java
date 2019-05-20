package com.bawei.lxxx.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.lxxx.R;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:20:00
 *@Description:${DESCRIPTION}
 * */public class Recy2 extends RecyclerView.ViewHolder {

    public  RecyclerView recyclerView;

    public Recy2(@NonNull View itemView) {
        super(itemView);
        recyclerView = itemView.findViewById(R.id.recyy22);
    }
}
