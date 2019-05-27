package com.bawei.week3.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.week3.R;

/*
 *@Auther:陈浩
 *@Date: 2019/5/25
 *@Time:9:13
 *@Description:${DESCRIPTION}
 * */public class Frag01 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag01,container,false);
    }
}
