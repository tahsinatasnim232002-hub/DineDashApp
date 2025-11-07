package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // find the sign up button (make sure the id matches your XML)
        Button signupBtn = findViewById(R.id.signup);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Go to MenuActivity directly
                Intent intent = new Intent(RegisterActivity.this, MenuActivity.class);
                startActivity(intent);
                finish(); // optional: close the register screen
            }
        });
    }
}
