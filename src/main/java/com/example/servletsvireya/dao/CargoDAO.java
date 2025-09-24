//package com.example.servletsvireya.dao;
//
//import com.example.servletsvireya.model.Cargo;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CargoDAO {
//    private Conexao conexao;
//
//    public int inserirCargo(Cargo cargo) {
//        conexao.conectar();
//        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("INSERT INTO Cargo (id, nome, acesso) VALUES (?, ?, ?)")) {
//            pstmt.setInt(1, cargo.getId());
//            pstmt.setString(2, cargo.getNome());
//            pstmt.setString(3, cargo.getAcesso());
//            pstmt.execute();
//            return pstmt.executeUpdate();
//        } catch (SQLException exceptionSQL) {
//            return -1;
//        } finally {
//            conexao.desconectar();
//        }
//    }
//
//    public List<Cargo> buscarCargo(Cargo cargo) {
//        List<Cargo> cargos = new ArrayList<>();
//        conexao.conectar();
//        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("SELECT * FROM Cargo WHERE id = ?")) {
//            pstmt.setInt(1, cargo.getId());
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()){
//                cargo.setId(rs.getInt("id"));
//                cargo.setNome(rs.getString("nome"));
//                cargo.setAcesso(rs.getString("acesso"));
//                cargos.add(cargo);
//            }
//            return cargos;
//        } catch (SQLException e) {
//            return null;
//        } finally {
//            conexao.desconectar();
//        }
//    }
//    public int alterarCargo(Cargo cargo){
//        conexao.conectar();
//        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("UPDATE Cargo SET nome = ?, acesso = ? WHERE id = ?")){
//            pstmt.setString(1, cargo.getNome());
//            pstmt.setString(2, cargo.getAcesso());
//            pstmt.setInt(3, cargo.getId());
//            return pstmt.executeUpdate();
//        } catch (SQLException sqle){
//            return -1;
//        } finally {
//            conexao.desconectar();
//        }
//    }
//    public int removerCargo(Cargo cargo){
//        conexao.conectar();
//        try (PreparedStatement pstmt = conexao.getConn().prepareStatement("DELETE FROM Cargo WHERE id = ?")){
//            pstmt.setInt(1, cargo.getId());
//            return pstmt.executeUpdate();
//        } catch (SQLException e){
//            return -1;
//        }
//        finally {
//            conexao.desconectar();
//        }
//    }
//}