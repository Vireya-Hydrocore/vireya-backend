package com.example.servletsvireya.controller.funcionario;

import com.example.servletsvireya.dao.FuncionarioDAO;
import com.example.servletsvireya.model.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ServletRemoverFuncionarios", value = "/servlet-remover-funcionarios")

public class ServletRemoverFuncionario extends HttpServlet {

    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);

        int removido = funcionarioDAO.removerFuncionario(funcionario);

        req.setAttribute("mensagem", removido > 0 ? "Funcionário removido com sucesso!" : "Erro ao remover o funcionário.");

        req.getRequestDispatcher("lista-funcionarios.jsp").forward(req, resp);
    }
}