package com.example.tp_3_4_top_navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.toolbar));

        Button btn = findViewById(R.id.second_activity_button);

        btn.setOnClickListener(v -> startActivity(new Intent(this, SecondActivity.class)));
    }
}