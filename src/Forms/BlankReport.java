/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Connection.ConectionReport;
import DAO.StockDao;
import DAO.ProductDao;
import Entities.Product;
import Utils.OSUtilities;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
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
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
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
public class BlankReport extends javax.swing.JFrame {

    private DefaultTableModel tmProducts = new DefaultTableModel(new Object[][]{}, new String[]{"Select", "Id", "Product", "Amount"}) {
        Class[] types = new Class[]{
            Boolean.class, Object.class, Object.class, Object.class
        };

        @Override
        public Class getColumnClass(int columnIndex) {
            return types[columnIndex];
        }
    };

    private List<Product> products;

    public BlankReport() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Report for entry into stock - WMS");
        ImageIcon iconWindow = new ImageIcon(getClass().getResource("/Imagens/windows_icon.png"));
        setIconImage(iconWindow.getImage());

        try {
            ProductDao pdao = new ProductDao();
            products = pdao.getListAll();
            this.adicionarTabela(products);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error!" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
        }

    }

    public final void adicionarTabela(List<Product> products) {
        try {
            while (tmProducts.getRowCount() > 0) {
                tmProducts.removeRow(0);
            }

            StockDao edao = new StockDao();

            Object[] linha = new Object[]{null, null, null, null};
            for (int i = 0; i < products.size(); i++) {
                tmProducts.addRow(linha);
                tmProducts.setValueAt(Boolean.FALSE, i, 0);
                tmProducts.setValueAt(products.get(i).getId(), i, 1);
                tmProducts.setValueAt(products.get(i).getProduct(), i, 2);
                tmProducts.setValueAt(edao.getStock(products.get(i).getId()).getAmount(), i, 3);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error!" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
        }
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
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProducts = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Report to entrance");

        jPanel2.setBackground(new java.awt.Color(0, 131, 73));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTProducts.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTProducts.setModel(tmProducts);
        jTProducts.setSelectionBackground(new java.awt.Color(0, 131, 73));
        jScrollPane1.setViewportView(jTProducts);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Select the products that will be added to the report for the entries summary.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 68, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/acroread.png"))); // NOI18N
        jButton1.setText("Report");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int check = 0;
        List<Product> lista = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (Boolean.parseBoolean(tmProducts.getValueAt(i, 0).toString()) == true) {
                if (check == 0) {
                    check = 1;
                }
                lista.add(products.get(i));
            }
        }
        if (check == 0) {
            JOptionPane.showMessageDialog(null, "For generate the report you need to select at least one product.", "..: WMS :..", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ProductDao pdao;
          
                //pdao = new ProductDao();
                //pdao.AddPDF_ReportE(lista);
                report(lista);
                //pdao.ClearPDF_ReportE();
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(BlankReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BlankReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BlankReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BlankReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BlankReport().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTProducts;
    // End of variables declaration//GEN-END:variables

    //Cria o report em branco
    private void report(List<Product> lista) {
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
        String Name = "Report_Entry_date_" + days + "-" + months + "-" + year;
        String file = Name;

        ConectionReport con = new ConectionReport();

        OSUtilities osUtilities = new OSUtilities();

        String showReport;
        String path = osUtilities.getDirectory("/Reports/Entry/");
        try {
            con.connect();
            String sql = "select row_number() over (order by produto.id_p) as id_ree, produto.id_p, produto.nome_p as produto, estoque.qtd as qtd_e from produto, estoque where \n" +
"produto.id_p=estoque.id_p and (";
            for (int i=0; i<lista.size(); i++){
                if (i == 0)
                    sql += "produto.id_p="+lista.get(i).getId();
                else
                    sql += " or produto.id_p="+lista.get(i).getId();
            }
            sql += ")";
            System.out.println(sql);
            con.executeSQL(sql);

            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
            //referencia o jasper
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Jasper/RelatorioEntrada.jasper"), new HashMap(), jrRS);
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

}
