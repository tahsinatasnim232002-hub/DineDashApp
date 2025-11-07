package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.dinedash.R;
import com.example.dinedash.api.ApiClient;
import com.example.dinedash.api.ApiService;
import com.example.dinedash.model.MenuItem;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MenuActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MenuAdapter adapter;
    private Button btnConfirmOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        recyclerView = findViewById(R.id.recyclerView);
        btnConfirmOrder = findViewById(R.id.btnConfirmOrder);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        fetchMenuItems();

        btnConfirmOrder.setOnClickListener(v -> {
            if (adapter != null) {
                List<MenuItem> selected = adapter.getSelectedItems();
                if (selected.isEmpty()) {
                    Toast.makeText(this, "Please select at least one food", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MenuActivity.this, MenuDetailsActivity.class);
                    intent.putParcelableArrayListExtra("selected_items", new ArrayList<>(selected));
                    startActivity(intent);
                }
            }
        });
    }

    private void fetchMenuItems() {
        ApiService apiService = ApiClient.getRetrofit().create(ApiService.class);
        Call<List<MenuItem>> call = apiService.getMenuItems();

        call.enqueue(new Callback<List<MenuItem>>() {
            @Override
            public void onResponse(Call<List<MenuItem>> call, Response<List<MenuItem>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter = new MenuAdapter(response.body());
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
