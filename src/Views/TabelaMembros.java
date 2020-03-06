
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseMembros;
import Model.ClasseRotas;
import Model.Relatorios;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;

public class TabelaMembros extends javax.swing.JPanel {
    
    ConexaoBanco conectar = new ConexaoBanco();
    ClasseRotas rota = new ClasseRotas();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    int primeiro;
    int ultimo;
    int Maximo;
    int Minimo;
    int oldprimeiro;
    int oldultimo;
    
    
    public boolean check = false;
    
      public TabelaMembros() {
        initComponents();
          setSize(MenuSecretaria.l,MenuSecretaria.a);   
    }
    
    
    
      
    public void ContarMembros(){
        
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(Ativo) FROM Membros ";
        
        try{
            con = conectar.Conectar();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                int total = rs.getInt(1);
                TotalMembros.setText(String.valueOf(total));
            }
            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public int ContarAtivos(){
        int total = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(Ativo) FROM Membros WHERE Ativo = true";
        
        try{
            con = conectar.Conectar();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                 total = rs.getInt(1);
               MembrosAtivos.setText(String.valueOf(total));
            }
            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return total;
    }
    
    public int ContarInativos(){
        int total = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(Ativo) FROM Membros WHERE Ativo = false";
        
        try{
            con = conectar.Conectar();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            
            while(rs.next()){
                total = rs.getInt(1);
               MembrosInativos.setText(String.valueOf(total));
            }
            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
        return total;
    }

    public void preencher(String sql){
 
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaMembros.getModel();
            Model.setNumRows(0); // numero de linhas na tabela
            
            while(rs.next()){
                Model.addRow(new Object[]{
                    check,
                    rs.getString("CodigoMembro"),
                    rs.getString("NomeCompleto"),
                    sdf.format(rs.getDate("DataNascimento")),
                    rs.getString("Telefone"),
                    rs.getString("Endereco"),
                    rs.getString("Bairro"),
                    rs.getString("Cidade"),
                    
                });
                
            }
                stmt.close();
                rs.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
       
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotaoImprimir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaMembros = new javax.swing.JTable();
        Adicionar = new javax.swing.JButton();
        BotaoEditar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CampoPesquisar = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        CampoCodigo = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        MembrosInativos = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        MembrosAtivos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TotalMembros = new javax.swing.JLabel();
        Frente = new javax.swing.JButton();
        Atras = new javax.swing.JButton();
        CampoResultados = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(219, 230, 244));

        BotaoImprimir.setBackground(new java.awt.Color(1, 1, 34));
        BotaoImprimir.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoImprimir.setForeground(new java.awt.Color(255, 255, 255));
        BotaoImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imprimir.png"))); // NOI18N
        BotaoImprimir.setText("Imprimir");
        BotaoImprimir.setBorder(null);
        BotaoImprimir.setBorderPainted(false);
        BotaoImprimir.setFocusPainted(false);
        BotaoImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoImprimirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoImprimirMouseExited(evt);
            }
        });
        BotaoImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoImprimirActionPerformed(evt);
            }
        });

        TabelaMembros.setBackground(new java.awt.Color(255, 255, 255));
        TabelaMembros.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaMembros.setForeground(new java.awt.Color(0, 0, 0));
        TabelaMembros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Nome Completo", "Data Nascimento", "Telefone", "Endereço", "Bairro", "Cidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaMembros.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaMembros.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaMembros.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TabelaMembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaMembrosMouseClicked(evt);
            }
        });
        TabelaMembros.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                TabelaMembrosComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaMembros);
        if (TabelaMembros.getColumnModel().getColumnCount() > 0) {
            TabelaMembros.getColumnModel().getColumn(0).setMinWidth(20);
            TabelaMembros.getColumnModel().getColumn(0).setPreferredWidth(20);
            TabelaMembros.getColumnModel().getColumn(0).setMaxWidth(20);
            TabelaMembros.getColumnModel().getColumn(1).setPreferredWidth(5);
            TabelaMembros.getColumnModel().getColumn(2).setPreferredWidth(200);
            TabelaMembros.getColumnModel().getColumn(3).setPreferredWidth(30);
            TabelaMembros.getColumnModel().getColumn(4).setPreferredWidth(50);
            TabelaMembros.getColumnModel().getColumn(5).setPreferredWidth(200);
            TabelaMembros.getColumnModel().getColumn(6).setPreferredWidth(100);
            TabelaMembros.getColumnModel().getColumn(7).setPreferredWidth(40);
        }

        Adicionar.setBackground(new java.awt.Color(1, 1, 34));
        Adicionar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Adicionar.setForeground(new java.awt.Color(255, 255, 255));
        Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/AdicionarMembro.png"))); // NOI18N
        Adicionar.setText("Adicionar");
        Adicionar.setBorder(null);
        Adicionar.setBorderPainted(false);
        Adicionar.setFocusPainted(false);
        Adicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdicionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdicionarMouseExited(evt);
            }
        });
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
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

        Excluir.setBackground(new java.awt.Color(1, 1, 34));
        Excluir.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Excluir.setForeground(new java.awt.Color(255, 255, 255));
        Excluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        Excluir.setText("Excluir");
        Excluir.setBorder(null);
        Excluir.setBorderPainted(false);
        Excluir.setFocusPainted(false);
        Excluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExcluirMouseExited(evt);
            }
        });
        Excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Membros");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Localizar:");

        CampoPesquisar.setBackground(new java.awt.Color(255, 255, 255));
        CampoPesquisar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoPesquisar.setForeground(new java.awt.Color(0, 0, 0));
        CampoPesquisar.setSelectionColor(new java.awt.Color(192, 202, 6));
        CampoPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoPesquisarActionPerformed(evt);
            }
        });
        CampoPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoPesquisarKeyTyped(evt);
            }
        });

        Buscar.setBackground(new java.awt.Color(1, 1, 34));
        Buscar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Buscar.setForeground(new java.awt.Color(255, 255, 255));
        Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Atualizar.png"))); // NOI18N
        Buscar.setText("Atualizar");
        Buscar.setBorder(null);
        Buscar.setBorderPainted(false);
        Buscar.setFocusPainted(false);
        Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BuscarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BuscarMouseExited(evt);
            }
        });
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });

        CampoCodigo.setBackground(new java.awt.Color(219, 230, 244));
        CampoCodigo.setForeground(new java.awt.Color(219, 230, 244));
        CampoCodigo.setBorder(null);
        CampoCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoCodigoActionPerformed(evt);
            }
        });
        CampoCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoCodigoKeyTyped(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 51), 2, true));

        jPanel7.setBackground(new java.awt.Color(255, 51, 51));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Inativos");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        MembrosInativos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        MembrosInativos.setForeground(new java.awt.Color(204, 0, 0));
        MembrosInativos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MembrosInativos.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MembrosInativos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MembrosInativos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 2, true));

        jPanel5.setBackground(new java.awt.Color(0, 153, 0));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Ativos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel9)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        MembrosAtivos.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        MembrosAtivos.setForeground(new java.awt.Color(0, 153, 0));
        MembrosAtivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MembrosAtivos.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MembrosAtivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MembrosAtivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 34), 2, true));

        jPanel3.setBackground(new java.awt.Color(1, 1, 34));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total ");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Membros");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(14, 14, 14))
        );

        TotalMembros.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        TotalMembros.setForeground(new java.awt.Color(0, 0, 204));
        TotalMembros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalMembros.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TotalMembros, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TotalMembros, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CampoResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Frente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(CampoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BotaoImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Frente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("PainelPrincipal");
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        if(CampoCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nenhuma linha Selecionada");
        }
        else{
            
            
            ClasseMembros.CodigoMembros = Integer.parseInt(CampoCodigo.getText());
            CadastroMembro chamar = new CadastroMembro(null, true);
            chamar.setVisible(true);
            chamar.Povoar();
            
            
        }
        
        
        
    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void CampoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoPesquisarActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        // usado para validar, se é 0 é um novo diferente de 0 é um Edit
        ClasseMembros.CodigoMembros = 0;
        CadastroMembro ad = new CadastroMembro(null, true);
        ad.setVisible(true);
        String sql = rota.getRTCadMembros();
        preencher(sql);
        mimx();
        paginacao();
    }//GEN-LAST:event_AdicionarActionPerformed

    private void AdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionarMouseEntered
        Adicionar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_AdicionarMouseEntered

    private void AdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionarMouseExited
       Adicionar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_AdicionarMouseExited

    private void BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseEntered
        Buscar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BuscarMouseEntered

    private void BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseExited
        Buscar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BuscarMouseExited

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed

        ContarMembros();
        ContarAtivos();
        ContarInativos();
        String sql = rota.getRTCadMembros();
        mimx();
        paginacao();
        
        preencher(sql);
    }//GEN-LAST:event_BuscarActionPerformed

    private void CampoPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoPesquisarKeyTyped
        String sql = "SELECT CodigoMembro,NomeCompleto,DataNascimento,Telefone,Endereco,Bairro,Cidade FROM Membros "
                + "WHERE NomeCompleto LIKE'%"+ CampoPesquisar.getText()+"%'";
        preencher(sql);
    }//GEN-LAST:event_CampoPesquisarKeyTyped

    private void TabelaMembrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMembrosMouseClicked
        
        int linha = TabelaMembros.getSelectedRow();
        CampoCodigo.setText(TabelaMembros.getValueAt(linha,1).toString());
        
        ClasseMembros.CodigoMembros = Integer.parseInt(CampoCodigo.getText());
        if(evt.getClickCount() == 2){
            CadastroMembro chamar = new CadastroMembro(null, true);
            chamar.setVisible(true);
            chamar.Povoar();
            String sql = rota.getRTCadMembros();
            preencher(sql);
        }
            
        
        
    }//GEN-LAST:event_TabelaMembrosMouseClicked

    private void CampoCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCodigoActionPerformed

    private void CampoCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoCodigoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCodigoKeyTyped

    private void ExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirActionPerformed
        if(CampoCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada");
        }
        else{
            UIManager.put("OptionPane.noButtonText", "Não"); 
            UIManager.put("OptionPane.yesButtonText", "Sim");
            switch(showConfirmDialog(null, "Deseja Realmente Excluir?","Confirma Exclusão",JOptionPane.YES_NO_OPTION)){
                
                case 0:
                    ClasseMembros.CodigoMembros = Integer.parseInt(CampoCodigo.getText());
                    ClasseMembros ex = new ClasseMembros();
                    ex.DeletaMembros();
                    mimx();
                    paginacao();
                break;
                
                case 1:
                break;
                            
            } 
            
            String sql = rota.getRTCadMembros();
            preencher(sql);
            
            
        }
    }//GEN-LAST:event_ExcluirActionPerformed

    private void ExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcluirMouseEntered
        Excluir.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_ExcluirMouseEntered

    private void ExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcluirMouseExited
        Excluir.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_ExcluirMouseExited

    private void BotaoEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarMouseEntered
        BotaoEditar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoEditarMouseEntered

    private void BotaoEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarMouseExited
        BotaoEditar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoEditarMouseExited

    private void BotaoImprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoImprimirMouseEntered
        BotaoImprimir.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoImprimirMouseEntered

    private void BotaoImprimirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoImprimirMouseExited
        BotaoImprimir.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoImprimirMouseExited

    private void BotaoImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoImprimirActionPerformed
        
        

        Relatorios imprimir = new Relatorios();
        
        try {
            imprimir.MultiplosCarteirinha();
        } catch (JRException ex) {
            Logger.getLogger(TabelaMembros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TabelaMembros.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        

    }//GEN-LAST:event_BotaoImprimirActionPerformed

    private void TabelaMembrosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_TabelaMembrosComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelaMembrosComponentShown

    private void FrenteBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrenteBuscarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_FrenteBuscarMouseEntered

    private void FrenteBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FrenteBuscarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_FrenteBuscarMouseExited

    private void FrenteBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FrenteBuscarActionPerformed

        String sql = "SELECT CodigoMembro,NomeCompleto,DataNascimento,Telefone,Endereco,Bairro,Cidade FROM Membros\n"
                + " WHERE codigoMembro < "+ultimo+"ORDER BY CodigoMembro DESC LIMIT 15";
        preencher(sql);
        paginacao();
    }//GEN-LAST:event_FrenteBuscarActionPerformed

    private void AtrasBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtrasBuscarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_AtrasBuscarMouseEntered

    private void AtrasBuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AtrasBuscarMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_AtrasBuscarMouseExited

    private void AtrasBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtrasBuscarActionPerformed
        
        
        String sql = "SELECT CodigoMembro,NomeCompleto,DataNascimento,Telefone,Endereco,Bairro,Cidade FROM Membros\n"
                + " WHERE codigoMembro > "+primeiro+"ORDER BY CodigoMembro DESC LIMIT 15";
        preencher(sql);
        paginacao();

    }//GEN-LAST:event_AtrasBuscarActionPerformed

    public void paginacao(){
        
        if(Maximo == 0 ){
            Atras.setEnabled(false);
            Frente.setEnabled(false);
            CampoResultados.setText("Mostrando resultados de: 0 á 0 ");
        }
        else{
            int rows = TabelaMembros.getRowCount();
            primeiro = Integer.parseInt(TabelaMembros.getValueAt(0,1).toString());
            ultimo = Integer.parseInt(TabelaMembros.getValueAt(rows-1,1).toString());
            CampoResultados.setText("Mostrando resultados de: "+ primeiro +" a " + ultimo);

            if(primeiro == Maximo && ultimo != Minimo){
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
    
    public void mimx() {
        String sql = "Select Max(CodigoMembro),min(CodigoMembro) from Membros";
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Adicionar;
    public static javax.swing.JButton Atras;
    public static javax.swing.JButton BotaoEditar;
    public static javax.swing.JButton BotaoImprimir;
    public static javax.swing.JButton Buscar;
    public static javax.swing.JTextField CampoCodigo;
    public static javax.swing.JTextField CampoPesquisar;
    public static javax.swing.JTextField CampoResultados;
    public static javax.swing.JButton Excluir;
    public static javax.swing.JButton Frente;
    public static javax.swing.JLabel MembrosAtivos;
    public static javax.swing.JLabel MembrosInativos;
    public static javax.swing.JTable TabelaMembros;
    public static javax.swing.JLabel TotalMembros;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public static javax.swing.JPanel jPanel4;
    public static javax.swing.JPanel jPanel5;
    public static javax.swing.JPanel jPanel6;
    public static javax.swing.JPanel jPanel7;
    public static javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    void setSize(int MAXIMIZED_BOTH) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



