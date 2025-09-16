package com.example.servletsvireya.model;

import java.sql.Date;
import java.time.LocalDate;

public class Estoque {  //alteração teste
    private int id;                  // Identificador único
    private int quantidade;          // Quantidade estocada de tal produto
    private LocalDate data_validade; // Data de validade de tal produto
    private int min_possiv_estocado; // Mínimo possível que tem que estar estocado desse produto (??)
    private int id_eta;              //FK. ETA que esse estoque desse produto pertence
    private int id_produto;          //FK. Produto já cadastrado no sistema, mas não no estoque

    //Métodos Construtores
    public Estoque(int id, int quantidade, LocalDate data_validade, int min_possiv_estocado, int id_eta, int id_produto) {
        this.id = id;
        this.quantidade = quantidade;
        this.data_validade = data_validade;
        this.min_possiv_estocado = min_possiv_estocado;
        this.id_eta = id_eta;
        this.id_produto = id_produto;
    }
    public Estoque(){
    }

    //Getters
    public int getId() {
        return id;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public LocalDate getData_validade() {
        return data_validade;
    }
    public int getMin_possiv_estocado() {
        return min_possiv_estocado;
    }
    public int getId_eta() {
        return id_eta;
    }
    public int getId_produto() {
        return id_produto;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setData_validade(LocalDate data_validade) {
        this.data_validade = data_validade;
    }
    public void setMin_possiv_estocado(int min_possiv_estocado) {
        this.min_possiv_estocado = min_possiv_estocado;
    }
    public void setId_eta(int id_eta) {
        this.id_eta = id_eta;
    }
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }
}
