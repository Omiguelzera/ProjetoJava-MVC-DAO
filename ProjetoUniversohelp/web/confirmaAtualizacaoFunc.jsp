<%-- 
    Document   : confirmaAtualizacaoFunc
    Created on : 26/05/2023, 14:12:47
    Author     : migue
--%>

<%@page import="model.Funcionario"%>
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
            Funcionario f = (Funcionario) request.getAttribute("f");
        %>
        <%if (f.getNomeFunc()!= null) {%>

        <form name="f1" action="ControleFuncionario" method ="POST" >
            ID..........: <%out.print(f.getIdFunc());%> <input type="hidden" name="txtId" value="<%out.print(f.getIdFunc());%>"> <BR>
            Nome........: <input type="text" name="txtNome" value="<%out.print(f.getNomeFunc());%>">  <BR>
            Idade..:<input typo="text" name="txtIdade" value="<%out.print(f.getIdade());%>"><BR>
            Cargo.......: <input type="text" name="txtCargo" value="<%out.print(f.getCargo());%>">  <BR>
            Salario.......: <input type="text" name="txtSalario" value="<%out.print(f.getSalario());%>">  <BR>
            Telefone.......: <input type="text" name="txtTelefone" value="<%out.print(f.getTelefone());%>">  <BR>
            Email.......: <input type="text" name="txtEmail" value="<%out.print(f.getEmail());%>">  <BR>
            <input type="submit" name="acao" value="CONFIRMAR ATUALIZACAO">
        </form>
        <%} else {%>
        <h2>Produto não encontrado.</h2>
        <%}%>
    </body>
