package com.example.gallery;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FullScreenViewActivity extends AppCompatActivity {

    ImageView imageView;
    private static final String TAG = "FullScreenViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_view);

        Log.d(TAG, "onCreate: Inside full screen activity");

        imageView=findViewById(R.id.img_full);

        int img_id = getIntent().getExtras().getInt("img");
        imageView.setImageResource(img_id);
    }
}