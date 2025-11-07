// app/java/.../MainActivity.java
package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] ids = new int[]{R.id.btnFacilities, R.id.btnEvents, R.id.btnClubs, R.id.btnSupport};
        for (int id : ids) {
            View v = findViewById(id);
            v.setOnClickListener(this);
        }
    }

    @Override public void onClick(View v) {
        Object tag = v.getTag();
        int index = Integer.parseInt(tag.toString());
        String[] labels = getResources().getStringArray(R.array.string_array_titles);
        Toast.makeText(this, labels[index] + " clicked", Toast.LENGTH_SHORT).show();

        // Part G：启动详情页并传递唯一标识（index）
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("idx", index);
        startActivity(intent);
    }
}
