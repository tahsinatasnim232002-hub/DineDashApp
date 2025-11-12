package com.example.dinedash.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;
import com.example.dinedash.model.MenuItem;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class MenuDetailsActivity extends AppCompatActivity {

    private LinearLayout detailsContainer;
    private Button btnProceedPayment;

    @SuppressLint({"SetTextI18n", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menudetails);

        detailsContainer = findViewById(R.id.detailcontainer);
        btnProceedPayment = findViewById(R.id.btnProceedToPayment);

        // Get selected items from previous screen
        ArrayList<MenuItem> selectedItems = getIntent().getParcelableArrayListExtra("selected_items");
        double total = 0;

        if (selectedItems != null && !selectedItems.isEmpty()) {
            for (MenuItem item : selectedItems) {
                // Each item block
                LinearLayout itemLayout = new LinearLayout(this);
                itemLayout.setOrientation(LinearLayout.HORIZONTAL);
                itemLayout.setPadding(16, 12, 16, 12);

                // Item name
                TextView nameView = new TextView(this);
                nameView.setText(item.getName());
                nameView.setLayoutParams(new LinearLayout.LayoutParams(
                        0, LinearLayout.LayoutParams.WRAP_CONTENT, 1
                ));
                nameView.setTextSize(18);
                nameView.setTextColor(getResources().getColor(android.R.color.black));

                // Price
                TextView priceView = new TextView(this);
                priceView.setText("৳ " + item.getPrice());
                priceView.setTextSize(18);
                priceView.setTextColor(getResources().getColor(R.color.purple_700));

                // Add both
                itemLayout.addView(nameView);
                itemLayout.addView(priceView);

                // Add to container
                detailsContainer.addView(itemLayout);
                total += item.getPrice();
            }

            // Add total at bottom
            TextView totalText = new TextView(this);
            totalText.setText("\nTotal: ৳ " + total);
            totalText.setTextSize(20);
            totalText.setTextColor(getResources().getColor(android.R.color.black));
            totalText.setPadding(0, 20, 0, 10);
            detailsContainer.addView(totalText);

        } else {
            TextView emptyText = new TextView(this);
            emptyText.setText("No items selected");
            emptyText.setTextSize(18);
            emptyText.setTextColor(getResources().getColor(android.R.color.darker_gray));
            emptyText.setPadding(0, 40, 0, 0);
            detailsContainer.addView(emptyText);
        }

        // Proceed button click
        btnProceedPayment.setOnClickListener(v -> {
            double total2 = 0;
            Intent intent = new Intent(MenuDetailsActivity.this, PaymentActivity.class);
            intent.putExtra("total_price", total2);
            startActivity(intent);
        });
    }
}
