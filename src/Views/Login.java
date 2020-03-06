/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseUsuario;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();

    
    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    

    
    public void Verificar(String sql){
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            while(rs.next()){
                ClasseUsuario.NomeUsuario = rs.getString("NomeUsuario");
                ClasseUsuario.Senha = rs.getString("Senha");
                ClasseUsuario.Caixas = rs.getBoolean("Caixas");
                ClasseUsuario.Despesas = rs.getBoolean("Despesas");
                ClasseUsuario.Entradas = rs.getBoolean("Entradas");
                ClasseUsuario.Membros = rs.getBoolean("Membros");
                ClasseUsuario.Relatorios = rs.getBoolean("Relatorios");
                ClasseUsuario.Usuarios = rs.getBoolean("Usuarios");
                ClasseUsuario.Configuracoes = rs.getBoolean("Configuracoes");
            }
            stmt.close();
            rs.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null," Um erro ocorreu durante a tentativa de login"+e );
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        CampoUsuario = new javax.swing.JTextField();
        CampoSenha = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BotaoAcessar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BotaoGlobais1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adonai Soft Versão 1.0.0 Beta");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(1, 1, 34));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        CampoUsuario.setBackground(new java.awt.Color(1, 1, 34));
        CampoUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CampoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        CampoUsuario.setBorder(null);

        CampoSenha.setBackground(new java.awt.Color(1, 1, 34));
        CampoSenha.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        CampoSenha.setForeground(new java.awt.Color(255, 255, 255));
        CampoSenha.setBorder(null);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuário");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Senha");

        BotaoAcessar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoAcessar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoAcessar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoAcessar.setText("Acessar");
        BotaoAcessar.setBorder(null);
        BotaoAcessar.setBorderPainted(false);
        BotaoAcessar.setFocusPainted(false);
        BotaoAcessar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoAcessarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoAcessarMouseExited(evt);
            }
        });
        BotaoAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAcessarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ink Free", 1, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(60, 63, 65));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("By Geovane.Araújo");

        BotaoGlobais1.setBackground(new java.awt.Color(255, 255, 255));
        BotaoGlobais1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotaoGlobais1.setText("X");
        BotaoGlobais1.setBorder(null);
        BotaoGlobais1.setFocusPainted(false);
        BotaoGlobais1.setFocusable(false);
        BotaoGlobais1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoGlobais1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoGlobais1MouseExited(evt);
            }
        });
        BotaoGlobais1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoGlobais1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 64, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))
                    .addComponent(BotaoGlobais1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CampoSenha)
                    .addComponent(CampoUsuario)
                    .addComponent(BotaoAcessar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(BotaoGlobais1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotaoAcessar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel4))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/AdonaiSoft.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAcessarActionPerformed
        String sql = "SELECT * FROM Usuario WHERE NomeUsuario ='"+CampoUsuario.getText()+"'";
        Verificar(sql);
        
        if(CampoUsuario.getText().equals(ClasseUsuario.NomeUsuario) && CampoSenha.getText().equals(ClasseUsuario.Senha)){
            Principal principal = new Principal();
            principal.bloquear();
            principal.setVisible(true);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos");
        }
        
    }//GEN-LAST:event_BotaoAcessarActionPerformed

    private void BotaoGlobais1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoGlobais1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoGlobais1MouseEntered

    private void BotaoGlobais1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoGlobais1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoGlobais1MouseExited

    private void BotaoGlobais1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGlobais1ActionPerformed
        System.exit(WIDTH);
        
    }//GEN-LAST:event_BotaoGlobais1ActionPerformed

    private void BotaoAcessarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAcessarMouseEntered
        BotaoAcessar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoAcessarMouseEntered

    private void BotaoAcessarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAcessarMouseExited
        BotaoAcessar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoAcessarMouseExited

    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BotaoAcessar;
    private javax.swing.JButton BotaoGlobais1;
    private javax.swing.JPasswordField CampoSenha;
    private javax.swing.JTextField CampoUsuario;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
