package com.bawei.chenhao0520.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.chenhao0520.R;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:9:23
 *@Description:${DESCRIPTION}
 * */public class OneHolder extends RecyclerView.ViewHolder {

    public ImageView img1;
    public TextView tv1;

    public OneHolder(@NonNull View itemView) {
        super(itemView);
        img1 = itemView.findViewById(R.id.img1);
        tv1 = itemView.findViewById(R.id.tv1);
    }
}
