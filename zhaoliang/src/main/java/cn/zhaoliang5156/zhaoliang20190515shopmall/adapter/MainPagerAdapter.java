package cn.zhaoliang5156.zhaoliang20190515shopmall.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cn.zhaoliang5156.zhaoliang20190515shopmall.base.BaseFragment;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 11:00 AM
 * Description: MainActivity适配器
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragmentList;
    private String[] tabTitle = {"首页", "分类", "咨询", "购物车", "个人信息"};

    public MainPagerAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.fragmentList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitle[position];
    }
}
