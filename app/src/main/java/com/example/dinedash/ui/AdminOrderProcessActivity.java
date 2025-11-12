package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
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

        TextView tableName = findViewById(R.id.tableName);
        RecyclerView recyclerView = findViewById(R.id.orderedItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Button confirmOrderBtn = findViewById(R.id.confirmOrderBtn);
        Button cancelOrderBtn = findViewById(R.id.cancelOrderBtn);

        int tableNumber = getIntent().getIntExtra("TABLE_NUMBER", -1);
        tableName.setText("Table " + tableNumber + " Orders");

        // ✅ Create sample items
        List<OrderedItem> itemList = new ArrayList<>();
        itemList.add(new OrderedItem("Cheese Burger", 2, 250));
        itemList.add(new OrderedItem("French Fries", 1, 100));
        itemList.add(new OrderedItem("Soft Drink", 3, 60));
        itemList.add(new OrderedItem("Pizza Slice", 1, 300));

        OrderedItemAdapter adapter = new OrderedItemAdapter(itemList);
        recyclerView.setAdapter(adapter);

        // Back button action
        Button backToTableBtn = findViewById(R.id.backToTableBtn);
        backToTableBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AdminOrderProcessActivity.this, AdminTableActivity.class);
            startActivity(intent);
        });

        // 🔹 Confirm order action
        confirmOrderBtn.setOnClickListener(v -> {
            Toast.makeText(this, "✅ Order Confirmed for Table " + tableNumber, Toast.LENGTH_SHORT).show();
            finish(); // return to previous activity
        });

        // 🔹 Cancel order action
        cancelOrderBtn.setOnClickListener(v -> {
            Toast.makeText(this, "❌ Order Canceled for Table " + tableNumber, Toast.LENGTH_SHORT).show();
            finish(); // return to previous activity
        });
    }
}
