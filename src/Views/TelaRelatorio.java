
package Views;

import Model.VariaveisUniversais;
import java.awt.Color;


public class TelaRelatorio extends javax.swing.JDialog {
    
    VariaveisUniversais relatorio = new VariaveisUniversais();

   
    public TelaRelatorio(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        PainelAbas.setFocusable(false);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PainelAbas = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        CarteirinhaMembros = new javax.swing.JButton();
        Certificado = new javax.swing.JButton();
        CartaMudanca = new javax.swing.JButton();
        CartaConvite = new javax.swing.JButton();
        CartaRecomendacao = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        RelatorioDizimista = new javax.swing.JButton();
        RelatorioEntradas = new javax.swing.JButton();
        RelatorioDespesa = new javax.swing.JButton();
        RelatorioCaixa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatórios");
        setAutoRequestFocus(false);
        setResizable(false);

        PainelAbas.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        PainelAbas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(219, 230, 244));

        CarteirinhaMembros.setBackground(new java.awt.Color(1, 1, 34));
        CarteirinhaMembros.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CarteirinhaMembros.setForeground(new java.awt.Color(255, 255, 255));
        CarteirinhaMembros.setText("Carteirinha");
        CarteirinhaMembros.setToolTipText("Carteirinha de Membros");
        CarteirinhaMembros.setBorder(null);
        CarteirinhaMembros.setFocusPainted(false);
        CarteirinhaMembros.setFocusable(false);
        CarteirinhaMembros.setMaximumSize(new java.awt.Dimension(86, 26));
        CarteirinhaMembros.setPreferredSize(new java.awt.Dimension(86, 26));
        CarteirinhaMembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CarteirinhaMembrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CarteirinhaMembrosMouseExited(evt);
            }
        });
        CarteirinhaMembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarteirinhaMembrosActionPerformed(evt);
            }
        });

        Certificado.setBackground(new java.awt.Color(1, 1, 34));
        Certificado.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Certificado.setForeground(new java.awt.Color(255, 255, 255));
        Certificado.setText("Certificado");
        Certificado.setToolTipText("Carteirinha de Membros");
        Certificado.setBorder(null);
        Certificado.setFocusPainted(false);
        Certificado.setFocusable(false);
        Certificado.setMaximumSize(new java.awt.Dimension(86, 26));
        Certificado.setPreferredSize(new java.awt.Dimension(86, 26));
        Certificado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CertificadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CertificadoMouseExited(evt);
            }
        });
        Certificado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CertificadoActionPerformed(evt);
            }
        });

        CartaMudanca.setBackground(new java.awt.Color(1, 1, 34));
        CartaMudanca.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CartaMudanca.setForeground(new java.awt.Color(255, 255, 255));
        CartaMudanca.setText("Mudança");
        CartaMudanca.setToolTipText("Carteirinha de Membros");
        CartaMudanca.setBorder(null);
        CartaMudanca.setFocusPainted(false);
        CartaMudanca.setFocusable(false);
        CartaMudanca.setMaximumSize(new java.awt.Dimension(86, 26));
        CartaMudanca.setPreferredSize(new java.awt.Dimension(86, 26));
        CartaMudanca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CartaMudancaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CartaMudancaMouseExited(evt);
            }
        });
        CartaMudanca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartaMudancaActionPerformed(evt);
            }
        });

        CartaConvite.setBackground(new java.awt.Color(1, 1, 34));
        CartaConvite.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CartaConvite.setForeground(new java.awt.Color(255, 255, 255));
        CartaConvite.setText("Convite");
        CartaConvite.setToolTipText("Carteirinha de Membros");
        CartaConvite.setBorder(null);
        CartaConvite.setFocusPainted(false);
        CartaConvite.setFocusable(false);
        CartaConvite.setMaximumSize(new java.awt.Dimension(86, 26));
        CartaConvite.setPreferredSize(new java.awt.Dimension(86, 26));
        CartaConvite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CartaConviteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CartaConviteMouseExited(evt);
            }
        });
        CartaConvite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartaConviteActionPerformed(evt);
            }
        });

        CartaRecomendacao.setBackground(new java.awt.Color(1, 1, 34));
        CartaRecomendacao.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CartaRecomendacao.setForeground(new java.awt.Color(255, 255, 255));
        CartaRecomendacao.setText("Recomendação");
        CartaRecomendacao.setToolTipText("Carteirinha de Membros");
        CartaRecomendacao.setBorder(null);
        CartaRecomendacao.setFocusPainted(false);
        CartaRecomendacao.setFocusable(false);
        CartaRecomendacao.setMaximumSize(new java.awt.Dimension(86, 26));
        CartaRecomendacao.setPreferredSize(new java.awt.Dimension(86, 26));
        CartaRecomendacao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CartaRecomendacaoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CartaRecomendacaoMouseExited(evt);
            }
        });
        CartaRecomendacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartaRecomendacaoActionPerformed(evt);
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
                        .addComponent(CarteirinhaMembros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Certificado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CartaMudanca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(CartaConvite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CartaRecomendacao, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CarteirinhaMembros, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Certificado, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CartaMudanca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CartaConvite, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CartaRecomendacao, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(273, Short.MAX_VALUE))
        );

        PainelAbas.addTab("Membros", jPanel2);

        jPanel3.setBackground(new java.awt.Color(219, 230, 244));

        RelatorioDizimista.setBackground(new java.awt.Color(1, 1, 34));
        RelatorioDizimista.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        RelatorioDizimista.setForeground(new java.awt.Color(255, 255, 255));
        RelatorioDizimista.setText("Dizimistas");
        RelatorioDizimista.setToolTipText("Relatório de Dizimistas");
        RelatorioDizimista.setBorder(null);
        RelatorioDizimista.setFocusPainted(false);
        RelatorioDizimista.setFocusable(false);
        RelatorioDizimista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RelatorioDizimistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RelatorioDizimistaMouseExited(evt);
            }
        });
        RelatorioDizimista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioDizimistaActionPerformed(evt);
            }
        });

        RelatorioEntradas.setBackground(new java.awt.Color(1, 1, 34));
        RelatorioEntradas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        RelatorioEntradas.setForeground(new java.awt.Color(255, 255, 255));
        RelatorioEntradas.setText("Entradas");
        RelatorioEntradas.setToolTipText("Relatório de Dizimistas");
        RelatorioEntradas.setBorder(null);
        RelatorioEntradas.setFocusPainted(false);
        RelatorioEntradas.setFocusable(false);
        RelatorioEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RelatorioEntradasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RelatorioEntradasMouseExited(evt);
            }
        });
        RelatorioEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioEntradasActionPerformed(evt);
            }
        });

        RelatorioDespesa.setBackground(new java.awt.Color(1, 1, 34));
        RelatorioDespesa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        RelatorioDespesa.setForeground(new java.awt.Color(255, 255, 255));
        RelatorioDespesa.setText("Despesas");
        RelatorioDespesa.setToolTipText("Relatório de Dizimistas");
        RelatorioDespesa.setBorder(null);
        RelatorioDespesa.setFocusPainted(false);
        RelatorioDespesa.setFocusable(false);
        RelatorioDespesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RelatorioDespesaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RelatorioDespesaMouseExited(evt);
            }
        });
        RelatorioDespesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioDespesaActionPerformed(evt);
            }
        });

        RelatorioCaixa.setBackground(new java.awt.Color(1, 1, 34));
        RelatorioCaixa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        RelatorioCaixa.setForeground(new java.awt.Color(255, 255, 255));
        RelatorioCaixa.setText("Caixa");
        RelatorioCaixa.setToolTipText("Relatório de Dizimistas");
        RelatorioCaixa.setBorder(null);
        RelatorioCaixa.setFocusPainted(false);
        RelatorioCaixa.setFocusable(false);
        RelatorioCaixa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RelatorioCaixaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RelatorioCaixaMouseExited(evt);
            }
        });
        RelatorioCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioCaixaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RelatorioDizimista, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(RelatorioCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RelatorioEntradas, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RelatorioDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RelatorioDizimista, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RelatorioEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RelatorioDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RelatorioCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        PainelAbas.addTab("Financeiro", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelAbas)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelAbas)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CarteirinhaMembrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarteirinhaMembrosMouseEntered
        CarteirinhaMembros.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_CarteirinhaMembrosMouseEntered

    private void CarteirinhaMembrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarteirinhaMembrosMouseExited
        CarteirinhaMembros.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_CarteirinhaMembrosMouseExited

    private void CarteirinhaMembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarteirinhaMembrosActionPerformed
        RelatorioMembro cha = new RelatorioMembro(null, true);
        relatorio.setRelatorios(1);
        cha.setVisible(true);
    }//GEN-LAST:event_CarteirinhaMembrosActionPerformed

    private void CertificadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CertificadoMouseEntered
        Certificado.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_CertificadoMouseEntered

    private void CertificadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CertificadoMouseExited
        Certificado.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_CertificadoMouseExited

    private void CertificadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CertificadoActionPerformed

        RelatorioMembro cha = new RelatorioMembro(null, true);
        relatorio.setRelatorios(3);
        cha.setVisible(true);
    }//GEN-LAST:event_CertificadoActionPerformed

    private void CartaMudancaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartaMudancaMouseEntered
        
    }//GEN-LAST:event_CartaMudancaMouseEntered

    private void CartaMudancaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartaMudancaMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_CartaMudancaMouseExited

    private void CartaMudancaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartaMudancaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CartaMudancaActionPerformed

    private void CartaConviteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartaConviteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CartaConviteMouseEntered

    private void CartaConviteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartaConviteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_CartaConviteMouseExited

    private void CartaConviteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartaConviteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CartaConviteActionPerformed

    private void CartaRecomendacaoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartaRecomendacaoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CartaRecomendacaoMouseEntered

    private void CartaRecomendacaoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CartaRecomendacaoMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_CartaRecomendacaoMouseExited

    private void CartaRecomendacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartaRecomendacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CartaRecomendacaoActionPerformed

    private void RelatorioDizimistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelatorioDizimistaMouseEntered
        RelatorioDizimista.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_RelatorioDizimistaMouseEntered

    private void RelatorioDizimistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelatorioDizimistaMouseExited
        RelatorioDizimista.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_RelatorioDizimistaMouseExited

    private void RelatorioDizimistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioDizimistaActionPerformed

        RelatorioCaixas cha = new RelatorioCaixas(null, true);
        relatorio.setRelatorios(1);
        cha.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RelatorioDizimistaActionPerformed

    private void RelatorioEntradasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelatorioEntradasMouseEntered
        RelatorioEntradas.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_RelatorioEntradasMouseEntered

    private void RelatorioEntradasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelatorioEntradasMouseExited
        RelatorioEntradas.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_RelatorioEntradasMouseExited

    private void RelatorioEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioEntradasActionPerformed
        RelatorioCaixas cha = new RelatorioCaixas(null, true);
        relatorio.setRelatorios(5);

        cha.setVisible(true);
    }//GEN-LAST:event_RelatorioEntradasActionPerformed

    private void RelatorioDespesaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelatorioDespesaMouseEntered
        RelatorioDespesa.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_RelatorioDespesaMouseEntered

    private void RelatorioDespesaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelatorioDespesaMouseExited
        RelatorioDespesa.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_RelatorioDespesaMouseExited

    private void RelatorioDespesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioDespesaActionPerformed
        RelatorioCaixas cha = new RelatorioCaixas(null, true);
        relatorio.setRelatorios(6);

        cha.setVisible(true);
    }//GEN-LAST:event_RelatorioDespesaActionPerformed

    private void RelatorioCaixaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelatorioCaixaMouseEntered
        RelatorioCaixa.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_RelatorioCaixaMouseEntered

    private void RelatorioCaixaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RelatorioCaixaMouseExited
        RelatorioCaixa.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_RelatorioCaixaMouseExited

    private void RelatorioCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioCaixaActionPerformed
        RelatorioCaixas cha = new RelatorioCaixas(null, true);
        relatorio.setRelatorios(4);

        cha.setVisible(true);
    }//GEN-LAST:event_RelatorioCaixaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaRelatorio dialog = new TelaRelatorio(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton CartaConvite;
    private javax.swing.JButton CartaMudanca;
    private javax.swing.JButton CartaRecomendacao;
    private javax.swing.JButton CarteirinhaMembros;
    private javax.swing.JButton Certificado;
    private javax.swing.JTabbedPane PainelAbas;
    private javax.swing.JButton RelatorioCaixa;
    private javax.swing.JButton RelatorioDespesa;
    private javax.swing.JButton RelatorioDizimista;
    private javax.swing.JButton RelatorioEntradas;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
