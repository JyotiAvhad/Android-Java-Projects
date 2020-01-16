package com.example.foodies.Controller.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodies.R;

public class LoginActivity extends AppCompatActivity {

    EditText mobileNum;
    ImageView iv_facebook,iv_google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobileNum = findViewById(R.id.et_mobileNum);
        iv_google = findViewById(R.id.imgView_google);

        findViewById(R.id.card_sendOTP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String phoneNumber = mobileNum.getText().toString().trim();

                if (phoneNumber.isEmpty() || phoneNumber.length() < 10) {
                    mobileNum.setError("Enter a Valid Mobile Number");
                    mobileNum.requestFocus();
                    return;
                }

                Intent intent = new Intent(LoginActivity.this, VerifyMobileActivity.class);
                intent.putExtra("mobile", phoneNumber);
                startActivity(intent);
            }
        });


        iv_google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(LoginActivity.this, DashboardActivity.class);
                startActivity(intent);
            }
        });

    }


    public void hideKeyboard(View view) {

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }
}
