package com.bawei.lx.fragment;

import android.util.Log;
import android.view.View;

import com.bawei.lx.R;
import com.bawei.lx.base.BaseFragment;
import com.bawei.lx.vp.IOneContract;
import com.bawei.lx.vp.OnePersenterImpl;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class Frag01 extends BaseFragment implements IOneContract.oneView {

    private XBanner xBanner;
    private OnePersenterImpl persenter;
    private ArrayList<String> strings;

    @Override
    protected int bindLayout() {
        return R.layout.frag01;
    }

    @Override
    protected void bindView() {

        xBanner = getActivity().findViewById(R.id.xbanner);

    }

    @Override
    protected void iniData() {
        persenter = new OnePersenterImpl();
        persenter.attach(this);
        persenter.request("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/200/1");
    }

    @Override
    protected void bindEven() {

    }


    @Override
    public void showData(String result) {
        try {
            JSONObject object = new JSONObject(result);
            JSONArray results = object.getJSONArray("results");
            strings = new ArrayList<>();
            for (int i = 0; i < results.length(); i++) {
                JSONObject o = (JSONObject) results.get(i);
                String url = o.getString("url");
                strings.add(url);
            }
            Log.e("123", "showData: "+strings );
            xBanner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    String o = (String) model;
                    Glide.with(getContext()).load(o).into();
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}