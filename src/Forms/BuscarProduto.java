/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DAO.ProdutoDao;
import Entidades.Produto;
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
public class BuscarProduto extends javax.swing.JFrame {

    DefaultTableModel tmProduto = new DefaultTableModel(null, new String[]{"Id", "Nome", "Preço"});
    ListSelectionModel lsmProduto;
    List<Produto> produtos;
    char l;

    /**
     * Creates new form PesquisarSocio
     */
    public BuscarProduto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Buscar Produto - SGE");
        ImageIcon imagemTituloJanela = new ImageIcon(getClass().getResource("/Imagens/icon-controle-de-estoqu.png"));
        setIconImage(imagemTituloJanela.getImage());

        //Desabilita os TextFilds
        jTNome.setEditable(false);
        jTPreco.setEditable(false);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTPesquisar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jTPreco = new javax.swing.JTextField();
        jBOk = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pesquisar Produto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Arial", 0, 24))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 131, 73));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesquisar por:");

        jTPesquisar.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTPesquisarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTPesquisarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTPesquisarKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nome:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 131, 73));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Preço(R$):");

        jTNome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNomeKeyPressed(evt);
            }
        });

        jTPreco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTPrecoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBOk.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jBOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/add.png"))); // NOI18N
        jBOk.setText("Adicionar");
        jBOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBOkActionPerformed(evt);
            }
        });

        jBCancelar.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancel.png"))); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jTProduto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTProduto.setModel(tmProduto);
        jTProduto.setSelectionBackground(new java.awt.Color(0, 131, 73));
        jTProduto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmProduto = jTProduto.getSelectionModel();
        lsmProduto.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) { if (! e.getValueIsAdjusting()){ jTTabelaLinhaSelecionada(jTProduto); } }
        });
        jTProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTProdutoKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTProduto);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBOk)
                .addGap(29, 29, 29)
                .addComponent(jBCancelar)
                .addGap(115, 115, 115))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBOk)
                    .addComponent(jBCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNomeKeyPressed
        if (jTNome.getBackground() != Color.WHITE) {
            jTNome.setBackground(Color.WHITE);
        }

    }//GEN-LAST:event_jTNomeKeyPressed

    private void jTPrecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPrecoKeyPressed
        if (jTPreco.getBackground() != Color.WHITE) {
            jTPreco.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jTPrecoKeyPressed

    private void jTPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPesquisarKeyPressed

    private void jTPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyTyped

    }//GEN-LAST:event_jTPesquisarKeyTyped

    private void jTPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyReleased
        l = evt.getKeyChar();
        if (evt.getKeyCode() == 40) {
            jTProduto.requestFocus();
        }
        try {
            listarProduto();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco! \n\r ERRO:" + ex, "SGE", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTPesquisarKeyReleased

    private void jBOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBOkActionPerformed
        if (jTProduto.getSelectedRow() != -1) {
            if (tipo == 0) {
                entradae.SetProduto(produtos.get(jTProduto.getSelectedRow()));
            }
            if (tipo == 1) {
                svenda.SetProduto(produtos.get(jTProduto.getSelectedRow()));
            }
            if (tipo == 2) {
                producao.SetProduto(produtos.get(jTProduto.getSelectedRow()));
            }
            this.dispose();
        }
    }//GEN-LAST:event_jBOkActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProdutoKeyPressed
        if (evt.getKeyCode() == 10) {
            if (jTProduto.getSelectedRow() != -1) {
                if (tipo == 0) {
                    entradae.SetProduto(produtos.get(jTProduto.getSelectedRow()));
                }
                if (tipo == 1) {
                    svenda.SetProduto(produtos.get(jTProduto.getSelectedRow()));
                }
                if (tipo == 2) {
                    producao.SetProduto(produtos.get(jTProduto.getSelectedRow()));
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_jTProdutoKeyPressed

    private Entrada_Estoque entradae;
    private SaidaVenda svenda;
    private ProducaoSacas producao;
    private int tipo;// 0 = EntradaEstoque; 1 = SaidaVenda; 2 = ProducaoSacas

    public void SetEntradaEstoque(Entrada_Estoque entradae) {
        this.entradae = entradae;
    }

    public void SetSaidaVenda(SaidaVenda svenda) {
        this.svenda = svenda;
    }

    public void SetProducaoSacas(ProducaoSacas producao) {
        this.producao = producao;
    }

    public void SetTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @param args the command line arguments
     *
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
            java.util.logging.Logger.getLogger(BuscarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTPesquisar;
    private javax.swing.JTextField jTPreco;
    private javax.swing.JTable jTProduto;
    // End of variables declaration//GEN-END:variables

    //Realiza a pesquisa do valor digitado no banco
    protected void listarProduto() throws SQLException {
        ProdutoDao me = new ProdutoDao();
        produtos = me.getLista("%" + jTPesquisar.getText() + "%");
        mostraPesquisa(produtos);
    }

    //Mostra a pesquisa na tabela
    private void mostraPesquisa(List<Produto> produto) {

        while (tmProduto.getRowCount() > 0) {
            tmProduto.removeRow(0);
        }
        int a = 1;

        if (((produtos.isEmpty())) && (l == ' ')) {
            JOptionPane.showMessageDialog(null, "Nenhum Produto com o Nome " + jTPesquisar.getText().toUpperCase() + " cadastrado.", "..: SGE :..", JOptionPane.INFORMATION_MESSAGE);
        } else {

            if (produtos.isEmpty() == false) {
                String[] linha = new String[]{null, null, null};
                for (int i = 0; i < produtos.size(); i++) {
                    tmProduto.addRow(linha);
                    tmProduto.setValueAt(produtos.get(i).getId(), i, 0);
                    tmProduto.setValueAt(produtos.get(i).getProduto(), i, 1);
                    tmProduto.setValueAt(produtos.get(i).getPreco(), i, 2);
                }
            }

        }
    }

    //Metodo para pagar o valor da linha selecionada
    private void jTTabelaLinhaSelecionada(JTable tabela) {
        try {
            if (jTProduto.getSelectedRow() != -1) {
                jTNome.setText(produtos.get(tabela.getSelectedRow()).getProduto());
                jTPreco.setText(produtos.get(tabela.getSelectedRow()).getPreco() + "");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter valores da tabela! \n\r ERRO:" + e, "SGE", JOptionPane.ERROR_MESSAGE);
        }
    }
}
