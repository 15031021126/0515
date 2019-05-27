package com.bawei.a052project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bawei.a052project.adpter.SomeAdpter;
import com.bawei.a052project.bean.Bean;
import com.bawei.a052project.mvp.IOnecontract;
import com.bawei.a052project.mvp.OnePersenterImpl;
import com.zhy.autolayout.AutoLayoutActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TwoActivity extends AutoLayoutActivity implements IOnecontract.IOneView {

    private RecyclerView recy;
    private OnePersenterImpl persenter;
    private String url = "http://172.17.8.100/small/commodity/v1/commodityList";
    private ArrayList<Bean> list;
    private SomeAdpter adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        recy = findViewById(R.id.recy);
        persenter = new OnePersenterImpl();
        persenter.attach(this);
        persenter.RequestData(url);

    }


    @Override
    public void showData(String str) {
        try {
            JSONObject object = new JSONObject(str);
            JSONObject result = object.getJSONObject("result");
            JSONObject mlss = result.getJSONObject("mlss");
            list = new ArrayList<>();
            JSONArray commodityList1 = mlss.getJSONArray("commodityList");
            for (int i = 0; i < commodityList1.length(); i++) {
                JSONObject o = (JSONObject) commodityList1.get(i);
                String commodityId = o.getString("commodityId");
                String commodityName = o.getString("commodityName");
                String masterPic = o.getString("masterPic");
                list.add(new Bean(commodityId, commodityName, masterPic));

            }
            JSONObject pzsh = result.getJSONObject("pzsh");
            JSONArray commodityList2 = pzsh.getJSONArray("commodityList");
            for (int i = 0; i < commodityList2.length(); i++) {
                JSONObject o = (JSONObject) commodityList2.get(i);
                String commodityId = o.getString("commodityId");
                String commodityName = o.getString("commodityName");
                String masterPic = o.getString("masterPic");
                list.add(new Bean(commodityId, commodityName, masterPic));
            }
            JSONObject rxxp = result.getJSONObject("rxxp");
            JSONArray commodityList3 = rxxp.getJSONArray("commodityList");
            for (int i = 0; i < commodityList3.length(); i++) {
                JSONObject o = (JSONObject) commodityList3.get(i);
                String commodityId = o.getString("commodityId");
                String commodityName = o.getString("commodityName");
                String masterPic = o.getString("masterPic");
                list.add(new Bean(commodityId, commodityName, masterPic));

            }
            Log.e("123", "list: " + list);
            adpter = new SomeAdpter(list, TwoActivity.this);
            recy.setLayoutManager(new LinearLayoutManager(this));
            recy.setAdapter(adpter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
