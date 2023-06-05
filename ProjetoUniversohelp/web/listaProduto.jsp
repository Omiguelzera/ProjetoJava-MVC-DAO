<%-- 
    Document   : listaProduto
    Created on : 02/12/2022, 16:29:36
    Author     : migue
--%>

<%@page import="model.Produto"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Produtos</h1>
        
        <%
        ArrayList<Produto> listaproduto = (ArrayList<Produto>) request.getAttribute("lista produto");
        
        %>
        <table border="1">
            <thead>
                <tr>
                    
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Quantidade</th>
                    <th>Preco</th>                  
                </tr>
            </thead>
      
            <tbody>
                <%
                    for(Produto f : listaproduto){
                    %>
                    <tr>
                        <td><%= f.getIdProduto() %></td>
                        <td><%= f.getNomeProd() %></td>
                        <td><%= f.getQuantidade() %></td>
                        <td><%= f.getPreco() %></td> 
                    </tr>  
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
