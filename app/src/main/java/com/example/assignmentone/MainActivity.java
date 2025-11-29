package com.example.assignmentone; // 确保包名与你的项目一致

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Intent传递索引的键
    public static final String EXTRA_INDEX = "com.example.assignmentone.INDEX";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 按钮点击事件处理（用if-else替代switch，适配AGP 8.0+资源ID非final）
     */
    public void onButtonClick(View view) {
        String message = "";
        int index = -1;
        int viewId = view.getId();

        // 用if-else替代switch（解决资源ID非final的问题）
        if (viewId == R.id.btn_facilities) {
            message = "Facilities clicked";
            index = 0;
        } else if (viewId == R.id.btn_events) {
            message = "Events clicked";
            index = 1;
        } else if (viewId == R.id.btn_clubs) {
            message = "Clubs clicked";
            index = 2;
        } else if (viewId == R.id.btn_support) {
            message = "Support clicked";
            index = 3;
        }

        // 显示Toast提示
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        // 跳转到DetailActivity（确保DetailActivity已创建）
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(EXTRA_INDEX, index);
        startActivity(intent);
    }
}