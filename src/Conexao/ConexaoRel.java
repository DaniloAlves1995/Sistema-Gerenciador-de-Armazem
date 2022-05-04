package Conexao;

import java.sql.*;
import javax.swing.*;

/**
 *
 ***********************************************************
 * ------------- ..::Danilo Alves Oliveira::.. ------------- *
 * **********************************************************
 *
 * @Desenvolvedor Danilo Alves
 *
 */
//<editor-fold defaultstate="collapsed" desc="Departamento de Sistemas Desktop">
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tecnology Java SE">
//</editor-fold>
public class ConexaoRel {

    final private String url = "jdbc:mysql://localhost/armazem";
    final private String usuario = "root";
    final private String senha = "danilo123";
    public Connection conexao;
    public Statement statement;
    public ResultSet resultset;

    public boolean conecta() {
        boolean result = true;

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexão do relatório com o banco! \n\r ERRO:" + ex.getMessage(), "..: SGA :..", JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    public void desconecta() {
        try {
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão do relatório com o banco! \n\r ERRO:" + ex.getMessage(), "..: SGA :..", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void executeSQL(String sql) {
        try {
            statement = conexao.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultset = statement.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar SQL na conexão do relatório com o banco! \n\r ERRO:" + ex.getMessage(), "..: SGA :..", JOptionPane.ERROR_MESSAGE);
        }
    }

}
