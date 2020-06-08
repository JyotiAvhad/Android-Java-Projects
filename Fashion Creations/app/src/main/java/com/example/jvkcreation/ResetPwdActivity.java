package com.example.jvkcreation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ResetPwdActivity extends AppCompatActivity {

    ImageView iv_backScreen;
    CardView cv_startShopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pwd);

        iv_backScreen=findViewById(R.id.iv_backScreen);
        iv_backScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ResetPwdActivity.this,UpdatePwdActivity.class));
                finish();
            }
        });

        cv_startShopping=findViewById(R.id.cardView_startShopping);
        cv_startShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ResetPwdActivity.this,CreateAccountActivity.class));
                finish();
            }
        });
    }
}
