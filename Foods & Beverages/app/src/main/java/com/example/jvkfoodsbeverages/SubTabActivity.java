package com.example.jvkfoodsbeverages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;

public class SubTabActivity extends AppCompatActivity {

    private SectionsPageAdapter sectionsPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_tab);

        sectionsPageAdapter=new SectionsPageAdapter(getSupportFragmentManager());

//        set ViewPager with the sections adapter.
        ViewPager viewPager = findViewById(R.id.viewPager);
        setViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //hosting adding fragment in the activity
//        FragmentManager fragmentManager=getSupportFragmentManager();
//        Fragment fragment=fragmentManager.findFragmentById(R.id.relativeLayout_sub_tab);
//
//        if (fragment==null){
//            fragment=new FeaturedFragment();
//            fragmentManager.beginTransaction()
//                    .add(R.id.relativeLayout_sub_tab,fragment)
//                    .commit();
//        }

        //adding featured frag in activity
//        featuredFragment();

        //adding featured frag in activity
//        popularFragment();

//        FeaturedFragment fragment = new FeaturedFragment();
//
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .add(R.id.relativeLayout_sub_tab,fragment)
//                .commit();



        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.viewPager,
                    new FeaturedFragment()).commit();
        }


        // making notification bar transparent
        changeStatusBarColor();
    }

    private void popularFragment() {

        PopularFragment fragment = new PopularFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.relativeLayout_sub_tab,fragment)
                .commit();
    }

    private void featuredFragment() {

        FeaturedFragment fragment = new FeaturedFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.relativeLayout_sub_tab,fragment)
                .commit();
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

        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new FeaturedFragment(), "Featured");
        adapter.addFragment(new PopularFragment(), "Popular");
        adapter.addFragment(new NewestFragment(), "Newest");
        adapter.addFragment(new TrendingFragment(), "Trending");
        viewPager.setAdapter(adapter);
    }
}
