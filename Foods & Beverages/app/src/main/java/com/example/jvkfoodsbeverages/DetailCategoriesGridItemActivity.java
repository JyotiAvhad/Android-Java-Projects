package com.example.jvkfoodsbeverages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class DetailCategoriesGridItemActivity extends AppCompatActivity {

    private String[] gridTitle = new String[]{
            "Happy Combo Mushroom Pizza",
            "Happy Combo Cheese Pizza",
            "Happy Combo Plain Pizza"
    };

    private String[] gridSubTitle = new String[]{
            "In stock",
            "In stock",
            "Out off stock"
    };

    private RecyclerView rvDetailDailyDeals;
    private ArrayList<DetailCategoriesGridItemModel> detailCategoriesGridItemModelArrayList;
    private DetailCategoriesGridItemAdapter detailCategoriesGridItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_categories_grid_item);

        GridItemSectionsPageAdapter sectionsPageAdapter = new GridItemSectionsPageAdapter(getSupportFragmentManager());

//        set ViewPager with the sections adapter.
        ViewPager viewPager = findViewById(R.id.grid_viewPager);
        setViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.grid_tabs);
        tabLayout.setupWithViewPager(viewPager);


//      detail page daily deals section
        rvDetailDailyDeals = findViewById(R.id.recyclerView_daily_deal);

        detailCategoriesGridItemModelArrayList = detailGridItems();
        detailCategoriesGridItemAdapter = new DetailCategoriesGridItemAdapter(this, detailCategoriesGridItemModelArrayList);
        rvDetailDailyDeals.setAdapter(detailCategoriesGridItemAdapter);
        rvDetailDailyDeals.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


        // making notification bar transparent
        changeStatusBarColor();

    }

    private ArrayList<DetailCategoriesGridItemModel> detailGridItems() {

        ArrayList<DetailCategoriesGridItemModel> arrayList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            DetailCategoriesGridItemModel gridItemModel = new DetailCategoriesGridItemModel();
            gridItemModel.setTitle(gridTitle[i]);
            gridItemModel.setSubTitle(gridSubTitle[i]);
//            popularNearYouModel.setFoodImg(myImageList[i]);
//            popularNearYouModel.setFoodRating(myImageList[i]);
            arrayList.add(gridItemModel);
        }
        return arrayList;
    }

    // Making notification bar transparent
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void setViewPager(ViewPager viewPager) {

        GridItemSectionsPageAdapter adapter = new GridItemSectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new DeliveryFragment(), "Delivery");
        adapter.addFragment(new MenuFragment(), "Menu");
        adapter.addFragment(new ReviewFragment(), "Review");
        viewPager.setAdapter(adapter);
    }

}
