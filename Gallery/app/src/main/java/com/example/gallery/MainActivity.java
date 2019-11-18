package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private SectionsPageAdapter sectionsPageAdapter;
    GridView gridView;

    ArrayList<Integer> imageList = new ArrayList<Integer>(Arrays.<Integer>asList(
            R.drawable.img_a,
            R.drawable.img_b,
            R.drawable.img_c,
            R.drawable.img_d,
            R.drawable.img_e,
            R.drawable.img_f,
            R.drawable.img_g,
            R.drawable.img_h,
            R.drawable.img_i,
            R.drawable.img_j,
            R.drawable.img_k,
            R.drawable.img_l,
            R.drawable.img_m,
            R.drawable.img_n,
            R.drawable.img_o,
            R.drawable.img_p,
            R.drawable.img_q,
            R.drawable.img_r,
            R.drawable.img_s,
            R.drawable.img_t,
            R.drawable.img_u,
            R.drawable.img_v,
            R.drawable.img_w,
            R.drawable.img_x,
            R.drawable.img_y,
            R.drawable.img_z
    ));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        gridView = findViewById(R.id.myGrids);

        gridView.setAdapter(new ImageAdapter(imageList, this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int item_pos = imageList.get(position);

                Intent intent=new Intent(MainActivity.this,FullScreenViewActivity.class);
                intent.putExtra("img",item_pos);
                startActivity(intent);

//                ShowDialogBox(item_pos);
            }
        });


        //sectionsPageAdapter=new SectionsPageAdapter(getSupportFragmentManager());

//        // Set ViewPager with the sections adapter.
//        ViewPager viewPager=findViewById(R.id.viewPager);
//        setViewPager(viewPager);
//
//        TabLayout tabLayout=findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(viewPager);


    }

    private void ShowDialogBox(final int item_pos) {

        final Dialog dialog = new Dialog(this);

       dialog.setContentView(R.layout.custom_dialog);

        //Getting custom dialog views
        TextView Image_name = dialog.findViewById(R.id.txt_Image_name);
        ImageView Image = dialog.findViewById(R.id.img);
        Button btn_Full = dialog.findViewById(R.id.btn_full);
        Button btn_Close = dialog.findViewById(R.id.btn_close);

        String title = getResources().getResourceName(item_pos);

        //extracting name
        final int index = title.indexOf("/");
        String name = title.substring(index+1,title.length());
        Image_name.setText(name);

        Image.setImageResource(item_pos);

        btn_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_Full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,FullScreenViewActivity.class);
                intent.putExtra("img",item_pos);
            }
        });

        dialog.show();

    }

    private void setViewPager(ViewPager viewPager) {

        SectionsPageAdapter adapter=new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new PhotosFragment(),"Photos");
        adapter.addFragment(new AlbumsFragment(),"Albums");
        viewPager.setAdapter(adapter);

    }
}
