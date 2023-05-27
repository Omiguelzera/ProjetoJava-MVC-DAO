<%-- 
    Document   : cadastroFornecedor
    Created on : 02/12/2022, 01:51:54
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

          <title>Controle Fornecedor</title>

</head>
         <body>
                   <h1>Cadastro de Fornecedores</h1>

        

          <form action="ControleFornecedor">

     Id: <input type="text" name="txtId"><br>
     
        Nome: <input type="text" name="txtNome"><br>

          Empresa: <input type="text" name="txtEmpresa"><br>

                     <input type="submit" name="acao" value="CADASTRAR">

                <input type="submit" name="acao" value="LISTAR">

             <input type="submit" name="acao" value="ATUALIZAR">

          <input type="submit" name="acao" value="DELETAR">

         </form>
               <div class="groupb">
            <a href="http://localhost:8080/ProjetoUniversohelp/ControleUsuario?txtlogin=banana&txtsenha=1234&acao=Login" 
                  class="botoes">Voltar ao Menu</a>
                 </div>
          </body>
</html>