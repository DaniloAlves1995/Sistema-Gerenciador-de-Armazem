package DAO;

import java.sql.Connection;

import Conexao.CreateConnection;
import Entidades.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *************************************************************
 * ------------- ..::Danilo Alves Oliveira::.. ------------- *
 * ***********************************************************
 * 
 *@Developer Danilo Alves
 * 
 */

public class CustomerDao implements InterfaceBasicDB<Cliente>{

  
    private final Connection connection;

    
    public CustomerDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    }


    @Override
    public void add(Cliente m1) {
        String sql = "insert into cliente(nome, endereco, cpf, contato1, contato2) "
                + "values(?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, m1.getNome().toUpperCase());
            stmt.setString(2, m1.getEndereco().toUpperCase());
            stmt.setString(3, m1.getCpf());
            stmt.setString(4, m1.getContato1());
            stmt.setString(5, m1.getContato2());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cliente> getList(String dado) {
        String sql = "select * from cliente WHERE nome LIKE ?";
        ResultSet rs;
        List<Cliente> ma = null;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, "%"+dado+"%");

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Cliente m = new Cliente();

                m.setId(rs.getInt("id_c"));
                m.setNome(rs.getString("nome"));
                m.setEndereco(rs.getString("endereco"));
                m.setContato1(rs.getString("contato1"));
                m.setContato2(rs.getString("contato2"));
                m.setCpf(rs.getString("cpf"));

                ma.add(m);
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return ma;
    }

    public List<Cliente> getListByAddress(String address) throws SQLException {
        String sql = "select * from cliente WHERE endereco LIKE ?";
        ResultSet rs;
        List<Cliente> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, "%"+address+"%");

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Cliente m = new Cliente();

                m.setId(rs.getInt("id_c"));
                m.setNome(rs.getString("nome"));
                m.setEndereco(rs.getString("endereco"));
                m.setContato1(rs.getString("contato1"));
                m.setContato2(rs.getString("contato2"));
                m.setCpf(rs.getString("cpf"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    @Override
    public void update(Cliente m)  {
        String sql = "update cliente set nome=?, endereco=?, cpf=?, contato1=?, contato2=?"
                + " where id_c=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, m.getNome().toUpperCase());
            stmt.setString(2, m.getEndereco().toUpperCase());
            stmt.setString(3, m.getCpf());
            stmt.setString(4, m.getContato1());
            stmt.setString(5, m.getContato2());
            stmt.setInt(6, m.getId());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Cliente m)  {
        String sql = "delete from cliente where id_c=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getAmountCustumers() throws SQLException {
        String sql = "SELECT COUNT(*) FROM cliente;";
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

    public Cliente getCustumer(int id) throws SQLException {
        String sql = "select * from cliente WHERE id_c=?";
        ResultSet rs;
        Cliente m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            m = new Cliente();
            while (rs.next()) {
                m.setId(rs.getInt("id_c"));
                m.setNome(rs.getString("nome"));
                m.setEndereco(rs.getString("endereco"));
                m.setContato1(rs.getString("contato1"));
                m.setContato2(rs.getString("contato2"));
                m.setCpf(rs.getString("cpf"));
            }
        }
        rs.close();

        return m;
    }
}
