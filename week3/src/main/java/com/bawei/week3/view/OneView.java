package com.bawei.week3.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.bawei.week3.R;

import java.util.ArrayList;
import java.util.Random;

/*
 *@Auther:陈浩
 *@Date: 2019/5/25
 *@Time:9:31
 *@Description:${DESCRIPTION}
 * */public class OneView extends View {

    private int[][] ew;
    private int n;
    private int bcolor;
    private int lcolor;
    private int ocolor;

    public OneView(Context context) {
        this(context, null);
    }

    public OneView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OneView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /* //读取属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        //读取数量
        color = typedArray.getColor(R.styleable.MyView_linecolor, Color.BLACK);
        oc = typedArray.getColor(R.styleable.MyView_ocolor, Color.BLACK);
        num = typedArray.getInteger(R.styleable.MyView_num, 5);
        back = typedArray.getColor(R.styleable.MyView_back, Color.GRAY);
        //释放资源
        typedArray.recycle();*/
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.OneView);
        n = typedArray.getInteger(R.styleable.OneView_num, 5);
        bcolor = typedArray.getColor(R.styleable.OneView_bcolor, Color.BLACK);
        lcolor = typedArray.getColor(R.styleable.OneView_lcolor, Color.WHITE);
        ocolor = typedArray.getColor(R.styleable.OneView_Ocolor, Color.WHITE);
        typedArray.recycle();
        setBackgroundColor(bcolor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String[] strings = new String[]{"500", "差", "400", "凉", "300", "优", "200", "好", "100", "0"};
        String[] list = new String[]{"0", "100", "200", "300", "400", "500"};
        int num = n;
        int space = 80;
        Paint paintX = new Paint();
        paintX.setColor(Color.WHITE);
        paintX.setStrokeWidth(5);
        canvas.drawLine(space, getHeight() - space, getWidth() - 50, getHeight() - space, paintX);
        Paint paintY = new Paint();
        paintY.setColor(Color.GREEN);
        paintY.setStrokeWidth(5);
        Paint paintText = new Paint();
        paintText.setTextSize(30);
        paintText.setColor(Color.WHITE);
        for (int i = 1; i < strings.length; i++) {

            canvas.drawText(strings[i], space - 60, (getHeight() - space) / 9 * i, paintText);
        }
        canvas.drawLine(space, getHeight() - space, space, space, paintY);
        //paintY.setColor(Color.RED);
        //canvas.drawLine(space, space, space, space+200, paintY);
        paintY.setColor(Color.BLUE);
        canvas.drawLine(space, space, space, space + 450, paintY);
        paintY.setColor(Color.YELLOW);
        canvas.drawLine(space, space, space, space + 320, paintY);
        paintY.setColor(Color.RED);
        canvas.drawLine(space, space, space, space + 180, paintY);

        for (int i = list.length - 1; i > 0; i--) {

            canvas.drawText(list[i], (getWidth() - space) / 5 * i, getHeight() - 30, paintText);
        }

        //画点

        String[][] arr = new String[num][];
        ew = new int[num][];
        for (int i = 0; i < num; i++) {
            Random random = new Random();
            int y = random.nextInt((getHeight() - space * 2)) + space;
            int x = ((getWidth() - space - 30)) / num * i + space + 10;
            ew[i] = new int[]{x, y};
        }
        Paint o = new Paint();
        o.setColor(ocolor);
        o.setStyle(Paint.Style.FILL);
        //画点
        for (int i = 0; i < num; i++) {
            canvas.drawCircle(ew[i][0], ew[i][1], 5, o);

        }
        Paint l = new Paint();
        l.setColor(lcolor);
        l.setStrokeWidth(5);
        //划线
        for (int i = 0; i < num - 1; i++) {
            canvas.drawLine(ew[i][0], ew[i][1], ew[i + 1][0], ew[i + 1][1], l);
        }
        l.setDither(true);
        l.setAntiAlias(true);

    }


}
