package com.example.dinedash.ui;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dinedash.R;
import com.example.dinedash.api.ApiClient;
import com.example.dinedash.api.ApiService;
import com.example.dinedash.model.MenuItem;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setHasFixedSize(false); // important for dynamic content

        fetchMenuItems();
    }

    private void fetchMenuItems() {
        ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
        Call<List<MenuItem>> call = apiService.getMenuItems();

        call.enqueue(new Callback<List<MenuItem>>() {
            @Override
            public void onResponse(Call<List<MenuItem>> call, Response<List<MenuItem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<MenuItem> menuList = response.body();

                    // Check if list is empty
                    if (menuList.isEmpty()) {
                        Toast.makeText(MenuActivity.this, "No menu found", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    // Initialize adapter and attach
                    adapter = new MenuAdapter(menuList);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(MenuActivity.this, "Failed to fetch menu", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MenuItem>> call, Throwable t) {
                Toast.makeText(MenuActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
