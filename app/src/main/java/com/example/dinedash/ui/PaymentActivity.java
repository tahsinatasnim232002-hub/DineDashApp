package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;

public class PaymentActivity extends AppCompatActivity {

    Button cardBtn, bkashBtn, cashBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Initialize buttons
        cardBtn = findViewById(R.id.cardBtn);
        bkashBtn = findViewById(R.id.bkashBtn);
        cashBtn = findViewById(R.id.cashBtn);

        // --- Card Button ---
        cardBtn.setOnClickListener(v -> {
            Intent intent = new Intent(PaymentActivity.this, CardActivity.class);
            startActivity(intent);
        });

        // --- Bkash Button ---
        bkashBtn.setOnClickListener(v -> {
            Intent intent = new Intent(PaymentActivity.this, BkashActivity.class);
            startActivity(intent);
        });

        // --- Cash Button ---
        cashBtn.setOnClickListener(v -> {
            Intent intent = new Intent(PaymentActivity.this, CashPaymentActivity.class);
            startActivity(intent);
        });
    }
}
