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
           //<editor-fold defaultstate="collapsed" desc="Departamento de Sistemas Desktop">
           //</editor-fold>
                  //<editor-fold defaultstate="collapsed" desc="Tecnology Java SE">
                  //</editor-fold>
public class Cliente extends Pessoa{
    private int Id;
    private String Cpf;
   
    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }
    
}
