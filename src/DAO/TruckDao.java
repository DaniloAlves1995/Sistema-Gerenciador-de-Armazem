/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.CreateConnection;
import Entities.Truck;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *************************************************************
 * ------------- ..::Danilo Alves Oliveira::.. ------------- *
 * ***********************************************************
 * 
 * 
 */

public class TruckDao implements InterfaceBasicDB<Truck>{

    private final Connection connection;

    public TruckDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    }

    @Override
    public void add(Truck m1) {
        try {
            String sql = "insert into truck(name_ca, carga, date) "
                    + "values(?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, m1.getName().toUpperCase());
            stmt.setInt(2, m1.getTruckLoad());
            stmt.setString(3, m1.getDate());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(TruckDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addTruckLoad(Truck m1) throws SQLException {
        String sql = "insert into caminhao_carga(id_customera, carga) "
                + "values(?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, m1.getId());
        stmt.setInt(2, m1.getTruckLoad());

        stmt.execute();
        stmt.close();
    }

   
    public List<Truck> getList(String dado, int tipo) throws SQLException {
        String sql = "";
        if (tipo == 0)
            sql = "select truck.id_customera, truck.name_ca, truck.date, caminhao_carga.carga from truck, caminhao_carga WHERE truck.name_ca LIKE '%" + dado + "%' and truck.id_customera = caminhao_carga.id_customera;";
        else
            sql = "select truck.id_customera, truck.name_ca, truck.date, caminhao_carga.carga from truck, caminhao_carga WHERE "
                    + "caminhao_carga.carga > 0 and truck.id_customera = caminhao_carga.id_customera;";
        
        ResultSet rs;
        List<Truck> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Truck m = new Truck();

                m.setId(rs.getInt("id_customera"));
                m.setName(rs.getString("name_ca"));
                m.setTruckLoad(rs.getInt("carga"));
                m.setdate(rs.getString("date"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public Truck getTruck(int id_customera) throws SQLException {
        String sql = "select * from truck where id_customera=" + id_customera;
        Truck m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            m = new Truck();
            while (rs.next()) {
                m.setId(rs.getInt("id_customera"));
                m.setName(rs.getString("name_ca"));
                m.setTruckLoad(rs.getInt("carga"));
                m.setdate(rs.getString("date"));
            }
        }

        return m;
    }

    @Override
    public void update(Truck m) {
        String sql = "update truck set name_ca=?, carga=? where id_customera=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, m.getName().toUpperCase());
            stmt.setInt(2, m.getTruckLoad());
            stmt.setInt(3, m.getId());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TruckDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateTruckLoad(Truck m) throws SQLException {
        String sql = "update caminhao_carga set carga=? where id_customera=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getTruckLoad());
            stmt.setInt(2, m.getId());

            stmt.execute();
        }
    }

    @Override
    public void delete(Truck m) {
        String sql = "delete from truck where id_customera=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TruckDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteTruckLoad(Truck m) throws SQLException {
        String sql = "delete from caminhao_carga where id_customera=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId());

            stmt.execute();
        }
    }

    public int getAmountTrucks() throws SQLException {
        String sql = "SELECT COUNT(*) FROM truck;";
        int amount;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            amount = 0;
            while (rs.next()) {
                amount = rs.getInt("COUNT(*)");
            }

        }

        return amount;
    }

    public int getLastId() throws SQLException {
        String sql = "SELECT * FROM truck ORDER BY id_customera DESC LIMIT 1";
        PreparedStatement stmt = this.connection.prepareStatement(sql);

        int id = 0;
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id_customera");
        }
        return id;
    }

    public List<Truck> getTruckDates(String dado, String date) throws SQLException {
        String sql = "select * from truck WHERE date between ? and ?";
        ResultSet rs;
        List<Truck> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            stmt.setString(1, dado);
            stmt.setString(2, date);

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Truck m = new Truck();

                m.setId(rs.getInt("id_customera"));
                m.setName(rs.getString("name_ca"));
                m.setTruckLoad(rs.getInt("carga"));
                m.setdate(rs.getString("date"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }
}
