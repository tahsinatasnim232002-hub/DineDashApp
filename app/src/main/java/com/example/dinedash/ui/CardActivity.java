package com.example.dinedash.ui;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dinedash.R;

public class CardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        // Optional: Show a message
        Toast.makeText(this, "Card payment feature coming soon!", Toast.LENGTH_SHORT).show();
    }
}
