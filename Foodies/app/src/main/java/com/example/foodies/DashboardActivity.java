package com.example.foodies;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {

    TabAdapter adapter;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);

        adapter = new TabAdapter(getSupportFragmentManager());

        adapter.addFragment(new BreakfastTabFragment(), "Breakfast");
        adapter.addFragment(new SandwitchTabFragment(), "Sandwitch");
        adapter.addFragment(new SoupsTabFragment(), "Soups");
        adapter.addFragment(new DessertsTabFragment(), "Desserts");
        adapter.addFragment(new BeverageTabFragment(), "Beverage");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}