/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 *************************************************************
 * ------------- ..::Danilo Alves Oliveira::.. ------------- *
 * ***********************************************************
 * 
 *@Desenvolvedor Danilo Alves
 * 
 */

public class Pessoa {
    private String Nome;
    private String Endereco;
    private String Contato1;
    private String Contato2;
    
    public String getContato1() {
        return Contato1;
    }

    public void setContato1(String Contato1) {
        this.Contato1 = Contato1;
    }

    public String getContato2() {
        return Contato2;
    }

    public void setContato2(String Contato2) {
        this.Contato2 = Contato2;
    }

    
    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
}
