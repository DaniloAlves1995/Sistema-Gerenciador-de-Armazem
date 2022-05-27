/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Conexao.ConectionReport;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 *************************************************************
 * ------------- ..::Danilo Alves Oliveira::.. ------------- *
 * ***********************************************************
 * 
 *@Developer Danilo Alves
 * 
 */

public class Report {
    private String sql;
    private String name;
    private String local;
    private String type;
    private String title;
    private ConectionReport con;
    
    public Report(){
        //diretorio para salvar
        File dir = new File("c:/WMS");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File l = new File("c:/WMS/Reports");
        if (!l.exists()) {
            l.mkdir();
        }
        
        //cria conexão
        this.con = new ConectionReport();
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setTipo(String type) {
        this.type = type;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void generateReport(){
        File li = new File("c:/WMS/Reports/"+this.type);
        if (!li.exists()) {
            li.mkdir();
        }

        String showReport;
        String path = "c:/WMS/Reports/"+this.type+"/";
        try {
            con.connect();
            con.executeSQL(this.sql);

            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
            //reference the jasper
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Jasper/"+this.type+".jasper"), new HashMap(), jrRS);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.setTitle(this.title+" - .: WMS :.");
            jv.setIconImage(new ImageIcon(getClass().getResource("/Imagens/icon-controle-de-estoqu.png")).getImage());
            jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            File arq = new File(path + this.name + ".pdf");
            boolean savePDF = false;
            if (arq.exists()) {
                int result = JOptionPane.showConfirmDialog(null, "The Report " + this.name + ".pdf already exists.\n Do you want to replace?", "WMS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_NO_OPTION)
                    savePDF = true; 
            } else
                savePDF = true;
            
            if (savePDF){
                JasperExportManager.exportReportToPdfFile(jp, path + this.name + ".pdf");
                showReport = path + this.name + ".pdf";
                JOptionPane.showMessageDialog(null, "Operation complete with success!\n Save at: " + path + this.name + ".pdf", "WMS", JOptionPane.INFORMATION_MESSAGE);
                try {
                    Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + showReport);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error to access the file! \n\r ERRO:" + Arrays.toString(e.getStackTrace()), "WMS", JOptionPane.ERROR_MESSAGE);
                }
            }  
        } catch (HeadlessException | JRException erro) {
            JOptionPane.showMessageDialog(null, "Error!" + erro, "WMS", JOptionPane.INFORMATION_MESSAGE);
        }
    
    }
    
    public String getDate(){
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        return df.format(date);
    }
}
