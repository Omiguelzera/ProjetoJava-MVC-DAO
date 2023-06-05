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
   private int id;
   private String nome;
   private String cpf;
   private String cargo;
   private double salario;

   public Funcionario() {
   }

   public Funcionario(int id, String nome, String cpf, String cargo, double salario) {
       this.id = id;
       this.nome = nome;
       this.cpf = cpf;
       this.cargo = cargo;
       this.salario = salario;
   }

   // getters e setters
   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   public String getNome() {
       return nome;
   }

   public void setNome(String nome) {
       this.nome = nome;
   }

   public String getCpf() {
       return cpf;
   }

   public void setCpf(String cpf) {
       this.cpf = cpf;
   }

   public String getCargo() {
       return cargo;
   }

   public void setCargo(String cargo) {
       this.cargo = cargo;
   }

   public double getSalario() {
       return salario;
   }

   public void setSalario(double salario) {
       this.salario = salario;
   }
}