package DAO;

import java.sql.Connection;

import Connection.CreateConnection;
import Entities.Customer;
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

public class CustomerDao implements InterfaceBasicDB<Customer>{

  
    private final Connection connection;

    
    public CustomerDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    }


    @Override
    public void add(Customer m1) { 
        String sql = "insert into customer(name, address, cpf, phone1, phone2) "
                + "values(?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, m1.getName().toUpperCase());
            stmt.setString(2, m1.getAddress().toUpperCase());
            stmt.setString(3, m1.getCpf());
            stmt.setString(4, m1.getContact1());
            stmt.setString(5, m1.getContact2());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Customer> getList(String dado) {
        String sql = "select * from customer WHERE name LIKE ?";
        ResultSet rs;
        List<Customer> ma = null;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, "%"+dado+"%");

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Customer m = new Customer();

                m.setId(rs.getInt("id_customer"));
                m.setName(rs.getString("name"));
                m.setAddress(rs.getString("address"));
                m.setContato1(rs.getString("phone1"));
                m.setContact2(rs.getString("phone2"));
                m.setCpf(rs.getString("cpf"));

                ma.add(m);
            }
            
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return ma;
    }

    public List<Customer> getListByAddress(String address) throws SQLException {
        String sql = "select * from customer WHERE address LIKE ?";
        ResultSet rs;
        List<Customer> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, "%"+address+"%");

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Customer m = new Customer();

                m.setId(rs.getInt("id_customer"));
                m.setName(rs.getString("name"));
                m.setAddress(rs.getString("address"));
                m.setContato1(rs.getString("phone1"));
                m.setContact2(rs.getString("phone2"));
                m.setCpf(rs.getString("cpf"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    @Override
    public void update(Customer m)  {
        String sql = "update customer set name=?, address=?, cpf=?, phone1=?, phone2=?"
                + " where id_customer=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, m.getName().toUpperCase());
            stmt.setString(2, m.getAddress().toUpperCase());
            stmt.setString(3, m.getCpf());
            stmt.setString(4, m.getContact1());
            stmt.setString(5, m.getContact2());
            stmt.setInt(6, m.getId());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Customer m)  {
        String sql = "delete from customer where id_customer=?";
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, m.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getAmountCustumers() throws SQLException {
        String sql = "SELECT COUNT(*) FROM customer;";
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

    public Customer getCustumer(int id) throws SQLException {
        String sql = "select * from customer WHERE id_customer=?";
        ResultSet rs;
        Customer m;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            m = new Customer();
            while (rs.next()) {
                m.setId(rs.getInt("id_customer"));
                m.setName(rs.getString("name"));
                m.setAddress(rs.getString("address"));
                m.setContato1(rs.getString("phone1"));
                m.setContact2(rs.getString("phone2"));
                m.setCpf(rs.getString("cpf"));
            }
        }
        rs.close();

        return m;
    }
}
