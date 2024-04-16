package com.example.headhunter.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.headhunter.R;

public class ApplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        Button buttonSubmitApplication = findViewById(R.id.buttonSubmitApplication);

        buttonSubmitApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (areFieldsValid()) {
                    Toast.makeText(ApplicationActivity.this, "Вы успешно откликнулись!", Toast.LENGTH_LONG).show();

                    new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(ApplicationActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }, 2000);
            }}
        });

    }
    private boolean areFieldsValid() {
        EditText editTextFullName = findViewById(R.id.editTextFullName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPhone = findViewById(R.id.editTextPhone);
        EditText editTextCoverLetter = findViewById(R.id.editTextCoverLetter);

        // Проверка на пустоту
        if (editTextFullName.getText().toString().trim().isEmpty()) {
            editTextFullName.setError("Full name is required");
            return false;
        }
        if (editTextEmail.getText().toString().trim().isEmpty()) {
            editTextEmail.setError("Email is required");
            return false;
        }
        if (editTextPhone.getText().toString().trim().isEmpty()) {
            editTextPhone.setError("Phone number is required");
            return false;
        }
        if (editTextCoverLetter.getText().toString().trim().isEmpty()) {
            editTextCoverLetter.setError("Cover letter is required");
            return false;
        }
        return true;
    }

}