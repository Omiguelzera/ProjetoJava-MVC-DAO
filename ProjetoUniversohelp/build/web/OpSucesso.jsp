<%-- 
    Document   : sucessocadastro
    Created on : 02/12/2022, 04:09:50
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado da Operação</title>
    </head>
    <body>
          <%
           String msg = (String) request.getAttribute("message");
        %>
        <h2><%out.print(msg);%><h2> <h2>Operação feita com sucesso</h2>
    </body>
</html>
