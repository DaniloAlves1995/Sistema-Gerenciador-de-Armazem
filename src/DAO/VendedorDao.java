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
 *@Desenvolvedor Danilo Alves
 * 
 */

//<editor-fold defaultstate="collapsed" desc="Departamento de Sistemas Desktop">
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tecnology Java SE">
//</editor-fold>
public class VendedorDao {

    //Variavel que recebe a conexão da classe CreateConnection
    private final Connection conexao;

    //abrir uma nova conexão a cada instância da classe
    public VendedorDao() throws SQLException {
        this.conexao = (Connection) CreateConnection.getConnection();
    }

    //método para adicionar o Vendedor
    public void adiciona(Vendedor m1) throws SQLException {
        String sql = "insert into funcionario(nome_fun, endereco, contato1, contato2) "
                + "values(?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, m1.getNome().toUpperCase());
            stmt.setString(2, m1.getEndereco().toUpperCase());
            stmt.setString(3, m1.getContato1());
            stmt.setString(4, m1.getContato2());

            stmt.execute();
        }
    }

    //método para pegar uma lista de Vendedores no banco
    public List<Vendedor> getLista(String dado) throws SQLException {
        String sql = "select * from funcionario WHERE nome_fun LIKE ?";
        ResultSet rs;
        List<Vendedor> ma;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {

            stmt.setString(1, "%"+dado+"%");

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

    //método para alterar o Vendedor no banco
    public void altera(Vendedor m) throws SQLException {
        String sql = "update funcionario set nome_fun=?, endereco=?, contato1=?, contato2=?"
                + " where id_fun=?";
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, m.getNome().toUpperCase());
            stmt.setString(2, m.getEndereco().toUpperCase());
            stmt.setString(3, m.getContato1());
            stmt.setString(4, m.getContato2());
            stmt.setInt(5, m.getId_vendedor());

            stmt.execute();
        }
    }

    //método para excluir um Vendedor do banco
    public void Excluir(Vendedor m) throws SQLException {
        String sql = "delete from funcionario where id_fun=?";
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setInt(1, m.getId_vendedor());
            stmt.execute();
        }
    }

    public Vendedor GetVendedor(int id) throws SQLException {
        String sql = "select * from funcionario WHERE id_fun=?";
        ResultSet rs;
        Vendedor m;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {

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

    //metodo para retornar a qtd de sócios no banco
    public int GetQtdVendedores() throws SQLException {
        String sql = "SELECT COUNT(*) FROM funcionario;";
        int qtd;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            qtd = 0;
            while (rs.next()) {
                qtd = rs.getInt("COUNT(*)");
            }
        }

        return qtd;
    }
}
