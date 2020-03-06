/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseCaixas;
import Model.ClasseRotas;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author geova
 */
public class TabelaCaixas extends javax.swing.JPanel {
    ConexaoBanco conectar = new ConexaoBanco();
    ClasseRotas rotas = new ClasseRotas();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public boolean check = false;
    
    public static double total;
    
    ClasseCaixas Entrada = new ClasseCaixas();
    String formato = "R$ 0.00";
    String form = "0.00";
    DecimalFormat df = new DecimalFormat(formato);
    DecimalFormat dt = new DecimalFormat(form);
    double valorInicial;
    double saldo;
    Date validar;
    String novaData;

    public void povoarTabela(String sql){
        
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaCaixa.getModel();
            Model.setNumRows(0);
            while(rs.next()){
                valorInicial = Double.parseDouble(rs.getString("SaldoInicial"));
                saldo = Double.parseDouble(rs.getString("Saldo"));
                Model.addRow(new Object[]{
                    check,
                    rs.getString("CodigoCaixa"),
                    rs.getString("DescricaoCaixa"),
                    df.format(valorInicial),                    
                    sdf.format(rs.getDate("DataAbertura")),
                    rs.getString("Status"),
                });
                
            }
                rs.close();
                stmt.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }
    public void povoarTabelaHistoarico(String sql){
        Connection con = null ;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            con = conectar.Conectar();
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            DefaultTableModel Model = (DefaultTableModel) TabelaHistorico.getModel();
            Model.setNumRows(0);
            while(rs.next()){
                saldo = Double.parseDouble(rs.getString("Saldo"));
                
                Model.addRow(new Object[]{
                    check,
                    rs.getString("CodigoCaixa"),
                    rs.getString("DescricaoCaixa"),
                    sdf.format(rs.getDate("DataAbertura")),
                    verificar(rs.getDate("DataFechamento")),
                    df.format(saldo),
                    rs.getString("Status"),
                    rs.getString("QuemFechou"),
                });
            }
                rs.close();
                stmt.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public String verificar(Date datafechamento){
        
        String novadata;
        if(datafechamento == null){
            novadata = "";
        }
        else{
            novadata = sdf.format(datafechamento);
        }
        
        return novadata;
    }
    
    public TabelaCaixas() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        BotaoAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaCaixa = new javax.swing.JTable();
        BotaoAbrirCaixa = new javax.swing.JButton();
        BotaoFecharcaixa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        CampoSelecionadoNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CampoPesquisa = new javax.swing.JTextField();
        CampoSelecionadoCodigo = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        CampoEntradas = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        CampoSaídas = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        CampoTotal = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaHistorico = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        BotaoAtualizar1 = new javax.swing.JButton();
        CampoPesquisa2 = new javax.swing.JTextField();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(219, 230, 244));

        jTabbedPane1.setBackground(new java.awt.Color(219, 230, 244));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(219, 230, 244));

        BotaoAtualizar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoAtualizar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BotaoAtualizar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Atualizar.png"))); // NOI18N
        BotaoAtualizar.setText("Atualizar");
        BotaoAtualizar.setBorder(null);
        BotaoAtualizar.setBorderPainted(false);
        BotaoAtualizar.setFocusPainted(false);
        BotaoAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoAtualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoAtualizarMouseExited(evt);
            }
        });
        BotaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAtualizarActionPerformed(evt);
            }
        });

        TabelaCaixa.setBackground(new java.awt.Color(255, 255, 255));
        TabelaCaixa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaCaixa.setForeground(new java.awt.Color(0, 0, 0));
        TabelaCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Descrição", "Saldo Inicial", "Data Abertura", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaCaixa.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaCaixa.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaCaixa.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TabelaCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaCaixaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaCaixa);
        if (TabelaCaixa.getColumnModel().getColumnCount() > 0) {
            TabelaCaixa.getColumnModel().getColumn(0).setMinWidth(20);
            TabelaCaixa.getColumnModel().getColumn(0).setPreferredWidth(20);
            TabelaCaixa.getColumnModel().getColumn(0).setMaxWidth(20);
            TabelaCaixa.getColumnModel().getColumn(1).setPreferredWidth(5);
            TabelaCaixa.getColumnModel().getColumn(2).setPreferredWidth(250);
            TabelaCaixa.getColumnModel().getColumn(3).setPreferredWidth(50);
            TabelaCaixa.getColumnModel().getColumn(4).setPreferredWidth(50);
            TabelaCaixa.getColumnModel().getColumn(5).setPreferredWidth(50);
        }

        BotaoAbrirCaixa.setBackground(new java.awt.Color(1, 1, 34));
        BotaoAbrirCaixa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoAbrirCaixa.setForeground(new java.awt.Color(255, 255, 255));
        BotaoAbrirCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Padlock_26px.png"))); // NOI18N
        BotaoAbrirCaixa.setText("Abrir Caixa");
        BotaoAbrirCaixa.setBorder(null);
        BotaoAbrirCaixa.setBorderPainted(false);
        BotaoAbrirCaixa.setFocusPainted(false);
        BotaoAbrirCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoAbrirCaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoAbrirCaixaMouseExited(evt);
            }
        });
        BotaoAbrirCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAbrirCaixaActionPerformed(evt);
            }
        });

        BotaoFecharcaixa.setBackground(new java.awt.Color(1, 1, 34));
        BotaoFecharcaixa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoFecharcaixa.setForeground(new java.awt.Color(255, 255, 255));
        BotaoFecharcaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Password_26px.png"))); // NOI18N
        BotaoFecharcaixa.setText("Fechar Caixa");
        BotaoFecharcaixa.setBorder(null);
        BotaoFecharcaixa.setBorderPainted(false);
        BotaoFecharcaixa.setFocusPainted(false);
        BotaoFecharcaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoFecharcaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoFecharcaixaMouseExited(evt);
            }
        });
        BotaoFecharcaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoFecharcaixaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Caixas");

        CampoSelecionadoNome.setBackground(new java.awt.Color(219, 230, 244));
        CampoSelecionadoNome.setForeground(new java.awt.Color(219, 230, 244));
        CampoSelecionadoNome.setBorder(null);
        CampoSelecionadoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoSelecionadoNomeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Localizar:");

        CampoPesquisa.setBackground(new java.awt.Color(255, 255, 255));
        CampoPesquisa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CampoPesquisa.setForeground(new java.awt.Color(0, 0, 0));
        CampoPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoPesquisaActionPerformed(evt);
            }
        });
        CampoPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoPesquisaKeyTyped(evt);
            }
        });

        CampoSelecionadoCodigo.setBackground(new java.awt.Color(219, 230, 244));
        CampoSelecionadoCodigo.setForeground(new java.awt.Color(219, 230, 244));
        CampoSelecionadoCodigo.setBorder(null);
        CampoSelecionadoCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoSelecionadoCodigoActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 2, true));

        jPanel6.setBackground(new java.awt.Color(0, 153, 0));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Total ");

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Entradas");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(14, 14, 14))
        );

        CampoEntradas.setEditable(false);
        CampoEntradas.setBackground(new java.awt.Color(255, 255, 255));
        CampoEntradas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        CampoEntradas.setForeground(new java.awt.Color(0, 153, 0));
        CampoEntradas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoEntradas.setText("0,00");
        CampoEntradas.setBorder(null);
        CampoEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoEntradasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CampoEntradas)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 2, true));

        jPanel10.setBackground(new java.awt.Color(255, 51, 51));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Total ");

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Saídas");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(14, 14, 14))
        );

        CampoSaídas.setEditable(false);
        CampoSaídas.setBackground(new java.awt.Color(255, 255, 255));
        CampoSaídas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        CampoSaídas.setForeground(new java.awt.Color(255, 51, 51));
        CampoSaídas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoSaídas.setText("0,00");
        CampoSaídas.setBorder(null);
        CampoSaídas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoSaídasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoSaídas))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CampoSaídas)
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 34), 2, true));

        jPanel12.setBackground(new java.awt.Color(1, 1, 34));

        jLabel17.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Total ");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel17)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        CampoTotal.setEditable(false);
        CampoTotal.setBackground(new java.awt.Color(255, 255, 255));
        CampoTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        CampoTotal.setForeground(new java.awt.Color(0, 0, 0));
        CampoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoTotal.setText("0,00");
        CampoTotal.setBorder(null);
        CampoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CampoTotal)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BotaoAbrirCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoFecharcaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CampoSelecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(CampoSelecionadoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(BotaoAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(CampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoAbrirCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoFecharcaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoSelecionadoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoSelecionadoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Caixas", jPanel1);

        jPanel2.setBackground(new java.awt.Color(219, 230, 244));

        TabelaHistorico.setBackground(new java.awt.Color(255, 255, 255));
        TabelaHistorico.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaHistorico.setForeground(new java.awt.Color(0, 0, 0));
        TabelaHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Descrição", "Data de Abertura", "Data de Fechamento", "Saldo", "Status ", "Quem Fechou"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaHistorico.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaHistorico.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaHistorico.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(TabelaHistorico);
        if (TabelaHistorico.getColumnModel().getColumnCount() > 0) {
            TabelaHistorico.getColumnModel().getColumn(0).setMinWidth(20);
            TabelaHistorico.getColumnModel().getColumn(0).setPreferredWidth(20);
            TabelaHistorico.getColumnModel().getColumn(0).setMaxWidth(20);
        }

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Histórico");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Localizar:");

        BotaoAtualizar1.setBackground(new java.awt.Color(1, 1, 34));
        BotaoAtualizar1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoAtualizar1.setForeground(new java.awt.Color(255, 255, 255));
        BotaoAtualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Atualizar.png"))); // NOI18N
        BotaoAtualizar1.setText("Atualizar");
        BotaoAtualizar1.setBorder(null);
        BotaoAtualizar1.setBorderPainted(false);
        BotaoAtualizar1.setFocusPainted(false);
        BotaoAtualizar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoAtualizar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoAtualizar1MouseExited(evt);
            }
        });
        BotaoAtualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAtualizar1ActionPerformed(evt);
            }
        });

        CampoPesquisa2.setBackground(new java.awt.Color(255, 255, 255));
        CampoPesquisa2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        CampoPesquisa2.setForeground(new java.awt.Color(0, 0, 0));
        CampoPesquisa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoPesquisa2ActionPerformed(evt);
            }
        });
        CampoPesquisa2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoPesquisa2KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 899, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 526, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoPesquisa2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoAtualizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel5)
                    .addComponent(BotaoAtualizar1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(CampoPesquisa2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("Histórico", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAtualizarActionPerformed
       String sql = rotas.getRTCaixa();
        povoarTabela(sql);
    }//GEN-LAST:event_BotaoAtualizarActionPerformed

    private void CampoSelecionadoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoSelecionadoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoSelecionadoNomeActionPerformed

    private void CampoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoPesquisaActionPerformed

    private void BotaoAbrirCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAbrirCaixaActionPerformed
        CadastroCaixa chamar = new CadastroCaixa(null, true);
        chamar.setVisible(true);
        String sql = rotas.getRTCaixa();
        povoarTabela(sql);
        
    }//GEN-LAST:event_BotaoAbrirCaixaActionPerformed

    private void CampoPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoPesquisaKeyTyped
       String sql = "SELECT * FROM Caixas WHERE DescricaoCaixa LIKE'%"+ CampoPesquisa.getText()+"%'";
        povoarTabela(sql);
    }//GEN-LAST:event_CampoPesquisaKeyTyped

    private void BotaoAtualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAtualizarMouseEntered
        BotaoAtualizar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoAtualizarMouseEntered

    private void BotaoAtualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAtualizarMouseExited
       BotaoAtualizar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoAtualizarMouseExited

    private void BotaoAbrirCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAbrirCaixaMouseEntered
        BotaoAbrirCaixa.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoAbrirCaixaMouseEntered

    private void BotaoAbrirCaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAbrirCaixaMouseExited
        BotaoAbrirCaixa.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoAbrirCaixaMouseExited

    private void TabelaCaixaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaCaixaMouseClicked
        int linha = TabelaCaixa.getSelectedRow();
        CampoSelecionadoCodigo.setText(TabelaCaixa.getValueAt(linha, 1).toString());
        
        Entrada.setCodigoCaixa(Integer.parseInt(CampoSelecionadoCodigo.getText()));
        
        Entrada.SomarEntradas();
        Entrada.SomarSaidas();
        Entrada.pegarsaldo();
        total = Entrada.getSomaEntradas() - Entrada.SomaDespesas + Entrada.getSaldoInicial();
        CampoTotal.setText(String.valueOf(dt.format(total)));
        CampoEntradas.setText(String.valueOf(dt.format(Entrada.getSomaEntradas())));
        CampoSaídas.setText(String.valueOf(dt.format(Entrada.getSomaDespesas())));
        
        
  
    }//GEN-LAST:event_TabelaCaixaMouseClicked

    private void CampoSelecionadoCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoSelecionadoCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoSelecionadoCodigoActionPerformed

    private void BotaoFecharcaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoFecharcaixaMouseEntered
        BotaoFecharcaixa.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoFecharcaixaMouseEntered

    private void BotaoFecharcaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoFecharcaixaMouseExited
        BotaoFecharcaixa.setBackground(new Color(1,1,34));
                
    }//GEN-LAST:event_BotaoFecharcaixaMouseExited

    private void BotaoFecharcaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFecharcaixaActionPerformed
        
        if(CampoSelecionadoCodigo.getText().equals("")){
           
            JOptionPane.showMessageDialog(null, "Nenhum caixa foi selecionado");
        }
        else{
            
            Entrada.setCodigoCaixa(Integer.parseInt(CampoSelecionadoCodigo.getText()));
            System.out.println(Entrada.getCodigoCaixa());
            FecharCaixa chamar = new FecharCaixa(null, true);
            chamar.setVisible(true);
            String sql = rotas.getRTCaixa();
            povoarTabela(sql);
            
        }
    }//GEN-LAST:event_BotaoFecharcaixaActionPerformed

    private void BotaoAtualizar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAtualizar1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoAtualizar1MouseEntered

    private void BotaoAtualizar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAtualizar1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoAtualizar1MouseExited

    private void BotaoAtualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAtualizar1ActionPerformed
        String sql = rotas.getRTCXHistorico();
        povoarTabelaHistoarico(sql);
    }//GEN-LAST:event_BotaoAtualizar1ActionPerformed

    private void CampoPesquisa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoPesquisa2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoPesquisa2ActionPerformed

    private void CampoPesquisa2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoPesquisa2KeyTyped
        String sql = "SELECT * FROM Caixas WHERE DescricaoCaixa LIKE'%"+ CampoPesquisa2.getText()+"%'";
        povoarTabela(sql);
    }//GEN-LAST:event_CampoPesquisa2KeyTyped

    private void CampoEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoEntradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoEntradasActionPerformed

    private void CampoSaídasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoSaídasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoSaídasActionPerformed

    private void CampoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoTotalActionPerformed
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAbrirCaixa;
    private javax.swing.JButton BotaoAtualizar;
    private javax.swing.JButton BotaoAtualizar1;
    private javax.swing.JButton BotaoFecharcaixa;
    private javax.swing.JTextField CampoEntradas;
    private javax.swing.JTextField CampoPesquisa;
    private javax.swing.JTextField CampoPesquisa2;
    private javax.swing.JTextField CampoSaídas;
    private javax.swing.JTextField CampoSelecionadoCodigo;
    private javax.swing.JTextField CampoSelecionadoNome;
    private javax.swing.JTextField CampoTotal;
    private javax.swing.JTable TabelaCaixa;
    private javax.swing.JTable TabelaHistorico;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
