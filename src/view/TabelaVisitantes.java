package view;

import database.ConexaoBanco;
import model.ClasseRotas;
import model.ClasseVisitantes;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class TabelaVisitantes extends javax.swing.JPanel {

    ConexaoBanco conectar = new ConexaoBanco();
    ClasseRotas rota = new ClasseRotas();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static int da;
    public boolean check = false;
    public int primeiro;
    public int ultimo;
    int Maximo;
    int Minimo;
    public int primeiroHistorico;
    public int ultimoHistorico;
    int MaximoHistorico;
    int MinimoHistorico;

    public TabelaVisitantes() {
        initComponents();
        
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

    public void Povoar(String sql) {

        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();

            DefaultTableModel Model = (DefaultTableModel) TBVisitantes.getModel();
            Model.setNumRows(0);

            while (rs.next()) {
                Model.addRow(new Object[]{
                    check,
                    rs.getString("CodigoVisitante"),
                    rs.getString("NomeVisitante"),
                    verificar(rs.getDate("DataVisita")),
                });
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void historico(String sql) {

        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();

            DefaultTableModel Model = (DefaultTableModel) tabelaVisitantesHistorico.getModel();
            Model.setNumRows(0);

            while (rs.next()) {
                Model.addRow(new Object[]{
                    check,
                    rs.getString("CodigoVisitante"),
                    rs.getString("NomeVisitante"),
                    verificar(rs.getDate("DataVisita")),
                });
            }
            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TBVisitantes = new javax.swing.JTable();
        btnAdicionar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        CampoPesquisaCadastro = new javax.swing.JTextField();
        CpCodigo = new javax.swing.JTextField();
        AtualizarCadastro = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        Frente = new javax.swing.JButton();
        Atras = new javax.swing.JButton();
        CampoResultados = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaVisitantesHistorico = new javax.swing.JTable();
        btnregistrarhis = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        CpPesquisaHis = new javax.swing.JTextField();
        AtualizarHistorico = new javax.swing.JButton();
        Frente1 = new javax.swing.JButton();
        Atras1 = new javax.swing.JButton();
        CampoResultados1 = new javax.swing.JTextField();

        jTabbedPane1.setBackground(new java.awt.Color(219, 230, 244));
        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 0));
        jTabbedPane1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(219, 230, 244));
        jPanel5.setForeground(new java.awt.Color(0, 0, 0));

        TBVisitantes.setBackground(new java.awt.Color(255, 255, 255));
        TBVisitantes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TBVisitantes.setForeground(new java.awt.Color(0, 0, 0));
        TBVisitantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Nome do Usuário", "Data Primeira Visita"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBVisitantes.setGridColor(new java.awt.Color(255, 255, 255));
        TBVisitantes.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TBVisitantes.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TBVisitantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVisitantesMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TBVisitantes);
        if (TBVisitantes.getColumnModel().getColumnCount() > 0) {
            TBVisitantes.getColumnModel().getColumn(0).setMinWidth(20);
            TBVisitantes.getColumnModel().getColumn(0).setPreferredWidth(20);
            TBVisitantes.getColumnModel().getColumn(0).setMaxWidth(20);
            TBVisitantes.getColumnModel().getColumn(1).setPreferredWidth(1);
            TBVisitantes.getColumnModel().getColumn(2).setPreferredWidth(600);
            TBVisitantes.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        btnAdicionar.setBackground(new java.awt.Color(1, 1, 34));
        btnAdicionar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        btnAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.setBorder(null);
        btnAdicionar.setBorderPainted(false);
        btnAdicionar.setFocusPainted(false);
        btnAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoAdicionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoAdicionarMouseExited(evt);
            }
        });
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAdicionarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(1, 1, 34));
        btnEditar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setBorderPainted(false);
        btnEditar.setFocusPainted(false);
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoEditarMouseExited(evt);
            }
        });
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarActionPerformed(evt);
            }
        });

        btnExcluir.setBackground(new java.awt.Color(1, 1, 34));
        btnExcluir.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnExcluir.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setBorder(null);
        btnExcluir.setBorderPainted(false);
        btnExcluir.setFocusPainted(false);
        btnExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoexcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoexcluirMouseExited(evt);
            }
        });
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoexcluirActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Visitantes");

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Localizar:");

        CampoPesquisaCadastro.setBackground(new java.awt.Color(255, 255, 255));
        CampoPesquisaCadastro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoPesquisaCadastro.setForeground(new java.awt.Color(0, 0, 0));
        CampoPesquisaCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        CampoPesquisaCadastro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoPesquisaCadastroKeyTyped(evt);
            }
        });

        CpCodigo.setBackground(new java.awt.Color(219, 230, 244));
        CpCodigo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CpCodigo.setForeground(new java.awt.Color(219, 230, 244));
        CpCodigo.setBorder(null);

        AtualizarCadastro.setBackground(new java.awt.Color(1, 1, 34));
        AtualizarCadastro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        AtualizarCadastro.setForeground(new java.awt.Color(255, 255, 255));
        AtualizarCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Atualizar.png"))); // NOI18N
        AtualizarCadastro.setText("Atualizar");
        AtualizarCadastro.setBorder(null);
        AtualizarCadastro.setBorderPainted(false);
        AtualizarCadastro.setFocusPainted(false);
        AtualizarCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BuscarMouseExited(evt);
            }
        });
        AtualizarCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        btnRegistrar.setBackground(new java.awt.Color(1, 1, 34));
        btnRegistrar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(null);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarBotaoAdicionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarBotaoAdicionarMouseExited(evt);
            }
        });
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarBotaoAdicionarActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CampoResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Frente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CpCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 299, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoPesquisaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AtualizarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(CampoPesquisaCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AtualizarCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CpCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Frente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Cadastro", jPanel5);

        jPanel7.setBackground(new java.awt.Color(219, 230, 244));

        tabelaVisitantesHistorico.setBackground(new java.awt.Color(255, 255, 255));
        tabelaVisitantesHistorico.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tabelaVisitantesHistorico.setForeground(new java.awt.Color(0, 0, 0));
        tabelaVisitantesHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Codigo", "Nome do Usuário", "Data Visita"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaVisitantesHistorico.setGridColor(new java.awt.Color(255, 255, 255));
        tabelaVisitantesHistorico.setSelectionBackground(new java.awt.Color(219, 230, 244));
        tabelaVisitantesHistorico.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tabelaVisitantesHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVisitantesHistoricotabelaVisitantesMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaVisitantesHistorico);
        if (tabelaVisitantesHistorico.getColumnModel().getColumnCount() > 0) {
            tabelaVisitantesHistorico.getColumnModel().getColumn(0).setMinWidth(20);
            tabelaVisitantesHistorico.getColumnModel().getColumn(0).setPreferredWidth(20);
            tabelaVisitantesHistorico.getColumnModel().getColumn(0).setMaxWidth(20);
            tabelaVisitantesHistorico.getColumnModel().getColumn(1).setPreferredWidth(1);
            tabelaVisitantesHistorico.getColumnModel().getColumn(2).setPreferredWidth(600);
            tabelaVisitantesHistorico.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        btnregistrarhis.setBackground(new java.awt.Color(1, 1, 34));
        btnregistrarhis.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        btnregistrarhis.setForeground(new java.awt.Color(255, 255, 255));
        btnregistrarhis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        btnregistrarhis.setText("Registrar");
        btnregistrarhis.setBorder(null);
        btnregistrarhis.setBorderPainted(false);
        btnregistrarhis.setFocusPainted(false);
        btnregistrarhis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnregistrarhisBotaoAdicionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnregistrarhisBotaoAdicionarMouseExited(evt);
            }
        });
        btnregistrarhis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarhisBotaoAdicionarActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Histórico dos Visitantes");

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Localizar:");

        CpPesquisaHis.setBackground(new java.awt.Color(255, 255, 255));
        CpPesquisaHis.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CpPesquisaHis.setForeground(new java.awt.Color(0, 0, 0));
        CpPesquisaHis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CpPesquisaHisjTextField2ActionPerformed(evt);
            }
        });
        CpPesquisaHis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CpPesquisaHisKeyTyped(evt);
            }
        });

        AtualizarHistorico.setBackground(new java.awt.Color(1, 1, 34));
        AtualizarHistorico.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        AtualizarHistorico.setForeground(new java.awt.Color(255, 255, 255));
        AtualizarHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Atualizar.png"))); // NOI18N
        AtualizarHistorico.setText("Atualizar");
        AtualizarHistorico.setBorder(null);
        AtualizarHistorico.setBorderPainted(false);
        AtualizarHistorico.setFocusPainted(false);
        AtualizarHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AtualizarHistoricoBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AtualizarHistoricoBuscarMouseExited(evt);
            }
        });
        AtualizarHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarHistoricoBuscarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnregistrarhis, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CampoResultados1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Atras1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Frente1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CpPesquisaHis, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(AtualizarHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(CpPesquisaHis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AtualizarHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnregistrarhis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Frente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoResultados1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Atras1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Histórico", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AtualizarHistoricoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarHistoricoBuscarActionPerformed
        String sql = rota.getRTHistoricoVisita();
        historico(sql);
        Povoarhistorico();
        paginacaoHistorico();
    }//GEN-LAST:event_AtualizarHistoricoBuscarActionPerformed

    private void AtualizarHistoricoBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtualizarHistoricoBuscarMouseExited
        
    }//GEN-LAST:event_AtualizarHistoricoBuscarMouseExited

    private void AtualizarHistoricoBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtualizarHistoricoBuscarMouseEntered
        AtualizarHistorico.setBackground(new Color(219, 230, 244));

    }//GEN-LAST:event_AtualizarHistoricoBuscarMouseEntered

    private void CpPesquisaHisjTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CpPesquisaHisjTextField2ActionPerformed
        AtualizarHistorico.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_CpPesquisaHisjTextField2ActionPerformed

    private void btnregistrarhisBotaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarhisBotaoAdicionarActionPerformed
        CadastroRegistroVisitantes reg = new CadastroRegistroVisitantes(null, true);
        reg.setVisible(true);
        String sql = rota.getRTHistoricoVisita();
        historico(sql);
        Povoarhistorico();
        paginacaoHistorico();
    }//GEN-LAST:event_btnregistrarhisBotaoAdicionarActionPerformed

    private void btnregistrarhisBotaoAdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistrarhisBotaoAdicionarMouseExited
        btnregistrarhis.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_btnregistrarhisBotaoAdicionarMouseExited

    private void btnregistrarhisBotaoAdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistrarhisBotaoAdicionarMouseEntered
        btnregistrarhis.setBackground(new Color(219, 230, 244));
    }//GEN-LAST:event_btnregistrarhisBotaoAdicionarMouseEntered

    private void tabelaVisitantesHistoricotabelaVisitantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVisitantesHistoricotabelaVisitantesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaVisitantesHistoricotabelaVisitantesMouseClicked

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        String sql = rota.getRTVisitantes();
        Povoar(sql);
        Povoar();
        paginacao();
    }//GEN-LAST:event_BuscarActionPerformed

    private void BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseExited
        AtualizarCadastro.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_BuscarMouseExited

    private void BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseEntered
        AtualizarCadastro.setBackground(new Color(219, 230, 244));
    }//GEN-LAST:event_BuscarMouseEntered

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void BotaoexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoexcluirActionPerformed
        if (CpCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha Selecionada");
        } else {
            UIManager.put("OptionPane.noButtonText", "Não");
            UIManager.put("OptionPane.yesButtonText", "Sim");
            switch (showConfirmDialog(null, "Deseja Realmente Excluir?", "Confirma Exclusão", JOptionPane.YES_NO_OPTION)) {

                case 0:
                    
                    ClasseVisitantes.CodigoVisitante = Integer.parseInt(CpCodigo.getText());
                    ClasseVisitantes excluir = new ClasseVisitantes();
                    excluir.Delete();
                    String sql = rota.getRTVisitantes();
                    Povoar(sql);
                    Povoar();
                    paginacao();
                    break;

                case 1:
                    break;
            }
        }
    }//GEN-LAST:event_BotaoexcluirActionPerformed

    private void BotaoexcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoexcluirMouseExited
        btnExcluir.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_BotaoexcluirMouseExited

    private void BotaoexcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoexcluirMouseEntered
        btnExcluir.setBackground(new Color(219, 230, 244));
    }//GEN-LAST:event_BotaoexcluirMouseEntered

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        if (CpCodigo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha Selecionada");
        } else {
            ClasseVisitantes.CodigoVisitante = Integer.parseInt(CpCodigo.getText());
            CadastroVisitantes chamar = new CadastroVisitantes(null, true);
            da = 1;
            String sql = "SELECT * FROM Visitantes WHERE CodigoVisitante = " + ClasseVisitantes.CodigoVisitante;
            chamar.Povoar(sql);
            chamar.setVisible(true);
            String sq = rota.getRTVisitantes();
            Povoar(sq);
        }
    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void BotaoEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarMouseExited
        btnEditar.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_BotaoEditarMouseExited

    private void BotaoEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarMouseEntered
        btnEditar.setBackground(new Color(219, 230, 244));
    }//GEN-LAST:event_BotaoEditarMouseEntered

    private void BotaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAdicionarActionPerformed
        CadastroVisitantes chamar = new CadastroVisitantes(null, true);
        da = 0;
        chamar.setVisible(true);
        String sql = rota.getRTVisitantes();
        Povoar(sql);
        Povoar();
        paginacao();
    }//GEN-LAST:event_BotaoAdicionarActionPerformed

    private void BotaoAdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAdicionarMouseExited
        btnAdicionar.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_BotaoAdicionarMouseExited

    private void BotaoAdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAdicionarMouseEntered
        btnAdicionar.setBackground(new Color(219, 230, 244));
    }//GEN-LAST:event_BotaoAdicionarMouseEntered

    private void tabelaVisitantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVisitantesMouseClicked
        int linha = TBVisitantes.getSelectedRow();
        int id = Integer.parseInt(TBVisitantes.getValueAt(linha, 1).toString());
        CpCodigo.setText(TBVisitantes.getValueAt(linha, 1).toString());
        

        if (evt.getClickCount() == 2) {
            ClasseVisitantes.CodigoVisitante = id;
            CadastroVisitantes chamar = new CadastroVisitantes(null, true);
            da = 1;
            String sql = "SELECT * FROM Visitantes WHERE CodigoVisitante = " + ClasseVisitantes.CodigoVisitante;
            chamar.Povoar(sql);
            chamar.setVisible(true);
            String sq = rota.getRTVisitantes();
            Povoar(sq);
        }
    }//GEN-LAST:event_tabelaVisitantesMouseClicked

    private void btnRegistrarBotaoAdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarBotaoAdicionarMouseEntered
        btnRegistrar.setBackground(new Color(219, 230, 244));
    }//GEN-LAST:event_btnRegistrarBotaoAdicionarMouseEntered

    private void btnRegistrarBotaoAdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarBotaoAdicionarMouseExited

        btnRegistrar.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_btnRegistrarBotaoAdicionarMouseExited

    private void btnRegistrarBotaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarBotaoAdicionarActionPerformed
        CadastroRegistroVisitantes reg = new CadastroRegistroVisitantes(null, true);
        reg.setVisible(true);
    }//GEN-LAST:event_btnRegistrarBotaoAdicionarActionPerformed

    private void CampoPesquisaCadastroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoPesquisaCadastroKeyTyped
        String sql = "SELECT * FROM Visitantes "
                + "WHERE NomeVisitante LIKE'%" + CampoPesquisaCadastro.getText() + "%'";
        Povoar(sql);
    }//GEN-LAST:event_CampoPesquisaCadastroKeyTyped

    private void CpPesquisaHisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CpPesquisaHisKeyTyped
        String sql = "SELECT * FROM HistoricoVisita "
                + "WHERE NomeVisitante LIKE'%" + CpPesquisaHis.getText() + "%'";
        historico(sql);
    }//GEN-LAST:event_CpPesquisaHisKeyTyped

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
       Frente1.setBackground(new Color(219, 230, 244));
    }//GEN-LAST:event_Frente1BuscarMouseEntered

    private void Frente1BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Frente1BuscarMouseExited
        Frente1.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_Frente1BuscarMouseExited

    private void Frente1BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Frente1BuscarActionPerformed
        
        String sql = "SELECT HistoricoVisita.codigovisitante, HistoricoVisita.datavisita,Visitantes.NomeVisitante\n" +
                        "FROM historicovisita\n" +
                        "INNER JOIN Visitantes ON Visitantes.CodigoVisitante = IDVisitante\n"
                      + "WHERE codigovisitante < "+ultimoHistorico+"ORDER BY CodigoVisitante DESC LIMIT 15 ";
        historico(sql);
        paginacaoHistorico();
    }//GEN-LAST:event_Frente1BuscarActionPerformed

    private void Atras1BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Atras1BuscarMouseEntered
        Atras1.setBackground(new Color(219, 230, 244));
    }//GEN-LAST:event_Atras1BuscarMouseEntered

    private void Atras1BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Atras1BuscarMouseExited
        Atras1.setBackground(new Color(1, 1, 34));
    }//GEN-LAST:event_Atras1BuscarMouseExited

    private void Atras1BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Atras1BuscarActionPerformed
        
        String sql = "SELECT HistoricoVisita.codigovisitante, HistoricoVisita.datavisita,Visitantes.NomeVisitante\n" +
                        "FROM historicovisita\n" +
                        "INNER JOIN Visitantes ON Visitantes.CodigoVisitante = IDVisitante\n"
                      + "WHERE codigovisitante > "+primeiroHistorico+"ORDER BY CodigoVisitante DESC LIMIT 15 ";

        historico(sql);
        paginacaoHistorico();
    }//GEN-LAST:event_Atras1BuscarActionPerformed

    public void Frente(){
        String sql = "SELECT * FROM Visitantes WHERE codigovisitante < "+ultimo+"ORDER BY CodigoVisitante DESC LIMIT 15 ";
        Povoar(sql);
        paginacao();
    }
    
    public void Atras(){
        String sql = "SELECT * FROM Visitantes WHERE codigovisitante > "+primeiro+"ORDER BY CodigoVisitante DESC LIMIT 15 ";
        Povoar(sql);
        paginacao();
    }
    
    public void paginacao(){
        
        if(Maximo == 0 ){
            Atras.setEnabled(false);
            Frente.setEnabled(false);
            CampoResultados.setText("Mostrando resultados de: 0 á 0 ");
        }
        else{
            int rows = TBVisitantes.getRowCount();
            primeiro = Integer.parseInt(TBVisitantes.getValueAt(0,1).toString());
            ultimo = Integer.parseInt(TBVisitantes.getValueAt(rows-1,1).toString());
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

    public void Povoar() {
        String sql = "Select Max(codigovisitante),min(codigovisitante) from visitantes";
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

    }
    
    public void paginacaoHistorico(){
        
        if(MaximoHistorico == 0 ){
            Atras.setEnabled(false);
            Frente.setEnabled(false);
            CampoResultados1.setText("Mostrando resultados de: 0 á 0 ");
        }
        else{
            int rows = tabelaVisitantesHistorico.getRowCount();
            primeiroHistorico = Integer.parseInt(tabelaVisitantesHistorico.getValueAt(0,1).toString());
            ultimoHistorico = Integer.parseInt(tabelaVisitantesHistorico.getValueAt(rows-1,1).toString());
            CampoResultados1.setText("Mostrando resultados de: "+ primeiroHistorico +" a " + ultimoHistorico);

            if(primeiroHistorico == MaximoHistorico && ultimoHistorico != MinimoHistorico){
                Atras1.setEnabled(false);
                Frente1.setEnabled(true);
            }
            else if(ultimoHistorico == MinimoHistorico && primeiroHistorico != MaximoHistorico){
                Atras1.setEnabled(true);
                Frente1.setEnabled(false);
            }
            else if(primeiroHistorico == MaximoHistorico && ultimoHistorico == MinimoHistorico){
                Atras1.setEnabled(false);
                Frente1.setEnabled(false);
            }
        }
        
        
        
    }
    
    
    public void Povoarhistorico() {
        String sql = "Select Max(codigovisitante),min(codigovisitante) from HistoricoVisita";
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();
            
            MaximoHistorico = rs.getInt("max");
            MinimoHistorico = rs.getInt("Min");

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Atras;
    private javax.swing.JButton Atras1;
    private javax.swing.JButton AtualizarCadastro;
    private javax.swing.JButton AtualizarHistorico;
    private javax.swing.JTextField CampoPesquisaCadastro;
    private javax.swing.JTextField CampoResultados;
    private javax.swing.JTextField CampoResultados1;
    private javax.swing.JTextField CpCodigo;
    private javax.swing.JTextField CpPesquisaHis;
    private javax.swing.JButton Frente;
    private javax.swing.JButton Frente1;
    private javax.swing.JTable TBVisitantes;
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnregistrarhis;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelaVisitantesHistorico;
    // End of variables declaration//GEN-END:variables
}
