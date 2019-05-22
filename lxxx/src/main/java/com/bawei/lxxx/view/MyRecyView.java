package com.bawei.lxxx.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.icu.util.Measure;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/*
 *@Auther:陈浩
 *@Date: 2019/5/20
 *@Time:22:11
 *@Description:${DESCRIPTION}
 * */public class MyRecyView extends RecyclerView {
    public MyRecyView(@NonNull Context context) {
        super(context);
    }

    public MyRecyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        super.onMeasure(widthSpec, heightSpec);
        heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 3, MeasureSpec.AT_MOST);
    }
}
