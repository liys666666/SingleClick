package com.liys.singleclick;

import android.util.Log;


/**
 * Created by liys on 2018/07/03.
 * Description:输出日志工具类
 */

public class LogUtils {
    //是否需要打印信息
    public static boolean isDebug = true;
    //打印信息的标识
    public static final String TAG = "66";

    public static void e(String msg) {
        if (isDebug) Log.e(TAG, msg);
    }
    public static void d(String msg) {
        if (isDebug) Log.d(TAG, msg);
    }
    public static void i(String msg) {
        if (isDebug) Log.i(TAG, msg);
    }
    public static void w(String msg) {
        if (isDebug) Log.w(TAG, msg);
    }
}
