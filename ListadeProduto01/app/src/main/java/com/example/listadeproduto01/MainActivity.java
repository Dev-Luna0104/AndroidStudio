package com.example.listadeproduto01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView listaProdutos;
    private ArrayList<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaProdutos = findViewById(R.id.listaProdutos);
        produtos = new ArrayList<>();

        produtos.add(new Produto(1, "Notebook", "Notebook Dell com 16GB RAM", 3500.00));
        produtos.add(new Produto(2, "Mouse", "Mouse sem fio Logitech", 99.90));
        produtos.add(new Produto(3, "Teclado", "Teclado mecânico RGB", 199.90));

        ArrayAdapter<Produto> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, produtos);

        listaProdutos.setAdapter(adapter);

        listaProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Produto selecionado = produtos.get(position);
                Intent intent = new Intent(MainActivity.this, DetalheProdutoActivity.class);
                intent.putExtra("produto", selecionado);
                startActivity(intent);
            }
        });
    }
}
