package com.bawei.week3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bawei.week3.view.TwoView;

import java.util.ArrayList;

public  class TwoActivity extends AppCompatActivity {

    private TwoView twoView;
    private ArrayList<String> strings;

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        twoView = findViewById(R.id.cc);
        strings = new ArrayList<>();
        strings.add("a");
        strings.add("a01424442");
        strings.add("a0000000000042");
        strings.add("a4244444444444");
        strings.add("a40000");
        strings.add("a424452");
        for (int i = 0; i < strings.size(); i++) {
            Button button = new Button(TwoActivity.this);
            button.setText(strings.get(i));
            twoView.addView(button);
            Button button2 = new Button(TwoActivity.this);
            button2.setText("点击泵困");
            String[] arr = new String[1];
            for (int j = 0; j < 5; j++) {
                button.setText(arr[i]);
            }
        }


    }
}
