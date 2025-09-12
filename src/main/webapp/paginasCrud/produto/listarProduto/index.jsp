<%--
  Created by IntelliJ IDEA.
  User: eriksilva-ieg
  Date: 11/09/2025
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servletsvireya.model.Produto" %>
<%@ page import="java.util.List" %>
<%
    List<Produto> lista = (List<Produto>) request.getAttribute("produtos");
%>
<html>

<head>
    <title>Title</title>
    <style>
        table{
            align-items: center;
            background-color: darkblue;
            color: aliceblue;
        }
    </style>
</head>

<body>
    <h1>Tabela de produtos</h1>
    <a href="${pageContext.request.contextPath}/servlet-listar-produto">Atualizar</a>

    <br><br>
    <table border="1">
        <thead>
            <th>ID</th>
            <th>Nome</th>
            <th>Tipo</th>
            <th>Unidade de Medida</th>
            <th>Concentração</th>
        </thead>
        <tbody>
            <% if (lista != null && !lista.isEmpty()){
                for (int i=0; i<lista.size(); i++){ %>
            <tr>
                <td> <%= lista.get(i).getId() %> </td> <!-- simbolo de igual serve para pegar o valor de uma var. SEM ; -->
                <td> <%= lista.get(i).getNome() %> </td>
                <td> <%= lista.get(i).getTipo() %> </td>
                <td> <%= lista.get(i).getUnidade_medida() %> </td>
                <td> <%= lista.get(i).getConcentracao() %> </td>
            </tr>
            <% }
            } else { %>
                <tr>
                    <td colspan="5">Nenhum produto encontrado! </td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>

</html>