package com.example.lurenman.popupwindowanddialogdemo.popuwindow;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.lurenman.popupwindowanddialogdemo.R;

/**
 * @author: baiyang.
 * Created on 2017/11/10.
 */

public class SelectFangDialogPopupWindnow extends PopupWindow {
    private View mMenuView;
    private LinearLayout ll_qx;
    private LinearLayout ll_qd;


    public SelectFangDialogPopupWindnow(Context context,View.OnClickListener itemsOnClick) {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mMenuView = inflater.inflate(R.layout.popupwindow_fangdialog, null);
        ll_qx=(LinearLayout) mMenuView.findViewById(R.id.ll_qx);
        ll_qd=(LinearLayout) mMenuView.findViewById(R.id.ll_qd);

        ll_qx.setOnClickListener(itemsOnClick);
        ll_qd.setOnClickListener(itemsOnClick);

        // 设置SelectPicPopupWindow的View
        this.setContentView(mMenuView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 设置SelectPicPopupWindow弹出窗体动画效果
        //this.setAnimationStyle(R.style.AnimBottom);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        // 设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);



    }
}
