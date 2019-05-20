package com.bawei.lxxx.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.lxxx.R;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:20:00
 *@Description:${DESCRIPTION}
 * */public class Recy22 extends RecyclerView.ViewHolder {

    public ImageView img2;
    public TextView tv2;

    public Recy22(@NonNull View itemView) {
        super(itemView);
        img2 = itemView.findViewById(R.id.img2);
        tv2 = itemView.findViewById(R.id.tv2);
    }
}
