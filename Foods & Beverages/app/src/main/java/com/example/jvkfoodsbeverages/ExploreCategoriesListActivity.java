package com.example.jvkfoodsbeverages;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;

public class ExploreCategoriesListActivity extends AppCompatActivity {

    ArrayList list = new ArrayList<>();

    GridView gridView;
    ImageView iv_backScreen;
    CardView cardView;

    String[] categoryNameList = new String[]{
            "Food",
            "Drink",
            "Vege",
            "Burger",
            "Cake",
            "Dessert",
            "Pizza",
            "Noodle",
            "Milktea",
            "Chicken",
            "Mexican Food",
            "Coffee"
    };

    String[] categoryPlacesCount = new String[]{
            "2215",
            "658",
            "432",
            "843",
            "124",
            "723",
            "984",
            "215",
            "362",
            "567",
            "423",
            "175"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_categories_list);

        gridView = findViewById(R.id.gridView);

        ExploreCategoriesListAdapter adapter = new ExploreCategoriesListAdapter(getApplicationContext(), categoryNameList, categoryPlacesCount);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent=new Intent(ExploreCategoriesListActivity.this, DetailCategoriesGridItemActivity.class);
                intent.putExtra("name",categoryNameList[position]);
                startActivity(intent);

            }
        });

        iv_backScreen = findViewById(R.id.iv_backScreen);
        iv_backScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(ExploreCategoriesListActivity.this, DashboardActivity.class));
                finish();
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

