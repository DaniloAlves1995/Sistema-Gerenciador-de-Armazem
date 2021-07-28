/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DAO.ClienteDao;
import Entidades.Cliente;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * ------------- ..::NorthTech Automação::.. ------------- *
 *********************************************************** 
 * 
 *@Desenvolvedor Danilo Alves
 * 
 */
           //<editor-fold defaultstate="collapsed" desc="Departamento de Sistemas Desktop">
           //</editor-fold>
                  //<editor-fold defaultstate="collapsed" desc="Tecnology Java SE">
                  //</editor-fold>
public class CadastroCliente extends javax.swing.JFrame {

    DefaultTableModel tmCliente = new DefaultTableModel(null, new String[]{"Id", "Nome", "Endereço", "Contato"});
    ListSelectionModel lsmCliente;
    List<Cliente> cliente;
    char l;
    public int habilit;
    public int salvar = 0;

    /**
     * Metódo para criar uma nova instância do Form
     */
    public CadastroCliente() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Cadastrar Cliente - SGE");
        ImageIcon imagemTituloJanela = new ImageIcon(getClass().getResource("/Imagens/icon-controle-de-estoqu.png"));
        setIconImage(imagemTituloJanela.getImage());
        
        //Desabilita os campos
        Desabilitar();
        //mostrar qtd de socios
        MostrarQtdClientes();

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
        jLabel12 = new javax.swing.JLabel();
        jTTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTNome = new javax.swing.JTextField();
        jTEndereco = new javax.swing.JTextField();
        jTTelefone = new javax.swing.JFormattedTextField();
        jTId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTCpf = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTTelefone1 = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 131, 73));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pesquisar Clientes:");

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
        jLabel12.setText("Total de Clientes:");

        jTTotal.setEditable(false);
        jTTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTTotal)
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
        jLabel2.setText("Cadastro de Clientes");

        jPanel3.setBackground(new java.awt.Color(0, 131, 73));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nome:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Endereço:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Contato 1:");

        jTNome.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNomeKeyPressed(evt);
            }
        });

        jTEndereco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTEnderecoActionPerformed(evt);
            }
        });
        jTEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTEnderecoKeyPressed(evt);
            }
        });

        try{
            try {
                jTTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
            jTTelefone.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
        jTTelefone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTTelefoneKeyPressed(evt);
            }
        });

        jTId.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTId.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Id:");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/addh.png"))); // NOI18N

        jTCpf.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTCpfActionPerformed(evt);
            }
        });
        jTCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTCpfKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CPF/CNPJ:");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Contato 2:");

        try{
            try {
                jTTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
            jTTelefone1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
        jTTelefone1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTTelefone1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(436, 436, 436)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTCpf)
                            .addComponent(jTEndereco)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jTTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTNome))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jTTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/page_white.png"))); // NOI18N
        jButton2.setText("Novo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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
                .addGap(37, 37, 37)
                .addComponent(jButton2)
                .addGap(37, 37, 37)
                .addComponent(jButton3)
                .addGap(37, 37, 37)
                .addComponent(jButton4)
                .addGap(88, 88, 88))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton2, jButton3, jButton4});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        jPanel5.setBackground(new java.awt.Color(0, 131, 73));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTClientes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTClientes.setModel(tmCliente);
        jTClientes.setSelectionBackground(new java.awt.Color(0, 131, 73));
        jTClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsmCliente = jTClientes.getSelectionModel();
        lsmCliente.addListSelectionListener(new ListSelectionListener() { public void valueChanged(ListSelectionEvent e) { if (! e.getValueIsAdjusting()){ jTTabelaLinhaSelecionada(jTClientes); } }
        });
        jScrollPane1.setViewportView(jTClientes);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
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
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        if (salvar == 0) {
            //Verifica se ha algum campo vazio
            if (Verificar()) {
                //Cria um objeto Sócio para setar os valores dos TextFilds
                Cliente s = new Cliente();
                //Seta os valores dos TextFilds
                s.setNome(jTNome.getText());
                s.setEndereco(jTEndereco.getText());
                s.setContato1(jTTelefone.getText());
                s.setContato2(jTTelefone1.getText());
                s.setCpf(jTCpf.getText());
               
                try {
                    //Cria um objeto DAO para inserir o novo Socio no banco
                    ClienteDao d = new ClienteDao();
                    //Adiciona o novo Sócio no banco
                    d.adiciona(s);
                    JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!", "..: SGE :..", JOptionPane.INFORMATION_MESSAGE);
                    //Limpa os TextFilds depois do Cadastro
                    Limpar();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao acessar o banco! \n\r ERRO:"+ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
                }

            }
        } else {
            if (Verificar()) {
                if (Everificar()) {
                    try {
                        alteraSocio();
                        jTPesquisar.setText("");
                        listarSocio();
                        Limpar();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! \n\r ERRO:"+ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
                    }

                }
            }
        }

        MostrarQtdClientes();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    //Método para limpar os TextFilds
    public void Limpar() {
        jTNome.setText("");
        jTEndereco.setText("");
        jTTelefone.setText("");
        jTTelefone1.setText("");
        jTId.setText("");   
        jTCpf.setText("");
    }

    //Método para Desabilitar os TextFilds
    public void Desabilitar() {
        jTNome.setEditable(false);
        jTEndereco.setEditable(false);
        jTTelefone.setEditable(false);
        jTTelefone1.setEditable(false);
        jTCpf.setEditable(false);
    }

    //Método para Habilitar os TextFilds
    public void Habilitar() {
        jTNome.setEditable(true);
        jTEndereco.setEditable(true);
        jTCpf.setEditable(true);
        jTTelefone.setEditable(true);
        jTTelefone1.setEditable(true);
    }

    protected void listarSocio() throws SQLException {
        ClienteDao me = new ClienteDao();
        cliente = me.getLista("%" + jTPesquisar.getText() + "%");

        mostraPesquisa(cliente);
    }

    private void mostraPesquisa(List<Cliente> cliente) {

        while (tmCliente.getRowCount() > 0) {
            tmCliente.removeRow(0);
        }
       
        if ((cliente.isEmpty()) && (l == ' ')) {
            JOptionPane.showMessageDialog(null, "Nenhum Cliente com o Nome " + jTPesquisar.getText().toUpperCase() + " cadastrado.", "..: SGE :..", JOptionPane.INFORMATION_MESSAGE);
        }

        String[] linha = new String[]{null, null, null, null, null};
        for (int i = 0; i < cliente.size(); i++) {
            tmCliente.addRow(linha);
            tmCliente.setValueAt(cliente.get(i).getId(), i, 0);
            tmCliente.setValueAt(cliente.get(i).getNome(), i, 1);
            tmCliente.setValueAt(cliente.get(i).getEndereco(), i, 2);
            tmCliente.setValueAt(cliente.get(i).getContato1(), i, 3);
           
        }
    }

    public boolean Everificar() {
        if ((cliente.get(jTClientes.getSelectedRow()).getNome().equals(jTNome.getText())) && (cliente.get(jTClientes.getSelectedRow()).getEndereco().equals(jTEndereco.getText())) && (cliente.get(jTClientes.getSelectedRow()).getContato1().equals(jTTelefone.getText())) && (cliente.get(jTClientes.getSelectedRow()).getContato2().equals(jTTelefone1.getText())) && (cliente.get(jTClientes.getSelectedRow()).getCpf().equals(jTCpf.getText()))) {
            JOptionPane.showMessageDialog(null, "Nenhum dado foi modificado!", "..: SGE :..", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else {
            return true;

        }
    }

    private void jTPesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyPressed

    }//GEN-LAST:event_jTPesquisarKeyPressed

    private void jTPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTPesquisarKeyTyped
        l = evt.getKeyChar();
        // System.out.println(l);
        
        try {
            listarSocio();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! \n\r ERRO:"+ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jTPesquisarKeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Habilitar();
        Limpar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (jTClientes.getSelectedRow() != -1) {
            Habilitar();
            salvar = 1;
        } else {
            JOptionPane.showMessageDialog(null, "Você Precisa selecionar um Cliente na tabela para poder Editar!", "..: SGE :..", JOptionPane.WARNING_MESSAGE);
        }


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (jTClientes.getSelectedRow() != -1) {
            Excluir();
        } else {
            JOptionPane.showMessageDialog(null, "Você Precisa selecionar um Cliente na Tabela para poder Excluir!", "..: SGE :..", JOptionPane.WARNING_MESSAGE);
        }
        MostrarQtdClientes();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTTelefoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefoneKeyPressed
        if (jTTelefone.getBackground() != Color.WHITE) {
            jTTelefone.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jTTelefoneKeyPressed

    private void jTEnderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEnderecoKeyPressed
        if (jTEndereco.getBackground() != Color.WHITE) {
            jTEndereco.setBackground(Color.WHITE);
        }
    }//GEN-LAST:event_jTEnderecoKeyPressed

    private void jTNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNomeKeyPressed
        if (jTNome.getBackground() != Color.WHITE) {
            jTNome.setBackground(Color.WHITE);
        }

    }//GEN-LAST:event_jTNomeKeyPressed

    private void jTEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEnderecoActionPerformed

    private void jTCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCpfActionPerformed

    private void jTCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCpfKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCpfKeyPressed

    private void jTTelefone1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTelefone1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTelefone1KeyPressed

    public boolean Verificar() {
        boolean valor = true;
        if (jTNome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "O campo Nome não pede ser vazio!", "..: SGE :..", JOptionPane.WARNING_MESSAGE);
            jTNome.setBackground(new Color(255, 51, 51));
            jTNome.requestFocus();
            valor = false;
        } else {
            if (jTEndereco.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O campo Endereço não pode ser vazio!", "..: SGE :..", JOptionPane.WARNING_MESSAGE);
                jTEndereco.setBackground(new Color(255, 51, 51));
                jTEndereco.requestFocus();
                valor = false;
            } else {
                
                    if (jTTelefone.getText().equals("(  )    -    ")) {
                        JOptionPane.showMessageDialog(null, "O campo Contato 1 não pode ser vazio!", "..: SGE :..", JOptionPane.WARNING_MESSAGE);
                        jTTelefone.setBackground(new Color(255, 51, 51));
                        jTTelefone.requestFocus();
                        valor = false;
                    } else {

                    }
                
            }
        }
        return valor;
    }

    //Esse metodo serve para Alterar os valores do sócio no banco
      private void alteraSocio() throws SQLException {

        if (Verificar()) {
            Cliente m = new Cliente();
            ClienteDao dao = new ClienteDao();
            m.setId(cliente.get(jTClientes.getSelectedRow()).getId());
            m.setNome(jTNome.getText());
            m.setEndereco(jTEndereco.getText());
            m.setContato1(jTTelefone.getText());
            m.setContato2(jTTelefone1.getText());
            m.setCpf(jTCpf.getText());
            
            dao.altera(m);
            JOptionPane.showMessageDialog(null, "Cliente Alterado com SUCESSO!", "..: SGE :..", JOptionPane.INFORMATION_MESSAGE);
            salvar = 0;
            Desabilitar();

        }

    }

    //Metodo para excluir o sócio 
    public void Excluir() {
        int a = JOptionPane.showConfirmDialog(null, "Você deseja realmente excluir o Cliente " + jTNome.getText().toUpperCase(), "..: SGE :..", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (a == 0) {
            try {
                ClienteDao m = new ClienteDao();
                m.Excluir(cliente.get(jTClientes.getSelectedRow()));
                JOptionPane.showMessageDialog(null, "Cliente excluido(a) com sucesso!", "..: SGE :..", JOptionPane.INFORMATION_MESSAGE);
                jTPesquisar.setText("");
                listarSocio();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! \n\r ERRO:"+ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * @Desenvolvedor Danilo Alves
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
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCliente().setVisible(true);
            }
        });
    }

    private void jTTabelaLinhaSelecionada(JTable tabela) {
        try {
            if (jTClientes.getSelectedRow() != -1) {
                jTNome.setText(cliente.get(tabela.getSelectedRow()).getNome());
                jTEndereco.setText(cliente.get(tabela.getSelectedRow()).getEndereco());
                jTTelefone.setText(cliente.get(tabela.getSelectedRow()).getContato1());
                jTTelefone1.setText(cliente.get(tabela.getSelectedRow()).getContato2());
                jTId.setText(cliente.get(tabela.getSelectedRow()).getId()+"");
                jTCpf.setText(cliente.get(tabela.getSelectedRow()).getCpf());
                
                Desabilitar();
            } else {

            }
        } catch (Exception e) {

        }
    } 
    
    //metodo para mostrar a qtd de sócios
    public void MostrarQtdClientes(){
        try {
            //pega a qtd de sócios cadastrados no banco
            ClienteDao dao = new ClienteDao();
            jTTotal.setText(String.valueOf(dao.GetQtdClientes()));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao contar a quantidade de clientes!", "..: SGE :..", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTClientes;
    private javax.swing.JTextField jTCpf;
    private javax.swing.JTextField jTEndereco;
    private javax.swing.JTextField jTId;
    public javax.swing.JTextField jTNome;
    private javax.swing.JTextField jTPesquisar;
    private javax.swing.JFormattedTextField jTTelefone;
    private javax.swing.JFormattedTextField jTTelefone1;
    private javax.swing.JTextField jTTotal;
    // End of variables declaration//GEN-END:variables
}
