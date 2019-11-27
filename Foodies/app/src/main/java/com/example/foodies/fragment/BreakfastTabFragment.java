package com.example.foodies.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

import com.example.foodies.R;

import java.util.ArrayList;
import java.util.Arrays;

public class BreakfastTabFragment extends Fragment {

    GridView gridViewList;

    ArrayList<Integer> breakfastItemList = new ArrayList<>(Arrays.<Integer>asList(

            R.drawable.upma,
            R.drawable.bread_pakoda,
            R.drawable.misal_pav,
            R.drawable.besan_chilla,
            R.drawable.methi_thepla,
            R.drawable.gobi_paratha,
            R.drawable.dosa,
            R.drawable.idli,
            R.drawable.aloo_paratha

            ));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_breakfast, container, false);



    }
}