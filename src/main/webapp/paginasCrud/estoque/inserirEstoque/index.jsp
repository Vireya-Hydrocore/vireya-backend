<%--
  Created by IntelliJ IDEA.
  User: eriksilva-ieg
  Date: 09/09/2025
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Cadastro de Produtos</title>
  <style>
    *{
      font-family: Arial;
    }
  </style>
</head>
<body>
<h1>Cadastrar novo ESTOQUE no sistema</h1>
<br><br><br>

<form action="${pageContext.request.contextPath}/servlet-inserir-estoque" method="post">
  <label for="nome">Nome: </label>
  <input type="text" id="nome" name="nome" placeholder="Digite o nome do produto" required>
  <br><br>
  <label for="quantidade">Quantidade: </label>
  <input type="number" name="quantidade" id="quantidade" placeholder="Digite o tipo do produto (Coagulante, Desinfetante)" required>
  <br><br>
  <label for="dtValidade">Data de Validade: </label>
  <input type="date" name="dataValidade" id="dtValidade" placeholder="Digite a unidade de medida (mg/L, %, m³)" required>
  <br><br>
  <label for="minPossivEstocado">Min possivel estocado: </label>
  <input type="number" name="minPossivEstocado" id="minPossivEstocado" placeholder="Digite o valor da concentração" required>

  <label for="idEta">idEta: </label>
  <input type="number" name="idEta" id="idEta" placeholder="Digite o valor da concentração" required>

  <label for="idProduto">idProduto: </label>
  <input type="number" name="idProduto" id="idProduto" placeholder="Digite o valor da concentração" required>

  <input type="submit" value="Enviar Resultados">
</form>

</body>
</html>
