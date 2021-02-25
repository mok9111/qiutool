package com.example.utitl.myinterface;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.utitl.R;
import com.example.utitl.utls.BindViews;
import com.example.utitl.utls.DeviceUtils;
import com.example.utitl.utls.InputMethodManager;
import com.example.utitl.utls.Md5Utils;
import com.example.utitl.utls.StatusBarUtil;


public class Abstracts {
    /*activity调用控件绑定*/
    public static void bindviewactivity(Activity footView, String shuju) {
        new BindViews(footView,shuju);
    }

    /*fragment调用控件绑定*/
    public static void bindviewfragment(View footView, Activity footViews, String shuju) {
        new BindViews(footView,footViews,shuju);
    }

    /*md5加密调用*/
    public static String Md5Utils(String Md5) {
      return Md5Utils.md5Decode32(Md5);
    }

    /* 标题栏沉浸效果调用 */
    public static void StatusBarUtil(Activity activity, @DrawableRes int drawableId) {
        new StatusBarUtil(activity, drawableId);
    }

    /*标题栏沉浸效果全屏调用*/
    public static void StatusBarUtilFull(Activity activity) {
        new StatusBarUtil(activity);
    }
    /*获取版本号versionCode版本名称name调用*/
    public static String DeviceUtils(Activity activity,String name) {
        return  DeviceUtils.Version(activity,name);
    }
    /*软键盘的控制调用*/
    public static void InputMethodManager(View view, Activity  context) {
        new InputMethodManager(view,context);
    }
    /*取中间图像调用*/
    public static void Glidecilcer(Activity activity,String url,@NonNull ImageView view) {
        RequestOptions options2 = new RequestOptions()
                .centerCrop()
                .fitCenter()
                .placeholder(R.drawable.ic_default_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(activity)
                .load(url)
                .apply(options2)
                .into(view);
    }
}
