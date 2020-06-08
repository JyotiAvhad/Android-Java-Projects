package com.example.jvkfoodsbeverages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class CurrentLocationActivity extends AppCompatActivity {

    Button currentLocation;
    TextView skipForNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_location);

        currentLocation = findViewById(R.id.btn_current_location);
        currentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CurrentLocationActivity.this, MapsActivity.class);
                startActivity(intent);

            }
        });

        skipForNow = findViewById(R.id.tv_skip_for_now);
        skipForNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CurrentLocationActivity.this, DashboardActivity.class);
                startActivity(intent);

            }
        });

        // making notification bar transparent
        changeStatusBarColor();

    }

    // Making notification bar transparent
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}
