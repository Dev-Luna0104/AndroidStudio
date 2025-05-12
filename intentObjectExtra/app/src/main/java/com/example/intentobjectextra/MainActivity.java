package com.example.intentobjectextra;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

        Button = findViewById(R.id.btnSalvarCadastro);

        Spinner = findViewById(R.id.spnCurso);

        configuraSpinner();


    }

}