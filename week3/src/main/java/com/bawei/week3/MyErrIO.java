package com.bawei.week3;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;

/*
 *@Auther:陈浩
 *@Date: 2019/5/26
 *@Time:19:53
 *@Description:${DESCRIPTION}
 * */public class MyErrIO implements Thread.UncaughtExceptionHandler {

    private Context context;
    private static MyErrIO errIO;

    public MyErrIO(Context context) {
        this.context = context;
    }

    public synchronized static MyErrIO getInstance(Context context) {
        if (errIO == null) {
            errIO = new MyErrIO(context);
        }
        return errIO;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        String message = e.getMessage();
        String localizedMessage = e.getLocalizedMessage();
        Log.e("123", "uncaughtException: " + message + "\n" + localizedMessage + "\n" + Build.MODEL + "\n" + Build.MANUFACTURER);
        context.startActivity(context.getPackageManager().getLaunchIntentForPackage(context.getPackageName()));
        Process.killProcess(Process.myPid());
    }
}
