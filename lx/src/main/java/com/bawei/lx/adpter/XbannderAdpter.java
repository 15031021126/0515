package com.bawei.lx.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bawei.lx.R;
import com.bawei.lx.holder.OneHolder;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class XbannderAdpter extends RecyclerView.Adapter<OneHolder> {
    private ArrayList<String> ss;
    private Context context;

    public XbannderAdpter(ArrayList<String> ss, Context context) {
        this.ss = ss;
        this.context = context;
    }

    @NonNull
    @Override
    public OneHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new OneHolder(inflater.inflate(R.layout.lv1, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OneHolder holder, int i) {
        Glide.with(context).load(ss.get(i)).into(holder.img1);
       holder.tv1.setText(ss.get(i));
    }

    @Override
    public int getItemCount() {
        return ss.size();
    }
}
