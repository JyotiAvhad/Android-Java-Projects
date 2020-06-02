package com.example.jvkfoodsbeverages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class DashboardActivity extends AppCompatActivity {

    //popular near you section
    private RecyclerView rvPopularNearYou;
    private ArrayList<PopularNearYouModel> popularNearYouModelArrayList;
    private PopularNearYouAdapter popularNearYouAdapter;

    private int[] myImageList = new int[]{
            R.drawable.popular_near_1,
            R.drawable.recommended_3,
            R.drawable.recommended_1,
            R.drawable.recommended_2};

    private String[] myImageNameList = new String[]{
            "MC Donald's - Thai Ha",
            "La Pizza - Pizza Delivery",
            "Savor - Omelet",
            "A Hoai - Bread"};

    private String[] myImageTypeList = new String[]{
            "Western Cuisine, Fast Food, Burger",
            "Fast Food, Pizza, Chicken",
            "Snacks - Omelet",
            "Breakfast - Bread"};


    //explore categories section
    private RecyclerView rvExploreCategories;
    private ArrayList<ExploreCategoriesModel> exploreCategoriesModelArrayList;
    private ExploreCategoriesAdapter exploreCategoriesAdapter;

    private String[] categoryNameList = new String[]{
            "Food",
            "Drink",
            "Vege",
            "Burger",
            "Cake",
            "Dessert",
            "Pizza",
            "Noodle",
            "Milktea",
            "Chicken",
            "Mexican Food",
            "Coffee"};

    private String[] categoryPlacesCount = new String[]{
            "2215",
            "658",
            "432",
            "843",
            "124",
            "723",
            "984",
            "215",
            "362",
            "567",
            "423",
            "175"};

    private int[] categoryBG = new int[]{
            R.color.red,
            R.color.purple,
            R.color.green,
            R.color.mango,
            R.color.brown,
            R.color.pink,
            R.color.red,
            R.color.purple,
            R.color.green,
            R.color.mango,
            R.color.brown,
            R.color.pink
    };



    //recommended section
    private RecyclerView rvRecommended;
    private ArrayList<RecommendedModel> recommendedModelArrayList;
    private RecommendedAdapter recommendedAdapter;

    private int[] recomImageList = new int[]{
            R.drawable.recommended_1,
            R.drawable.recommended_2,
            R.drawable.recommended_3};

    private String[] recomImageNameList = new String[]{
            "MC Donald's",
            "MC Donald's",
            "MC Donald's"};

    private String[] recomImageTypeList = new String[]{
            "Western Cuisine, Fast Food, Burger",
            "Western Cuisine, Fast Food, Burger",
            "Western Cuisine, Fast Food, Burger"};


    //voucher & discount section
    private RecyclerView rvVoucherDiscount;
    private ArrayList<VoucherDiscountModel> voucherDiscountModelArrayList;
    private VoucherDiscountAdapter voucherDiscountAdapter;

    private int[] vdImageList = new int[]{
            R.drawable.voucher_discount_1,
            R.drawable.voucher_discount_2};


    //onCreate method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // making notification bar transparent
        changeStatusBarColor();

        //popular categories list
        rvPopularNearYou = (RecyclerView) findViewById(R.id.recyclerView_popular_near_you);

        popularNearYouModelArrayList = popularNearYou();
        popularNearYouAdapter = new PopularNearYouAdapter(this, popularNearYouModelArrayList);
        rvPopularNearYou.setAdapter(popularNearYouAdapter);
        rvPopularNearYou.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        //on click categories grid view
        TextView viewAll=findViewById(R.id.tv_view_all);
        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DashboardActivity.this,SubTabActivity.class));
//                finish();
            }
        });

        //explore categories list
        rvExploreCategories = (RecyclerView) findViewById(R.id.recyclerView_explore_categories);

        exploreCategoriesModelArrayList = exploreCategories();
        exploreCategoriesAdapter = new ExploreCategoriesAdapter(this, exploreCategoriesModelArrayList);
        rvExploreCategories.setAdapter(exploreCategoriesAdapter);
        rvExploreCategories.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        //on click categories grid view
        TextView showAll=findViewById(R.id.tv_ec_show_all);
        showAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DashboardActivity.this, ExploreCategoriesListActivity.class));
//                finish();
            }
        });

        //recommended categories list
        rvRecommended = (RecyclerView) findViewById(R.id.recyclerView_recommended);

        recommendedModelArrayList = recommended();
        recommendedAdapter = new RecommendedAdapter(this, recommendedModelArrayList);
        rvRecommended.setAdapter(recommendedAdapter);
        rvRecommended.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


        //voucher & discount list
        rvVoucherDiscount = (RecyclerView) findViewById(R.id.recyclerView_voucher_discount);

        voucherDiscountModelArrayList = voucherDiscount();
        voucherDiscountAdapter = new VoucherDiscountAdapter(this, voucherDiscountModelArrayList);
        rvVoucherDiscount.setAdapter(voucherDiscountAdapter);
        rvVoucherDiscount.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));


    }

    private ArrayList<VoucherDiscountModel> voucherDiscount() {

        ArrayList<VoucherDiscountModel> arrayList = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            VoucherDiscountModel voucherDiscountModel = new VoucherDiscountModel();
            voucherDiscountModel.setVdImg(vdImageList[i]);
            arrayList.add(voucherDiscountModel);
        }
        return arrayList;

    }


    //    recommended method
    private ArrayList<RecommendedModel> recommended() {

        ArrayList<RecommendedModel> arrayList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            RecommendedModel recommendedModel = new RecommendedModel();
            recommendedModel.setrName(recomImageNameList[i]);
            recommendedModel.setrType(recomImageTypeList[i]);
            recommendedModel.setrImg(recomImageList[i]);
//            popularNearYouModel.setFoodRating(myImageList[i]);
            arrayList.add(recommendedModel);
        }
        return arrayList;
    }

    //    exploreCategories method
    private ArrayList<ExploreCategoriesModel> exploreCategories() {

        ArrayList<ExploreCategoriesModel> arrayList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            ExploreCategoriesModel exploreCategoriesModel = new ExploreCategoriesModel();
            exploreCategoriesModel.setCatName(categoryNameList[i]);
            exploreCategoriesModel.setCatPlacesCount(categoryPlacesCount[i] + " places");
//            exploreCategoriesModel.setCatBGColor(R.color.orange);

//            exploreCategoriesModel.setCatBGColor(categoryBG[i]);
//            exploreCategoriesModel.setCatBGColor(randomColor());
            arrayList.add(exploreCategoriesModel);
        }
        return arrayList;

    }

    //to get random color for card view background
    private int randomColor() {

        Random random = new Random();
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    //    popularNearYou method
    private ArrayList<PopularNearYouModel> popularNearYou() {

        ArrayList<PopularNearYouModel> arrayList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            PopularNearYouModel popularNearYouModel = new PopularNearYouModel();
            popularNearYouModel.setFoodName(myImageNameList[i]);
            popularNearYouModel.setFoodType(myImageTypeList[i]);
            popularNearYouModel.setFoodImg(myImageList[i]);
//            popularNearYouModel.setFoodRating(myImageList[i]);
            arrayList.add(popularNearYouModel);
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
}
