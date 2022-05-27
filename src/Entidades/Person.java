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
 *@Developer Danilo Alves
 * 
 */

public class Person {
    private String Name;
    private String Address;
    private String Contact1;
    private String Contact2;
    
    public String getContact1() {
        return Contact1;
    }

    public void setContato1(String Contato1) {
        this.Contact1 = Contato1;
    }

    public String getContact2() {
        return Contact2;
    }

    public void setContact2(String Contato2) {
        this.Contact2 = Contato2;
    }

    
    public String getAddress() {
        return Address;
    }

    public void setAddress(String Endereco) {
        this.Address = Endereco;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Nome) {
        this.Name = Nome;
    }
}
