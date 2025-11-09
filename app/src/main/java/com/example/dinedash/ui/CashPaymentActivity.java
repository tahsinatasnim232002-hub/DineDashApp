package com.example.dinedash.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dinedash.R;

public class CashPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash);

        // Button reference from XML
        Button proceedBtn = findViewById(R.id.proceedBtn);

        proceedBtn.setOnClickListener(v -> {
            Intent intent = new Intent(CashPaymentActivity.this, ThankYouActivity.class);
            startActivity(intent);
        });
    }
}
