package com.example.intentobjectextra;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


public class MainActivity extends Activity {

    Button btnSalvarCadastro;
    EditText edtNome, edtIdade;
    Spinner spnCurso;
    RadioGroup rgGenero, rgStatusMatricula;
    RadioButton rbMasculino, rbFeminino, rbEmCurso, rbTrancado;
    String nome, curso, genero, statusMatricula;
    int idade;
    Intent intent;
    Pessoa aluno;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalvarCadastro = findViewById(R.id.btnSalvarCadastro);

        edtNome = findViewById(R.id.txtNome);
        edtIdade = findViewById(R.id.txtIdade);
        spnCurso = findViewById(R.id.spnCurso);
        rgGenero = findViewById(R.id.rdgGenero);
        rgStatusMatricula = findViewById(R.id.chbStatusMatricula);
        rbMasculino = findViewById(R.id.rdbMasculino);
        rbFeminino = findViewById(R.id.rdbFeminino);

        configuraSpinner();

        btnSalvarCadastro.setOnClickListener(v -> {
            nome = edtNome.getText().toString();
            idade = Integer.parseInt(edtIdade.getText().toString());
            curso = spnCurso.getSelectedItem().toString();

            if (rbMasculino.isChecked()){
                genero = "Masculino";
            } else if (rbFeminino.isChecked()) {
                genero = "Feminino";
            }

            if(rbEmCurso.isChecked()){
                statusMatricula = "Em curso";
            } else if (rbTrancado.isChecked()) {
                statusMatricula = "Trancado";
            }

            aluno = new Pessoa(nome, idade, curso, genero, statusMatricula);
            intent = new Intent(MainActivity.this, DetalheActivity.class);
            intent.putExtra("aluno", aluno);

            startActivity(intent);
        });

    }

    public void configuraSpinner(){
        String[] cursos = new String[]{"Informática", "Mecânica", "Eletrônica"};

        //criar um adaptador para o spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cursos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //associar o adaptador ao spinner
        spnCurso.setAdapter(adapter);

    }

}