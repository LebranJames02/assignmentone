package com.example.assignmentone;

import android.content.Intent; // 已导入Intent相关类
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // 用于Intent传递按钮索引的全局常量标识
    public static final String EXTRA_INDEX = "com.example.assignmentone.INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 按钮点击事件：处理Toast提示 + Intent跳转+数据传递
     */
    public void onButtonClick(View view) {
        String toastMessage = "";
        int buttonIndex = -1;
        int clickedViewId = view.getId();

        // 根据按钮ID匹配提示语与索引
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

        // 显示点击提示
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show();

        // Intent跳转至DetailActivity + 传递按钮索引数据
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(EXTRA_INDEX, buttonIndex); // 传递索引数据
        startActivity(detailIntent); // 启动DetailActivity
    }
}