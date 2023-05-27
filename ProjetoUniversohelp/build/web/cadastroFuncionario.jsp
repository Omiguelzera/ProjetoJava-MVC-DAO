<%-- 
    Document   : cadastroFuncionario
    Created on : 02/12/2022, 18:48:29
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>

          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

          <title>Controle Funcionario</title>

</head>
<body>
                   <h1>Cadastro de Funcionario</h1>


                   <form action="ControleFuncionario" >
                       
     Id: <input type="text" name="txtId"><br>
     
         Nome: <input type="text" name="txtNome"><br>

          Idade: <input type="text" name="txtIdade"><br>

             Cargo: <input type="text" name="txtCargo"><br>

                 Salario: <input type="text" name="txtSalario"><br>

                     Telefone: <input type="text" name="txtTelefone"><br>

                          Email: <input type="text" name="txtEmail"><br>

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
