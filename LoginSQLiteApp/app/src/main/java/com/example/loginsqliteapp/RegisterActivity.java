package com.example.loginsqliteapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextRegUsername, editTextRegPassword, editTextRegConfirmPassword;
    Button buttonCreateAccount;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextRegUsername = findViewById(R.id.editTextRegUsername);
        editTextRegPassword = findViewById(R.id.editTextRegPassword);
        editTextRegConfirmPassword = findViewById(R.id.editTextRegConfirmPassword);
        buttonCreateAccount = findViewById(R.id.buttonCreateAccount);

        db = new DatabaseHelper(this);

        buttonCreateAccount.setOnClickListener(view -> {
            String username = editTextRegUsername.getText().toString();
            String password = editTextRegPassword.getText().toString();
            String confirmPassword = editTextRegConfirmPassword.getText().toString();

            if (!password.equals(confirmPassword)) {
                Toast.makeText(RegisterActivity.this, "Senhas não coincidem", Toast.LENGTH_SHORT).show();
            } else {
                if (db.registerUser(username, password)) {
                    Toast.makeText(RegisterActivity.this, "Conta criada com sucesso", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "Erro ao criar conta", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
