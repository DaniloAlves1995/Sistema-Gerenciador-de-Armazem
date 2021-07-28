
package DAO;


import com.mysql.jdbc.Connection;

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
public class SaidaDao {
    //Variavel que recebe a conexão da classe CriaConexao
    private Connection conexao;
    
    //Método Principal da Classe que serve para toda vez que tiver uma instância da classe abrir uma nova conexão 
    public SaidaDao()throws SQLException{
        this.conexao=(Connection) CriaConexao.getConexao();
    }
    
    //método para adicionar a nota
    public void adiciona(Saida m1) throws SQLException{
        String sql="insert into saida(id_c, id_fun, total, data) "
          +"values(?, ?, ?, ?)";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        
        stmt.setInt(1, m1.getId_c());
        stmt.setInt(2, m1.getId_fun());
        stmt.setDouble(3, m1.getTotal()); 
        stmt.setString(4, m1.getData()); 
        
        
        stmt.execute();
        stmt.close();
        
    }
    
    //método para pegar uma lista de notas no banco
    public List<Saida> getLista(String dado, String data, int tipo) throws SQLException{
        String sql="";
        switch(tipo){
            case 0:
                sql="select * from saida";
                break;
            case 1:
                sql="select * from saida WHERE id_s=" + dado;
                break;
            case 2:
                sql="select * from saida WHERE id_c=" + dado+" and data like '"+data+"'";
                break;
            case 3:
                sql="select * from saida WHERE data like '"+data+"'";
                break;
            case 6:
                sql="select * from saida WHERE id_c=" + dado;
                break;
            case 7:
                sql="select * from saida WHERE id_c=" + dado;
                break;
            case 8:
                sql="select * from saida WHERE data between '" + dado +"' and '"+data+"'";
                break;
        }
     
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        
        ResultSet rs = stmt.executeQuery();
        List<Saida> ma = new ArrayList<Saida>();
        
        while(rs.next()){
            Saida m = new Saida();
            
            m.setId_s(rs.getInt("id_s"));
            m.setId_c(rs.getInt("id_c"));
            m.setId_fun(rs.getInt("id_fun"));
            m.setTotal(rs.getDouble("total"));
            m.setData(rs.getString("data"));
            
            ma.add(m);
            
        }
        stmt.close();
        rs.close();
        
      
        return ma;
       
        
    }
    
     //método para pegar uma lista de notas no banco
    public List<Saida> getNotasNPagas(int idcliente) throws SQLException{
        String sql="select * from saida WHERE id_c=" + idcliente+" and pg=0";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        
        ResultSet rs = stmt.executeQuery();
        List<Saida> ma = new ArrayList<Saida>();
        
        while(rs.next()){
            Saida m = new Saida();
            
            m.setId_s(rs.getInt("id_s"));
            m.setId_c(rs.getInt("id_c"));
            m.setId_fun(rs.getInt("id_fun"));
            m.setTotal(rs.getDouble("total"));
            m.setData(rs.getString("data"));
            
            ma.add(m);
            
        }
        stmt.close();
        rs.close();
        
      
        return ma;
    }
    
    //método para excluir uma nota do banco
    public void Excluir(Saida m) throws SQLException{ 
            String sql= "delete from saida where id_s=?";
            PreparedStatement stmt= this.conexao.prepareStatement(sql);
            stmt.setInt(1, m.getId_s());
            stmt.execute();
            stmt.close();
    }
    
    //metodo que retorna o id da ultima nota adicionada
    public int getIdUltimaNota() throws SQLException{
        String sql="SELECT * FROM saida ORDER BY id_s DESC LIMIT 1";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        int id=0;
        ResultSet rs = stmt.executeQuery();
      
        while(rs.next()){
            id=rs.getInt("id_s");
        }
        return id;
    }
    
    public void EditarNota(Saida n) throws SQLException{
        String sql="update saida set total=?"
                + " where id_s=?";
        PreparedStatement stmt=this.conexao.prepareStatement(sql);
        
        stmt.setDouble(1, n.getTotal());
       

        stmt.setInt(2, n.getId_s());
   //     System.out.println(m.getId());
        stmt.execute();
        stmt.close();
    }
    
    //método para adicionar os campos para o resumo
    public void adicionaPDFResumo(Estoque e) throws SQLException{
        String sql="insert into pdf_resumon(qtd_total, id_p) "
          +"values(?, ?)";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        
        stmt.setInt(1, e.getQtd());
        stmt.setDouble(2, e.getId_p());
     
        
        
        stmt.execute();
        stmt.close();
        
    }
    
    //metodo que retorna o id do último produto adicionado
    public void LimparPDFResumo() throws SQLException{
        String sql="TRUNCATE pdf_resumon";
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        stmt.execute();
        stmt.close();
    }
  
}


    