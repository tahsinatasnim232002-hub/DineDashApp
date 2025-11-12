package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;

public class AdminLoginActivity extends AppCompatActivity {

    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage02);

        View loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AdminLoginActivity.this, AdminTableActivity.class);
            startActivity(intent);
//            finish();
        });
    }
}
