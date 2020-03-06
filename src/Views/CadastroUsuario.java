
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseUsuario;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CadastroUsuario extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();

   
    public CadastroUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void Limpar(){
        
        campoNome.setText("");
        CampoSenha.setText("");
        CampoConfirmar.setText("");
        Membros.setSelected(false);
        Conffiguracoes.setSelected(false);
        Despesas.setSelected(false);
        Entradas.setSelected(false);
        Caixas.setSelected(false);
        Usuarios.setSelected(false);
        Relatorios.setSelected(false);
               
    }
    
 
    
    public void Povoar(String sql){
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            while(rs.next()){
                
                CampoCodigo2.setText(rs.getString("CodigoUsuario"));
                campoNome.setText(rs.getString("NomeUsuario"));
                CampoSenha.setText(rs.getString("Senha"));
                CampoConfirmar.setText(rs.getString("ConfirmarSenha"));
                Membros.setSelected(rs.getBoolean("Membros"));
                Entradas.setSelected(rs.getBoolean("Entradas"));
                Despesas.setSelected(rs.getBoolean("Despesas"));
                Usuarios.setSelected(rs.getBoolean("Usuarios"));
                Conffiguracoes.setSelected(rs.getBoolean("Configuracoes"));
                Relatorios.setSelected(rs.getBoolean("relatorios"));
                Caixas.setSelected(rs.getBoolean("Caixas"));
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

        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        CampoCodigo2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        BotaoSalvar = new javax.swing.JButton();
        CampoSenha = new javax.swing.JPasswordField();
        CampoConfirmar = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Membros = new javax.swing.JCheckBox();
        Entradas = new javax.swing.JCheckBox();
        Caixas = new javax.swing.JCheckBox();
        Relatorios = new javax.swing.JCheckBox();
        Despesas = new javax.swing.JCheckBox();
        Conffiguracoes = new javax.swing.JCheckBox();
        Usuarios = new javax.swing.JCheckBox();

        jLabel15.setText("Incluir:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Usuários");
        setResizable(false);

        jPanel7.setBackground(new java.awt.Color(238, 238, 238));

        CampoCodigo2.setEditable(false);
        CampoCodigo2.setBackground(new java.awt.Color(238, 238, 238));
        CampoCodigo2.setBorder(null);
        CampoCodigo2.setEnabled(false);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Nome do Usuário");

        campoNome.setBackground(new java.awt.Color(255, 255, 255));
        campoNome.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        campoNome.setForeground(new java.awt.Color(0, 0, 0));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Senha:");

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

        CampoSenha.setBackground(new java.awt.Color(255, 255, 255));
        CampoSenha.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoSenha.setForeground(new java.awt.Color(0, 0, 0));

        CampoConfirmar.setBackground(new java.awt.Color(255, 255, 255));
        CampoConfirmar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoConfirmar.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Confirmar Senha:");

        jPanel2.setBackground(new java.awt.Color(238, 238, 238));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true), "Permissões", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        Membros.setBackground(new java.awt.Color(238, 238, 238));
        Membros.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Membros.setForeground(new java.awt.Color(0, 0, 0));
        Membros.setText("Membros");
        Membros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MembrosActionPerformed(evt);
            }
        });

        Entradas.setBackground(new java.awt.Color(238, 238, 238));
        Entradas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Entradas.setForeground(new java.awt.Color(0, 0, 0));
        Entradas.setText("Entradas");
        Entradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EntradasActionPerformed(evt);
            }
        });

        Caixas.setBackground(new java.awt.Color(238, 238, 238));
        Caixas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Caixas.setForeground(new java.awt.Color(0, 0, 0));
        Caixas.setText("Caixas");
        Caixas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaixasActionPerformed(evt);
            }
        });

        Relatorios.setBackground(new java.awt.Color(238, 238, 238));
        Relatorios.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Relatorios.setForeground(new java.awt.Color(0, 0, 0));
        Relatorios.setText("Relatórios");
        Relatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatoriosActionPerformed(evt);
            }
        });

        Despesas.setBackground(new java.awt.Color(238, 238, 238));
        Despesas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Despesas.setForeground(new java.awt.Color(0, 0, 0));
        Despesas.setText("Despesas");
        Despesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DespesasActionPerformed(evt);
            }
        });

        Conffiguracoes.setBackground(new java.awt.Color(238, 238, 238));
        Conffiguracoes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Conffiguracoes.setForeground(new java.awt.Color(0, 0, 0));
        Conffiguracoes.setText("Configurações");
        Conffiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConffiguracoesActionPerformed(evt);
            }
        });

        Usuarios.setBackground(new java.awt.Color(238, 238, 238));
        Usuarios.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Usuarios.setForeground(new java.awt.Color(0, 0, 0));
        Usuarios.setText("Usuários");
        Usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Despesas, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Caixas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Relatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(420, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Membros, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Conffiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 398, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Membros, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Entradas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Despesas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Caixas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Relatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Conffiguracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Usuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(0, 156, Short.MAX_VALUE))
                                    .addComponent(campoNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(8, 8, 8)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoSenha)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatoriosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RelatoriosActionPerformed

    private void UsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuariosActionPerformed

    private void ConffiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConffiguracoesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ConffiguracoesActionPerformed

    private void CaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaixasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CaixasActionPerformed

    private void EntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EntradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EntradasActionPerformed

    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
        ClasseUsuario.NomeUsuario = campoNome.getText();
        ClasseUsuario.Senha = CampoSenha.getText();
        ClasseUsuario.ConfirmarSenha = CampoConfirmar.getText();
        ClasseUsuario.Caixas = Caixas.isSelected();
        ClasseUsuario.Configuracoes = Conffiguracoes.isSelected();
        ClasseUsuario.Despesas = Despesas.isSelected();
        ClasseUsuario.Entradas = Entradas.isSelected();
        ClasseUsuario.Membros = Membros.isSelected();
        ClasseUsuario.Relatorios = Relatorios.isSelected();
        ClasseUsuario.Usuarios = Usuarios.isSelected();

        ClasseUsuario inserir = new ClasseUsuario();

        if(CampoSenha.getText().equals(ClasseUsuario.ConfirmarSenha)){
            if(CampoCodigo2.getText().equals("")){
                inserir.InserirUsuario();
                Limpar();
            }
            else{
                inserir.AlterarUsuario();
                this.dispose();
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Senhas inseridas não combinamm");
        }
    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void BotaoSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseExited
        BotaoSalvar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoSalvarMouseExited

    private void BotaoSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseEntered
        BotaoSalvar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoSalvarMouseEntered

    private void MembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MembrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MembrosActionPerformed

    private void DespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DespesasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DespesasActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroUsuario dialog = new CadastroUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JCheckBox Caixas;
    private javax.swing.JTextField CampoCodigo2;
    private javax.swing.JPasswordField CampoConfirmar;
    private javax.swing.JPasswordField CampoSenha;
    private javax.swing.JCheckBox Conffiguracoes;
    private javax.swing.JCheckBox Despesas;
    private javax.swing.JCheckBox Entradas;
    private javax.swing.JCheckBox Membros;
    private javax.swing.JCheckBox Relatorios;
    private javax.swing.JCheckBox Usuarios;
    private javax.swing.JTextField campoNome;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
