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
                float preco = Float.parseFloat(request.getParameter("txtPreço"));
                
                
                Produto prod = new Produto();
                prod.setIdProduto(id);
                prod.setNomeProd(nome);
                prod.setPreco(preco);
                prod.setQuantidade(quantidade);
              
                
                
                ProdutoDAO produto = new ProdutoDAO();
                produto.cadastrar(prod);
                
                response.sendRedirect("sucessocadastro.jsp");
           
           }else if(cad.equals("Listar")){
              
              ProdutoDAO prod = new ProdutoDAO();
              
              ArrayList<Produto> produto = prod.listar();
              
              request.setAttribute("lista produto", produto );
              
              RequestDispatcher rd = request.getRequestDispatcher("listaProduto.jsp");
              rd.forward(request, response);
           
           }
           
           
        }catch (Exception e){
        request.setAttribute("erro no cadastro", e );
        RequestDispatcher rd
                = request.getRequestDispatcher("cadastroProduto.jsp");
        rd.forward(request, response);
        }
    }

}


