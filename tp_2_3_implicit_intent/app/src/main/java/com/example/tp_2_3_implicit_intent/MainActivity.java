package com.example.tp_2_3_implicit_intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG  = "MainActivity";
    private static final int CAMERA_RESULT  = 12345;

    EditText websiteEditText;
    EditText locationEditText;
    EditText shareEditText;

    Button websiteBtn;
    Button locationBtn;
    Button shareBtn;
    Button takePictureBtn;

    ImageView photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        websiteEditText = findViewById(R.id.web_site);
        locationEditText = findViewById(R.id.location);
        shareEditText = findViewById(R.id.text);
        websiteBtn = findViewById(R.id.btn_web_site);
        locationBtn = findViewById(R.id.btn_location);
        shareBtn = findViewById(R.id.btn_text);
        takePictureBtn = findViewById(R.id.btn_take_picture);
        photo = findViewById(R.id.photo);

        websiteBtn.setOnClickListener(v -> onWebsiteClick());
        locationBtn.setOnClickListener(v -> onLocationClick());
        shareBtn.setOnClickListener(v -> onShareClick());
        takePictureBtn.setOnClickListener(v -> onTakePictureClick());
    }

    private void onShareClick() {
        String txt = shareEditText.getText().toString();
        String mimeType = "text/plain";
        new ShareCompat.IntentBuilder(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();

    }

    private void onTakePictureClick() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, CAMERA_RESULT);
        } catch (ActivityNotFoundException e) {
            Log.d(TAG, "onTakePictureClick: error with photo intent");
        }

    }

    private void onLocationClick() {
        String loc = locationEditText.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        checkAndCallIntent(intent);
    }

    private void onWebsiteClick() {
        String url = websiteEditText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, url);
        checkAndCallIntent(intent);
    }

    private void checkAndCallIntent(Intent intent) {
        if (!getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).isEmpty()) {
            startActivity(intent);
        }
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
        else
            Log.e(TAG, "checkAndCallIntent: Can't handle this intent");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_RESULT && resultCode == RESULT_OK) {
            if (data != null) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                photo.setImageBitmap(imageBitmap);
            }
        }

    }
}