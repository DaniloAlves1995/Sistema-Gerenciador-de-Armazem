package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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

public class CriaConexao {

    public  static Connection getConexao() throws SQLException{
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
            } catch (InstantiationException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar Driver JDBC! \n\r ERRO:"+ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalAccessException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! \n\r ERRO:"+ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
            }
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/armazem", "root", "");
            
            return con;
        } catch (ClassNotFoundException e) {
           JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! \n\r ERRO:"+e.getMessage(), "..: SGE :..", JOptionPane.ERROR_MESSAGE);
           throw new SQLException(e.getMessage());
        }
    }
}
