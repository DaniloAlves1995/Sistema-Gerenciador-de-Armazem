
package DAO;


import com.mysql.jdbc.Connection;

import Conexao.CriaConexao;
import Entidades.Vendedor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 ***********************************************************
 * ------------- ..::NorthTech Automação::.. ------------- *
 *********************************************************** 
 * 
 *@Desenvolvedor Danilo Alves
 * 
 */
           //<editor-fold defaultstate="collapsed" desc="Departamento de Sistemas Desktop">
           //</editor-fold>
                  //<editor-fold defaultstate="collapsed" desc="Tecnology Java SE">
                  //</editor-fold>
public class VendedorDao {
    //Variavel que recebe a conexão da classe CriaConexao
    private Connection conexao;
    
    //Método Principal da Classe que serve para toda vez que tiver uma instância da classe abrir uma nova conexão 
    public VendedorDao()throws SQLException{
        this.conexao=(Connection) CriaConexao.getConexao();
    }
    
    //método para adicionar o Vendedor
    public void adiciona(Vendedor m1) throws SQLException{
        String sql="insert into funcionario(nome_fun, endereco, contato1, contato2) "
          +"values(?, ?, ?, ?)";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        
        stmt.setString(1, m1.getNome().toUpperCase());
        stmt.setString(2, m1.getEndereco().toUpperCase());
        stmt.setString(3, m1.getContato1());
        stmt.setString(4, m1.getContato2());
        
        
        stmt.execute();
        stmt.close();
        
    }
    
    //método para pegar uma lista de Vendedores no banco
    public List<Vendedor> getLista(String dado) throws SQLException{
        String sql="select * from funcionario WHERE nome_fun LIKE '%" + dado + "%';";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        
        ResultSet rs = stmt.executeQuery();
        List<Vendedor> ma = new ArrayList<Vendedor>();
        
        while(rs.next()){
            Vendedor m = new Vendedor();
            
            m.setId_vendedor(rs.getInt("id_fun"));
            m.setNome(rs.getString("nome_fun"));
            m.setEndereco(rs.getString("endereco"));
            m.setContato1(rs.getString("contato1"));
            m.setContato2(rs.getString("contato2"));
          
            ma.add(m);
            
        }
        stmt.close();
        rs.close();
        
      
        return ma;
       
        
    }
   
    //método para alterar o Vendedor no banco
    public void altera(Vendedor m) throws SQLException{
        String sql="update funcionario set nome_fun=?, endereco=?, contato1=?, contato2=?"
                + " where id_fun=?";
        PreparedStatement stmt=this.conexao.prepareStatement(sql);
        
        stmt.setString(1, m.getNome().toUpperCase());
        stmt.setString(2, m.getEndereco().toUpperCase());
        stmt.setString(3, m.getContato1());
        stmt.setString(4, m.getContato2());
     
       

        stmt.setInt(5, m.getId_vendedor());
   //     System.out.println(m.getId());
        stmt.execute();
        stmt.close();
    }
    
    //método para excluir um Vendedor do banco
    public void Excluir(Vendedor m) throws SQLException{ 
            String sql= "delete from funcionario where id_fun=?";
            PreparedStatement stmt= this.conexao.prepareStatement(sql);
            stmt.setInt(1, m.getId_vendedor());
            stmt.execute();
            stmt.close();
    }
    

    
    public Vendedor GetVendedor(int id) throws SQLException{
        String sql="select * from funcionario WHERE id_fun="+id;
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        
        ResultSet rs = stmt.executeQuery();
        Vendedor m = new Vendedor();
        while(rs.next()){
            m.setId_vendedor(rs.getInt("id_fun"));
            m.setNome(rs.getString("nome_fun"));
            m.setEndereco(rs.getString("endereco"));
            m.setContato1(rs.getString("contato1"));
            m.setContato2(rs.getString("contato2"));
            
            
        }
        stmt.close();
        rs.close();
        
      
        return m;
    }
    //metodo para retornar a qtd de sócios no banco
    public int GetQtdVendedores() throws SQLException{
        String sql= "SELECT COUNT(*) FROM funcionario;";
        PreparedStatement stmt= this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int qtd = 0;
        while(rs.next()){
            qtd = rs.getInt("COUNT(*)");
        }
        
        stmt.close();
        
        return qtd;
    }
}

    