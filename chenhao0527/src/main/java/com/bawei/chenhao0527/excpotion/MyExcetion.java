package com.bawei.chenhao0527.excpotion;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;

/*
 *@Auther:陈浩
 *@Date: 2019/5/27
 *@Time:8:57
 *@Description:${异常处理}
 * */public class MyExcetion implements Thread.UncaughtExceptionHandler {

    private Context context;
    private static MyExcetion excetion;

    MyExcetion(Context context) {
        this.context = context;
    }

    public static MyExcetion getInstance(Context context) {
        if (excetion == null) {
            excetion = new MyExcetion(context);
        }
        return excetion;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        String message = e.getMessage();
        String localizedMessage = e.getLocalizedMessage();
        Log.e("123", "错误日志: " + message + "\n" + "错误类型" + localizedMessage + "\n" + "手机型号" + Build.MODEL + "\n" + "手机品牌" + Build.MANUFACTURER);
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()));
        Process.killProcess(Process.myPid());
    }
}
