/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.CriaConexao;
import Entidades.Produto;
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
    private Connection conexao;
    
    //Método Principal da Classe que serve para toda vez que tiver uma instância da classe abrir uma nova conexão 
    public SacaDao()throws SQLException{
        this.conexao=(Connection) CriaConexao.getConexao();
    }
    
    //método para adicionar o pruduto
    public void adiciona(Saca m1) throws SQLException{
        String sql="insert into sacas(id_p, id_ca, qtd, data) "
          +"values(?, ?, ?, ?)";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        
        stmt.setInt(1, m1.getId_p());
        stmt.setInt(2, m1.getId_ca());
        stmt.setInt(3, m1.getQtd());
         stmt.setString(4, m1.getData());
        
        stmt.execute();
        stmt.close();
        
    }
    
    //método para pegar uma lista de produtos no banco
    public List<Saca> getLista(String dado, String data, int tipo, String produto) throws SQLException{
        String sql = "";
        if(tipo==0){
            //seja produto especifico
            sql="select produto.nome_p, caminhao.nome_ca, sacas.* from sacas, produto, caminhao WHERE sacas.data between '" + dado +"' and '"+data+"' and produto.nome_p LIKE '%"+produto+"%' and produto.id_p = sacas.id_p and sacas.id_ca=caminhao.id_ca;";
        }else{
            sql="select produto.nome_p, caminhao.nome_ca, sacas.* from produto, caminhao, sacas WHERE sacas.data between '"+dado+"' and '"+data+"' and produto.id_p=sacas.id_p and caminhao.id_ca = sacas.id_ca;";
        }
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        List<Saca> ma = new ArrayList<Saca>();
        
        while(rs.next()){
            Saca m = new Saca();
            
            m.setId_sa(rs.getInt("id_sa"));
            m.setId_p(rs.getInt("id_p"));
            m.setId_ca(rs.getInt("id_ca"));
            m.setQtd(rs.getInt("qtd"));
            m.setData(rs.getString("data"));
            
            ma.add(m);
            
        }
        stmt.close();
        rs.close();
        
      
        return ma;
    }
    
    public int GetQtdSacas(String d1, String d2, String produto) throws SQLException{
        String sql= "select sum(qtd) from sacas, produto WHERE sacas.data between '" + d1 +"' and '"+d2+"' and produto.nome_p LIKE '%"+produto+"%' and produto.id_p = sacas.id_p;";
        PreparedStatement stmt= this.conexao.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        int qtd = 0;
        
        while(rs.next()){
            qtd = rs.getInt("sum(qtd)");
        }
        stmt.close();
        
        return qtd;
    }
    
    
}
