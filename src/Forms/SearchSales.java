/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Connection.ConectionReport;
import DAO.CustomerDao;
import DAO.ProductDao;
import DAO.OutStockDao;
import DAO.SaleDao;
import Entities.Customer;
import Entities.Stock;
import Entities.OutStock;
import Entities.Sale;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class SearchSales extends javax.swing.JFrame {

    private List<OutStock> exits;
    private String d1, d2;
    private DefaultTableModel tmNota = new DefaultTableModel(null, new String[]{"Select", "Nº", "Customer", "Value(R$)", "Date"}) {
        Class[] types = new Class[]{
            Boolean.class, Object.class, Object.class, Object.class, Object.class
        };

        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    };
    

    public SearchSales() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Search sales - WMS");
        ImageIcon iconWindow = new ImageIcon(getClass().getResource("/Imagens/windows_icon.png"));
        this.setIconImage(iconWindow.getImage());
        this.exits = new ArrayList<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTNota = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jBDelete = new javax.swing.JButton();
        jBGerarN = new javax.swing.JButton();
        jBGerarN1 = new javax.swing.JButton();
        jBGerarN2 = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 131, 73));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Initial date:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Final date:");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Search sales");

        jPanel4.setBackground(new java.awt.Color(0, 131, 73));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jTNota.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTNota.setModel(tmNota);
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
        jLabel6.setText("Sales:");

        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/table.png"))); // NOI18N
        jButton2.setText("Details");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jBDelete.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jBDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cart_delete.png"))); // NOI18N
        jBDelete.setText("Delete sale");
        jBDelete.setEnabled(false);
        jBDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeleteActionPerformed(evt);
            }
        });

        jBGerarN.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jBGerarN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/acroread.png"))); // NOI18N
        jBGerarN.setText("Invoice");
        jBGerarN.setEnabled(false);
        jBGerarN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGerarNActionPerformed(evt);
            }
        });

        jBGerarN1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jBGerarN1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/acroread.png"))); // NOI18N
        jBGerarN1.setText("Report");
        jBGerarN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGerarN1ActionPerformed(evt);
            }
        });

        jBGerarN2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jBGerarN2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/acroread.png"))); // NOI18N
        jBGerarN2.setText("Packing list");
        jBGerarN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGerarN2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBGerarN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBGerarN1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBGerarN2)
                        .addGap(41, 41, 41)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jBDelete)
                    .addComponent(jBGerarN)
                    .addComponent(jBGerarN1)
                    .addComponent(jBGerarN2))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(332, 332, 332)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        if (jTNota.getSelectedRow() != -1) {
            jBDelete.setEnabled(true);
            jBGerarN.setEnabled(true);
        }
    }//GEN-LAST:event_jTNotaMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTNota.getSelectedRow() != -1) {
            SaleDetails e = new SaleDetails();
            e.SetId(exits.get(jTNota.getSelectedRow()).getId_outStock());
            e.SetSearchVendas(this);
            e.Iniciar();
            e.show();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a sale on the table.", "..: WMS :..", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jBDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeleteActionPerformed
        if (jTNota.getSelectedRow() != -1) {
            try {
                int op = JOptionPane.showConfirmDialog(null, "Do you want to delete this sale?", "..: WMS :..", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if (op == 0) {
                    //Caso seja sim
                    OutStock a = exits.get(jTNota.getSelectedRow());
                    OutStockDao ndao = new OutStockDao();
                    ndao.delete(a);

                    SaleDao vdao = new SaleDao();
                    vdao.deleteByOut(a.getId_outStock());
                    JOptionPane.showMessageDialog(null, "Sale deleted with success!", "..: WMS :..", JOptionPane.QUESTION_MESSAGE);
                    Search();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error to access the database! \n\r ERROR:" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jBDeleteActionPerformed

    private void jBGerarNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGerarNActionPerformed
        if (jTNota.getSelectedRow() != -1) {
            reportNota();
        }
    }//GEN-LAST:event_jBGerarNActionPerformed

    private void jDateChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser1PropertyChange
        Search();
    }//GEN-LAST:event_jDateChooser1PropertyChange

    private void jDateChooser1VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_jDateChooser1VetoableChange

    }//GEN-LAST:event_jDateChooser1VetoableChange

    private void jDateChooser1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser1MouseClicked

    }//GEN-LAST:event_jDateChooser1MouseClicked

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        Search();
    }//GEN-LAST:event_jDateChooser2PropertyChange

    private void jBGerarN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGerarN1ActionPerformed
        if (exits.size() > 0) {
            try {
                SaleDao vdao = new SaleDao();
                vdao.adicionaPDF(d1, d2);

                report();
                vdao.LimparPDF();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error!" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "There was no sale in the reported period!", "..: WMS :..", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jBGerarN1ActionPerformed

    private void jBGerarN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGerarN2ActionPerformed
        if (exits.size() > 0) {
            try {
                int check = 0;
                int qtd_total = 0;
                double preco_total = 0;
                String idss_s = "";
                SaleDao vdao = new SaleDao();

                ProductDao pdao = new ProductDao();
                List<OutStock> listas = new ArrayList<>();
                List<Sale> listav = new ArrayList<>();
                List<Stock> listae = new ArrayList<>();

                //fica somente com os ids das exits selecionados
                for (int i = 0; i < exits.size(); i++) {
                    if (Boolean.parseBoolean(tmNota.getValueAt(i, 0).toString()) == true) {
                        if (check == 0) {
                            check = 1;
                        }
                        OutStock s = new OutStock();
                        s.setId_outStock(exits.get(i).getId_outStock());
                        listas.add(s);
                    }
                }
                //verifica se tem algum valor pesquisado na tabela
                if (check == 0) {
                    JOptionPane.showMessageDialog(null, "For generate the packing list you need to select at least a sale.", "..: WMS :..", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //retorna a lista de ids de products de todas as exits sem repetir
                    listav = vdao.getProductsOut(listas);
                    OutStockDao sdao = new OutStockDao();
                    for (int i = 0; i < listav.size(); i++) {
                        int qtd = vdao.getAmountProductsOut(listas, listav.get(i).getId_prod());
                        Stock p = new Stock();
                        p.setId_p(listav.get(i).getId_prod());
                        p.setAmount(qtd);

                        //adiciona na tabela os valores para o resumo
                        sdao.adicionaPDFResumo(p);
                    }
                    reportResumo();
                    sdao.LimparPDFResumo();
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error!" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "There was no sale in the reported period!", "..: WMS :..", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jBGerarN2ActionPerformed
 
    public void Search() {
        if (jDateChooser1.getDate() != null && jDateChooser2.getDate() != null) {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            d1 = sd.format(jDateChooser1.getDate());
            d2 = sd.format(jDateChooser2.getDate());

            try {
                OutStockDao sdao = new OutStockDao();
                exits = sdao.getList(d1, d2, 8);
                showExits(exits);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error!" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //Mostra a pesquisa na tabela de notas
    private void showExits(List<OutStock> exits) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
        Date d;

        while (tmNota.getRowCount() > 0) {
            tmNota.removeRow(0);
        }
        if (!exits.isEmpty()) {
            Object[] linha = new Object[]{Boolean.FALSE, null, null, null, null};
            for (int i = 0; i < exits.size(); i++) {
                try {
                    tmNota.addRow(linha);
                    tmNota.setValueAt(exits.get(i).getId_outStock(), i, 1);
                    Customer c = new Customer();
                    try {
                        CustomerDao cdao = new CustomerDao();
                        c = cdao.getCustumer(exits.get(i).getId_customer());
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error!" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
                    }
                    tmNota.setValueAt(c.getName(), i, 2);
                    tmNota.setValueAt(exits.get(i).getTotal() + "", i, 3);
                    d = df.parse(exits.get(i).getDate());
                    tmNota.setValueAt(df2.format(d), i, 4);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Error!" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(SearchSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchSales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SearchSales().setVisible(true);
        });
    }

    //Cria o report da lista de vendas
    private void report() {
        try {
            Date data = new Date();
            int year = data.getYear() + 1900;
            int day = data.getDate();
            int month = data.getMonth() + 1;
            String days = null, months = null;
            if (day < 10) {
                days = "0" + day;
            } else {
                days = "" + day;
            }
            if (month < 10) {
                months = "0" + month;
            } else {
                months = "" + month;
            }
            String Name = "Report_Sales_DATE_" + days + "-" + months + "-" + year;
            String file = Name;
            ConectionReport con = new ConectionReport();
            //diretorio que vai salvar
            File dir = new File("c:/WMS");
            if (!dir.exists()) {
                dir.mkdir();
            }
            File l = new File("c:/WMS/Reports");
            if (!l.exists()) {
                l.mkdir();
            }
            File li = new File("c:/WMS/Reports/Sales");
            if (!li.exists()) {
                li.mkdir();
            }
            String showReport;
            String path = "c:/WMS/Reports/Sales";
            con.connect();
            con.executeSQL("select * from product, venda, saida, cliente, pdf_venda where venda.id_s = saida.id_s and product.id_p = venda.id_p and saida.id_c = cliente.id_c and saida.data between '" + d1 + "' and '" + d2 + "' order by saida.data");
            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
            //referencia o jasper
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Jasper/ReportExits.jasper"), new HashMap(), jrRS);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.setTitle("Search sales - .: WMS :.");
            jv.setIconImage(new ImageIcon(getClass().getResource("/Imagens/windows_icon.png")).getImage());
            jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // JasperViewer.viewReport(jp,true);
            File arq = new File(path + file + ".pdf");
            if (arq.exists()) {
                int result = JOptionPane.showConfirmDialog(null, "The report" + file + ".pdf already exists\n Do you want to replace it?", "WMS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_NO_OPTION) {
                    JasperExportManager.exportReportToPdfFile(jp, path + file + ".pdf");
                    showReport = path + file + ".pdf";
                    JOptionPane.showMessageDialog(null, "Operation finished with success!\n Saved in: " + path + file + ".pdf", "WMS", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + showReport);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error to acces the file! \n\r ERROR:" + e.getStackTrace(), "WMS", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {

                JasperExportManager.exportReportToPdfFile(jp, path + file + ".pdf");
                showReport = path + file + ".pdf";
                JOptionPane.showMessageDialog(null, "Operation finished with success!\n Saved in: " + path + file + ".pdf", "WMS", JOptionPane.INFORMATION_MESSAGE);
                try {
                    Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + showReport);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error to acces the file! \n\r ERROR:" + e.getMessage(), "WMS", JOptionPane.ERROR_MESSAGE);
                }

            }

        } catch (JRException ex) {
            Logger.getLogger(SearchSales.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDelete;
    private javax.swing.JButton jBGerarN;
    private javax.swing.JButton jBGerarN1;
    private javax.swing.JButton jBGerarN2;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTNota;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables

    //Cria o report da nota
    private void reportNota() {
        Date data = new Date();

        int year = data.getYear() + 1900;
        int day = data.getDate();
        int month = data.getMonth() + 1;
        String days = null, months = null;
        if (day < 10) {
            days = "0" + day;
        } else {
            days = "" + day;
        }
        if (month < 10) {
            months = "0" + month;
        } else {
            months = "" + month;
        }
        String Name = "INVOICE_SALE_N_" + exits.get(jTNota.getSelectedRow()).getId_outStock();
        String file = Name;

        ConectionReport con = new ConectionReport();

//diretorio que vai salvar
        File dir = new File("c:/WMS");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File l = new File("c:/WMS/Reports");
        if (!l.exists()) {
            l.mkdir();
        }
        File li = new File("c:/WMS/Reports/Invoices");
        if (!li.exists()) {
            li.mkdir();
        }

        String showReport;
        String path = "c:/WMS/Reports/Invoices/";
        try {
            con.connect();
            con.executeSQL("select saida.*, product.*, venda.*, cliente.*, funcionario.Name_fun from  saida, product, venda, cliente, funcionario where saida.id_s=" + exits.get(jTNota.getSelectedRow()).getId_outStock() + " and saida.id_s=venda.id_s and venda.id_p=product.id_p and saida.id_c=cliente.id_c and funcionario.id_fun=saida.id_fun;");

            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
            //referencia o jasper
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Jasper/NotaVenda.jasper"), new HashMap(), jrRS);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.setTitle("Invoice - .: WMS :.");
            jv.setIconImage(new ImageIcon(getClass().getResource("/Imagens/windows_icon.png")).getImage());
            jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // JasperViewer.viewReport(jp,true);
            File arq = new File(path + file + ".pdf");
            if (arq.exists()) {
                int result = JOptionPane.showConfirmDialog(null, "The report" + file + ".pdf already exists\n Do you want to replace it?", "WMS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_NO_OPTION) {
                    JasperExportManager.exportReportToPdfFile(jp, path + file + ".pdf");
                    showReport = path + file + ".pdf";
                    JOptionPane.showMessageDialog(null, "Operation finished with success!\n Saved in: " + path + file + ".pdf", "WMS", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + showReport);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error to acces the file! \n\r ERROR:" + e.getStackTrace(), "WMS", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {

                JasperExportManager.exportReportToPdfFile(jp, path + file + ".pdf");
                showReport = path + file + ".pdf";
                JOptionPane.showMessageDialog(null, "Operation finished with success!\n Saved in: " + path + file + ".pdf", "WMS", JOptionPane.INFORMATION_MESSAGE);
                try {
                    Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + showReport);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error to acces the file! \n\r ERROR:" + e.getMessage(), "WMS", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (HeadlessException | JRException erro) {
            JOptionPane.showMessageDialog(null, "Error!" + erro, "WMS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Cria o report da nota
    private void reportResumo() {
        Date data = new Date();

        int year = data.getYear() + 1900;
        int day = data.getDate();
        int month = data.getMonth() + 1;
        String days = null, months = null;
        if (day < 10) {
            days = "0" + day;
        } else {
            days = "" + day;
        }
        if (month < 10) {
            months = "0" + month;
        } else {
            months = "" + month;
        }
        String Name = "PACKINGLIST_SALE_DATE_" + days + "-" + months + "-" + year;
        String file = Name;

        ConectionReport con = new ConectionReport();

        //gerar string sql;
        String sql = "select product.*, pdf_resumon.* from product, pdf_resumon where pdf_resumon.id_p = product.id_p;";

        //diretorio que vai salvar
        File dir = new File("c:/WMS");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File l = new File("c:/WMS/Reports");
        if (!l.exists()) {
            l.mkdir();
        }
        File li = new File("c:/WMS/Reports/Invoices");
        if (!li.exists()) {
            li.mkdir();
        }

        String showReport;
        String path = "c:/WMS/Reports/Invoices/";
        try {
            con.connect();
            con.executeSQL(sql);

            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
            //referencia o jasper
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Jasper/ResumoVendas.jasper"), new HashMap(), jrRS);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.setTitle("Invoices - .: WMS :.");
            jv.setIconImage(new ImageIcon(getClass().getResource("/Imagens/windows_icon.png")).getImage());
            jv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            // JasperViewer.viewReport(jp,true);
            File arq = new File(path + file + ".pdf");
            if (arq.exists()) {
                int result = JOptionPane.showConfirmDialog(null, "The report" + file + ".pdf already exists\n Do you want to replace it?", "WMS", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_NO_OPTION) {
                    JasperExportManager.exportReportToPdfFile(jp, path + file + ".pdf");
                    showReport = path + file + ".pdf";
                    JOptionPane.showMessageDialog(null, "Operation finished with success!\n Saved in: " + path + file + ".pdf", "WMS", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + showReport);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Error to acces the file! \n\r ERROR:" + e.getStackTrace(), "WMS", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {

                JasperExportManager.exportReportToPdfFile(jp, path + file + ".pdf");
                showReport = path + file + ".pdf";
                JOptionPane.showMessageDialog(null, "Operation finished with success!\n Saved in: " + path + file + ".pdf", "WMS", JOptionPane.INFORMATION_MESSAGE);
                try {
                    Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + showReport);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null, "Error to acces the file! \n\r ERROR:" + e.getMessage(), "WMS", JOptionPane.ERROR_MESSAGE);
                }

            }
        } catch (HeadlessException | JRException erro) {
            JOptionPane.showMessageDialog(null, "Error!" + erro, "WMS", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
