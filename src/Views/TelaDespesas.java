
package Views;

import BancoDados.ConexaoBanco;
import Converter.Data;
import Converter.DataHora;
import Model.ClasseDespesas;
import Model.ClasseRotas;
import Model.Var.VarDespesas;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TelaDespesas extends javax.swing.JPanel {

    public static int da;
    public boolean check = false;
    
    public TelaDespesas() {
        initComponents();
    }
    ConexaoBanco conectar = new ConexaoBanco();
    VarDespesas despesas = new VarDespesas();
    ClasseRotas rotas = new ClasseRotas();
    DataHora dt = new DataHora();
    Data sd = new Data();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String formato = "R$ 0.00";
    DecimalFormat df = new DecimalFormat(formato);
    String Verificar;
    int IdCaixa;
    String Status;

    public void TabelaTodas(String sql){
        
        Connection con = conectar.Conectar();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaDespesas.getModel();
            Model.setNumRows(0);
            
            while(rs.next()){
                double valor = Double.parseDouble(rs.getString("Valor"));
                Model.addRow(new Object[]{
                    check,
                    rs.getString("ID"),
                    rs.getString("Descricao"),
                    df.format(valor),
                    verificar(rs.getDate("DataC")),
                    rs.getString("Status"),
                    rs.getString("DescricaoCaixa"),
                    rs.getString("IDCaixa"),
                });
            } 
            Pendentes();
            rs.close();
            stmt.close();
                    
        }
        catch(SQLException e){
            System.out.println(e);        
        }
            
    }
    public void TabelaPendentes(String sql){
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaPendentes.getModel();
            Model.setNumRows(0);
            
            while(rs.next()){
                double valor = Double.parseDouble(rs.getString("Valor"));
                Model.addRow(new Object[]{
                    check,
                    rs.getString("ID"),
                    rs.getString("Descricao"),
                    df.format(valor),
                    verificar(rs.getDate("DataV")),
                    rs.getString("Status"),
                    rs.getString("DescricaoCaixa"),
                    rs.getString("IDCaixa"),
                });
            } 
            Vencidas();
            rs.close();
            stmt.close();
        }
        catch(SQLException e){
                System.out.println(e);        
            }
            
    }
    public void TabelaPagas(String sql){
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaPagas.getModel();
            Model.setNumRows(0);
            
            while(rs.next()){
                double valor = Double.parseDouble(rs.getString("Valor"));
                Model.addRow(new Object[]{
                    check,
                    rs.getString("ID"),
                    rs.getString("Descricao"),
                    df.format(valor),
                    verificar(rs.getDate("DataP")),
                    rs.getString("Status"),
                    rs.getString("DescricaoCaixa"),
                    rs.getString("QuemPagou"),
                    rs.getString("IDCaixa"),
                    
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
     
    public void  Pendentes(){
        
        String p = "Pendente";

        TabelaDespesas.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected,
                                 hasFocus, row, column);
                    
                    Color c = Color.BLACK;
                    Object linha = TabelaDespesas.getValueAt(row,5);
                    
                    if(p.equals(linha.toString())){
                        c =  Color.RED;
                    }
                    label.setForeground(c);
                   return label;
            }
        });  
    }
    
    public void  Vencidas(){
        java.util.Date dt = new java.util.Date();
        

        TabelaPendentes.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected,
                                 hasFocus, row, column);
                    
                    Color c = Color.BLACK;
                    java.util.Date dtvencimento = sd.StringDate(TabelaPendentes.getValueAt(row,4).toString());
                    
                    boolean b = dtvencimento.before(dt);
                    
                    if(b == true){
                        c =  Color.RED;
                    }
                    label.setForeground(c);
                   return label;
            }
        });  
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaDespesas = new javax.swing.JTable();
        BotaoAdicionar = new javax.swing.JButton();
        BotaoEditarTodas = new javax.swing.JButton();
        BotaoExcluirDespesa = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CampoLocalizarTodas = new javax.swing.JTextField();
        CampoCodigoDespesaTodas = new javax.swing.JTextField();
        BuscarTodas = new javax.swing.JButton();
        Frente = new javax.swing.JButton();
        Atras = new javax.swing.JButton();
        CampoResultados = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelaPendentes = new javax.swing.JTable();
        BotaoPagar = new javax.swing.JButton();
        BotaoEditarPendentes = new javax.swing.JButton();
        BotaoExcluirDespesasPendentes = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        CampoLOcalizarPendentes = new javax.swing.JTextField();
        BotaoAtualizar = new javax.swing.JButton();
        CampoCodigoDespesasPendentes = new javax.swing.JTextField();
        Frente1 = new javax.swing.JButton();
        Atras1 = new javax.swing.JButton();
        CampoResultados1 = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelaPagas = new javax.swing.JTable();
        BotaoEstornar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        CampoLocalizarPagas = new javax.swing.JTextField();
        BotaoAtualizarPagas = new javax.swing.JButton();
        CampoCodigoDespesasPagas = new javax.swing.JTextField();
        Frente2 = new javax.swing.JButton();
        Atras2 = new javax.swing.JButton();
        CampoResultados2 = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(219, 230, 244));

        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(219, 230, 244));

        TabelaDespesas.setBackground(new java.awt.Color(255, 255, 255));
        TabelaDespesas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaDespesas.setForeground(new java.awt.Color(0, 0, 0));
        TabelaDespesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Descrição", "Valor", "Data de Cadastro", "Status", "Caixas", ""
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
        TabelaDespesas.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaDespesas.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaDespesas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TabelaDespesas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaDespesasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaDespesas);
        if (TabelaDespesas.getColumnModel().getColumnCount() > 0) {
            TabelaDespesas.getColumnModel().getColumn(0).setMinWidth(20);
            TabelaDespesas.getColumnModel().getColumn(0).setPreferredWidth(20);
            TabelaDespesas.getColumnModel().getColumn(0).setMaxWidth(20);
            TabelaDespesas.getColumnModel().getColumn(1).setPreferredWidth(1);
            TabelaDespesas.getColumnModel().getColumn(2).setPreferredWidth(200);
            TabelaDespesas.getColumnModel().getColumn(3).setPreferredWidth(25);
            TabelaDespesas.getColumnModel().getColumn(4).setPreferredWidth(25);
            TabelaDespesas.getColumnModel().getColumn(5).setPreferredWidth(50);
            TabelaDespesas.getColumnModel().getColumn(6).setPreferredWidth(100);
            TabelaDespesas.getColumnModel().getColumn(7).setMinWidth(0);
            TabelaDespesas.getColumnModel().getColumn(7).setPreferredWidth(0);
            TabelaDespesas.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        BotaoAdicionar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoAdicionar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Plus_Math_26px.png"))); // NOI18N
        BotaoAdicionar.setText("Adicionar");
        BotaoAdicionar.setBorder(null);
        BotaoAdicionar.setBorderPainted(false);
        BotaoAdicionar.setFocusPainted(false);
        BotaoAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoAdicionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoAdicionarMouseExited(evt);
            }
        });
        BotaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAdicionarActionPerformed(evt);
            }
        });

        BotaoEditarTodas.setBackground(new java.awt.Color(1, 1, 34));
        BotaoEditarTodas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoEditarTodas.setForeground(new java.awt.Color(255, 255, 255));
        BotaoEditarTodas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.png"))); // NOI18N
        BotaoEditarTodas.setText("Editar");
        BotaoEditarTodas.setBorder(null);
        BotaoEditarTodas.setBorderPainted(false);
        BotaoEditarTodas.setFocusPainted(false);
        BotaoEditarTodas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoEditarTodasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoEditarTodasMouseExited(evt);
            }
        });
        BotaoEditarTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarTodasActionPerformed(evt);
            }
        });

        BotaoExcluirDespesa.setBackground(new java.awt.Color(1, 1, 34));
        BotaoExcluirDespesa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoExcluirDespesa.setForeground(new java.awt.Color(255, 255, 255));
        BotaoExcluirDespesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        BotaoExcluirDespesa.setText("Excluir");
        BotaoExcluirDespesa.setBorder(null);
        BotaoExcluirDespesa.setBorderPainted(false);
        BotaoExcluirDespesa.setFocusPainted(false);
        BotaoExcluirDespesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoExcluirDespesaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoExcluirDespesaMouseExited(evt);
            }
        });
        BotaoExcluirDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirDespesaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Despesas");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Localizar:");

        CampoLocalizarTodas.setBackground(new java.awt.Color(255, 255, 255));
        CampoLocalizarTodas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoLocalizarTodas.setForeground(new java.awt.Color(0, 0, 0));
        CampoLocalizarTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoLocalizarTodasActionPerformed(evt);
            }
        });
        CampoLocalizarTodas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoLocalizarTodasKeyTyped(evt);
            }
        });

        CampoCodigoDespesaTodas.setBackground(new java.awt.Color(219, 230, 244));
        CampoCodigoDespesaTodas.setForeground(new java.awt.Color(219, 230, 244));
        CampoCodigoDespesaTodas.setBorder(null);
        CampoCodigoDespesaTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCodigoDespesaTodasActionPerformed(evt);
            }
        });

        BuscarTodas.setBackground(new java.awt.Color(1, 1, 34));
        BuscarTodas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BuscarTodas.setForeground(new java.awt.Color(255, 255, 255));
        BuscarTodas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Atualizar.png"))); // NOI18N
        BuscarTodas.setText("Atualizar");
        BuscarTodas.setBorder(null);
        BuscarTodas.setBorderPainted(false);
        BuscarTodas.setFocusPainted(false);
        BuscarTodas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BuscarTodasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BuscarTodasMouseExited(evt);
            }
        });
        BuscarTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarTodasActionPerformed(evt);
            }
        });

        Frente.setBackground(new java.awt.Color(1, 1, 34));
        Frente.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        Frente.setForeground(new java.awt.Color(255, 255, 255));
        Frente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Chevron_Right_15px.png"))); // NOI18N
        Frente.setBorder(null);
        Frente.setBorderPainted(false);
        Frente.setFocusPainted(false);
        Frente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FrenteBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FrenteBuscarMouseExited(evt);
            }
        });
        Frente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FrenteBuscarActionPerformed(evt);
            }
        });

        Atras.setBackground(new java.awt.Color(1, 1, 34));
        Atras.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        Atras.setForeground(new java.awt.Color(255, 255, 255));
        Atras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Back_15px.png"))); // NOI18N
        Atras.setBorder(null);
        Atras.setBorderPainted(false);
        Atras.setFocusPainted(false);
        Atras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AtrasBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AtrasBuscarMouseExited(evt);
            }
        });
        Atras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtrasBuscarActionPerformed(evt);
            }
        });

        CampoResultados.setEditable(false);
        CampoResultados.setBackground(new java.awt.Color(219, 230, 244));
        CampoResultados.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoResultados.setForeground(new java.awt.Color(0, 0, 0));
        CampoResultados.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        CampoResultados.setText("sdfsdf");
        CampoResultados.setToolTipText("");
        CampoResultados.setBorder(null);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(BotaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoEditarTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoExcluirDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCodigoDespesaTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CampoResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Frente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 338, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoLocalizarTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscarTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CampoLocalizarTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoCodigoDespesaTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoExcluirDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoEditarTodas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CampoResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Atras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Frente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 835, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 544, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Todas as Despesas", jPanel8);
        jPanel8.getAccessibleContext().setAccessibleParent(jPanel8);

        jPanel15.setBackground(new java.awt.Color(219, 230, 244));

        TabelaPendentes.setBackground(new java.awt.Color(255, 255, 255));
        TabelaPendentes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaPendentes.setForeground(new java.awt.Color(0, 0, 0));
        TabelaPendentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Descrição", "Valor", "Data de Vencimento", "Status", "Caiixa", ""
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
        TabelaPendentes.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaPendentes.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaPendentes.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TabelaPendentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaPendentesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TabelaPendentes);
        if (TabelaPendentes.getColumnModel().getColumnCount() > 0) {
            TabelaPendentes.getColumnModel().getColumn(0).setMinWidth(20);
            TabelaPendentes.getColumnModel().getColumn(0).setPreferredWidth(20);
            TabelaPendentes.getColumnModel().getColumn(0).setMaxWidth(20);
            TabelaPendentes.getColumnModel().getColumn(1).setPreferredWidth(1);
            TabelaPendentes.getColumnModel().getColumn(2).setPreferredWidth(200);
            TabelaPendentes.getColumnModel().getColumn(3).setPreferredWidth(25);
            TabelaPendentes.getColumnModel().getColumn(4).setPreferredWidth(25);
            TabelaPendentes.getColumnModel().getColumn(5).setPreferredWidth(50);
            TabelaPendentes.getColumnModel().getColumn(6).setPreferredWidth(50);
            TabelaPendentes.getColumnModel().getColumn(7).setMinWidth(0);
            TabelaPendentes.getColumnModel().getColumn(7).setPreferredWidth(0);
            TabelaPendentes.getColumnModel().getColumn(7).setMaxWidth(0);
        }

        BotaoPagar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoPagar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoPagar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Donate_26px.png"))); // NOI18N
        BotaoPagar.setText("Pagar");
        BotaoPagar.setBorder(null);
        BotaoPagar.setBorderPainted(false);
        BotaoPagar.setFocusPainted(false);
        BotaoPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoPagarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoPagarMouseExited(evt);
            }
        });
        BotaoPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoPagarActionPerformed(evt);
            }
        });

        BotaoEditarPendentes.setBackground(new java.awt.Color(1, 1, 34));
        BotaoEditarPendentes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoEditarPendentes.setForeground(new java.awt.Color(255, 255, 255));
        BotaoEditarPendentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.png"))); // NOI18N
        BotaoEditarPendentes.setText("Editar");
        BotaoEditarPendentes.setBorder(null);
        BotaoEditarPendentes.setBorderPainted(false);
        BotaoEditarPendentes.setFocusPainted(false);
        BotaoEditarPendentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoEditarPendentesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoEditarPendentesMouseExited(evt);
            }
        });
        BotaoEditarPendentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarPendentesActionPerformed(evt);
            }
        });

        BotaoExcluirDespesasPendentes.setBackground(new java.awt.Color(1, 1, 34));
        BotaoExcluirDespesasPendentes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoExcluirDespesasPendentes.setForeground(new java.awt.Color(255, 255, 255));
        BotaoExcluirDespesasPendentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        BotaoExcluirDespesasPendentes.setText("Excluir");
        BotaoExcluirDespesasPendentes.setBorder(null);
        BotaoExcluirDespesasPendentes.setBorderPainted(false);
        BotaoExcluirDespesasPendentes.setFocusPainted(false);
        BotaoExcluirDespesasPendentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoExcluirDespesasPendentesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoExcluirDespesasPendentesMouseExited(evt);
            }
        });
        BotaoExcluirDespesasPendentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirDespesasPendentesActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Despesas Pendentes");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Localizar:");

        CampoLOcalizarPendentes.setBackground(new java.awt.Color(255, 255, 255));
        CampoLOcalizarPendentes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoLOcalizarPendentes.setForeground(new java.awt.Color(0, 0, 0));
        CampoLOcalizarPendentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoLOcalizarPendentesActionPerformed(evt);
            }
        });
        CampoLOcalizarPendentes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoLOcalizarPendentesKeyTyped(evt);
            }
        });

        BotaoAtualizar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoAtualizar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
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

        CampoCodigoDespesasPendentes.setBackground(new java.awt.Color(219, 230, 244));
        CampoCodigoDespesasPendentes.setForeground(new java.awt.Color(219, 230, 244));
        CampoCodigoDespesasPendentes.setBorder(null);

        Frente1.setBackground(new java.awt.Color(1, 1, 34));
        Frente1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        Frente1.setForeground(new java.awt.Color(255, 255, 255));
        Frente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Chevron_Right_15px.png"))); // NOI18N
        Frente1.setBorder(null);
        Frente1.setBorderPainted(false);
        Frente1.setFocusPainted(false);
        Frente1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Frente1BuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Frente1BuscarMouseExited(evt);
            }
        });
        Frente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Frente1BuscarActionPerformed(evt);
            }
        });

        Atras1.setBackground(new java.awt.Color(1, 1, 34));
        Atras1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        Atras1.setForeground(new java.awt.Color(255, 255, 255));
        Atras1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Back_15px.png"))); // NOI18N
        Atras1.setBorder(null);
        Atras1.setBorderPainted(false);
        Atras1.setFocusPainted(false);
        Atras1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Atras1BuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Atras1BuscarMouseExited(evt);
            }
        });
        Atras1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Atras1BuscarActionPerformed(evt);
            }
        });

        CampoResultados1.setEditable(false);
        CampoResultados1.setBackground(new java.awt.Color(219, 230, 244));
        CampoResultados1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoResultados1.setForeground(new java.awt.Color(0, 0, 0));
        CampoResultados1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        CampoResultados1.setText("sdfsdf");
        CampoResultados1.setToolTipText("");
        CampoResultados1.setBorder(null);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(BotaoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoEditarPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoExcluirDespesasPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCodigoDespesasPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CampoResultados1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(Atras1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Frente1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoLOcalizarPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(CampoLOcalizarPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BotaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoExcluirDespesasPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoEditarPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoCodigoDespesasPendentes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CampoResultados1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Atras1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Frente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Todas as Despesas Pendentes", jPanel14);

        jPanel17.setBackground(new java.awt.Color(219, 230, 244));

        TabelaPagas.setBackground(new java.awt.Color(255, 255, 255));
        TabelaPagas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaPagas.setForeground(new java.awt.Color(0, 0, 0));
        TabelaPagas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Descrição", "Valor", "Data Pagamento", "Status", "Caixa", "Quem Pagou", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaPagas.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaPagas.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaPagas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TabelaPagas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaPagasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TabelaPagas);
        if (TabelaPagas.getColumnModel().getColumnCount() > 0) {
            TabelaPagas.getColumnModel().getColumn(0).setMinWidth(20);
            TabelaPagas.getColumnModel().getColumn(0).setPreferredWidth(20);
            TabelaPagas.getColumnModel().getColumn(0).setMaxWidth(20);
            TabelaPagas.getColumnModel().getColumn(1).setPreferredWidth(1);
            TabelaPagas.getColumnModel().getColumn(2).setPreferredWidth(200);
            TabelaPagas.getColumnModel().getColumn(3).setPreferredWidth(25);
            TabelaPagas.getColumnModel().getColumn(4).setPreferredWidth(25);
            TabelaPagas.getColumnModel().getColumn(5).setPreferredWidth(50);
            TabelaPagas.getColumnModel().getColumn(6).setPreferredWidth(50);
            TabelaPagas.getColumnModel().getColumn(7).setPreferredWidth(50);
            TabelaPagas.getColumnModel().getColumn(8).setMinWidth(0);
            TabelaPagas.getColumnModel().getColumn(8).setPreferredWidth(0);
            TabelaPagas.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        BotaoEstornar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoEstornar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoEstornar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoEstornar.setText("Estornar");
        BotaoEstornar.setBorder(null);
        BotaoEstornar.setBorderPainted(false);
        BotaoEstornar.setFocusPainted(false);
        BotaoEstornar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoEstornarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoEstornarMouseExited(evt);
            }
        });
        BotaoEstornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEstornarActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Despesas Pagas");

        jLabel18.setBackground(new java.awt.Color(0, 0, 0));
        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Localizar:");

        CampoLocalizarPagas.setBackground(new java.awt.Color(255, 255, 255));
        CampoLocalizarPagas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoLocalizarPagas.setForeground(new java.awt.Color(0, 0, 0));
        CampoLocalizarPagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoLocalizarPagasActionPerformed(evt);
            }
        });
        CampoLocalizarPagas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoLocalizarPagasKeyTyped(evt);
            }
        });

        BotaoAtualizarPagas.setBackground(new java.awt.Color(1, 1, 34));
        BotaoAtualizarPagas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoAtualizarPagas.setForeground(new java.awt.Color(255, 255, 255));
        BotaoAtualizarPagas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Atualizar.png"))); // NOI18N
        BotaoAtualizarPagas.setText("Atualizar");
        BotaoAtualizarPagas.setBorder(null);
        BotaoAtualizarPagas.setBorderPainted(false);
        BotaoAtualizarPagas.setFocusPainted(false);
        BotaoAtualizarPagas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoAtualizarPagasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoAtualizarPagasMouseExited(evt);
            }
        });
        BotaoAtualizarPagas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAtualizarPagasActionPerformed(evt);
            }
        });

        CampoCodigoDespesasPagas.setBackground(new java.awt.Color(219, 230, 244));
        CampoCodigoDespesasPagas.setForeground(new java.awt.Color(219, 230, 244));
        CampoCodigoDespesasPagas.setBorder(null);

        Frente2.setBackground(new java.awt.Color(1, 1, 34));
        Frente2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        Frente2.setForeground(new java.awt.Color(255, 255, 255));
        Frente2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Chevron_Right_15px.png"))); // NOI18N
        Frente2.setBorder(null);
        Frente2.setBorderPainted(false);
        Frente2.setFocusPainted(false);
        Frente2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Frente2BuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Frente2BuscarMouseExited(evt);
            }
        });
        Frente2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Frente2BuscarActionPerformed(evt);
            }
        });

        Atras2.setBackground(new java.awt.Color(1, 1, 34));
        Atras2.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        Atras2.setForeground(new java.awt.Color(255, 255, 255));
        Atras2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Back_15px.png"))); // NOI18N
        Atras2.setBorder(null);
        Atras2.setBorderPainted(false);
        Atras2.setFocusPainted(false);
        Atras2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Atras2BuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Atras2BuscarMouseExited(evt);
            }
        });
        Atras2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Atras2BuscarActionPerformed(evt);
            }
        });

        CampoResultados2.setEditable(false);
        CampoResultados2.setBackground(new java.awt.Color(219, 230, 244));
        CampoResultados2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoResultados2.setForeground(new java.awt.Color(0, 0, 0));
        CampoResultados2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        CampoResultados2.setText("sdfsdf");
        CampoResultados2.setToolTipText("");
        CampoResultados2.setBorder(null);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 261, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoLocalizarPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoAtualizarPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(BotaoEstornar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CampoCodigoDespesasPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoResultados2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(Atras2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Frente2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoAtualizarPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoLocalizarPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoEstornar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoCodigoDespesasPagas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CampoResultados2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Atras2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Frente2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Todas as Despesas Pagas", jPanel16);

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

    private void CampoLocalizarPagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoLocalizarPagasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoLocalizarPagasActionPerformed

    private void CampoLOcalizarPendentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoLOcalizarPendentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoLOcalizarPendentesActionPerformed

    private void BotaoEditarPendentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarPendentesActionPerformed
        if(CampoCodigoDespesaTodas.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor selecione uma linha");
        }
        else{
            Verificar();
            if(Verificar.equals("Caixa Fechado")){
                JOptionPane.showMessageDialog(null, "Não é possível alterar uma despesa que está relacionada a um caixa que já foi fechado");
            }
            else{
                if(Status.equals("Paga")){
                    JOptionPane.showMessageDialog(null, "Para Editar é Preciso estornar a despesa");
                }
                else{
                    despesas.setID(Integer.parseInt(CampoCodigoDespesaTodas.getText()));
                    CadastroDespesa pv = new CadastroDespesa(null, true);
                    pv.Povoar();
                    pv.setVisible(true);
                    String sql = rotas.getRTDespesasPendentes();
                    TabelaPendentes(sql);
                }
            }
        }
    }//GEN-LAST:event_BotaoEditarPendentesActionPerformed

    private void BotaoPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPagarActionPerformed
        if(CampoCodigoDespesasPendentes.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor selecione uma linha");
        }
        else{
            Verificar();
            if(Verificar.equals("Caixa Fechado")){
                JOptionPane.showMessageDialog(null, "O Caixa Vinculado a esta despesa está fechado, para que seja possível pagar é necessário alterar o caixa da despesa");
            }
            else{
            
                despesas.setID(Integer.parseInt(CampoCodigoDespesasPendentes.getText()));
                PagarDespesa pagar = new PagarDespesa(null, true);
                pagar.povoar();
                pagar.setVisible(true);
                TabelaTodas(rotas.getRTDespesasTodas());
                TabelaPendentes(rotas.getRTDespesasPendentes());
                TabelaPagas(rotas.getRTDespesasPagas());
            }
        }
    }//GEN-LAST:event_BotaoPagarActionPerformed

    private void CampoLocalizarTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoLocalizarTodasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoLocalizarTodasActionPerformed

    private void BotaoEditarTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarTodasActionPerformed
        if(CampoCodigoDespesaTodas.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor selecione uma linha");
        }
        else{
 
            if(Status.equals("Paga")){
                JOptionPane.showMessageDialog(null, "Para Editar é Preciso estornar a despesa");
            }
            else{
                despesas.setID(Integer.parseInt(CampoCodigoDespesaTodas.getText()));
                CadastroDespesa pv = new CadastroDespesa(null, true);
                da = 1;
                pv.Povoar();
                pv.setVisible(true);
                String sql = rotas.getRTDespesasTodas();
                TabelaTodas(sql);
            } 
        }
    }//GEN-LAST:event_BotaoEditarTodasActionPerformed

    private void BotaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAdicionarActionPerformed
        CadastroDespesa chamar = new CadastroDespesa(null, true);
        da = 0;
        chamar.setVisible(true);
        TabelaTodas(rotas.getRTDespesasTodas());
        TabelaPendentes(rotas.getRTDespesasPendentes());
        TabelaPagas(rotas.getRTDespesasPagas());
    }//GEN-LAST:event_BotaoAdicionarActionPerformed

    private void CampoCodigoDespesaTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCodigoDespesaTodasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCodigoDespesaTodasActionPerformed

    private void BotaoExcluirDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirDespesaActionPerformed
        if(CampoCodigoDespesaTodas.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor selecione uma linha");
        }
        else{

            if(Status.equals("Paga")){
                JOptionPane.showMessageDialog(null, "Para excluir é Preciso estornar a despesa");
            }
            else{
                UIManager.put("OptionPane.noButtonText", "Não"); 
                UIManager.put("OptionPane.yesButtonText", "Sim");
                switch(showConfirmDialog(null, "Deseja Realmente Excluir?","Confirma Exclusão",JOptionPane.YES_NO_OPTION)){
                
                    case 0:
                        despesas.setID(Integer.parseInt(CampoCodigoDespesaTodas.getText()));
                        ClasseDespesas excluir = new ClasseDespesas();
                        excluir.ExcluirDespesa();
                        TabelaTodas(rotas.getRTDespesasTodas());
                        TabelaPendentes(rotas.getRTDespesasPendentes());
                        TabelaPagas(rotas.getRTDespesasPagas());
                    break;

                    case 1:
                    break;       
                }   
            }
        }
    }//GEN-LAST:event_BotaoExcluirDespesaActionPerformed

    private void BotaoExcluirDespesasPendentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirDespesasPendentesActionPerformed
        if(CampoCodigoDespesaTodas.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor selecione uma linha");
        }
        else{
            
            if(Status.equals("Paga")){
                JOptionPane.showMessageDialog(null, "Para excluir é Preciso estornar a despesa");
            }
            else{
                UIManager.put("OptionPane.noButtonText", "Não"); 
                UIManager.put("OptionPane.yesButtonText", "Sim");
                switch(showConfirmDialog(null, "Deseja Realmente Excluir?","Confirma Exclusão",JOptionPane.YES_NO_OPTION)){
                
                    case 0:
                        despesas.setID(Integer.parseInt(CampoCodigoDespesaTodas.getText()));
                        ClasseDespesas excluir = new ClasseDespesas();
                        excluir.ExcluirDespesa();
                        TabelaTodas(rotas.getRTDespesasTodas());
                        TabelaPendentes(rotas.getRTDespesasPendentes());
                        TabelaPagas(rotas.getRTDespesasPagas());
                    break;

                    case 1:
                    break;       
                }
                
            }  
        }
    }//GEN-LAST:event_BotaoExcluirDespesasPendentesActionPerformed

    public void Verificar(){

       String sql = "SELECT Status FROM Caixas WHERE  codigocaixa  = "+IdCaixa;
       Connection con = conectar.Conectar();
       PreparedStatement stmt = null;
       ResultSet rs = null;
        

        try{
            
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();
            Verificar = rs.getString("Status");
            rs.close();
            stmt.close();

        }
        catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Ops ocorreu um erro ao preencher os campos, por favor verifique -> " +e);
        }   
        
        
    }
    private void BotaoAdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAdicionarMouseEntered
        BotaoAdicionar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoAdicionarMouseEntered

    private void BotaoAdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAdicionarMouseExited
        BotaoAdicionar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoAdicionarMouseExited

    private void BotaoEditarTodasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarTodasMouseEntered
        BotaoEditarTodas.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoEditarTodasMouseEntered

    private void BotaoEditarTodasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarTodasMouseExited
        BotaoEditarTodas.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoEditarTodasMouseExited

    private void BotaoExcluirDespesaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoExcluirDespesaMouseEntered
        BotaoExcluirDespesa.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoExcluirDespesaMouseEntered

    private void BotaoExcluirDespesaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoExcluirDespesaMouseExited
        BotaoExcluirDespesa.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoExcluirDespesaMouseExited

    private void BuscarTodasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarTodasMouseEntered
        BuscarTodas.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BuscarTodasMouseEntered

    private void BuscarTodasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarTodasMouseExited
        BuscarTodas.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BuscarTodasMouseExited

    private void BuscarTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarTodasActionPerformed
        String sql = rotas.getRTDespesasTodas();
        TabelaTodas(sql);
        
    }//GEN-LAST:event_BuscarTodasActionPerformed

    private void CampoLocalizarTodasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoLocalizarTodasKeyTyped
        String sql = "SELECT * FROM Despesas WHERE DescricaoDespesa  LIKE'%"+CampoLocalizarTodas.getText()+"%'";
        TabelaTodas(sql);
    }//GEN-LAST:event_CampoLocalizarTodasKeyTyped

    private void BotaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAtualizarActionPerformed
        String sql = rotas.getRTDespesasPendentes();
        TabelaPendentes(sql);
    }//GEN-LAST:event_BotaoAtualizarActionPerformed

    private void CampoLOcalizarPendentesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoLOcalizarPendentesKeyTyped
        String sql = "SELECT * FROM Despesas WHERE DescricaoDespesa  LIKE'%"+CampoLOcalizarPendentes.getText()+"%'";
        TabelaTodas(sql);
    }//GEN-LAST:event_CampoLOcalizarPendentesKeyTyped

    private void CampoLocalizarPagasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoLocalizarPagasKeyTyped
        String sql = "SELECT * FROM Despesas WHERE DescricaoDespesa  LIKE'%"+CampoLocalizarPagas.getText()+"%'";
        TabelaTodas(sql);
    }//GEN-LAST:event_CampoLocalizarPagasKeyTyped

    private void BotaoAtualizarPagasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAtualizarPagasActionPerformed
        String sql = rotas.getRTDespesasPagas();
        TabelaPagas(sql);
    }//GEN-LAST:event_BotaoAtualizarPagasActionPerformed

    private void TabelaPagasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaPagasMouseClicked
        int linha = TabelaPagas.getSelectedRow();
        
        CampoCodigoDespesasPagas.setText(TabelaPagas.getValueAt(linha, 1).toString());
        
        IdCaixa = Integer.parseInt(TabelaPagas.getValueAt(linha, 8).toString());
        Status = TabelaPagas.getValueAt(linha, 5).toString();  
    }//GEN-LAST:event_TabelaPagasMouseClicked

    private void TabelaDespesasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaDespesasMouseClicked
        int linha = TabelaDespesas.getSelectedRow();
        
        
        CampoCodigoDespesaTodas.setText(TabelaDespesas.getValueAt(linha, 1).toString());
       
        IdCaixa = Integer.parseInt(TabelaDespesas.getValueAt(linha, 7).toString());
        Status = TabelaDespesas.getValueAt(linha, 5).toString();
       
        if(evt.getClickCount() == 2){
            
            if(Status.equals("Paga")){
                despesas.setID(Integer.parseInt(CampoCodigoDespesaTodas.getText()));
                CadastroDespesa pv = new CadastroDespesa(null, true);
                da = 2;
                pv.setVisible(true);
            }
            else{
                despesas.setID(Integer.parseInt(CampoCodigoDespesaTodas.getText()));
                CadastroDespesa pv = new CadastroDespesa(null, true);
                da = 1;
                pv.setVisible(true);
                TabelaTodas(rotas.getRTDespesasTodas());
                TabelaPendentes(rotas.getRTDespesasPendentes());
                
            } 
            
        }
    }//GEN-LAST:event_TabelaDespesasMouseClicked

    private void TabelaPendentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaPendentesMouseClicked
        int linha = TabelaPendentes.getSelectedRow();
        
        CampoCodigoDespesasPendentes.setText(TabelaPendentes.getValueAt(linha, 1).toString());
       
        IdCaixa = Integer.parseInt(TabelaPendentes.getValueAt(linha, 7).toString());
        Status = TabelaPendentes.getValueAt(linha, 5).toString();
        
        if(evt.getClickCount() == 2){
            despesas.setID(Integer.parseInt(CampoCodigoDespesasPendentes.getText()));
            CadastroDespesa pv = new CadastroDespesa(null, true);
            pv.Povoar();
            pv.setVisible(true);
            TabelaTodas(rotas.getRTDespesasTodas());
            TabelaPendentes(rotas.getRTDespesasPendentes());
            TabelaPagas(rotas.getRTDespesasPagas());
        }
    }//GEN-LAST:event_TabelaPendentesMouseClicked

    private void BotaoEditarPendentesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarPendentesMouseEntered
        BotaoEditarPendentes.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoEditarPendentesMouseEntered

    private void BotaoEditarPendentesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarPendentesMouseExited
        BotaoEditarPendentes.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoEditarPendentesMouseExited

    private void BotaoExcluirDespesasPendentesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoExcluirDespesasPendentesMouseEntered
        BotaoExcluirDespesasPendentes.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoExcluirDespesasPendentesMouseEntered

    private void BotaoExcluirDespesasPendentesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoExcluirDespesasPendentesMouseExited
        BotaoExcluirDespesasPendentes.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoExcluirDespesasPendentesMouseExited

    private void BotaoPagarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPagarMouseEntered
        BotaoPagar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoPagarMouseEntered

    private void BotaoPagarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPagarMouseExited
        BotaoPagar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoPagarMouseExited

    private void BotaoAtualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAtualizarMouseEntered
        BotaoAtualizar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoAtualizarMouseEntered

    private void BotaoAtualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAtualizarMouseExited
        BotaoAtualizar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoAtualizarMouseExited

    private void BotaoAtualizarPagasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAtualizarPagasMouseEntered
        BotaoAtualizarPagas.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoAtualizarPagasMouseEntered

    private void BotaoAtualizarPagasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAtualizarPagasMouseExited
        BotaoAtualizarPagas.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoAtualizarPagasMouseExited

    private void BotaoEstornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEstornarActionPerformed
        
       if(CampoCodigoDespesasPagas.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor selecione uma linha");
        }
        else{
            Verificar();
            if(Verificar.equals("Caixa Fechado")){
                JOptionPane.showMessageDialog(null, "O Caixa Vinculado a esta despesa está fechado, não será mais possível estornar");
            }
            else{
                ClasseDespesas post = new ClasseDespesas();
                despesas.setID(Integer.parseInt(CampoCodigoDespesasPagas.getText()));
                String sql = "UPDATE Duplicatas SET  Status = ?, datap = ? WHERE ID =" + despesas.getID();
                despesas.setStatus("Pendente");
                post.Estornar(sql);
                TabelaTodas(rotas.getRTDespesasTodas());
                TabelaPendentes(rotas.getRTDespesasPendentes());
                TabelaPagas(rotas.getRTDespesasPagas());
            }
        }
   
    }//GEN-LAST:event_BotaoEstornarActionPerformed

    private void BotaoEstornarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEstornarMouseEntered
        BotaoEstornar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoEstornarMouseEntered

    private void BotaoEstornarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEstornarMouseExited
        BotaoEstornar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoEstornarMouseExited

    private void FrenteBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrenteBuscarMouseEntered
        Frente.setBackground(new Color(219, 230, 244));
    }//GEN-LAST:event_FrenteBuscarMouseEntered

    private void FrenteBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrenteBuscarMouseExited
        Frente.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_FrenteBuscarMouseExited

    private void FrenteBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrenteBuscarActionPerformed

        Frente();
    }//GEN-LAST:event_FrenteBuscarActionPerformed

    private void AtrasBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtrasBuscarMouseEntered
        Atras.setBackground(new Color(219, 230, 244));
    }//GEN-LAST:event_AtrasBuscarMouseEntered

    private void AtrasBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtrasBuscarMouseExited
        Atras.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_AtrasBuscarMouseExited

    private void AtrasBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasBuscarActionPerformed

        Atras();
    }//GEN-LAST:event_AtrasBuscarActionPerformed

    private void Frente1BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Frente1BuscarMouseEntered
        Frente1.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_Frente1BuscarMouseEntered

    private void Frente1BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Frente1BuscarMouseExited
        Frente1.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_Frente1BuscarMouseExited

    private void Frente1BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Frente1BuscarActionPerformed
        FrentePendente();
    }//GEN-LAST:event_Frente1BuscarActionPerformed

    private void Atras1BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Atras1BuscarMouseEntered
        Atras1.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_Atras1BuscarMouseEntered

    private void Atras1BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Atras1BuscarMouseExited
        Atras1.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_Atras1BuscarMouseExited

    private void Atras1BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Atras1BuscarActionPerformed
        AtrasPendente();
    }//GEN-LAST:event_Atras1BuscarActionPerformed

    private void Frente2BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Frente2BuscarMouseEntered
        Frente2.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_Frente2BuscarMouseEntered

    private void Frente2BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Frente2BuscarMouseExited
        Frente2.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_Frente2BuscarMouseExited

    private void Frente2BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Frente2BuscarActionPerformed
        FrentePagas();
    }//GEN-LAST:event_Frente2BuscarActionPerformed

    private void Atras2BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Atras2BuscarMouseEntered
        Atras2.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_Atras2BuscarMouseEntered

    private void Atras2BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Atras2BuscarMouseExited
        Atras2.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_Atras2BuscarMouseExited

    private void Atras2BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Atras2BuscarActionPerformed
        AtrasPagas();
    }//GEN-LAST:event_Atras2BuscarActionPerformed
    
    // inicio da Tabela Todas As despesas
    public int primeiro;
    public int ultimo;
    int Maximo;
    int Minimo;

    public void Frente(){
         
        String sql = "SELECT id, Duplicatas.descricao,valor, datac, Duplicatas.status,Caixas.descricaocaixa,IDCaixa\n" +
                        "FROM duplicatas\n" +
                        "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                        "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                        "WHERE Tipo =  1 AND ID < "+ultimo+"\n" +
                        "ORDER BY ID DESC limit 15";
                                    
        TabelaTodas(sql);
        paginacaoTodas();
    }
    
    public void Atras(){

        String sql = "SELECT id, Duplicatas.descricao,valor, datac, Duplicatas.status,Caixas.descricaocaixa,IDCaixa\n" +
                        "FROM duplicatas\n" +
                        "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                        "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                        "WHERE Tipo =  1 AND ID > "+primeiro+"\n" +
                        "ORDER BY ID DESC limit 15";
        TabelaTodas(sql);
        paginacaoTodas();
    }
    
    public void paginacaoTodas(){
        
        if(Maximo == 0 ){
            Atras.setEnabled(false);
            Frente.setEnabled(false);
            CampoResultados.setText("Mostrando resultados de: 0 á 0 ");
        }
        else{
            int rows = TabelaDespesas.getRowCount();
            primeiro = Integer.parseInt(TabelaDespesas.getValueAt(0,1).toString());
            ultimo = Integer.parseInt(TabelaDespesas.getValueAt(rows-1,1).toString());
            CampoResultados.setText("Mostrando resultados de: "+ primeiro +" a " + ultimo);

            if(primeiro == Maximo && ultimo != Minimo ){
                Atras.setEnabled(false);
                Frente.setEnabled(true);
            }
            else if(ultimo == Minimo && primeiro != Maximo){
                Atras.setEnabled(true);
                Frente.setEnabled(false);
            }
            else if(primeiro == Maximo && ultimo == Minimo){
                Atras.setEnabled(false);
                Frente.setEnabled(false);
            }
        }  
    }

    public void MinimoMaximoTodas() {
        String sql = "Select Max(ID),min(ID) from Duplicatas WHERE Tipo = 1";
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();
            
            Maximo = rs.getInt("max");
            Minimo = rs.getInt("Min");

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }// fim da Tabela Todas as Despesas
    
    //Inicio de Todas as Pendentes
    
    public int primeiroPendente;
    public int ultimoPendente;
    int MaximoPendente;
    int MinimoPendente;
    
    public void FrentePendente(){
         
        
        String sql = "SELECT id, Duplicatas.descricao,valor, dataV, Duplicatas.status,Caixas.descricaocaixa,IDCaixa\n" +
                        "FROM duplicatas\n" +
                        "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                        "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                        "WHERE Tipo =  1 AND ID < "+ultimoPendente+"\n" +
                        "ORDER BY ID DESC limit 15";
        TabelaPendentes(sql);
        paginacaoPendente();
    }
    
    public void AtrasPendente(){

       String sql = "SELECT id, Duplicatas.descricao,valor, dataV, Duplicatas.status,Caixas.descricaocaixa,IDCaixa\n" +
                        "FROM duplicatas\n" +
                        "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                        "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                        "WHERE Tipo =  1 AND ID > "+primeiroPendente+"\n" +
                        "ORDER BY ID DESC limit 15";
        TabelaPendentes(sql);
        paginacaoPendente();
    }
    
    public void paginacaoPendente(){
        
        if(MaximoPendente == 0 ){
            Atras1.setEnabled(false);
            Frente1.setEnabled(false);
            CampoResultados1.setText("Mostrando resultados de: 0 á 0 ");
        }
        
        else{
            int rows = TabelaPendentes.getRowCount();
            primeiroPendente = Integer.parseInt(TabelaPendentes.getValueAt(0,1).toString());
            ultimoPendente = Integer.parseInt(TabelaPendentes.getValueAt(rows-1,1).toString());
            CampoResultados1.setText("Mostrando resultados de: "+ primeiroPendente +" a " + ultimoPendente);

            if(primeiroPendente == MaximoPendente && ultimoPendente != MinimoPendente ){
                Atras1.setEnabled(false);
                Frente1.setEnabled(true);
            }
            else if(ultimoPendente == MinimoPendente && primeiroPendente != MaximoPendente){
                Atras1.setEnabled(true);
                Frente1.setEnabled(false);
            }
            else if(primeiroPendente == MaximoPendente && ultimoPendente == MinimoPendente){
                Atras1.setEnabled(false);
                Frente1.setEnabled(false);
            }
        }
        
        
        
    }

    public void MinimoMaximoPendente() {
        String sql = "Select Max(ID),min(ID) from Duplicatas WHERE Duplicatas.Status = 'Pendente' AND Tipo = 1 ";
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();
            
            MaximoPendente = rs.getInt("max");
            MinimoPendente = rs.getInt("Min");

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }// fim Paginação Pendente
    
    //Início Paginação das Pagas

    public int primeiroPagas;
    public int ultimoPagas;
    int MaximoPagas;
    int MinimoPagas;
    
    public void FrentePagas(){
         
        
        String sql = "SELECT id, Duplicatas.descricao,valor, dataP, Duplicatas.status,Caixas.descricaocaixa,IDCaixa,QuemPagou\n" +
                        "FROM duplicatas\n" +
                        "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                        "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                        "WHERE Tipo =  1 AND ID < "+ultimoPagas+"\n" +
                        "ORDER BY ID DESC limit 15";
        TabelaPagas(sql);
        paginacaoPagas();
    }
    
    public void AtrasPagas(){

       String sql = "SELECT id, Duplicatas.descricao,valor, dataP, Duplicatas.status,Caixas.descricaocaixa,IDCaixa,QuemPagou\n" +
                        "FROM duplicatas\n" +
                        "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                        "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                        "WHERE Tipo =  1 AND ID > "+primeiroPagas+"\n" +
                        "ORDER BY ID DESC limit 15";
        TabelaPagas(sql);
        paginacaoPagas();
    }
    
    public void paginacaoPagas(){
        
        if(MaximoPagas == 0 ){
            Atras2.setEnabled(false);
            Frente2.setEnabled(false);
            CampoResultados2.setText("Mostrando resultados de: 0 á 0 ");
        }
        else{
            int rows = TabelaPagas.getRowCount();
            primeiroPagas = Integer.parseInt(TabelaPagas.getValueAt(0,1).toString());
            ultimoPagas = Integer.parseInt(TabelaPagas.getValueAt(rows-1,1).toString());
            CampoResultados2.setText("Mostrando resultados de: "+ primeiroPagas +" a " + ultimoPagas);

            if(primeiroPagas == MaximoPagas && ultimoPagas != MinimoPagas ){
                Atras2.setEnabled(false);
                Frente2.setEnabled(true);
            }
            else if(ultimoPagas == MinimoPagas && primeiroPagas != MaximoPagas){
                Atras2.setEnabled(true);
                Frente2.setEnabled(false);
            }
            else if(primeiroPagas == MaximoPagas && ultimoPagas == MinimoPagas){
                Atras2.setEnabled(false);
                Frente2.setEnabled(false);
            }
        }
        
        
    }

    public void MinimoMaximoPagas() {
        String sql = "Select Max(ID),min(ID) from Duplicatas WHERE Duplicatas.Status = 'Paga' AND Tipo = 1 ";
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();
            
            MaximoPagas = rs.getInt("max");
            MinimoPagas = rs.getInt("Min");

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JButton Atras1;
    private javax.swing.JButton Atras2;
    private javax.swing.JButton BotaoAdicionar;
    private javax.swing.JButton BotaoAtualizar;
    private javax.swing.JButton BotaoAtualizarPagas;
    private javax.swing.JButton BotaoEditarPendentes;
    private javax.swing.JButton BotaoEditarTodas;
    private javax.swing.JButton BotaoEstornar;
    private javax.swing.JButton BotaoExcluirDespesa;
    private javax.swing.JButton BotaoExcluirDespesasPendentes;
    private javax.swing.JButton BotaoPagar;
    private javax.swing.JButton BuscarTodas;
    private javax.swing.JTextField CampoCodigoDespesaTodas;
    private javax.swing.JTextField CampoCodigoDespesasPagas;
    private javax.swing.JTextField CampoCodigoDespesasPendentes;
    private javax.swing.JTextField CampoLOcalizarPendentes;
    private javax.swing.JTextField CampoLocalizarPagas;
    private javax.swing.JTextField CampoLocalizarTodas;
    private javax.swing.JTextField CampoResultados;
    private javax.swing.JTextField CampoResultados1;
    private javax.swing.JTextField CampoResultados2;
    private javax.swing.JButton Frente;
    private javax.swing.JButton Frente1;
    private javax.swing.JButton Frente2;
    private javax.swing.JTable TabelaDespesas;
    private javax.swing.JTable TabelaPagas;
    private javax.swing.JTable TabelaPendentes;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
