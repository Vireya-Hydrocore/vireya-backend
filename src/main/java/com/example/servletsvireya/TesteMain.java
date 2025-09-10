package com.example.servletsvireya;

import com.example.servletsvireya.util.Conexao;

public class TesteMain {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();

        conexao.conectar();
        conexao.desconectar();
    }
}
