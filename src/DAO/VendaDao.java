
package DAO;


import com.mysql.jdbc.Connection;

import Conexao.CriaConexao;
import Entidades.Cliente;
import Entidades.Produto;
import Entidades.Saida;
import Entidades.Venda;
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
public class VendaDao {
    //Variavel que recebe a conexão da classe CriaConexao
    private Connection conexao;
    
    //Método Principal da Classe que serve para toda vez que tiver uma instância da classe abrir uma nova conexão 
    public VendaDao()throws SQLException{
        this.conexao=(Connection) CriaConexao.getConexao();
    }
    
    //método para adicionar o pruduto
    public void adiciona(Venda m1) throws SQLException{
        String sql="insert into venda(id_s, id_p, preco, qtd, valor_p) "
          +"values(?, ?, ?, ?, ?)";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        
        stmt.setInt(1, m1.getId_s());
        stmt.setInt(2, m1.getId_p());
        stmt.setDouble(3, m1.getPreco());
        stmt.setInt(4, m1.getQtd());
        stmt.setDouble(5, m1.getValor_p());
        
        
        stmt.execute();
        stmt.close();
        
    }
    
    //método para pegar uma lista de vendas no banco
    public List<Venda> getLista(int id_s) throws SQLException{
        String sql="select * from venda WHERE id_s="+id_s;
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        
        ResultSet rs = stmt.executeQuery();
        List<Venda> ma = new ArrayList<Venda>();
        
        while(rs.next()){
            Venda m = new Venda();
            
            m.setId_v(rs.getInt("id_v"));
            m.setId_p(rs.getInt("id_p"));
            m.setId_s(rs.getInt("id_s"));
            m.setPreco(rs.getDouble("preco"));
            m.setQtd(rs.getInt("qtd"));
            m.setValor_p(rs.getDouble("valor_p"));
            
            ma.add(m);
            
        }
        stmt.close();
        rs.close();
        
      
        return ma;
       
        
    }
    
//método para alterar a venda no banco
    public void altera(Venda m) throws SQLException{
        String sql="update venda set id_p=?, preco=?, qtd=?, valor_p=?"
                + " where id_v=?";
        PreparedStatement stmt=this.conexao.prepareStatement(sql);
        
        stmt.setInt(1, m.getId_p());
        stmt.setDouble(2, m.getPreco());
        stmt.setInt(3, m.getQtd());
        stmt.setDouble(4, m.getValor_p());

        stmt.setInt(5, m.getId_v());
   //     System.out.println(m.getId());
        stmt.execute();
        stmt.close();
    }
    
    //método para excluir uma venda do banco
    public void Excluir(Venda m) throws SQLException{ 
            String sql= "delete from venda where id_v=?";
            PreparedStatement stmt= this.conexao.prepareStatement(sql);
            stmt.setInt(1, m.getId_v());
            stmt.execute();
            stmt.close();
    }
    
    //método para excluir as vendas relacionadas ao id da nota
    public void ExcluirVendas(int idsaida) throws SQLException{ 
            String sql= "delete from venda where id_s=?";
            PreparedStatement stmt= this.conexao.prepareStatement(sql);
            stmt.setInt(1, idsaida);
            stmt.execute();
            stmt.close();
    }
    
    //método para adicionar os valores de data ao relatório
    public void adicionaPDF(String d1, String d2) throws SQLException{
        String sql="insert into pdf_venda(dataI, dataF) "
          +"values(?, ?)";
        PreparedStatement stmt= conexao.prepareStatement(sql);
        
        stmt.setString(1, d1);
        stmt.setString(2, d2);
        
        
        stmt.execute();
        stmt.close();
        
    }
    
    //método para limpar a tabela pdf
    public void LimparPDF() throws SQLException{ 
            String sql= "TRUNCATE TABLE `pdf_venda`";
            PreparedStatement stmt= this.conexao.prepareStatement(sql);
            
            stmt.execute();
            stmt.close();
    }
    
    //método para pegar a soma da qtd de produtos de uma saida
    public int getQTD(int id_s) throws SQLException{
        String sql="select SUM(qtd) from venda WHERE id_s="+id_s;
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        
        ResultSet rs = stmt.executeQuery();
        int qtd = 0;
        while(rs.next()){
            qtd = rs.getInt("SUM(qtd)");
        }
        stmt.close();
        rs.close();
        
      return qtd;
   }
    
    //método para pegar a soma da qtd de produtos de um determinado produto e uma saida
    public int getQTDProdSaida(List<Saida> listas, int id_p) throws SQLException{
        
        String sql="select SUM(qtd) from venda WHERE id_p="+id_p+" and (";
        for(int i = 0; i<listas.size(); i++){
            if(i==0)
                sql=sql+"id_s="+listas.get(i).getId_s();
            else
                sql=sql+" or id_s="+listas.get(i).getId_s();
        }
        sql=sql+");";
        
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        
        ResultSet rs = stmt.executeQuery();
        int qtd = 0;
        while(rs.next()){
            qtd = rs.getInt("SUM(qtd)");
        }
        stmt.close();
        rs.close();
        
      return qtd;
   }
    
    //método para pegar a soma da qtd de produtos de um determinado produto e uma saida
    public List<Venda> getIdsProdSaida(List<Saida> listas) throws SQLException{
        String sql="select distinct id_p from venda WHERE ";
        for(int i = 0; i<listas.size(); i++){
            if(i==0)
                sql=sql+"id_s="+listas.get(i).getId_s();
            else
                sql=sql+" or id_s="+listas.get(i).getId_s();
        }
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
        
        
        ResultSet rs = stmt.executeQuery();
        List<Venda> lista = new ArrayList<>();
        while(rs.next()){
            Venda v = new Venda();
            v.setId_p(rs.getInt("id_p"));
            
            lista.add(v);
        }
        stmt.close();
        rs.close();
        
      return lista;
   }
   
}

    