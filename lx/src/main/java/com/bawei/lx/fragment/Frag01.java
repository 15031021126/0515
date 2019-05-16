package com.bawei.lx.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bawei.lx.R;
import com.bawei.lx.adpter.XbannderAdpter;
import com.bawei.lx.base.BaseFragment;
import com.bawei.lx.bean.BannerBean;
import com.bawei.lx.vp.IOneContract;
import com.bawei.lx.vp.OnePersenterImpl;
import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public class Frag01 extends BaseFragment implements IOneContract.oneView {

    private XBanner xBanner;
    private OnePersenterImpl persenter;
    private ArrayList<String> ss;
    private RecyclerView recyclerView;


    @Override
    protected int bindLayout() {
        return R.layout.frag01;
    }

    @Override
    protected void bindView() {

        xBanner = getActivity().findViewById(R.id.xbanner);
        recyclerView = getActivity().findViewById(R.id.recy);

    }

    @Override
    protected void iniData() {
        persenter = new OnePersenterImpl();
        persenter.attach(this);
        persenter.request("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/30/2");
    }

    @Override
    protected void bindEven() {

    }


    private List<BannerBean> bannerBeanList = new ArrayList<>();

    @Override
    public void showData(String result) {
        try {
            JSONObject object = new JSONObject(result);
            JSONArray results = object.getJSONArray("results");
            ss = new ArrayList<>();
            for (int i = 0; i < results.length(); i++) {
                JSONObject o = (JSONObject) results.get(i);
                String url = o.getString("url");
                ss.add(url);
                if (i < 5) {
                    bannerBeanList.add(new BannerBean(url));
                }
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
            recyclerView.setAdapter(new XbannderAdpter(ss,getActivity()));
            //轮播
            xBanner.setBannerData(bannerBeanList);
            xBanner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    Glide.with(getContext()).load(((BannerBean)model).getXBannerUrl()).into((ImageView)view);
                }
            });
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
