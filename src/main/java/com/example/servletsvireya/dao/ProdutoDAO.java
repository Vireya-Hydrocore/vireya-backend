package com.example.servletsvireya.dao;

import com.example.servletsvireya.model.Produto;
import com.example.servletsvireya.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProdutoDAO {
    private final Conexao conexao = new Conexao(); //Só para os método de conectar() e desconectar()


    //Método para cadastrar um produto no sistema
    public int cadastrarProduto(Produto produto){ //Cadastra no sistema mas NÃO insere no estoque
        try{
            Connection conn = conexao.conectar(); //Conecta ao banco de dados
            //Prepara a declaração SQL para inserir o produto
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO produto(nome, tipo, unidade_medida, concentracao) values(?, ?, ?, ?)");

            //Setando valores usando a classe model
            pstmt.setString(1, produto.getNome());
            pstmt.setString(2, produto.getTipo());
            pstmt.setString(3, produto.getUnidade_medida());
            pstmt.setDouble(4, produto.getConcentracao());

            if(pstmt.executeUpdate() > 0){ //Se modificar alguma linha
                return 1; //Inserção bem sucedida
            } else{
                return 0; //Não foi possível inserir
            }
        } catch(SQLException e){
            e.printStackTrace();
            return -1; //Para indicar erro no banco de dados
        }
        finally{
            conexao.desconectar(); //Por fim, mesmo que passe pela exceção, desconecta
        }
    }

    //Método para remover um produto (pelo ID)
    public int removerProduto(Produto produto) {
        try {
            Connection conn = conexao.conectar();

            //Aqui precisa verificar se o id do produto existe (??)

            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM produto WHERE id = ?");
            pstmt.setInt(1, produto.getId());

            if (pstmt.executeUpdate() > 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    //Métodos para alterar concentração e unidade de medida ////////Pode mudar né?
    public int alterarConcentracao(Produto produto){ //Altera a concentração (por ID)
        try{
            Connection conn = conexao.conectar();

            PreparedStatement pstmt = conn.prepareStatement("UPDATE produto SET concentracao = ? WHERE id = ?");
            pstmt.setDouble(1, produto.getConcentracao());
            pstmt.setInt(2, produto.getId());

            if (pstmt.executeUpdate() > 0){
                return 1;
            } else{
                return 0;
            }
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    //Altera unidade de medida do produto
    public int alterarUnidadeMedida(Produto produto){ //Altera a concentração (por
        try{
            Connection conn = conexao.conectar();

            PreparedStatement pstmt = conn.prepareStatement("UPDATE produto SET unidade_medida = ? WHERE id = ?");
            pstmt.setString(1, produto.getUnidade_medida());
            pstmt.setInt(2, produto.getId());

            if (pstmt.executeUpdate() > 0){
                return 1;
            } else{
                return 0;
            }
        } catch(SQLException e){
            e.printStackTrace();
            return -1;
        } finally {
            conexao.desconectar();
        }
    }

    //Método para listar produtos ////////////////// Usar list (não sei como)
    public List<Produto> listarProduto(){
        List<Produto> produtos = new ArrayList<>();
        try{
            ResultSet rset = null; //Consulta da tabela
            Connection conn = conexao.conectar();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM produto ORDER BY id");
            rset = pstmt.executeQuery(); //Executa a consulta com Query

            //Armazenar os valores em um List<>
            while (rset.next()){
                int id = rset.getInt(1); //Pega a primeira coluna do select
                String nome = rset.getString(2);
                String tipo = rset.getString(3);
                String unidadeMedida = rset.getString(4);
                double concentracao = rset.getDouble(5);

                //Populando o List
                produtos.add(new Produto(id, nome, tipo, unidadeMedida, concentracao));
            }

        } catch (SQLException e){
            e.printStackTrace();
            return new ArrayList<>(); //Retorna lista vazia
        } finally {
            conexao.desconectar();
        }
        return produtos; //Retorna o List com os resultados
    }
}
