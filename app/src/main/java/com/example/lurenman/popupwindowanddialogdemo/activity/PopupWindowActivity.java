package com.example.lurenman.popupwindowanddialogdemo.activity;

import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lurenman.popupwindowanddialogdemo.R;
import com.example.lurenman.popupwindowanddialogdemo.popuwindow.SelectFangDialogPopupWindnow;
import com.example.lurenman.popupwindowanddialogdemo.popuwindow.SelectPicPopupWindow;

/**
 * @author: baiyang.
 * Created on 2017/11/10.
 */

public class PopupWindowActivity extends BaseActivity {
    private Button bt_selectedPic;
    private Button bt_fang_dialog;
    private Button bt_showPopupWindow;
    private SelectPicPopupWindow selectWindowPic;
    private SelectFangDialogPopupWindnow selectFangDialog;
    //提示添加桌面快捷键的
    private PopupWindow mPopupWindow;

    @Override
    protected void initViews() {

        setContentView(R.layout.activity_popupwindow);
        bt_selectedPic = (Button) findViewById(R.id.bt_selectedPic);
        bt_fang_dialog = (Button) findViewById(R.id.bt_fang_dialog);
        bt_showPopupWindow = (Button) findViewById(R.id.bt_showPopupWindow);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        bt_selectedPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectWindowPic = new SelectPicPopupWindow(getApplicationContext(), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()) {
                            case R.id.btn_take_photo:
                                //上传
                                // selectWindowPic.dismiss();
                                Toast.makeText(getApplicationContext(), "拍摄", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.btn_pick_photo:
                                // selectWindowPic.dismiss();
                                Toast.makeText(getApplicationContext(), "从相册选择照片", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    }
                });
                //这个展示在哪都无所谓了
                selectWindowPic.showAtLocation(PopupWindowActivity.this.findViewById(R.id.main),
                        Gravity.CENTER, 0, 0);
            }
        });
        bt_fang_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectFangDialog = new SelectFangDialogPopupWindnow(getApplicationContext(), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (view.getId()) {
                            case R.id.ll_qx:
                                selectFangDialog.dismiss();
                                break;
                            case R.id.ll_qd:
                                selectFangDialog.dismiss();
                                Toast.makeText(getApplicationContext(), "选择成功", Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                    }
                });
                selectFangDialog.showAtLocation(PopupWindowActivity.this.findViewById(R.id.main),
                        Gravity.CENTER, 0, 0);
            }
        });
        bt_showPopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupWindow(view);
            }
        });
    }

    private void showPopupWindow(View view) {
        final View popupView = View.inflate(getApplicationContext(), R.layout.popupwindow_layout,
                null);
        TextView tv_pop_zdl = (TextView) popupView.findViewById(R.id.tv_pop_zdl);

        tv_pop_zdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mPopupWindow) {
                    mPopupWindow.dismiss();
                }
            }
        });

        mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable());
        mPopupWindow.showAsDropDown(view, -view.getWidth() / 2, 0);
        //动画设置
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(400);
        alphaAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation
                .RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(400);
        scaleAnimation.setFillAfter(true);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        popupView.startAnimation(animationSet);
    }

    @Override
    protected void loadData() {

    }
}
