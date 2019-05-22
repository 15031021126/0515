package com.bawei.a0522;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyView aa;
    private Animation animation;
    private TextView tv;
    private Button cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        aa = findViewById(R.id.aa);
        tv = findViewById(R.id.tv);
        cc = findViewById(R.id.cc);
        aa.getData(new CakkBackStr() {
            @Override
            public void getx(String x,String y) {
                tv.setText("("+x+","+y+")");
            }

            @Override
            public void getY(String y) {

            }
        });
        animation = AnimationUtils.loadAnimation(this, R.anim.aa);
        cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cc.startAnimation(animation);

            }
        });
    }
}
