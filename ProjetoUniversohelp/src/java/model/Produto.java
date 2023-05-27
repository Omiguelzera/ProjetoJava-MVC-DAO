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
public class Produto {
    
    
    private int idProduto;
    private String nomeProd;
    private int quantidade;
    private double preco;

    
    public int getIdProduto() {
        return idProduto;
    }

    
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    
    public String getNomeProd() {
        return nomeProd;
    }

    
    public void setNomeProd(String nome) {
        this.nomeProd = nome;
    }

    
    public int getQuantidade() {
        return quantidade;
    }

    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    
    public Double getPreco() {
        return preco;
    }

    
    public void setPreco( double preco) {
        this.preco = preco;
    }
    
    
}
