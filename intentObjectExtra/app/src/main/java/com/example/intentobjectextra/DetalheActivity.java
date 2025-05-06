package com.example.intentobjectextra;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class DetalheActivity extends Activity {

    private TextView txtNome, txtIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detalhe);

        //Recuperar a Pessoa da Intent
        Pessoa pessoa = (Pessoa) getIntent().getSerializableExtra("pessoa");

        //Recuperar os componentes da tela
        txtNome = findViewById(R.id.txtnome);
        txtIdade = findViewById(R.id.txtidade);

        //Exibir os dados da Pessoa
        txtNome.setText(pessoa.getNome());
        txtIdade.setText(String.valueOf(pessoa.getIdade()));

    }
}