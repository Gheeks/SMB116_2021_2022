package com.example.tp_2_1_activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "**** Activity1";
    public static final int RESULT_CODE = 1;
    public static final String EXTRA_TEST = "com.example.tp_2_1_activities_extra_test";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText = findViewById(R.id.text);

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(this, Activity2.class);
            intent.putExtra(EXTRA_TEST, editText.getText().toString());
            startActivityForResult(intent, RESULT_CODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_CODE && resultCode == RESULT_OK) {
            if (data != null) {
                String result = data.getStringExtra(Activity2.EXTRA_REPLY);
                showSnackBar(result);
            }
        }

    }

    private void showSnackBar(String msg) {
        Snackbar.make(findViewById(R.id.root), msg, Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
    
    
}