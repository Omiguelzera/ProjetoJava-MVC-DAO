/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Banco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Produto;


/**
 *
 * @author migue
 */
public class ProdutoDAO {
    
    private static final String INSERT = "INSERT INTO tproduto (id, nome, quantidade, preco ) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM tproduto";


    public void cadastrar(Produto produto){
    
          Connection conexao = null;
          try{
              conexao = Conexao.getConexao();
             
              PreparedStatement pstmt = conexao.prepareStatement(INSERT);
              
              pstmt.setInt(1, produto.getIdProduto());
              pstmt.setString(2, produto.getNomeProd());
              pstmt.setInt(3, produto.getQuantidade());
              pstmt.setDouble(4, produto.getPreco());
           
              pstmt.execute();
              
          }catch(Exception e ){
          throw new RuntimeException(e);
          }finally{
              try{
                  conexao.close();
              }catch(SQLException ex){
                  throw new RuntimeException (ex);
              }
          
          }
       
     }
     public ArrayList<Produto> listar() throws SQLException{
          
        try {
            ArrayList<Produto> listaproduto = new ArrayList<Produto>();
            
            Connection conexao = Conexao.getConexao();
            
            PreparedStatement psmt = conexao.prepareStatement(SELECT_ALL );
            
            ResultSet rs = psmt.executeQuery();
            
            while(rs.next()){
                
                Produto novoProduto = new Produto();
                novoProduto.setIdProduto(rs.getInt("id"));
                novoProduto.setNomeProd("nome");
                novoProduto.setPreco(rs.getFloat("preço"));
               
                
                listaproduto.add(novoProduto);
                
                
            }
            
            return listaproduto;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
          } 
    
}
