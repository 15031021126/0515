package com.bawei.lxx;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class SimpleRecycleViewAdapter extends RecyclerView.Adapter<SimpleHolder> {
    private ArrayList<String> list;
    private Context context;

    public SimpleRecycleViewAdapter(ArrayList<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public SimpleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //设置试图
        LayoutInflater inflater = LayoutInflater.from(context);
        return new SimpleHolder(inflater.inflate(R.layout.simple_recycler_view_item, parent, false));
    }
    @Override
    public void onBindViewHolder(@NonNull SimpleHolder holder, int position) {
        //设置值
        holder.tvTitle.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        //设置大小
        return list.size();
    }
}
