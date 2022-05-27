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

public class Product {
    private int Id;
    private String product;
    private double price;
    private String note;

    public String getNote() {
        return note;
    }

    public void setNote(String obs) {
        this.note = obs;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String Produto) {
        this.product = Produto;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double Price) {
        this.price = Price;
    }
    
}
