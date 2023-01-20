/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import DAO.FuncionarioDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Funcionario;

/**
 *
 * @author migue
 */
public class listaFuncionario {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
    
        FuncionarioDAO fun = new FuncionarioDAO();
        ArrayList<Funcionario> listaFuncionario = fun.listar();
        
        for(Funcionario f : listaFuncionario){
               System.out.println(f.getIdFunc());
               System.out.println(f.getNomeFunc());
               System.out.println(f.getIdade());
               System.out.println(f.getCargo());
               System.out.println(f.getSalario());
               System.out.println(f.getTelefone());
               System.out.println(f.getEmail());
               
        }
    
    }
}
