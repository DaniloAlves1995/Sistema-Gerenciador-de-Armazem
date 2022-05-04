package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 ***********************************************************
 * ------------- ..::Danilo Alves Oliveira::.. ------------- *
 * **********************************************************
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
      
           
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/armazem", "root", "danilo123");
            
            return con;
        
    }
}
