package com.bawei.week3.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bawei.week3.R;
import com.bawei.week3.TwoActivity;

/*
 *@Auther:陈浩
 *@Date: 2019/5/25
 *@Time:9:13
 *@Description:${DESCRIPTION}
 * */public class Frag02 extends Fragment {

    private ImageView img;
    private ObjectAnimator animatorY;
    private ObjectAnimator xia;
    private AnimatorSet set;
    private AnimatorSet.Builder before;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag02, container, false);
        img = view.findViewById(R.id.img1);
        animatorY = ObjectAnimator.ofFloat(img, "rotationY", 360);
        xia = ObjectAnimator.ofFloat(img, "translationX", 0, 200f, -200);
        ObjectAnimator xxx = ObjectAnimator.ofFloat(img, "translationX", 50);
        ObjectAnimator aaa = ObjectAnimator.ofFloat(img, "rotation", 360);
        ObjectAnimator bbb = ObjectAnimator.ofFloat(img, "rotationX", 360);

        set = new AnimatorSet();
        set.setDuration(3000);
        before = set.play(animatorY).with(xia).with(aaa).with(bbb).before(xxx);

        view.findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                set.start();
                Toast.makeText(getActivity(), "aassss", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TwoActivity.class);
                startActivity(intent);
            }
        });
    }
}
