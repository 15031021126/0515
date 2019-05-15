package cn.zhaoliang5156.zhaoliang20190515shopmall.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import cn.zhaoliang5156.zhaoliang20190515shopmall.Api;
import cn.zhaoliang5156.zhaoliang20190515shopmall.R;
import cn.zhaoliang5156.zhaoliang20190515shopmall.adapter.HomeAdapter;
import cn.zhaoliang5156.zhaoliang20190515shopmall.base.BaseFragment;
import cn.zhaoliang5156.zhaoliang20190515shopmall.bean.HomeBanner;
import cn.zhaoliang5156.zhaoliang20190515shopmall.bean.HomeList;
import cn.zhaoliang5156.zhaoliang20190515shopmall.mvp.home.HomePresenterImpl;
import cn.zhaoliang5156.zhaoliang20190515shopmall.mvp.home.IHomeContract;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 10:55 AM
 * Description: 首页Fragment
 */
public class HomeFragment extends BaseFragment implements IHomeContract.IHomeView {

    private static final String TAG = HomeFragment.class.getSimpleName();

    private IHomeContract.IHomePresenter presenter;

    private RecyclerView recyclerView;  // 声明首页列表
    private HomeAdapter adapter;

    @Override
    protected int setView() {
        return R.layout.home_fragment;
    }

    @Override
    protected void bindView(View view) {
        recyclerView = view.findViewById(R.id.home_recycle_view);

        // 设置布局管理
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        // 设置Adapter
        adapter = new HomeAdapter(mActivity);
        recyclerView.setAdapter(adapter);

        presenter = new HomePresenterImpl();
        presenter.attach(this);
    }


    @Override
    protected void initData() {
        presenter.getBanner(Api.home_banner);
        presenter.getList(Api.home_list);
    }

    @Override
    public void showBanner(String data) {
        Log.i(TAG, "Banner:" + data);
        Gson gson = new Gson();
        HomeBanner homeBanner = gson.fromJson(data, HomeBanner.class);
        adapter.updateBanner(homeBanner);

    }

    @Override
    public void showList(String data) {
        Log.i(TAG, "List" + data);
        Gson gson = new Gson();
        HomeList homeList = gson.fromJson(data, HomeList.class);
        adapter.updateList(homeList);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
