package com.example.assignmentone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // 用于Intent传递按钮索引的标识（全局常量）
    public static final String EXTRA_INDEX = "com.example.assignmentone.INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置当前Activity对应的布局文件
        setContentView(R.layout.activity_main);
    }

    /**
     * 按钮点击事件处理方法（与布局中android:onClick绑定）
     * 适配AGP 8.0+资源ID非final特性，使用if-else替代switch
     */
    public void onButtonClick(View view) {
        String toastMessage = "";
        int buttonIndex = -1;
        int clickedViewId = view.getId();

        // 根据点击的按钮ID，设置对应的提示语和索引
        if (clickedViewId == R.id.btn_facilities) {
            toastMessage = "Facilities clicked";
            buttonIndex = 0;
        } else if (clickedViewId == R.id.btn_events) {
            toastMessage = "Events clicked";
            buttonIndex = 1;
        } else if (clickedViewId == R.id.btn_clubs) {
            toastMessage = "Clubs clicked";
            buttonIndex = 2;
        } else if (clickedViewId == R.id.btn_support) {
            toastMessage = "Support clicked";
            buttonIndex = 3;
        }

        // 显示点击提示的Toast
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();

        // 跳转到DetailActivity，并传递当前按钮的索引
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(EXTRA_INDEX, buttonIndex);
        startActivity(detailIntent);
    }
}