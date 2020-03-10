
package Views;

import BancoDados.ConexaoBanco;
import Converter.DataHora;
import Model.ClasseEntradas;
import Model.ClasseRotas;
import Model.Var.VarEntradas;

import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class TabelaEntradas extends javax.swing.JPanel {
    ConexaoBanco conectar = new ConexaoBanco();
    VarEntradas entradas = new VarEntradas();
    ClasseRotas rotas = new ClasseRotas();
    DataHora dt = new DataHora();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String formato = "R$ 0.00";
    DecimalFormat df = new DecimalFormat(formato);
    String Verificar;
    int IdCaixa;
    
    
    public static int da;
    public boolean check = false;

    
    public TabelaEntradas() {
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
            
            DefaultTableModel Model = (DefaultTableModel) TabelaEntradas.getModel();
            Model.setNumRows(0);
            
            while(rs.next()){
                double valor = Double.parseDouble(rs.getString("Valor"));
                
                Model.addRow(new Object[]{
                    check,
                    rs.getString("ID"),
                    rs.getString("Descricao"),
                    verificar(rs.getDate("DataC")),
                    rs.getString("TpDesc"),
                    df.format(valor),
                    rs.getString("nomecompleto"),
                    rs.getString("descricaocaixa"),
                    rs.getString("idCaixa"),
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
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaEntradas = new javax.swing.JTable();
        BotaoAdicionar = new javax.swing.JButton();
        BotaoEditar = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CampoPesquisa = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        CampoCodigo = new javax.swing.JTextField();
        CamoCaixa = new javax.swing.JTextField();
        Frente = new javax.swing.JButton();
        Atras = new javax.swing.JButton();
        CampoResultados = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(219, 230, 244));

        TabelaEntradas.setBackground(new java.awt.Color(255, 255, 255));
        TabelaEntradas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaEntradas.setForeground(new java.awt.Color(0, 0, 0));
        TabelaEntradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Descrição", "Data", "Tipo", "Valor", "Nome ", "Caixa", ""
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
        TabelaEntradas.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaEntradas.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaEntradas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TabelaEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaEntradasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaEntradas);
        if (TabelaEntradas.getColumnModel().getColumnCount() > 0) {
            TabelaEntradas.getColumnModel().getColumn(0).setMinWidth(20);
            TabelaEntradas.getColumnModel().getColumn(0).setPreferredWidth(20);
            TabelaEntradas.getColumnModel().getColumn(0).setMaxWidth(20);
            TabelaEntradas.getColumnModel().getColumn(1).setPreferredWidth(1);
            TabelaEntradas.getColumnModel().getColumn(2).setPreferredWidth(200);
            TabelaEntradas.getColumnModel().getColumn(3).setPreferredWidth(50);
            TabelaEntradas.getColumnModel().getColumn(4).setPreferredWidth(50);
            TabelaEntradas.getColumnModel().getColumn(5).setPreferredWidth(50);
            TabelaEntradas.getColumnModel().getColumn(6).setPreferredWidth(200);
            TabelaEntradas.getColumnModel().getColumn(7).setPreferredWidth(50);
            TabelaEntradas.getColumnModel().getColumn(8).setMinWidth(0);
            TabelaEntradas.getColumnModel().getColumn(8).setPreferredWidth(0);
            TabelaEntradas.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        BotaoAdicionar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoAdicionar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoAdicionar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Donate_26px.png"))); // NOI18N
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

        BotaoExcluir.setBackground(new java.awt.Color(1, 1, 34));
        BotaoExcluir.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoExcluir.setForeground(new java.awt.Color(255, 255, 255));
        BotaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Excluir.png"))); // NOI18N
        BotaoExcluir.setText("Excluir");
        BotaoExcluir.setBorder(null);
        BotaoExcluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoExcluirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoExcluirMouseExited(evt);
            }
        });
        BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Entradas");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Localizar:");

        CampoPesquisa.setBackground(new java.awt.Color(255, 255, 255));
        CampoPesquisa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
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

        CamoCaixa.setBackground(new java.awt.Color(219, 230, 244));
        CamoCaixa.setForeground(new java.awt.Color(219, 230, 244));
        CamoCaixa.setBorder(null);
        CamoCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CamoCaixaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(BotaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                        .addComponent(CamoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)
                        .addComponent(CampoResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(Atras, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Frente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4)
                    .addComponent(CampoPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BotaoAdicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CamoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Atras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Frente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 923, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        if(CampoCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nenhuma Linha selecionada");
        }
        else{
            Verificar();
            if(Verificar.equals("Caixa Fechado")){
                JOptionPane.showMessageDialog(null, "Não é possível alterar uma entrada que está relacionada a um caixa que já foi fechado");
            }
            else{
                da = 1;
                entradas.setID(Integer.parseInt(CampoCodigo.getText()));
                
                CadastroEntrada chamar = new CadastroEntrada(null, true);
                chamar.Povoar();
                chamar.setVisible(true);
                String sql = rotas.getRTTabEntradas();
                Povoar(sql);
            }
        }
    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void CampoPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoPesquisaActionPerformed

    private void BotaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAdicionarActionPerformed
        CadastroEntrada Chamar = new CadastroEntrada(null, true);
        da = 0;
        Chamar.setVisible(true);
        String sql = rotas.getRTTabEntradas();
        Povoar(sql);
        Povoar();
        paginacao();
    }//GEN-LAST:event_BotaoAdicionarActionPerformed

    private void BotaoAdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAdicionarMouseEntered
        BotaoAdicionar.setBackground(new Color (219,230,244));
        
    }//GEN-LAST:event_BotaoAdicionarMouseEntered

    private void BotaoAdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAdicionarMouseExited
        BotaoAdicionar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoAdicionarMouseExited

    private void BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseEntered
        Buscar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BuscarMouseEntered

    private void BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseExited
        Buscar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BuscarMouseExited

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        
        String sql = rotas.getRTTabEntradas();
        Povoar(sql);
        
    }//GEN-LAST:event_BuscarActionPerformed

    private void CampoPesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoPesquisaKeyTyped
        String sql = "SELECT CodigoEntrada,DescricaoEntrada,DataEntrada,TipoEntrada,ValorEntrada,NomeMembro FROM Entradas "
                + "WHERE DescricaoEntrada  LIKE '%"+ CampoPesquisa.getText()+"%'";
        Povoar(sql);
        Povoar();
        paginacao();
    }//GEN-LAST:event_CampoPesquisaKeyTyped

    private void TabelaEntradasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaEntradasMouseClicked
        int linha = TabelaEntradas.getSelectedRow();
        CampoCodigo.setText(TabelaEntradas.getValueAt(linha, 1).toString());
        entradas.setID(Integer.parseInt(CampoCodigo.getText()));
        IdCaixa = Integer.parseInt(TabelaEntradas.getValueAt(linha, 8).toString());
        
        
        if(evt.getClickCount() == 2){
            
            Verificar();
            if(Verificar.equals("Caixa Fechado")){
                JOptionPane.showMessageDialog(null, "Não é possível alterar uma entrada que está relacionada a um caixa que já foi fechado");
            }
            else{
                da = 1;
                entradas.setID(Integer.parseInt(CampoCodigo.getText()));
                CadastroEntrada chamar = new CadastroEntrada(null, true);
                chamar.Povoar();
                chamar.setVisible(true);
                String sql = rotas.getRTTabEntradas();
                Povoar(sql);
            }
        }
    }//GEN-LAST:event_TabelaEntradasMouseClicked

    private void CampoCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCodigoActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        if(CampoCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nenhuma Linha selecionada");
        }
        else{
            Verificar();
            if(Verificar.equals("Caixa Fechado")){
                JOptionPane.showMessageDialog(null, "Não é possível excluir uma entrada que está rlacionada a um caixa que já foi fechado");
            }
            else{
                UIManager.put("OptionPane.noButtonText", "Não"); 
                UIManager.put("OptionPane.yesButtonText", "Sim");
                switch(showConfirmDialog(null, "Deseja Realmente Excluir?","Confirma Exclusão",JOptionPane.YES_NO_OPTION)){
                
                    case 0:
                        ClasseEntradas ex = new ClasseEntradas();
                        ex.DeletarEntrada();
                        String sql = rotas.getRTTabEntradas();
                        Povoar(sql);
                        Povoar();
                        paginacao();
                    break;

                    case 1:
                    break;       
                 }
                
                String sql = rotas.getRTTabEntradas();
                Povoar(sql);
            }
            
            
        }
        
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    public void Verificar(){
          
        String sql = "SELECT Status FROM Caixas WHERE  codigocaixa = '"+IdCaixa+"'";
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
    
    
    private void BotaoEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarMouseEntered
        BotaoEditar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoEditarMouseEntered

    private void BotaoEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarMouseExited
        BotaoEditar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoEditarMouseExited

    private void BotaoExcluirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoExcluirMouseEntered
        BotaoExcluir.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoExcluirMouseEntered

    private void BotaoExcluirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoExcluirMouseExited
        BotaoExcluir.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoExcluirMouseExited

    private void CamoCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CamoCaixaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CamoCaixaActionPerformed

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

    public int primeiro;
    public int ultimo;
    int Maximo;
    int Minimo;
    
    public void Frente(){
         
        String sql = "SELECT id, Duplicatas.descricao, datac, valor, Tipo.descricao,Caixas.descricaocaixa, membros.NomeCompleto,IDCaixa \n" +
                    "FROM duplicatas\n" +
                    "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                    "INNER JOIN Membros ON Membros.codigomembro = Duplicatas.IDMembro\n" +
                    "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                    "WHERE tipo = 0 AND id < "+ultimo+" ORDER BY ID DESC limit 15";
                                    
        Povoar(sql);
        paginacao();
    }
    
    public void Atras(){
        String sql = "SELECT id, Duplicatas.descricao, datac, valor, Tipo.descricao,Caixas.descricaocaixa, membros.NomeCompleto,IDCaixa \n" +
                    "FROM duplicatas\n" +
                    "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                    "INNER JOIN Membros ON Membros.codigomembro = Duplicatas.IDMembro\n" +
                    "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                    "WHERE tipo = 0 AND id > "+primeiro+" ORDER BY ID DESC limit 15";
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
            int rows = TabelaEntradas.getRowCount();
            primeiro = Integer.parseInt(TabelaEntradas.getValueAt(0,1).toString());
            ultimo = Integer.parseInt(TabelaEntradas.getValueAt(rows-1,1).toString());
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
        String sql = "Select Max(id),min(id) from duplicatas WHERE tipo = 0";
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
    private javax.swing.JButton Atras;
    private javax.swing.JButton BotaoAdicionar;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField CamoCaixa;
    private javax.swing.JTextField CampoCodigo;
    private javax.swing.JTextField CampoPesquisa;
    private javax.swing.JTextField CampoResultados;
    private javax.swing.JButton Frente;
    private javax.swing.JTable TabelaEntradas;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
