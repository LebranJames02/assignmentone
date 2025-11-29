package com.example.assignmentone; // 与MainActivity同包名

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // 获取MainActivity传递的索引
        int index = getIntent().getIntExtra(MainActivity.EXTRA_INDEX, -1);
        if (index == -1) {
            finish(); // 无有效索引则关闭页面
            return;
        }

        // 从arrays.xml读取数据（需确保arrays.xml已存在）
        String[] titles = getResources().getStringArray(R.array.string_array_titles);
        String[] contents = getResources().getStringArray(R.array.string_array_content);
        String[] imageNames = getResources().getStringArray(R.array.string_array_images);

        // 填充标题
        TextView tvTitle = findViewById(R.id.tv_title);
        tvTitle.setText(titles[index]);

        // 填充内容
        TextView tvContent = findViewById(R.id.tv_content);
        tvContent.setText(contents[index]);

        // 填充图片（动态获取资源ID）
        String imageName = imageNames[index].trim();
        int imageResId = getResources().getIdentifier(
                imageName, "drawable", getPackageName()
        );
        ImageView ivDetail = findViewById(R.id.iv_detail);
        ivDetail.setImageResource(imageResId);
        ivDetail.setContentDescription(titles[index]); // 无障碍描述
    }
}