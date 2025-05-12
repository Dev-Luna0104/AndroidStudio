package com.example.intentobjectextra;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends Activity {

    Button btnSalvarCadastro;
    Spinner spnCurso;
    String curso;
    Intent intent;
    Bundle bundle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSalvarCadastro = findViewById(R.id.btnSalvarCadastro);

        spnCurso = findViewById(R.id.spnCurso);

        configuraSpinner();


    }

    public void configuraSpinner(){
        String[] cursos = new String[]{"Informática", "Mecânica", "Eletrônica"};

        //criar um adaptador para o spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cursos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //associar o adaptador ao spinner
        spnCurso.setAdapter(adapter);

    }

}