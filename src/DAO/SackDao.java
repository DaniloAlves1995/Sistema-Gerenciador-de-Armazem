/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.CreateConnection;
import Entities.Sack;
import java.sql.Connection;
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

public class SackDao {

    private final Connection connection;

    public SackDao() throws SQLException {
        this.connection = (Connection) CreateConnection.getConnection();
    }

    public void add(Sack m1) throws SQLException {
        String sql = "insert into sacas(id_p, id_ca, qtd, data) values(?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, m1.getId_prod());
            stmt.setInt(2, m1.getId_truck());
            stmt.setInt(3, m1.getAmount());
            stmt.setString(4, m1.getDate());

            stmt.execute();
        }
    }

    public List<Sack> getList(String data, String date, int tipo, String product) throws SQLException {

        String sql = (tipo == 0) ? "select produto.nome_p, caminhao.nome_ca, sacas.* from sacas, produto, caminhao"
                +" WHERE sacas.data between ? and ? and produto.nome_p LIKE '%?%' and produto.id_p = sacas.id_p"
                +" and sacas.id_ca=caminhao.id_ca;" : "select produto.nome_p, caminhao.nome_ca, sacas.* from "
                + "produto, caminhao, sacas WHERE sacas.data between ? and ? and produto.id_p=sacas.id_p"
                +" and caminhao.id_ca = sacas.id_ca;";

        ResultSet rs;
        List<Sack> ma;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, data);
            stmt.setString(2, date);
            if (tipo == 0) 
                stmt.setString(3, product);
            

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Sack m = new Sack();

                m.setId_sack(rs.getInt("id_sa"));
                m.setId_prod(rs.getInt("id_p"));
                m.setId_truck(rs.getInt("id_ca"));
                m.setAmount(rs.getInt("qtd"));
                m.setDate(rs.getString("data"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public int getAmoutSacks(String d1, String d2, String product) throws SQLException {
        String sql = "select sum(qtd) from sacas, produto WHERE sacas.data between ? and ? and produto.nome_p LIKE '%?%' and produto.id_p = sacas.id_p;";
        int qtd;
        try (PreparedStatement stmt = this.connection.prepareStatement(sql)) {
            stmt.setString(1, d1);
            stmt.setString(2, d2);
            stmt.setString(3, product);

            ResultSet rs = stmt.executeQuery();
            qtd = 0;
            while (rs.next())
                qtd = rs.getInt("sum(qtd)");
            
        }

        return qtd;
    }
}
