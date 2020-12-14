package activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.neostore.R;
import com.google.android.material.navigation.NavigationView;
import com.rd.PageIndicatorView;

import adapter.ViewPagerAdapter;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    Context context;
    DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //viewPager
        ViewPager viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        //pageIndicatorView
        PageIndicatorView pageIndicatorView = findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setCount(4);
        pageIndicatorView.setSelection(1);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //Hamburger
        ImageView homeMenu = findViewById(R.id.iv_home_menu);
        drawerLayout = findViewById(R.id.drawerLayout);
        homeMenu.setOnClickListener(view -> drawerLayout.openDrawer(Gravity.LEFT));

        //navigation view drawer
        NavigationView navigationView = findViewById(R.id.nav_home);
        View head_view = navigationView.getHeaderView(0);
        TextView name = head_view.findViewById(R.id.head_name);
        TextView email = head_view.findViewById(R.id.head_email);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                switch (id) {

//                    case R.id.MyCart:
//                        Intent cart = new Intent(getApplicationContext(), ActivityCart.class);
//                        startActivity(cart);
//                        break;
//
//                    case R.id.Tables:
//                        furniture("1");
//                        break;
//
//                    case R.id.Chairs:
//                        furniture("2");
//                        break;
//
//                    case R.id.Sofas:
//                        furniture("3");
//                        break;
//
//                    case R.id.Cupboard:
//                        furniture("4");
//                        break;
//
//                    case R.id.logout:
//                        HelperShared.Helper.getInstance(context).clear();
//                        Intent logout = new Intent(getApplicationContext(), ActivityLogin.class);
//                        logout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                        startActivity(logout);
//                        break;
                }
                return true;
            }
        });
    }


    @Override
    public void onClick(View view) {


    }
}
