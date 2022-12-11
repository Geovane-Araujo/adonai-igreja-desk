
package view;

import model.ClasseRotas;
import java.awt.Color;


public class MenuFinanceiro extends javax.swing.JPanel {
    ClasseRotas rota = new ClasseRotas();
            
    public static int l;
    public static int a;
    public MenuFinanceiro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BotaoEntradas = new javax.swing.JButton();
        BotaoCaixas1 = new javax.swing.JButton();
        BotaoCaixas = new javax.swing.JButton();

        setBackground(new java.awt.Color(1, 1, 34));
        setMaximumSize(new java.awt.Dimension(171, 444));
        setPreferredSize(new java.awt.Dimension(171, 444));

        jPanel1.setBackground(new java.awt.Color(1, 1, 34));

        BotaoEntradas.setBackground(new java.awt.Color(1, 1, 34));
        BotaoEntradas.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        BotaoEntradas.setForeground(new java.awt.Color(255, 255, 255));
        BotaoEntradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Request_Money_23px_1.png"))); // NOI18N
        BotaoEntradas.setText("Entradas");
        BotaoEntradas.setBorder(null);
        BotaoEntradas.setFocusPainted(false);
        BotaoEntradas.setFocusable(false);
        BotaoEntradas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotaoEntradas.setMaximumSize(new java.awt.Dimension(86, 26));
        BotaoEntradas.setPreferredSize(new java.awt.Dimension(86, 26));
        BotaoEntradas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoEntradasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoEntradasMouseExited(evt);
            }
        });
        BotaoEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEntradasActionPerformed(evt);
            }
        });

        BotaoCaixas1.setBackground(new java.awt.Color(1, 1, 34));
        BotaoCaixas1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        BotaoCaixas1.setForeground(new java.awt.Color(255, 255, 255));
        BotaoCaixas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Initiate_Money_Transfer_23px_1.png"))); // NOI18N
        BotaoCaixas1.setText("Despesas");
        BotaoCaixas1.setBorder(null);
        BotaoCaixas1.setFocusPainted(false);
        BotaoCaixas1.setFocusable(false);
        BotaoCaixas1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotaoCaixas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoCaixas1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoCaixas1MouseExited(evt);
            }
        });
        BotaoCaixas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCaixas1ActionPerformed(evt);
            }
        });

        BotaoCaixas.setBackground(new java.awt.Color(1, 1, 34));
        BotaoCaixas.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        BotaoCaixas.setForeground(new java.awt.Color(255, 255, 255));
        BotaoCaixas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Cash_Register_20px.png"))); // NOI18N
        BotaoCaixas.setText("Caixas");
        BotaoCaixas.setBorder(null);
        BotaoCaixas.setFocusPainted(false);
        BotaoCaixas.setFocusable(false);
        BotaoCaixas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotaoCaixas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoCaixasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoCaixasMouseExited(evt);
            }
        });
        BotaoCaixas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCaixasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BotaoEntradas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BotaoCaixas1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
            .addComponent(BotaoCaixas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(BotaoEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(BotaoCaixas1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 325, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoEntradasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEntradasMouseEntered
        BotaoEntradas.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoEntradasMouseEntered

    private void BotaoEntradasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEntradasMouseExited
        BotaoEntradas.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoEntradasMouseExited

    private void BotaoCaixasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoCaixasMouseEntered
       BotaoCaixas.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoCaixasMouseEntered

    private void BotaoCaixasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoCaixasMouseExited
        BotaoCaixas.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoCaixasMouseExited

    private void BotaoEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEntradasActionPerformed

       TabelaEntradas chamar = new TabelaEntradas();

        l = Principal.Painel.getWidth();
        a = Principal.Painel.getHeight();
        
        Principal.Painel.removeAll();
        Principal.Painel.add(chamar);
        Principal.Painel.revalidate();
        Principal.Painel.repaint();
        String sql = rota.getRTTabEntradas();
        chamar.Povoar(sql);
        
        chamar.Povoar();// povoa as variaveis minimo e máximo
        chamar.paginacao();
        chamar.setSize(l, a);
    }//GEN-LAST:event_BotaoEntradasActionPerformed

    private void BotaoCaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCaixasActionPerformed
       TabelaCaixas chamar = new TabelaCaixas();
        //chamar.setLocation(5, 5);
        
         l = Principal.Painel.getWidth();
         a = Principal.Painel.getHeight();
        
        Principal.Painel.removeAll();
        Principal.Painel.add(chamar);
        Principal.Painel.revalidate();
        Principal.Painel.repaint();
        String sql = rota.getRTCaixa();
        String sq = rota.getRTCXHistorico();
        chamar.povoarTabela(sql);
        chamar.povoarTabelaHistoarico(sq);
        
       chamar.setSize(l, a);
    }//GEN-LAST:event_BotaoCaixasActionPerformed

    private void BotaoCaixas1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoCaixas1MouseEntered
        BotaoCaixas1.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoCaixas1MouseEntered

    private void BotaoCaixas1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoCaixas1MouseExited
        BotaoCaixas1.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoCaixas1MouseExited

    private void BotaoCaixas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCaixas1ActionPerformed
        TelaDespesas chamar = new TelaDespesas();
        
        
        int l = Principal.Painel.getWidth();
        int a = Principal.Painel.getHeight();
        
        Principal.Painel.removeAll();
        Principal.Painel.add(chamar);
        Principal.Painel.revalidate();
        Principal.Painel.repaint();

        chamar.TabelaTodas(rota.getRTDespesasTodas());
        chamar.TabelaPendentes(rota.getRTDespesasPendentes());
        chamar.TabelaPagas(rota.getRTDespesasPagas());
        
        //Responsável pela Paginação
        chamar.MinimoMaximoTodas();
        chamar.paginacaoTodas();
        chamar.MinimoMaximoPendente();
        chamar.paginacaoPendente();
        chamar.MinimoMaximoPagas();
        chamar.paginacaoPagas();
        
        chamar.setSize(l, a);
    }//GEN-LAST:event_BotaoCaixas1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BotaoCaixas;
    public static javax.swing.JButton BotaoCaixas1;
    public static javax.swing.JButton BotaoEntradas;
    public static javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}