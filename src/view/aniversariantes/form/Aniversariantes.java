
package view.aniversariantes.form;

import database.ConexaoBanco;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;

public class Aniversariantes extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public boolean check = false;
    int mes;
    
    

   
    public Aniversariantes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
            
            DefaultTableModel Model = (DefaultTableModel) TabelaTurma.getModel();
            Model.setNumRows(0);
            
            
            while(rs.next()){
                     
                
                Model.addRow(new Object[]{
                    check,
                    rs.getString("NomeCompleto"),
                    sdf.format(rs.getDate("datanascimento")),
 
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

        ProfessorAluno = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaTurma = new javax.swing.JTable();
        BotaoSalvar1 = new javax.swing.JButton();
        CampoMes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aniversariantes");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(238, 238, 238));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Mês do Nascimento:");

        TabelaTurma.setBackground(new java.awt.Color(255, 255, 255));
        TabelaTurma.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaTurma.setForeground(new java.awt.Color(0, 0, 0));
        TabelaTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Aniversariante", "Data Nascimento"
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
        TabelaTurma.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaTurma.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaTurma.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TabelaTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaTurmaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaTurma);
        if (TabelaTurma.getColumnModel().getColumnCount() > 0) {
            TabelaTurma.getColumnModel().getColumn(0).setMinWidth(20);
            TabelaTurma.getColumnModel().getColumn(0).setPreferredWidth(20);
            TabelaTurma.getColumnModel().getColumn(0).setMaxWidth(20);
            TabelaTurma.getColumnModel().getColumn(1).setPreferredWidth(250);
            TabelaTurma.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        BotaoSalvar1.setBackground(new java.awt.Color(1, 1, 34));
        BotaoSalvar1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoSalvar1.setForeground(new java.awt.Color(255, 255, 255));
        BotaoSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Busacar.png"))); // NOI18N
        BotaoSalvar1.setText("Buscar");
        BotaoSalvar1.setBorder(null);
        BotaoSalvar1.setBorderPainted(false);
        BotaoSalvar1.setFocusPainted(false);
        BotaoSalvar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoSalvar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoSalvar1MouseExited(evt);
            }
        });
        BotaoSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvar1ActionPerformed(evt);
            }
        });

        CampoMes.setBackground(new java.awt.Color(255, 255, 255));
        CampoMes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoMes.setForeground(new java.awt.Color(0, 0, 0));
        CampoMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(CampoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BotaoSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
  
        String sql = "SELECT nomecompleto,datanascimento   \n" +
                        " From membros \n" +
                        " WHERE EXTRACT(MONTH FROM datanascimento) = Extract(Month From Now()) ";
        
        Povoar(sql);
    }//GEN-LAST:event_formWindowOpened

    private void BotaoSalvar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvar1MouseEntered
        BotaoSalvar1.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoSalvar1MouseEntered

    private void BotaoSalvar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvar1MouseExited
        BotaoSalvar1.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoSalvar1MouseExited

    private void BotaoSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvar1ActionPerformed

        mes = CampoMes.getSelectedIndex();
        mes = mes + 1;
        System.out.println(mes);
        
        
        String sql = "SELECT nomecompleto,datanascimento   \n" +
                        " From membros \n" +
                        " WHERE EXTRACT(MONTH FROM datanascimento) =" +mes;
        Povoar(sql);

    }//GEN-LAST:event_BotaoSalvar1ActionPerformed

    private void TabelaTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaTurmaMouseClicked

    }//GEN-LAST:event_TabelaTurmaMouseClicked

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
            java.util.logging.Logger.getLogger(Aniversariantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aniversariantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aniversariantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aniversariantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Aniversariantes dialog = new Aniversariantes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BotaoSalvar1;
    private javax.swing.JComboBox<String> CampoMes;
    private javax.swing.ButtonGroup ProfessorAluno;
    private javax.swing.JTable TabelaTurma;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
