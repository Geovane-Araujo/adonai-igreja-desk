
package Views;

import BancoDados.ConexaoBanco;
import Converter.ImagemBd;
import Model.ClasseGlobais;
import Model.ClasseMembros;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;



public class CadastroGlobais extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();
    // usado para guardar uma imagem no banco
    BufferedImage imagem;
    ImagemBd gravarbd = new ImagemBd();
    String path = "C:\\Program Files\\AdonaiSoft Igreja\\warning\\As.jpg";
    boolean img;
    
    public CadastroGlobais(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CampoCodigo = new javax.swing.JTextField();
        Salvar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoTextoRelatorio = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BuscarCaixas = new javax.swing.JButton();
        LabelImagem = new javax.swing.JLabel();
        Delimagen = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        campoSMTP = new javax.swing.JTextField();
        CampoPorta = new javax.swing.JTextField();
        CampoUsuario = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CampoEmail = new javax.swing.JTextField();
        CampoSenha = new javax.swing.JPasswordField();
        jLabel12 = new javax.swing.JLabel();
        CampoAutenticacao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Globais");
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

        Salvar1.setBackground(new java.awt.Color(1, 1, 34));
        Salvar1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Salvar1.setForeground(new java.awt.Color(255, 255, 255));
        Salvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        Salvar1.setText("Salvar");
        Salvar1.setBorder(null);
        Salvar1.setBorderPainted(false);
        Salvar1.setFocusPainted(false);
        Salvar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Salvar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Salvar1MouseExited(evt);
            }
        });
        Salvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Salvar1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(238, 238, 238));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Relatórios", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        campoTextoRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        campoTextoRelatorio.setColumns(10);
        campoTextoRelatorio.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        campoTextoRelatorio.setForeground(new java.awt.Color(0, 0, 0));
        campoTextoRelatorio.setLineWrap(true);
        campoTextoRelatorio.setRows(4);
        jScrollPane1.setViewportView(campoTextoRelatorio);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Texto do Cabeçalho do Relatório");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Imagem");

        BuscarCaixas.setBackground(new java.awt.Color(1, 1, 34));
        BuscarCaixas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BuscarCaixas.setForeground(new java.awt.Color(255, 255, 255));
        BuscarCaixas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Download_15px.png"))); // NOI18N
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

        LabelImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        LabelImagem.setMaximumSize(new java.awt.Dimension(122, 171));

        Delimagen.setBackground(new java.awt.Color(1, 1, 34));
        Delimagen.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        Delimagen.setForeground(new java.awt.Color(255, 255, 255));
        Delimagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Delete_15px.png"))); // NOI18N
        Delimagen.setBorder(null);
        Delimagen.setBorderPainted(false);
        Delimagen.setFocusPainted(false);
        Delimagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DelimagenMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DelimagenMouseExited(evt);
            }
        });
        Delimagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelimagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabelImagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(Delimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(BuscarCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(LabelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BuscarCaixas, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                            .addComponent(Delimagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(238, 238, 238));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "E-mail", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        campoSMTP.setBackground(new java.awt.Color(255, 255, 255));
        campoSMTP.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        campoSMTP.setForeground(new java.awt.Color(0, 0, 0));

        CampoPorta.setBackground(new java.awt.Color(255, 255, 255));
        CampoPorta.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoPorta.setForeground(new java.awt.Color(0, 0, 0));

        CampoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        CampoUsuario.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoUsuario.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Smtp:");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Porta:");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Usuário:");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("E-Mail:");

        CampoEmail.setBackground(new java.awt.Color(255, 255, 255));
        CampoEmail.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoEmail.setForeground(new java.awt.Color(0, 0, 0));

        CampoSenha.setBackground(new java.awt.Color(255, 255, 255));
        CampoSenha.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoSenha.setForeground(new java.awt.Color(0, 0, 0));
        CampoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoSenhaActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Senha:");

        CampoAutenticacao.setBackground(new java.awt.Color(255, 255, 255));
        CampoAutenticacao.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoAutenticacao.setForeground(new java.awt.Color(0, 0, 0));
        CampoAutenticacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Não usa Autenticação", "TSL", "SSL", "STARTSL" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(campoSMTP, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(CampoPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoAutenticacao, 0, 167, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(CampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(56, 56, 56)))
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(CampoSenha))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoSMTP, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoAutenticacao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Salvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Salvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Povoar();
        
        
        
    }//GEN-LAST:event_formWindowOpened

    private void Salvar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Salvar1MouseEntered
        Salvar1.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_Salvar1MouseEntered

    private void Salvar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Salvar1MouseExited
        Salvar1.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_Salvar1MouseExited

    private void Salvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salvar1ActionPerformed
        if(img == true){
             ClasseGlobais.imagem = gravarbd.getImgBytes(imagem);
        }
        else{
            imagem = img(path);
            ClasseGlobais.imagem = gravarbd.getImgBytes(imagem);
        }
       
        ClasseGlobais.SMPT = campoSMTP.getText();
        ClasseGlobais.Usuario = CampoUsuario.getText();      
        ClasseGlobais.Porta = Integer.parseInt(CampoPorta.getText());
        ClasseGlobais.TestoRelatorio = campoTextoRelatorio.getText();
        ClasseGlobais.Autenticacao = (String) CampoAutenticacao.getSelectedItem();
        ClasseGlobais.Senha = CampoSenha.getText();
        ClasseGlobais.Email = CampoEmail.getText();
        ClasseGlobais.Id_Globais = Integer.parseInt(CampoCodigo.getText());

        
        ClasseGlobais editar = new ClasseGlobais();
        editar.AlterarGlobais();
        this.dispose();
     
    }//GEN-LAST:event_Salvar1ActionPerformed
   
    
   
    
    private void CampoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoSenhaActionPerformed

    private void BuscarCaixasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarCaixasMouseEntered
        BuscarCaixas.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BuscarCaixasMouseEntered

    private void BuscarCaixasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarCaixasMouseExited
        BuscarCaixas.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BuscarCaixasMouseExited

    private void BuscarCaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarCaixasActionPerformed

        JFileChooser file = new JFileChooser();
        file.setDialogTitle("Buscar imagem");
        file.setApproveButtonText("Selecionar");
        file.setApproveButtonToolTipText("Cancelar");
        file.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem","jpg","png");

        
        file.setFileFilter(filter);
        int retorno = file.showOpenDialog(this);
        
        if(retorno == JFileChooser.APPROVE_OPTION){
            File arqu = file.getSelectedFile();  
            
            
            imagem = img(arqu.getPath());
            img = true;

            ImageIcon ico = new ImageIcon(imagem);
            ico.setImage(ico.getImage().getScaledInstance(LabelImagem.getWidth(),LabelImagem.getHeight(),1));
            LabelImagem.setIcon(ico);
        }
               

    }//GEN-LAST:event_BuscarCaixasActionPerformed

    public BufferedImage img(String path){
        
        BufferedImage image = null;
        
        try {
            
                image = ImageIO.read(new File(path));
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        
        return image;
        
    }
    
    private void DelimagenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelimagenMouseEntered
        Delimagen.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_DelimagenMouseEntered

    private void DelimagenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelimagenMouseExited
        Delimagen.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_DelimagenMouseExited

    private void DelimagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelimagenActionPerformed

        ImageIcon ico = new ImageIcon(path);
        ico.setImage(ico.getImage().getScaledInstance(LabelImagem.getWidth(),LabelImagem.getHeight(),1));
        LabelImagem.setIcon(ico);
    }//GEN-LAST:event_DelimagenActionPerformed

    public void Povoar(){
        
        String sql = "SELECT * FROM Globais WHERE Id_Globais = 1";
        Connection con = conectar.Conectar();
        ResultSet rs= null;
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();
            
            CampoCodigo.setText(rs.getString("Id_Globais"));
            ClasseGlobais.imagem = rs.getBytes("imagem");
            gravarbd.exibiImagemLabel(ClasseGlobais.imagem, LabelImagem);
            campoSMTP.setText(rs.getString("SMPT"));
            CampoUsuario.setText(rs.getString("Usuario"));
            CampoPorta.setText(rs.getString("Porta"));
            CampoEmail.setText(rs.getString("Email"));
            CampoSenha.setText(rs.getString("Senha"));
            CampoAutenticacao.setSelectedItem(rs.getString("Autenticacao"));
            campoTextoRelatorio.setText(rs.getString("TestoRelatorio"));  
            
            rs.close();
            stmt.close();

        }
        catch(SQLException e){
            System.out.println(e);
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
            java.util.logging.Logger.getLogger(CadastroGlobais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroGlobais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroGlobais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroGlobais.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroGlobais dialog = new CadastroGlobais(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                        dialog.setBackground(Color.black);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarCaixas;
    private javax.swing.JComboBox<String> CampoAutenticacao;
    private javax.swing.JTextField CampoCodigo;
    private javax.swing.JTextField CampoEmail;
    private javax.swing.JTextField CampoPorta;
    private javax.swing.JPasswordField CampoSenha;
    private javax.swing.JTextField CampoUsuario;
    private javax.swing.JButton Delimagen;
    public static javax.swing.JLabel LabelImagem;
    private javax.swing.JButton Salvar1;
    private javax.swing.JTextField campoSMTP;
    private javax.swing.JTextArea campoTextoRelatorio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
