package com.example.listadeproduto01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class DetalheProdutoActivity extends Activity {

    private TextView txtCodigo, txtNome, txtDescricao, txtPreco;

    //btnvoltar
    private Button btnVoltar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_produto);

        txtCodigo = findViewById(R.id.txtCodigo);
        txtNome = findViewById(R.id.txtNome);
        txtDescricao = findViewById(R.id.txtDescricao);
        txtPreco = findViewById(R.id.txtPreco);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Produto produto = (Produto) getIntent().getSerializableExtra("produto");

        if (produto != null) {
            txtCodigo.setText("Código: " + produto.getCodigo());
            txtNome.setText("Nome: " + produto.getNome());
            txtDescricao.setText("Descrição: " + produto.getDescricao());
            txtPreco.setText("Preço: R$ " + String.format("%.2f", produto.getPreco()));
        }
    }
}
