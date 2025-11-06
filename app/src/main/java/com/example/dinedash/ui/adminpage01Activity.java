package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;

public class adminpage01Activity extends AppCompatActivity {

    private Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage01); // Make sure XML filename matches

        // Find the continue button
        continueBtn = findViewById(R.id.button9);

        // Set click listener
        continueBtn.setOnClickListener(v -> {
            // Example: Navigate to Admin Dashboard activity
            Intent intent = new Intent(adminpage01Activity.this, adminpage01Activity.class);
            startActivity(intent);
            finish(); // optional, prevents going back to AdminActivity
        });
    }
}
