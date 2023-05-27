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
import java.util.List;
import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author migue
 */
public class FuncionarioDAO {

    private Connection conn;

    public FuncionarioDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, cpf, cargo, salario) VALUES(?,?,?,?) ";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getCargo());
            stmt.setDouble(4, funcionario.getSalario());
            stmt.execute();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir produto no banco de dados: " + e.getMessage());
        }
    }

    public void atualizar(Funcionario funcionario) {
        String sql = "UPTADE funcionario SET nome = ?, cpf =?, cargo=?, salario=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setString(3, funcionario.getCargo());
            stmt.setDouble(4, funcionario.getSalario());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar o funcionario no banco de dados :(");
        }
    }

    public void excluir(Funcionario funcionario) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, funcionario.getId());
            stmt.execute();
        } catch (SQLException e) {

            throw new RuntimeException("Erro ao tentar apagar os dados :(");
        }

    }

    public Funcionario buscarPorId(int id) {
        String sql = "SELECT * FROM funcionario WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario(rs.getDouble("salario"));
                return funcionario;
            } else {
                return null;
            }
        } catch (SQLException e) {

            throw new RuntimeException("Erro ao fazer busca do funcionario");
        }

    }

    public List<Funcionario> ListarTodos() {
        String sql = "SELECT * FROM funcionario";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            List<Funcionario> funcionarios = new ArrayList<>();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setCargo(rs.getString("cargo"));
                funcionario.setSalario(rs.getDouble("salario"));
                funcionarios.add(funcionario);

            }
            return funcionarios;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao tentar buscar a lista de funcionario :(");
        }

    }
}

      
      

