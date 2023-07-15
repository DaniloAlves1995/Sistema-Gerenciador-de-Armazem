/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DAO.StockDao;
import DAO.ProductDao;
import Entities.Stock;
import Entities.Product;
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
public class EditStock extends javax.swing.JFrame {

    private DefaultTableModel tmProduct = new DefaultTableModel(null, new String[]{"Id", "Name", "Preço (R$)", "Total stock"});
    private ListSelectionModel lsmProduct;
    private List<Product> product;
    private char l;
    private int save = 0;

    public EditStock() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Edit Stock - WMS");
        ImageIcon iconWindow = new ImageIcon(getClass().getResource("/Imagens/icon-controle-de-estoqu.png"));
        this.setIconImage(iconWindow.getImage());
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
        jTSearch = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTProduct = new javax.swing.JTextField();
        jTPreco = new javax.swing.JTextField();
        jTId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProducts = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 131, 73));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTSearch.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTSearchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTSearchKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Search product:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTSearch)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 131, 73));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Price (R$):");

        jTProduct.setEditable(false);
        jTProduct.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTProductKeyPressed(evt);
            }
        });

        jTPreco.setEditable(false);
        jTPreco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTPrecoActionPerformed(evt);
            }
        });
        jTPreco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTPrecoKeyPressed(evt);
            }
        });

        jTId.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTId.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Id:");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/stock.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Amount in stock:");

        jTTotal.setEditable(false);
        jTTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTotalActionPerformed(evt);
            }
        });
        jTTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTTotalKeyPressed(evt);
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
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTProduct))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Edit Stock");

        jPanel5.setBackground(new java.awt.Color(0, 131, 73));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/disk.png"))); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/table_edit.png"))); // NOI18N
        jButton4.setText("Edit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton2, jButton4});

        jPanel6.setBackground(new java.awt.Color(0, 131, 73));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTProducts.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTProducts.setModel(tmProduct);
        jTProducts.setSelectionBackground(new java.awt.Color(0, 131, 73));
        jTProducts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmProduct = jTProducts.getSelectionModel();
        lsmProduct.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) { if (! e.getValueIsAdjusting()){ jTSelectedRowTable(jTProducts); } }
        });
        jScrollPane1.setViewportView(jTProducts);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTSearchKeyPressed

    private void jTSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSearchKeyReleased
        l = evt.getKeyChar();
        if (evt.getKeyCode() == 40) {
            jTProduct.requestFocus();
        }
        try {
            listProduct();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco! \n\r ERRO:" + ex, "WMS", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTSearchKeyReleased

    private void jTSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTSearchKeyTyped

    }//GEN-LAST:event_jTSearchKeyTyped

    private void jTProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProductKeyPressed
        if (jTProduct.getBackground() != Color.WHITE) {
            jTProduct.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jTProductKeyPressed

    private void jTPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPrecoActionPerformed

    private void jTPrecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPrecoKeyPressed
        if (jTPreco.getBackground() != Color.WHITE) {
            jTPreco.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jTPrecoKeyPressed

    private void jTTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTotalActionPerformed

    private void jTTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTotalKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (save == 1) {
            if (check()) {
                try {
                    StockDao edao = new StockDao();
                    Stock e = edao.getStock(product.get(jTProducts.getSelectedRow()).getId());
                    e.setAmount(Integer.parseInt(jTTotal.getText()));

                    edao.update(e);
                    JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso!", "..: WMS :..", JOptionPane.INFORMATION_MESSAGE);
                    listProduct();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro!" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "A quantidade em stock preciza ser um número inteiro!", "..: WMS :..", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTProducts.getSelectedRow() != -1) {
            Enable();
            save = 1;
        } else {
            JOptionPane.showMessageDialog(null, "Você Precisa selecionar um Cliente na tabela para poder Edit!", "..: WMS :..", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    public void Enable() {
        jTTotal.setEditable(true);
    }

    public void Disable() {
        jTTotal.setEditable(false);
    }

    public boolean check() {
        boolean s = true;
        if (jTTotal.getText().trim().equals("")) {
            s = false;
        } else {
            try {
                int a = Integer.parseInt(jTTotal.getText());
            } catch (Exception e) {
                s = false;
            }
        }

        return s;
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
            java.util.logging.Logger.getLogger(EditStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditStock().setVisible(true);
            }
        });
    }

    protected void listProduct() throws SQLException {
        ProductDao me = new ProductDao();
        product = me.getList("%" + jTSearch.getText() + "%");

        showSearch(product);
    }

    private void showSearch(List<Product> product) {

        while (tmProduct.getRowCount() > 0) {
            tmProduct.removeRow(0);
        }

        if ((product.isEmpty()) && (l == ' ')) {
            JOptionPane.showMessageDialog(null, "Nenhum Product com o Name " + jTSearch.getText().toUpperCase() + " cadastrado.", "..: WMS :..", JOptionPane.INFORMATION_MESSAGE);
        }

        String[] linha = new String[]{null, null, null, null};
        for (int i = 0; i < product.size(); i++) {
            tmProduct.addRow(linha);
            tmProduct.setValueAt(product.get(i).getId(), i, 0);
            tmProduct.setValueAt(product.get(i).getProduct(), i, 1);
            tmProduct.setValueAt(product.get(i).getPrice(), i, 2);
            tmProduct.setValueAt(getTotalStock(product.get(i).getId()) + "", i, 3);
        }
    }

    private void jTSelectedRowTable(JTable tabela) {
        try {
            if (jTProducts.getSelectedRow() != -1) {
                jTProduct.setText(product.get(tabela.getSelectedRow()).getProduct());
                jTPreco.setText(product.get(tabela.getSelectedRow()).getPrice() + "");
                jTId.setText(product.get(tabela.getSelectedRow()).getId() + "");
                //busca a qtd desse product em stock
                jTTotal.setText(getTotalStock(product.get(tabela.getSelectedRow()).getId()) + "");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter valores da tabela! \n\r ERRO:" + e, "WMS", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int getTotalStock(int id_prod) {
        Stock stock = null;
        try {
            StockDao edao = new StockDao();
            stock = edao.getStock(id_prod);
            if (stock == null) {
                Stock e = new Stock();
                e.setId_p(id_prod);
                e.setAmount(0);
                edao.add(e);
                stock = edao.getStock(id_prod);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro!" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
        }

        return stock.getAmount();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTPreco;
    public javax.swing.JTextField jTProduct;
    private javax.swing.JTable jTProducts;
    private javax.swing.JTextField jTSearch;
    private javax.swing.JTextField jTTotal;
    // End of variables declaration//GEN-END:variables
}
