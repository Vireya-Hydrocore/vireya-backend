package com.example.servletsvireya.model;
public class Produto {
    private int id;                // Identificador único
    private String nome;           // ex: Sulfato de Alumínio
    private String tipo;           // ex: Coagulante, Desinfetante
    private String unidade_medida; // ex: mg/L, %, etc.
    private double concentracao;   // ex: 12.5, 3.7, etc.

    //Construtores
    public Produto(int id, String nome, String tipo, String unidade_medida, double concentracao) { //tive que criar para adicionar nos metodos de listar
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.unidade_medida = unidade_medida;
        this.concentracao = concentracao;
    }
    public Produto(String nome, String tipo, String unidade_medida, double concentracao) {
        this.nome = nome;
        this.tipo = tipo;
        this.unidade_medida = unidade_medida;
        this.concentracao = concentracao;
    }
    public Produto(int id){
        this.id = id;
    }
    public Produto(){

    }

//    public String toString(){
//        return "ID: "+id+" Nome: "+nome+" Tipo: "+tipo+" Unidade de Medida: "+unidade_medida+" Concentração: "+concentracao;
//    }

    //Getters
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public double getConcentracao(){
        return concentracao;
    }
    public String getUnidade_medida(){
        return unidade_medida;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }
    public void setConcentracao(double concentracao) {
        this.concentracao = concentracao;
    }
}
