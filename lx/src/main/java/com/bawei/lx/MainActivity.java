package com.bawei.lx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.lx.adpter.OneAdpter;
import com.bawei.lx.adpter.XbannerAdpter;
import com.bawei.lx.shopmvp.IShopContract;
import com.bawei.lx.shopmvp.ShopPresenterImpl;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IShopContract.shopView {

    private String url = "http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=" + URLEncoder.encode("板鞋") + "&page=1&count=20";

    private ShopPresenterImpl presenter;
    private EditText text;
    private ImageView ss;
    private String s;
    private ArrayList<Bean> beans;
    private RecyclerView recyclerView;
    private OneAdpter adpter1;
    private ArrayList<Bean> list;
   // private RecyclerView cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new ShopPresenterImpl();
        recyclerView = findViewById(R.id.recy);
      //  cc = findViewById(R.id.cc);
        presenter.attach(this);
        ss = findViewById(R.id.ss);
        presenter.requestData("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=" + URLEncoder.encode("板鞋") + "&page=1&count=30");
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = findViewById(R.id.edt);
                s = text.getText().toString();
                presenter.requestData("http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?keyword=" + URLEncoder.encode(s) + "&page=1&count=20");
                Log.e("123", "showData: " + s);
                adpter1.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void showData(String result) {

        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray array = jsonObject.getJSONArray("result");
            beans = new ArrayList<>();
            list = new ArrayList<>();
            for (int i = 0; i < array.length(); i++) {
                JSONObject o = (JSONObject) array.get(i);
                String commodityName = o.getString("commodityName");
                String masterPic = o.getString("masterPic");
                beans.add(new Bean(commodityName, masterPic));
                if (i <= 5) {
                    list.add(new Bean(commodityName, masterPic));
                }
            }
            Log.e("123", "showData: " + beans);
            if (beans.size() == 0) {
                Toast.makeText(this, "没数据啦!", Toast.LENGTH_SHORT).show();
            }

            recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
            adpter1 = new OneAdpter(MainActivity.this, beans);
            recyclerView.setAdapter(adpter1);
            //callBackClick.onClickLinster();
          //  cc.setLayoutManager(new LinearLayoutManager(this));
           // cc.setAdapter(new XbannerAdpter(beans, this));
            CallBackClick callBackClick;
            adpter1.getData(new CallBackClick() {
                @Override
                public void clickLin(String data) {
                    Toast.makeText(MainActivity.this, "" + data, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void longLin(String data, String i) {
                    Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                    intent.putExtra("a", data);
                    intent.putExtra("b", i);
                    startActivity(intent);

                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
