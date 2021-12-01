package DAO;

import com.mysql.jdbc.Connection;

import Conexao.CriaConexao;
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
 *@Desenvolvedor Danilo Alves
 * 
 */

//<editor-fold defaultstate="collapsed" desc="Departamento de Sistemas Desktop">
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tecnology Java SE">
//</editor-fold>
public class ProdutoDao {

    //Variavel que recebe a conexão da classe CriaConexao
    private Connection conexao;

    //Método Principal da Classe que serve para toda vez que tiver uma instância da classe abrir uma nova conexão 
    public ProdutoDao() throws SQLException {
        this.conexao = (Connection) CriaConexao.getConexao();
    }

    //método para adicionar o pruduto
    public void adiciona(Produto m1) throws SQLException {
        String sql = "insert into produto(nome_p, preco_p, obs) values(?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, m1.getProduto().toUpperCase());
            stmt.setDouble(2, m1.getPreco());
            stmt.setString(3, m1.getObs().toUpperCase());

            stmt.execute();
        }
    }

    //método para pegar uma lista de produtos no banco
    public List<Produto> getLista(String dado) throws SQLException {
        String sql = "select * from produto WHERE nome_p LIKE ?";
        ResultSet rs;
        List<Produto> ma;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, "%"+dado+"%");

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

    //método para pegar uma lista de produtos no banco
    public List<Produto> getListaTodos() throws SQLException {
        String sql = "select * from produto";
        ResultSet rs;
        List<Produto> ma;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
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

    //método para alterar o produto no banco
    public void altera(Produto m) throws SQLException {
        String sql = "update produto set nome_p=?, preco_p=?, obs=? where id_p=?";
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, m.getProduto().toUpperCase());
            stmt.setDouble(2, m.getPreco());
            stmt.setString(3, m.getObs().toUpperCase());
            stmt.setInt(4, m.getId());

            stmt.execute();
        }
    }

    //método para excluir um produto do banco
    public void Excluir(Produto m) throws SQLException {
        String sql = "delete from produto where id_p=?";

        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setInt(1, m.getId());
            stmt.execute();
        }
    }

    //metodo para retornar a qtd de sócios no banco
    public int GetQtdProdutos() throws SQLException {
        String sql = "SELECT COUNT(*) FROM produto;";
        int qtd = 0;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                qtd = rs.getInt("COUNT(*)");
            }

        }

        return qtd;
    }

    //retorna o produto com o id pesquisado
    public Produto GetProduto(int id) throws SQLException {
        String sql = "select * from produto where id_p=?";
        Produto m;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
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

    //metodo para retornar o produto pesquisado pelo nome
    public Produto GetProduto(String nome) throws SQLException {
        String sql = "select * from produto where nome_p='?';";
        Produto m;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);

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
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            EstoqueDao edao = new EstoqueDao();

            for (int i = 0; i < lista.size(); i++) {
                stmt.setInt(1, lista.get(i).getId());
                stmt.setString(2, lista.get(i).getProduto().toUpperCase());
                stmt.setInt(3, edao.GetEstoque(lista.get(i).getId()).getQtd());

                stmt.execute();
            }
        }
    }

    //metodo que retorna o id do último produto adicionado
    public int getIdUltimoProduto() throws SQLException {
        String sql = "SELECT * FROM produto ORDER BY id_p DESC LIMIT 1";
        int id;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            id = 0;
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id_p");
            }
        }
        return id;
    }

    //metodo que retorna o id do último produto adicionado
    public void LimparPDF_RelatorioE() throws SQLException {
        String sql = "TRUNCATE pdf_relatorioe";
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.execute();
        }
    }
}
