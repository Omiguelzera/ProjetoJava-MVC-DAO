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

public class ProdutoDAO extends Conexao {
    private Connection conn;

    public ProdutoDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Produto produto) {
        String sql = "INSERT INTO produto (nome, descricao, preco, quantidade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir o produto no banco de dados: " + e.getMessage());
        }
    }

    public void atualizar(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, descricao = ?, preco = ?, quantidade = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setInt(4, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o produto no banco de dados: " + e.getMessage());
        }
    }

    public void excluir(Produto produto) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir o produto no banco de dados: " + e.getMessage());
        }
    }

    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM produto WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                return produto;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar o produto no banco de dados: " + e.getMessage());
        }
    }

    public List<Produto> listarTodos() {
        String sql = "SELECT * FROM produto";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            List<Produto> produtos = new ArrayList<>();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produtos.add(produto);
            }
            return produtos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os produtos no banco de dados: " + e.getMessage());
        }
    }
}