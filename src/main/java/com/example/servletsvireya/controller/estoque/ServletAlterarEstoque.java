package com.example.servletsvireya.controller.estoque;

import com.example.servletsvireya.dao.EstoqueDAO;
import com.example.servletsvireya.model.Estoque;
import com.example.servletsvireya.model.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAlterarEstoque", value = "/ServletAlterarEstoque")
public class ServletAlterarEstoque extends HttpServlet {
    EstoqueDAO estoqueDAO = new EstoqueDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Pegar os valores
        String idStr = req.getParameter("id");
        String quantidadeStr = req.getParameter("quantidade");

        //Converter para inteiro e double
        int id = Integer.parseInt(idStr);
        int quantidade = Integer.parseInt(quantidadeStr);

        //Instanciando objeto da classe model Produto
        Estoque estoque = new Estoque();
        estoque.setId(id);
        estoque.setQuantidade(quantidade);

        //Alterando produto do sistema
        estoqueDAO.alterarQtd(estoque);

        //não precisa responder nada
    }
}
