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
    
    
    private int idFornec;
    private String nomeFornec;
    private String empresa;

    
    public int getIdFornec() {
        return idFornec;
    }

    
    public void setIdFornec(int idFornec) {
        this.idFornec = idFornec;
    }

    
    public String getNomeFornec() {
        return nomeFornec;
    }

    
    public void setNomeFornec(String nomeFornec) {
        this.nomeFornec = nomeFornec;
    }

   
    public String getEmpresa() {
        return empresa;
    }

    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
}
