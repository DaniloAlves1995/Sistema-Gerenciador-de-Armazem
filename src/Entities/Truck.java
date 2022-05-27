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

public class Truck {
    private int Id;
    private String Name;
    private int TrackLoad;
    private String Date;

    public String getDate() {
        return Date;
    }

    public void setData(String Data) {
        this.Date = Data;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Nome) {
        this.Name = Nome;
    }

    public int getTruckLoad() {
        return TrackLoad;
    }

    public void setTruckLoad(int Carga) {
        this.TrackLoad = Carga;
    }
    
    
}
