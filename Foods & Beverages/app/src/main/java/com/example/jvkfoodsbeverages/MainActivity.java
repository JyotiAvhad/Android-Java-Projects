package com.example.jvkfoodsbeverages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button phoneNumber;
    Button facebook;
    Button google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumber=findViewById(R.id.btn_phoneNumber);
        phoneNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this, PhoneNumberActivity.class);
                startActivity(intent);

            }
        });

        facebook=findViewById(R.id.btn_facebook);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent=new Intent(Intent.ACTION_SEND);
//                intent.setType("text/plain");
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
//
//                intent.putExtra(Intent.EXTRA_SUBJECT,"Facebook");
//                intent.putExtra(Intent.EXTRA_TEXT,"http://www.facebook.com");
//
//                startActivity(Intent.createChooser(intent,"Open With..."));
//                finish();




//                Intent intent=new Intent(Intent.ACTION_SEND);
//                intent.setType("text/plain");
//                startActivity(Intent.createChooser(intent,"Open With..."));
//                intent.putExtra(Intent.EXTRA_TEXT,"http://www.facebook.com");
//
//                finish();



                Intent intent=new Intent(android.content.Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT,"Open Facebook");

                String app_url="http://www.google.com";
                intent.putExtra(Intent.EXTRA_TEXT,app_url);
                startActivity(Intent.createChooser(intent,"Share Via..."));


            }
        });

        google=findViewById(R.id.btn_google);
        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);

            }
        });

    }
}
