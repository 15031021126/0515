package com.bawei.a0524;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String str = null;
        String[] split = str.split(",");
        Toast.makeText(this, "程序崩溃", Toast.LENGTH_SHORT).show();

    }
}
