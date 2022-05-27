/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 *************************************************************
 * ------------- ..::Danilo Alves Oliveira::.. ------------- *
 * ***********************************************************
 * 
 *@Developer Danilo Alves
 * 
 */

public class OutStock {

    private int Id_outStock;
    private int Id_customer;
    private int Id_salesman;
    private double Total;
    private String Date;

    public int getId_outStock() {
        return Id_outStock;
    }

    public void setId_outStock(int id_outStock) {
        this.Id_outStock = id_outStock;
    }

    public int getId_salesman() {
        return Id_salesman;
    }

    public void setId_salesman(int id_salesman) {
        this.Id_salesman = id_salesman;
    }
    
    public int getId_customer() {
        return Id_customer;
    }

    public void setId_customer(int Id_customer) {
        this.Id_customer = Id_customer;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

}
