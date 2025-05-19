// Produto.java
package com.example.listadeproduto01;

import java.io.Serializable;

public class Produto implements Serializable {
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;

    public Produto(int codigo, String nome, String descricao, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }
    public double getPreco() { return preco; }

    @Override
    public String toString() {
        return nome;
    }
}
