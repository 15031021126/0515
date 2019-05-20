package com.bawei.loginandzc.holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.loginandzc.R;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class OneHolder extends RecyclerView.ViewHolder {

    public  TextView tv1;
    public  ImageView img1;

    public OneHolder(@NonNull View itemView) {
        super(itemView);
        img1 = itemView.findViewById(R.id.img1);
        tv1 = itemView.findViewById(R.id.tv1);
    }
}
