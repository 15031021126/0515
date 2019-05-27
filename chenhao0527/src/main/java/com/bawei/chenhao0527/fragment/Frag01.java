package com.bawei.chenhao0527.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.chenhao0527.CallClik;
import com.bawei.chenhao0527.R;
import com.bawei.chenhao0527.view.MyView;

/*
 *@Auther:陈浩
 *@Date: 2019/5/27
 *@Time:8:46
 *@Description:${DESCRIPTION}
 * */public class Frag01 extends Fragment {
    CallClik callClik;
    private MyView aa;
    private TextView vv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag01, container, false);
        aa = view.findViewById(R.id.view);
        vv = view.findViewById(R.id.vv);
        TextView textView = new TextView(getActivity());
        textView.setText("F");
        textView.setGravity(Gravity.CENTER);
        textView.setBackgroundColor(Color.BLACK);
        aa.setGETData(new CallClik() {
            @Override
            public void success(String result) {
                vv.setText(result);
                // Toast.makeText(getActivity(), ""+result, Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }


}
