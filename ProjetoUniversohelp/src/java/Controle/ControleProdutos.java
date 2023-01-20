/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;



import DAO.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Produto;

/**
 *
 * @author migue
 */
@WebServlet(name = "ControleProdutos", urlPatterns = {"/ControleProdutos"})
public class ControleProdutos extends HttpServlet {

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
                int quantidade =  Integer.parseInt(request.getParameter("txtQuantidade"));
                float preco = Float.parseFloat(request.getParameter("txtPreco"));
                
                
                Produto prod = new Produto();
                prod.setIdProduto(id);
                prod.setNomeProd(nome);
                prod.setQuantidade(quantidade);
                prod.setPreco(preco);
                
              
                
                
                ProdutoDAO produto = new ProdutoDAO();
                produto.cadastrar(prod);
                
                response.sendRedirect("sucessocadastro.jsp");
           
           }else if(cad.equals("Listar")){
              
              ProdutoDAO prod = new ProdutoDAO();
              
              ArrayList<Produto> produto = prod.listar();
              
              request.setAttribute("lista produto", produto );
              
              RequestDispatcher rd = request.getRequestDispatcher("listaProduto.jsp");
              rd.forward(request, response);
           
           }else if(cad.equals("Atualizar")){
           
           
           
           
           }else if(cad.equals("Excluir")){
               
                int id = Integer.parseInt(request.getParameter("txtId"));
               
             
                Produto fun = new Produto();
                fun.setIdProduto(id);
                
                
                
               ProdutoDAO func = new ProdutoDAO();
              // func.deletar(fun);
            
              
             response.sendRedirect("deletarFuncionario.jsp");
               
           
           }
           
           
        }catch (Exception e){
        
           request.setAttribute("erro no cadastro", e );
        RequestDispatcher rd
                = request.getRequestDispatcher("erroprod.jsp");
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


