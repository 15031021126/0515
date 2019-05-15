package com.bawei.lxx;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class SimpleHolder extends RecyclerView.ViewHolder {

    public   TextView tvTitle;

    public SimpleHolder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tv_title);
    }
}
