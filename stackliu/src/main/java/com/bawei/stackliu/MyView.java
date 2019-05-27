package com.bawei.stackliu;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/*
 *@Auther:陈浩
 *@Date: 2019/5/24
 *@Time:21:10
 *@Description:${DESCRIPTION}
 * */public class MyView extends LinearLayout implements TextWatcher {

    public MyView(Context context) {
        super(context);
    }

    public MyView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.ssk, this, true);
        EditText edt =
                view.findViewById(R.id.edt);
        view.findViewById(R.id.bt1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击了", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
