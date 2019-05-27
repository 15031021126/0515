package com.bawei.chenhao0527.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.chenhao0527.R;

/*
 *@Auther:陈浩
 *@Date: 2019/5/27
 *@Time:8:46
 *@Description:${动画}
 * */public class Frag02 extends Fragment {

    private TextView tv;
    private AnimatorSet set;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag02, container, false);
        tv = view.findViewById(R.id.tv);
        ObjectAnimator a = ObjectAnimator.ofFloat(tv, "translationY", 0, 370, 0);//下
        ObjectAnimator b = ObjectAnimator.ofFloat(tv, "translationY", 0, -370, 0);//上
        ObjectAnimator c = ObjectAnimator.ofFloat(tv, "rotationX", 0, -370, 0);//上
        ObjectAnimator f = ObjectAnimator.ofFloat(tv, "rotationY", 0, -370, 0);//上
        set = new AnimatorSet();
        set.play(a).with(c).before(b).with(f);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set.setDuration(6000);
                set.start();
            }
        });
        return view;
    }

}
