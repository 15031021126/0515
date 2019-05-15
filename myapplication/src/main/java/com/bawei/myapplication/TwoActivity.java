package com.bawei.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        Log.e("123", "onCreate: " );
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e("123", "onStart: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("123", "onPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("123", "onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("123", "onResume: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("123", "onDestroy: " );
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("123", "onStop: " );
    }
}
