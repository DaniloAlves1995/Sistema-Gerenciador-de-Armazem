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

    private Connection connection;

    public SaleDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    }

    public void add(Sale m1) throws SQLException {
        String sql = "insert into venda(id_s, id_p, preco, qtd, valor_p) "
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
        String sql = "select * from venda WHERE id_s=?";
        ResultSet rs;
        List<Sale> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            stmt.setInt(1, id_s);

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Sale m = new Sale();

                m.setId_sale(rs.getInt("id_v"));
                m.setId_prod(rs.getInt("id_p"));
                m.setId_outStock(rs.getInt("id_s"));
                m.setPrice(rs.getDouble("preco"));
                m.setAmount(rs.getInt("qtd"));
                m.setValueProduct(rs.getDouble("valor_p"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public void update(Sale m) throws SQLException {
        String sql = "update venda set id_p=?, preco=?, qtd=?, valor_p=?"
                + " where id_v=?";
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
        String sql = "delete from venda where id_v=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId_sale());
            stmt.execute();
        }
    }

    public void deleteByOut(int idsaida) throws SQLException {
        String sql = "delete from venda where id_s=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, idsaida);
            stmt.execute();
        }
    }

    public void adicionaPDF(String d1, String d2) throws SQLException {
        String sql = "insert into pdf_venda(dataI, dataF) values(?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, d1);
            stmt.setString(2, d2);

            stmt.execute();
        }
    }

    public void LimparPDF() throws SQLException {
        String sql = "TRUNCATE TABLE `pdf_venda`";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    public int getAmount(int id_s) throws SQLException {
        String sql = "select SUM(qtd) from venda WHERE id_s=?";
        ResultSet rs;
        int qtd;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            stmt.setInt(1, id_s);

            rs = stmt.executeQuery();
            qtd = 0;
            while (rs.next()) 
                qtd = rs.getInt("SUM(qtd)");
            

        }
        rs.close();

        return qtd;
    }

    public int getAmountProductsOut(List<OutStock> lists, int id_p) throws SQLException {

        //montando String SQL dinamicamente
        String sql = "select SUM(qtd) from venda WHERE id_p=" + id_p + " and (";
        for (int i = 0; i < lists.size(); i++)
            sql = (i == 0) ? sql + "id_s=" + lists.get(i).getId_outStock() : sql + " or id_s=" + lists.get(i).getId_outStock();

        sql += ");";

        ResultSet rs;
        int qtd;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            rs = stmt.executeQuery();
            qtd = 0;
            while (rs.next()) {
                qtd = rs.getInt("SUM(qtd)");
            }
        }
        rs.close();

        return qtd;
    }

    public List<Sale> getProductsOut(List<OutStock> listas) throws SQLException {
        String sql = "select distinct id_p from venda WHERE ";
        for (int i = 0; i < listas.size(); i++)
            sql += (i == 0) ? "id_s=" + listas.get(i).getId_outStock() : " or id_s=" + listas.get(i).getId_outStock();
        ResultSet rs;
        List<Sale> lista;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            rs = stmt.executeQuery();
            lista = new ArrayList<>();
            while (rs.next()) {
                Sale v = new Sale();
                v.setId_prod(rs.getInt("id_p"));

                lista.add(v);
            }
        }
        rs.close();

        return lista;
    }

}
