package com.bawei.chenhao0527.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.bawei.chenhao0527.CallClik;
import com.bawei.chenhao0527.R;

/*
 *@Auther:陈浩
 *@Date: 2019/5/27
 *@Time:9:19
 *@Description:${DESCRIPTION}
 * */public class MyView extends View {

    private int tcolor;
    private int height;
    private int width;
    private String[] list;
    private CallClik callClik;
    private String s;
    private Paint paint;
    private int a;
    private int b;
    private Boolean tag = false;

    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        tcolor = typedArray.getColor(R.styleable.MyView_tcolor, Color.BLACK);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        height = getMeasuredHeight();
        width = getMeasuredWidth();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        list = new String[]{"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};
        paint = new Paint();
        paint.setTextSize(26);
        paint.setColor(tcolor);
        if (tag == false) {
            a = 5;
        }
        for (int i = 0; i < list.length; i++) {
            tag = true;
            canvas.drawText(list[i], width - 30, (height / list.length * i + 1), this.paint);
            if (a == i) {
                paint.setColor(Color.RED);
            } else {
                paint.setColor(tcolor);
            }
        }
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int y = (int) event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                a = (y / (height / list.length));
                if (a < 27 && a >= 0) {
                    s = list[a + 1];
                    Log.e("123", "onTouchEvent: " + s + a);
                    callClik.success(s);
                }
                break;
            case MotionEvent.ACTION_UP:
                a = a;
                break;
        }
        return true;
    }

    public void setGETData(CallClik callClik) {
        this.callClik = callClik;
    }
}
