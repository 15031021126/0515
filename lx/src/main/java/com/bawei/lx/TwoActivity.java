package com.bawei.lx;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TwoActivity extends AppCompatActivity {

    private ImageView img2;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        img2 = findViewById(R.id.img2);
        tv2 = findViewById(R.id.tv2);
        findViewById(R.id.tt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        String a = intent.getStringExtra("a");
        String b = intent.getStringExtra("b");
        Glide.with(TwoActivity.this).load(b).into(img2);
        tv2.setText(a);
    }
}
