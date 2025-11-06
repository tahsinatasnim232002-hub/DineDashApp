package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dinedash.R;

public class AdminActivity extends AppCompatActivity {

    private Button continueBtn;
    private TextInputEditText userIdEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage01);

        View adminLoginBtn = findViewById(R.id.adminLoginBtn);
//        userIdEditText = findViewById(R.id.text_input_user_id);
//        passwordEditText = findViewById(R.id.text_input_password);
//
        adminLoginBtn.setOnClickListener(v -> {
            Intent intent = new Intent(AdminActivity.this, AdminLoginActivity.class);
            startActivity(intent);
        });
    }
}
