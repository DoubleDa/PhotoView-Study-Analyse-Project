package com.dyx.pp.library.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    /**
     * 获取终端SDK版本
     *
     * @return
     */
    public static int getTerminalSDKVersion() {
        // TODO Auto-generated method stub
        return Build.VERSION.SDK_INT;
    }

    /**
     * 获取当前版本
     *
     * @param cont
     * @return
     */
    public static String getVersion(Context cont) {
        PackageManager packageManager = cont.getPackageManager();
        try {
            PackageInfo info = packageManager.getPackageInfo(cont.getPackageName(), 0);
            return info != null ? info.versionName : "";
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    /**
     * 获取当前版本号 code
     *
     * @param
     * @return
     */
    public static int getVersionCode(Context mContext) {
        int versionCode = 1;
        try {
            PackageInfo info = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);
            versionCode = info.versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace(System.err);
        }
        return versionCode;
    }

    /**
     * 获取 IMSI id码 （默认88888888888）
     *
     * @param cont
     * @return
     */
    public static String getImsiid(Context cont) {
        TelephonyManager tphoneMamager = (TelephonyManager) cont.getSystemService(Context.TELEPHONY_SERVICE);
        return tphoneMamager.getSubscriberId() != null ? tphoneMamager.getSubscriberId() : "88888888888";
    }

    /**
     * 获取设备码（默认88888888888）
     *
     * @param cont
     * @return
     */
    public static String getDeviceid(Context cont) {
        TelephonyManager tphoneMamager = (TelephonyManager) cont.getSystemService(Context.TELEPHONY_SERVICE);

        return tphoneMamager.getDeviceId() != null ? tphoneMamager.getDeviceId() : "88888888888";
    }

    /**
     * 屏幕的宽dp
     *
     * @param cont
     * @return
     */
    public static int getWindowWidth(Context cont) {
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager wm = (WindowManager) cont.getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;// 屏幕的宽dp
    }

    /**
     * // 屏幕的高dp
     *
     * @param cont
     * @return
     */
    public static int getWindowHeight(Activity cont) {
        DisplayMetrics metrics = new DisplayMetrics();
        cont.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;// 屏幕的高dp
    }

    /**
     * 获取屏幕比例
     *
     * @param cont
     * @return
     */
    public static String getWindowWH(Context cont) {
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) cont).getWindowManager().getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels; // 屏幕宽度（像素）
        int height = metric.heightPixels; // 屏幕高度（像素）
        return width + "*" + height;
    }

    /**
     * 显示输入法
     *
     * @param cont
     */
    public static void showSoftInput(Activity cont) {
        cont.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
    }

    /**
     * 隐藏输入法
     *
     * @param cont
     */
    public static void hideSoftInput(Activity cont) {
        cont.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN | WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }


    /**
     * 若账号密码登陆接口下发msg中包含Unicode码，将其转换为可读的字符输出
     *
     * @param read
     * @return
     * @author wwei
     */
    public static String transUnicodeToString(String read) {
        // TODO Auto-generated method stub
        Pattern mPattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher mMatcher = mPattern.matcher(read);
        char tempChar;
        while (mMatcher.find()) {
            tempChar = (char) Integer.parseInt(mMatcher.group(2), 16);
            read = read.replace(mMatcher.group(1), tempChar + "");
        }
        return read;
    }

    public static String formatDistance(double param) {
        String distance = "";
        DecimalFormat df = new DecimalFormat("#.#");
        if (param < 1 && param >= 0) {
            param = param * 1000;
            if (param <= 100) {
                distance = "100米内";
            } else {
                distance = df.format(param) + "米内";
            }
        } else {
            distance = df.format(param) + "公里内";
        }
        return distance;
    }

    /**
     * 两次点击的时间间隔
     */
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 10000) {
            lastClickTime = time;
            return false;
        }
        return true;
    }

    public static void dialPhoneNumber(String phoneNumber, Context context) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }

    /**
     * 分页使用
     *
     * @param cou 总条目
     * @param pag 每页条目数量
     * @return
     */
    private static int getPageSize(int cou, int pag) {
        if (cou % pag == 0) {
            return cou / pag;
        } else {
            return cou / pag + 1;
        }
    }

    /**
     * //截取数字
     *
     * @param content
     * @return
     */
    public static String getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }
}