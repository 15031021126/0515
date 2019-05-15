package com.bawei.lx;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TableLayout;

import com.bawei.lx.adpter.MyFragAdpter;
import com.bawei.lx.fragment.Frag01;
import com.bawei.lx.fragment.Frag02;
import com.bawei.lx.fragment.Frag03;
import com.bawei.lx.fragment.Frag04;
import com.bawei.lx.fragment.Frag05;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab;
    private ViewPager pager;
    private ArrayList<String> stringArrayList;
    private ArrayList<Fragment> fragmentArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pager = findViewById(R.id.pager);
        tab = findViewById(R.id.tab);
       RecyclerView recy= findViewById(R.id.recy);
//       recy.setLayoutManager(new GridLayoutManager());
        //数据
        stringArrayList = new ArrayList<>();
        stringArrayList.add("首页");
        stringArrayList.add("直播");
        stringArrayList.add("推荐");
        stringArrayList.add("购物车");
        stringArrayList.add("我的");
        fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new Frag01());
        fragmentArrayList.add(new Frag02());
        fragmentArrayList.add(new Frag03());
        fragmentArrayList.add(new Frag04());
        fragmentArrayList.add(new Frag05());
        //适配器
        pager.setAdapter(new MyFragAdpter(getSupportFragmentManager(), stringArrayList, fragmentArrayList));
        tab.setupWithViewPager(pager);
    }
}
