package com.example.loginsqliteapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class AlunoActivity extends AppCompatActivity {

    EditText editTextNome, editTextRA;
    Button buttonSalvar, buttonListar;
    ListView listViewAlunos;
    DatabaseHelper db;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextUsername);
        editTextRA = findViewById(R.id.editTextPassword);
        buttonSalvar = findViewById(R.id.buttonAlunos);
        buttonListar = findViewById(R.id.buttonLogin);

        db = new DatabaseHelper(this);

        buttonSalvar.setOnClickListener(v -> {
            String nome = editTextNome.getText().toString();
            String ra = editTextRA.getText().toString();

            if (db.inserirAluno(nome, ra)) {
                Toast.makeText(this, "Aluno inserido com sucesso!", Toast.LENGTH_SHORT).show();
                editTextNome.setText("");
                editTextRA.setText("");
            } else {
                Toast.makeText(this, "Erro ao inserir aluno", Toast.LENGTH_SHORT).show();
            }
        });

        buttonListar.setOnClickListener(v -> {
            List<String> lista = db.listarAlunos();
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lista);
            listViewAlunos.setAdapter(adapter);
        });
    }
}
