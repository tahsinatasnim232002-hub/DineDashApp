package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // find the sign up button (make sure the id matches your XML)
        EditText name = findViewById(R.id.name);
        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText confirmPassword = findViewById(R.id.confirmPassword);
        Button signupBtn = findViewById(R.id.signup);
        TextView loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(v -> {
            setContentView(R.layout.activity_login);
        });

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get text values
                String nameStr = name.getText().toString().trim();
                String emailStr = email.getText().toString().trim();
                String passStr = password.getText().toString().trim();
                String confirmPassStr = confirmPassword.getText().toString().trim();

                // Validate fields
                if (nameStr.isEmpty()) {
                    name.setError("Name is required");
                    name.requestFocus();
                    return;
                }

                if (emailStr.isEmpty()) {
                    email.setError("Email is required");
                    email.requestFocus();
                    return;
                }

                if (passStr.isEmpty()) {
                    password.setError("Password is required");
                    password.requestFocus();
                    return;
                }

                if (confirmPassStr.isEmpty()) {
                    confirmPassword.setError("Confirm your password");
                    confirmPassword.requestFocus();
                    return;
                }

                if (!passStr.equals(confirmPassStr)) {
                    confirmPassword.setError("Passwords do not match");
                    confirmPassword.requestFocus();
                    return;
                }

                Toast.makeText(RegisterActivity.this, "Registration Successful!", Toast.LENGTH_SHORT).show();

                // ✅ If all checks pass, go to next activity
                Intent intent = new Intent(RegisterActivity.this, MenuActivity.class);
                startActivity(intent);
                finish(); // optional
            }
        });
    }
}
