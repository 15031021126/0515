package com.bawei.a052project;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView dh;
    private SharedPreferences sp;
    private SharedPreferences.Editor edit;
    private Button button;
    int num = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dh = findViewById(R.id.dh);
        button = findViewById(R.id.button);
        sp = getSharedPreferences("one", MODE_PRIVATE);
        if (sp.getBoolean("k", false)) {
            Intent intent = new Intent(MainActivity.this, TwoActivity.class);
            // startActivity(intent);
            //return;
        }
        edit = sp.edit();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
                finish();
                return;
            }
        });
        handler.sendEmptyMessageDelayed(0, 1000);
        ObjectAnimator rotation1 = ObjectAnimator.ofFloat(dh, "rotation", 360 * 2);
        ObjectAnimator translationY = ObjectAnimator.ofFloat(dh, "translationY", 200);
        ObjectAnimator translationX1 = ObjectAnimator.ofFloat(dh, "translationX", 0, 100, 0);
        ObjectAnimator translationX2 = ObjectAnimator.ofFloat(dh, "translationX", 0);
        ObjectAnimator alpha = ObjectAnimator.ofFloat(dh, "alpha", 0.1f);
        AnimatorSet set = new AnimatorSet();
        AnimatorSet.Builder play = set.play(rotation1).with(translationY).before(alpha);

        // play.after(translationY);
        play.with(translationX2);
        play.before(translationX1);
        set.setDuration(3000);
        set.start();

        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                edit.putBoolean("k", true);
                edit.commit();
                Intent intent = new Intent(MainActivity.this, TwoActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                num--;
                button.setText(num + "S");
                if (num == 0) {
                    button.setText("正在跳转...");
//                    Intent intent = new Intent(MainActivity.this, TwoActivity.class);
//                    startActivity(intent);
                    finish();
                    return;
                }
                handler.sendEmptyMessageDelayed(0, 1000);
            }

        }
    };
}
