package com.bawei.lx.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bawei.lx.R;

/*
 *@Auther:陈浩
 *@Date: 2019/5/18
 *@Time:10:51
 *@Description:${DESCRIPTION}
 * */public class RecyHolder extends RecyclerView.ViewHolder {

    public  RecyclerView recyclerView;

    public RecyHolder(@NonNull View itemView) {
        super(itemView);
        recyclerView = itemView.findViewById(R.id.xbannerrecy);
    }
}
