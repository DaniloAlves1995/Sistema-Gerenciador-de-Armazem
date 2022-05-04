package DAO;

import java.sql.Connection;

import Conexao.CriaConexao;
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
 *@Desenvolvedor Danilo Alves
 * 
 */

//<editor-fold defaultstate="collapsed" desc="Departamento de Sistemas Desktop">
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tecnology Java SE">
//</editor-fold>
public class EstoqueDao {

    //Variavel que recebe a conexão da classe CriaConexao
    private Connection conexao;

    //Método Principal da Classe que serve para toda vez que tiver uma instância da classe abrir uma nova conexão 
    public EstoqueDao() throws SQLException {
        this.conexao = (Connection) CriaConexao.getConexao();
    }

    //método para adicionar o pruduto
    public void adiciona(Estoque m1) throws SQLException {
        String sql = "insert into estoque(id_p, qtd) values(?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, m1.getId_p());
            stmt.setInt(2, m1.getQtd());

            stmt.execute();
        }
    }

    //método para adicionar o pruduto
    public void adicionaTotal(int qtd) throws SQLException {
        String sql = "insert into pdf_total(total) values(?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, qtd);

            stmt.execute();
        }
    }

    //método para adicionar o pruduto
    public void LimparTotal() throws SQLException {
        String sql = "TRUNCATE pdf_total";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    public void adicionaEstEntrada(Estoque m1) throws SQLException {
        String sql = "insert into estoque_entrada(id_p, qtd, data) values(?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, m1.getId_p());
            stmt.setInt(2, m1.getQtd());
            stmt.setString(3, m1.getData());

            stmt.execute();
        }
    }

    //método para pegar uma lista de produtos no banco
    public List<Estoque> getLista(String dado) throws SQLException {
        String sql = "select * from estoque WHERE id_p=?";
        ResultSet rs;
        List<Estoque> ma;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, dado);

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

    public List<Estoque> getListaEstEntrada(String dado, String data, int tipo, String produto) throws SQLException {
        String sql = "";
        if (tipo == 0) {
            //seja produto especifico
            sql = "select * from estoque_entrada, produto WHERE estoque_entrada.data between '?' and '?' and produto.nome_p LIKE '%?%' and produto.id_p = estoque_entrada.id_p;";
        } else {
            sql = "select * from estoque_entrada WHERE data between '?' and '?'";
        }

        ResultSet rs;
        List<Estoque> ma;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, dado);
            stmt.setString(2, data);
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

    //método para alterar o produto no banco
    public void altera(Estoque m) throws SQLException {
        String sql = "update estoque set qtd=? where id_e=?";
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setInt(1, m.getQtd());
            stmt.setInt(2, m.getId_e());

            stmt.execute();
        }
    }

    //método para excluir um produto do banco
    public void Excluir(Estoque m) throws SQLException {
        String sql = "delete from produto where id_e=?";
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setInt(1, m.getId_e());
            stmt.execute();
        }
    }

    //metodo para retornar a qtd de sócios no banco
    public int GetQtdProdutos() throws SQLException {
        String sql = "SELECT COUNT(*) FROM estoque;";
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

    //retorna o produto com o id pesquisado
    public Estoque GetEstoque(int id_produto) throws SQLException {
        String sql = "select * from estoque where id_p=?";
        Estoque m;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
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

    //metodo para retornar o produto pesquisado pelo nome
    public Produto GetProduto(String nome) throws SQLException {
        String sql = "select * from produto where nome=?;";
        Produto m;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, nome);

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

    public int GetQtdEstEnt(String d1, String d2, String produto) throws SQLException {
        String sql = "select sum(qtd) from estoque_entrada, produto WHERE estoque_entrada.data between '?' and '?' and produto.nome_p LIKE '%?%' and produto.id_p = estoque_entrada.id_p;";
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
