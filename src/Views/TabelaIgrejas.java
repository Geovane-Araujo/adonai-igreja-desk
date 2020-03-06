
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseCadIgrejas;
import Model.ClasseRotas;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showConfirmDialog;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class TabelaIgrejas extends javax.swing.JPanel {
    
    ConexaoBanco conectar = new ConexaoBanco();
    ClasseRotas rota = new ClasseRotas();
    
      public TabelaIgrejas() {
        initComponents();
          setSize(MenuSecretaria.l,MenuSecretaria.a);
        
          
        
        int r = TabelaIgreja.getRowCount();
        String re = Integer.toString(r);
        
        
   
    }
    
    

    public void preencher(String sql){
        
        
        
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            ResultSet rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaIgreja.getModel();
            Model.setNumRows(0);
            boolean check = false;
            
            // numero de linhas na tabela
            
            while(rs.next()){
                Model.addRow(new Object[]{
                    check,
                    rs.getString("ID_Igreja"),
                    rs.getString("NomeIgreja"),
                    rs.getString("Telefone"),
                    rs.getString("PastorResponsavel"),
                    rs.getString("Email"),
                    
                    
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
        TabelaIgreja = new javax.swing.JTable();
        Adicionar = new javax.swing.JButton();
        BotaoEditar = new javax.swing.JButton();
        Excluir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CampoPesquisar = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();
        CampoCodigo = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(219, 230, 244));

        BotaoImprimir.setBackground(new java.awt.Color(1, 1, 34));
        BotaoImprimir.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoImprimir.setForeground(new java.awt.Color(255, 255, 255));
        BotaoImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Envelope_26px.png"))); // NOI18N
        BotaoImprimir.setText("E-mail");
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

        TabelaIgreja.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaIgreja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "ID", "Igreja", "Telefone", "Pastor Responsável", "E-mail"
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
        TabelaIgreja.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaIgreja.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaIgreja.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TabelaIgreja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaIgrejaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaIgreja);
        if (TabelaIgreja.getColumnModel().getColumnCount() > 0) {
            TabelaIgreja.getColumnModel().getColumn(0).setMinWidth(20);
            TabelaIgreja.getColumnModel().getColumn(0).setPreferredWidth(15);
            TabelaIgreja.getColumnModel().getColumn(0).setMaxWidth(20);
            TabelaIgreja.getColumnModel().getColumn(1).setPreferredWidth(10);
            TabelaIgreja.getColumnModel().getColumn(2).setPreferredWidth(400);
            TabelaIgreja.getColumnModel().getColumn(3).setPreferredWidth(50);
            TabelaIgreja.getColumnModel().getColumn(4).setPreferredWidth(100);
            TabelaIgreja.getColumnModel().getColumn(5).setPreferredWidth(200);
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
        jLabel8.setText("Contato de Igrejas");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
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
                        .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Excluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BotaoImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            
            
            ClasseCadIgrejas.ID_Igreja = Integer.parseInt(CampoCodigo.getText());
            CadastroContatoIgrejas ad = new CadastroContatoIgrejas(null, true);
            ad.setVisible(true);
            ad.Povoar();
            String sql = rota.getRTIgrejas();
            preencher(sql);  
        }   
    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void CampoPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoPesquisarActionPerformed

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        CadastroContatoIgrejas ad = new CadastroContatoIgrejas(null, true);
        ad.setVisible(true);
        String sql = rota.getRTIgrejas();
        preencher(sql);
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

        String sql = rota.getRTIgrejas();
        
        preencher(sql);
    }//GEN-LAST:event_BuscarActionPerformed

    private void CampoPesquisarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoPesquisarKeyTyped
        String sql = "SELECT ID_Igreja,NomeIgreja,Telefone,PastorResponsavel,Email FROM Membros "
                + "WHERE Nemeigreja LIKE'%"+ CampoPesquisar.getText()+"%'";
        preencher(sql);
    }//GEN-LAST:event_CampoPesquisarKeyTyped

    private void TabelaIgrejaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaIgrejaMouseClicked
        
        int linha = TabelaIgreja.getSelectedRow();
        CampoCodigo.setText(TabelaIgreja.getValueAt(linha,1).toString());
        
       
        ClasseCadIgrejas.ID_Igreja = Integer.parseInt(CampoCodigo.getText());
        if(evt.getClickCount() == 2){
            System.out.println(ClasseCadIgrejas.ID_Igreja);
            CadastroContatoIgrejas chamar = new CadastroContatoIgrejas(null, true);
            chamar.Povoar();
            chamar.setVisible(true);
            String sql = rota.getRTIgrejas();
            preencher(sql);
            
        }
            
        
        
    }//GEN-LAST:event_TabelaIgrejaMouseClicked

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
                    ClasseCadIgrejas.ID_Igreja = Integer.parseInt(CampoCodigo.getText());
                    ClasseCadIgrejas ex = new ClasseCadIgrejas();
                    ex.Deletar();
                    String sql = rota.getRTIgrejas();
                    preencher(sql);
                break;

                case 1:
                break;       
            }
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
            TelaEmail envio = new TelaEmail(null, true);
            envio.setVisible(true);
    }//GEN-LAST:event_BotaoImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Adicionar;
    public static javax.swing.JButton BotaoEditar;
    public static javax.swing.JButton BotaoImprimir;
    public static javax.swing.JButton Buscar;
    public static javax.swing.JTextField CampoCodigo;
    public static javax.swing.JTextField CampoPesquisar;
    public static javax.swing.JButton Excluir;
    public static javax.swing.JTable TabelaIgreja;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    void setSize(int MAXIMIZED_BOTH) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



