package DAO;

import java.sql.Connection;

import Conexao.CreateConnection;
import Entidades.Produto;
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

    public void add(Produto m1) throws SQLException {
        String sql = "insert into produto(nome_p, preco_p, obs) values(?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, m1.getProduto().toUpperCase());
            stmt.setDouble(2, m1.getPreco());
            stmt.setString(3, m1.getObs().toUpperCase());

            stmt.execute();
        }
    }

    public List<Produto> getList(String data) throws SQLException {
        String sql = "select * from produto WHERE nome_p LIKE ?";
        ResultSet rs;
        List<Produto> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, "%"+data+"%");

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Produto m = new Produto();

                m.setId(rs.getInt("id_p"));
                m.setProduto(rs.getString("nome_p"));
                m.setPreco(rs.getDouble("preco_p"));
                m.setObs(rs.getString("obs"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public List<Produto> getListAll() throws SQLException {
        String sql = "select * from produto";
        ResultSet rs;
        List<Produto> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Produto m = new Produto();

                m.setId(rs.getInt("id_p"));
                m.setProduto(rs.getString("nome_p"));
                m.setPreco(rs.getDouble("preco_p"));
                m.setObs(rs.getString("obs"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public void update(Produto m) throws SQLException {
        String sql = "update produto set nome_p=?, preco_p=?, obs=? where id_p=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, m.getProduto().toUpperCase());
            stmt.setDouble(2, m.getPreco());
            stmt.setString(3, m.getObs().toUpperCase());
            stmt.setInt(4, m.getId());

            stmt.execute();
        }
    }

    public void delete(Produto m) throws SQLException {
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

    public Produto getProduct(int id) throws SQLException {
        String sql = "select * from produto where id_p=?";
        Produto m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            m = new Produto();
            while (rs.next()) {
                m.setId(rs.getInt("id_p"));
                m.setProduto(rs.getString("nome_p"));
                m.setPreco(rs.getDouble("preco_p"));
                m.setObs(rs.getString("obs"));
            }
        }

        return m;
    }

    public Produto getProduct(String name) throws SQLException {
        String sql = "select * from produto where nome_p='?';";
        Produto m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            m = new Produto();
            while (rs.next()) {
                m.setId(rs.getInt("id_p"));
                m.setProduto(rs.getString("nome_p"));
                m.setPreco(rs.getDouble("preco_p"));
                m.setObs(rs.getString("obs"));
            }
        }

        return m;
    }

    public void AddPDF_RelatorioE(List<Produto> lista) throws SQLException {
        String sql = "insert into pdf_relatorioe(id_p, produto, qtd_e) values(?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            StockDao edao = new StockDao();

            for (int i = 0; i < lista.size(); i++) {
                stmt.setInt(1, lista.get(i).getId());
                stmt.setString(2, lista.get(i).getProduto().toUpperCase());
                stmt.setInt(3, edao.getStock(lista.get(i).getId()).getQtd());

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
