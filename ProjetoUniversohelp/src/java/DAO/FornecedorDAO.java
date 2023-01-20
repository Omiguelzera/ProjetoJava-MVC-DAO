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
import model.Fornecedor;


/**
 *
 * @author migue
 */
public class FornecedorDAO {
    
    
     private static final String INSERT = "INSERT INTO tfornecedor (id, nome, empresa) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM tfornecedor";


    public void cadastrar(Fornecedor fornecedor){
    
          Connection conexao = null;
          try{
              conexao = Conexao.getConexao();
             
              PreparedStatement pstmt = conexao.prepareStatement(INSERT);
              
              pstmt.setInt(1, fornecedor.getIdFornec());
              pstmt.setString(2, fornecedor.getNomeFornec());
              pstmt.setString(3, fornecedor.getEmpresa());
             
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
     public ArrayList<Fornecedor> listar() throws SQLException{
          
        try {
            ArrayList<Fornecedor> listafornecedor = new ArrayList<Fornecedor>();
            
            Connection conexao = Conexao.getConexao();
            
            PreparedStatement psmt = conexao.prepareStatement(SELECT_ALL );
            
            ResultSet rs = psmt.executeQuery();
            
            while(rs.next()){
                
                Fornecedor novoFornecedor = new Fornecedor();
                novoFornecedor.setIdFornec(rs.getInt("id"));
                novoFornecedor.setNomeFornec("nome");
                novoFornecedor.setEmpresa("empresa");
               
                
                listafornecedor.add(novoFornecedor);
                
                
            }
            
            return listafornecedor;
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FornecedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
          } 
}
