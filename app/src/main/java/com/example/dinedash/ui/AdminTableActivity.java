package com.example.dinedash.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dinedash.R;

public class AdminTableActivity extends AppCompatActivity {

    private TextView titleText;
    private Button table1Btn, table2Btn, table3Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminpage03);

        // view init
//        titleText = findViewById(R.id.textView10);
//        table1Btn = findViewById(R.id.button12);
//        table2Btn = findViewById(R.id.button13);
//        table3Btn = findViewById(R.id.button14);
//
//        // Click listeners (single-page behavior)
//        table1Btn.setOnClickListener(v -> onTableSelected("Table-01"));
//        table2Btn.setOnClickListener(v -> onTableSelected("Table-02"));
//        table3Btn.setOnClickListener(v -> onTableSelected("Table-03"));
    }

    /**
     * Handles table selection on the same page.
     * Updates title and shows an action dialog (View / Confirm / Cancel).
     */
    private void onTableSelected(String tableName) {
        // Update the top title to reflect selected table
        titleText.setText(tableName + " Order");

        // Show options in a dialog (you can replace with BottomSheet if preferred)
        String[] options = {"View Orders", "Confirm Order", "Cancel"};
        new AlertDialog.Builder(this)
                .setTitle(tableName)
                .setItems(options, (dialog, which) -> {
                    switch (which) {
                        case 0: // View Orders
                            // For now: simple placeholder action. Replace with real view logic.
                            Toast.makeText(AdminTableActivity.this,
                                    "Viewing orders for " + tableName, Toast.LENGTH_SHORT).show();
                            // TODO: show an orders list below, or open a fragment/dialog with details
                            break;

                        case 1: // Confirm Order
                            // Placeholder: you might call API or update DB here.
                            Toast.makeText(AdminTableActivity.this,
                                    "Order confirmed for " + tableName, Toast.LENGTH_SHORT).show();
                            break;

                        case 2: // Cancel
                            dialog.dismiss();
                            break;
                    }
                })
                .show();
    }
}
