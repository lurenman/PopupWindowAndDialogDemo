package com.example.lurenman.popupwindowanddialogdemo.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.lurenman.popupwindowanddialogdemo.R;

/**
 * @author: baiyang.
 * Created on 2017/11/10.
 * 这种自定义背景会有点问题,弹出速度感觉也慢些 这个跟主题themeResId有关
 */

public class CustomDialog extends Dialog {
    private static final String TAG = "CustomDialog";
    private LinearLayout ll_qx;
    private LinearLayout ll_qd;
    private View.OnClickListener mItemsOnClick;

    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    //下面两种构造方法是我加的
    public CustomDialog(@NonNull Context context, View.OnClickListener itemsOnClick) {
        super(context);
        mItemsOnClick = itemsOnClick;
    }

    public CustomDialog(@NonNull Context context, @StyleRes int themeResId, View.OnClickListener itemsOnClick) {
        super(context, themeResId);
        mItemsOnClick = itemsOnClick;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popupwindow_fangdialog);
        Log.e(TAG, "onCreate-----");
        ll_qx = (LinearLayout) findViewById(R.id.ll_qx);
        ll_qd = (LinearLayout) findViewById(R.id.ll_qd);
        if (mItemsOnClick != null) {
            ll_qx.setOnClickListener(mItemsOnClick);
            ll_qd.setOnClickListener(mItemsOnClick);
        }
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.e(TAG, "onDetachedFromWindow-----");
    }
}
