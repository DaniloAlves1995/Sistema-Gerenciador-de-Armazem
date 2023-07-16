/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import DAO.CustomerDao;
import DAO.ProductDao;
import DAO.OutStockDao;
import DAO.SaleDao;
import DAO.SalesmanDao;
import Entities.Customer;
import Entities.Product;
import Entities.OutStock;
import Entities.Sale;
import Entities.Salesman;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
public class SaleDetails extends javax.swing.JFrame {

    private List<Sale> venda, vendas;//lista utilizada para armazenar as vendas da tabela
    private DefaultListModel dlista, dlistam;
    private DefaultTableModel tmVendas = new DefaultTableModel(null, new String[]{"Product", "Amount", "Price(R$)"});
    private Product product = null;
    private List<Salesman> Sellers;
    private int idcliente;
    private OutStock nota;
    private boolean veri = false;
    
    public int id;
    public SearchSales pesqvenda;

    char l;
    int mais = -1;//para check se já clicou na seta para baixo
    int contr = 1;//para controlar quando o usuário percorre o product na lista
    int ilistp = -1;//índice para referenciar a posição selecionada da lista com a lista <product> 
    int qtd = 0;//para contar The amount ofproducts vendidos
    int contrenter = 0;
    int contfocus = 0;
    int controlefocus2 = 0;//para controlar se está passando pelos campos para cadastrar ou editar

    public SaleDetails() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setTitle("Sale detail - WMS");
        ImageIcon iconWindow = new ImageIcon(getClass().getResource("/Imagens/windows_icon.png"));
        this.setIconImage(iconWindow.getImage());

        //desabilitar os vendadores
        jComboBox2.setEnabled(false);

        //inicializa a lista vendas
        venda = new ArrayList<Sale>();

        //inicializa os DefaultListModels para ser utilizado no esfeito da pesquisa dinâmic do product
        dlista = new DefaultListModel();
        dlistam = new DefaultListModel();

        jTValor.setEditable(false);
        jTPreco.setEditable(false);
        jTAddress.setEditable(false);

        PreencherSellers();
    }

    public void SetId(int id) {
        this.id = id;
    }

    public void Iniciar() {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
            Date d;

            OutStockDao da = new OutStockDao();
            List<OutStock> notas = da.getList(id + "", "", 1);
            nota = notas.get(0);
            jTNVenda.setText(notas.get(0).getId_outStock() + "");
            jTTotal.setText(notas.get(0).getTotal() + "");
            d = df.parse(notas.get(0).getDate());
            jTData.setText(df2.format(d));
            CustomerDao cdao = new CustomerDao();
            idcliente = notas.get(0).getId_customer();
            Customer c = cdao.getCustumer(notas.get(0).getId_customer());
            jTCliente.setText(c.getName());
            jTAddress.setText(c.getAddress());
            jTCpf.setText(c.getCpf());
            jTContato1.setText(c.getContact1());
            jTContato2.setText(c.getContact2());
            SalesmanDao vdao = new SalesmanDao();
            Salesman v = vdao.getSelesman(notas.get(0).getId_salesman());
            jComboBox2.setSelectedItem(v.getName());

            listVendas();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to access the database! \n\r ERROR:" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "ERROR:" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void listVendas() throws SQLException {
        SaleDao me = new SaleDao();
        vendas = me.getList(id);

        showSearchVenda(vendas);
    }

    private void showSearchVenda(List<Sale> vendas) {

        while (tmVendas.getRowCount() > 0) {
            tmVendas.removeRow(0);
        }

        String[] linha = new String[]{null, null, null, null};
        for (int i = 0; i < vendas.size(); i++) {
            try {
                tmVendas.addRow(linha);
                ProductDao pdao = new ProductDao();
                Product p = pdao.getProduct(vendas.get(i).getId_prod());
                tmVendas.setValueAt(p.getProduct(), i, 0);
                tmVendas.setValueAt(vendas.get(i).getAmount(), i, 1);
                tmVendas.setValueAt(vendas.get(i).getPrice(), i, 2);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error to access the database! \n\r ERROR:" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
            }

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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTNVenda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTData = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTProduct = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTValor = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jTPreco = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTCliente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTAddress = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTTotal1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTCpf = new javax.swing.JTextField();
        jTContato1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTContato2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTVendas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 131, 73));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("N° of Sale:");

        jTNVenda.setEditable(false);
        jTNVenda.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTNVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTNVendaMouseClicked(evt);
            }
        });
        jTNVenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTNVendaKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total:");

        jTTotal.setEditable(false);
        jTTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTTotal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTotalMouseClicked(evt);
            }
        });
        jTTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTTotalKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Date:");

        jTData.setEditable(false);
        jTData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTDataMouseClicked(evt);
            }
        });
        jTData.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTDataKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Seller:");

        jComboBox2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTNVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTTotal)
                    .addComponent(jTData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jTData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTNVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setText("Sale details");

        jPanel3.setBackground(new java.awt.Color(0, 131, 73));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Customer data:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Product:");

        jTProduct.setEditable(false);
        jTProduct.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTProductFocusLost(evt);
            }
        });
        jTProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProductMouseClicked(evt);
            }
        });
        jTProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTProductKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTProductKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTProductKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Value (R$):");

        jTValor.setEditable(false);
        jTValor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTValorKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Price(R$):");

        jTPreco.setEditable(false);
        jTPreco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTPreco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Sale data:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Customer:");

        jTCliente.setEditable(false);
        jTCliente.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTClienteMouseClicked(evt);
            }
        });
        jTCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTClienteKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Address:");

        jTAddress.setEditable(false);
        jTAddress.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTAddressKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTAddressKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTAddressKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Amount.:");

        jTTotal1.setEditable(false);
        jTTotal1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTTotal1.setText("1");
        jTTotal1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTTotalFocusLost(evt);
            }
        });
        jTTotal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTotalActionPerformed(evt);
            }
        });
        jTTotal1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTTotalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTTotalKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("CPF:");

        jTCpf.setEditable(false);
        jTCpf.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTCpf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTCpfMouseClicked(evt);
            }
        });
        jTCpf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTCpfKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTCpfKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTCpfKeyTyped(evt);
            }
        });

        jTContato1.setEditable(false);
        jTContato1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTContato1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTContato1MouseClicked(evt);
            }
        });
        jTContato1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTContato1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTContato1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTContato1KeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Phone 1:");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Phone 2:");

        jTContato2.setEditable(false);
        jTContato2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTContato2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTContato2MouseClicked(evt);
            }
        });
        jTContato2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTContato2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTContato2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTContato2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(859, 865, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTProduct))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTValor)
                                    .addComponent(jTPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTAddress)
                                    .addComponent(jTCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                                    .addComponent(jTCpf, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTContato2))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTContato1)))))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel15)
                    .addComponent(jTContato1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jTContato2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel9)
                    .addComponent(jTValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTVendas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTVendas.setModel(tmVendas);
        jTVendas.setSelectionBackground(new java.awt.Color(0, 131, 73));
        jTVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTVendasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTVendas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(400, 400, 400))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

    private void jTNVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTNVendaMouseClicked

    }//GEN-LAST:event_jTNVendaMouseClicked

    private void jTNVendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTNVendaKeyPressed

    }//GEN-LAST:event_jTNVendaKeyPressed

    private void jTTotalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTotalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTotalMouseClicked
    // TODO add your handling code here:


    private void jTDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDataMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDataMouseClicked

    private void jTDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDataKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDataKeyPressed

    private void jTProductFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTProductFocusLost

    }//GEN-LAST:event_jTProductFocusLost

    private void jTProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProductKeyPressed

    }//GEN-LAST:event_jTProductKeyPressed

    private void jTProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProductKeyReleased

    }//GEN-LAST:event_jTProductKeyReleased

    private void jTProductKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProductKeyTyped

    }//GEN-LAST:event_jTProductKeyTyped

    private void jTValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTValorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTValorKeyReleased

    private void jTClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTClienteMouseClicked

    }//GEN-LAST:event_jTClienteMouseClicked

    private void jTClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTClienteKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTClienteKeyPressed

    private void jTClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTClienteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTClienteKeyReleased

    private void jTClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTClienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTClienteKeyTyped

    private void jTAddressKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAddressKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAddressKeyPressed

    private void jTAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAddressKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAddressKeyReleased

    private void jTAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAddressKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAddressKeyTyped

    private void jTTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTotalActionPerformed

    private void jTTotalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTTotalFocusLost

    }//GEN-LAST:event_jTTotalFocusLost

    private void jTTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTotalKeyPressed

    }//GEN-LAST:event_jTTotalKeyPressed

    private void jTTotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTotalKeyReleased

    }//GEN-LAST:event_jTTotalKeyReleased

    private void jTVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTVendasMouseClicked
        ClicarTabela();
    }//GEN-LAST:event_jTVendasMouseClicked

    private void jTProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProductMouseClicked

    }//GEN-LAST:event_jTProductMouseClicked

    private void jTCpfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTCpfMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCpfMouseClicked

    private void jTCpfKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCpfKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCpfKeyPressed

    private void jTCpfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCpfKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCpfKeyReleased

    private void jTCpfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTCpfKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTCpfKeyTyped

    private void jTContato1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTContato1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTContato1MouseClicked

    private void jTContato1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTContato1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTContato1KeyPressed

    private void jTContato1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTContato1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTContato1KeyReleased

    private void jTContato1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTContato1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTContato1KeyTyped

    private void jTContato2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTContato2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTContato2MouseClicked

    private void jTContato2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTContato2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTContato2KeyPressed

    private void jTContato2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTContato2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTContato2KeyReleased

    private void jTContato2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTContato2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTContato2KeyTyped

    //metodo que recebe a instância do Form SearchVenda
    public void SetSearchVendas(SearchSales pesqvenda) {
        this.pesqvenda = pesqvenda;
    }

    //metodo para show os valores nos campos quando clicar na tabela
    public void ClicarTabela() {
        if (jTVendas.getSelectedRow() != -1) {
            try {
                ProductDao pdao = new ProductDao();
                Product p = pdao.getProduct(vendas.get(jTVendas.getSelectedRow()).getId_prod());
                jTProduct.setText(p.getProduct());
                jTPreco.setText(vendas.get(jTVendas.getSelectedRow()).getValueProduct() + "");
                jTTotal.setText(vendas.get(jTVendas.getSelectedRow()).getAmount() + "");
                jTValor.setText(vendas.get(jTVendas.getSelectedRow()).getPrice() + "");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error to access the database! \n\r ERROR:" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    //método que limpa os campos para a venda de outro product
    public void Clear() {
        jTPreco.setText("");
        jTProduct.setText("");
        jTTotal.setText("1");
        jTValor.setText("");
    }

    private void atualizarTabela(List<Entities.Sale> venda) {

        while (tmVendas.getRowCount() > 0) {
            tmVendas.removeRow(0);
        }

        String[] linha = new String[]{null, null, null, null};
        for (int i = 0; i < venda.size(); i++) {
            tmVendas.addRow(linha);
            String product = "";
            String preco = "";
            try {
                //Pega o product com o id na lista da venda
                ProductDao dao = new ProductDao();
                Product p = dao.getProduct(venda.get(i).getId_prod());
                product = p.getProduct();
                preco = String.valueOf(p.getPrice());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error to access the database! \n\r ERROR:" + ex, "..: WMS :..", JOptionPane.ERROR_MESSAGE);
            }

            tmVendas.setValueAt(product, i, 0);
            tmVendas.setValueAt(venda.get(i).getAmount(), i, 1);
            tmVendas.setValueAt(venda.get(i).getPrice(), i, 2);

        }
    }

    //metodo para preencher o combobox dos Sellers
    public final void PreencherSellers() {
        try {
            SalesmanDao a = new SalesmanDao();
            Sellers = a.getList("");
            for (int y = 0; y < Sellers.size(); y++) {
                jComboBox2.addItem(Sellers.get(y).getName());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error to access the database! \n\r ERROR:" + ex, "SyWMSM'S", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(SaleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SaleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SaleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SaleDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaleDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTAddress;
    private javax.swing.JTextField jTCliente;
    private javax.swing.JTextField jTContato1;
    private javax.swing.JTextField jTContato2;
    private javax.swing.JTextField jTCpf;
    private javax.swing.JTextField jTData;
    private javax.swing.JTextField jTNVenda;
    private javax.swing.JTextField jTPreco;
    private javax.swing.JTextField jTProduct;
    private javax.swing.JTextField jTTotal;
    private javax.swing.JTextField jTTotal1;
    private javax.swing.JTextField jTValor;
    private javax.swing.JTable jTVendas;
    // End of variables declaration//GEN-END:variables
}
