package com.example.foodies.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.foodies.R;
import com.example.foodies.adapter.TabSelectorAdapter;
import com.example.foodies.bottomfragment.DashboardFragment;
import com.example.foodies.bottomfragment.FavoriteFragment;
import com.example.foodies.bottomfragment.RecipeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

public class DashboardActivity extends AppCompatActivity {

    TabSelectorAdapter adapter;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        viewPager = findViewById(R.id.viewPager);
//        tabLayout = findViewById(R.id.tabLayout);
//
//        adapter = new TabSelectorAdapter(getSupportFragmentManager());
//
//        adapter.addFragment(new BreakfastTabFragment(), "Breakfast");
//        adapter.addFragment(new SandwitchTabFragment(), "Sandwitch");
//        adapter.addFragment(new SoupsTabFragment(), "Soups");
//        adapter.addFragment(new DessertsTabFragment(), "Desserts");
//        adapter.addFragment(new BeverageTabFragment(), "Beverage");
//
//        viewPager.setAdapter(adapter);
//        tabLayout.setupWithViewPager(viewPager);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);

        // loadFragment(new RecipeFragment());

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new DashboardFragment()).commit();
        }
    }

//    private boolean loadFragment(Fragment fragment){
//        if (fragment!=null){
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.fragment_container,fragment)
//                    .commit();
//
//            return true;
//        }
//        return false;
//    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.btn_ic_home:
                            selectedFragment = new DashboardFragment();
                            break;

                        case R.id.btn_ic_recipe:
                            selectedFragment = new RecipeFragment();
                            break;

                        case R.id.btn_ic_favorite:
                            selectedFragment = new FavoriteFragment();
                            break;
                    }


                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .commit();

                    return true;
//                    return loadFragment(selectedFragment);
                }
            };
}