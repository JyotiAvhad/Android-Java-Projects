package com.example.jvkcreation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PurchaseAsActivity extends AppCompatActivity {

    ImageView iv_backScreen;
    CardView cv_women;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_as);

        iv_backScreen=findViewById(R.id.iv_backScreen);
        iv_backScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PurchaseAsActivity.this,CreateAccountActivity.class));
//                finish();
            }
        });

        cv_women=findViewById(R.id.cardView_women);
        cv_women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(PurchaseAsActivity.this,WomenShopNowActivity.class));
//                finish();
            }
        });
    }
}
