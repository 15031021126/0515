package com.bawei.chenhao0520;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.chenhao0520.adpter.OneAdpter;
import com.bawei.chenhao0520.bean.Bean;
import com.bawei.chenhao0520.mvp.IoneContract;
import com.bawei.chenhao0520.mvp.OnePersenterImpl;
import com.bawei.chenhao0520.net.HttpUntil;
import com.bumptech.glide.load.Encoder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;

public class MainActivity extends AppCompatActivity implements IoneContract.IoneView {

    private OnePersenterImpl persenter;
    private String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=" + URLEncoder.encode("手机") + "&page=1&count=20";
    private RecyclerView recyclerView;
    private ArrayList<Bean> list;
    private EditText text;
    private Button ss;
    private OneAdpter adpter;
    private HttpUntil until;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persenter = new OnePersenterImpl();
        persenter.attach(this);
        persenter.requestData(url);
        until = new HttpUntil();
        //判断网络
        boolean b = until.isNet(MainActivity.this);
        if(!b){
            Toast.makeText(this, "没网", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "有网", Toast.LENGTH_SHORT).show();
        recyclerView = findViewById(R.id.recy);
        ss = findViewById(R.id.ss);
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = findViewById(R.id.edt);
                String s = text.getText().toString();
                if (s.length() == 0) {
                    Toast.makeText(MainActivity.this, "内容不得为空!", Toast.LENGTH_SHORT).show();
                }
                persenter.requestData("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=" + URLEncoder.encode(s) + "&page=1&count=20");
                adpter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void showData(String url) {
            
        try {
            JSONObject object = new JSONObject(url);
            JSONArray result = object.getJSONArray("result");
            list = new ArrayList<>();
            for (int i = 0; i < result.length(); i++) {
                JSONObject o = (JSONObject) result.get(i);
                String commodityId = o.getString("commodityId");
                String commodityName = o.getString("commodityName");
                String masterPic = o.getString("masterPic");
                list.add(new Bean(commodityId, commodityName, masterPic));
            }
            Log.e("123", "showData: " + list);
            if (list.size() == 0) {
                Toast.makeText(this, "没有数据了!", Toast.LENGTH_SHORT).show();
            }
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
            //适配器
            adpter = new OneAdpter(list, MainActivity.this);
            recyclerView.setAdapter(adpter);
            adpter.getData(new Onclick() {
                @Override
                public void click(String id,String uri) {
                    Intent intent = new Intent(MainActivity.this,TwoActivity.class);
                    intent.putExtra("a",id);
                    intent.putExtra("b",uri);
                    startActivity(intent);
                }

                @Override
                public void longclick(String name,String uri) {
                    Toast.makeText(MainActivity.this, name+uri, Toast.LENGTH_SHORT).show();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
