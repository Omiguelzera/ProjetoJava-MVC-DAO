/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import DAO.FuncionarioDAO;
import model.Funcionario;

/**
 *
 * @author migue
 */
public class cadastroFuncionario {
    
    public static void main(String []args){
    
    Funcionario func = new Funcionario();
    func.setIdFunc(1);
    func.setNomeFunc("eu num");
    func.setIdade(33);
    func.setCargo("Operador");
    func.setSalario(1400);
    func.setTelefone("11-99483758");
    func.setEmail("miguel@sla.com");
    
    FuncionarioDAO fun = new FuncionarioDAO();
    fun.cadastrar(func);
    System.out.println("cadastrado com sucesso ");
    
    }
    
}
