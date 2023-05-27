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
import java.util.List;
import model.Funcionario;


/**
 *
 * @author migue
 */
public class FuncionarioDAO {
     public void cadastrar(Funcionario f) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into tfuncionario (id, nomefunc, idade, cargo, salario, telefone, email) values (?,?,?,?,?,?,?)");
        comando.setInt(1, f.getIdFunc());
        comando.setString(2, f.getNomeFunc());
        comando.setInt(3, f.getIdade());
        comando.setString(4, f.getCargo());
        comando.setDouble(5, f.getSalario());
        comando.setString(6, f.getTelefone());
        comando.setString(7, f.getEmail());
        comando.execute();
        con.close();
    }
    
    public void deletar(Funcionario f) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from tfuncionario where id = ?");
        comando.setInt(1, f.getIdFunc());
        comando.execute();
        con.close();
    }
    
    public void atualizar(Funcionario f) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update tfuncionario set nomefunc = ?, idade = ?, cargo = ?, salario = ?, telefone = ? email =?  where id = ?");
        comando.setString(1, f.getNomeFunc());
        comando.setInt(2, f.getIdade());
        comando.setString(3, f.getCargo());
        comando.setDouble(4, f.getSalario());
        comando.setString(5, f.getTelefone());
        comando.setString(6, f.getEmail());
        comando.setInt(7, f.getIdFunc());
        con.close();
    }

    public Funcionario consultarById(Funcionario f ) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from tfuncionario where id = ?");
        comando.setInt(1, f.getIdFunc());
        ResultSet rs = comando.executeQuery();
        Funcionario func = new Funcionario();
        if (rs.next()){
            func.setIdFunc(rs.getInt("id"));
            func.setNomeFunc(rs.getString("nomefunc"));
            func.setIdade(rs.getInt("idade"));
            func.setCargo(rs.getString("cargo"));
            func.setSalario(rs.getDouble("salario"));
            func.setTelefone(rs.getString("telefone"));
            func.setEmail(rs.getString("email"));
            con.close();
            
        }        
        return func;
    }
    
    
    public List<Funcionario> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from tfuncionario");
        ResultSet rs = comando.executeQuery();
        
        List<Funcionario> lfunc = new ArrayList<Funcionario>();
        while(rs.next()){
            Funcionario func = new Funcionario();
            func.setIdFunc(rs.getInt("id"));
            func.setNomeFunc(rs.getString("nomefunc"));
            func.setIdade(rs.getInt("idade"));
            func.setCargo(rs.getString("cargo"));
            func.setSalario(rs.getDouble("salario"));
            func.setTelefone(rs.getString("telefone"));
            func.setEmail(rs.getString("email"));
            lfunc.add(func);
        }        
        return lfunc;
    }
} 
      
      

