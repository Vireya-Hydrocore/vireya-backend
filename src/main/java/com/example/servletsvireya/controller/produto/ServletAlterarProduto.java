package com.example.servletsvireya.controller.produto;

import com.example.servletsvireya.dao.ProdutoDAO;
import com.example.servletsvireya.model.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAlterarProduto", value = "/servlet-alterar-produto")
public class ServletAlterarProduto extends HttpServlet {
    ProdutoDAO produtoDAO = new ProdutoDAO();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Pegar os valores
        String idStr = req.getParameter("id");
        String concentracaoStr = req.getParameter("concentracao");

        //Converter para inteiro e double
        int id = Integer.parseInt(idStr);
        double concentracao = Double.parseDouble(concentracaoStr);

        //Instanciando objeto da classe model Produto
        Produto produto = new Produto();
        produto.setId(id);
        produto.setConcentracao(concentracao);

        //Alterando produto do sistema
        produtoDAO.alterarConcentracao(produto);

        //não precisa responder nada
    }
}
