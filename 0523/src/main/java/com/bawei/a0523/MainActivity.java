package com.bawei.a0523;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.a);
        //animation = AnimationUtils.loadAnimation(this, R.anim.ann);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //淡出
                ObjectAnimator alpha = ObjectAnimator.ofFloat(img, "alpha", 1f, 0.1f);
                //旋转
                ObjectAnimator rotation = ObjectAnimator.ofFloat(img, "rotation", 360f);
                ObjectAnimator translationX = ObjectAnimator.ofFloat(img, "translationY", 300);
                //x轴扩张
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(img, "scaleX", 2);
                //逆时针旋转
                ObjectAnimator rotation2 = ObjectAnimator.ofFloat(img, "rotation", -360f);
                ObjectAnimator x1 = ObjectAnimator.ofFloat(img, "translationX", 200);
                ObjectAnimator x2 = ObjectAnimator.ofFloat(img, "translationX", -200);
                //结合
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(rotation).with(translationX).before(alpha).after(scaleX).before(x1).before(x2).before(rotation2);
                animatorSet.setDuration(2000);
                animatorSet.start();
            }
        });

    }
}
