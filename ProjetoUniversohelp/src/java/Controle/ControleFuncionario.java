/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.FuncionarioDAO;
import model.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author migue
 */
@WebServlet(name = "ControleFuncionario", urlPatterns = {"/ControleFuncionario"})
public class ControleFuncionario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
    
     * 
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String cad = request.getParameter("acao");
           if(cad.equals("Cadastrar")){
                
                int id = Integer.parseInt(request.getParameter("txtId"));
                String nome = request.getParameter("txtNome");
                int idade =  Integer.parseInt(request.getParameter("txtIdade"));
                String cargo = request.getParameter("txtCargo");
                float salario = Float.parseFloat(request.getParameter("txtSalario"));
                String telefone = request.getParameter("txtTelefone");
                String email = request.getParameter("txtEmail");
                
                Funcionario fun = new Funcionario();
                fun.setIdFunc(id);
                fun.setNomeFunc(nome);
                fun.setIdade(idade); 
                fun.setCargo(cargo);
                fun.setSalario(salario);
                fun.setTelefone(telefone);
                fun.setEmail(email);
                
                
                
                FuncionarioDAO funcionario = new FuncionarioDAO();
                funcionario.cadastrar(fun);
                
                response.sendRedirect("sucessocadastro.jsp");
           
           }else if(cad.equals("Listar")){
              
              FuncionarioDAO func = new FuncionarioDAO();
              
              ArrayList<Funcionario> funcionario = func.listar();
              
              request.setAttribute("lista funcionario", funcionario );
              
              RequestDispatcher rd = request.getRequestDispatcher("listaFuncionario.jsp");
              rd.forward(request, response);
           
           }else if(cad.equals("Atualizar")){
           
                int id = Integer.parseInt(request.getParameter("txtId"));
                String nome = request.getParameter("txtNome");
                int idade =  Integer.parseInt(request.getParameter("txtIdade"));
                String cargo = request.getParameter("txtCargo");
                float salario = Float.parseFloat(request.getParameter("txtSalario"));
                String telefone = request.getParameter("txtTelefone");
                String email = request.getParameter("txtEmail");
                
                Funcionario fun = new Funcionario();
                fun.setIdFunc(id);
                fun.setNomeFunc(nome);
                fun.setIdade(idade); 
                fun.setCargo(cargo);
                fun.setSalario(salario);
                fun.setTelefone(telefone);
                fun.setEmail(email);
                
                
                
                FuncionarioDAO funcionario = new FuncionarioDAO();
                funcionario.cadastrar(fun);
                
                response.sendRedirect("sucessocadastro.jsp");
           
           
           }else if(cad.equals("Excluir")){
               
                int id = Integer.parseInt(request.getParameter("txtId"));
               
             
                Funcionario fun = new Funcionario();
                fun.setIdade(id);
                
                
                
               FuncionarioDAO func = new FuncionarioDAO();
               func.deletar(fun);
            
              
             response.sendRedirect("deletarFuncionario.jsp");
               
           
           }
           
           
        }catch (Exception e){
        request.setAttribute("erro", e );
        RequestDispatcher rd
                = request.getRequestDispatcher("errocadastro.jsp");
        rd.forward(request, response);
        }
  
        response.getWriter().close();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    
    
    
    
    
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
