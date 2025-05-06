package com.example.intentobjectextra;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

    private Button btnDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDetalhe = findViewById(R.id.btnDetalhe);

        btnDetalhe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Criar o Intent
                Intent intent = new Intent(MainActivity.this, DetalheActivity.class);

                //Criar a Pessoa
                Pessoa pessoa = new Pessoa("João", 25);

                //Enviar a Pessoa para a tela Detalhe
                intent.putExtra("pessoa", pessoa);

                //Abrir a tela Detalhe
                startActivity(intent);



            }
        });

    }
}