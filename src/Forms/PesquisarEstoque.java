/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Conexao.ConexaoRel;
import DAO.EstoqueDao;
import DAO.ProdutoDao;
import Entidades.Estoque;
import Entidades.Produto;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Danilo
 */
public class PesquisarEstoque extends javax.swing.JFrame {

    DefaultTableModel tmProduto = new DefaultTableModel(null, new String[]{"Id", "Nome", "Preço (R$)","Qtd estoque"});
    ListSelectionModel lsmProduto;
    List<Produto> produto = new ArrayList<>();
    char l;
    
    public PesquisarEstoque() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Pesquisar Estoque - SGE");
        ImageIcon imagemTituloJanela = new ImageIcon(getClass().getResource("/Imagens/icon-controle-de-estoqu.png"));
        setIconImage(imagemTituloJanela.getImage());
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
        jTPesquisar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTProduto = new javax.swing.JTextField();
        jTPreco = new javax.swing.JTextField();
        jTId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTQtd = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 131, 73));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
        jLabel10.setText("Pesquisar produto:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTPesquisar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Pesquisar Estoque");

        jPanel3.setBackground(new java.awt.Color(0, 131, 73));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Preço (R$):");

        jTProduto.setEditable(false);
        jTProduto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTProdutoKeyPressed(evt);
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

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/estoque_p.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Qtd em estoque:");

        jTQtd.setEditable(false);
        jTQtd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTQtdActionPerformed(evt);
            }
        });
        jTQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTQtdKeyPressed(evt);
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
                                .addComponent(jTProduto))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                            .addComponent(jTProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 131, 73));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTProdutos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTProdutos.setModel(tmProduto);
        jTProdutos.setSelectionBackground(new java.awt.Color(0, 131, 73));
        jTProdutos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmProduto = jTProdutos.getSelectionModel();
        lsmProduto.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) { if (! e.getValueIsAdjusting()){ jTTabelaLinhaSelecionada(jTProdutos); } }
        });
        jScrollPane1.setViewportView(jTProdutos);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/acroread.png"))); // NOI18N
        jButton1.setText("Relatório");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(262, 262, 262))))
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
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPesquisarKeyPressed

    private void jTPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyReleased
        l=evt.getKeyChar();
        if(evt.getKeyCode()==40){
            jTProduto.requestFocus();
        }
        try{
            listarProduto();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco! \n\r ERRO:"+ex, "SGE", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jTPesquisarKeyReleased

    private void jTPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyTyped

    }//GEN-LAST:event_jTPesquisarKeyTyped

    private void jTProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProdutoKeyPressed
        if (jTProduto.getBackground() != Color.WHITE) {
            jTProduto.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jTProdutoKeyPressed

    private void jTPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTPrecoActionPerformed

    private void jTPrecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPrecoKeyPressed
        if (jTPreco.getBackground() != Color.WHITE) {
            jTPreco.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jTPrecoKeyPressed

    private void jTQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTQtdActionPerformed

    private void jTQtdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTQtdKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTQtdKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(produto.size()>0){
            relatorio();
        }else{
            JOptionPane.showMessageDialog(null, "Nenhum produto para listar.", "SGE", JOptionPane.INFORMATION_MESSAGE);
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
            java.util.logging.Logger.getLogger(PesquisarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisarEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PesquisarEstoque().setVisible(true);
            }
        });
    }
    
    protected void listarProduto() throws SQLException {
        ProdutoDao me = new ProdutoDao();
        produto = me.getLista("%" + jTPesquisar.getText() + "%");

        mostraPesquisa(produto);
    }

    private void mostraPesquisa(List<Produto> produto) {

        while (tmProduto.getRowCount() > 0) {
            tmProduto.removeRow(0);
        }
       
        if ((produto.isEmpty()) && (l == ' ')) {
            JOptionPane.showMessageDialog(null, "Nenhum Produto com o Nome " + jTPesquisar.getText().toUpperCase() + " cadastrado.", "..: SGE :..", JOptionPane.INFORMATION_MESSAGE);
        }

        String[] linha = new String[]{null, null, null, null};
        for (int i = 0; i < produto.size(); i++) {
            tmProduto.addRow(linha);
            tmProduto.setValueAt(produto.get(i).getId(), i, 0);
            tmProduto.setValueAt(produto.get(i).getProduto(), i, 1);
            tmProduto.setValueAt(produto.get(i).getPreco(), i, 2);
            tmProduto.setValueAt(getqtdEstoque(produto.get(i).getId())+"", i, 3);
        }
    }
    
    private void jTTabelaLinhaSelecionada(JTable tabela) {
        try {
            if (jTProdutos.getSelectedRow() != -1) {
                jTProduto.setText(produto.get(tabela.getSelectedRow()).getProduto());
                jTPreco.setText(produto.get(tabela.getSelectedRow()).getPreco()+"");
                jTId.setText(produto.get(tabela.getSelectedRow()).getId()+"");
                //busca a qtd desse produto em estoque
                jTQtd.setText(getqtdEstoque(produto.get(tabela.getSelectedRow()).getId())+"");
            } else {

            }
        } catch (Exception e) {

        }
    } 

    //pega a qtd de estoque de determinado produto
    public int getqtdEstoque(int id_prod){
        Estoque estoque = null;
        try {
            //busca a qtd desse produto em estoque
            EstoqueDao edao = new EstoqueDao();
            estoque = edao.GetEstoque(id_prod);
            if(estoque==null){
                Estoque e = new Estoque();
                e.setId_p(id_prod);
                e.setQtd(0);
                edao.adiciona(e);
                estoque = edao.GetEstoque(id_prod);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro!" + ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
        }
        
        return estoque.getQtd();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTPesquisar;
    private javax.swing.JTextField jTPreco;
    public javax.swing.JTextField jTProduto;
    private javax.swing.JTable jTProdutos;
    private javax.swing.JTextField jTQtd;
    // End of variables declaration//GEN-END:variables

//Cria o relatorio da nota
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
        String nome = "Relatório_Estoque_DATA_"+dias + "-" + mess + "-" + ano;
        String arquivo = nome;

        ConexaoRel con = new ConexaoRel();

//diretorio que vai salvar
        File dir = new File("c:/SGE");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File l = new File("c:/SGE/Relatorios");
        if (!l.exists()) {
            l.mkdir();
        }
        File li = new File("c:/SGE/Relatorios/Estoque");
        if (!li.exists()) {
            li.mkdir();
        }

        String MostrarRelatorio;
        String path = "c:/SGE/Relatorios/Estoque/";
        try {
            con.conecta();
            con.executeSQL("select produto.*, estoque.qtd from produto, estoque where produto.id_p=estoque.id_p and produto.nome_p LIKE '%"+jTPesquisar.getText()+"%';");
           
          
            JRResultSetDataSource jrRS = new JRResultSetDataSource(con.resultset);
            //referencia o jasper
            JasperPrint jp = JasperFillManager.fillReport(getClass().getResourceAsStream("/Jasper/QtdEstoque.jasper"), new HashMap(), jrRS);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            jv.setTitle("Relatório de Estoque - .: SGE :.");
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
                         JOptionPane.showMessageDialog(null, "Erro ao acessar arquivo! \n\r ERRO:"+e.getStackTrace(), "SGE", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {

                JasperExportManager.exportReportToPdfFile(jp, path + arquivo + ".pdf");
                MostrarRelatorio = path + arquivo + ".pdf";
                JOptionPane.showMessageDialog(null, "Operação Realizada consucesso!\n Salvo em: " + path + arquivo + ".pdf", "SGE", JOptionPane.INFORMATION_MESSAGE);
                try {
                    Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL " + MostrarRelatorio);
                } catch (IOException e) {
                     JOptionPane.showMessageDialog(null, "Erro ao acessar arquivo! \n\r ERRO:"+e.getMessage(), "SGE", JOptionPane.ERROR_MESSAGE);
                }

            }

            //   JasperViewer jv = new JasperViewer(jp, false);
            //  jv.setVisible(true);
            //  jv.setTitle("Lista Contatos");
            //  jv.setIconImage(new ImageIcon(getClass().getResource("/Icones/vista (18).png")).getImage());
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro!" + erro, "SGE", JOptionPane.INFORMATION_MESSAGE);
            
        }
    }
    
}
