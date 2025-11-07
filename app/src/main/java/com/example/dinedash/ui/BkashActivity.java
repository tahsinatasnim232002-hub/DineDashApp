package com.example.dinedash.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dinedash.R;

public class BkashActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bkashpayment);

        // Optional: Show a message
        Toast.makeText(this, "bKash payment feature coming soon!", Toast.LENGTH_SHORT).show();
    }
}

