<%-- 
    Document   : listaFornecedor
    Created on : 02/12/2022, 16:29:48
    Author     : migue
--%>

<%@page import="model.Fornecedor"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Funcionarios</h1>
        
        <%
        ArrayList<Fornecedor> listafornecedor = (ArrayList<Fornecedor>) request.getAttribute("lforn");
        
        %>
        <table border="1">
            <thead>
                <tr>
                    
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Empresa</th>
                  
                </tr>
            </thead>
      
            <tbody>
                <%
                    for(Fornecedor f : listafornecedor){
                    %>
                    <tr>
                        <td><%= f.getIdFornec() %></td>
                        <td><%= f.getNomeFornec() %></td>
                        <td><%= f.getEmpresa() %></td>
                        
                    <%
                    }
                    
                    %>
                     <div class="groupb">
            <a href="http://localhost:8080/ProjetoUniversohelp/cadastroFuncionario.jsp" 
                  class="botoes">Voltar ao Cadastro</a>
            </div>
                    
            </tbody>
              </table>
            
    </body>
</html>
