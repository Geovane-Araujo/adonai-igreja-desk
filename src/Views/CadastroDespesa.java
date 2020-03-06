

package Views;

import BancoDados.ConexaoBanco;
import Converter.DataHora;
import Converter.Virgula;

import Model.ClasseDespesas;
import Model.Var.VarDespesas;
import Model.VariaveisUniversais;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class CadastroDespesa extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();
    VarDespesas despesas = new VarDespesas();
    ClasseDespesas post = new ClasseDespesas();
    VariaveisUniversais e = new VariaveisUniversais();
    Virgula vir = new Virgula();
    ClasseDespesas cadastro = new ClasseDespesas();
    DataHora dt = new DataHora();
    Date data = new Date();
    String formato = "0.00";
    DecimalFormat df = new DecimalFormat(formato);
    
    

    /** Creates new form TelaCadastroDespesa */
    public CadastroDespesa(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents(); 
    }
    

    private void limpar(){
        
            campoCodigo.setText("");
            CampoDescricao.setText("");
            CampoStatus.setText("Pendente");
            CampoDataVencimento1.setDate(data);
            CampoValor.setText("");
            CampoCaixaDespesa.setText("");
            CampoDataVencimento.setDate(data);
            CampoObs.setText("");
            CampoTipo.setText("");
    }
    
    public void Povoar(){
        
        String sql = "SELECT id, Duplicatas.descricao, datac, datav, Duplicatas.status, valor, Duplicatas.observacoes, tipo, Duplicatas.idtipo, idcaixa,Tipo.descricao as dtipo,Caixas.descricaocaixa\n" +
                        "FROM duplicatas\n" +
                        "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                        "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                        "WHERE ID ="+ despesas.getID();
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();
            
            campoCodigo.setText(rs.getString("ID"));
            CampoDescricao.setText(rs.getString("Descricao"));
            CampoStatus.setText(rs.getString("status"));
            CampoDataVencimento1.setDate(rs.getDate("DataC"));
            double teste = Double.parseDouble(rs.getString("Valor"));
            CampoValor.setText(df.format(teste));
            CampoCaixaDespesa.setText(rs.getString("DescricaoCaixa"));
            CampoDataVencimento.setDate(rs.getDate("DataV"));
            CampoObs.setText(rs.getString("Observacoes"));
            CampoTipo.setText(rs.getString("dtipo"));
            despesas.setIDCaixa(rs.getInt("IDCaixa"));
            despesas.setIDTipo(rs.getInt("IDTipo"));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Problemas Aqui ->" +e );
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        campoCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CampoDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CampoValor = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoObs = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        BotaoSalvar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        CampoStatus = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        BuscarCaixas = new javax.swing.JButton();
        CampoCaixaDespesa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        CampoDataVencimento = new com.toedter.calendar.JDateChooser();
        BotaoAdicionarCargo = new javax.swing.JButton();
        BotaoBuscarCargo = new javax.swing.JButton();
        CampoTipo = new javax.swing.JTextField();
        CampoDataVencimento1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Despesas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        campoCodigo.setEditable(false);
        campoCodigo.setBackground(new java.awt.Color(238, 238, 238));
        campoCodigo.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        campoCodigo.setForeground(new java.awt.Color(238, 238, 238));
        campoCodigo.setBorder(null);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Descrição:");

        CampoDescricao.setBackground(new java.awt.Color(255, 255, 255));
        CampoDescricao.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoDescricao.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Valor:");

        CampoValor.setBackground(new java.awt.Color(255, 255, 255));
        CampoValor.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoValor.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data: ");

        CampoObs.setBackground(new java.awt.Color(255, 255, 255));
        CampoObs.setColumns(20);
        CampoObs.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoObs.setForeground(new java.awt.Color(0, 0, 0));
        CampoObs.setRows(2);
        CampoObs.setWrapStyleWord(true);
        CampoObs.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 0, true));
        jScrollPane1.setViewportView(CampoObs);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Observações:");

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

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Data Vencimento:");

        CampoStatus.setEditable(false);
        CampoStatus.setBackground(new java.awt.Color(238, 238, 238));
        CampoStatus.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        CampoStatus.setForeground(new java.awt.Color(204, 0, 0));
        CampoStatus.setText("Pendente");
        CampoStatus.setBorder(null);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Caixa:");

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

        CampoCaixaDespesa.setBackground(new java.awt.Color(255, 255, 255));
        CampoCaixaDespesa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoCaixaDespesa.setForeground(new java.awt.Color(0, 0, 0));
        CampoCaixaDespesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CampoCaixaDespesaKeyPressed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Tipo:");

        CampoDataVencimento.setBackground(new java.awt.Color(255, 255, 255));
        CampoDataVencimento.setForeground(new java.awt.Color(0, 0, 0));
        CampoDataVencimento.setDateFormatString("dd/MM/yyyy");
        CampoDataVencimento.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        BotaoAdicionarCargo.setBackground(new java.awt.Color(1, 1, 34));
        BotaoAdicionarCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotaoAdicionarCargo.setForeground(new java.awt.Color(255, 255, 255));
        BotaoAdicionarCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Plus_Math_15px.png"))); // NOI18N
        BotaoAdicionarCargo.setBorder(null);
        BotaoAdicionarCargo.setBorderPainted(false);
        BotaoAdicionarCargo.setFocusPainted(false);
        BotaoAdicionarCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoAdicionarCargoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoAdicionarCargoMouseExited(evt);
            }
        });
        BotaoAdicionarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAdicionarCargoActionPerformed(evt);
            }
        });

        BotaoBuscarCargo.setBackground(new java.awt.Color(1, 1, 34));
        BotaoBuscarCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BotaoBuscarCargo.setForeground(new java.awt.Color(255, 255, 255));
        BotaoBuscarCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Search_15px.png"))); // NOI18N
        BotaoBuscarCargo.setBorder(null);
        BotaoBuscarCargo.setBorderPainted(false);
        BotaoBuscarCargo.setFocusPainted(false);
        BotaoBuscarCargo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoBuscarCargoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoBuscarCargoMouseExited(evt);
            }
        });
        BotaoBuscarCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscarCargoActionPerformed(evt);
            }
        });

        CampoTipo.setBackground(new java.awt.Color(255, 255, 255));
        CampoTipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoTipo.setForeground(new java.awt.Color(0, 0, 0));
        CampoTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CampoTipoKeyPressed(evt);
            }
        });

        CampoDataVencimento1.setBackground(new java.awt.Color(255, 255, 255));
        CampoDataVencimento1.setForeground(new java.awt.Color(0, 0, 0));
        CampoDataVencimento1.setDateFormatString("dd/MM/yyyy");
        CampoDataVencimento1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel11)
                                    .addComponent(CampoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(CampoCaixaDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BuscarCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(CampoDataVencimento1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CampoDataVencimento, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CampoTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BotaoBuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BotaoAdicionarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)
                                        .addComponent(CampoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoStatus)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoBuscarCargo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoAdicionarCargo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BuscarCaixas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoCaixaDespesa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(CampoDataVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoDataVencimento1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

    private void BuscarCaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarCaixasActionPerformed
        e.setEntrada(7);
        PesquisaCaixas chamar = new PesquisaCaixas(null, true);
        chamar.setVisible(true);
        
    }//GEN-LAST:event_BuscarCaixasActionPerformed

    private void BuscarCaixasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarCaixasMouseExited
        BuscarCaixas.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BuscarCaixasMouseExited

    private void BuscarCaixasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarCaixasMouseEntered
        BuscarCaixas.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BuscarCaixasMouseEntered

    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
        Salvar();

    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
  
        if(TelaDespesas.da == 0){
            CampoDataVencimento1.setDate(data);
            CampoDataVencimento.setDate(data);
        }
        
        else if(TelaDespesas.da == 2){
            Povoar();
            BotaoSalvar.setEnabled(false);
        }
        else{
            Povoar();
        }
    }//GEN-LAST:event_formWindowOpened

    private void BotaoSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseEntered
       BotaoSalvar.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoSalvarMouseEntered

    private void BotaoSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseExited
        BotaoSalvar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoSalvarMouseExited

    private void BotaoAdicionarCargoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAdicionarCargoMouseEntered
        BotaoAdicionarCargo.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoAdicionarCargoMouseEntered

    private void BotaoAdicionarCargoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAdicionarCargoMouseExited
        BotaoAdicionarCargo.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoAdicionarCargoMouseExited

    private void BotaoAdicionarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAdicionarCargoActionPerformed
        Cadastrotipo tipo = new Cadastrotipo(null, true);
        tipo.setVisible(true);
    }//GEN-LAST:event_BotaoAdicionarCargoActionPerformed

    private void BotaoBuscarCargoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoBuscarCargoMouseEntered
        BotaoBuscarCargo.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoBuscarCargoMouseEntered

    private void BotaoBuscarCargoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoBuscarCargoMouseExited
        BotaoBuscarCargo.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoBuscarCargoMouseExited

    private void BotaoBuscarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscarCargoActionPerformed
        e.setEscolha(1);
        PesquisaTipo cargo = new PesquisaTipo(null, true);
        cargo.setVisible(true);
    }//GEN-LAST:event_BotaoBuscarCargoActionPerformed

    private void CampoTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoTipoKeyPressed
        PesquisaTipo cargo = new PesquisaTipo(null, true);
        cargo.setVisible(true);
    }//GEN-LAST:event_CampoTipoKeyPressed

    private void CampoCaixaDespesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoCaixaDespesaKeyPressed
        VariaveisUniversais.setEntrada(7);
        PesquisaCaixas chamar = new PesquisaCaixas(null, true);
        chamar.setVisible(true);
    }//GEN-LAST:event_CampoCaixaDespesaKeyPressed

    public void Salvar(){
        
        if(CampoTipo.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Por Favor Selecione o tipo da Despesa");
            CampoTipo.setBackground(new Color(242, 199, 209));
        }
        else if(CampoCaixaDespesa.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor selecione oo caixa para a Despesa");
            CampoCaixaDespesa.setBackground(new Color(242, 199, 209));
        }
        else{
            
            despesas.setDescricao(CampoDescricao.getText());
            despesas.setStatus(CampoStatus.getText());
            despesas.setDataC((java.sql.Date) dt.DataBd(CampoDataVencimento1.getDate()));
            double valor = Double.parseDouble(CampoValor.getText().replace(",","."));
            despesas.setValor(Double.parseDouble(df.format(valor).replace(",",".")));
            despesas.setDataV((java.sql.Date) dt.DataBd(CampoDataVencimento.getDate()));
            despesas.setObservacoes(CampoObs.getText());
        
            if(campoCodigo.getText().equals("")){
                    
                post.InserirDespesa();
                this.limpar();
                CampoTipo.setBackground(new Color(255,255,255));
                CampoCaixaDespesa.setBackground(new Color(255,255,255));
            }
            else{
                    
                post.EditarDespesa();
                this.dispose();

            }   
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
            java.util.logging.Logger.getLogger(CadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroDespesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroDespesa dialog = new CadastroDespesa(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BotaoAdicionarCargo;
    private javax.swing.JButton BotaoBuscarCargo;
    private javax.swing.JButton BotaoSalvar;
    private javax.swing.JButton BuscarCaixas;
    public static javax.swing.JTextField CampoCaixaDespesa;
    private com.toedter.calendar.JDateChooser CampoDataVencimento;
    private com.toedter.calendar.JDateChooser CampoDataVencimento1;
    private javax.swing.JTextField CampoDescricao;
    private javax.swing.JTextArea CampoObs;
    private javax.swing.JTextField CampoStatus;
    public static javax.swing.JTextField CampoTipo;
    private javax.swing.JTextField CampoValor;
    private javax.swing.JTextField campoCodigo;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
