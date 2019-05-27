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
 * */public class Recy033 extends RecyclerView.ViewHolder {

    public ImageView img3;
    public TextView tv3;

    public Recy033(@NonNull View itemView) {
        super(itemView);
        img3 = itemView.findViewById(R.id.img3);
        tv3 = itemView.findViewById(R.id.tv3);
    }
}
