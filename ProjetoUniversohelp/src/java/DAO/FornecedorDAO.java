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
import model.Fornecedor;

/**
 *
 * @author migue
 */
public class FornecedorDAO {

    private Connection conn;

    public FornecedorDAO(Connection con) {
        this.conn = conn;

    }

    public void inserir(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor (nome, cnpj, endereco, telefone)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar inserir fornecedor no banco de dados :(");
        }
    }

    public void atualizar(Fornecedor fornecedor) {
        String sql = "UPDATE fornecedor SET nome=?, cnpj=?, endereco=?, telefone=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getCnpj());
            stmt.setString(3, fornecedor.getEndereco());
            stmt.setString(4, fornecedor.getTelefone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar atualizar fornecedor :(");
        }
    }

    public void excluir(Fornecedor fornecedor) {
        String sql = "DELETE FROM fornecedor WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, fornecedor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar excluir fornecedor :(");
        }
    }

    public Fornecedor buscarPorId(int id) {
        String sql = "SELECT * FROM fornecedor WHERE id =?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setTelefone(rs.getString("telefone"));
                return fornecedor;

            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar fazer a busca por ID :(");

        }

    }

    public List<Fornecedor> listarTodos() {
        String sql = "SELECT * FROM fornecedor";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            List<Fornecedor> fornecedores = new ArrayList<>();
            while (rs.next()) {
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEndereco(rs.getString("endereco"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedores.add(fornecedor);

            }
            return fornecedores;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar mostrar a lista de fornecedores :(");
        }

    }

}


    

