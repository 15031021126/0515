package com.bawei.a0524;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;

/*
 *@Auther:陈浩
 *@Date: 2019/5/24
 *@Time:11:56
 *@Description:${DESCRIPTION}
 * */public class AppUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private static AppUncaughtExceptionHandler appUncaughtExceptionHandler;
    private Context applicationContext;

    private AppUncaughtExceptionHandler(Context context) {
        context = applicationContext;

    }

    public static synchronized AppUncaughtExceptionHandler getInstance(Context context) {
        if (appUncaughtExceptionHandler == null) {
            appUncaughtExceptionHandler = new AppUncaughtExceptionHandler(context);
        }
        return appUncaughtExceptionHandler;
    }


    @Override
    public void uncaughtException(Thread t, Throwable e) {
        long id = t.getId();
        String message = e.getMessage();
        String localizedMessage = e.getLocalizedMessage();
        //PackageInfo info = applicationContext.getPackageManager().getPackageArchiveInfo(applicationContext.getPackageName(), 0);
        StringBuffer buffer = new StringBuffer();
      // buffer.append("info.versionName " + info.versionName);
       // buffer.append("info.versionName " + info.versionCode);
        Log.e("123", "-------------------1--------------------");
        Log.e("123", "exciption------:=----- " + id);
        Log.e("123", "Message:--------=------- " + message);
        Log.e("123", "localizedMessage:----------= " + localizedMessage);
        Log.e("123", "------------------手机系统信息---------------------" + Build.VERSION.RELEASE + "\n" + Build.VERSION.SDK_INT);
        e.printStackTrace();
        Log.e("123", "-------------------手机型号--------------------" + Build.MODEL);
        //铺货到要做的事情
        Log.e("123", "-------------------手机制造商--------------------" + Build.MANUFACTURER);

        Log.e("123", "-------------------app版本信息--------------------" + buffer);
        applicationContext.startActivity(applicationContext.getPackageManager().getLaunchIntentForPackage(applicationContext.getPackageName()));
        android.os.Process.killProcess(android.os.Process.myPid());

    }
}
