package activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neostore.R;

import java.util.List;

import adapter.TablesPrdListAdapter;
import model.RetrofitClient;
import model.TableListResponse;
import model.TablesData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductTableActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

//    @Override
//    protected void onStart() {
//        super.onStart();
//        if(!HelperShared.Helper.getInstance(this).isLoggedIn()){
//            Intent home = new Intent(getApplicationContext(), LoginActivity.class);
//            home.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(home);
//        }
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_table);

        recyclerView = findViewById(R.id.rv_list);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        getTablesData();

    }

    private void getTablesData() {

        TextView title = findViewById(R.id.tv_home_appName);
        Intent intent = getIntent();
        String val = intent.getStringExtra("id");

        switch (val) {
            case "1":
                title.setText("Tables");
                break;

            case "2":
                title.setText("Chairs");
                break;

            case "3":
                title.setText("Sofas");
                break;

            case "4":
                title.setText("CupBoards");
                break;

            default:
                throw new IllegalStateException("Unexpected value: ");

        }

        Call<TableListResponse> call = RetrofitClient.getInstance().getApi().getTablesList(val);

        call.enqueue(new Callback<TableListResponse>() {

            @Override
            public void onResponse(Call<TableListResponse> call, Response<TableListResponse> response) {

                List<TablesData> exampleList = response.body().getData();

                adapter = new TablesPrdListAdapter(exampleList, ProductTableActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<TableListResponse> call, Throwable t) {

            }
        });

    }
}
