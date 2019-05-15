package cn.zhaoliang5156.zhaoliang20190515shopmall.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import cn.zhaoliang5156.zhaoliang20190515shopmall.R;
import cn.zhaoliang5156.zhaoliang20190515shopmall.adapter.MainPagerAdapter;
import cn.zhaoliang5156.zhaoliang20190515shopmall.base.BaseFragment;
import cn.zhaoliang5156.zhaoliang20190515shopmall.ui.fragment.CategoryFragment;
import cn.zhaoliang5156.zhaoliang20190515shopmall.ui.fragment.HomeFragment;
import cn.zhaoliang5156.zhaoliang20190515shopmall.ui.fragment.MyFragment;
import cn.zhaoliang5156.zhaoliang20190515shopmall.ui.fragment.NewsFragment;
import cn.zhaoliang5156.zhaoliang20190515shopmall.ui.fragment.ShopCartFragment;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 10:48 AM
 * Description:
 * 首页Activity
 * TabLayout+ViewPager+Fragment
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mainPager;
    private TabLayout mainTab;

    private List<BaseFragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPager = findViewById(R.id.main_pager);
        mainTab = findViewById(R.id.main_tab);

        // 初始化页面
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new NewsFragment());
        fragmentList.add(new ShopCartFragment());
        fragmentList.add(new MyFragment());

        // 设置适配器
        mainPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(), fragmentList));
        // 让Page和tab关联
        mainTab.setupWithViewPager(mainPager);

    }
}
