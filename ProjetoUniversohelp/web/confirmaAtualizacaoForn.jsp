<%-- 
    Document   : confirmaAtualizacaoForn
    Created on : 26/05/2023, 15:14:26
    Author     : migue
--%>

<%@page import="model.Fornecedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado busca por ID</title>
    </head>
    <body>
        <h1>Resultado da Busca</h1>
        <%
           Fornecedor forn = (Fornecedor) request.getAttribute("forn");
        
        %>
        
        <%if(forn.getNomeFornec() != null){%>
                         
                 <form name="f1" action="ControleFornecedor" method ="POST" >
            ID..........: <%out.print(forn.getIdFornec());%> <input type="hidden" name="txtId" value="<%out.print(forn.getIdFornec());%>"> <BR>
            Nome........: <input type="text" name="txtNome" value="<%out.print(forn.getNomeFornec());%>">  <BR>
            Empresa..:<input typo="text" name="txtIdade" value="<%out.print(forn.getEmpresa());%>"><BR>
           
            <input type="submit" name="acao" value="CONFIRMAR ATUALIZACAO">
        </form>
        <%} else {%>
        <h2>Produto não encontrado.</h2>
        <%}%>
    </body>
</html>
