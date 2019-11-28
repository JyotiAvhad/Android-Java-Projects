package com.example.foodies.tabfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodies.pojo.BreakfastItem;
import com.example.foodies.R;
import com.example.foodies.adapter.BreakfastRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class BreakfastTabFragment extends Fragment {

    List<BreakfastItem> lstBreakfastItem;
    View myFragment;

//    ArrayList<Integer> breakfastItemList = new ArrayList<>(Arrays.<Integer>asList(
//
//            R.drawable.upma,
//            R.drawable.bread_pakoda,
//            R.drawable.misal_pav,
//            R.drawable.besan_chilla,
//            R.drawable.methi_thepla,
//            R.drawable.gobi_paratha,
//            R.drawable.dosa,
//            R.drawable.idli,
//            R.drawable.aloo_paratha
//
//    ));

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_tab_breakfast, container, false);

        lstBreakfastItem = new ArrayList<>();

        lstBreakfastItem.add(new BreakfastItem("Misal Pav",R.drawable.misal_pav));
        lstBreakfastItem.add(new BreakfastItem("Bread Pakoda",R.drawable.bread_pakoda));
        lstBreakfastItem.add(new BreakfastItem("Besan Chilla",R.drawable.besan_chilla));
        lstBreakfastItem.add(new BreakfastItem("Gobi Paratha",R.drawable.gobi_paratha));
        lstBreakfastItem.add(new BreakfastItem("Aloo Paratha",R.drawable.aloo_paratha));
        lstBreakfastItem.add(new BreakfastItem("Upma",R.drawable.upma));
        lstBreakfastItem.add(new BreakfastItem("Dosa",R.drawable.dosa));
        lstBreakfastItem.add(new BreakfastItem("Idli",R.drawable.idli));
        lstBreakfastItem.add(new BreakfastItem("Misal Pav",R.drawable.misal_pav));
        lstBreakfastItem.add(new BreakfastItem("Bread Pakoda",R.drawable.bread_pakoda));
        lstBreakfastItem.add(new BreakfastItem("Besan Chilla",R.drawable.besan_chilla));
        lstBreakfastItem.add(new BreakfastItem("Gobi Paratha",R.drawable.gobi_paratha));
        lstBreakfastItem.add(new BreakfastItem("Aloo Paratha",R.drawable.aloo_paratha));
        lstBreakfastItem.add(new BreakfastItem("Upma",R.drawable.upma));
        lstBreakfastItem.add(new BreakfastItem("Dosa",R.drawable.dosa));
        lstBreakfastItem.add(new BreakfastItem("Idli",R.drawable.idli));
        lstBreakfastItem.add(new BreakfastItem("Gobi Paratha",R.drawable.gobi_paratha));

        RecyclerView myrv = myFragment.findViewById(R.id.recyclerView_itemName);
        BreakfastRecyclerViewAdapter myAdapter = new BreakfastRecyclerViewAdapter(this, lstBreakfastItem);
        myrv.setLayoutManager(new GridLayoutManager(getActivity(),2));
        myrv.setAdapter(myAdapter);

        return myFragment;


    }
}