<%-- 
    Document   : confirmarAtualizacao
    Created on : 26/05/2023, 11:07:40
    Author     : migue
--%>

<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado Cosultar By ID</title>
    </head>
    <body>
        <h1>Resultado da Busca</h1>
        <%
            Produto p = (Produto) request.getAttribute("p");
        %>
        <%if (p.getNomeProd() != null) {%>

        <form name="f1" action="ControleProdutos" >
            ID..........: <%out.print(p.getIdProduto());%> <input type="hidden" name="txtId" value="<%out.print(p.getIdProduto());%>"> <BR>
            Nome........: <input type="text" name="txtNome" value="<%out.print(p.getNomeProd());%>">  <BR>
            Quantidade..:<input typo="text" name="txtQuantidade" value="<%out.print(p.getQuantidade());%>"><BR>
            Preço.......: <input type="text" name="txtPreco" value="<%out.print(p.getPreco());%>">  <BR>
            <input type="submit" name="acao" value="CONFIRMAR ATUALIZACAO">
        </form>
        <%} else {%>
        <h2>Produto não encontrado.</h2>
        <%}%>
    </body>
</html>
