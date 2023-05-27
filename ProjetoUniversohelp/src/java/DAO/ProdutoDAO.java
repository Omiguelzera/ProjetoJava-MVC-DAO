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
import model.Produto;


/**
 *
 * @author migue
 */
public class ProdutoDAO {
    
      public void cadastrar(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("insert into tproduto (id, nomeprod, quantidade, preco) values (?,?,?,?)");
        comando.setInt(1, p.getIdProduto());
        comando.setString(2, p.getNomeProd());
        comando.setInt(3, p.getQuantidade());
        comando.setDouble(4, p.getQuantidade());
        comando.execute();
        con.close();
    }
    
    public void deletar(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from tproduto where id = ?");
        comando.setInt(1, p.getIdProduto());
        comando.execute();
        con.close();
    }
    
    public void atualizar(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update tproduto set nomeprod = ?, quantidade = ?, preco = ? where id = ?");
        comando.setString(1, p.getNomeProd());
        comando.setInt(2, p.getQuantidade());
        comando.setDouble(3, p.getPreco());
        comando.setInt(4, p.getIdProduto());
        comando.execute();
        con.close();
    }

    public Produto consultarById(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from tproduto where id = ?");
        comando.setInt(1, p.getIdProduto());
        ResultSet rs = comando.executeQuery();
        Produto prod = new Produto();
        if (rs.next()){
            prod.setIdProduto(rs.getInt("id"));
            prod.setNomeProd(rs.getString("nomeprod"));
            prod.setQuantidade(rs.getInt("quantidade"));
            prod.setPreco(rs.getDouble("preco"));
        }        
        return prod;
    }
    
    
    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from tproduto");
        ResultSet rs = comando.executeQuery();
        
        List<Produto> lprod = new ArrayList<Produto>();
        while(rs.next()){
            Produto prod = new Produto();
            prod.setIdProduto(rs.getInt("id"));
            prod.setNomeProd(rs.getString("nomeprod"));
            prod.setQuantidade(rs.getInt("quantidade"));
            prod.setPreco(rs.getDouble("preco"));
            lprod.add(prod);
        }        
        return lprod;
    }
   
          
}
          
    
