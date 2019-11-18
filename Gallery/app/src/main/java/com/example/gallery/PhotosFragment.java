package com.example.gallery;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PhotosFragment extends Fragment {

    GridView gridView;

    private static final String TAG = "PhotosFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "PhotosFragment onCreateView: ");

//        gridView= gridView.findViewById(R.id.grid_view);
//        gridView.setAdapter(new ImageAdapter(this));

        View view=inflater.inflate(R.layout.photos_fragment,container,false);

        return view;
    }
}
