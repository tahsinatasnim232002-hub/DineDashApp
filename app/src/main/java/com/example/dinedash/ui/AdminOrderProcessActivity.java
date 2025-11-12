package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dinedash.R;
import com.example.dinedash.adapter.OrderedItemAdapter;
import com.example.dinedash.model.OrderedItem;

import java.util.ArrayList;
import java.util.List;

public class AdminOrderProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage04);

        RecyclerView recyclerView = findViewById(R.id.orderedItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // ✅ Create sample items
        List<OrderedItem> itemList = new ArrayList<>();
        itemList.add(new OrderedItem("Cheese Burger", 2, 250));
        itemList.add(new OrderedItem("French Fries", 1, 100));
        itemList.add(new OrderedItem("Soft Drink", 3, 60));
        itemList.add(new OrderedItem("Pizza Slice", 1, 300));

        // ✅ Set adapter
        OrderedItemAdapter adapter = new OrderedItemAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Back button action
        Button backToTableBtn = findViewById(R.id.backToTableBtn);
        backToTableBtn.setOnClickListener(v -> {
            Toast.makeText(AdminOrderProcessActivity.this, "Back to Table", Toast.LENGTH_SHORT).show();
        });
    }
}
