/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DAO.CaminhaoDao;
import Entidades.Caminhao;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

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
public class Gerenciar_Caminhao extends javax.swing.JFrame {

    
    private DefaultTableModel tmCaminhao = new DefaultTableModel(null, new String[]{"Id", "Nome", "Sacas Restantes."});
    private ListSelectionModel lsmCaminhao;
    private List<Caminhao> caminhoes;
    private int salvar = 0;
    private char l;

    public Gerenciar_Caminhao() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Gerenciar Caminhão - SGE");
        ImageIcon imagemTituloJanela = new ImageIcon(getClass().getResource("/Imagens/icon-controle-de-estoqu.png"));
        this.setIconImage(imagemTituloJanela.getImage());

        this.MostrarQtdCaminhoes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTPesquisar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jTId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTSacRest = new javax.swing.JTextField();
        jTPreCarga = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTCaminhoes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 131, 73));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesquisar Caminhão:");

        jTPesquisar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTPesquisarKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPesquisarKeyTyped(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Total:");

        jTTotal.setEditable(false);
        jTTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Gerenciar Caminhões");

        jPanel3.setBackground(new java.awt.Color(0, 131, 73));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Sac. restantes:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Previ. de sacas:");

        jTNome.setEditable(false);
        jTNome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNomeKeyPressed(evt);
            }
        });

        jTId.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTId.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Id:");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/caminao.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nome:");

        jTSacRest.setEditable(false);
        jTSacRest.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTSacRest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTSacRestActionPerformed(evt);
            }
        });
        jTSacRest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTSacRestKeyPressed(evt);
            }
        });

        jTPreCarga.setEditable(false);
        jTPreCarga.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTPreCarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPreCargaActionPerformed(evt);
            }
        });
        jTPreCarga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTPreCargaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTSacRest, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTPreCarga, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTNome))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jTSacRest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTPreCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 131, 73));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/disk.png"))); // NOI18N
        jButton1.setText("Salvar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/table_edit.png"))); // NOI18N
        jButton3.setText("Editar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/delete.png"))); // NOI18N
        jButton4.setText("Excluir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addGap(204, 204, 204))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton3});

        jPanel5.setBackground(new java.awt.Color(0, 131, 73));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTCaminhoes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTCaminhoes.setModel(tmCaminhao);
        jTCaminhoes.setSelectionBackground(new java.awt.Color(0, 131, 73));
        jTCaminhoes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmCaminhao = jTCaminhoes.getSelectionModel();
        lsmCaminhao.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) { if (! e.getValueIsAdjusting()){ jTTabelaLinhaSelecionada(jTCaminhoes); } }
        });
        jScrollPane1.setViewportView(jTCaminhoes);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(258, 258, 258))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyPressed

    }//GEN-LAST:event_jTPesquisarKeyPressed

    private void jTPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyTyped
        l = evt.getKeyChar();

        try {
            listarCaminhoes();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! \n\r ERRO:" + ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTPesquisarKeyTyped

    private void jTTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTotalActionPerformed

    private void jTNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNomeKeyPressed
        if (jTNome.getBackground() != Color.WHITE) {
            jTNome.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jTNomeKeyPressed

    private void jTPreCargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPreCargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPreCargaActionPerformed

    private void jTPreCargaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPreCargaKeyPressed
        if (jTPreCarga.getBackground() != Color.WHITE) {
            jTPreCarga.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jTPreCargaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (Verificar()) {
            if (Everificar()) {
                try {
                    alteraCaminhao();
                    jTPesquisar.setText("");
                    listarCaminhoes();
                    Limpar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! \n\r ERRO:" + ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
                }

            }
        }

        MostrarQtdCaminhoes();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTCaminhoes.getSelectedRow() != -1) {
            Habilitar();
            salvar = 1;
        } else {
            JOptionPane.showMessageDialog(null, "Você Precisa selecionar um Caminhão na tabela para poder Editar!", "..: SGE :..", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTCaminhoes.getSelectedRow() != -1) {
            Excluir();
        } else {
            JOptionPane.showMessageDialog(null, "Você Precisa selecionar um Caminhão na Tabela para poder Excluir!", "..: SGE :..", JOptionPane.WARNING_MESSAGE);
        }
        MostrarQtdCaminhoes();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTSacRestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTSacRestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSacRestActionPerformed

    private void jTSacRestKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSacRestKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSacRestKeyPressed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gerenciar_Caminhao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gerenciar_Caminhao().setVisible(true);
            }
        });
    }

    protected void listarCaminhoes() throws SQLException {
        CaminhaoDao me = new CaminhaoDao();
        caminhoes = me.getLista("%" + jTPesquisar.getText() + "%", 0);

        mostraPesquisa(caminhoes);
    }

    private void mostraPesquisa(List<Caminhao> caminhoes) {

        while (tmCaminhao.getRowCount() > 0) {
            tmCaminhao.removeRow(0);
        }

        if ((caminhoes.isEmpty()) && (l == ' ')) {
            JOptionPane.showMessageDialog(null, "Nenhum Caminhão com o Nome " + jTPesquisar.getText().toUpperCase() + " cadastrado.", "..: SGE :..", JOptionPane.INFORMATION_MESSAGE);
        }

        String[] linha = new String[]{null, null, null};
        for (int i = 0; i < caminhoes.size(); i++) {
            tmCaminhao.addRow(linha);
            tmCaminhao.setValueAt(caminhoes.get(i).getId(), i, 0);
            tmCaminhao.setValueAt(caminhoes.get(i).getNome(), i, 1);
            tmCaminhao.setValueAt(caminhoes.get(i).getCarga(), i, 2);

        }
    }

    public void Limpar() {
        jTNome.setText("");
        jTPreCarga.setText("");
        jTId.setText("");
        jTSacRest.setText("");
    }

    //Método para Desabilitar os TextFilds
    public void Desabilitar() {
        jTNome.setEditable(false);
        jTPreCarga.setEditable(false);
        jTSacRest.setEditable(false);
    }

    //Método para Habilitar os TextFilds
    public void Habilitar() {
        jTNome.setEditable(true);
        jTPreCarga.setEditable(true);
        jTSacRest.setEditable(true);
    }

    public boolean Verificar() {
        boolean valor = true;
        if (jTNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo Nome não pode ser vazio!", "..: SGE :..", JOptionPane.WARNING_MESSAGE);
            jTNome.setBackground(new Color(255, 51, 51));
            jTNome.requestFocus();
            valor = false;
        } else {
            if (jTPreCarga.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo Previsão de Sacas não pode ser vazio!", "..: SGE :..", JOptionPane.WARNING_MESSAGE);
                jTPreCarga.setBackground(new Color(255, 51, 51));
                jTPreCarga.requestFocus();
                valor = false;
            } else {
                try {
                    int a = Integer.parseInt(jTPreCarga.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "O campo Previsão de Sacas deve ser um número inteiro!", "..: SGE :..", JOptionPane.WARNING_MESSAGE);
                    valor = false;
                }
                try {
                    int a = Integer.parseInt(jTSacRest.getText());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "O campo Sacas restantes deve ser um número inteiro!", "..: SGE :..", JOptionPane.WARNING_MESSAGE);
                    valor = false;
                }
            }
        }
        return valor;
    }

    //Esse metodo serve para Alterar os valores do produto no banco
    private void alteraCaminhao() throws SQLException {

        if (Verificar()) {
            Caminhao m = new Caminhao();
            CaminhaoDao dao = new CaminhaoDao();
            m.setId(caminhoes.get(jTCaminhoes.getSelectedRow()).getId());
            m.setNome(jTNome.getText());
            m.setCarga(Integer.parseInt(jTPreCarga.getText()));

            dao.alterar(m);
            m.setCarga(Integer.parseInt(jTSacRest.getText()));
            dao.alteraCamCarga(m);
            JOptionPane.showMessageDialog(null, "Caminhão Alterado com SUCESSO!", "..: SGE :..", JOptionPane.INFORMATION_MESSAGE);
            salvar = 0;
            Desabilitar();
        }
    }

    public boolean Everificar() {
        try {
            CaminhaoDao cdao = new CaminhaoDao();
            String carga_prev = String.valueOf(cdao.GetCaminhao(caminhoes.get(jTCaminhoes.getSelectedRow()).getId()).getCarga());
            if ((caminhoes.get(jTCaminhoes.getSelectedRow()).getNome().equals(jTNome.getText())) && (String.valueOf(caminhoes.get(jTCaminhoes.getSelectedRow()).getCarga()).equals(jTPreCarga.getText())) && jTSacRest.getText().equals(carga_prev)) {
                JOptionPane.showMessageDialog(null, "Nenhum dado foi modificado!", "..: SGE :..", JOptionPane.INFORMATION_MESSAGE);
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO: " + ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    //Metodo para excluir o produto
    public void Excluir() {
        int a = JOptionPane.showConfirmDialog(null, "Você deseja realmente excluir o Caminhão " + jTNome.getText().toUpperCase(), "..: SGE :..", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == 0) {
            try {
                CaminhaoDao m = new CaminhaoDao();
                m.Excluir(caminhoes.get(jTCaminhoes.getSelectedRow()));
                m.ExcluirCamCarga(caminhoes.get(jTCaminhoes.getSelectedRow()));
                JOptionPane.showMessageDialog(null, "Caminhão excluido(a) com sucesso!", "..: SGE :..", JOptionPane.INFORMATION_MESSAGE);
                jTPesquisar.setText("");
                listarCaminhoes();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! \n\r ERRO:" + ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //metodo para mostrar a qtd de sócios
    public final void MostrarQtdCaminhoes() {
        try {
            //pega a qtd de sócios cadastrados no banco
            CaminhaoDao dao = new CaminhaoDao();
            jTTotal.setText(String.valueOf(dao.GetQtdCaminhoes()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao contar a quantidade de caminhões!", "..: SGE :..", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jTTabelaLinhaSelecionada(JTable tabela) {
        try {
            if (jTCaminhoes.getSelectedRow() != -1) {
                jTNome.setText(caminhoes.get(tabela.getSelectedRow()).getNome());
                jTSacRest.setText(caminhoes.get(tabela.getSelectedRow()).getCarga() + "");
                jTId.setText(caminhoes.get(tabela.getSelectedRow()).getId() + "");
                CaminhaoDao cdao = new CaminhaoDao();
                jTPreCarga.setText("" + cdao.GetCaminhao(caminhoes.get(tabela.getSelectedRow()).getId()).getCarga());

                Desabilitar();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter valores da tabela! \n\r ERRO:" + e, "SGE", JOptionPane.ERROR_MESSAGE);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTCaminhoes;
    private javax.swing.JTextField jTId;
    public javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTPesquisar;
    private javax.swing.JTextField jTPreCarga;
    private javax.swing.JTextField jTSacRest;
    private javax.swing.JTextField jTTotal;
    // End of variables declaration//GEN-END:variables
}
