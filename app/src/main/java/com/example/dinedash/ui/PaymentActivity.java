package com.example.dinedash.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;

public class PaymentActivity extends AppCompatActivity {

    Button cardBtn, bkashBtn, cashBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Initialize buttons
        cardBtn = findViewById(R.id.cardBtn);
        bkashBtn = findViewById(R.id.bkashBtn);
        cashBtn = findViewById(R.id.cashBtn);

        // --- Add Card Button ---
        cardBtn.setOnClickListener(v -> {
            Toast.makeText(PaymentActivity.this, "Add Card feature coming soon...", Toast.LENGTH_SHORT).show();
        });

        // --- Add Bkash Button ---
        bkashBtn.setOnClickListener(v -> {
            Toast.makeText(PaymentActivity.this, "bKash payment coming soon...", Toast.LENGTH_SHORT).show();
        });

        // --- Cash Button ---
        cashBtn.setOnClickListener(v -> {
            Toast.makeText(PaymentActivity.this, "Cash payment selected", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(PaymentActivity.this, Payment2Activity.class);
            startActivity(intent);
        });
    }
}
