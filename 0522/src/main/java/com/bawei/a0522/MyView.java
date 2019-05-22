package com.bawei.a0522;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
 *@Auther:陈浩
 *@Date: 2019/5/22
 *@Time:8:39
 *@Description:${DESCRIPTION}
 * */public class MyView extends View {
    private CakkBackStr cakkBackStr;
    private int[][] ew;
    private int num=5;
    private int color;
    private int oc;
    private int back;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       //读取属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        //读取数量
        color = typedArray.getColor(R.styleable.MyView_linecolor, Color.BLACK);
        oc = typedArray.getColor(R.styleable.MyView_ocolor, Color.BLACK);
        num = typedArray.getInteger(R.styleable.MyView_num, 5);
        back = typedArray.getColor(R.styleable.MyView_back, Color.GRAY);
        //释放资源
        typedArray.recycle();
        setBackgroundColor(back);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        Paint paint = new Paint();
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        int space = 80;
        canvas.drawLine(space, 750, getWidth() - 30, 750, paint);//x轴
        canvas.drawLine(space, 750, space, 50, paint);//Y轴
        paint.setColor(Color.RED);
        canvas.drawLine(space, 750, space, 731 / 4 * 1 - 100, paint);//Y轴
        paint.setColor(Color.YELLOW);
        canvas.drawLine(space, 750, space, 731 / 4 * 2 - 100, paint);//Y轴
        paint.setColor(Color.GREEN);
        canvas.drawLine(space, 750, space, 731 / 4 * 3 - 100, paint);//Y轴
        paint.setColor(Color.BLUE);
        canvas.drawLine(space, 750, space, 731 / 4 * 4 - 100, paint);//Y轴
        //Y轴文字
        String[] arrays = new String[]{"a", "100", "差", "200", "凉", "300", "d", "400"};
        Paint ypaint = new Paint();
        ypaint.setColor(Color.GREEN);
        ypaint.setStrokeWidth(20);
        ypaint.setTextSize(35);
        for (int i = 1; i < arrays.length; i++) {
            canvas.drawText(arrays[i], space - 70, 731 / 7 * i, ypaint);
        }
        //X轴文字
        String[] arr = new String[]{"0", "100", "200", "300", "400", "500"};
        Paint xpaint = new Paint();
        ypaint.setColor(Color.BLUE);
        ypaint.setStrokeWidth(20);
        ypaint.setTextSize(35);
        for (int i = 1; i < arr.length; i++) {
            canvas.drawText(arr[i], (getWidth() - space) / 5 * i, getHeight() - 30, ypaint);
        }
        //点
        Paint o = new Paint();
        o.setColor(oc);
        o.setStyle(Paint.Style.FILL);
        //假数据
//        canvas.drawCircle(210, 476, 5, o);
//        canvas.drawCircle(306, 306, 5, o);
        //线
        Paint l = new Paint();
        l.setColor(color);
        l.setStrokeWidth(3);
        //canvas.drawLine(210, 476, 306, 306, l);
        //s随机点
        ew = new int[num][];
        for (int i = 0; i < num; i++) {
            Random random = new Random();
            //  int i = (int)(10+Math.random()*(20-10+1))
           // (数据类型)(最小值+Math.random()*(最大值-最小值+1))
            int y0 = (int)(50+Math.random()*(746-50+1));
            int x0 = ((getWidth()-space*2)/num*i+space+8);         // random.nextInt(505%(505-77+1)+77);
            ew [i]= new int[]{x0,y0};

        }
        for (int[]a:ew) {
            for (int j:a) {
                Log.e("10", "onDraw: "+j+"\n");
            }
        }
        //画点
        for (int i = 0; i < num; i++) {
            canvas.drawCircle(ew[i][0],ew[i][1],5,o);
        }
        //连线
        for (int i = 0; i < num -1; i++) {
        canvas.drawLine(ew[i][0],ew[i][1],ew[i+1][0],ew[i+1][1],l);
        }
        Log.e("1000", "onDraw: "+num );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                Log.e("123", "坐标：（" + x + "," + +y + "）");
                cakkBackStr.getx("" + x, y + "");
                cakkBackStr.getY("" + y);
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("123", "坐标：（" + x + "," + +y + "）");
                cakkBackStr.getx("" + x, y + "");
                cakkBackStr.getY("" + y);
                break;
        }
        return true;
    }

    public void getData(CakkBackStr backStr) {
        this.cakkBackStr = backStr;
    }
}
