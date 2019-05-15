package cn.zhaoliang5156.zhaoliang20190515shopmall.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import cn.zhaoliang5156.zhaoliang20190515shopmall.R;
import cn.zhaoliang5156.zhaoliang20190515shopmall.bean.HomeBanner;
import cn.zhaoliang5156.zhaoliang20190515shopmall.bean.HomeList;
import cn.zhaoliang5156.zhaoliang20190515shopmall.holder.home.BannerHolder;
import cn.zhaoliang5156.zhaoliang20190515shopmall.holder.home.MlssHolder;
import cn.zhaoliang5156.zhaoliang20190515shopmall.holder.home.PzshHolder;
import cn.zhaoliang5156.zhaoliang20190515shopmall.holder.home.RxxpHolder;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 3:04 PM
 * Description:
 * 首页的Adapter
 */
public class HomeAdapter extends RecyclerView.Adapter {

    // 定义条目类型
    private final int ITEM_TYPE_BANNER = 0; // ctrl + shift + u 大小写切换
    private final int ITEM_TYPE_RXXP = 1;
    private final int ITEM_TYPE_MLSS = 2;
    private final int ITEM_TYPE_PZSH = 3;

    private Context context;
    private HomeBanner banner;
    private HomeList list;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    public void updateBanner(HomeBanner banner) {
        this.banner = banner;
        notifyDataSetChanged();
    }

    public void updateList(HomeList list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 返回不同的Holder
        LayoutInflater inflater = LayoutInflater.from(context);
        switch (viewType) {
            case ITEM_TYPE_BANNER:
                return new BannerHolder(inflater.inflate(R.layout.home_item_banner, parent, false));
            case ITEM_TYPE_RXXP:
                return new RxxpHolder(inflater.inflate(R.layout.home_item_rxxp, parent, false));
            case ITEM_TYPE_MLSS:
                return new MlssHolder(inflater.inflate(R.layout.home_item_mlss, parent, false));
            case ITEM_TYPE_PZSH:
                return new PzshHolder(inflater.inflate(R.layout.home_item_pzsh, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // 根据不同的Holder进行赋值
        int viewType = getItemViewType(position);
        switch (viewType) {
            case ITEM_TYPE_BANNER:
                // 轮播赋值
                ((BannerHolder) holder).banner.setBannerData(banner.result);
                ((BannerHolder) holder).banner.loadImage(new XBanner.XBannerAdapter() {

                    @Override
                    public void loadBanner(XBanner banner, Object model, View view, int position) {
                        Glide.with(context).load(((HomeBanner.BannerItem) model).getXBannerUrl()).into((ImageView) view);
                    }
                });
                break;
            case ITEM_TYPE_RXXP:
                HomeList.Item rxxp = list.result.rxxp;
                ((RxxpHolder) holder).tvTag.setText(rxxp.name);
                ((RxxpHolder) holder).rxxpList.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
                ((RxxpHolder) holder).rxxpList.setAdapter(new RxxpAdapter(context, list.result.rxxp.commodityList));
                break;
            case ITEM_TYPE_MLSS:

                break;
            case ITEM_TYPE_PZSH:

                break;
        }
    }

    @Override
    public int getItemCount() {
        if (banner != null && list != null) {
            return 4;
        }
        return 0;
    }

    /**
     * 返回条目视图类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        int type = 0;
        switch (position) {
            case 0:
                type = ITEM_TYPE_BANNER;
                break;
            case 1:
                type = ITEM_TYPE_RXXP;
                break;
            case 2:
                type = ITEM_TYPE_MLSS;
                break;
            case 3:
                type = ITEM_TYPE_PZSH;
                break;
        }
        return type;
    }
}
