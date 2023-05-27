<%-- 
    Document   : erro
    Created on : 02/12/2022, 00:59:02
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
        <h2><%out.print(msg);%></h2> <h2> Algo deu errado com a operação</h2>
    </body>
</html>
