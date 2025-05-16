package com.example.intentobjectextra;

import java.io.Serializable;

//value
public class Pessoa implements Serializable {

    private String nome;
    private int idade;
    private String curso;
    private String genero;
    private String statusMatricula;

    public Pessoa(String nome, int idade, String curso, String genero, String statusMatricula) {
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
        this.genero = genero;
        this.nome = statusMatricula;

    }

    public String getStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(String statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
