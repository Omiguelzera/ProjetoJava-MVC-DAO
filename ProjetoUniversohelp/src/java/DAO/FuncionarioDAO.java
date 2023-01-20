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
import model.Funcionario;

/**
 *
 * @author migue
 */
public class FuncionarioDAO {
    private static final String INSERT = "INSERT INTO tfuncionario (id, nome, idade, cargo, salario, telefone, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM tfuncionario";


    public void cadastrar(Funcionario funcionario){
    
          Connection conexao = null;
          try{
              conexao = Conexao.getConexao();
             
              PreparedStatement pstmt = conexao.prepareStatement(INSERT);
              pstmt.setInt(1, funcionario.getIdFunc());
              pstmt.setString(2, funcionario.getNomeFunc());
              pstmt.setInt(3, funcionario.getIdade());
              pstmt.setString(4, funcionario.getCargo());
              pstmt.setDouble(5, funcionario.getSalario());
              pstmt.setString(6, funcionario.getTelefone());
              pstmt.setString(7, funcionario.getEmail());
              pstmt.executeUpdate();
              
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
      public ArrayList<Funcionario> listar() throws SQLException, ClassNotFoundException{
          
       
            ArrayList<Funcionario> listafuncionario = new ArrayList<Funcionario>();
            
            Connection conexao = Conexao.getConexao();
            
            PreparedStatement psmt = conexao.prepareStatement(SELECT_ALL );
            
            ResultSet rs = psmt.executeQuery();
            
            while(rs.next()){
                
                Funcionario novoFuncionario = new Funcionario();
                novoFuncionario.setIdFunc(rs.getInt("id"));
                novoFuncionario.setNomeFunc(rs.getString("nome"));
                novoFuncionario.setSalario(rs.getFloat("salario"));
                novoFuncionario.setCargo(rs.getString("cargo"));
                novoFuncionario.setTelefone(rs.getString("telefone"));
                novoFuncionario.setEmail(rs.getString("telefone"));
                
                listafuncionario.add(novoFuncionario);
                
                
            }
            
            return listafuncionario;
            
        } 
       
          } 
      
      

