// app/java/.../DetailActivity.java
package com.example.assignment1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.ArrayRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        int idx = getIntent().getIntExtra("idx", 0);

        String[] titles = getStringArray(R.array.string_array_titles);
        String[] contents = getStringArray(R.array.string_array_content);
        String[] images = getStringArray(R.array.string_array_images);

        // 直接用 idx 索引，避免 if/switch
        String title = titles[idx];
        String body = contents[idx];
        String imageName = images[idx];

        int iconRes = getResources().getIdentifier(imageName, "drawable", getPackageName());

        ((TextView) findViewById(R.id.detailTitle)).setText(title);
        ((TextView) findViewById(R.id.sectionBody)).setText(body);
        ((ImageView) findViewById(R.id.detailIcon)).setImageResource(iconRes);
    }

    private String[] getStringArray(@ArrayRes int resId) {
        return getResources().getStringArray(resId);
    }
}
