package com.paowang.utils;

import android.util.Log;

public class DLog {

    private static final String TAG = "hmz";
    public static boolean isLog = true;

    public static void v(String tag, String msg) {
        if (isLog) {
            Log.v(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (isLog) {
            Log.d(tag, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (isLog) {
            Log.i(tag, msg);
        }
    }

    public static void d(String msg) {
        if (isLog) {
            Log.d(TAG, msg);
        }
    }

    public static void i(String msg) {
        if (isLog) {
            Log.i(TAG, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (isLog) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (isLog) {
            Log.e(tag, msg);
        }
    }

    public static void e(String tag, Throwable throwable) {
        if (isLog) {
            Log.e(tag, throwable.getMessage(), throwable);
        }
    }

    public static void i(String tag, String msg, Throwable throwable) {
        if (isLog) {
            Log.i(tag, msg, throwable);
        }
    }

    public static void w(String tag, String msg, Throwable throwable) {
        if (isLog) {
            Log.w(tag, msg, throwable);
        }
    }

    public static void e(String tag, String msg, Throwable throwable) {
        if (isLog) {
            Log.e(tag, msg, throwable);
        }
    }
}
