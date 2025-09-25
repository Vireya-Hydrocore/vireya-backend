//package com.example.servletsvireya.dao;
//
//import com.example.servletsvireya.model.Admin;
//import com.example.servletsvireya.util.Conexao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class AdminDAO {
//    Conexao conexao = new Conexao();
//
//    public boolean inserirAdmin(Admin admin) {
//        Connection conn = conexao.conectar();
//
//        try {
//            String comando = "INSERT INTO Admin (id, nome, email, idEta) VALUES (?, ?, ?, ?)";
//            PreparedStatement pstmt = conn.prepareStatement(comando);
//
//            pstmt.setInt(1, admin.getId());
//            pstmt.setString(2, admin.getNome());
//            pstmt.setString(3, admin.getEmail());
//            pstmt.setInt(4, admin.getIdEta());
//
//            //Retornando se alguma linha foi modificada
//            return pstmt.executeUpdate() > 0;
//
//        } catch (SQLException exceptionSQL) {
//            return false;
//        } finally {
//            conexao.desconectar();
//        }
//    }
//
//    public List<Admin> buscarAdmin(Admin admin) {
//        List<Admin> admins = new ArrayList<>();
//        Connection conn = conexao.conectar();
//
//        try (PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Admin WHERE id = ?")) {
//            pstmt.setInt(1, admin.getId());
//
//            ResultSet rs = pstmt.executeQuery();
//            while (rs.next()) {
//                admin.setId(rs.getInt("id"));
//                admin.setNome(rs.getString("nome"));
//                admin.setEmail(rs.getString("email"));
//                admins.add(admin);
//            }
//
//            return admins;
//        } catch (SQLException e) {
//            return new ArrayList<>(); //Lista vazia
//        } finally {
//            conexao.desconectar();
//        }
//    }
//
//    public int alterarAdmin(Admin admin) { //
//        Connection conn = conexao.conectar();
//
//        try (PreparedStatement pstmt = conn.prepareStatement("UPDATE Admin SET nome = ?, email = ? WHERE id = ?")) {
//            pstmt.setString(1, admin.getNome());
//            pstmt.setString(2, admin.getEmail());
//            pstmt.setInt(3, admin.getId());
//
//            return (pstmt.executeUpdate() > 0) ? 1 : 0;
//
//        } catch (SQLException sqle) {
//            return -1;
//        } finally {
//            conexao.desconectar();
//        }
//    }
//
//    public int removerAdmin(int id) throws SQLException{
//        //Estabelecendo conexão
//        Connection conn = conexao.conectar();
//
//        String comando = "DELETE FROM admin WHERE id = ?";
//        try (PreparedStatement pstmt = conn.prepareStatement(comando)) {
//            pstmt.setInt(1, id);
//
//            if(buscarAdmin(admin.getId(1)) == null){
//                return 0;
//            }
//
//            pstmt.executeUpdate();
//            return 1;
//        } finally {
//            conexao.desconectar();
//        }
//    }
//}
