package com.example.servletsvireya.dao;
import com.example.servletsvireya.model.Eta;
import com.example.servletsvireya.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtaDAO {
    Conexao conexao;

    public EtaDAO(){ this.conexao = new Conexao(); }

    // Método inserirEta()

    public int inserirETA(Eta eta){
        conexao.conectar();
        try( PreparedStatement pstmt = conexao.getConn().prepareStatement("INSERT INTO ETA (id, nome, capacidade, telefone) VALUES (?, ?, ?, ?)")){

            pstmt.setInt(1, eta.getId());
            pstmt.setString(2, eta.getNome());
            pstmt.setInt(3, eta.getCapacidade());
            pstmt.setString(4, eta.getTelefone());

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

        conexao.conectar();

        try(PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ETA WHERE id = ?")){

            pstmt.setInt(1, eta.getId());
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()){
                eta.setId(rs.getInt("id"));
                eta.setNome(rs.getString("nome"));
                eta.setCapacidade(rs.getInt("capacidade"));
                eta.setTelefone(rs.getString("telefone"));

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


    // Método buscarTodasEtas()

    public List<Eta> buscarTodasEtas() {

        List<Eta> etas = new ArrayList<>();
        conexao.conectar();

        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM ETA")) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Eta eta = new Eta();
                eta.setId(rs.getInt("id"));
                eta.setNome(rs.getString("nome"));
                eta.setCapacidade(rs.getInt("capacidade"));
                eta.setTelefone(rs.getString("telefone"));

                etas.add(eta);
            }

            return etas;
        }
        catch (SQLException e) {
            return null;
        }
        finally {
            conexao.desconectar();
        }
    }

    // Método alterarETA()

    public int alterarETA(Eta eta){
        conexao.conectar();
        try(PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE ETA SET nome = ?, capacidade = ?, telefone = ? WHERE id = ?")){

            pstmt.setString(1, eta.getNome());
            pstmt.setInt(2, eta.getCapacidade());
            pstmt.setString(3, eta.getTelefone());
            pstmt.setInt(4, eta.getId());

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
        conexao.conectar();
        try(PreparedStatement pstmt = conexao.getConn().prepareStatement("DELETE FROM ETA WHERE id = ?")){

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
        conexao.conectar();
        try(PreparedStatement pstmt = conexao.getConn().prepareStatement("DELETE FROM ETA WHERE id NOT IN (SELECT MIN(id) FROM ETA GROUP BY nome, capacidade, telefone)")){

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
