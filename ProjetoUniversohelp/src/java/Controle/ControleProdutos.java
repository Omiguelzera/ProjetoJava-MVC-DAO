/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;



import DAO.ProdutoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    private ProdutoDAO produtoDAO;
    
    @Override
    public void init() throws ServletException {
        produtoDAO  = new ProdutoDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        
        if (acao == null) {
            acao = "";
        }
        
        switch (acao) {
            case "cadastrar":
                request.getRequestDispatcher("/produto-cadastro.jsp").forward(request, response);
                break;
            case "editar":
                Long id = Long.parseLong(request.getParameter("id"));
                Produto produto = produtoDAO.buscarPorId(id);
                request.setAttribute("produto", produto);
                request.getRequestDispatcher("/produto-editar.jsp").forward(request, response);
                break;
            case "excluir":
                id = Long.parseLong(request.getParameter("id"));
                produtoDAO.excluir(id);
                response.sendRedirect(request.getContextPath() + "/produto");
                break;
            default:
                List<Produto> produtos = produtoDAO.listar();
                request.setAttribute("produtos", produtos);
                request.getRequestDispatcher("/produto-listar.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String acao = request.getParameter("acao");
        
        if (acao == null) {
            acao = "";
        }
        
        switch (acao) {
            case "cadastrar":
                String nome = request.getParameter("nome");
                double preco = Double.parseDouble(request.getParameter("preco"));
                int quantidade = Integer.parseInt(request.getParameter("quantidade"));
                
                Produto produto = new Produto(nome, preco, quantidade);
                produtoDAO.cadastrar(produto);
                
                response.sendRedirect(request.getContextPath() + "/produto");
                break;
            case "editar":
                Long id = Long.parseLong(request.getParameter("id"));
                nome = request.getParameter("nome");
                preco = Double.parseDouble(request.getParameter("preco"));
                quantidade = Integer.parseInt(request.getParameter("quantidade"));
                
                produto = new Produto(id, nome, preco, quantidade);
                produtoDAO.atualizar(produto);
                
                response.sendRedirect(request.getContextPath() + "/produto");
                break;
        }
    }
}



