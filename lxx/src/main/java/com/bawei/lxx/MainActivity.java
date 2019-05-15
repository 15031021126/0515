package com.bawei.lxx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bawei.lxx.mvp.HomePersenterImpl;
import com.bawei.lxx.mvp.IhomeContract;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IhomeContract.IhomeView {
    private String url = "http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10";
    private HomePersenterImpl persenter;
    private RecyclerView recyclerView;
    private ArrayList<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lv);
        //找控件
        recyclerView = findViewById(R.id.first_recycle);
        persenter = new HomePersenterImpl();
        persenter.attach(this);
        persenter.requestList(url);
        //数据
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("helloWord!" + i);
        }
        //设置布局管理器
        //list条目
       //recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        //网格
      //  recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        //横线
        recyclerView.setLayoutManager(new GridLayoutManager(this,4,LinearLayoutManager.HORIZONTAL,false));
        //设置适配器
        recyclerView.setAdapter(new SimpleRecycleViewAdapter(list, MainActivity.this));

    }

    //请求接口数据
    @Override
    public void showList(String result) {
        Log.e("123", "showList: " + result);
    }
}
