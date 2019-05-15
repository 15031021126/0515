package com.bawei.lx.adpter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class MyFragAdpter extends FragmentPagerAdapter {
    private ArrayList<String> stringArrayList;
    private ArrayList<Fragment> fragmentArrayList;

    public MyFragAdpter(FragmentManager fm, ArrayList<String> stringArrayList, ArrayList<Fragment> fragmentArrayList) {
        super(fm);
        this.stringArrayList = stringArrayList;
        this.fragmentArrayList = fragmentArrayList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentArrayList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return stringArrayList.get(position);

    }
}
