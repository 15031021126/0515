package com.bawei.a052project.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.a052project.R;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:19:27
 *@Description:${DESCRIPTION}
 * */public class Recy02Holder extends RecyclerView.ViewHolder {

    public RecyclerView recy02;

    public Recy02Holder(@NonNull View itemView) {
        super(itemView);
        recy02 = itemView.findViewById(R.id.recy02);
    }
}
