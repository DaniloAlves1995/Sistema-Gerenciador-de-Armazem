package DAO;

import com.mysql.jdbc.Connection;

import Conexao.CriaConexao;
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
 *@Desenvolvedor Danilo Alves
 * 
 */

//<editor-fold defaultstate="collapsed" desc="Departamento de Sistemas Desktop">
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tecnology Java SE">
//</editor-fold>

public class ClienteDao implements InterfaceBasicDB<Cliente>{

    //Variavel que recebe a conexão da classe CriaConexao
    private final Connection conexao;

    //Método Principal da Classe que serve para toda vez que tiver uma instância da classe abrir uma nova conexão 
    public ClienteDao() throws SQLException {
        this.conexao = (Connection) CriaConexao.getConexao();
    }

    //método para adicionar o cliente
    @Override
    public void adicionar(Cliente m1) {
        String sql = "insert into cliente(nome, endereco, cpf, contato1, contato2) "
                + "values(?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, m1.getNome().toUpperCase());
            stmt.setString(2, m1.getEndereco().toUpperCase());
            stmt.setString(3, m1.getCpf());
            stmt.setString(4, m1.getContato1());
            stmt.setString(5, m1.getContato2());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //método para pegar uma lista de socios no banco
    public List<Cliente> getLista(String dado) {
        String sql = "select * from cliente WHERE nome LIKE '%?%';";
        ResultSet rs;
        List<Cliente> ma = null;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, dado);

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
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return ma;
    }

    //metodo que retorna uma lista de clientes pelo endereço
    public List<Cliente> getListE(String endereco) throws SQLException {
        String sql = "select * from cliente WHERE endereco LIKE '%?%';";
        ResultSet rs;
        List<Cliente> ma;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, endereco);

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

    //método para alterar o cliente no banco
    @Override
    public void alterar(Cliente m)  {
        String sql = "update cliente set nome=?, endereco=?, cpf=?, contato1=?, contato2=?"
                + " where id_c=?";
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setString(1, m.getNome().toUpperCase());
            stmt.setString(2, m.getEndereco().toUpperCase());
            stmt.setString(3, m.getCpf());
            stmt.setString(4, m.getContato1());
            stmt.setString(5, m.getContato2());
            stmt.setInt(6, m.getId());

            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //método para excluir um cliente do banco
    @Override
    public void Excluir(Cliente m)  {
        String sql = "delete from cliente where id_c=?";
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            stmt.setInt(1, m.getId());
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //metodo para retornar a qtd de sócios no banco
    public int GetQtdClientes() throws SQLException {
        String sql = "SELECT COUNT(*) FROM cliente;";
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

    public Cliente GetCliente(int id) throws SQLException {
        String sql = "select * from cliente WHERE id_c=?";
        ResultSet rs;
        Cliente m;
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
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
