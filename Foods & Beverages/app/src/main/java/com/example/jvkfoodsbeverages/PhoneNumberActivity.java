package com.example.jvkfoodsbeverages;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class PhoneNumberActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int flags[] = {

            R.drawable.flag_of_india,
            R.drawable.flag_of_australia,
            R.drawable.flag_of_brazil,

            R.drawable.flag_of_france,
            R.drawable.flag_of_italy,
            R.drawable.flag_of_japan,

            R.drawable.flag_of_malaysia,
            R.drawable.flag_of_mexico,
            R.drawable.flag_of_nepal,

            R.drawable.flag_of_russia,
            R.drawable.flag_of_singapore,
            R.drawable.flag_of_switzerland,

            R.drawable.flag_of_thailand,
            R.drawable.flag_of_united_kingdom,
            R.drawable.flag_of_united_states
    };

    String countryCode[] = {
            "91","61","55",
            "33","39","81",
            "60","52","977",
            "7","65","41",
            "66","44","1"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        Spinner spinner= findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        CustomSpinnerAdapter customSpinnerAdapter=new CustomSpinnerAdapter(getApplicationContext(),flags,countryCode);
        spinner.setAdapter(customSpinnerAdapter);

        // making notification bar transparent
        changeStatusBarColor();

        //open dialog box on next btn click
        Button next = findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder=new AlertDialog.Builder(PhoneNumberActivity.this);
                builder.setMessage("We will send the authentication code to the phone number you entered. "+
                "\n"+"Do you want to continue?");
                builder.setTitle("Login with phone number");
                builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        startActivity(new Intent(PhoneNumberActivity.this,OTPActivity.class));
                    }
                });

                builder.setNegativeButton("Cancel",null);

                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });

    }

    // Making notification bar transparent
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//        Toast.makeText(getApplicationContext(),countryCode[position],Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
