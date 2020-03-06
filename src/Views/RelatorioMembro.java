
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseMembros;
import Model.ClasseRotas;
import Model.Relatorios;
import Model.VariaveisUniversais;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;


public class RelatorioMembro extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();
    VariaveisUniversais relatorio = new VariaveisUniversais();
    ClasseRotas rota = new ClasseRotas();
    

    
    public RelatorioMembro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BuscarMembros = new javax.swing.JButton();
        CampoCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CampoNomeMembro = new javax.swing.JTextField();
        BotaoGerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar carteirinha de Membro");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        BuscarMembros.setBackground(new java.awt.Color(1, 1, 34));
        BuscarMembros.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BuscarMembros.setForeground(new java.awt.Color(255, 255, 255));
        BuscarMembros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Search_15px.png"))); // NOI18N
        BuscarMembros.setBorder(null);
        BuscarMembros.setBorderPainted(false);
        BuscarMembros.setFocusPainted(false);
        BuscarMembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BuscarMembrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BuscarMembrosMouseExited(evt);
            }
        });
        BuscarMembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarMembrosActionPerformed(evt);
            }
        });

        CampoCodigo.setEditable(false);
        CampoCodigo.setBackground(new java.awt.Color(238, 238, 238));
        CampoCodigo.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        CampoCodigo.setBorder(null);
        CampoCodigo.setEnabled(false);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome Do Membro");

        CampoNomeMembro.setBackground(new java.awt.Color(255, 255, 255));
        CampoNomeMembro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoNomeMembro.setForeground(new java.awt.Color(0, 0, 0));

        BotaoGerar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoGerar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoGerar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoGerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imprimir.png"))); // NOI18N
        BotaoGerar.setText("Gerar");
        BotaoGerar.setBorder(null);
        BotaoGerar.setBorderPainted(false);
        BotaoGerar.setFocusPainted(false);
        BotaoGerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoGerarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoGerarMouseExited(evt);
            }
        });
        BotaoGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoGerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BotaoGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CampoNomeMembro, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscarMembros, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoNomeMembro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarMembros, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(255, 255, 255))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGerarActionPerformed
        
        //Relatório de Certificado
        
        if(relatorio.getRelatorios()==3){
              ClasseMembros.NomeCompleto = CampoNomeMembro.getText();
              ClasseMembros.CodigoMembros = Integer.parseInt(CampoCodigo.getText());
              


             Relatorios imprimir = new Relatorios();
             
            try {
                imprimir.Certificado();
                
            } catch (JRException ex) {
                Logger.getLogger(RelatorioMembro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(RelatorioMembro.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
                 
                 this.dispose();
        }
        else{
            ClasseMembros.CodigoMembros = Integer.parseInt(CampoCodigo.getText());
  
            Relatorios imprimir = new Relatorios();
            try {
                imprimir.CarteiraMembro();
                
            } catch (JRException ex) {
                Logger.getLogger(CadastroMembro.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CadastroMembro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                TelaRelatorio fech = new TelaRelatorio(null, true);
                fech.setVisible(false);
                this.dispose();
        }
        
        
  
    }//GEN-LAST:event_BotaoGerarActionPerformed

    private void BuscarMembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarMembrosActionPerformed
        VariaveisUniversais.Entrada = 2;
        PesquisaMembros chamar = new PesquisaMembros(null, true);
        chamar.setVisible(true);
        
    }//GEN-LAST:event_BuscarMembrosActionPerformed

    private void BuscarMembrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMembrosMouseEntered
        BuscarMembros.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BuscarMembrosMouseEntered

    private void BuscarMembrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMembrosMouseExited
        BuscarMembros.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BuscarMembrosMouseExited

    private void BotaoGerarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoGerarMouseEntered
        BotaoGerar.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoGerarMouseEntered

    private void BotaoGerarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoGerarMouseExited
        BotaoGerar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoGerarMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(RelatorioMembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioMembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioMembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioMembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RelatorioMembro dialog = new RelatorioMembro(new javax.swing.JFrame(), true);
                
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
    private javax.swing.JButton BotaoGerar;
    private javax.swing.JButton BuscarMembros;
    public static javax.swing.JTextField CampoCodigo;
    public static javax.swing.JTextField CampoNomeMembro;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
