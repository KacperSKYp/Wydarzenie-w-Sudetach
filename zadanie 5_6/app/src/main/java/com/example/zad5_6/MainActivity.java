package com.example.zad5_6;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int likeCount = 0;
    private String lastRegisteredEmail = "";
    private TextView likesCounter;
    private TextView infoArea;
    private EditText emailInput;
    private EditText passwordInput;
    private EditText confirmPasswordInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        likesCounter = findViewById(R.id.likesCounter);
        infoArea = findViewById(R.id.infoArea);
        emailInput = findViewById(R.id.emailInput);
        passwordInput = findViewById(R.id.passwordInput);
        confirmPasswordInput = findViewById(R.id.confirmPasswordInput);
        Button likeButton = findViewById(R.id.likeButton);
        Button unlikeButton = findViewById(R.id.unlikeButton);
        Button saveButton = findViewById(R.id.saveButton);
        Button showParticipantButton = findViewById(R.id.showParticipantButton);

        // Like button functionality
        likeButton.setOnClickListener(v -> {
            likeCount++;
            updateLikesDisplay();
        });

        // Unlike button functionality
        unlikeButton.setOnClickListener(v -> {
            if (likeCount > 0) {
                likeCount--;
                updateLikesDisplay();
            }
        });

        // Save button functionality
        saveButton.setOnClickListener(v -> {
            String email = emailInput.getText().toString();
            String password = passwordInput.getText().toString();
            String confirmPassword = confirmPasswordInput.getText().toString();

            if (!email.contains("@")) {
                infoArea.setText("Nieprawidłowy adres e-mail");
            } else if (!password.equals(confirmPassword)) {
                infoArea.setText("Hasła się różnią");
            } else {
                lastRegisteredEmail = email;
                infoArea.setText("Zarejestrowano: " + email);
            }
        });

        // Show participant button functionality
        showParticipantButton.setOnClickListener(v -> {
            if (!lastRegisteredEmail.isEmpty()) {
                infoArea.setText(lastRegisteredEmail);
            }
        });
    }

    private void updateLikesDisplay() {
        likesCounter.setText(likeCount + " polubień");
    }
}
