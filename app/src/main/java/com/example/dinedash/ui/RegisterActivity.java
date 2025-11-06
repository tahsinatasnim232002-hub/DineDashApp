package com.example.dinedash.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dinedash.R;
import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {

    private static final String TAG = "RegisterActivity";
    private TextInputEditText nameInput; // may be null if no id in XML; we try to find it
    private EditText emailInput, passwordInput, confirmPasswordInput;
    private Button signupBtn;

    // SharedPreferences demo keys (for simple local demo storage)
    private static final String PREFS_NAME = "dinedash_prefs";
    private static final String KEY_REGISTERED_NAME = "registered_name";
    private static final String KEY_REGISTERED_EMAIL = "registered_email";
    private static final int MIN_PASSWORD_LENGTH = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register); // make sure this matches your XML filename

        // --- SAFE name lookup: try to resolve id by name first (avoids compile error if id not present)
        int nameId = getResources().getIdentifier("nameInput", "id", getPackageName());
        if (nameId != 0) {
            // id exists in resources
            View maybe = findViewById(nameId);
            if (maybe instanceof TextInputEditText) {
                nameInput = (TextInputEditText) maybe;
            }
        }

        // If we still don't have nameInput, fallback to searching the view tree for first TextInputEditText
        if (nameInput == null) {
            View root = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
            nameInput = findFirstTextInputEditText(root);
            if (nameInput == null) {
                Log.w(TAG, "Name input not found (no id and no TextInputEditText present).");
            }
        }

        // These IDs exist in your XML (you posted them)
        emailInput = findViewById(R.id.editTextTextEmailAddress);
        passwordInput = findViewById(R.id.editTextTextPassword);
        confirmPasswordInput = findViewById(R.id.editTextTextPassword2);
        signupBtn = findViewById(R.id.button3);

        if (signupBtn != null) {
            signupBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onSignupClicked();
                }
            });
        } else {
            Toast.makeText(this, "Sign up button not found in layout", Toast.LENGTH_SHORT).show();
        }
    }

    private void onSignupClicked() {
        // Clear previous errors (if any)
        if (nameInput != null) nameInput.setError(null);
        if (emailInput != null) emailInput.setError(null);
        if (passwordInput != null) passwordInput.setError(null);
        if (confirmPasswordInput != null) confirmPasswordInput.setError(null);

        String name = nameInput != null ? String.valueOf(nameInput.getText()).trim() : "";
        String email = emailInput != null ? String.valueOf(emailInput.getText()).trim() : "";
        String password = passwordInput != null ? String.valueOf(passwordInput.getText()) : "";
        String confirmPassword = confirmPasswordInput != null ? String.valueOf(confirmPasswordInput.getText()) : "";

        boolean valid = true;

        // Validate name
        if (name.isEmpty()) {
            if (nameInput != null) nameInput.setError("Enter your name");
            else Toast.makeText(this, "Enter your name", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        // Validate email
        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (emailInput != null) emailInput.setError("Enter a valid email address");
            else Toast.makeText(this, "Enter a valid email address", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        // Validate password
        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            if (passwordInput != null) passwordInput.setError("Password must be at least " + MIN_PASSWORD_LENGTH + " characters");
            else Toast.makeText(this, "Password must be at least " + MIN_PASSWORD_LENGTH + " characters", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        // Confirm password
        if (!password.equals(confirmPassword)) {
            if (confirmPasswordInput != null) confirmPasswordInput.setError("Passwords do not match");
            else Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            valid = false;
        }

        if (!valid) return;

        // Save demo registration data to SharedPreferences (DO NOT store raw passwords in production)
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        prefs.edit()
                .putString(KEY_REGISTERED_NAME, name)
                .putString(KEY_REGISTERED_EMAIL, email)
                .apply();

        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show();

        // Navigate to LoginActivity (step 2). Change to MenuActivity if you want to go directly to home.
        try {
            Intent intent = new Intent(RegisterActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            // If LoginActivity doesn't exist yet, try MenuActivity as fallback
            Log.w(TAG, "LoginActivity not found; falling back to MenuActivity. Exception: " + e.getMessage());
            try {
                Intent fallback = new Intent(RegisterActivity.this, MenuActivity.class);
                startActivity(fallback);
                finish();
            } catch (Exception ex) {
                Toast.makeText(this, "Registered but can't navigate: create LoginActivity or MenuActivity", Toast.LENGTH_LONG).show();
                Log.e(TAG, "Navigation failed: " + ex.getMessage());
            }
        }
    }

    /**
     * Recursively search view tree for the first TextInputEditText instance.
     * This helps when your XML's TextInputEditText has no id.
     */
    private TextInputEditText findFirstTextInputEditText(View root) {
        if (root == null) return null;
        if (root instanceof TextInputEditText) {
            return (TextInputEditText) root;
        }
        if (root instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) root;
            for (int i = 0; i < vg.getChildCount(); i++) {
                View child = vg.getChildAt(i);
                TextInputEditText found = findFirstTextInputEditText(child);
                if (found != null) return found;
            }
        }
        return null;
    }
}
