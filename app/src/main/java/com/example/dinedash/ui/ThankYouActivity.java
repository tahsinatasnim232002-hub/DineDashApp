package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;

public class ThankYouActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

        Button continueBtn = findViewById(R.id.button8);

        // Continue button click → back to Home/Menu or MainActivity
        continueBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ThankYouActivity.this, MenuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}
