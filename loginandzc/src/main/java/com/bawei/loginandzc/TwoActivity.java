package com.bawei.loginandzc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bawei.loginandzc.adpter.XbannerAdpter;
import com.bawei.loginandzc.bean.XbannerBean;
import com.bawei.loginandzc.showmvp.IshowMvp;
import com.bawei.loginandzc.showmvp.OnePreenterImpl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TwoActivity extends AppCompatActivity implements IshowMvp.oneView {
    private String url = "http://gank.io/api/data/%E7%A6%8F%E5%88%A9/100/1";
    private OnePreenterImpl preenter;
    private ArrayList<XbannerBean> list;
    private ArrayList<String> bens;
    private RecyclerView recyclerView;
    private RecyclerView recy2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        recyclerView = findViewById(R.id.recybanner);
        recy2 = findViewById(R.id.recy2);
        preenter = new OnePreenterImpl();
        preenter.attach(this);
        preenter.requestData(url);
    }

    @Override
    public void showData(String result) {
        try {
            JSONObject object = new JSONObject(result);
            JSONArray results = object.getJSONArray("results");
            list = new ArrayList<>();
            bens = new ArrayList<>();
            for (int i = 0; i < results.length(); i++) {
                JSONObject o = (JSONObject) results.get(i);
                String url = o.getString("url");
                bens.add(url);
                if (i <= 5) {
                    list.add(new XbannerBean(url));
                }
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(new XbannerAdpter(list, TwoActivity.this, bens));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
