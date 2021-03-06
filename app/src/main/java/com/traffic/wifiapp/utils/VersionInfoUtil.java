package com.traffic.wifiapp.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import com.traffic.wifiapp.common.WifiApplication;

/**
 * Created by ray on 2016/4/13.
 * 关于应用版本的一些信息
 */
public class VersionInfoUtil {

public static final int versionCode=getVersionCode(WifiApplication.getInstance());//版本号  14
public static final String versionName=getVersionName(WifiApplication.getInstance());//版本名 2.0.0
public static final boolean VierisonIsOver19=isVersionOver(19);//系统版本号

    /**
     * 判断系统api版本是否超过指定数字
     * */
    public static boolean isVersionOver(int code){
        if (Build.VERSION.SDK_INT >=code) {
            return true;
        }else {
           return false;
        }
    }


    /**
     * 获取版本信息 10
     * */
    public  static int getVersionCode(Context context) {
        PackageManager packageManager =context.getPackageManager();
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if(packInfo==null)return 0;
        return packInfo.versionCode;
    }

    /**
     *
     * 获取版本名 1.9.6
     * */
    public  static String getVersionName(Context context)  {
        PackageManager packageManager =context.getPackageManager();
        PackageInfo packInfo = null;
        try {
            packInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if(packInfo==null)return "1.0.0";
        return packInfo.versionName;
    }


}
