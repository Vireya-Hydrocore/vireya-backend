<%--
  Created by IntelliJ IDEA.
  User: eriksilva-ieg
  Date: 09/09/2025
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Cadastro de Produtos</title>
</head>
<body>
<h1>Cadastrar novo produto no sistema</h1>
<br><br><br>

<form action="${pageContext.request.contextPath}/servlet-cadastrar-produto" method="post">
    <label for="nome">Nome: </label>
    <input type="text" id="nome" name="nome" placeholder="Digite o nome do produto" required>
    <br><br>
    <label for="tipo">Tipo: </label>
    <input type="text" name="tipo" id="tipo" placeholder="Digite o tipo do produto (Coagulante, Desinfetante)" required>
    <br><br>
    <label for="unidMedida">Unidade de Medida: </label>
    <input type="text" name="unidMedida" id="unidMedida" placeholder="Digite a unidade de medida (mg/L, %, m³)" required>
    <br><br>
    <label for="concentracao">Concentração: </label>
    <input type="number" name="concentracao" id="concentracao" placeholder="Digite o valor da concentração" required>
    <br><br><br>
    <input type="submit" value="Enviar Resultados">
</form>

</body>
</html>
