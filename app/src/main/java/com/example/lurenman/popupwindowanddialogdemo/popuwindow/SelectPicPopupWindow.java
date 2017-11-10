package com.example.lurenman.popupwindowanddialogdemo.popuwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.lurenman.popupwindowanddialogdemo.R;

public class SelectPicPopupWindow extends PopupWindow {
    private static final String TAG = "SelectPicPopupWindow";

    private LinearLayout btn_take_photo, btn_pick_photo, btn_cancel;
    private View mMenuView;

    public SelectPicPopupWindow(Context context, OnClickListener itemsOnClick) {
        super(context);

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.popupwindow_selectpic, null);

        btn_take_photo = (LinearLayout) mMenuView
                .findViewById(R.id.btn_take_photo);
        btn_pick_photo = (LinearLayout) mMenuView
                .findViewById(R.id.btn_pick_photo);
        btn_cancel = (LinearLayout) mMenuView.findViewById(R.id.btn_cancel);

        btn_take_photo.setOnClickListener(itemsOnClick);
        btn_pick_photo.setOnClickListener(itemsOnClick);

        btn_cancel.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        // 设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        this.setAnimationStyle(R.style.AnimBottom);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        mMenuView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                int height = mMenuView.findViewById(R.id.pop_layout).getTop();
                int y = (int) event.getY();
                Log.e(TAG, "onTouch height:" + height);
                Log.e(TAG, "onTouch getY():" + y);
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });
        // // 添加按钮监听
        // btn_cancel.setOnClickListener(this);
        // btn_pick_photo.setOnClickListener(this);
        // btn_take_photo.setOnClickListener(this);
    }

}
