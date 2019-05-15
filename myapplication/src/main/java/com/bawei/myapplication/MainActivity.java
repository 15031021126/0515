package com.bawei.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }
        });
        Log.e("123", "主页面onCreate: ");
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("123", "主页面oonStart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("123", "主页面oonPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("123", "主页面oonRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("123", "主页面oonResume: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("123", "主页面oonDestroy: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("123", "主页面oonStop: ");
    }
}
