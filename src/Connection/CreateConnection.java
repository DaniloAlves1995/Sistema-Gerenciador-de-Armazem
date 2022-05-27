package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 ***********************************************************
 * ------------- ..::Danilo Alves Oliveira::.. ------------- *
 * **********************************************************
 * 
 *@Developer Danilo Alves
 * 
 */

public class CreateConnection {

    public  static Connection getConnection() throws SQLException{
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/armazem", "root", "danilo123");
            
        return con;
    }
}
