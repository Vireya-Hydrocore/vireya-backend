<%--
  Created by IntelliJ IDEA.
  User: eriksilva-ieg
  Date: 09/09/2025
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>

<!------------------ MENU GERAL ------------------->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Área Restrita</title>
</head>
<body>
<h1>CRUD VIREYA</h1>
<h2>Selecione a tabela da qual você deseja realizar o CRUD: </h2>

<nav id="botoes">
    <a href="${pageContext.request.contextPath}/paginasCrud/estoque/index.jsp">Fu;ncionario</a>
    <br>
    <a href="">Cargo</a>
    <br>
    <a href="${pageContext.request.contextPath}/paginasCrud/produto/index.jsp">Produto</a>
    <br>
    <a href="${pageContext.request.contextPath}/paginasCrud/estoque/index.jsp">Estoque</a>
    <br>
    <a href="">Eta</a>
    <br>
<%--    <a href="${pageContext.request.contextPath}/paginasCrud/estoque/index.jsp">Admin</a>--%>
</nav>

</body>
</html>
