package Conexao;
//import Principal.*;
import java.sql.*;
import javax.swing.*;

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

public class ConexaoRel
{
        final private String driver = "com.mysql.jdbc.Driver";
        final private String url = "jdbc:mysql://localhost/armazem";
        final private String usuario = "root";
        final private String senha = "";
        public Connection conexao;
        public Statement statement;
        public ResultSet resultset;
        
       public boolean conecta()
       {
            boolean result = true;
            try 
            {
                Class.forName(driver);
                conexao = DriverManager.getConnection(url, usuario, senha);

               // javax.swing.JOptionPane.showMessageDialog(null,"<html><font color='blue' sise='20'> Nenhuma Falha Foi Encontrada! <font><html>");
            }
            catch(ClassNotFoundException Driver) 
            {
                 //     javax.swing.JOptionPane.showMessageDialog(null,"<html><font color='red' sise='20'> Falhas foram encontradas! Entre em Contato com os Desenvolvedores <font><html>");
       //        JOptionPane.showMessageDialog(null,"Driver não localizado: "+Driver);
         //      result = false;
            }
            catch(SQLException Fonte) 
            {     
                 //javax.swing.JOptionPane.showMessageDialog(null,"<html><font color='red' sise='20'> Falhas foram encontradas! Entre em Contato com os Desenvolvedores <font><html>");
 //               JOptionPane.showMessageDialog(null, "Falhas foram encontradas! Entre em Contato com os Desenvolvedores");
   //                JOptionPane.showMessageDialog(null,"Deu erro na conexão "+
     //                   "com a fonte de dados: "+Fonte);
                result = false;
            }
            return result; 
       }
       
       public void desconecta()
       {
            boolean result = true;
            try 
            {
                conexao.close();
               // JOptionPane.showMessageDialog(null,"Banco fechado");
            }
            catch(SQLException fecha) 
            {
                //JOptionPane.showMessageDialog(null,"A conexão com o Banco não está sendo efetuada! "+
                  //      "Fechar o banco de dados: "+fecha);
                result = false;
            }

       }
       
       public void executeSQL(String sql)
       {
            try 
            {
                statement = conexao.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
                resultset = statement.executeQuery(sql);
            }
            catch(SQLException sqlex) 
            {
               //JOptionPane.showMessageDialog(null,"Não foi possível "+
                 //      "executar o comando sql,"+sqlex+", o sql passado foi "+sql);
            }

       }
       
}
