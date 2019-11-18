package com.example.gallery;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class FullScreenViewActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_view);

        imageView=findViewById(R.id.img_full);

        int img_id = getIntent().getExtras().getInt("img");
        imageView.setImageResource(img_id);
    }
}