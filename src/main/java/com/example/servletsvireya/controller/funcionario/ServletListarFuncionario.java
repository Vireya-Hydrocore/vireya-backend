package com.example.servletsvireya.controller.funcionario;

import com.example.servletsvireya.dao.FuncionarioDAO;
import com.example.servletsvireya.model.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletListarFuncionario", value = "/servlet-listar-funcionario")

public class ServletListarFuncionario extends HttpServlet {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        List<Funcionario> funcionarios = funcionarioDAO.buscarTodosFuncionarios();
//        req.setAttribute("listaFuncionarios", funcionarios);

        req.getRequestDispatcher("lista-funcionarios.jsp").forward(req, resp);

    }
}