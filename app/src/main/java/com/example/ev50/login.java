package com.example.ev50;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText nameBox = findViewById(R.id.NameBox);
        EditText passwordBox = findViewById(R.id.editTextTextPassword);
        Button submitBtn = findViewById(R.id.SubmitBtn);
        TextView registerLink = findViewById(R.id.register); // Link to register activity

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = nameBox.getText().toString().trim();
                String password = passwordBox.getText().toString().trim();

                // Default credentials
                String defaultUsername = "abc";
                String defaultPassword = "abc123";

                // Check for default credentials
                if (username.isEmpty() || password.isEmpty()) {
                    Log.d("Login", "Please fill in all fields");
                    Toast.makeText(login.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else if (username.equals(defaultUsername) && password.equals(defaultPassword)) {
                    Log.d("Login", "Login successful with default credentials");
                    Intent intent = new Intent(login.this, appact.class);
                    startActivity(intent);
                    finish(); // Optionally call finish() if you don't want to return to the login screen
                } else {
                    Log.d("Login", "Invalid credentials");
                    Toast.makeText(login.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start RegisterActivity
                Intent intent = new Intent(login.this, reg.class); // Ensure RegisterActivity is correctly named
                startActivity(intent);
            }
        });
    }
}