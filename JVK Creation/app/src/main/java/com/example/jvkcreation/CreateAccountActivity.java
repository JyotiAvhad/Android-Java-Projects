package com.example.jvkcreation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CreateAccountActivity extends AppCompatActivity {

    ImageView iv_backScreen;
    CardView cv_signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        iv_backScreen=findViewById(R.id.iv_backScreen);
        iv_backScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CreateAccountActivity.this,MainActivity.class));
                finish();
            }
        });

        cv_signUp=findViewById(R.id.cardView_signUp);
        cv_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(CreateAccountActivity.this,PurchaseAsActivity.class));
                finish();
            }
        });
    }
}
