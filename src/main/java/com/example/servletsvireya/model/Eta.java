package com.example.servletsvireya.model;

public class Eta {
    private int id; // Primary Key
    private String nome;
    private int capacidade;

    // Contrutores

    public Eta(){}
    public Eta(int id, String nome, int capacidade){
        this.id = id;
        this.nome = nome;
        this.capacidade = capacidade;
    }

    // Getters e Setters
    public int getId(){ return this.id; }
    public String getNome(){ return this.nome; }
    public int getCapacidade(){ return this.capacidade; }

    public void setId(int id){ this.id = id; }
    public void setNome(String nome){ this.nome = nome; }
    public void setCapacidade(int capacidade){ this.capacidade = capacidade; }
}