/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Forms;

import DAO.ClienteDao;
import DAO.ProdutoDao;
import DAO.SaidaDao;
import DAO.VendaDao;
import DAO.VendedorDao;
import Entidades.Cliente;
import Entidades.Produto;
import Entidades.Saida;
import Entidades.Venda;
import Entidades.Vendedor;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
public class DetalhesVenda extends javax.swing.JFrame {

   
   List<Venda> venda;
   DefaultListModel dlista;
   DefaultListModel dlistam;
   public int id;
   DefaultTableModel tmVendas = new DefaultTableModel(null, new String[]{"Produto", "Quantidade", "Preço(R$)"});
   List<Venda> vendas;//lista utilizada para armazenar as vendas da tabela
   Produto produto=null;
   List<Vendedor> vendedores;
   private int idcliente;
   Saida nota;
   boolean veri=false;
   
    char l;
    int mais=-1;//para verificar se já clicou na seta para baixo
    int contr=1;//para controlar quando o usuário percorre o produto na lista
    int ilistp=-1;//índice para referenciar a posição selecionada da lista com a lista <produto> 
    int qtd=0;//para contar a quantidade de produtos vendidos
    int contrenter=0;
    int contfocus=0;
    int controlefocus2=0;//para controlar se está passando pelos campos para cadastrar ou editar
    
    public DetalhesVenda() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setTitle("Detalhes da venda - SGE");
        ImageIcon imagemTituloJanela = new ImageIcon(getClass().getResource("/Imagens/icon-controle-de-estoqu.png"));
        setIconImage(imagemTituloJanela.getImage());
        
        //desabilitar os vendadores
        jComboBox2.setEnabled(false);
        
        
        //inicializa a lista vendas
        venda = new ArrayList<Venda>();
       
     
        //inicializa os DefaultListModels para ser utilizado no esfeito da pesquisa dinâmic do produto
        dlista = new DefaultListModel();
        dlistam = new DefaultListModel();
       
        jTValor.setEditable(false);
        jTPreco.setEditable(false);
        jTEndereco.setEditable(false);
        
        
        
        PreencherVendedores();
    }
    
    public void SetId(int id){
        this.id=id;
    }

    public void Iniciar(){
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy");
            Date d;
            
            SaidaDao da = new SaidaDao();
            List<Saida> notas = da.getLista(id+"", "", 1);
            nota = notas.get(0);
            jTNVenda.setText(notas.get(0).getId_s()+"");
            jTTotal.setText(notas.get(0).getTotal()+"");
            d=df.parse(notas.get(0).getData());
            jTData.setText(df2.format(d));
            ClienteDao cdao = new ClienteDao();
            idcliente = notas.get(0).getId_c();
            Cliente c = cdao.GetCliente(notas.get(0).getId_c());
            jTCliente.setText(c.getNome());
            jTEndereco.setText(c.getEndereco());
            jTCpf.setText(c.getCpf());
            jTContato1.setText(c.getContato1());
            jTContato2.setText(c.getContato2());
            VendedorDao vdao = new VendedorDao();
            Vendedor v = vdao.GetVendedor(notas.get(0).getId_fun());
            jComboBox2.setSelectedItem(v.getNome());
            
            
            listarVendas();
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao acessar o banco! \n\r ERRO:"+ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(null, "ERRO:"+ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
       }
    }
    
    protected void listarVendas() throws SQLException {
        VendaDao me = new VendaDao();
        vendas = me.getLista(id);

        mostraPesquisaVenda(vendas);
    }

    private void mostraPesquisaVenda(List<Venda> vendas) {

        while (tmVendas.getRowCount() > 0) {
            tmVendas.removeRow(0);
        }
       
        String[] linha = new String[]{null, null, null, null};
        for (int i = 0; i < vendas.size(); i++) {
            try {
                tmVendas.addRow(linha);
                ProdutoDao pdao = new ProdutoDao();
                Produto p = pdao.GetProduto(vendas.get(i).getId_p());
                tmVendas.setValueAt(p.getProduto(), i, 0);
                tmVendas.setValueAt(vendas.get(i).getQtd(), i, 1);
                tmVendas.setValueAt(vendas.get(i).getPreco(), i, 2);
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao acessar o banco! \n\r ERRO:"+ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
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
        jTProduto = new javax.swing.JTextField();
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
        jTEndereco = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTQtd = new javax.swing.JTextField();
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
        jLabel3.setText("N° da Venda:");

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
        jLabel6.setText("Data:");

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
        jLabel17.setText("Vendedor:");

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
        jLabel2.setText("Detalhes da Venda");

        jPanel3.setBackground(new java.awt.Color(0, 131, 73));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dados do cliente:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Produto:");

        jTProduto.setEditable(false);
        jTProduto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTProdutoFocusLost(evt);
            }
        });
        jTProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProdutoMouseClicked(evt);
            }
        });
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

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Valor (R$):");

        jTValor.setEditable(false);
        jTValor.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTValorKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Preço(R$):");

        jTPreco.setEditable(false);
        jTPreco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTPreco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Dados da venda:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cliente:");

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
        jLabel13.setText("Endereço:");

        jTEndereco.setEditable(false);
        jTEndereco.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTEnderecoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTEnderecoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTEnderecoKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Quant.:");

        jTQtd.setEditable(false);
        jTQtd.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTQtd.setText("1");
        jTQtd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTQtdFocusLost(evt);
            }
        });
        jTQtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTQtdActionPerformed(evt);
            }
        });
        jTQtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTQtdKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTQtdKeyReleased(evt);
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
        jLabel15.setText("Contato 1:");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Contato 2:");

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
                                        .addComponent(jTQtd, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTProduto))
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
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTEndereco))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel14))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(jTEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jTProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(380, 380, 380))
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

    private void jTTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTTotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTotalKeyPressed

    private void jTDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTDataMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDataMouseClicked

    private void jTDataKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTDataKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTDataKeyPressed

    private void jTProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTProdutoFocusLost
     
    }//GEN-LAST:event_jTProdutoFocusLost

    private void jTProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProdutoKeyPressed

    }//GEN-LAST:event_jTProdutoKeyPressed

    private void jTProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProdutoKeyReleased
       
    }//GEN-LAST:event_jTProdutoKeyReleased

    private void jTProdutoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTProdutoKeyTyped

    }//GEN-LAST:event_jTProdutoKeyTyped

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

    private void jTEnderecoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEnderecoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEnderecoKeyPressed

    private void jTEnderecoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEnderecoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEnderecoKeyReleased

    private void jTEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTEnderecoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jTEnderecoKeyTyped

    private void jTQtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTQtdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTQtdActionPerformed

    private void jTQtdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTQtdFocusLost
        
    }//GEN-LAST:event_jTQtdFocusLost

    private void jTQtdKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTQtdKeyPressed

    }//GEN-LAST:event_jTQtdKeyPressed

    private void jTQtdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTQtdKeyReleased
       
    }//GEN-LAST:event_jTQtdKeyReleased

    private void jTVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTVendasMouseClicked
       ClicarTabela();
    }//GEN-LAST:event_jTVendasMouseClicked

    private void jTProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProdutoMouseClicked
        
    }//GEN-LAST:event_jTProdutoMouseClicked

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

    public PesquisarVendas pesqvenda;
    //metodo que recebe a instância do Form PesquisarVenda
    public void SetPesquisarVendas(PesquisarVendas pesqvenda){
        this.pesqvenda = pesqvenda;
    }
   
    //metodo para mostrar os valores nos campos quando clicar na tabela
    public void ClicarTabela(){
         if(jTVendas.getSelectedRow()!=-1){
            try {
                ProdutoDao pdao = new ProdutoDao();
                Produto p = pdao.GetProduto(vendas.get(jTVendas.getSelectedRow()).getId_p());
                jTProduto.setText(p.getProduto());
                jTPreco.setText(vendas.get(jTVendas.getSelectedRow()).getValor_p()+"");
                jTQtd.setText(vendas.get(jTVendas.getSelectedRow()).getQtd()+"");
                jTValor.setText(vendas.get(jTVendas.getSelectedRow()).getPreco()+"");
                
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao acessar o banco! \n\r ERRO:"+ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
    }
    
     //método que limpa os campos para a venda de outro produto
    public void Limpar(){
        jTPreco.setText("");
        jTProduto.setText("");
        jTQtd.setText("1");
        jTValor.setText("");
    }
    
    private void atualizarTabela(List<Entidades.Venda> venda) {

        while (tmVendas.getRowCount() > 0) {
            tmVendas.removeRow(0);
        }
       
        String[] linha = new String[]{null, null, null, null};
        for (int i = 0; i < venda.size(); i++) {
            tmVendas.addRow(linha);
            String produto="";
            String preco="";
            try {
                //Pega o produto com o id na lista da venda
                ProdutoDao dao = new ProdutoDao();
                Produto p = dao.GetProduto(venda.get(i).getId_p());
                produto = p.getProduto();
                preco = String.valueOf(p.getPreco());
            } catch (SQLException ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao acessar o banco! \n\r ERRO:"+ex, "..: SGE :..", JOptionPane.ERROR_MESSAGE);
            }
            
            tmVendas.setValueAt(produto, i, 0);
            tmVendas.setValueAt(venda.get(i).getQtd(), i, 1);
            tmVendas.setValueAt(venda.get(i).getPreco(), i, 2);
           
        }
    }
 
  
    
    //metodo para preencher o combobox dos vendedores
    public void PreencherVendedores(){
        try {
            VendedorDao a = new  VendedorDao();
            vendedores = a.getLista("");
            for(int y=0;y<vendedores.size(); y++){
                jComboBox2.addItem(vendedores.get(y).getNome());
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco! \n\r ERRO:"+ex, "SysGEM'S", JOptionPane.ERROR_MESSAGE);
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
            java.util.logging.Logger.getLogger(DetalhesVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DetalhesVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DetalhesVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DetalhesVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DetalhesVenda().setVisible(true);
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
    private javax.swing.JTextField jTCliente;
    private javax.swing.JTextField jTContato1;
    private javax.swing.JTextField jTContato2;
    private javax.swing.JTextField jTCpf;
    private javax.swing.JTextField jTData;
    private javax.swing.JTextField jTEndereco;
    private javax.swing.JTextField jTNVenda;
    private javax.swing.JTextField jTPreco;
    private javax.swing.JTextField jTProduto;
    private javax.swing.JTextField jTQtd;
    private javax.swing.JTextField jTTotal;
    private javax.swing.JTextField jTValor;
    private javax.swing.JTable jTVendas;
    // End of variables declaration//GEN-END:variables
}
