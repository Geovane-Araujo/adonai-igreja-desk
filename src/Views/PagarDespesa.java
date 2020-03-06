
package Views;

import BancoDados.ConexaoBanco;
import Converter.DataHora;
import Converter.Virgula;
import Model.ClasseDespesas;
import Model.ClasseUsuario;
import Model.Var.VarDespesas;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;


public class PagarDespesa extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();
    ClasseDespesas post = new ClasseDespesas();
    VarDespesas despesas = new VarDespesas();
    Virgula vir = new Virgula();
    Date data = new Date();
    DataHora dt = new DataHora();
    ClasseUsuario us = new ClasseUsuario();
    String formato = "0.00";
    DecimalFormat df = new DecimalFormat(formato);
    

   
    
    public PagarDespesa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        CampoUsuário.setText(ClasseUsuario.NomeUsuario);
   }

    
    public void povoar(){
        String sql = "SELECT id, Duplicatas.descricao, datav, valor,Caixas.descricaocaixa\n" +
                        "FROM duplicatas\n" +
                        "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                        "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                        "WHERE ID = "+ despesas.getID();
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            while(rs.next()){
                double valor = Double.parseDouble(rs.getString("Valor"));
                CampoCodigo.setText(rs.getString("ID"));
                CampoDescricao.setText(rs.getString("Descricao"));
                CampoValorDespesa.setText(String.valueOf(df.format(valor)));
                CampoDataVencimento.setDate(rs.getDate("DataV"));
                CampoCaixa.setText(rs.getString("DescricaoCaixa"));
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
        CampoCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CampoDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CampoValorDespesa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BotaoPagar = new javax.swing.JButton();
        CampoCaixa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CampoUsuário = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CampoDataVencimento = new com.toedter.calendar.JDateChooser();
        CampoDataPagamento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pagamento de Despesas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        CampoCodigo.setEditable(false);
        CampoCodigo.setBackground(new java.awt.Color(238, 238, 238));
        CampoCodigo.setForeground(new java.awt.Color(238, 238, 238));
        CampoCodigo.setBorder(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Descrição");

        CampoDescricao.setEditable(false);
        CampoDescricao.setBackground(new java.awt.Color(255, 255, 255));
        CampoDescricao.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Valor Despesa");

        CampoValorDespesa.setEditable(false);
        CampoValorDespesa.setBackground(new java.awt.Color(255, 255, 255));
        CampoValorDespesa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data Vencimento: ");

        BotaoPagar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoPagar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoPagar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Cash_in_Hand_29px.png"))); // NOI18N
        BotaoPagar.setText("Pagar");
        BotaoPagar.setBorder(null);
        BotaoPagar.setBorderPainted(false);
        BotaoPagar.setFocusPainted(false);
        BotaoPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoPagarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoPagarMouseExited(evt);
            }
        });
        BotaoPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoPagarActionPerformed(evt);
            }
        });

        CampoCaixa.setEditable(false);
        CampoCaixa.setBackground(new java.awt.Color(255, 255, 255));
        CampoCaixa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Caixa:");

        CampoUsuário.setEditable(false);
        CampoUsuário.setBackground(new java.awt.Color(255, 255, 255));
        CampoUsuário.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Usuário:");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Data Pagamento:");

        CampoDataVencimento.setBackground(new java.awt.Color(255, 255, 255));
        CampoDataVencimento.setDateFormatString("dd/MM/yyyy");
        CampoDataVencimento.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        CampoDataPagamento.setBackground(new java.awt.Color(255, 255, 255));
        CampoDataPagamento.setDateFormatString("dd/MM/yyyy");
        CampoDataPagamento.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(209, 209, 209)
                                        .addComponent(jLabel8))
                                    .addComponent(CampoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoValorDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CampoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoUsuário)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3)
                            .addComponent(CampoDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoDataPagamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BotaoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoValorDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoUsuário, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(5, 5, 5)
                        .addComponent(CampoDataPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void BotaoPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoPagarActionPerformed
           
           despesas.setDescricao(CampoDescricao.getText());
           despesas.setValor(vir.Virgula(CampoValorDespesa.getText()));
           despesas.setDataV((java.sql.Date) dt.DataBd(CampoDataVencimento.getDate()));
           despesas.setQuemPagou(CampoUsuário.getText());
           despesas.setDataP((java.sql.Date) dt.DataBd(CampoDataPagamento.getDate()));
           despesas.setStatus("Paga");
           despesas.setID(Integer.parseInt(CampoCodigo.getText()));
           
           
           post.PagarDespesa();  
           this.dispose();
    }//GEN-LAST:event_BotaoPagarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        CampoDataPagamento.setDate(data);
    }//GEN-LAST:event_formWindowOpened

    private void BotaoPagarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPagarMouseEntered
        BotaoPagar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoPagarMouseEntered

    private void BotaoPagarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoPagarMouseExited
        BotaoPagar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoPagarMouseExited

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
            java.util.logging.Logger.getLogger(PagarDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagarDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagarDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagarDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PagarDespesa dialog = new PagarDespesa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BotaoPagar;
    private javax.swing.JTextField CampoCaixa;
    private javax.swing.JTextField CampoCodigo;
    private com.toedter.calendar.JDateChooser CampoDataPagamento;
    private com.toedter.calendar.JDateChooser CampoDataVencimento;
    private javax.swing.JTextField CampoDescricao;
    private javax.swing.JTextField CampoUsuário;
    private javax.swing.JTextField CampoValorDespesa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
