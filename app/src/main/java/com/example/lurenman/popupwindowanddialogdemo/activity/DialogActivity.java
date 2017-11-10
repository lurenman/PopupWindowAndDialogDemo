package com.example.lurenman.popupwindowanddialogdemo.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lurenman.popupwindowanddialogdemo.R;
import com.example.lurenman.popupwindowanddialogdemo.dialog.CustomDialog;

/**
 * @author: baiyang.
 * Created on 2017/11/10.
 */

public class DialogActivity extends BaseActivity {
    private Button bt_dialog;
    private Button bt_customdialog;
    private CustomDialog customDialog;
    private Button bt_customdialog1;

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_dialog);
        bt_dialog = (Button) findViewById(R.id.bt_dialog);
        bt_customdialog = (Button) findViewById(R.id.bt_customdialog);
        bt_customdialog1 = (Button) findViewById(R.id.bt_customdialog1);
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initEnvent() {
        super.initEnvent();
        bt_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setMessage("基本的AlertDialog");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "嗷嗷嗷", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                //这个就是最左边的那个按钮
                builder.setNeutralButton("ads", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                // builder.setCancelable(false);//设置这个只有点击按钮才能取消，点返回键无效果
                AlertDialog dialog = builder.show();

            }
        });
        bt_customdialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //记住这个android.R.style.Theme_Translucent_NoTitleBar 这个很重要
               customDialog=new CustomDialog(mContext,android.R.style.Theme_Translucent_NoTitleBar ,new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       switch (view.getId()) {
                           case R.id.ll_qx:
                               customDialog.dismiss();
                               break;
                           case R.id.ll_qd:
                               Toast.makeText(getApplicationContext(), "选择成功", Toast.LENGTH_SHORT).show();
                               customDialog.dismiss();
                               break;
                           default:
                               break;
                       }
                   }
               });
                //这块一定不要忘了
                customDialog.show();
            }
        });
        bt_customdialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog lDialog = new Dialog(mContext, android.R.style.Theme_Translucent_NoTitleBar);
                lDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                lDialog.setContentView(R.layout.popupwindow_fangdialog);
                LinearLayout ll_qx = (LinearLayout)lDialog.findViewById(R.id.ll_qx);
                LinearLayout ll_qd = (LinearLayout)lDialog.findViewById(R.id.ll_qd);
                ll_qx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lDialog.dismiss();
                    }
                });
                ll_qd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lDialog.dismiss();
                        Toast.makeText(getApplicationContext(), "选择成功", Toast.LENGTH_SHORT).show();
                    }
                });
                lDialog.show();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
