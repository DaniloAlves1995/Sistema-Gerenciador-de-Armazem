/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Conexao.ConexaoRel;
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
 *@Desenvolvedor Danilo Alves
 * 
 */
public class Relatorio {
    private String sql;
    private String nome;
    private String local;
    private String tipo;
    private String titulo;
    private ConexaoRel con;
    
    public Relatorio(){
        //diretorio para salvar
        File dir = new File("c:/SGA");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File l = new File("c:/SGA/Relatorios");
        if (!l.exists()) {
            l.mkdir();
        }
        
        //cria conexão
        this.con = new ConexaoRel();
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void gerarRelatorio(){
        File li = new File("c:/SGA/Relatorios/"+this.tipo);
        if (!li.exists()) {
            li.mkdir();
        }

        String MostrarRelatorio;
        String path = "c:/SGA/Relatorios/"+this.tipo+"/";
        try {
            con.conecta();
            con.executeSQL(this.sql);

            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
            //referencia o jasper
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Jasper/"+this.tipo+".jasper"), new HashMap(), jrRS);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.setTitle(this.titulo+" - .: SGA :.");
            jv.setIconImage(new ImageIcon(getClass().getResource("/Imagens/icon-controle-de-estoqu.png")).getImage());
            jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            File arq = new File(path + this.nome + ".pdf");
            boolean salvarPdf = false;
            if (arq.exists()) {
                int result = JOptionPane.showConfirmDialog(null, "O relatório " + this.nome + ".pdf já existe.\n Dezeja substitui-lo?", "SGA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_NO_OPTION)
                    salvarPdf = true; 
            } else
                salvarPdf = true;
            
            if (salvarPdf){
                JasperExportManager.exportReportToPdfFile(jp, path + this.nome + ".pdf");
                MostrarRelatorio = path + this.nome + ".pdf";
                JOptionPane.showMessageDialog(null, "Operação Realizada com sucesso!\n Salvo em: " + path + this.nome + ".pdf", "SGA", JOptionPane.INFORMATION_MESSAGE);
                try {
                    Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + MostrarRelatorio);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao acessar arquivo! \n\r ERRO:" + Arrays.toString(e.getStackTrace()), "SGA", JOptionPane.ERROR_MESSAGE);
                }
            }  
        } catch (HeadlessException | JRException erro) {
            JOptionPane.showMessageDialog(null, "Erro!" + erro, "SGA", JOptionPane.INFORMATION_MESSAGE);
        }
    
    }
    
    public String getData(){
        Date data = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        return df.format(data);
    }
}
