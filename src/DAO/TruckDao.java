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
            String sql = "insert into caminhao(nome_ca, carga, data) "
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
        String sql = "insert into caminhao_carga(id_ca, carga) "
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
            sql = "select caminhao.id_ca, caminhao.nome_ca, caminhao.data, caminhao_carga.carga from caminhao, caminhao_carga WHERE caminhao.nome_ca LIKE '%" + dado + "%' and caminhao.id_ca = caminhao_carga.id_ca;";
        else
            sql = "select caminhao.id_ca, caminhao.nome_ca, caminhao.data, caminhao_carga.carga from caminhao, caminhao_carga WHERE "
                    + "caminhao_carga.carga > 0 and caminhao.id_ca = caminhao_carga.id_ca;";
        
        ResultSet rs;
        List<Truck> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Truck m = new Truck();

                m.setId(rs.getInt("id_ca"));
                m.setName(rs.getString("nome_ca"));
                m.setTruckLoad(rs.getInt("carga"));
                m.setData(rs.getString("data"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public Truck getTruck(int id_ca) throws SQLException {
        String sql = "select * from caminhao where id_ca=" + id_ca;
        Truck m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            m = new Truck();
            while (rs.next()) {
                m.setId(rs.getInt("id_ca"));
                m.setName(rs.getString("nome_ca"));
                m.setTruckLoad(rs.getInt("carga"));
                m.setData(rs.getString("data"));
            }
        }

        return m;
    }

    @Override
    public void update(Truck m) {
        String sql = "update caminhao set nome_ca=?, carga=? where id_ca=?";
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
        String sql = "update caminhao_carga set carga=? where id_ca=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getTruckLoad());
            stmt.setInt(2, m.getId());

            stmt.execute();
        }
    }

    @Override
    public void delete(Truck m) {
        String sql = "delete from caminhao where id_ca=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TruckDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteTruckLoad(Truck m) throws SQLException {
        String sql = "delete from caminhao_carga where id_ca=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId());

            stmt.execute();
        }
    }

    public int getAmountTrucks() throws SQLException {
        String sql = "SELECT COUNT(*) FROM caminhao;";
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
        String sql = "SELECT * FROM caminhao ORDER BY id_ca DESC LIMIT 1";
        PreparedStatement stmt = this.connection.prepareStatement(sql);

        int id = 0;
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id_ca");
        }
        return id;
    }

    public List<Truck> getTruckDates(String dado, String data) throws SQLException {
        String sql = "select * from caminhao WHERE data between ? and ?";
        ResultSet rs;
        List<Truck> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            stmt.setString(1, dado);
            stmt.setString(2, data);

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Truck m = new Truck();

                m.setId(rs.getInt("id_ca"));
                m.setName(rs.getString("nome_ca"));
                m.setTruckLoad(rs.getInt("carga"));
                m.setData(rs.getString("data"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }
}
