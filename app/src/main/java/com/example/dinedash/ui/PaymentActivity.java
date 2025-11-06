package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;

public class PaymentActivity extends AppCompatActivity {

    Button addCardBtn, addBkashBtn, cashBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Initialize buttons
        addCardBtn = findViewById(R.id.button2);
        addBkashBtn = findViewById(R.id.button4);
        cashBtn = findViewById(R.id.button5);

        // --- Add Card Button ---
        addCardBtn.setOnClickListener(v -> {
            Toast.makeText(PaymentActivity.this, "Add Card feature coming soon...", Toast.LENGTH_SHORT).show();
        });

        // --- Add Bkash Button ---
        addBkashBtn.setOnClickListener(v -> {
            Toast.makeText(PaymentActivity.this, "bKash payment coming soon...", Toast.LENGTH_SHORT).show();
        });

        // --- Cash Button ---
        cashBtn.setOnClickListener(v -> {
            Toast.makeText(PaymentActivity.this, "Cash payment selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PaymentActivity.this, MenuActivity.class);
            startActivity(intent);
        });
    }
}
