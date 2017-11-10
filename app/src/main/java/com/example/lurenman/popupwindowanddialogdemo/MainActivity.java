package com.example.lurenman.popupwindowanddialogdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lurenman.popupwindowanddialogdemo.activity.DialogActivity;
import com.example.lurenman.popupwindowanddialogdemo.activity.PopupWindowActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tv_popupwindow;
    private TextView tv_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_popupwindow = (TextView) findViewById(R.id.tv_popupwindow);
        tv_dialog = (TextView) findViewById(R.id.tv_dialog);
        tv_popupwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PopupWindowActivity.class);
                startActivity(intent);
            }
        });
        tv_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }
}
