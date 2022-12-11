
package view.contatoIgrejas.search;

import database.ConexaoBanco;
import view.gerais.TelaEmail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class PesquisaIgrejas extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();

    
    public PesquisaIgrejas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    String sql = "SELECT ID_Igreja, NomeIgreja,Email FROM Igrejas";
    
    public void povoar(String sql){
        
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaMembros.getModel();
            Model.setNumRows(0);
            
            while(rs.next()){
                Model.addRow(new Object[]{
                    rs.getString("ID_Igreja"),
                    rs.getString("NomeIgreja"),
                    rs.getString("Email")
                });
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CampoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaMembros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Membros");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        CampoNome.setBackground(new java.awt.Color(255, 255, 255));
        CampoNome.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoNome.setForeground(new java.awt.Color(0, 0, 0));
        CampoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNomeActionPerformed(evt);
            }
        });
        CampoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoNomeKeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nome da Igreja:");

        TabelaMembros.setBackground(new java.awt.Color(255, 255, 255));
        TabelaMembros.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaMembros.setForeground(new java.awt.Color(0, 0, 0));
        TabelaMembros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

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
        jScrollPane1.setViewportView(TabelaMembros);
        if (TabelaMembros.getColumnModel().getColumnCount() > 0) {
            TabelaMembros.getColumnModel().getColumn(0).setPreferredWidth(1);
            TabelaMembros.getColumnModel().getColumn(1).setPreferredWidth(250);
            TabelaMembros.getColumnModel().getColumn(2).setPreferredWidth(200);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoNome))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CampoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoNomeActionPerformed

    private void CampoNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoNomeKeyTyped
        String sql = "SELECT ID_Igreja, NomeIgreja,Email FROM Membros "
                + "WHERE NomeIgreja LIKE'%"+ CampoNome.getText()+"%'";
        povoar(sql);
        
    }//GEN-LAST:event_CampoNomeKeyTyped

    private void TabelaMembrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaMembrosMouseClicked
        int linha = TabelaMembros.getSelectedRow();
        TelaEmail.CampoDestinatario.setText(TabelaMembros.getValueAt(linha,2).toString());
        this.dispose();
        
            
            
        
       
           
        
        
        
        
    }//GEN-LAST:event_TabelaMembrosMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String sql = "SELECT ID_Igreja, NomeIgreja,Email FROM Igrejas";
        povoar(sql);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(PesquisaIgrejas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaIgrejas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaIgrejas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaIgrejas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PesquisaIgrejas dialog = new PesquisaIgrejas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoNome;
    private javax.swing.JTable TabelaMembros;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
