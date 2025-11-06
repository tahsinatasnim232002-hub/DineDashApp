package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;

public class ThankYouActivity extends AppCompatActivity {

    private Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou); // make sure XML file name matches

        // Find the button
        continueBtn = findViewById(R.id.button8);

        // Set click listener
        continueBtn.setOnClickListener(v -> {
            // Navigate to MenuActivity (home screen)
            Intent intent = new Intent(ThankYouActivity.this, MenuActivity.class);
            startActivity(intent);
            finish(); // finish this activity so user can't go back to Thank You screen with back button
        });
    }
}
