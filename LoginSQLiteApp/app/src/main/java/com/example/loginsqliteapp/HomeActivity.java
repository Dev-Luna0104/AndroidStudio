package com.example.loginsqliteapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    Button buttonAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        buttonAlunos = findViewById(R.id.buttonAlunos);

        buttonAlunos.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, com.example.loginsqliteapp.AlunoActivity.class);
            startActivity(intent);
        });
    }
}
