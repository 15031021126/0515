package com.bawei.lxxx.adpter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bawei.lxxx.MyClick;
import com.bawei.lxxx.R;
import com.bawei.lxxx.TwoActivity;
import com.bawei.lxxx.bean.XbannerBean;
import com.bawei.lxxx.holder.Recy2;
import com.bawei.lxxx.holder.Recy3;
import com.bawei.lxxx.holder.XbannerHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:20:01
 *@Description:${DESCRIPTION}
 * */public class SomeAdpter extends RecyclerView.Adapter {
    private Context context;
    private ArrayList<XbannerBean> list;
    private ArrayList<String> bens;
    private MyClick click;

    public final int A = 0;
    public final int B = 1;
    public final int C = 2;
    public final int D = 3;
    private TwoAdpter twoAdpter;

    public SomeAdpter(Context context, ArrayList<XbannerBean> list, ArrayList<String> bens) {
        this.context = context;
        this.list = list;
        this.bens = bens;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);

        switch (getItemViewType(i)) {
            case A:
                return new XbannerHolder(inflater.inflate(R.layout.xabnnerlayout, viewGroup, false));
            case B:
                return new Recy2(inflater.inflate(R.layout.twolayout, viewGroup, false));
            case C:
                return new Recy3(inflater.inflate(R.layout.three1, viewGroup, false));
            case D:
                return new Recy2(inflater.inflate(R.layout.twolayout, viewGroup, false));
        }
        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (getItemViewType(i)) {
            case A:
                ((XbannerHolder) viewHolder).xbanner.setBannerData(list);
                ((XbannerHolder) viewHolder).xbanner.loadImage(new XBanner.XBannerAdapter() {
                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        XbannerBean o = (XbannerBean) model;
                        String s = o.getXBannerUrl();
                        Glide.with(context).load(s).apply(new RequestOptions().placeholder(R.drawable.black_background)).into((ImageView) view);
                    }
                });
                break;
            case B:

                ((Recy2) viewHolder).recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                twoAdpter = new TwoAdpter(context, bens);
                twoAdpter.getData(new MyClick() {
                    @Override
                    public void onClick(String url, ArrayList<String> bean,Intent intent) {
                        Intent aa = new Intent(context, TwoActivity.class);
                        aa.putExtra("a",bens);
                    }

                    @Override
                    public void onLongClick(String url, ArrayList<String> bean) {
                        Toast.makeText(context, bean.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
                ((Recy2) viewHolder).recyclerView.setAdapter(twoAdpter);
                break;
            case C:
                ((Recy3) viewHolder).recy3.setLayoutManager(new GridLayoutManager(context, 2));
                ((Recy3) viewHolder).recy3.setAdapter(new ThreeAdptet(context, bens));
                break;
            case D:

                break;
        }
    }

    public void getDa(MyClick click) {
        this.click = click;
    }

    @Override
    public int getItemCount() {
        if (bens != null && list != null) {
            return 4;
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        switch (position) {
            case 0:
                type = A;
                break;
            case 1:
                type = B;
                break;
            case 2:
                type = C;
                break;
            case 3:
                type = D;
                break;
        }
        return type;
    }
}
