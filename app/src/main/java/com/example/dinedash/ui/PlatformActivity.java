package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;

public class PlatformActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platforms);

        Button customerSideBtn = findViewById(R.id.customerSideBtn);
        customerSideBtn.setOnClickListener(v -> {
            Intent intent = new Intent(PlatformActivity.this, MenuActivity.class);
            startActivity(intent);
        });

        Button adminSideBtn = findViewById(R.id.customerSideBtn);
        adminSideBtn.setOnClickListener(v -> {
            Intent intent = new Intent(PlatformActivity.this, MenuActivity.class);
            startActivity(intent);
        });
    }
}
