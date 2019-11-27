package com.example.foodies.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.foodies.R;
import com.example.foodies.activity.TabSelectorAdapter;
import com.google.android.material.tabs.TabLayout;

public class DashboardFragment extends Fragment {


    TabSelectorAdapter adapter;

    View myFragmnt;

    TabLayout tabLayout;
    ViewPager viewPager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myFragmnt = inflater.inflate(R.layout.fragment_dashboard, container, false);

        viewPager = myFragmnt.findViewById(R.id.viewPager);
        tabLayout = myFragmnt.findViewById(R.id.tabLayout);

        return myFragmnt;
    }

    //Call onActivity Create Method


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPagwer(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPagwer(ViewPager viewPager) {

        TabSelectorAdapter adapter = new TabSelectorAdapter(getChildFragmentManager());

        adapter.addFragment(new BreakfastTabFragment(), "Breakfast");
        adapter.addFragment(new SandwitchTabFragment(), "Sandwitch");
        adapter.addFragment(new SoupsTabFragment(), "Soups");
        adapter.addFragment(new DessertsTabFragment(), "Desserts");
        adapter.addFragment(new BeverageTabFragment(), "Beverage");

        viewPager.setAdapter(adapter);

    }
}
