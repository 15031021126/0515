package com.bawei.a0524;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;

public class AppUncaughtExceptionHandler000 implements Thread.UncaughtExceptionHandler{
   public static final String TAG="AppUncaughtExceptionHandler";
    private static AppUncaughtExceptionHandler000 appUncaughtExceptionHandler;
    private Context applicationContext;
    private Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
    private boolean ctags;

    private  AppUncaughtExceptionHandler000(){}
    //懒汉(线程安全)
     public  static synchronized  AppUncaughtExceptionHandler000 getInstance(){
         if(appUncaughtExceptionHandler==null){
             appUncaughtExceptionHandler = new AppUncaughtExceptionHandler000();
         }
         return appUncaughtExceptionHandler;
     }

    /**
     * 初始化捕获类
     *
     * @param context
     */
    public void init(Context context) {
        applicationContext = context.getApplicationContext();
        ctags = false;
        defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void uncaughtException(Thread t, Throwable e) {
         if (ctags){
             return;
         }
         ctags=true;
        Log.d(TAG, "uncaughtException:==== "+e.toString());
        //cd 或者 sp
         e.printStackTrace();
        try {
            Log.d(TAG, "getCrashReport:==== "+getCrashReport(e));
        } catch (PackageManager.NameNotFoundException e1) {
            e1.printStackTrace();
        }
        if(defaultUncaughtExceptionHandler!=null){
            defaultUncaughtExceptionHandler.uncaughtException(t, e);
        }
        Process.killProcess(Process.myPid());
        System.exit(0);
    }

    /**
     * 获取异常信息
     * @param ex
     * @return
     */
    private String getCrashReport(Throwable ex) throws PackageManager.NameNotFoundException {
        StringBuffer exceptionStr = new StringBuffer();
        PackageInfo pinfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);

        if (pinfo != null) {
            if (ex != null) {
                //app版本信息
                exceptionStr.append("App Version：" + pinfo.versionName);
                exceptionStr.append("_" + pinfo.versionCode + "\n");

                //手机系统信息
                exceptionStr.append("OS Version：" + Build.VERSION.RELEASE);
                exceptionStr.append("_");
                exceptionStr.append(Build.VERSION.SDK_INT + "\n");

                //手机制造商
                exceptionStr.append("Vendor: " + Build.MANUFACTURER+ "\n");

                //手机型号
                exceptionStr.append("Model: " + Build.MODEL+ "\n");

                String errorStr = ex.getLocalizedMessage();
                if (TextUtils.isEmpty(errorStr)) {
                    errorStr = ex.getMessage();
                }
                if (TextUtils.isEmpty(errorStr)) {
                    errorStr = ex.toString();
                }
                exceptionStr.append("Exception: " + errorStr + "\n");
                StackTraceElement[] elements = ex.getStackTrace();
                if (elements != null) {
                    for (int i = 0; i < elements.length; i++) {
                        exceptionStr.append(elements[i].toString() + "\n");
                    }
                }
            } else {
                exceptionStr.append("no exception. Throwable is null\n");
            }
            return exceptionStr.toString();
        } else {
            return "";
        }
    }

}
