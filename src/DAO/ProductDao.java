package DAO;

import java.sql.Connection;

import Connection.CreateConnection;
import Entities.Product;
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

public class ProductDao {

    private final Connection connection;

    public ProductDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    }

    public void add(Product m1) throws SQLException {
        String sql = "insert into product(name, price, notes) values(?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, m1.getProduct().toUpperCase());
            stmt.setDouble(2, m1.getPrice());
            stmt.setString(3, m1.getNote().toUpperCase());

            stmt.execute();
        } 
    }

    public List<Product> getList(String date) throws SQLException {
        String sql = "select * from product WHERE name LIKE ?";
        ResultSet rs;
        List<Product> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, "%"+date+"%");

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Product m = new Product();

                m.setId(rs.getInt("id_product"));
                m.setProduct(rs.getString("name"));
                m.setPrice(rs.getDouble("price"));
                m.setNote(rs.getString("notes"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public List<Product> getListAll() throws SQLException {
        String sql = "select * from product";
        ResultSet rs;
        List<Product> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Product m = new Product();

                m.setId(rs.getInt("id_product"));
                m.setProduct(rs.getString("name"));
                m.setPrice(rs.getDouble("price"));
                m.setNote(rs.getString("notes"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public void update(Product m) throws SQLException {
        String sql = "update product set name=?, price=?, notes=? where id_product=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, m.getProduct().toUpperCase());
            stmt.setDouble(2, m.getPrice());
            stmt.setString(3, m.getNote().toUpperCase());
            stmt.setInt(4, m.getId());

            stmt.execute();
        }
    }

    public void delete(Product m) throws SQLException {
        String sql = "delete from product where id_product=?";

        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId());
            stmt.execute();
        }
    }

    public int getAmountProducts() throws SQLException {
        String sql = "SELECT COUNT(*) FROM product;";
        int amount = 0;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                amount = rs.getInt("COUNT(*)");
            }
        }

        return amount;
    }

    public Product getProduct(int id) throws SQLException {
        String sql = "select * from product where id_product=?";
        Product m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            m = new Product();
            while (rs.next()) {
                m.setId(rs.getInt("id_product"));
                m.setProduct(rs.getString("name"));
                m.setPrice(rs.getDouble("price"));
                m.setNote(rs.getString("notes"));
            }
        }

        return m;
    }

    public Product getProduct(String name) throws SQLException {
        String sql = "select * from product where name=?;";
        Product m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            m = new Product();
            while (rs.next()) {
                m.setId(rs.getInt("id_product"));
                m.setProduct(rs.getString("name"));
                m.setPrice(rs.getDouble("price"));
                m.setNote(rs.getString("notes"));
            }
        }

        return m;
    }

    public int getLastId() throws SQLException {
        String sql = "SELECT * FROM product ORDER BY id_product DESC LIMIT 1";
        int id;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            id = 0;
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id_product");
            }
        }
        return id;
    }

}
