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
public class Saida {

    private int Id_s;
    private int Id_c;
    private int Id_fun;
    private double Total;
    private String Data;

    public int getId_s() {
        return Id_s;
    }

    public void setId_s(int Id_s) {
        this.Id_s = Id_s;
    }

    public int getId_fun() {
        return Id_fun;
    }

    public void setId_fun(int Id_fun) {
        this.Id_fun = Id_fun;
    }
    
    public int getId_c() {
        return Id_c;
    }

    public void setId_c(int Id_c) {
        this.Id_c = Id_c;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

}
