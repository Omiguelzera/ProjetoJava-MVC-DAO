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
public class Fornecedor {
    private int id;
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;

    // Construtor vazio
    public Fornecedor() {}

    // Construtor com parâmetros
    public Fornecedor(int id, String nome, String cnpj, String endereco, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getters e setters
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
      this.endereco = endereco;
    }
    
    public String getTelefone(){
       return telefone;
    }
    
    public void setTelefone (String telefone){
         this.telefone =  telefone;
    }
}
