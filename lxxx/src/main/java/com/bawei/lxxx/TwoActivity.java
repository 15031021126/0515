package com.bawei.lxxx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stx.xhb.xbanner.XBanner;

public class TwoActivity extends AppCompatActivity {

    private XBanner xxx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        xxx = findViewById(R.id.xxx);

    }
}
