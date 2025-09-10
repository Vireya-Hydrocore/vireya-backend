package com.example.servletsvireya.dao;

import com.example.servletsvireya.model.Eta;
import com.example.servletsvireya.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EtaDAO {
    Conexao conexao;

    public EtaDAO(){ this.conexao = new Conexao(); }

    // Método inserirEta()

    public int inserirETA(Eta eta){
        Connection conn = conexao.conectar();
        try( PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ETA (id, nome, capacidade) VALUES (?, ?, ?)")){

            pstmt.setInt(1, eta.getId());
            pstmt.setString(2, eta.getNome());
            pstmt.setInt(3, eta.getCapacidade());

            return pstmt.executeUpdate();
        }
        catch (SQLException sqle){
            return -1;
        }
        finally {
            conexao.desconectar();
        }
    }

    // Método buscarETA()

    public List<Eta> buscarETA(Eta eta){
        List<Eta> etas = new ArrayList<>();

        Connection conn = conexao.conectar();

        try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ETA WHERE id = ?")){

            pstmt.setInt(1, eta.getId());
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                eta.setId(rs.getInt("id"));
                eta.setNome(rs.getString("nome"));
                eta.setCapacidade(rs.getInt("capacidade"));

                etas.add(eta);
            }
            return etas;
        }
        catch (SQLException sqle){
            return null;
        }
        finally {
            conexao.desconectar();
        }
    }

    // Método alterarETA()

    public int alterarETA(Eta eta){
        Connection conn = conexao.conectar();
        try(PreparedStatement pstmt = conn.prepareStatement("UPDATE ETA SET nome = ?, capacidade = ? WHERE id = ?")){

            pstmt.setString(1, eta.getNome());
            pstmt.setInt(2, eta.getCapacidade());
            pstmt.setInt(3, eta.getId());

            return pstmt.executeUpdate();
        }
        catch (SQLException sqle){
            return -1;
        }
        finally {
            conexao.desconectar();
        }
    }


    // Método remover()

    public int removerETA(Eta eta){
        Connection conn = conexao.conectar();
        try(PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ETA WHERE id = ?")){

            pstmt.setInt(1,eta.getId());
            return pstmt.executeUpdate();
        }
        catch (SQLException sqle){
            return -1;
        }
        finally {
            conexao.desconectar();
        }
    }

    // Método removerDuplicadas()

    public int removerDuplicadas(){
        Connection conn = conexao.conectar();
        try(PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ETA WHERE id NOT IN (SELECT MIN(id) FROM ETA GROUP BY nome, capacidade)")){

            int qtdRemovida = pstmt.executeUpdate();
            return qtdRemovida;
        }
        catch (SQLException sqle){
            return -1;
        }
        finally {
            conexao.desconectar();
        }
    }
}