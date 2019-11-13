package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.GridView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SectionsPageAdapter sectionsPageAdapter;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        gridView=findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(this));

        sectionsPageAdapter=new SectionsPageAdapter(getSupportFragmentManager());

//        // Set ViewPager with the sections adapter.
//        ViewPager viewPager=findViewById(R.id.viewPager);
//        setViewPager(viewPager);
//
//        TabLayout tabLayout=findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);

    }

    private void setViewPager(ViewPager viewPager) {

        SectionsPageAdapter adapter=new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new PhotosFragment(),"Photos");
        adapter.addFragment(new AlbumsFragment(),"Albums");
        viewPager.setAdapter(adapter);

    }
}
