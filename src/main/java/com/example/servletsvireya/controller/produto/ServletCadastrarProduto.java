package com.example.servletsvireya.controller.produto;

import com.example.servletsvireya.dao.ProdutoDAO;
import com.example.servletsvireya.model.Produto;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCadastrarProduto", value = "/servlet-cadastrar-produto")
public class ServletCadastrarProduto extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProdutoDAO produtoDAO = new ProdutoDAO();

        //Pegar os valores
        String nome = req.getParameter("nome").toUpperCase();
        String tipo = req.getParameter("tipo").toUpperCase();
        String unidMedida = req.getParameter("unidMedida").toUpperCase();
        String concentracaoStr = req.getParameter("concentracao");

        //Converter a concentração de String para double
        double concentracao = Double.parseDouble(concentracaoStr);

        //Instanciando objeto da classe model Produto
        Produto produto = new Produto(nome, tipo, unidMedida, concentracao);

        //Inserindo no banco de dados
        produtoDAO.cadastrarProduto(produto);

        resp.setContentType("text/html"); //indicando que a resposta será conteúdo html
        PrintWriter out = resp.getWriter(); //pra escrever a resposta

        out.println("<html><body>");
        out.println("<h1>Produto Cadastrado com Sucesso!</h1>");
        out.println("<br>");
        out.println("<p>Produto: "+nome+"</p>");
        out.println("</body></html>");
    }
}
