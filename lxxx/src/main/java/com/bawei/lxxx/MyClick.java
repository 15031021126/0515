package com.bawei.lxxx;

import android.content.Intent;

import java.util.ArrayList;

/*
 *@Auther:陈浩
 *@Date: 2019/5/21
 *@Time:9:30
 *@Description:${DESCRIPTION}
 * */public interface MyClick {
    void onClick(String url, ArrayList<String> bean,Intent intent);
    void onLongClick(String url, ArrayList<String> bean);
}
