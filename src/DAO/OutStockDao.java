package DAO;

import java.sql.Connection;

import Connection.CreateConnection;
import Entities.OutStock;
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

public class OutStockDao {

    private final Connection connection;

    public OutStockDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    }

    public void add(OutStock m1) throws SQLException {
        String sql = "insert into sale_out(id_customer, id_seller, total, date) "
                + "values(?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setInt(1, m1.getId_customer());
        stmt.setInt(2, m1.getId_salesman());
        stmt.setDouble(3, m1.getTotal());
        stmt.setString(4, m1.getDate());

        stmt.execute();
        stmt.close();

    }

    public List<OutStock> getList(String data, String date, int type) throws SQLException {
        String sql = "";
        switch (type) {
            case 0:
                sql = "select * from sale_out";
                break;
            case 1:
                sql = "select * from sale_out WHERE id_s=?";
                break;
            case 2:
                sql = "select * from sale_out WHERE id_customer=? and date like ?";
                break;
            case 3:
                sql = "select * from sale_out WHERE date like ?";
                break;
            case 6:
                sql = "select * from sale_out WHERE id_customer=?";
                break;
            case 7:
                sql = "select * from sale_out WHERE id_customer=?";
                break; 
            case 8:
                sql = "select * from sale_out WHERE date between ? and ?";
                break;
        }

        ResultSet rs;
        List<OutStock> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            if (type == 1 || type == 6 || type == 7)
                stmt.setString(1, data);
            
            if (type == 2 || type == 8) {
                stmt.setString(1, data);
                stmt.setString(2, date);
            }

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                OutStock m = new OutStock();

                m.setId_outStock(rs.getInt("id_sale_out"));
                m.setId_customer(rs.getInt("id_customer"));
                m.setId_salesman(rs.getInt("id_seller"));
                m.setTotal(rs.getDouble("total"));
                m.setDate(rs.getString("date"));

                ma.add(m);

            }
        }
        rs.close();

        return ma;
    }

    public List<OutStock> getInvoiceNotPaid(int id_customer) throws SQLException {
        String sql = "select * from sale_out WHERE id_customer=? and pg=0";
        ResultSet rs;
        List<OutStock> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            stmt.setInt(1, id_customer);

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                OutStock m = new OutStock();

                m.setId_outStock(rs.getInt("id_sale_out"));
                m.setId_customer(rs.getInt("id_customer"));
                m.setId_salesman(rs.getInt("id_seller"));
                m.setTotal(rs.getDouble("total"));
                m.setDate(rs.getString("date"));

                ma.add(m);

            }
        }
        rs.close();

        return ma;
    }

    public void delete(OutStock m) throws SQLException {
        String sql = "delete from sale_out where id_sale_out=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId_outStock());
            stmt.execute();
        }
    }

   
    public int getLastInvoiceId() throws SQLException {
        String sql = "SELECT * FROM sale_out ORDER BY id_sale_out DESC LIMIT 1";
        PreparedStatement stmt = this.connection.prepareStatement(sql);

        int id = 0;
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id_sale_out");
        }
        return id;
    }

    public void updateInvoice(OutStock n) throws SQLException {
        String sql = "update sale_out set total=? where id_sale_out=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setDouble(1, n.getTotal());
            stmt.setInt(2, n.getId_outStock());

            stmt.execute();
        }
    }

}
