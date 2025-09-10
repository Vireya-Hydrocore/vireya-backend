package com.example.servletsvireya.dao;

import com.example.servletsvireya.model.Funcionario;
import com.example.servletsvireya.util.Conexao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class FuncionarioDAO {

    Conexao conexao;

    public FuncionarioDAO (){
        this.conexao = new Conexao();
    }

    // Método inserir()

    public int inserirFuncionario(Funcionario funcionario){
        Connection conn = conexao.conectar();

        try(PreparedStatement pstmt = conn.prepareStatement("INSERT INTO funcionario (id, nome, email, data_admissao, data_nascimento, id_eta, id_cargo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")){

            pstmt.setInt(1, funcionario.getId());
            pstmt.setString(2, funcionario.getNome());
            pstmt.setString(3, funcionario.getEmail());
            pstmt.setDate(4, Date.valueOf(funcionario.getDataAdmissao()));
            pstmt.setDate(5, Date.valueOf(funcionario.getDataNascimento()));
            pstmt.setInt(6, funcionario.getIdETA());
            pstmt.setInt(7, funcionario.getIdCargo());

            return pstmt.executeUpdate();

        } catch (SQLException sqle){
            return -1;

        } finally {
            conexao.desconectar();
        }
    }

    // Método buscarFuncionario()

    public List<Funcionario> buscarFuncionario(Funcionario funcionario){
        List<Funcionario> funcionarios = new ArrayList<>();
        Connection conn = conexao.conectar();

        try(PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Funcionario WHERE id = ?")){

            pstmt.setInt(1, funcionario.getId());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setDataAdmissao(rs.getDate("data_admissao").toLocalDate()); // .toLocalDate - Pega a data no SQL em tranforma em um LocalDate em Java
                funcionario.setDataNascimento(rs.getDate("data_nascimento").toLocalDate()); // .toLocalDate - Pega a data no SQL em tranforma em um LocalDate em Java
                funcionario.setIdETA(rs.getInt("id_eta"));
                funcionario.setIdCargo(rs.getInt("id_cargo"));

                funcionarios.add(funcionario);

            }
            return funcionarios;

        } catch (SQLException sqle){
            return null;

        } finally {
            conexao.desconectar();
        }
    }

    // Método alterarFuncionario

    public int alterarFuncionario(Funcionario funcionario){
        Connection conn = conexao.conectar();
        try(PreparedStatement pstmt = conn.prepareStatement("UPDATE Funcionario SET nome = ?, email = ?, data_admissao = ?, data_nascimento = ?, id_eta = ?, id_cargo = ?")){

            pstmt.setString(1, funcionario.getNome());
            pstmt.setString(2, funcionario.getEmail());
            pstmt.setDate(3, Date.valueOf(funcionario.getDataAdmissao()));
            pstmt.setDate(4, Date.valueOf(funcionario.getDataNascimento()));
            pstmt.setInt(5, funcionario.getIdETA());
            pstmt.setInt(6, funcionario.getIdCargo());

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

    public int removerFuncionario(Funcionario funcionario){
        Connection conn = conexao.conectar();

        try(PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ETA WHERE id = ?")){

            pstmt.setInt(1, funcionario.getId());
            return pstmt.executeUpdate();
        }
        catch (SQLException sqle){
            return -1;
        }
        finally {
            conexao.desconectar();
        }
    }

    // Método removerDuplicadas ()

    public int removerDuplicadas(){
        Connection conn = conexao.conectar();
        try(PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Funcionario id NOT IN (SELECT MIN(id) FROM ETA GROUP BY nome, email, data_admissao, data_nascimento, id_eta, id_cargo)")){

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