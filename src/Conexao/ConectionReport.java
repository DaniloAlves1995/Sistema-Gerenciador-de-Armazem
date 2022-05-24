package Conexao;

import java.sql.*;
import javax.swing.*;

/**
 *
 ***********************************************************
 * ------------- ..::Danilo Alves Oliveira::.. ------------- *
 * **********************************************************
 *
 * @Developer Danilo Alves
 *
 */

public class ConectionReport {

    final private String url = "jdbc:mysql://localhost/armazem";
    final private String user = "root";
    final private String password = "danilo123";
    public Connection connection;
    public Statement statement;
    public ResultSet resultset;

    public boolean connect() {
        boolean result = true;

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error connecting report to the database! \n\r ERROR:" + ex.getMessage(), "..: WMS :..", JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error closing report connection to the database! \n\r ERROR:" + ex.getMessage(), "..: WMS :..", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void executeSQL(String sql) {
        try {
            statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error executing SQL on report connection to database! \n\r ERRO:" + ex.getMessage(), "..: WMS :..", JOptionPane.ERROR_MESSAGE);
        }
    }

}
