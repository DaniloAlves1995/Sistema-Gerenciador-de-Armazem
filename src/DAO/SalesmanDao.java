package DAO;

import java.sql.Connection;

import Conexao.CreateConnection;
import Entidades.Vendedor;
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

    public void add(Vendedor m1) throws SQLException {
        String sql = "insert into funcionario(nome_fun, endereco, contato1, contato2) "
                + "values(?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, m1.getNome().toUpperCase());
            stmt.setString(2, m1.getEndereco().toUpperCase());
            stmt.setString(3, m1.getContato1());
            stmt.setString(4, m1.getContato2());

            stmt.execute();
        }
    }

    public List<Vendedor> getList(String data) throws SQLException {
        String sql = "select * from funcionario WHERE nome_fun LIKE ?";
        ResultSet rs;
        List<Vendedor> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {

            stmt.setString(1, "%"+data+"%");
            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Vendedor m = new Vendedor();

                m.setId_vendedor(rs.getInt("id_fun"));
                m.setNome(rs.getString("nome_fun"));
                m.setEndereco(rs.getString("endereco"));
                m.setContato1(rs.getString("contato1"));
                m.setContato2(rs.getString("contato2"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public void update(Vendedor m) throws SQLException {
        String sql = "update funcionario set nome_fun=?, endereco=?, contato1=?, contato2=?"
                + " where id_fun=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, m.getNome().toUpperCase());
            stmt.setString(2, m.getEndereco().toUpperCase());
            stmt.setString(3, m.getContato1());
            stmt.setString(4, m.getContato2());
            stmt.setInt(5, m.getId_vendedor());

            stmt.execute();
        }
    }

    public void delete(Vendedor m) throws SQLException {
        String sql = "delete from funcionario where id_fun=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId_vendedor());
            stmt.execute();
        }
    }

    public Vendedor getSelesman(int id) throws SQLException {
        String sql = "select * from funcionario WHERE id_fun=?";
        ResultSet rs;
        Vendedor m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            m = new Vendedor();
            while (rs.next()) {
                m.setId_vendedor(rs.getInt("id_fun"));
                m.setNome(rs.getString("nome_fun"));
                m.setEndereco(rs.getString("endereco"));
                m.setContato1(rs.getString("contato1"));
                m.setContato2(rs.getString("contato2"));
            }
        }
        rs.close();

        return m;
    }

    public int getAmountSelesman() throws SQLException {
        String sql = "SELECT COUNT(*) FROM funcionario;";
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
