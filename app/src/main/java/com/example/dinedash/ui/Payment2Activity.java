package com.example.dinedash.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View; // ✅ ADD THIS LINE
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;


public class Payment2Activity extends AppCompatActivity {

    private static final String TAG = "Payment2Activity";

    private TextInputLayout cardNumberLayout, expiryLayout, cvcLayout;
    private TextInputEditText editTextCardNumber, editTextExpiry, editTextCvc;
    private Button checkoutBtn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // find views
        cardNumberLayout = findViewById(R.id.cardNumberLayout);
        expiryLayout = findViewById(R.id.expiryLayout);
        cvcLayout = findViewById(R.id.cvcLayout);

        editTextCardNumber = findViewById(R.id.editTextCardNumber);
        editTextExpiry = findViewById(R.id.editTextExpiry);
        editTextCvc = findViewById(R.id.editTextCvc);

        checkoutBtn = findViewById(R.id.checkout);

        if (checkoutBtn != null) {
            checkoutBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onCheckoutClicked();
                }
            });
        } else {
            Log.w(TAG, "Checkout button (button7) not found");
        }
    }

    private void onCheckoutClicked() {
        // Clear previous errors
        clearErrors();

        String cardNumber = String.valueOf(editTextCardNumber != null ? editTextCardNumber.getText() : "").trim();
        String expiry = String.valueOf(editTextExpiry != null ? editTextExpiry.getText() : "").trim();
        String cvc = String.valueOf(editTextCvc != null ? editTextCvc.getText() : "").trim();

        boolean valid = true;

        if (!isValidCardNumber(cardNumber)) {
            if (cardNumberLayout != null) cardNumberLayout.setError("Enter a valid card number (13–19 digits)");
            else Toast.makeText(this, "Invalid card number", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        if (!isValidExpiry(expiry)) {
            if (expiryLayout != null) expiryLayout.setError("Enter expiry in MM/YY and ensure it's not expired");
            else Toast.makeText(this, "Invalid expiry date", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        if (!isValidCVC(cvc)) {
            if (cvcLayout != null) cvcLayout.setError("Enter a valid 3 or 4 digit CVC");
            else Toast.makeText(this, "Invalid CVC", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        if (!valid) {
            return;
        }

        // If valid — perform checkout action (navigate, show toast, etc.)
        Toast.makeText(this, "Payment details valid — proceeding to checkout", Toast.LENGTH_SHORT).show();

        // Navigate to MenuActivity (ensure MenuActivity exists)
        Intent intent = new Intent(Payment2Activity.this, ThankYouActivity.class);
        startActivity(intent);
        // optionally finish this activity:
        // finish();
    }

    private void clearErrors() {
        if (cardNumberLayout != null) cardNumberLayout.setError(null);
        if (expiryLayout != null) expiryLayout.setError(null);
        if (cvcLayout != null) cvcLayout.setError(null);
    }

    /**
     * Card number validation: digits only and length between 13 and 19.
     * (This is a simple check; in production you might run Luhn check or use a library.)
     */
    private boolean isValidCardNumber(String number) {
        if (TextUtils.isEmpty(number)) return false;
        // remove spaces if user typed grouped numbers
        String digitsOnly = number.replaceAll("\\s+", "");
        if (!digitsOnly.matches("\\d{13,19}")) return false;
        return true;
    }

    /**
     * Expiry validation: "MM/YY" format and not expired.
     * Card is considered valid through the last day of the expiry month.
     */
    private boolean isValidExpiry(String expiry) {
        if (TextUtils.isEmpty(expiry)) return false;

        String trimmed = expiry.replaceAll("\\s+", "");
        if (!trimmed.matches("(0[1-9]|1[0-2])/(\\d{2})")) {
            return false;
        }

        String[] parts = trimmed.split("/");
        int month;
        int yearTwoDigits;
        try {
            month = Integer.parseInt(parts[0]);
            yearTwoDigits = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            return false;
        }

        int fullYear = 2000 + yearTwoDigits;

        Calendar expiryCal = Calendar.getInstance();
        expiryCal.clear();
        expiryCal.set(Calendar.YEAR, fullYear);
        expiryCal.set(Calendar.MONTH, month - 1);
        int lastDay = expiryCal.getActualMaximum(Calendar.DAY_OF_MONTH);
        expiryCal.set(Calendar.DAY_OF_MONTH, lastDay);
        expiryCal.set(Calendar.HOUR_OF_DAY, 23);
        expiryCal.set(Calendar.MINUTE, 59);
        expiryCal.set(Calendar.SECOND, 59);
        expiryCal.set(Calendar.MILLISECOND, 999);

        Calendar now = Calendar.getInstance();

        return now.compareTo(expiryCal) <= 0;
    }

    /**
     * CVC validation: 3 or 4 digits.
     */
    private boolean isValidCVC(String cvc) {
        if (TextUtils.isEmpty(cvc)) return false;
        String digitsOnly = cvc.replaceAll("\\s+", "");
        return digitsOnly.matches("\\d{3,4}");
    }
}
