
package Views;

import Model.ClasseRotas;
import java.awt.Color;


public class MenuEscola extends javax.swing.JPanel {
    ClasseRotas rota = new ClasseRotas();
    public static int l;
    public static int a;
    public MenuEscola() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotaoClasses = new javax.swing.JButton();

        setBackground(new java.awt.Color(1, 1, 34));
        setMaximumSize(new java.awt.Dimension(171, 444));
        setPreferredSize(new java.awt.Dimension(171, 444));

        BotaoClasses.setBackground(new java.awt.Color(1, 1, 34));
        BotaoClasses.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        BotaoClasses.setForeground(new java.awt.Color(255, 255, 255));
        BotaoClasses.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_School_26px.png"))); // NOI18N
        BotaoClasses.setText("Classes");
        BotaoClasses.setBorder(null);
        BotaoClasses.setFocusPainted(false);
        BotaoClasses.setFocusable(false);
        BotaoClasses.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        BotaoClasses.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoClassesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoClassesMouseExited(evt);
            }
        });
        BotaoClasses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoClassesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BotaoClasses, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BotaoClasses, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 408, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoClassesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoClassesMouseEntered
       BotaoClasses.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoClassesMouseEntered

    private void BotaoClassesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoClassesMouseExited
        BotaoClasses.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoClassesMouseExited

    private void BotaoClassesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoClassesActionPerformed
      TabelaClasse chamar = new TabelaClasse();

        l = Principal.Painel.getWidth();
        a = Principal.Painel.getHeight();
        
        Principal.Painel.removeAll();
        Principal.Painel.add(chamar);
        Principal.Painel.revalidate();
        Principal.Painel.repaint();
        String sql = rota.getTabelaClasses();
        
        chamar.PovoarHistorico();
        chamar.Povoar(sql);
        chamar.setSize(l, a);
    }//GEN-LAST:event_BotaoClassesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton BotaoClasses;
    // End of variables declaration//GEN-END:variables
}
