/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import DAO.FornecedorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;

/**
 *
 * @author migue
 */
@WebServlet(name = "ControleFornecedor", urlPatterns = {"/ControleFornecedor"})
public class ControleFornecedor extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
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
                String empresa = request.getParameter("txtEmpresa");
                
                Fornecedor forn = new Fornecedor();
                forn.setIdFornec(id);
                forn.setNomeFornec(nome);
                forn.setEmpresa(empresa);
                
                
                
                FornecedorDAO fornecedor = new FornecedorDAO();
                fornecedor.cadastrar(forn);
                
                response.sendRedirect("sucessocadastro.jsp");
           
           }else if(cad.equals("Listar")){
              
              FornecedorDAO forn = new FornecedorDAO();
              
              ArrayList<Fornecedor> fornecedor = forn.listar();
              
              request.setAttribute("lista fornecedor", fornecedor );
              
              RequestDispatcher rd = request.getRequestDispatcher("listaFonecedor.jsp");
              rd.forward(request, response);
           
           }
           
           
        }catch (Exception e){
        request.setAttribute("erro no cadastro", e );
        RequestDispatcher rd
                = request.getRequestDispatcher("cadastroFornecedor.jsp");
        rd.forward(request, response);
        }
    }

}


