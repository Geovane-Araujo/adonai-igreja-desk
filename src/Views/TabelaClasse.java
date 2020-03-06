
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseChamada;
import Model.ClasseClasses;
import Model.ClasseRotas;
import Model.VariaveisUniversais;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class TabelaClasse extends javax.swing.JPanel {
    ConexaoBanco conectar = new ConexaoBanco();
    ClasseRotas rota = new ClasseRotas();
    VariaveisUniversais var = new VariaveisUniversais();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public static int cargo;
    public boolean check = false;
    

    
   
    public TabelaClasse() {
        initComponents();
    }
     
    public void Povoar(String sql){
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaClasses.getModel();
            Model.setNumRows(0);
            
            
            while(rs.next()){
                Model.addRow(new Object[]{
                    check,
                    rs.getString("IdClasse"),
                    rs.getString("Descricao"),
                });
            }
            rs.close();
            stmt.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }

    public void PovoarHistorico(){
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(rota.getTabelaHistorico());
            stmt.execute();
            rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaHistorico.getModel();
            Model.setNumRows(0);
            
            
            while(rs.next()){
                Model.addRow(new Object[]{
                    check,
                    rs.getString("ID"),
                    rs.getString("Descricao"),
                    sdf.format(rs.getDate("Datachamada")),
                    rs.getString("IdClasse"),
                });
            }
            rs.close();
            stmt.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaClasses = new javax.swing.JTable();
        BotaoAdicionar = new javax.swing.JButton();
        BotaoEditar = new javax.swing.JButton();
        Botaoexcluir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        CampoCodigo = new javax.swing.JTextField();
        BotaoBuscar = new javax.swing.JButton();
        BotaoTurma = new javax.swing.JButton();
        BotaoChamada = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaHistorico = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        BotaoBuscarHistorico = new javax.swing.JButton();
        CampoHistorico = new javax.swing.JTextField();

        jTabbedPane1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(219, 230, 244));

        TabelaClasses.setBackground(new java.awt.Color(255, 255, 255));
        TabelaClasses.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaClasses.setForeground(new java.awt.Color(0, 0, 0));
        TabelaClasses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Classe"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaClasses.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaClasses.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaClasses.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TabelaClasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaClassesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaClasses);
        if (TabelaClasses.getColumnModel().getColumnCount() > 0) {
            TabelaClasses.getColumnModel().getColumn(0).setMinWidth(20);
            TabelaClasses.getColumnModel().getColumn(0).setMaxWidth(20);
            TabelaClasses.getColumnModel().getColumn(1).setResizable(false);
            TabelaClasses.getColumnModel().getColumn(1).setPreferredWidth(1);
            TabelaClasses.getColumnModel().getColumn(2).setResizable(false);
            TabelaClasses.getColumnModel().getColumn(2).setPreferredWidth(500);
        }

        BotaoAdicionar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoAdicionar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
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

        BotaoEditar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoEditar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoEditar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Editar.png"))); // NOI18N
        BotaoEditar.setText("Editar");
        BotaoEditar.setBorder(null);
        BotaoEditar.setBorderPainted(false);
        BotaoEditar.setFocusPainted(false);
        BotaoEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoEditarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoEditarMouseExited(evt);
            }
        });
        BotaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarActionPerformed(evt);
            }
        });

        Botaoexcluir.setBackground(new java.awt.Color(1, 1, 34));
        Botaoexcluir.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Botaoexcluir.setForeground(new java.awt.Color(255, 255, 255));
        Botaoexcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        Botaoexcluir.setText("Excluir");
        Botaoexcluir.setBorder(null);
        Botaoexcluir.setBorderPainted(false);
        Botaoexcluir.setFocusPainted(false);
        Botaoexcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoexcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoexcluirMouseExited(evt);
            }
        });
        Botaoexcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoexcluirActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Classes");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Localizar:");

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(0, 0, 0));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        CampoCodigo.setBackground(new java.awt.Color(219, 230, 244));
        CampoCodigo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CampoCodigo.setForeground(new java.awt.Color(219, 230, 244));
        CampoCodigo.setBorder(null);

        BotaoBuscar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoBuscar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoBuscar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Atualizar.png"))); // NOI18N
        BotaoBuscar.setText("Atualizar");
        BotaoBuscar.setBorder(null);
        BotaoBuscar.setBorderPainted(false);
        BotaoBuscar.setFocusPainted(false);
        BotaoBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoBuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoBuscarMouseExited(evt);
            }
        });
        BotaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscarActionPerformed(evt);
            }
        });

        BotaoTurma.setBackground(new java.awt.Color(1, 1, 34));
        BotaoTurma.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoTurma.setForeground(new java.awt.Color(255, 255, 255));
        BotaoTurma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Classroom_26px.png"))); // NOI18N
        BotaoTurma.setText("Turma");
        BotaoTurma.setBorder(null);
        BotaoTurma.setBorderPainted(false);
        BotaoTurma.setFocusPainted(false);
        BotaoTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoTurmaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoTurmaMouseExited(evt);
            }
        });
        BotaoTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoTurmaActionPerformed(evt);
            }
        });

        BotaoChamada.setBackground(new java.awt.Color(1, 1, 34));
        BotaoChamada.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoChamada.setForeground(new java.awt.Color(255, 255, 255));
        BotaoChamada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Leadership_26px.png"))); // NOI18N
        BotaoChamada.setText("Chamada");
        BotaoChamada.setBorder(null);
        BotaoChamada.setBorderPainted(false);
        BotaoChamada.setFocusPainted(false);
        BotaoChamada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoChamadaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoChamadaMouseExited(evt);
            }
        });
        BotaoChamada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoChamadaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BotaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Botaoexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoChamada, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Botaoexcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoChamada, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Classes", jPanel1);

        jPanel3.setBackground(new java.awt.Color(219, 230, 244));

        TabelaHistorico.setBackground(new java.awt.Color(255, 255, 255));
        TabelaHistorico.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaHistorico.setForeground(new java.awt.Color(0, 0, 0));
        TabelaHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Classe", "Data Chamada", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
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
        TabelaHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaHistoricoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabelaHistorico);
        if (TabelaHistorico.getColumnModel().getColumnCount() > 0) {
            TabelaHistorico.getColumnModel().getColumn(0).setMinWidth(20);
            TabelaHistorico.getColumnModel().getColumn(0).setMaxWidth(20);
            TabelaHistorico.getColumnModel().getColumn(1).setResizable(false);
            TabelaHistorico.getColumnModel().getColumn(1).setPreferredWidth(1);
            TabelaHistorico.getColumnModel().getColumn(2).setResizable(false);
            TabelaHistorico.getColumnModel().getColumn(2).setPreferredWidth(500);
            TabelaHistorico.getColumnModel().getColumn(3).setResizable(false);
            TabelaHistorico.getColumnModel().getColumn(3).setPreferredWidth(200);
            TabelaHistorico.getColumnModel().getColumn(4).setMinWidth(0);
            TabelaHistorico.getColumnModel().getColumn(4).setPreferredWidth(0);
            TabelaHistorico.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Histórico de Chamadas");

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Localizar:");

        jTextField3.setBackground(new java.awt.Color(255, 255, 255));
        jTextField3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 0));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        BotaoBuscarHistorico.setBackground(new java.awt.Color(1, 1, 34));
        BotaoBuscarHistorico.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        BotaoBuscarHistorico.setForeground(new java.awt.Color(255, 255, 255));
        BotaoBuscarHistorico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Atualizar.png"))); // NOI18N
        BotaoBuscarHistorico.setText("Atualizar");
        BotaoBuscarHistorico.setBorder(null);
        BotaoBuscarHistorico.setBorderPainted(false);
        BotaoBuscarHistorico.setFocusPainted(false);
        BotaoBuscarHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoBuscarHistoricoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoBuscarHistoricoMouseExited(evt);
            }
        });
        BotaoBuscarHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscarHistoricoActionPerformed(evt);
            }
        });

        CampoHistorico.setBackground(new java.awt.Color(219, 230, 244));
        CampoHistorico.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CampoHistorico.setForeground(new java.awt.Color(219, 230, 244));
        CampoHistorico.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoBuscarHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(CampoHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscarHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addGap(23, 23, 23)
                .addComponent(CampoHistorico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 872, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 523, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chamadas", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 874, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Classes");
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
       if(CampoCodigo.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Nenhma Linha Foi Selecionada");
       }
       else{
           ClasseClasses.IDClasse = Integer.parseInt(CampoCodigo.getText());
           CadastroClasse chamar = new CadastroClasse(null, true);
           String sql = "SELECT * FROM Classe WHERE IdClasse = "+ClasseClasses.IDClasse;
           
           chamar.Povoar(sql);
           chamar.setVisible(true);
           String sq = "SELECT IdClasse,Descricao FROM Classe";
           Povoar(sq);
           
           
       }
    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void BotaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAdicionarActionPerformed
        CadastroClasse chamar = new CadastroClasse(null, true);
        chamar.setVisible(true);
        String sql = "SELECT IdClasse,Descricao FROM Classe";
        Povoar(sql);
     
    }//GEN-LAST:event_BotaoAdicionarActionPerformed

    private void TabelaClassesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaClassesMouseClicked
       int linha = TabelaClasses.getSelectedRow();
       CampoCodigo.setText(TabelaClasses.getValueAt(linha, 1).toString());
       
       
       if(evt.getClickCount() == 2){
           ClasseClasses.IDClasse = Integer.parseInt(CampoCodigo.getText());
            CadastroTurma chamar = new CadastroTurma(null, true);
            chamar.setVisible(true);
        }
    }//GEN-LAST:event_TabelaClassesMouseClicked

    private void BotaoexcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoexcluirActionPerformed
        if(CampoCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nenhuma Linha Selecionada");
        }
        else{
            
            UIManager.put("OptionPane.noButtonText", "Não"); 
            UIManager.put("OptionPane.yesButtonText", "Sim");
            switch(showConfirmDialog(null, "Deseja Realmente Excluir?","Confirma Exclusão",JOptionPane.YES_NO_OPTION)){

                case 0:
                    ClasseClasses.IDClasse = Integer.parseInt(CampoCodigo.getText());
                    ClasseClasses excluir = new ClasseClasses();
                    excluir.Delete();
                    String sq = "SELECT IdClasse,Descricao FROM Classe";
                    Povoar(sq);
                break;

                case 1:
                break;       
             } 
        }
    }//GEN-LAST:event_BotaoexcluirActionPerformed

    private void BotaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscarActionPerformed
        
           String sq = "SELECT IdClasse,Descricao FROM Classe";
           Povoar(sq);
        
    }//GEN-LAST:event_BotaoBuscarActionPerformed

    private void BotaoBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoBuscarMouseEntered
        BotaoBuscar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoBuscarMouseEntered

    private void BotaoBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoBuscarMouseExited
        BotaoBuscar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoBuscarMouseExited

    private void BotaoexcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoexcluirMouseEntered
        Botaoexcluir.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoexcluirMouseEntered

    private void BotaoexcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoexcluirMouseExited
        Botaoexcluir.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoexcluirMouseExited

    private void BotaoEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarMouseEntered
        BotaoEditar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoEditarMouseEntered

    private void BotaoEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarMouseExited
        BotaoEditar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoEditarMouseExited

    private void BotaoAdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAdicionarMouseEntered
        BotaoAdicionar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoAdicionarMouseEntered

    private void BotaoAdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAdicionarMouseExited
        BotaoAdicionar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoAdicionarMouseExited

    private void BotaoTurmaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoTurmaMouseEntered
        BotaoTurma.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoTurmaMouseEntered

    private void BotaoTurmaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoTurmaMouseExited
        BotaoTurma.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoTurmaMouseExited

    private void BotaoTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoTurmaActionPerformed
        if(CampoCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione uma Classe!");
        }
        else{
            ClasseClasses.IDClasse = Integer.parseInt(CampoCodigo.getText());
            CadastroTurma chamar = new CadastroTurma(null, true);
            chamar.setVisible(true);
        }
        
        
    }//GEN-LAST:event_BotaoTurmaActionPerformed

    private void TabelaHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaHistoricoMouseClicked
       int linha = TabelaHistorico.getSelectedRow();
       CampoHistorico.setText(TabelaHistorico.getValueAt(linha, 1).toString());
       
       
       if(evt.getClickCount() == 2){
           ClasseChamada.ID =0;
           ClasseChamada.ID = Integer.parseInt(CampoHistorico.getText());
           Chamada VerCha = new Chamada(null, true);
           var.setUsadochamada(1);  
           VerCha.setVisible(true);
            
            
        }
    }//GEN-LAST:event_TabelaHistoricoMouseClicked

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void BotaoBuscarHistoricoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoBuscarHistoricoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoBuscarHistoricoMouseEntered

    private void BotaoBuscarHistoricoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoBuscarHistoricoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoBuscarHistoricoMouseExited

    private void BotaoBuscarHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscarHistoricoActionPerformed
        PovoarHistorico();
    }//GEN-LAST:event_BotaoBuscarHistoricoActionPerformed

    private void BotaoChamadaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoChamadaMouseEntered
       BotaoChamada.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoChamadaMouseEntered

    private void BotaoChamadaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoChamadaMouseExited
        BotaoChamada.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoChamadaMouseExited

    private void BotaoChamadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoChamadaActionPerformed
        if(CampoCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione uma Classe!");
        }
        else{
            ClasseClasses.IDClasse = Integer.parseInt(CampoCodigo.getText());
            Chamada abrir = new Chamada(null, true);
            abrir.setVisible(true);
        }
    }//GEN-LAST:event_BotaoChamadaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoAdicionar;
    private javax.swing.JButton BotaoBuscar;
    private javax.swing.JButton BotaoBuscarHistorico;
    private javax.swing.JButton BotaoChamada;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoTurma;
    private javax.swing.JButton Botaoexcluir;
    private javax.swing.JTextField CampoCodigo;
    private javax.swing.JTextField CampoHistorico;
    private javax.swing.JTable TabelaClasses;
    private javax.swing.JTable TabelaHistorico;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables
}
