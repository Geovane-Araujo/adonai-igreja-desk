
package Views;

import BancoDados.ConexaoBanco;
import Converter.Data;
import Converter.DataHora;
import Model.ClasseEntradas;
import Model.Var.VarEntradas;
import Model.VariaveisUniversais;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class CadastroEntrada extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();
    VariaveisUniversais e = new VariaveisUniversais();
    DataHora dt = new DataHora();
    String FormatoMoeda = "0.00";
    DecimalFormat df = new DecimalFormat(FormatoMoeda);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    VarEntradas entradas = new VarEntradas();
    ClasseEntradas post = new ClasseEntradas();
    Data form = new Data();
    Date data = new Date();
    public static int tp;
    
    public CadastroEntrada(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    public void Limpar(){
        CampoCaixaEntrada.setText("");
        CampoDescricao.setText("");
        CampoNomeMembro.setText("");
        CampoObs.setText("");
        CampoTipo.setText("");
        CampoValor.setText("");
        CampoData.setDate(form.StringDate(form.FormatarData(data)));
    }
    

    public void Povoar(){
        String sql = "SELECT id, Duplicatas.descricao, datac, valor, duplicatas.observacoes,Tipo.descricao as DescTipo,Caixas.descricaocaixa, membros.NomeCompleto,Duplicatas.IDTipo ,IDMembro,idCaixa \n" +
                    "FROM duplicatas\n" +
                    "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                    "INNER JOIN Membros ON Membros.codigomembro = Duplicatas.IDMembro\n" +
                    "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                    "WHERE ID = "+ entradas.getID();
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();
            
            double valor = Double.parseDouble(rs.getString("Valor"));
            CampoCodigo.setText(rs.getString("ID"));
            CampoDescricao.setText(rs.getString("Descricao"));
            CampoData.setDate(rs.getDate("DataC"));
            CampoTipo.setText(rs.getString("DescTipo"));
            CampoValor.setText(df.format(valor));
            CampoNomeMembro.setText(rs.getString("nomecompleto"));
            CampoCaixaEntrada.setText(rs.getString("descricaocaixa"));
            CampoObs.setText(rs.getString("observacoes"));
            entradas.setIDCaixa(rs.getInt("IDCaixa"));
            entradas.setIDTipo(rs.getInt("IDTipo"));
            entradas.setIDMembro(rs.getInt("IDMembro"));
            
            rs.close();
            stmt.close();
                    
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        BuscarMembros = new javax.swing.JButton();
        CampoCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CampoDescricao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CampoValor = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CampoCaixaEntrada = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CampoNomeMembro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoObs = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        BotaoSalvar = new javax.swing.JButton();
        BuscarCaixas = new javax.swing.JButton();
        CampoData = new com.toedter.calendar.JDateChooser();
        CampoTipo = new javax.swing.JTextField();
        BotaoBuscarCargo = new javax.swing.JButton();
        BotaoAdicionarCargo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Entradas");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        BuscarMembros.setBackground(new java.awt.Color(1, 1, 34));
        BuscarMembros.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BuscarMembros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Search_15px.png"))); // NOI18N
        BuscarMembros.setBorder(null);
        BuscarMembros.setBorderPainted(false);
        BuscarMembros.setFocusPainted(false);
        BuscarMembros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BuscarMembrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BuscarMembrosMouseExited(evt);
            }
        });
        BuscarMembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarMembrosActionPerformed(evt);
            }
        });

        CampoCodigo.setEditable(false);
        CampoCodigo.setBackground(new java.awt.Color(238, 238, 238));
        CampoCodigo.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        CampoCodigo.setForeground(new java.awt.Color(238, 238, 238));
        CampoCodigo.setBorder(null);
        CampoCodigo.setEnabled(false);

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

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Caixa:");

        CampoCaixaEntrada.setBackground(new java.awt.Color(255, 255, 255));
        CampoCaixaEntrada.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoCaixaEntrada.setForeground(new java.awt.Color(0, 0, 0));
        CampoCaixaEntrada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CampoCaixaEntradaKeyPressed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data: ");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nome do Membro:");

        CampoNomeMembro.setBackground(new java.awt.Color(255, 255, 255));
        CampoNomeMembro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoNomeMembro.setForeground(new java.awt.Color(0, 0, 0));
        CampoNomeMembro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CampoNomeMembroKeyPressed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Tipo:");

        CampoObs.setBackground(new java.awt.Color(255, 255, 255));
        CampoObs.setColumns(20);
        CampoObs.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoObs.setForeground(new java.awt.Color(0, 0, 0));
        CampoObs.setRows(3);
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

        BuscarCaixas.setBackground(new java.awt.Color(1, 1, 34));
        BuscarCaixas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        CampoData.setBackground(new java.awt.Color(255, 255, 255));
        CampoData.setForeground(new java.awt.Color(0, 0, 0));
        CampoData.setDateFormatString("dd/MM/yyyy");
        CampoData.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        CampoTipo.setBackground(new java.awt.Color(255, 255, 255));
        CampoTipo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoTipo.setForeground(new java.awt.Color(0, 0, 0));
        CampoTipo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CampoTipoKeyPressed(evt);
            }
        });

        BotaoBuscarCargo.setBackground(new java.awt.Color(1, 1, 34));
        BotaoBuscarCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        BotaoAdicionarCargo.setBackground(new java.awt.Color(1, 1, 34));
        BotaoAdicionarCargo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(CampoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CampoTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoBuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoAdicionarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
                            .addComponent(CampoData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(CampoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CampoNomeMembro, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BuscarMembros, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CampoCaixaEntrada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BuscarCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CampoData, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CampoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscarCargo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoAdicionarCargo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(CampoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BuscarCaixas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CampoCaixaEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BuscarMembros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoNomeMembro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
       
        Salvar();
    }//GEN-LAST:event_BotaoSalvarActionPerformed

    public void Salvar(){

        entradas.setDescricao(CampoDescricao.getText());
        entradas.setDataC((java.sql.Date) dt.DataBd(CampoData.getDate()));
        double valor = Double.parseDouble(CampoValor.getText().replace(",","."));
        entradas.setValor(Double.parseDouble(df.format(valor).replace(",", ".")));
        entradas.setObservacoes(CampoObs.getText());
        
        if(CampoCaixaEntrada.getText().equals("")){
            
            JOptionPane.showMessageDialog(null, "Por Favor Selecione um Caixa");
            CampoCaixaEntrada.setBackground(new Color(242, 199, 209));
        }
        else if(CampoTipo.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Por favor Selecione o Tipo da entrada");
            CampoTipo.setBackground(new Color(242, 199, 209));
        }
        else{
            
            if(CampoCodigo.getText().equals("")){
                post.InserirEntrada();
                Limpar();
            }
            else{

                post.EditarEntrada();
                this.dispose();
            }

        }
    }
    
    private void BuscarMembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarMembrosActionPerformed
        e.setEscolha(0);
        PesquisaMembros chamar = new PesquisaMembros(null, true);
        chamar.setVisible(true);
        
    }//GEN-LAST:event_BuscarMembrosActionPerformed

    private void BuscarCaixasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarCaixasActionPerformed
        VariaveisUniversais.setEntrada(1);
        PesquisaCaixas chamar = new PesquisaCaixas(null, true);
        chamar.setVisible(true);
    }//GEN-LAST:event_BuscarCaixasActionPerformed

    private void BuscarMembrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMembrosMouseEntered
        BuscarMembros.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BuscarMembrosMouseEntered

    private void BuscarMembrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarMembrosMouseExited
        BuscarMembros.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BuscarMembrosMouseExited

    private void BuscarCaixasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarCaixasMouseExited
        BuscarCaixas.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BuscarCaixasMouseExited

    private void BuscarCaixasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarCaixasMouseEntered
        BuscarCaixas.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BuscarCaixasMouseEntered

    private void BotaoSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseEntered
        BotaoSalvar.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoSalvarMouseEntered

    private void BotaoSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseExited
        BotaoSalvar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoSalvarMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        if(TabelaEntradas.da == 0){
           CampoData.setDate(data); 
        }
 
    }//GEN-LAST:event_formWindowOpened

    private void BotaoBuscarCargoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoBuscarCargoMouseEntered
        BotaoBuscarCargo.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoBuscarCargoMouseEntered

    private void BotaoBuscarCargoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoBuscarCargoMouseExited
        BotaoBuscarCargo.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoBuscarCargoMouseExited

    private void BotaoBuscarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscarCargoActionPerformed
        e.setEscolha(0);
        PesquisaTipo cargo = new PesquisaTipo(null, true);
        cargo.setVisible(true);
    }//GEN-LAST:event_BotaoBuscarCargoActionPerformed

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

    private void CampoTipoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoTipoKeyPressed
        tp = 1;
        PesquisaTipo cargo = new PesquisaTipo(null, true);
        cargo.setVisible(true);
    }//GEN-LAST:event_CampoTipoKeyPressed

    private void CampoNomeMembroKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoNomeMembroKeyPressed
        PesquisaMembros chamar = new PesquisaMembros(null, true);
        chamar.setVisible(true);
    }//GEN-LAST:event_CampoNomeMembroKeyPressed

    private void CampoCaixaEntradaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoCaixaEntradaKeyPressed
        VariaveisUniversais.setEntrada(1);
        PesquisaCaixas chamar = new PesquisaCaixas(null, true);
        chamar.setVisible(true);
    }//GEN-LAST:event_CampoCaixaEntradaKeyPressed

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
            java.util.logging.Logger.getLogger(CadastroEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroEntrada dialog = new CadastroEntrada(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BuscarMembros;
    public static javax.swing.JTextField CampoCaixaEntrada;
    private javax.swing.JTextField CampoCodigo;
    public static com.toedter.calendar.JDateChooser CampoData;
    private javax.swing.JTextField CampoDescricao;
    public static javax.swing.JTextField CampoNomeMembro;
    private javax.swing.JTextArea CampoObs;
    public static javax.swing.JTextField CampoTipo;
    private javax.swing.JTextField CampoValor;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
