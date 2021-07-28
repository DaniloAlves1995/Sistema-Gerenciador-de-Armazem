/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.CriaConexao;
import Entidades.Caminhao;
import Entidades.Produto;
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
public class CaminhaoDao {
    private Connection conexao;
    //Método Principal da Classe que serve para toda vez que tiver uma instância da classe abrir uma nova conexão 
    public CaminhaoDao()throws SQLException{
        this.conexao=(Connection) CriaConexao.getConexao();
    }
    
    //método para adicionar o pruduto
    public void adiciona(Caminhao m1) throws SQLException{
        String sql="insert into caminhao(nome_ca, carga, data) "
          +"values(?, ?, ?)";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        
        stmt.setString(1, m1.getNome().toUpperCase());
        stmt.setInt(2, m1.getCarga());
        stmt.setString(3, m1.getData());
        
        stmt.execute();
        stmt.close();
    }
    
    //método para adicionar o pruduto
    public void adicionaCamCarga(Caminhao m1) throws SQLException{
        String sql="insert into caminhao_carga(id_ca, carga) "
          +"values(?, ?)";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        
        stmt.setInt(1, m1.getId());
        stmt.setInt(2, m1.getCarga());
        
        stmt.execute();
        stmt.close();
    }
    
    //método para pegar uma lista de produtos no banco
    public List<Caminhao> getLista(String dado, int tipo) throws SQLException{
        String sql="";
        if(tipo==0){
            sql="select caminhao.id_ca, caminhao.nome_ca, caminhao.data, caminhao_carga.carga from caminhao, caminhao_carga WHERE caminhao.nome_ca LIKE '%" + dado + "%' and caminhao.id_ca = caminhao_carga.id_ca;";
        }else{
            sql="select caminhao.id_ca, caminhao.nome_ca, caminhao.data, caminhao_carga.carga from caminhao, caminhao_carga WHERE "
                    + "caminhao_carga.carga > 0 and caminhao.id_ca = caminhao_carga.id_ca;";
        }
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        
        ResultSet rs = stmt.executeQuery();
        List<Caminhao> ma = new ArrayList<Caminhao>();
        
        while(rs.next()){
            Caminhao m = new Caminhao();
            
            m.setId(rs.getInt("id_ca"));
            m.setNome(rs.getString("nome_ca"));
            m.setCarga(rs.getInt("carga"));
            m.setData(rs.getString("data"));
            
            ma.add(m);
            
        }
        stmt.close();
        rs.close();
        
      
        return ma;
       
        
    }
    
    public Caminhao GetCaminhao(int id_ca) throws SQLException{
        String sql= "select * from caminhao where id_ca="+id_ca;
        PreparedStatement stmt= this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        Caminhao m = new Caminhao();
        
        while(rs.next()){
            m.setId(rs.getInt("id_ca"));
            m.setNome(rs.getString("nome_ca"));
            m.setCarga(rs.getInt("carga"));
            m.setData(rs.getString("data"));
        }
        stmt.close();
        
        return m;
    }
    
//método para alterar o produto no banco
    public void altera(Caminhao m) throws SQLException{
        String sql="update caminhao set nome_ca=?, carga=?"
                + " where id_ca=?";
        PreparedStatement stmt=this.conexao.prepareStatement(sql);
        
        stmt.setString(1, m.getNome().toUpperCase());
        stmt.setInt(2, m.getCarga());

        stmt.setInt(3, m.getId());
   //     System.out.println(m.getId());
        stmt.execute();
        stmt.close();
    }
    
    public void alteraCamCarga(Caminhao m) throws SQLException{
        String sql="update caminhao_carga set carga=?"
                + " where id_ca=?";
        PreparedStatement stmt=this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, m.getCarga());

        stmt.setInt(2, m.getId());
   //     System.out.println(m.getId());
        stmt.execute();
        stmt.close();
    }
    
    //método para excluir um produto do banco
    public void Excluir(Caminhao m) throws SQLException{ 
            String sql= "delete from caminhao where id_ca=?";
            PreparedStatement stmt= this.conexao.prepareStatement(sql);
            stmt.setInt(1, m.getId());
            stmt.execute();
            stmt.close();
    }
    
    public void ExcluirCamCarga(Caminhao m) throws SQLException{ 
            String sql= "delete from caminhao_carga where id_ca=?";
            PreparedStatement stmt= this.conexao.prepareStatement(sql);
            stmt.setInt(1, m.getId());
            stmt.execute();
            stmt.close();
    }
    
    //metodo para retornar a qtd de sócios no banco
    public int GetQtdCaminhoes() throws SQLException{
        String sql= "SELECT COUNT(*) FROM caminhao;";
        PreparedStatement stmt= this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        int qtd = 0;
        while(rs.next()){
            qtd = rs.getInt("COUNT(*)");
        }
        
        stmt.close();
        
        return qtd;
    }
    
    //pegar o id do ultimo caminhão adicionado
     public int getIdUltimoCam() throws SQLException{
        String sql="SELECT * FROM caminhao ORDER BY id_ca DESC LIMIT 1";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        int id=0;
        ResultSet rs = stmt.executeQuery();
      
        while(rs.next()){
            id=rs.getInt("id_ca");
        }
        return id;
    }
     
     //método para pegar uma lista de produtos no banco
    public List<Caminhao> getListaEntDatas(String dado, String data) throws SQLException{
        String sql="select * from caminhao WHERE data between '" + dado +"' and '"+data+"'";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        
        ResultSet rs = stmt.executeQuery();
        List<Caminhao> ma = new ArrayList<Caminhao>();
        
        while(rs.next()){
            Caminhao m = new Caminhao();
            
            m.setId(rs.getInt("id_ca"));
            m.setNome(rs.getString("nome_ca"));
            m.setCarga(rs.getInt("carga"));
            m.setData(rs.getString("data"));
            
            ma.add(m);
            
        }
        stmt.close();
        rs.close();
        
      
        return ma;
    }
}
