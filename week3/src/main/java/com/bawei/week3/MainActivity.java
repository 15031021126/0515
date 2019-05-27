package com.bawei.week3;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bawei.week3.adpter.FragAdpter;
import com.bawei.week3.fragment.Frag01;
import com.bawei.week3.fragment.Frag02;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private TabLayout tab;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        tab = findViewById(R.id.tab);
        //数据
        fragments = new ArrayList<>();
        fragments.add(new Frag01());
        fragments.add(new Frag02());
        strings = new ArrayList<>();
        strings.add("首页");
        strings.add("我的");
        //适配器
        FragAdpter adpter = new FragAdpter(getSupportFragmentManager(), fragments, strings, MainActivity.this);
        pager.setAdapter(adpter);
        tab.setupWithViewPager(pager);
    }
}
