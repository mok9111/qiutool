package com.example.utitl.utls;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.Locale;
import java.util.TimeZone;

/**
 *获取版本
 **/
public class DeviceUtils {

	public static String Version(Context context,String name) {
	   if(name.equals("name"))
			return 	getVersionName(context);
	   else
			return getVersionCode(context)+"";
	}

	private static String getVersionName(Context context) {
	    return getPackageInfo(context).versionName;
	}



	public static String getTimeZone() {
		TimeZone tz = TimeZone.getDefault();
		return tz.getID();
	}

	 
	//版本号
	private static int getVersionCode(Context context) {
	    return getPackageInfo(context).versionCode;
	}
	 
	private static PackageInfo getPackageInfo(Context context) {
	    PackageInfo pi = null;
	 
	    try {
	        PackageManager pm = context.getPackageManager();
	        pi = pm.getPackageInfo(context.getPackageName(),
	                PackageManager.GET_CONFIGURATIONS);
	 
	        return pi;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return pi;
	}

	public static String getSystemLanguage(Context context) {
		Locale locale = context.getResources().getConfiguration().locale;
		String language = locale.getLanguage();
		if (language.endsWith("zh"))
			return "ZH";
		else
			return "EN";
	}

	public static String getMetadata(Context context, String name) {
		try {
			ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(
					context.getPackageName(), PackageManager.GET_META_DATA);
			if (appInfo.metaData != null) {
				return appInfo.metaData.getString(name);
			}
		} catch (PackageManager.NameNotFoundException e) {
// if we can’t find it in the manifest, just return null
		}

		return null;
	}




}
