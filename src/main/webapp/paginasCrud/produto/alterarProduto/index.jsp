<%--
  Created by IntelliJ IDEA.
  User: eriksilva-ieg
  Date: 11/09/2025
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@page import="com.example.servletsvireya.model.Produto"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Área Restrita - Vireya</title>
    <style>
      h1, h2, form{
        align-items: center;
      }
    </style>
</head>
<body>

  <h1>Alterar Produto</h1>
  <br>
  <h2>Digite as informações que você quer mudar:</h2>
  <br>

  <form action="${pageContext.request.contextPath}/servlet-alterar-produto" method="post">
    <label for="id">ID: </label>
    <input type="number" id="id" name="id" value="${produto.id}" readonly> <!--usando EL, aciona o metodo .getId(). mas podia ser scriplet tb-->
    <br>
    <label for="nome">Nome: </label>
    <input type="text" id="nome" name="nome" value="${produto.nome}">
    <br>
    <label for="tipo">Tipo: </label>
    <input type="text" id="tipo" name="tipo" value="${produto.tipo}">
    <br>
    <label for="unidMedida">Unidade de Medida: </label>
    <input type="text" id="unidMedida" name="unidMedida" value="${produto.unidade_medida}">
    <br>
    <label for="concentracao">Concentração: </label>
    <input type="number" id="concentracao" name="concentracao" value="${produto.concentracao}">
    <br><br>
    <button type="submit">Alterar</button>

  </form>
</body>
</html>
