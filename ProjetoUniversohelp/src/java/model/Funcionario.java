/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author migue
 */
public class Funcionario {
    
    private int idFunc;
    private String nomeFunc;
    private int idade;
    private String cargo;
    private double salario;
    private String telefone;
    private String email;

    
    public int getIdFunc() {
        return idFunc;
    }

    
    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

   
    public String getNomeFunc() {
        return nomeFunc;
    }

    
    public void setNomeFunc(String nome) {
        this.nomeFunc = nome;
    }

    
    public int getIdade() {
        return idade;
    }

    
    public void setIdade(int idade) {
        this.idade = idade;
    }
  
    public String getCargo() {
        return cargo;
    }

    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    
    public Double getSalario() {
        return salario;
    }

   
    public void setSalario(double salario) {
        this.salario = salario;
    }

    
    public String getTelefone() {
        return telefone;
    }

    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

   
    
}
