package com.example.exerciciosqllite;

public class Pessoa {
    private String nome;
    private int idade;
    private double imc;
    private String categoria;

    public Pessoa(String nome, int idade, double imc, String categoria) {
        this.nome = nome;
        this.idade = idade;
        this.imc = imc;
        this.categoria = categoria ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
