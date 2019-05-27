package com.bawei.stackliu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/*
 *@Auther:陈浩
 *@Date: 2019/5/24
 *@Time:17:09
 *@Description:${DESCRIPTION}
 * */public class MyStackView extends ViewGroup {
    public MyStackView(Context context) {
        super(context);
    }

    public MyStackView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyStackView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        //获取宽
        int width = getMeasuredWidth();

        //定义行书
        int low = 0;
        //行间距
        int margin = 18;
        for (int i = 0; i < getChildCount(); i++) {
            //获取子布局
            View childAt = getChildAt(i);
            //获取子布局的宽高
            int heightchild = childAt.getMeasuredHeight();
            int widthchild = childAt.getMeasuredWidth();
            if (margin + widthchild > width) {
                low++;
                margin = 18;
            }
            childAt.layout(margin,  low*heightchild, margin + widthchild, heightchild * (low + 1));
            margin+=widthchild+20;
        }


    }
}
