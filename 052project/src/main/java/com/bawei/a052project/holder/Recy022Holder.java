package com.bawei.a052project.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.a052project.R;

/*
 *@Auther:陈浩
 *@Date: 2019/5/23
 *@Time:19:33
 *@Description:${DESCRIPTION}
 * */public class Recy022Holder extends RecyclerView.ViewHolder {

    public  ImageView img2;
    public  TextView tv2;

    public Recy022Holder(@NonNull View itemView) {
        super(itemView);
        img2 = itemView.findViewById(R.id.img2);
        tv2 = itemView.findViewById(R.id.tv2);
    }
}
