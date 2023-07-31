package DAO;

import java.sql.Connection;

import Connection.CreateConnection;
import Entities.Salesman;
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

public class SalesmanDao {

    private final Connection connection;

    public SalesmanDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    } 

    public void add(Salesman m1) throws SQLException {
        String sql = "insert into seller(name, address, phone1, phone2) "
                + "values(?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, m1.getName().toUpperCase());
            stmt.setString(2, m1.getAddress().toUpperCase());
            stmt.setString(3, m1.getContact1());
            stmt.setString(4, m1.getContact2());

            stmt.execute();
        }
    }

    public List<Salesman> getList(String date) throws SQLException {
        String sql = "select * from seller WHERE name LIKE ?";
        ResultSet rs;
        List<Salesman> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            stmt.setString(1, "%"+date+"%");
            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Salesman m = new Salesman();

                m.setId_salesman(rs.getInt("id_seller"));
                m.setName(rs.getString("name"));
                m.setAddress(rs.getString("address"));
                m.setContato1(rs.getString("phone1"));
                m.setContact2(rs.getString("phone2"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public void update(Salesman m) throws SQLException {
        String sql = "update seller set name=?, address=?, phone1=?, phone2=?"
                + " where id_seller=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, m.getName().toUpperCase());
            stmt.setString(2, m.getAddress().toUpperCase());
            stmt.setString(3, m.getContact1());
            stmt.setString(4, m.getContact2());
            stmt.setInt(5, m.getId_salesman());

            stmt.execute();
        }
    }

    public void delete(Salesman m) throws SQLException {
        String sql = "delete from seller where id_seller=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId_salesman());
            stmt.execute();
        }
    }

    public Salesman getSelesman(int id) throws SQLException {
        String sql = "select * from seller WHERE id_seller=?";
        ResultSet rs;
        Salesman m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            m = new Salesman();
            while (rs.next()) {
                m.setId_salesman(rs.getInt("id_seller"));
                m.setName(rs.getString("name"));
                m.setAddress(rs.getString("address"));
                m.setContato1(rs.getString("phone1"));
                m.setContact2(rs.getString("phone2"));
            }
        }
        rs.close();

        return m;
    }

    public int getAmountSelesman() throws SQLException {
        String sql = "SELECT COUNT(*) FROM seller;";
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
}
