<%-- 
    Document   : listaFuncionario
    Created on : 02/12/2022, 15:39:54
    Author     : migue
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Funcionario"%>
<%@page import="model.Funcionario"%>
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
        ArrayList<Funcionario> listafuncionario = (ArrayList<Funcionario>) request.getAttribute("lista funcionario");
        
        %>
        <table border="1">
            <thead>
                <tr>
                    
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Idade</th>
                    <th>Cargo</th>
                    <th>Salario</th>
                    <th>Telefone</th>
                    <th>Email</th>
                    
                </tr>
            </thead>
      
            <tbody>
                <%
                    for(Funcionario f : listafuncionario){
                    %>
                    <tr>
                        <td><%= f.getIdFunc() %></td>
                        <td><%= f.getNomeFunc() %></td>
                        <td><%= f.getIdFunc() %></td>
                        <td><%= f.getCargo() %></td>
                        <td><%= f.getSalario() %></td>
                        <td><%= f.getTelefone() %></td>
                        <td><%= f.getEmail() %></td>
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
