package com.bawei.stackliu;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private MyStackView a;
    private ArrayList<String> list;
    private EditText text;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        a = findViewById(R.id.a);
//        text = findViewById(R.id.edt);
//        imageView = findViewById(R.id.bt1);
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String trim = text.getText().toString().trim();
//                if (trim.length() == 0) {
//                    return;
//                }
//                TextView button = new TextView(MainActivity.this);
//                button.setText(trim);
//                button.setBackgroundColor(Color.GREEN);
//                a.addView(button);
//            }
//        });
//        list = new ArrayList<>();
//
//        list.add("iopsps");
//        list.add("iosssssspsps");
//        list.add("iopsadasps");
//        list.add("ips");
//        list.add("ssssssssssssssssssssss");
//        for (int i = 0; i < list.size(); i++) {
//            TextView button = new TextView(this);
//            button.setText(list.get(i));
//            a.addView(button);
//        }


        Log.e("123", "onCreate: " + list);

//        Intent intent = new Intent(this, TwoActivity.class);
//        startActivity(intent);
    }
}
