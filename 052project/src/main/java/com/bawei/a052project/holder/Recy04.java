package com.bawei.a052project.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.a052project.R;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:20:13
 *@Description:${DESCRIPTION}
 * */public class Recy04 extends RecyclerView.ViewHolder {

    public  RecyclerView recy04;

    public Recy04(@NonNull View itemView) {
        super(itemView);
        recy04 = itemView.findViewById(R.id.recy04);
    }
}
