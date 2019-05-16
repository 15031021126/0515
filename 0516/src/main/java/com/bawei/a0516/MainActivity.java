package com.bawei.a0516;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

import com.bawei.a0516.adpter.XBannerAdpter;
import com.bawei.a0516.bean.Bean;
import com.bawei.a0516.bean.XbannerBean;
import com.bawei.a0516.mvp.Icontract;
import com.bawei.a0516.mvp.PersenterImpl;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.stx.xhb.xbanner.XBanner;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Icontract.IsView {

    private XBanner xbanner;
    private PersenterImpl persenter;
    private ArrayList<Bean> beans;
    private RecyclerView recyclerView;
    private ArrayList<XbannerBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recy);
        persenter = new PersenterImpl();
        persenter.attach(this);
        persenter.requestData("http://172.17.8.100/movieApi/movie/v1/findHotMovieList?page=1&count=10");
    }

    @Override
    public void showData(String result) {

        try {
            JSONObject object = new JSONObject(result);
            JSONArray array = object.getJSONArray("result");
            beans = new ArrayList<>();
            list = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                JSONObject o = (JSONObject) array.get(i);
                String imageUrl = o.getString("imageUrl");
                String name = o.getString("name");
                String summary = o.getString("summary");
                beans.add(new Bean(name, imageUrl, summary));
                if (i <= 5) {
                    list.add(new XbannerBean(imageUrl));
                }
            }
            Log.e("123", "showData: " + list.toString());
            //布局管理器
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            //适配器
            recyclerView.setAdapter(new XBannerAdpter(MainActivity.this, list,beans));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
