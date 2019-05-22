package com.bawei.lxxx.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.lxxx.MyClick;
import com.bawei.lxxx.R;
import com.bawei.lxxx.holder.Recy2;
import com.bawei.lxxx.holder.Recy22;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:20:23
 *@Description:${DESCRIPTION}
 * */public class TwoAdpter extends RecyclerView.Adapter<Recy22> {
    private Context context;
    private ArrayList<String> bens;
    private MyClick click;

    public TwoAdpter(Context context, ArrayList<String> bens) {
        this.context = context;
        this.bens = bens;
    }

    @NonNull
    @Override
    public Recy22 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new Recy22(inflater.inflate(R.layout.two2, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Recy22 recy22, final int i) {
        recy22.tv2.setText(bens.get(i));
        Glide.with(context).load(bens.get(i)).into(recy22.img2);
        recy22.img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.onClick(bens.get(i), bens);
            }
        });
        recy22.img2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                click.onLongClick(bens.get(i), bens);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return bens.size();
    }

    public void getData(MyClick click) {
        this.click = click;
    }
}
