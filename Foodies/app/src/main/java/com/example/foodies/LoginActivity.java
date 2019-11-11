package com.example.foodies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText mobileNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobileNum=findViewById(R.id.et_mobileNum);

        findViewById(R.id.card_sendOTP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNumber = mobileNum.getText().toString().trim();

                if (phoneNumber.isEmpty() || phoneNumber.length() < 10){
                    mobileNum.setError("Enter a Valid Mobile Number");
                    mobileNum.requestFocus();
                    return;
                }

                Intent intent =new Intent(LoginActivity.this, VerifyPhoneNoActivity.class);
                intent.putExtra("mobile",phoneNumber);
                startActivity(intent);
            }
        });


    }



}
