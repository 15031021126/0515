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
 * */public class Recy3 extends RecyclerView.ViewHolder {

    public RecyclerView recy3;

    public Recy3(@NonNull View itemView) {
        super(itemView);
        recy3 = itemView.findViewById(R.id.recy3);
    }
}
