package cn.zhaoliang5156.zhaoliang20190515shopmall.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Copyright (C), 2015-2019, 八维集团
 * Author: zhaoliang
 * Date: 2019/5/15 10:42 AM
 * Description: 基类Fragment
 * onAttach
 * onCreateView
 * onViewCreated
 * onActivityCreated
 */
public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;

    /**
     * 返回视图
     *
     * @return
     */
    protected abstract int setView();

    /**
     * 绑定视图
     */
    protected abstract void bindView(View view);

    /**
     * 初始化数据
     */
    protected abstract void initData();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setView(), container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

}
