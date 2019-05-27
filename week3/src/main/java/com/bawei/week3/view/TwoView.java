package com.bawei.week3.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/*
 *@Auther:陈浩
 *@Date: 2019/5/25
 *@Time:14:33
 *@Description:${DESCRIPTION}
 * */public class TwoView extends ViewGroup {
    public TwoView(Context context) {
        this(context, null);
    }

    public TwoView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TwoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec,heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int width = getMeasuredWidth();
        //int width = getWidth();
        Log.e("123", "onLayout: " + width);
        int space = 20;
        int line = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int childMeasuredHeight = child.getMeasuredHeight();
            int childMeasuredWidth = child.getMeasuredWidth();
            if (space + childMeasuredWidth >= width) {
                line++;
                space = 20;
            }
            child.layout(space, childMeasuredHeight * line, space + childMeasuredWidth, childMeasuredHeight * (line + 1));
            space += childMeasuredWidth + 20;
        }

    }
}
