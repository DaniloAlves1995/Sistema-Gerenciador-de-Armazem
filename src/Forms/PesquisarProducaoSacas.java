/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Conexao.ConectionReport;
import DAO.CaminhaoDao;
import DAO.EstoqueDao;
import DAO.ProdutoDao;
import DAO.SacaDao;
import Entidades.Saca;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 ***********************************************************
 * ------------- ..::Danilo Alves Oliveira::.. ------------- *
 * **********************************************************
 *
 *
 */
//<editor-fold defaultstate="collapsed" desc="Departamento de Sistemas Desktop">
//</editor-fold>
//<editor-fold defaultstate="collapsed" desc="Tecnologia Java SE">
//</editor-fold>
public class PesquisarProducaoSacas extends javax.swing.JFrame {

    private DefaultTableModel tmSacas = new DefaultTableModel(null, new String[]{"Produto", "Qtd", "Caminhão", "Data"});
    private List<Saca> sacas;
    private String d1, d2;

    public PesquisarProducaoSacas() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Pesquisar produção de sacas - SGE");
        ImageIcon imagemTituloJanela = new ImageIcon(getClass().getResource("/Imagens/icon-controle-de-estoqu.png"));
        this.setIconImage(imagemTituloJanela.getImage());
        this.sacas = new ArrayList<>();
        jRadioButton2.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTNota = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jBGerarN1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTProduto = new javax.swing.JTextField();
        jRadioButton2 = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Pesquisar produção de Sacas");

        jPanel4.setBackground(new java.awt.Color(0, 131, 73));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jTNota.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTNota.setModel(tmSacas);
        jTNota.setGridColor(new java.awt.Color(255, 255, 255));
        jTNota.setSelectionBackground(new java.awt.Color(0, 131, 73));
        jTNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTNota);

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Produção de sacas:");

        jBGerarN1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jBGerarN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/acroread.png"))); // NOI18N
        jBGerarN1.setText("Relatório");
        jBGerarN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGerarN1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBGerarN1)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jBGerarN1)
                .addGap(15, 15, 15))
        );

        jPanel2.setBackground(new java.awt.Color(0, 131, 73));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Data inicial:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Data final:");

        jDateChooser1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jDateChooser1.setPreferredSize(new java.awt.Dimension(87, 28));
        jDateChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDateChooser1MouseClicked(evt);
            }
        });
        jDateChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser1PropertyChange(evt);
            }
        });
        jDateChooser1.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                jDateChooser1VetoableChange(evt);
            }
        });

        jDateChooser2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jDateChooser2.setPreferredSize(new java.awt.Dimension(87, 28));
        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Produto:");

        jRadioButton1.setBackground(new java.awt.Color(0, 131, 73));
        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setText("Por produto");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jTProduto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTProduto.setEnabled(false);
        jTProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTProdutoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProdutoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTProdutoKeyTyped(evt);
            }
        });

        jRadioButton2.setBackground(new java.awt.Color(0, 131, 73));
        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(255, 255, 255));
        jRadioButton2.setText("Todos");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTProduto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jLabel13)
                        .addComponent(jTProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRadioButton2))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(217, 217, 217))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNotaMouseClicked

    }//GEN-LAST:event_jTNotaMouseClicked

    private void jBGerarN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGerarN1ActionPerformed
        if (this.sacas.size() > 0) {
            if (jRadioButton1.isSelected()) {
                try {
                    EstoqueDao edao = new EstoqueDao();
                    SacaDao sdao = new SacaDao();
                    int qtd = sdao.GetQtdSacas(d1, d2, jTProduto.getText());
                    edao.adicionaTotal(qtd);
                    relatorio();
                    edao.LimparTotal();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "ERRO: " + ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                relatorio();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Não houve nenhuma produção no período informado!", "..: SGE :..", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jBGerarN1ActionPerformed

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked

    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        pesquisar();
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jDateChooser1VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jDateChooser1VetoableChange

    }//GEN-LAST:event_jDateChooser1VetoableChange

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        pesquisar();
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        jTProduto.setEnabled(true);
        pesquisar();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jTProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProdutoKeyPressed

    }//GEN-LAST:event_jTProdutoKeyPressed

    private void jTProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProdutoKeyReleased
        pesquisar();
    }//GEN-LAST:event_jTProdutoKeyReleased

    private void jTProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProdutoKeyTyped

    }//GEN-LAST:event_jTProdutoKeyTyped

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        jTProduto.setEnabled(false);
        pesquisar();
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    public void pesquisar() {
        if (jDateChooser1.getDate() != null && jDateChooser2.getDate() != null) {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            d1 = sd.format(jDateChooser1.getDate());
            d2 = sd.format(jDateChooser2.getDate());

            if (jRadioButton2.isSelected()) {
                try {
                    SacaDao sdao = new SacaDao();
                    sacas = sdao.getLista(d1, d2, 1, "");
                    mostrarSaidas(sacas);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro!" + ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                try {
                    SacaDao sdao = new SacaDao();
                    sacas = sdao.getLista(d1, d2, 0, jTProduto.getText());
                    mostrarSaidas(sacas);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro!" + ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    //Mostra a pesquisa na tabela de notas
    private void mostrarSaidas(List<Saca> sacas) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
        Date d;
        while (tmSacas.getRowCount() > 0) {
            tmSacas.removeRow(0);
        }
        if (!sacas.isEmpty()) {
            Object[] linha = new Object[]{null, null, null, null};
            for (int i = 0; i < sacas.size(); i++) {
                try {
                    tmSacas.addRow(linha);
                    ProdutoDao pdao = new ProdutoDao();
                    CaminhaoDao cdao = new CaminhaoDao();
                    tmSacas.setValueAt(pdao.GetProduto(sacas.get(i).getId_p()).getProduto(), i, 0);
                    tmSacas.setValueAt(sacas.get(i).getQtd(), i, 1);
                    tmSacas.setValueAt(cdao.GetCaminhao(sacas.get(i).getId_ca()).getNome(), i, 2);
                    d = df.parse(sacas.get(i).getData());
                    tmSacas.setValueAt(df2.format(d), i, 3);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro!" + ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Erro!" + ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PesquisarProducaoSacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisarProducaoSacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisarProducaoSacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisarProducaoSacas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PesquisarProducaoSacas().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBGerarN1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTNota;
    private javax.swing.JTextField jTProduto;
    // End of variables declaration//GEN-END:variables

    //Cria o relatorio da lista de vendas
    private void relatorio() {
        Date data = new Date();

        int ano = data.getYear() + 1900;
        int dia = data.getDate();
        int mes = data.getMonth() + 1;
        String dias = null, mess = null;
        if (dia < 10) {
            dias = "0" + dia;
        } else {
            dias = "" + dia;
        }
        if (mes < 10) {
            mess = "0" + mes;
        } else {
            mess = "" + mes;
        }
        String nome = "Relatório_Produção_Sacas_DATA_" + dias + "-" + mess + "-" + ano;
        String arquivo = nome;

        ConectionReport con = new ConectionReport();

        //diretorio que vai salvar
        File dir = new File("c:/SGE");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File l = new File("c:/SGE/Relatorios");
        if (!l.exists()) {
            l.mkdir();
        }
        File li = new File("c:/SGE/Relatorios/Entrada");
        if (!li.exists()) {
            li.mkdir();
        }

        String MostrarRelatorio;
        String path = "c:/SGE/Relatorios/Entrada/";
        try {
            con.connect();
            String sql = "";
            String jasper = "";
            if (jRadioButton2.isSelected()) {
                sql = "select produto.nome_p, caminhao.nome_ca, sacas.* from produto, caminhao, sacas WHERE sacas.data between '" + d1 + "' and '" + d2 + "' and produto.id_p=sacas.id_p and caminhao.id_ca = sacas.id_ca;";
                jasper = "/Jasper/RelatorioProducaoSacas.jasper";
            } else {
                sql = "select pdf_total.*, produto.nome_p, caminhao.nome_ca, sacas.* from sacas, produto, caminhao, pdf_total WHERE sacas.data between '" + d1 + "' and '" + d2 + "' and produto.nome_p LIKE '%" + jTProduto.getText() + "%' and produto.id_p = sacas.id_p and sacas.id_ca=caminhao.id_ca;";
                jasper = "/Jasper/RelatorioProducaoSacas_i.jasper";
            }
            con.executeSQL(sql);

            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
            //referencia o jasper
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream(jasper), new HashMap(), jrRS);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.setTitle("Pesquisar Produção de Sacas - .: SGE :.");
            jv.setIconImage(new ImageIcon(getClass().getResource("/Imagens/icon-controle-de-estoqu.png")).getImage());
            jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // JasperViewer.viewReport(jp,true);
            File arq = new File(path + arquivo + ".pdf");
            if (arq.exists()) {
                int result = JOptionPane.showConfirmDialog(null, "O relatório " + arquivo + ".pdf já existe.\n Dezeja substitui-lo?", "SGE", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_NO_OPTION) {
                    JasperExportManager.exportReportToPdfFile(jp, path + arquivo + ".pdf");
                    MostrarRelatorio = path + arquivo + ".pdf";
                    JOptionPane.showMessageDialog(null, "Operação Realizada com sucesso!\n Salvo em: " + path + arquivo + ".pdf", "SGE", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + MostrarRelatorio);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao acessar arquivo! \n\r ERRO:" + e.getStackTrace(), "SGE", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JasperExportManager.exportReportToPdfFile(jp, path + arquivo + ".pdf");
                MostrarRelatorio = path + arquivo + ".pdf";
                JOptionPane.showMessageDialog(null, "Operação Realizada consucesso!\n Salvo em: " + path + arquivo + ".pdf", "SGE", JOptionPane.INFORMATION_MESSAGE);
                try {
                    Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + MostrarRelatorio);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Erro ao acessar arquivo! \n\r ERRO:" + e.getMessage(), "SGE", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (HeadlessException | JRException erro) {
            JOptionPane.showMessageDialog(null, "Erro!" + erro, "SGE", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
