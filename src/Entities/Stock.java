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

public class Stock {
    private int id_stock;
    private int id_prod;
    private int amount;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_p() {
        return id_prod;
    }

    public void setId_p(int id_p) {
        this.id_prod = id_p;
    }

    
    public int getId_stock() {
        return id_stock;
    }

    public void setId_stock(int id_e) {
        this.id_stock = id_e;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
