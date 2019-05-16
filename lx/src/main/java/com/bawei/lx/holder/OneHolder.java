package com.bawei.lx.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.lx.R;

/**
 * Time:2017/12/9
 * Author:陈浩是、
 * Description:功能
 */
public class OneHolder extends RecyclerView.ViewHolder {

    public ImageView img1;
    public TextView tv1;

    public OneHolder(@NonNull View itemView) {
        super(itemView);
        img1 = itemView.findViewById(R.id.img1);
        tv1 = itemView.findViewById(R.id.tv1);

    }
}
