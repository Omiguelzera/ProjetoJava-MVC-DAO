<%-- 
    Document   : errocadastro
    Created on : 03/12/2022, 05:40:42
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>JSP Page</title>

    </head>

    <body>

        <h2>Erro!</h2>

        <%

            Exception erro = (Exception) request.getAttribute("erro");

        %>

        <%=erro.getMessage()%>

    </body>

</html>
