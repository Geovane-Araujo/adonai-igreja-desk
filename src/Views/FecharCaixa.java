
package Views;
import BancoDados.ConexaoBanco;
import Converter.Data;
import Converter.DataHora;
import Model.ClasseCaixas;
import Model.ClasseRotas;
import Model.ClasseUsuario;
import Model.Relatorios;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;

public class FecharCaixa extends javax.swing.JDialog {

    ClasseCaixas Entrada = new ClasseCaixas();
    ConexaoBanco conectar = new ConexaoBanco();
    Relatorios relatorio = new Relatorios();
    ClasseRotas rota = new ClasseRotas();
    Date data = new Date();
    DataHora dt = new DataHora();
    String formato = "0.00";
    DecimalFormat df = new DecimalFormat(formato);


    public FecharCaixa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CampoSaldo2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        CodigoCaixa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CampoDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CampoSaldoInicial = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BotaoFechar = new javax.swing.JButton();
        CampoEntradas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CampoSaidas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CampoTotal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CampoData = new com.toedter.calendar.JDateChooser();
        CampoDataFechamento = new com.toedter.calendar.JDateChooser();

        CampoSaldo2.setEditable(false);
        CampoSaldo2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Entradas");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fechamento de Caixa");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        CodigoCaixa.setEditable(false);
        CodigoCaixa.setBackground(new java.awt.Color(238, 238, 238));
        CodigoCaixa.setBorder(null);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Descrição");

        CampoDescricao.setEditable(false);
        CampoDescricao.setBackground(new java.awt.Color(255, 255, 255));
        CampoDescricao.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoDescricao.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Saldo Inicial:");

        CampoSaldoInicial.setEditable(false);
        CampoSaldoInicial.setBackground(new java.awt.Color(255, 255, 255));
        CampoSaldoInicial.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoSaldoInicial.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data Abertura: ");

        BotaoFechar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoFechar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoFechar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Password_26px.png"))); // NOI18N
        BotaoFechar.setText("Fechar Caixa");
        BotaoFechar.setBorder(null);
        BotaoFechar.setBorderPainted(false);
        BotaoFechar.setFocusPainted(false);
        BotaoFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoFecharMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoFecharMouseExited(evt);
            }
        });
        BotaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoFecharActionPerformed(evt);
            }
        });

        CampoEntradas.setEditable(false);
        CampoEntradas.setBackground(new java.awt.Color(255, 255, 255));
        CampoEntradas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoEntradas.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Entradas:");

        CampoSaidas.setEditable(false);
        CampoSaidas.setBackground(new java.awt.Color(255, 255, 255));
        CampoSaidas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoSaidas.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Saídas:");

        CampoTotal.setEditable(false);
        CampoTotal.setBackground(new java.awt.Color(255, 255, 255));
        CampoTotal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoTotal.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Total:");

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Data Fechamento:");

        CampoData.setBackground(new java.awt.Color(255, 255, 255));
        CampoData.setForeground(new java.awt.Color(0, 0, 0));
        CampoData.setDateFormatString("dd/MM/yyyy");
        CampoData.setEnabled(false);
        CampoData.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        CampoDataFechamento.setBackground(new java.awt.Color(255, 255, 255));
        CampoDataFechamento.setForeground(new java.awt.Color(0, 0, 0));
        CampoDataFechamento.setDateFormatString("dd/MM/yyyy");
        CampoDataFechamento.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CampoEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(223, 223, 223)
                                        .addComponent(jLabel9)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CampoSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CampoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6)
                                    .addComponent(CampoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(CampoSaldoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel10)
                                    .addComponent(CampoData, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoDataFechamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BotaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CodigoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(38, 38, 38)
                                .addComponent(jLabel9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(5, 5, 5)
                                .addComponent(CampoData, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoDataFechamento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoSaldoInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoSaidas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CodigoCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFecharActionPerformed
        
        
        
        Entrada.setDataFechamento((java.sql.Date) dt.DataBd(CampoDataFechamento.getDate()));
        Entrada.setSaldo(Double.parseDouble(CampoTotal.getText().replace(",","."))) ;
        Entrada.setQuemFechou(ClasseUsuario.NomeUsuario);
        Entrada.setEntradas(Double.parseDouble(CampoEntradas.getText().replace(",",".")));
        Entrada.setStatus("Caixa Fechado");
        Entrada.setSaidas(Double.parseDouble(CampoSaidas.getText().replace(",",".")));
        Entrada.setCodigoCaixa(Integer.parseInt(CodigoCaixa.getText()));
        Entrada.FecharCaixa();
        this.dispose();
        gerarfechamento();
        
        
        
    }//GEN-LAST:event_BotaoFecharActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        CampoDataFechamento.setDate(data);
        Povoar();
    }//GEN-LAST:event_formWindowOpened

    private void BotaoFecharMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoFecharMouseEntered
        BotaoFechar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoFecharMouseEntered

    private void BotaoFecharMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoFecharMouseExited
        BotaoFechar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoFecharMouseExited

    public void gerarfechamento(){
            
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
    }
    public void Povoar(){
          
       String sql = "SELECT * FROM Caixas WHERE  CodigoCaixa= "+Entrada.getCodigoCaixa();
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try{
            
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();
            
            
            double valorInicial = Double.parseDouble(rs.getString("saldoinicial"));
            double ValorEntradas = Entrada.getSomaEntradas();
            double ValorSaidas   = Entrada.getSomaDespesas();
            double ValorTotal = TabelaCaixas.total;
            CodigoCaixa.setText(rs.getString("codigocaixa"));
            CampoDescricao.setText(rs.getString("descricaocaixa"));
            CampoData.setDate(rs.getDate("dataabertura"));
            CampoSaldoInicial.setText(String.valueOf(df.format(valorInicial)));
            
            CampoEntradas.setText(String.valueOf(df.format(ValorEntradas)));
            CampoSaidas.setText(String.valueOf(df.format(ValorSaidas)));
            CampoTotal.setText(String.valueOf(df.format(ValorTotal)));
            
            rs.close();
            stmt.close();

        }
        catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Ops ocorreu um erro ao preencher os campos, por favor verifique -> " +e);
        }   
        
        
    }
    
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
            java.util.logging.Logger.getLogger(FecharCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FecharCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FecharCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FecharCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FecharCaixa dialog = new FecharCaixa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BotaoFechar;
    private com.toedter.calendar.JDateChooser CampoData;
    private com.toedter.calendar.JDateChooser CampoDataFechamento;
    private javax.swing.JTextField CampoDescricao;
    private javax.swing.JTextField CampoEntradas;
    private javax.swing.JTextField CampoSaidas;
    private javax.swing.JTextField CampoSaldo2;
    private javax.swing.JTextField CampoSaldoInicial;
    private javax.swing.JTextField CampoTotal;
    private javax.swing.JTextField CodigoCaixa;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
