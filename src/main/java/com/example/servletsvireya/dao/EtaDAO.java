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
        String comando = "INSERT INTO ETA (id, nome, capacidade) " +
                "VALUES (?, ?, ?)";
        try(PreparedStatement pstmt = conn.prepareStatement(comando)){
            pstmt.setInt(1, eta.getId());
            pstmt.setString(2, eta.getNome());
            pstmt.setInt(3, eta.getCapacidade());

            return pstmt.executeUpdate(); //
        }
        catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        }
        finally {
            conexao.desconectar();
        }
    }


    // Método listar as ETAs
    public List<Eta> listarETA(){
        ResultSet rs = null;
        List<Eta> etas = new ArrayList<>();

        Connection conn = conexao.conectar();
        String comando = "INSERT INTO ETA (id, nome, capacidade) VALUES (?, ?, ?)";
        try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ETA ORDER BY id")){
            rs = pstmt.executeQuery();

            while(rs.next()){
                Eta eta = new Eta();
                eta.setId(rs.getInt("id"));
                eta.setNome(rs.getString("nome"));
                eta.setCapacidade(rs.getInt("capacidade"));

                //Populando o list
                etas.add(eta);
            }
            return etas;

        }catch (SQLException sqle){
            sqle.printStackTrace();
            return new ArrayList<>();
        }finally {
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

            //aqui verificar se a eta existe

            if (pstmt.executeUpdate() > 0) {
                return 1; //Deleção bem sucedida
            } else {
                return 0;
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        } finally {
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