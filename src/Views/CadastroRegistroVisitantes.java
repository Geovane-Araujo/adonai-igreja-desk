
package Views;

import BancoDados.ConexaoBanco;
import Converter.DataHora;
import Model.ClasseVisitantes;
import java.awt.Color;
import java.util.Date;

public class CadastroRegistroVisitantes extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();
    Date data = new Date();
    DataHora dt = new DataHora();

   
    public CadastroRegistroVisitantes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void Limpar(){
        
        CampoNomeVisita.setText("");
        CampoDenominacao.setText("");
        
               
    }
    
 
    
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        CampoCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CampoNomeVisita = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BotaoSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoDenominacao = new javax.swing.JTextArea();
        BuscarCaixas = new javax.swing.JButton();
        CampoData = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro dos Visitantes");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(238, 238, 238));

        CampoCodigo.setEditable(false);
        CampoCodigo.setBackground(new java.awt.Color(238, 238, 238));
        CampoCodigo.setBorder(null);
        CampoCodigo.setEnabled(false);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome do Visitante:");

        CampoNomeVisita.setBackground(new java.awt.Color(255, 255, 255));
        CampoNomeVisita.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoNomeVisita.setForeground(new java.awt.Color(0, 0, 0));
        CampoNomeVisita.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CampoNomeVisitaKeyPressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data:");

        BotaoSalvar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoSalvar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoSalvar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        BotaoSalvar.setText("Salvar");
        BotaoSalvar.setBorder(null);
        BotaoSalvar.setBorderPainted(false);
        BotaoSalvar.setFocusPainted(false);
        BotaoSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoSalvarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoSalvarMouseExited(evt);
            }
        });
        BotaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvarActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Denominação:");

        CampoDenominacao.setBackground(new java.awt.Color(255, 255, 255));
        CampoDenominacao.setColumns(20);
        CampoDenominacao.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoDenominacao.setForeground(new java.awt.Color(0, 0, 0));
        CampoDenominacao.setRows(5);
        jScrollPane1.setViewportView(CampoDenominacao);

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

        CampoData.setBackground(new java.awt.Color(255, 255, 255));
        CampoData.setForeground(new java.awt.Color(0, 0, 0));
        CampoData.setDateFormatString("dd/MM/yyyy");
        CampoData.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(CampoNomeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(BuscarCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(108, 108, 108))
                                    .addComponent(CampoData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(49, 49, 49))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CampoNomeVisita, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BuscarCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CampoData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 460, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
        ClasseVisitantes.IdVisitante = Integer.parseInt(CampoCodigo.getText());
        ClasseVisitantes.DataVisitah = (java.sql.Date) dt.DataBd(CampoData.getDate());
        ClasseVisitantes.Denominacaoh = CampoDenominacao.getText();
        
        
        
        
        ClasseVisitantes inserir = new ClasseVisitantes();
        
       
                inserir.InserirRegistro();
                Limpar();
            
           
        
    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void BuscarCaixasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarCaixasMouseEntered
        BuscarCaixas.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BuscarCaixasMouseEntered

    private void BuscarCaixasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarCaixasMouseExited
        BuscarCaixas.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BuscarCaixasMouseExited

    private void BuscarCaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarCaixasActionPerformed

        PesquisaVisitantes chamar = new PesquisaVisitantes(null, true);
        chamar.setVisible(true);

    }//GEN-LAST:event_BuscarCaixasActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CampoData.setDate(data);
    }//GEN-LAST:event_formWindowOpened

    private void BotaoSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseEntered
        BotaoSalvar.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoSalvarMouseEntered

    private void BotaoSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseExited
        BotaoSalvar.setBackground(new Color (1,1,34));
    }//GEN-LAST:event_BotaoSalvarMouseExited

    private void CampoNomeVisitaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoNomeVisitaKeyPressed
        PesquisaVisitantes chamar = new PesquisaVisitantes(null, true);
        chamar.setVisible(true);
    }//GEN-LAST:event_CampoNomeVisitaKeyPressed

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
            java.util.logging.Logger.getLogger(CadastroRegistroVisitantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroRegistroVisitantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroRegistroVisitantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroRegistroVisitantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                CadastroRegistroVisitantes dialog = new CadastroRegistroVisitantes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BotaoSalvar;
    private javax.swing.JButton BuscarCaixas;
    public static javax.swing.JTextField CampoCodigo;
    private com.toedter.calendar.JDateChooser CampoData;
    private javax.swing.JTextArea CampoDenominacao;
    public static javax.swing.JTextField CampoNomeVisita;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
