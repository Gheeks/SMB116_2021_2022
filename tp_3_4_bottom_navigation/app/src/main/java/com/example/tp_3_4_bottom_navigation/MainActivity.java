package com.example.tp_3_4_bottom_navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textview);

        initializeBottomNavigationView();

        BadgeDrawable badge = bottomNavigationView.getOrCreateBadge(R.id.menu_you);
        badge.setVisible(true);
        badge.setNumber(23);
    }

    private void initializeBottomNavigationView() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.menu_news) {
                textView.setText(R.string.news);
            } else if (id == R.id.menu_global) {
                textView.setText(R.string.global);
            } else if (id == R.id.menu_you) {
                textView.setText(R.string.for_you);
            } else if (id == R.id.menu_trending) {
                textView.setText(R.string.trending);
            }

            return true;
        });

        bottomNavigationView.setSelectedItemId(R.id.menu_news);
    }
}