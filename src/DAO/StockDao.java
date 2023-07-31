package DAO;

import java.sql.Connection;

import Connection.CreateConnection;
import Entities.Stock;
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

public class StockDao {

    private final Connection connection;

    public StockDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    }

    public void add(Stock m1) throws SQLException {
        String sql = "insert into stock(id_product, amount) values(?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, m1.getId_p());
            stmt.setInt(2, m1.getAmount());

            stmt.execute();
        }
    }

    public void addStockIn(Stock m1) throws SQLException {
        String sql = "insert into stock_entry(id_product, amount, date) values(?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, m1.getId_p());
            stmt.setInt(2, m1.getAmount());
            stmt.setString(3, m1.getDate());

            stmt.execute();
        }
    }

    public List<Stock> getList(String date) throws SQLException {
        String sql = "select * from stock WHERE id_product=?";
        ResultSet rs;
        List<Stock> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, date);

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Stock m = new Stock();

                m.setId_stock(rs.getInt("id_stock"));
                m.setId_p(rs.getInt("id_product"));
                m.setAmount(rs.getInt("amount"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public List<Stock> getListStockIn(String data, String date, int tipo, String product) throws SQLException {
        String sql = "";
        if (tipo == 0)
            //seja product especifico
            sql = "select * from stock_entry, product WHERE stock_entry.date between ? and ? and product.name LIKE '%?%' and product.id_product = stock_entry.id_product;";
        else
            sql = "select * from stock_entry WHERE date between ? and ?";
        

        ResultSet rs;
        List<Stock> ma; 
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, data);
            stmt.setString(2, date);
            if (tipo == 0) {
                stmt.setString(3, product);
            }

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Stock m = new Stock();

                m.setId_stock(rs.getInt("id_stock_entry"));
                m.setId_p(rs.getInt("id_product"));
                m.setAmount(rs.getInt("amount"));
                m.setDate(rs.getString("date"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public void update(Stock m) throws SQLException {
        String sql = "update stock set amount=? where id_stock=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getAmount());
            stmt.setInt(2, m.getId_stock());

            stmt.execute();
        }
    }

    public void delete(Stock m) throws SQLException {
        String sql = "delete from product where id_stock=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId_stock());
            stmt.execute();
        }
    }

    public int getAmountProducts() throws SQLException {
        String sql = "SELECT COUNT(*) FROM stock;";
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

    public Stock getStock(int id_product) throws SQLException {
        String sql = "select * from stock where id_product=?";
        Stock m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id_product);

            ResultSet rs = stmt.executeQuery();
            m = new Stock();
            while (rs.next()) {
                m.setId_stock(rs.getInt("id_stock"));
                m.setId_p(rs.getInt("id_product"));
                m.setAmount(rs.getInt("amount"));
            }
            if (m.getId_stock() == 0) {
                m = null;
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

    public int getAmountStock(String d1, String d2, String product) throws SQLException {
        String sql = "select sum(amount) from stock_entry, product WHERE stock_entry.date between ? and ? and product.name LIKE '%?%' and product.id_product = stock_entry.id_product;";
        int amount;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, d1);
            stmt.setString(2, d2);
            stmt.setString(3, product);

            ResultSet rs = stmt.executeQuery();
            amount = 0;
            while (rs.next()) {
                amount = rs.getInt("sum(amount)");
            }
        }

        return amount;
    }
}
