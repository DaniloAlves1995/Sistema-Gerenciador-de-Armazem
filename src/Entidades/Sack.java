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

public class Sack {
    private int id_sack;
    private int id_prod;
    private int id_truck;
    private int amount;
    private String date;

    public int getId_sack() {
        return id_sack;
    }

    public void setId_sack(int id_outStock) {
        this.id_sack = id_outStock;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getId_truck() {
        return id_truck;
    }

    public void setId_truck(int id_ca) {
        this.id_truck = id_ca;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
}
