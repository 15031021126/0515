package cn.zhaoliang5156.zhaoliang20190515shopmall.holder.home;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import cn.zhaoliang5156.zhaoliang20190515shopmall.R;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 3:06 PM
 * Description:
 * 热销新品ViewHolder
 */
public class RxxpHolder extends RecyclerView.ViewHolder {

    public TextView tvTag;
    public RecyclerView rxxpList;

    public RxxpHolder(View itemView) {
        super(itemView);

        tvTag = itemView.findViewById(R.id.tv_tag);
        rxxpList = itemView.findViewById(R.id.rxxp_list);
    }
}
