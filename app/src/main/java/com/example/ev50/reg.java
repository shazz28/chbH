package com.example.ev50;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class reg extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg); // Ensure you have a layout file named activity_register.xml

        EditText nameBox = findViewById(R.id.NameBox);
        EditText usernameBox = findViewById(R.id.FNameBox);
        EditText passwordBox = findViewById(R.id.editTextTextPassword2);
        EditText confirmPasswordBox = findViewById(R.id.cnfPassword2);
        Button submitBtn = findViewById(R.id.SubmitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameBox.getText().toString().trim();
                String username = usernameBox.getText().toString().trim();
                String password = passwordBox.getText().toString().trim();
                String confirmPassword = confirmPasswordBox.getText().toString().trim();

                // Default credentials
                String defaultUsername = "abc";
                String defaultPassword = "abc123";

                // Check for empty fields
                if (name.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Log.d("Register", "Please fill in all fields");
                    Toast.makeText(reg.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (!password.equals(confirmPassword)) {
                    Log.d("Register", "Passwords do not match");
                    Toast.makeText(reg.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                } else if (username.equals(defaultUsername) && password.equals(defaultPassword)) {
                    // If user tries to register with default credentials
                    Log.d("Register", "Registration successful with default credentials");
                    Intent intent = new Intent(reg.this, appact.class);
                    startActivity(intent);
                    finish(); // Optionally call finish() if you don't want to return to the registration screen
                } else {
                    // Here you would normally save the new user credentials to your database
                    Log.d("Register", "Registration successful for user: " + username);
                    Intent intent = new Intent(reg.this, appact.class);
                    startActivity(intent);
                    finish(); // Optionally call finish() if you don't want to return to the registration screen
                }
            }
        });
    }
}