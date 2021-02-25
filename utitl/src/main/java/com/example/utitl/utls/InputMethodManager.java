package com.example.utitl.utls;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * 软键盘的控制
 * **/
public class InputMethodManager {

    public InputMethodManager( View view, Activity  context) {
        setupUI(view,context);
    }

    //软键盘已弹出
    private    void setupUI(final View view,final Activity  context) {

        //Set up touch listener for non-text box views to hide keyboard.
        if (view == null) {
            return;
        }
        if(!(view instanceof EditText)) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    android.view.inputmethod.InputMethodManager inputMethodManager = (android.view.inputmethod.InputMethodManager)  context.getSystemService(Activity.INPUT_METHOD_SERVICE);
                    if (inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0)) {
                        inputMethodManager.hideSoftInputFromWindow(context.getWindow().getDecorView().getRootView().getWindowToken(), 0);
//                        baseinit();
                        return true;
                        //软键盘已弹出
                    } else {
                        return false;
                        //软键盘未弹出
                    }
                }
            });
        }
        //If a layout container, iterate over children and seed recursion.
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                View innerView = ((ViewGroup) view).getChildAt(i);
                setupUI(innerView,context);
            }
        }

        SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(view);
        softKeyboardStateHelper.addSoftKeyboardStateListener(new SoftKeyboardStateHelper.SoftKeyboardStateListener() {
            @Override
            public void onSoftKeyboardOpened(int keyboardHeightInPx) {
                //键盘打开
            }
            @Override
            public void onSoftKeyboardClosed() {
                //键盘关闭
//                baseinit();
            }
        });
    }

}
