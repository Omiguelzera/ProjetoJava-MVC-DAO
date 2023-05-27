<%-- 
    Document   : produto-cadastro.jsp
    Created on : 02/05/2023, 18:28:59
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de Produto</title>
</head>
<body>
    <h1>Cadastro de Produto</h1>
    <form method="post" action="ControleProdutos">
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome"><br><br>
        <label for="preco">Preço:</label>
        <input type="text" id="preco" name="preco"><br><br>
        <label for="quantidade">Quantidade:</label>
        <input type="text" id="quantidade" name="quantidade"><br><br>
        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
