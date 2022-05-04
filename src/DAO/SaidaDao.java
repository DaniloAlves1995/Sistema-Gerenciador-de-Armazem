package DAO;

import java.sql.Connection;

import Conexao.CriaConexao;
import Entidades.Estoque;
import Entidades.Saida;
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
 *@Desenvolvedor Danilo Alves
 * 
 */

//<editor-fold defaultstate="collapsed" desc="Departamento de Sistemas Desktop">
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tecnology Java SE">
//</editor-fold>
public class SaidaDao {

    //Variavel que recebe a conexão da classe CriaConexao
    private Connection conexao;

    //Método Principal da Classe que serve para toda vez que tiver uma instância da classe abrir uma nova conexão 
    public SaidaDao() throws SQLException {
        this.conexao = (Connection) CriaConexao.getConexao();
    }

    //método para adicionar a nota
    public void adiciona(Saida m1) throws SQLException {
        String sql = "insert into saida(id_c, id_fun, total, data) "
                + "values(?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setInt(1, m1.getId_c());
        stmt.setInt(2, m1.getId_fun());
        stmt.setDouble(3, m1.getTotal());
        stmt.setString(4, m1.getData());

        stmt.execute();
        stmt.close();

    }

    //método para pegar uma lista de notas no banco
    public List<Saida> getLista(String dado, String data, int tipo) throws SQLException {
        String sql = "";
        switch (tipo) {
            case 0:
                sql = "select * from saida";
                break;
            case 1:
                sql = "select * from saida WHERE id_s=?";
                break;
            case 2:
                sql = "select * from saida WHERE id_c=? and data like '?'";
                break;
            case 3:
                sql = "select * from saida WHERE data like '?'";
                break;
            case 6:
                sql = "select * from saida WHERE id_c=?";
                break;
            case 7:
                sql = "select * from saida WHERE id_c=?";
                break;
            case 8:
                sql = "select * from saida WHERE data between '?' and '?'";
                break;
        }

        ResultSet rs;
        List<Saida> ma;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {

            if (tipo == 1 || tipo == 6 || tipo == 7) {
                stmt.setString(1, dado);
            }
            if (tipo == 2 || tipo == 8) {
                stmt.setString(1, dado);
                stmt.setString(2, data);
            }

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Saida m = new Saida();

                m.setId_s(rs.getInt("id_s"));
                m.setId_c(rs.getInt("id_c"));
                m.setId_fun(rs.getInt("id_fun"));
                m.setTotal(rs.getDouble("total"));
                m.setData(rs.getString("data"));

                ma.add(m);

            }
        }
        rs.close();

        return ma;
    }

    //método para pegar uma lista de notas no banco
    public List<Saida> getNotasNPagas(int idcliente) throws SQLException {
        String sql = "select * from saida WHERE id_c=? and pg=0";
        ResultSet rs;
        List<Saida> ma;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {

            stmt.setInt(1, idcliente);

            rs = stmt.executeQuery();
            ma = new ArrayList<>();
            while (rs.next()) {
                Saida m = new Saida();

                m.setId_s(rs.getInt("id_s"));
                m.setId_c(rs.getInt("id_c"));
                m.setId_fun(rs.getInt("id_fun"));
                m.setTotal(rs.getDouble("total"));
                m.setData(rs.getString("data"));

                ma.add(m);

            }
        }
        rs.close();

        return ma;
    }

    //método para excluir uma nota do banco
    public void Excluir(Saida m) throws SQLException {
        String sql = "delete from saida where id_s=?";
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setInt(1, m.getId_s());
            stmt.execute();
        }
    }

    //metodo que retorna o id da ultima nota adicionada
    public int getIdUltimaNota() throws SQLException {
        String sql = "SELECT * FROM saida ORDER BY id_s DESC LIMIT 1";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);

        int id = 0;
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            id = rs.getInt("id_s");
        }
        return id;
    }

    public void EditarNota(Saida n) throws SQLException {
        String sql = "update saida set total=? where id_s=?";
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setDouble(1, n.getTotal());
            stmt.setInt(2, n.getId_s());

            stmt.execute();
        }
    }

    //método para adicionar os campos para o resumo
    public void adicionaPDFResumo(Estoque e) throws SQLException {
        String sql = "insert into pdf_resumon(qtd_total, id_p) values(?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, e.getQtd());
            stmt.setDouble(2, e.getId_p());

            stmt.execute();
        }
    }

    //metodo que retorna o id do último produto adicionado
    public void LimparPDFResumo() throws SQLException {
        String sql = "TRUNCATE pdf_resumon";
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.execute();
        }
    }

}
