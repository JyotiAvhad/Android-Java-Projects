package com.example.jvkcreation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class UpdatePwdActivity extends AppCompatActivity {

    CardView cv_reset;
    ImageView iv_backScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_pwd);

        iv_backScreen=findViewById(R.id.iv_backScreen);
        iv_backScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(UpdatePwdActivity.this,ForgotPwdActivity.class));
                finish();
            }
        });

        cv_reset=findViewById(R.id.cardView_resetPwd);
        cv_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(UpdatePwdActivity.this,ResetPwdActivity.class));
                finish();
            }
        });
    }
}
