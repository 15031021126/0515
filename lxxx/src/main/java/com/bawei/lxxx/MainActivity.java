package com.bawei.lxxx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.bawei.lxxx.adpter.SomeAdpter;
import com.bawei.lxxx.bean.XbannerBean;
import com.bawei.lxxx.showmvp.IshowMvp;
import com.bawei.lxxx.showmvp.OnePreenterImpl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IshowMvp.oneView {
    private String url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/100/1";
    private OnePreenterImpl preenter;
    private ArrayList<XbannerBean> list;
    private ArrayList<String> bens;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preenter = new OnePreenterImpl();
        recyclerView = findViewById(R.id.recy);
        preenter.attach(this);
        preenter.requestData(url);
    }

    @Override
    public void showData(String result) {
        try {
            JSONObject object = new JSONObject(result);
            JSONArray results = object.getJSONArray("results");
            list = new ArrayList<XbannerBean>();
            bens = new ArrayList<String>();
            for (int i = 0; i < results.length(); i++) {
                JSONObject o = (JSONObject) results.get(i);
                String a = o.getString("url");
                bens.add(a);
                if (i <= 5) {
                    list.add(new XbannerBean(a));
                }
            }

            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new SomeAdpter(MainActivity.this, list, bens));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        preenter.dettach();
    }
}
