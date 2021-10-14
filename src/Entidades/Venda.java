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
public class Venda {
    private int Id_v;
    private int Id_p;
    private int Id_s;
    private int qtd;
    private double preco;
    private double valor_p;

    public double getValor_p() {
        return valor_p;
    }

    public void setValor_p(double valor_p) {
        this.valor_p = valor_p;
    }
    
    public int getId_v() {
        return Id_v;
    }

    public void setId_v(int Id_v) {
        this.Id_v = Id_v;
    }

    public int getId_s() {
        return Id_s;
    }

    public void setId_s(int Id_s) {
        this.Id_s = Id_s;
    }

    public int getId_p() {
        return Id_p;
    }

    public void setId_p(int Id_p) {
        this.Id_p = Id_p;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
}
