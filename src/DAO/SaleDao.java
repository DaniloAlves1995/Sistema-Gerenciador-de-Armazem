package DAO;

import java.sql.Connection;

import Connection.CreateConnection;
import Entities.OutStock;
import Entities.Sale;
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

public class SaleDao {

    private final Connection connection;

    public SaleDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    }

    public void add(Sale m1) throws SQLException {
        String sql = "insert into sale(id_sale_out, id_product, price, amount, value) "
                + "values(?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, m1.getId_outStock());
            stmt.setInt(2, m1.getId_prod());
            stmt.setDouble(3, m1.getPrice());
            stmt.setInt(4, m1.getAmount());
            stmt.setDouble(5, m1.getValueProduct());

            stmt.execute();
        }
    }

    public List<Sale> getList(int id_s) throws SQLException {
        String sql = "select * from sale WHERE id_sal=?";
        ResultSet rs;
        List<Sale> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            stmt.setInt(1, id_s);

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Sale m = new Sale();

                m.setId_sale(rs.getInt("id_sale"));
                m.setId_prod(rs.getInt("id_product"));
                m.setId_outStock(rs.getInt("id_sale_out"));
                m.setPrice(rs.getDouble("prico"));
                m.setAmount(rs.getInt("amount"));
                m.setValueProduct(rs.getDouble("value"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public void update(Sale m) throws SQLException {
        String sql = "update sale set id_product=?, price=?, amount=?, value=?"
                + " where id_sale=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId_prod());
            stmt.setDouble(2, m.getPrice());
            stmt.setInt(3, m.getAmount());
            stmt.setDouble(4, m.getValueProduct());
            stmt.setInt(5, m.getId_sale());

            stmt.execute(); 
        }
    }

    public void deleteBySale(Sale m) throws SQLException {
        String sql = "delete from sale where id_sale=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId_sale());
            stmt.execute();
        }
    }

    public void deleteByOut(int idsale_out) throws SQLException {
        String sql = "delete from sale where id_sale=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, idsale_out);
            stmt.execute();
        }
    }

    public int getAmount(int id_s) throws SQLException {
        String sql = "select SUM(amount) from sale WHERE id_sale=?";
        ResultSet rs;
        int amount;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            stmt.setInt(1, id_s);

            rs = stmt.executeQuery();
            amount = 0;
            while (rs.next()) 
                amount = rs.getInt("SUM(amount)");
            

        }
        rs.close();

        return amount;
    }

    public int getAmountProductsOut(List<OutStock> lists, int id_product) throws SQLException {

        //montando String SQL dinamicamente
        String sql = "select SUM(amount) from sale WHERE id_product=" + id_product + " and (";
        for (int i = 0; i < lists.size(); i++)
            sql = (i == 0) ? sql + "id_sale_out=" + lists.get(i).getId_outStock() : sql + " or id_sale_out=" + lists.get(i).getId_outStock();

        sql += ");";

        ResultSet rs;
        int amount;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            rs = stmt.executeQuery();
            amount = 0;
            while (rs.next()) {
                amount = rs.getInt("SUM(amount)");
            }
        }
        rs.close();

        return amount;
    }

    public List<Sale> getProductsOut(List<OutStock> listas) throws SQLException {
        String sql = "select distinct id_product from sale WHERE ";
        for (int i = 0; i < listas.size(); i++)
            sql += (i == 0) ? "id_sale_out=" + listas.get(i).getId_outStock() : " or id_sale_out=" + listas.get(i).getId_outStock();
        ResultSet rs;
        List<Sale> lista;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            rs = stmt.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Sale v = new Sale();
                v.setId_prod(rs.getInt("id_product"));

                lista.add(v);
            }
        }
        rs.close();

        return lista;
    }

}
