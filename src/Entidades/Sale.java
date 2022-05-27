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

public class Sale {
    private int Id_sale;
    private int Id_prod;
    private int Id_outStock;
    private int amount;
    private double price;
    private double value_prod;

    public double getValueProduct() {
        return value_prod;
    }

    public void setValueProduct(double value_p) {
        this.value_prod = value_p;
    }
    
    public int getId_sale() {
        return Id_sale;
    }

    public void setId_sale(int Id_sale) {
        this.Id_sale = Id_sale;
    }

    public int getId_outStock() {
        return Id_outStock;
    }

    public void setId_outStock(int Id_s) {
        this.Id_outStock = Id_s;
    }

    public int getId_prod() {
        return Id_prod;
    }

    public void setId_prod(int Id_p) {
        this.Id_prod = Id_p;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
