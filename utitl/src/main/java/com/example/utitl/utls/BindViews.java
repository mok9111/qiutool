package com.example.utitl.utls;

import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/*
自动控件绑定与填充
 */
public class BindViews {
    public BindViews(Activity footView, String shuju) {
        bindviews(footView,shuju);
    }

    public BindViews(View footView,Activity footViews, String shuju) {
        fragmentbindviews(footView,footViews,shuju);
    }

    private  void bindviews(Activity footView, String shuju){
        try {
            JSONObject kindJson1 = new JSONObject(shuju);
            Iterator<String> it = kindJson1.keys();
            while (it.hasNext()) {
                String key = it.next();
                String value = kindJson1.getString(key);
                if (value.equals("null"))
                    value = "";
                int view_id = footView.getResources().getIdentifier(key, "id", footView.getPackageName());
                View view = footView.findViewById(view_id);
                if (view instanceof TextView) {

                    ((TextView) view).setText(value);
                } else if (view instanceof EditText) {
                    ((EditText) view).setText(value);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private  void fragmentbindviews(View footView,Activity footViews, String shuju){
        try {
            JSONObject kindJson1 = new JSONObject(shuju);
            Iterator<String> it = kindJson1.keys();
            while (it.hasNext()) {
                String key = it.next();
                String value = kindJson1.getString(key);
                if (value.equals("null"))
                    value = "";
                int view_id = footView.getResources().getIdentifier(key, "id", footViews.getPackageName());
                View view = footView.findViewById(view_id);
                if (view instanceof TextView) {

                    ((TextView) view).setText(value);
                } else if (view instanceof EditText) {
                    ((EditText) view).setText(value);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
