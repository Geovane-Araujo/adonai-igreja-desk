
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseConfiguracoes;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class TabelaConfiguracoes extends javax.swing.JPanel {
    ConexaoBanco conectar = new ConexaoBanco();

    
    public TabelaConfiguracoes() {
        initComponents();
        setSize(MenuConfiguracoes.l,MenuConfiguracoes.a);
    }
    

    public void Preencher(String sql){
        Connection con = conectar.Conectar();
        PreparedStatement stmt  = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaIgreja.getModel();
            Model.setNumRows(0);
            while(rs.next()){
                Model.addRow(new Object[]{
                     rs.getString("CodiIgreja"),
                     rs.getString("NomeIgreja"),
                     rs.getString("CNPJIgreja"),
                     rs.getString("EnderecoIgreja"),
                     rs.getString("BairroIgreja"),
                     rs.getString("CidadeIgreja"),
                     rs.getString("TelefoneIgreja"),
                     rs.getString("PastorIgreja")
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaIgreja = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        BotaoEditar = new javax.swing.JButton();
        CampoIgreja = new javax.swing.JTextField();
        CampoCodigo = new javax.swing.JTextField();
        Buscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(219, 230, 244));
        setForeground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(838, 579));

        TabelaIgreja.setBackground(new java.awt.Color(255, 255, 255));
        TabelaIgreja.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaIgreja.setForeground(new java.awt.Color(0, 0, 0));
        TabelaIgreja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome da Igreja", "CNPJ", "Endereço", "Bairro", "Cidade", "Telefone", "Pastor Responsável"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

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
            TabelaIgreja.getColumnModel().getColumn(0).setPreferredWidth(5);
            TabelaIgreja.getColumnModel().getColumn(1).setPreferredWidth(200);
            TabelaIgreja.getColumnModel().getColumn(2).setPreferredWidth(10);
            TabelaIgreja.getColumnModel().getColumn(3).setPreferredWidth(50);
            TabelaIgreja.getColumnModel().getColumn(4).setPreferredWidth(10);
            TabelaIgreja.getColumnModel().getColumn(5).setPreferredWidth(10);
            TabelaIgreja.getColumnModel().getColumn(6).setPreferredWidth(5);
            TabelaIgreja.getColumnModel().getColumn(7).setPreferredWidth(10);
        }

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Cadastro da Igreja");

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

        CampoIgreja.setBackground(new java.awt.Color(219, 230, 244));
        CampoIgreja.setForeground(new java.awt.Color(219, 230, 244));
        CampoIgreja.setBorder(null);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CampoIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 516, Short.MAX_VALUE)
                        .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CampoIgreja)
                        .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        CadastroIgreja chamar = new CadastroIgreja(null, true);
        chamar.povoar();
        chamar.setVisible(true);
    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void CampoCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCodigoActionPerformed

    private void CampoCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoCodigoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoCodigoKeyTyped

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
       String sql = "SELECT * FROM Configuracoes";
        Preencher(sql);
    }//GEN-LAST:event_BuscarActionPerformed

    private void TabelaIgrejaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaIgrejaMouseClicked
        int linha = TabelaIgreja.getSelectedRow();
        CampoIgreja.setText(TabelaIgreja.getValueAt(linha, 1).toString());
        CampoCodigo.setText(TabelaIgreja.getValueAt(linha, 0).toString());
        ClasseConfiguracoes.CodigoIgreja = Integer.parseInt(CampoCodigo.getText());
        
        if(evt.getClickCount() == 2){
            CadastroIgreja chamar = new CadastroIgreja(null, true);
            chamar.povoar();
            chamar.setVisible(true);
        }
    }//GEN-LAST:event_TabelaIgrejaMouseClicked

    private void BuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseEntered
       Buscar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BuscarMouseEntered

    private void BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMouseExited
        Buscar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BuscarMouseExited

    private void BotaoEditarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarMouseEntered
        BotaoEditar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoEditarMouseEntered

    private void BotaoEditarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEditarMouseExited
        BotaoEditar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoEditarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton Buscar;
    private javax.swing.JTextField CampoCodigo;
    private javax.swing.JTextField CampoIgreja;
    private javax.swing.JTable TabelaIgreja;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
