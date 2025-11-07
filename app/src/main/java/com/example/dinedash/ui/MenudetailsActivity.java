package com.example.dinedash.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dinedash.R;
import com.example.dinedash.model.MenuItem;
import java.util.ArrayList;

public class MenudetailsActivity extends AppCompatActivity {

    private LinearLayout detailContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menudetails);

        detailContainer = findViewById(R.id.detailcontainer);

        ArrayList<MenuItem> selectedItems = getIntent().getParcelableArrayListExtra("selected_items");
        if (selectedItems != null) {
            double total = 0;
            for (MenuItem item : selectedItems) {
                TextView tv = new TextView(this);
                tv.setText(item.getName() + " - ৳" + item.getPrice());
                tv.setTextSize(16);
                detailContainer.addView(tv);
                total += item.getPrice();
            }

            TextView totalText = new TextView(this);
            totalText.setText("Total: Taka" + total);
            totalText.setTextSize(18);
            totalText.setPadding(16,16,16,16);
            detailContainer.addView(totalText);
        }
    }
}
