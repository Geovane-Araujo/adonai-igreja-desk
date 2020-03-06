
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseCaixas;
import Model.ClasseDespesas;
import Model.ClasseEntradas;
import Model.Var.VarDespesas;
import Model.Var.VarEntradas;
import Model.VariaveisUniversais;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;


public class PesquisaCaixas extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();
    VariaveisUniversais validar = new VariaveisUniversais();
    VarDespesas despesas = new VarDespesas();

    
    public PesquisaCaixas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    

    
    public void povoar(String sql){
        
        //String sql = "SELECT CodigoMembro, NomeCompleto FROM Membros";
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaCaixas.getModel();
            Model.setNumRows(0);
            
            while(rs.next()){
                Model.addRow(new Object[]{
                    rs.getString("CodigoCaixa"),
                    rs.getString("DescricaoCaixa"),
                });
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        finally{
            try{
                rs.close();
                stmt.close();;
            }
            catch(SQLException e){
                System.out.println(e);
            }
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        CampoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaCaixas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Caixas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        CampoNome.setBackground(new java.awt.Color(255, 255, 255));
        CampoNome.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoNome.setForeground(new java.awt.Color(0, 0, 0));
        CampoNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoNomeActionPerformed(evt);
            }
        });
        CampoNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CampoNomeKeyTyped(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Descrição do Caixa:");

        TabelaCaixas.setBackground(new java.awt.Color(255, 255, 255));
        TabelaCaixas.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaCaixas.setForeground(new java.awt.Color(0, 0, 0));
        TabelaCaixas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaCaixas.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaCaixas.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaCaixas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TabelaCaixas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaCaixasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaCaixas);
        if (TabelaCaixas.getColumnModel().getColumnCount() > 0) {
            TabelaCaixas.getColumnModel().getColumn(0).setPreferredWidth(5);
            TabelaCaixas.getColumnModel().getColumn(1).setPreferredWidth(250);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoNome))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
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

    private void CampoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoNomeActionPerformed

    private void CampoNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoNomeKeyTyped
        String sql = "SELECT CodigoCaixa,DescricaoCaixa FROM Caixas "
        + "WHERE DescricaoCaixa LIKE'%"+ CampoNome.getText()+"%'";
        povoar(sql);

    }//GEN-LAST:event_CampoNomeKeyTyped

    private void TabelaCaixasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaCaixasMouseClicked
        ClasseDespesas idDespesa = new ClasseDespesas();
        int linha = TabelaCaixas.getSelectedRow();
        int linha2 = TabelaCaixas.getSelectedRow();
        
        //Tela Cadastro de Entradas
        if(VariaveisUniversais.Entrada == 1){
            VarEntradas entradas = new VarEntradas();
            entradas.setIDCaixa(Integer.parseInt(TabelaCaixas.getValueAt(linha,0).toString()));
            CadastroEntrada.CampoCaixaEntrada.setText(TabelaCaixas.getValueAt(linha,1).toString());
            VariaveisUniversais.setEntrada(0);
            this.dispose();
            
        }
        
        // Relatório de Entradas
        else if(VariaveisUniversais.Entrada == 2){
            RelatorioCaixas.CampoCodigoCaixa.setText(TabelaCaixas.getValueAt(linha,0).toString());
            RelatorioCaixas.CampoCaixa.setText(TabelaCaixas.getValueAt(linha,1).toString());
            VariaveisUniversais.setEntrada(0);
            this.dispose();
            
        }
        else if(VariaveisUniversais.getEntrada() == 3){
            ClasseCaixas saldo = new ClasseCaixas();
            saldo.setCodigoCaixa(Integer.parseInt(TabelaCaixas.getValueAt(linha,0).toString()));
            VariaveisUniversais.setEntrada(0);
            this.dispose();
        }
        
        else if (VariaveisUniversais.Entrada == 7){
            despesas.setIDCaixa(Integer.parseInt(TabelaCaixas.getValueAt(linha2,0).toString()));
            CadastroDespesa.CampoCaixaDespesa.setText(TabelaCaixas.getValueAt(linha2,1).toString());
            VariaveisUniversais.setEntrada(0);
            this.dispose();
        }
        
        
        
    }//GEN-LAST:event_TabelaCaixasMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        if(validar.getRelatorios()==1){
            String sql = "SELECT CodigoCaixa,DescricaoCaixa FROM Caixas";
            povoar(sql); 
        }
        
        else if(validar.getRelatorios()==5){
            String sql = "SELECT CodigoCaixa,DescricaoCaixa FROM Caixas";
            povoar(sql); 
        }
        
        else if(validar.getRelatorios()==6){
            String sql = "SELECT CodigoCaixa,DescricaoCaixa FROM Caixas";
            povoar(sql); 
        }
        
        else if(validar.getRelatorios()==4){
            String sql = "SELECT CodigoCaixa,DescricaoCaixa FROM Caixas "
            + "WHERE Status = 'Caixa Fechado'";
            povoar(sql);
        }
        else if(validar.getEntrada()==1 ||validar.getEntrada()==3 || validar.getEntrada()==7){
            String sql = "SELECT CodigoCaixa,DescricaoCaixa FROM Caixas "
            + "WHERE Status = 'Caixa Aberto'";
            povoar(sql);
        }
        
        
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(PesquisaCaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PesquisaCaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PesquisaCaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PesquisaCaixas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PesquisaCaixas dialog = new PesquisaCaixas(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField CampoNome;
    private javax.swing.JTable TabelaCaixas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
