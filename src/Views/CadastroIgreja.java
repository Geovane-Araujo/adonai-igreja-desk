
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseConfiguracoes;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CadastroIgreja extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();

    
    public CadastroIgreja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public void povoar(){
        String sql = "SELECT * FROM Configuracoes WHERE CodiIgreja = 1";
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            while(rs.next()){
                CampoBairro.setText(rs.getString("BairroIgreja"));
                CampoCNPJ.setText(rs.getString("CNPJIgreja"));
                CampoCidade.setText(rs.getString("CidadeIgreja"));
                CampoCidadeCampo.setText(rs.getString("IgrejaSede"));
                CampoCodigo.setText(rs.getString("CodiIgreja"));
                CampoEndereco.setText(rs.getString("EnderecoIgreja"));
                CampoEstado.setSelectedItem(rs.getString("EstadoIgreja"));
                CampoNome.setText(rs.getString("NomeIgreja"));
                CampoNumero.setText(rs.getString("Numero"));
                CampoPastorLocal.setText(rs.getString("PastorIgreja"));
                CampoPedirSenha.setSelected(rs.getBoolean("PedirSenha"));
                CampoSecretario.setText(rs.getString("SecretarioIgreja"));
                CampoTelefone.setText(rs.getString("TelefoneIgreja"));
                CampoTesoureiro.setText(rs.getString("TesoureiroIgreja"));
                campoPastorPresidente.setText(rs.getString("PastorPresidente"));
                        
            }
            stmt.close();
            rs.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BotaoSalvar = new javax.swing.JButton();
        CampoCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CampoNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CampoEndereco = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CampoCidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CampoCNPJ = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        CampoBairro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        CampoEstado = new javax.swing.JComboBox<>();
        CampoTelefone = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        CampoPedirSenha = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        CampoNumero = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        campoPastorPresidente = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        CampoCidadeCampo = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CampoPastorLocal = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        CampoSecretario = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        CampoTesoureiro = new javax.swing.JTextField();

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Pastor Responsável Local");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro da Igreja");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        BotaoSalvar.setBackground(new java.awt.Color(1, 1, 34));
        BotaoSalvar.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
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

        CampoCodigo.setEditable(false);
        CampoCodigo.setBackground(new java.awt.Color(238, 238, 238));
        CampoCodigo.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        CampoCodigo.setForeground(new java.awt.Color(238, 238, 238));
        CampoCodigo.setBorder(null);
        CampoCodigo.setEnabled(false);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome da Igreja:");

        CampoNome.setBackground(new java.awt.Color(255, 255, 255));
        CampoNome.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoNome.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Endereço:");

        CampoEndereco.setBackground(new java.awt.Color(255, 255, 255));
        CampoEndereco.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoEndereco.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Cidade:");

        CampoCidade.setBackground(new java.awt.Color(255, 255, 255));
        CampoCidade.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoCidade.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CNPJ:");

        CampoCNPJ.setBackground(new java.awt.Color(255, 255, 255));
        CampoCNPJ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        CampoCNPJ.setForeground(new java.awt.Color(0, 0, 0));
        try {
            CampoCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CampoCNPJ.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Bairro:");

        CampoBairro.setBackground(new java.awt.Color(255, 255, 255));
        CampoBairro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoBairro.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Estado:");

        CampoEstado.setBackground(new java.awt.Color(255, 255, 255));
        CampoEstado.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoEstado.setForeground(new java.awt.Color(0, 0, 0));
        CampoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE" }));
        CampoEstado.setBorder(null);

        CampoTelefone.setBackground(new java.awt.Color(255, 255, 255));
        CampoTelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        CampoTelefone.setForeground(new java.awt.Color(0, 0, 0));
        try {
            CampoTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CampoTelefone.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Telefone:");

        CampoPedirSenha.setBackground(new java.awt.Color(238, 238, 238));
        CampoPedirSenha.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoPedirSenha.setForeground(new java.awt.Color(0, 0, 0));
        CampoPedirSenha.setText("Pedir Senha");
        CampoPedirSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoPedirSenhaActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Numero:");

        CampoNumero.setBackground(new java.awt.Color(255, 255, 255));
        CampoNumero.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoNumero.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Pastor Presidente do campo:");

        campoPastorPresidente.setBackground(new java.awt.Color(255, 255, 255));
        campoPastorPresidente.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        campoPastorPresidente.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Cidade Igreja Sede:");

        CampoCidadeCampo.setBackground(new java.awt.Color(255, 255, 255));
        CampoCidadeCampo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoCidadeCampo.setForeground(new java.awt.Color(0, 0, 0));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Pastor Responsável Local:");

        CampoPastorLocal.setBackground(new java.awt.Color(255, 255, 255));
        CampoPastorLocal.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoPastorLocal.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Secretário:");

        CampoSecretario.setBackground(new java.awt.Color(255, 255, 255));
        CampoSecretario.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoSecretario.setForeground(new java.awt.Color(0, 0, 0));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Tesoureiro:");

        CampoTesoureiro.setBackground(new java.awt.Color(255, 255, 255));
        CampoTesoureiro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoTesoureiro.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CampoCNPJ)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 147, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(CampoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(CampoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoBairro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(CampoEstado, 0, 145, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CampoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(campoPastorPresidente, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoCidadeCampo)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoPastorLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoSecretario, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(CampoTesoureiro))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CampoPedirSenha))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel9))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CampoCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CampoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(CampoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(CampoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(CampoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel8))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CampoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel12)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CampoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoPastorPresidente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(CampoCidadeCampo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoPastorLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoTesoureiro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoSecretario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CampoPedirSenha)))
                .addGap(51, 51, 51)
                .addComponent(jLabel11)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void CampoPedirSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoPedirSenhaActionPerformed
        
    }//GEN-LAST:event_CampoPedirSenhaActionPerformed

    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
        ClasseConfiguracoes.BairroIgreja = CampoBairro.getText();
        ClasseConfiguracoes.CNPJIgreja = CampoCNPJ.getText();
        ClasseConfiguracoes.CidadeIgreja = CampoCidade.getText();
        ClasseConfiguracoes.EnderecoIgreja = CampoEndereco.getText();
        ClasseConfiguracoes.EstadoIgreja = CampoEstado.getSelectedItem().toString();
        ClasseConfiguracoes.IgrejaSede = CampoCidadeCampo.getText();
        ClasseConfiguracoes.NomeIgreja = CampoNome.getText();
        ClasseConfiguracoes.Numero = Integer.parseInt(CampoNumero.getText());
        ClasseConfiguracoes.PastorIgreja = CampoPastorLocal.getText();
        ClasseConfiguracoes.PastorPresidente = campoPastorPresidente.getText();
        ClasseConfiguracoes.PedirSenha = CampoPedirSenha.isSelected();
        ClasseConfiguracoes.SecretarioIgreja = CampoSecretario.getText();
        ClasseConfiguracoes.TelefoneIgreja = CampoTelefone.getText();
        ClasseConfiguracoes.TesoureiroIgreja = CampoTesoureiro.getText();
        
        if(CampoCodigo.getText().equals("")){
            ClasseConfiguracoes gravar = new ClasseConfiguracoes();
            gravar.InserirIgreja();
            this.dispose();
        }
        else{
            ClasseConfiguracoes editar = new ClasseConfiguracoes();
            editar.AlterarConfiguraçoes();
            this.dispose();
        }
        
        
    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void BotaoSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseEntered
        BotaoSalvar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoSalvarMouseEntered

    private void BotaoSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseExited
        BotaoSalvar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoSalvarMouseExited

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
            java.util.logging.Logger.getLogger(CadastroIgreja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroIgreja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroIgreja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroIgreja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroIgreja dialog = new CadastroIgreja(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField CampoBairro;
    private javax.swing.JFormattedTextField CampoCNPJ;
    private javax.swing.JTextField CampoCidade;
    private javax.swing.JTextField CampoCidadeCampo;
    private javax.swing.JTextField CampoCodigo;
    private javax.swing.JTextField CampoEndereco;
    private javax.swing.JComboBox<String> CampoEstado;
    private javax.swing.JTextField CampoNome;
    private javax.swing.JTextField CampoNumero;
    private javax.swing.JTextField CampoPastorLocal;
    private javax.swing.JCheckBox CampoPedirSenha;
    private javax.swing.JTextField CampoSecretario;
    private javax.swing.JFormattedTextField CampoTelefone;
    private javax.swing.JTextField CampoTesoureiro;
    private javax.swing.JTextField campoPastorPresidente;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
