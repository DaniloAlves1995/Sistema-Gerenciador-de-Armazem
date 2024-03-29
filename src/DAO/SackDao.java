/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.CreateConnection;
import Entities.Sack;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 

/**
 *
 *************************************************************
 * ------------- ..::Danilo Alves Oliveira::.. ------------- *
 * ***********************************************************
 * 
 *@Developer Danilo Alves
 * 
 */

public class SackDao {

    private final Connection connection;

    public SackDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    }

    public void add(Sack m1) throws SQLException {
        String sql = "insert into sacks(id_product, id_truck, amount, date) values(?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, m1.getId_prod());
            stmt.setInt(2, m1.getId_truck());
            stmt.setInt(3, m1.getAmount());
            stmt.setString(4, m1.getDate());

            stmt.execute();
        }
    }

    public List<Sack> getList(String data, String date, int tipo, String product) throws SQLException {

        String sql = (tipo == 0) ? "select product.name, truck.name, sacks.* from sacks, product, truck"
                +" WHERE sacks.date between ? and ? and product.name LIKE '%?%' and product.id_product = sacks.id_product"
                +" and sacks.id_truck=truck.id_truck;" : "select product.name, truck.name, sacks.* from "
                + "product, truck, sacks WHERE sacks.date between ? and ? and product.id_product=sacks.id_product"
                +" and truck.id_truck = sacks.id_truck;";

        ResultSet rs;
        List<Sack> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, data);
            stmt.setString(2, date);
            if (tipo == 0) 
                stmt.setString(3, product);
            

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Sack m = new Sack();

                m.setId_sack(rs.getInt("id_sacks"));
                m.setId_prod(rs.getInt("id_product"));
                m.setId_truck(rs.getInt("id_truck"));
                m.setAmount(rs.getInt("amount"));
                m.setDate(rs.getString("date"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public int getAmoutSacks(String d1, String d2, String product) throws SQLException {
        String sql = "select sum(amount) from sacks, product WHERE sacks.date between ? and ? and product.name LIKE '%?%' and product.id_product = sacks.id_product;";
        int amount;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, d1);
            stmt.setString(2, d2);
            stmt.setString(3, product);

            ResultSet rs = stmt.executeQuery();
            amount = 0;
            while (rs.next())
                amount = rs.getInt("sum(amount)");
            
        }

        return amount;
    }
}
