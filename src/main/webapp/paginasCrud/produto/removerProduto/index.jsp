<%--
  Created by IntelliJ IDEA.
  User: eriksilva-ieg
  Date: 09/09/2025
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title> Remoção de Produtos - Teste</title>
<%--  <link rel="stylesheet" href="/paginasCrud/style.css">--%>
  <style>
    *{
      font-family: Arial;
    }
  </style>
</head>
<body>
<h1>Remover produtos dos já cadastrados</h1>
<br><br><br>
<form action="/servlet-remover-produto" method="post">
  <label for="id">ID: </label>
  <input type="number" id="id" name="id" placeholder="Digite o ID do produto" required>
  <br><br>
  <input type="submit" value="Remover">
</form>
</body>
</html>
