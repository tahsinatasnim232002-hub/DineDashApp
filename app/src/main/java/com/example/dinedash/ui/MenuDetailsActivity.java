package com.example.dinedash.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;
import com.example.dinedash.model.MenuItem;

import java.util.ArrayList;

public class MenuDetailsActivity extends AppCompatActivity {

    private LinearLayout detailsContainer;
    private Button btnProceedPayment;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menudetails);

        // Views initialize
        detailsContainer = findViewById(R.id.detailcontainer);
        btnProceedPayment = findViewById(R.id.btnProceedToPayment);

        // Get selected items from MenuActivity
        ArrayList<MenuItem> selectedItems = getIntent().getParcelableArrayListExtra("selected_items");

        double total = 0;

        if (selectedItems != null && !selectedItems.isEmpty()) {
            for (MenuItem item : selectedItems) {
                TextView tv = new TextView(this);
                tv.setText(item.getName() + " - ৳" + item.getPrice());
                tv.setTextSize(16);
                detailsContainer.addView(tv);

                total += item.getPrice();
            }

            // Show total price
            TextView totalText = new TextView(this);
            totalText.setText("Total: ৳" + total);
            totalText.setTextSize(18);
            totalText.setPadding(16, 16, 16, 16);
            detailsContainer.addView(totalText);
        } else {
            TextView emptyText = new TextView(this);
            emptyText.setText("No items selected");
            emptyText.setTextSize(16);
            detailsContainer.addView(emptyText);
        }

        // Go to PaymentActivity on button click
        btnProceedPayment.setOnClickListener(v -> {
            Intent intent = new Intent(MenuDetailsActivity.this, PaymentActivity.class);
            startActivity(intent);
        });
    }
}
