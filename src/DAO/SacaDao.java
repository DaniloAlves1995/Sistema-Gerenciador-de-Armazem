/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.CriaConexao;
import Entidades.Saca;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Danilo
 */
public class SacaDao {

    //Variavel que recebe a conexão da classe CriaConexao
    private final Connection conexao;

    //Método Principal da Classe que serve para toda vez que tiver uma instância da classe abrir uma nova conexão 
    public SacaDao() throws SQLException {
        this.conexao = (Connection) CriaConexao.getConexao();
    }

    //método para adicionar o pruduto
    public void adiciona(Saca m1) throws SQLException {
        String sql = "insert into sacas(id_p, id_ca, qtd, data) values(?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, m1.getId_p());
            stmt.setInt(2, m1.getId_ca());
            stmt.setInt(3, m1.getQtd());
            stmt.setString(4, m1.getData());

            stmt.execute();
        }
    }

    //método para pegar uma lista de produtos no banco
    public List<Saca> getLista(String dado, String data, int tipo, String produto) throws SQLException {

        String sql = (tipo == 0) ? "select produto.nome_p, caminhao.nome_ca, sacas.* "
                + "from sacas, produto, caminhao WHERE sacas.data between '?' "
                + "and '?' and produto.nome_p LIKE '%?%' and produto.id_p = "
                + "sacas.id_p and sacas.id_ca=caminhao.id_ca;"
                : "select produto.nome_p, caminhao.nome_ca, sacas.* from "
                + "produto, caminhao, sacas WHERE sacas.data between '?' and"
                + "'?' and produto.id_p=sacas.id_p and caminhao.id_ca = sacas.id_ca;";

        ResultSet rs;
        List<Saca> ma;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, dado);
            stmt.setString(2, data);
            if (tipo == 0) {
                stmt.setString(3, produto);
            }

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Saca m = new Saca();

                m.setId_sa(rs.getInt("id_sa"));
                m.setId_p(rs.getInt("id_p"));
                m.setId_ca(rs.getInt("id_ca"));
                m.setQtd(rs.getInt("qtd"));
                m.setData(rs.getString("data"));

                ma.add(m);
            }
        }
        rs.close();

        return ma;
    }

    public int GetQtdSacas(String d1, String d2, String produto) throws SQLException {
        String sql = "select sum(qtd) from sacas, produto WHERE sacas.data between '?' and '?' and produto.nome_p LIKE '%?%' and produto.id_p = sacas.id_p;";
        int qtd;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, d1);
            stmt.setString(2, d2);
            stmt.setString(3, produto);

            ResultSet rs = stmt.executeQuery();
            qtd = 0;
            while (rs.next()) {
                qtd = rs.getInt("sum(qtd)");
            }
        }

        return qtd;
    }
}
