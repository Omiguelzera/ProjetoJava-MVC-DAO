/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Banco.Conexao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Fornecedor;



/**
 *
 * @author migue
 */
public class FornecedorDAO {
    
    
 public void cadastrar(Fornecedor forn) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into tfornecedor (id, nomefornec, empresa) values (?,?,?)");
        comando.setInt(1, forn.getIdFornec());
        comando.setString(2, forn.getNomeFornec());
        comando.setString(3, forn.getEmpresa());
        comando.execute();
        con.close();
    }
    
    public void deletar(Fornecedor forn) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from tfornecedor where id = ?");
        comando.setInt(1, forn.getIdFornec());
        comando.execute();
        con.close();
    }
    
    public void atualizar(Fornecedor forn) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update tfornecedor set nomefornec = ?, empresa = ? where id = ?");
        comando.setString(1, forn.getNomeFornec());
        comando.setString(2, forn.getEmpresa());
        comando.setInt(3, forn.getIdFornec());
        comando.execute();
        con.close();
    }

    public Fornecedor consultarById(Fornecedor forn) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from tfornecedor where id = ?");
        comando.setInt(1, forn.getIdFornec());
        ResultSet rs = comando.executeQuery();
        Fornecedor forne = new Fornecedor();
        if (rs.next()){
            forne.setIdFornec(rs.getInt("id"));
            forne.setNomeFornec(rs.getString("nomefornec"));
            forne.setEmpresa(rs.getString("empresa"));
            
        }        
        return forne;
    }
    
    
    public List<Fornecedor> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from tfornecedor");
        ResultSet rs = comando.executeQuery();
        
        List<Fornecedor> lforn = new ArrayList<Fornecedor>();
        while(rs.next()){
            Fornecedor forne = new Fornecedor();
            forne.setIdFornec(rs.getInt("id"));
            forne.setNomeFornec(rs.getString("nomefornec"));
            forne.setEmpresa(rs.getString("empresa"));
            lforn.add(forne);
        }        
        return lforn;
    }
}


           

