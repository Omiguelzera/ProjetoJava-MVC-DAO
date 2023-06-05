/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author migue
 */
public class Conexao {
     private static final String URL = "jdbc:postgresql://localhost:5432/Tcc";
    private static final String USER = "postgres";
    private static final String PASSWORD = "miguer";
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
}

