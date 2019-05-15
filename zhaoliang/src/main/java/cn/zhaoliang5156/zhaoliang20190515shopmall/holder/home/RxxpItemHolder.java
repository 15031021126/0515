package cn.zhaoliang5156.zhaoliang20190515shopmall.holder.home;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.zhaoliang5156.zhaoliang20190515shopmall.R;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 4:17 PM
 * Description:
 */
public class RxxpItemHolder extends RecyclerView.ViewHolder {

    public ImageView icon;
    public TextView tvName;
    public TextView tvPrice;

    public RxxpItemHolder(View itemView) {
        super(itemView);
        icon = itemView.findViewById(R.id.iv_icon);
        tvName = itemView.findViewById(R.id.tv_desc);
        tvPrice = itemView.findViewById(R.id.tv_price);
    }
}
