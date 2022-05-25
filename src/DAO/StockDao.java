package DAO;

import java.sql.Connection;

import Conexao.CreateConnection;
import Entidades.Estoque;
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

public class StockDao {

    private Connection connection;

    public StockDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    }

    public void add(Estoque m1) throws SQLException {
        String sql = "insert into estoque(id_p, qtd) values(?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, m1.getId_p());
            stmt.setInt(2, m1.getQtd());

            stmt.execute();
        }
    }

    public void addTotal(int amount) throws SQLException {
        String sql = "insert into pdf_total(total) values(?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, amount);

            stmt.execute();
        }
    }

    public void cleanTotal() throws SQLException {
        String sql = "TRUNCATE pdf_total";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    public void addStockIn(Estoque m1) throws SQLException {
        String sql = "insert into estoque_entrada(id_p, qtd, data) values(?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, m1.getId_p());
            stmt.setInt(2, m1.getQtd());
            stmt.setString(3, m1.getData());

            stmt.execute();
        }
    }

    public List<Estoque> getList(String data) throws SQLException {
        String sql = "select * from estoque WHERE id_p=?";
        ResultSet rs;
        List<Estoque> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, data);

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Estoque m = new Estoque();

                m.setId_e(rs.getInt("id_e"));
                m.setId_p(rs.getInt("id_p"));
                m.setQtd(rs.getInt("qtd"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public List<Estoque> getListStockIn(String data, String date, int tipo, String produto) throws SQLException {
        String sql = "";
        if (tipo == 0)
            //seja produto especifico
            sql = "select * from estoque_entrada, produto WHERE estoque_entrada.data between '?' and '?' and produto.nome_p LIKE '%?%' and produto.id_p = estoque_entrada.id_p;";
        else
            sql = "select * from estoque_entrada WHERE data between '?' and '?'";
        

        ResultSet rs;
        List<Estoque> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, data);
            stmt.setString(2, date);
            if (tipo == 0) {
                stmt.setString(3, produto);
            }

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Estoque m = new Estoque();

                m.setId_e(rs.getInt("id_ee"));
                m.setId_p(rs.getInt("id_p"));
                m.setQtd(rs.getInt("qtd"));
                m.setData(rs.getString("data"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public void update(Estoque m) throws SQLException {
        String sql = "update estoque set qtd=? where id_e=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getQtd());
            stmt.setInt(2, m.getId_e());

            stmt.execute();
        }
    }

    public void delete(Estoque m) throws SQLException {
        String sql = "delete from produto where id_e=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId_e());
            stmt.execute();
        }
    }

    public int getAmountProducts() throws SQLException {
        String sql = "SELECT COUNT(*) FROM estoque;";
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

    public Estoque getStock(int id_produto) throws SQLException {
        String sql = "select * from estoque where id_p=?";
        Estoque m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id_produto);

            ResultSet rs = stmt.executeQuery();
            m = new Estoque();
            while (rs.next()) {
                m.setId_e(rs.getInt("id_e"));
                m.setId_p(rs.getInt("id_p"));
                m.setQtd(rs.getInt("qtd"));
            }
            if (m.getId_e() == 0) {
                m = null;
            }
        }
        return m;
    }

    public Produto getProduct(String name) throws SQLException {
        String sql = "select * from produto where nome=?;";
        Produto m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, name);

            ResultSet rs = stmt.executeQuery();
            m = new Produto();
            while (rs.next()) {
                m.setId(rs.getInt("id_p"));
                m.setProduto(rs.getString("nome"));
                m.setPreco(rs.getDouble("preco"));
                m.setObs(rs.getString("obs"));
            }
        }

        return m;
    }

    public int getAmountStock(String d1, String d2, String product) throws SQLException {
        String sql = "select sum(qtd) from estoque_entrada, produto WHERE estoque_entrada.data between '?' and '?' and produto.nome_p LIKE '%?%' and produto.id_p = estoque_entrada.id_p;";
        int qtd;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, d1);
            stmt.setString(2, d2);
            stmt.setString(3, product);

            ResultSet rs = stmt.executeQuery();
            qtd = 0;
            while (rs.next()) {
                qtd = rs.getInt("sum(qtd)");
            }
        }

        return qtd;
    }
}
