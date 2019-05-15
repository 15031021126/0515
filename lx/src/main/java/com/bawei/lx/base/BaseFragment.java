package com.bawei.lx.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.lx.MainActivity;
import com.bawei.lx.R;

/**
 * Time:2017/12/9
 * Author:陈浩
 * Description:功能
 */
public abstract class BaseFragment extends Fragment {
    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(bindLayout(), container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mainActivity = (MainActivity) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bindView();
        iniData();
        bindEven();
    }

    protected abstract int bindLayout();

    protected abstract void bindView();

    protected abstract void iniData();

    protected abstract void bindEven();

}
