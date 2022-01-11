package com.example.tp_3_1_buttons;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    ImageView donut;
    ImageView iceCream;
    ImageView froyo;
    FloatingActionButton fab;

    private GestureDetectorCompat detector;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donut = findViewById(R.id.imageView);
        froyo = findViewById(R.id.imageView2);
        iceCream = findViewById(R.id.imageView3);
        fab = findViewById(R.id.fab);

        donut.setOnClickListener(v -> showToast("You ordered a donut"));
        iceCream.setOnClickListener(v -> showToast("You ordered an ice cream sandwich"));
        froyo.setOnClickListener(v -> showToast("You ordered a frozen yogurt"));

        fab.setOnClickListener(v -> {
            Intent intent = new Intent("display_order_activity");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
            getApplicationContext().startActivity(intent);
        });

        detector = new GestureDetectorCompat(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                Log.d(TAG, "onSingleTapUp: ");
                return super.onSingleTapUp(e);
            }

            @Override
            public void onLongPress(MotionEvent e) {
                Log.d(TAG, "onLongPress: ");
                super.onLongPress(e);
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                Log.d(TAG, "onScroll: ");
                return super.onScroll(e1, e2, distanceX, distanceY);
            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                Log.d(TAG, "onFling: ");
                return super.onFling(e1, e2, velocityX, velocityY);
            }

            @Override
            public void onShowPress(MotionEvent e) {
                Log.d(TAG, "onShowPress: ");
                super.onShowPress(e);
            }

            @Override
            public boolean onDown(MotionEvent e) {
                Log.d(TAG, "onDown: ");
                return super.onDown(e);
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                Log.d(TAG, "onDoubleTap: ");
                return super.onDoubleTap(e);
            }
        });

        donut.setOnTouchListener((v, event) -> {
            if (detector.onTouchEvent(event))
                return true;

            return super.onTouchEvent(event);
        });
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}