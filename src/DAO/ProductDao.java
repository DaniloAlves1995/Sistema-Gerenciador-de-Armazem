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

    private Connection connection;

    public ProductDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    }

    public void add(Product m1) throws SQLException {
        String sql = "insert into produto(nome_p, preco_p, obs) values(?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, m1.getProduct().toUpperCase());
            stmt.setDouble(2, m1.getPrice());
            stmt.setString(3, m1.getNote().toUpperCase());

            stmt.execute();
        } 
    }

    public List<Product> getList(String data) throws SQLException {
        String sql = "select * from produto WHERE nome_p LIKE ?";
        ResultSet rs;
        List<Product> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, "%"+data+"%");

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Product m = new Product();

                m.setId(rs.getInt("id_p"));
                m.setProduct(rs.getString("nome_p"));
                m.setPrice(rs.getDouble("preco_p"));
                m.setNote(rs.getString("obs"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public List<Product> getListAll() throws SQLException {
        String sql = "select * from produto";
        ResultSet rs;
        List<Product> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Product m = new Product();

                m.setId(rs.getInt("id_p"));
                m.setProduct(rs.getString("nome_p"));
                m.setPrice(rs.getDouble("preco_p"));
                m.setNote(rs.getString("obs"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public void update(Product m) throws SQLException {
        String sql = "update produto set nome_p=?, preco_p=?, obs=? where id_p=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, m.getProduct().toUpperCase());
            stmt.setDouble(2, m.getPrice());
            stmt.setString(3, m.getNote().toUpperCase());
            stmt.setInt(4, m.getId());

            stmt.execute();
        }
    }

    public void delete(Product m) throws SQLException {
        String sql = "delete from produto where id_p=?";

        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId());
            stmt.execute();
        }
    }

    public int getAmountProducts() throws SQLException {
        String sql = "SELECT COUNT(*) FROM produto;";
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
        String sql = "select * from produto where id_p=?";
        Product m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            m = new Product();
            while (rs.next()) {
                m.setId(rs.getInt("id_p"));
                m.setProduct(rs.getString("nome_p"));
                m.setPrice(rs.getDouble("preco_p"));
                m.setNote(rs.getString("obs"));
            }
        }

        return m;
    }

    public Product getProduct(String name) throws SQLException {
        String sql = "select * from produto where nome_p=?;";
        Product m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            m = new Product();
            while (rs.next()) {
                m.setId(rs.getInt("id_p"));
                m.setProduct(rs.getString("nome_p"));
                m.setPrice(rs.getDouble("preco_p"));
                m.setNote(rs.getString("obs"));
            }
        }

        return m;
    }

    public void AddPDF_RelatorioE(List<Product> lista) throws SQLException {
        String sql = "insert into pdf_relatorioe(id_p, produto, qtd_e) values(?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            StockDao edao = new StockDao();

            for (int i = 0; i < lista.size(); i++) {
                stmt.setInt(1, lista.get(i).getId());
                stmt.setString(2, lista.get(i).getProduct().toUpperCase());
                stmt.setInt(3, edao.getStock(lista.get(i).getId()).getAmount());

                stmt.execute();
            }
        }
    }

    public int getLastId() throws SQLException {
        String sql = "SELECT * FROM produto ORDER BY id_p DESC LIMIT 1";
        int id;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            id = 0;
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id_p");
            }
        }
        return id;
    }

    public void LimparPDF_RelatorioE() throws SQLException {
        String sql = "TRUNCATE pdf_relatorioe";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.execute();
        }
    }
}
