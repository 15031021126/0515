package com.bawei.myapplication.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.bawei.myapplication.R;

/*
 *@Auther:陈浩
 *@Date: 2019/5/21
 *@Time:14:09
 *@Description:${DESCRIPTION}
 * */public class MyView extends View {

    private Paint paint3;
    private Path path;
    private Paint paint;
    private Paint paint2;
    private Paint aa;
    private Canvas bb;

    public MyView(Context context) {
        super(context);

    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        paint.setColor(Color.YELLOW);
        paint.setTextSize(25);
        paint.setStrokeWidth(20);
        paint.setAntiAlias(true);

        paint2 = new Paint();
        paint2.setColor(Color.RED);//设置画笔颜色
        paint2.setStrokeWidth(20);//设置粗细
        paint2.setAntiAlias(true);//抗锯齿
        bb = new Canvas();
        //canvas.drawCircle(200, 200, 150, paint);
        canvas.drawRoundRect(50, 50, 500, 700, 50, 50, paint2);//绘制圆形矩形rect
        canvas.drawCircle(getWidth() / 2, getHeight() / 3, 80, paint);//画园

        // canvas.drawLine(70,58,300,getHeight()/3+70,paint);
        // canvas.drawLine(getWidth()/2,getHeight()/3,getWidth()-50,66,paint);
        paint3 = new Paint();
        paint3.setColor(Color.GRAY);
        paint3.setTextSize(50);
        
        paint3.setAlpha(255);
        canvas.drawText("开", getWidth() / 2 - 20, getHeight() / 3 + 10, paint3);
        canvas.drawArc(50, 20, getWidth() - 38, 150, 0, 180, true, paint);
        canvas.drawText("得到一加七pro一部", 150, 520, paint);
        canvas.drawRect(50, 400, 500, 600, paint3);//设置灰色方块
        path = new Path();
        aa = new Paint();
        aa.setStyle(Paint.Style.STROKE);
        aa.setStrokeCap(Paint.Cap.ROUND);
        aa.setStrokeJoin(Paint.Join.ROUND);
        aa.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        aa.setAlpha(0);


    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        Log.e("123", "onTouchEvent: " + "X  " + x + "Y  " + y);
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                if (x >= 60 && x <= 493 && y >= 60 && y <= 700) {
                    path.reset();
                    path.moveTo(x, y);
                }
                break;
            case MotionEvent.ACTION_UP:
                Log.e("123", "抬起");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("123", "移动");
                
                path.lineTo(x, y);
                break;

        }
            bb.drawPath(path,paint3);
        invalidate();
        return true;
    }
}
