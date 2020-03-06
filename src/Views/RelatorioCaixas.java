
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseCaixas;
import Model.ClasseRotas;
import Model.ClasseTipo;
import Model.Relatorios;
import Model.VariaveisUniversais;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;


public class RelatorioCaixas extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();
    ClasseRotas rota = new ClasseRotas();
    VariaveisUniversais relatorio = new VariaveisUniversais();
    

    
    public RelatorioCaixas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CampoCodigoCaixa = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CampoCaixa = new javax.swing.JTextField();
        BotaoGerar = new javax.swing.JButton();
        BuscarCaixas = new javax.swing.JButton();
        CampoTipo = new javax.swing.JTextField();
        BotaoBuscarTipoRelatorio = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        CampoCodigoTipo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório Caixas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        CampoCodigoCaixa.setEditable(false);
        CampoCodigoCaixa.setBackground(new java.awt.Color(238, 238, 238));
        CampoCodigoCaixa.setForeground(new java.awt.Color(238, 238, 238));
        CampoCodigoCaixa.setBorder(null);
        CampoCodigoCaixa.setEnabled(false);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Descrição do Caixa:");

        CampoCaixa.setBackground(new java.awt.Color(255, 255, 255));
        CampoCaixa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoCaixa.setForeground(new java.awt.Color(0, 0, 0));

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

        BuscarCaixas.setBackground(new java.awt.Color(1, 1, 34));
        BuscarCaixas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BuscarCaixas.setForeground(new java.awt.Color(255, 255, 255));
        BuscarCaixas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Search_15px.png"))); // NOI18N
        BuscarCaixas.setBorder(null);
        BuscarCaixas.setBorderPainted(false);
        BuscarCaixas.setFocusPainted(false);
        BuscarCaixas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BuscarCaixasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BuscarCaixasMouseExited(evt);
            }
        });
        BuscarCaixas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarCaixasActionPerformed(evt);
            }
        });

        CampoTipo.setBackground(new java.awt.Color(255, 255, 255));
        CampoTipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoTipo.setForeground(new java.awt.Color(0, 0, 0));

        BotaoBuscarTipoRelatorio.setBackground(new java.awt.Color(1, 1, 34));
        BotaoBuscarTipoRelatorio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotaoBuscarTipoRelatorio.setForeground(new java.awt.Color(255, 255, 255));
        BotaoBuscarTipoRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Search_15px.png"))); // NOI18N
        BotaoBuscarTipoRelatorio.setBorder(null);
        BotaoBuscarTipoRelatorio.setBorderPainted(false);
        BotaoBuscarTipoRelatorio.setFocusPainted(false);
        BotaoBuscarTipoRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoBuscarTipoRelatorioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoBuscarTipoRelatorioMouseExited(evt);
            }
        });
        BotaoBuscarTipoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscarTipoRelatorioActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Tipo:");

        CampoCodigoTipo.setEditable(false);
        CampoCodigoTipo.setBackground(new java.awt.Color(238, 238, 238));
        CampoCodigoTipo.setForeground(new java.awt.Color(238, 238, 238));
        CampoCodigoTipo.setBorder(null);
        CampoCodigoTipo.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CampoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscarCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CampoTipo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotaoBuscarTipoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BotaoGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCodigoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CampoCodigoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoBuscarTipoRelatorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BotaoGerar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CampoCodigoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CampoCodigoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGerarActionPerformed
        
        if(relatorio.getRelatorios()==1){
            
            ClasseCaixas.CodigoCaixa = Integer.parseInt(CampoCodigoCaixa.getText());
            ClasseTipo.IDTipo = Integer.parseInt(CampoCodigoTipo.getText());
            
            relatorio.setRelatorios(0);


             Relatorios imprimir = new Relatorios();
             
            try {
                imprimir.Dizimistas();
                
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, ex);
                Logger.getLogger(RelatorioCaixas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
                Logger.getLogger(RelatorioCaixas.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
                 TelaRelatorio fech = new TelaRelatorio(null, true);
                 fech.dispose();
                 this.dispose();
             
        }
        
        //Relatório Resumo Caixa
        if(relatorio.getRelatorios()==4){
            
            ClasseCaixas.CodigoCaixa = Integer.parseInt(CampoCodigoCaixa.getText());
           
            relatorio.setRelatorios(0);


             Relatorios imprimir = new Relatorios();
             
            try {
                imprimir.Caixas();
                
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, ex);
                Logger.getLogger(RelatorioCaixas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
                Logger.getLogger(RelatorioCaixas.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
                 TelaRelatorio fech = new TelaRelatorio(null, true);
                 fech.dispose();
                 this.dispose();
        }
        
        if(relatorio.getRelatorios()==5){
            
            ClasseCaixas.CodigoCaixa = Integer.parseInt(CampoCodigoCaixa.getText());
            
            relatorio.setRelatorios(0);


             Relatorios imprimir = new Relatorios();
             
            try {
                imprimir.Entradas();
                
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, ex);
                Logger.getLogger(RelatorioCaixas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
                Logger.getLogger(RelatorioCaixas.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
                 TelaRelatorio fech = new TelaRelatorio(null, true);
                 fech.dispose();
                 this.dispose();
        }
        
        
        if(relatorio.getRelatorios()==6){
            
            ClasseCaixas.CodigoCaixa = Integer.parseInt(CampoCodigoCaixa.getText());
            
            relatorio.setRelatorios(0);


             Relatorios imprimir = new Relatorios();
             
            try {
                imprimir.Despesas();
                
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, ex);
                Logger.getLogger(RelatorioCaixas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
                Logger.getLogger(RelatorioCaixas.class.getName()).log(Level.SEVERE, null, ex);
            }
                 
                 TelaRelatorio fech = new TelaRelatorio(null, true);
                 fech.dispose();
                 this.dispose();
        }

    }//GEN-LAST:event_BotaoGerarActionPerformed

    private void BuscarCaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarCaixasActionPerformed
        VariaveisUniversais.setEntrada(2);
        PesquisaCaixas chamar = new PesquisaCaixas(null, true);
        chamar.setVisible(true);
    }//GEN-LAST:event_BuscarCaixasActionPerformed

    private void BuscarCaixasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarCaixasMouseExited
        BuscarCaixas.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BuscarCaixasMouseExited

    private void BuscarCaixasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarCaixasMouseEntered
        BuscarCaixas.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BuscarCaixasMouseEntered

    private void BotaoGerarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoGerarMouseEntered
        BotaoGerar.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoGerarMouseEntered

    private void BotaoGerarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoGerarMouseExited
        BotaoGerar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoGerarMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(relatorio.getRelatorios()==1){
            
        }
        else{
            BotaoBuscarTipoRelatorio.setEnabled(false);
            CampoTipo.setEditable(false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void BotaoBuscarTipoRelatorioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoBuscarTipoRelatorioMouseEntered
        BotaoBuscarTipoRelatorio.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoBuscarTipoRelatorioMouseEntered

    private void BotaoBuscarTipoRelatorioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoBuscarTipoRelatorioMouseExited
        BotaoBuscarTipoRelatorio.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoBuscarTipoRelatorioMouseExited

    private void BotaoBuscarTipoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscarTipoRelatorioActionPerformed
        
        relatorio.setEscolha(2);
        PesquisaTipo cargo = new PesquisaTipo(null, true);
        cargo.setVisible(true);
    }//GEN-LAST:event_BotaoBuscarTipoRelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(RelatorioCaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RelatorioCaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RelatorioCaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RelatorioCaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                RelatorioCaixas dialog = new RelatorioCaixas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BotaoBuscarTipoRelatorio;
    private javax.swing.JButton BotaoGerar;
    private javax.swing.JButton BuscarCaixas;
    public static javax.swing.JTextField CampoCaixa;
    public static javax.swing.JTextField CampoCodigoCaixa;
    public static javax.swing.JTextField CampoCodigoTipo;
    public static javax.swing.JTextField CampoTipo;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
