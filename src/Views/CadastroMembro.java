
package Views;

import BancoDados.ConexaoBanco;
import Converter.DataHora;
import Converter.ImagemBd;
import Model.ClasseMembros;
import Model.ClasseRotas;
import Model.Relatorios;
import Model.clsRedimensionarImagem;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import net.sf.jasperreports.engine.JRException;


public class CadastroMembro extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();
    ClasseRotas rota = new ClasseRotas();
    DataHora dt = new DataHora();
    BufferedImage imagem;
    ImagemBd gravarbd = new ImagemBd();
    String path = "C:\\Program Files\\AdonaiSoft Igreja\\warning\\avatar.jpg";
    boolean img;
    
    
    public static int novo;

    public void limparcampos(){
        
        CampoNome.setText("");
        CampoDtNasc.setDate(null);
        CampoTelefone.setText("");
        CampoEndereco.setText("");
        CampoBairro.setText("");
        CampoNumero.setText("");
        CampoEstado.setSelectedItem("AC");
        CampoCidade.setText("");
        CampoCargo.setText("");
        CampoObservacoes.setText("");
        CampoAtivo.setSelected(false);
        CampoDataBatismo.setText("");
        CampoEmail.setText("");
        CampoEstadoCivil.setSelectedItem("Solteiro(a)");
        CampoCep.setText("");
        CampoBatizado.setSelected(false);
        ImageIcon ico = new ImageIcon(path);
        ico.setImage(ico.getImage().getScaledInstance(labelImagem.getWidth(),labelImagem.getHeight(),1));
        labelImagem.setIcon(ico);
        CampoDtNasc.setBackground(new Color(255,255,255));
        CampoCargo.setBackground(new Color(255,255,255));
        
    }
    public CadastroMembro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        if(CampoAtivo.isSelected() == false){
            CampoBatizado.setEnabled(false);
            
            CampoDataBatismo.setEnabled(false);
        }
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel1 = new javax.swing.JPanel();
        BotaoImprimir = new javax.swing.JButton();
        CampoCodigo = new javax.swing.JTextField();
        Salvar1 = new javax.swing.JButton();
        CampoNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        labelImagem = new javax.swing.JLabel();
        BuscarImg = new javax.swing.JButton();
        CampoDtNasc = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        CampoTelefone = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        CampoEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CampoEstadoCivil = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        CampoEndereco = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CampoNumero = new javax.swing.JTextField();
        CampoBairro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CampoCidade = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        CampoEstado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        CampoCep = new javax.swing.JFormattedTextField();
        CampoAtivo = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        CampoBatizado = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        CampoDataBatismo = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoObservacoes = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        BotaoAdicionarCargo = new javax.swing.JButton();
        BotaoBuscarCargo = new javax.swing.JButton();
        CampoCargo = new javax.swing.JTextField();
        Delimagen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Membros");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(238, 238, 238));

        BotaoImprimir.setBackground(new java.awt.Color(1, 1, 34));
        BotaoImprimir.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoImprimir.setForeground(new java.awt.Color(255, 255, 255));
        BotaoImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Imprimir.png"))); // NOI18N
        BotaoImprimir.setText("Imprimir");
        BotaoImprimir.setBorder(null);
        BotaoImprimir.setBorderPainted(false);
        BotaoImprimir.setFocusPainted(false);
        BotaoImprimir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoImprimirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoImprimirMouseExited(evt);
            }
        });
        BotaoImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoImprimirActionPerformed(evt);
            }
        });

        CampoCodigo.setEditable(false);
        CampoCodigo.setBackground(new java.awt.Color(238, 238, 238));
        CampoCodigo.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
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

        CampoNome.setBackground(new java.awt.Color(255, 255, 255));
        CampoNome.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoNome.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome Completo:");

        labelImagem.setBackground(new java.awt.Color(255, 255, 255));
        labelImagem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(163, 163, 163)));
        labelImagem.setMaximumSize(new java.awt.Dimension(135, 116));

        BuscarImg.setBackground(new java.awt.Color(1, 1, 34));
        BuscarImg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        BuscarImg.setForeground(new java.awt.Color(255, 255, 255));
        BuscarImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Download_15px.png"))); // NOI18N
        BuscarImg.setBorder(null);
        BuscarImg.setBorderPainted(false);
        BuscarImg.setFocusPainted(false);
        BuscarImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BuscarImgMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BuscarImgMouseExited(evt);
            }
        });
        BuscarImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarImgActionPerformed(evt);
            }
        });

        CampoDtNasc.setBackground(new java.awt.Color(255, 255, 255));
        CampoDtNasc.setForeground(new java.awt.Color(0, 0, 0));
        CampoDtNasc.setDateFormatString("dd/MM/yyyy");
        CampoDtNasc.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nascimento");

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

        CampoEmail.setBackground(new java.awt.Color(255, 255, 255));
        CampoEmail.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoEmail.setForeground(new java.awt.Color(0, 0, 0));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Email:");

        CampoEstadoCivil.setBackground(new java.awt.Color(255, 255, 255));
        CampoEstadoCivil.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoEstadoCivil.setForeground(new java.awt.Color(0, 0, 0));
        CampoEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro(a)", "Casado(a)", "Viúvo(a)", "Divorciado(a)", "Uniao Estavel" }));
        CampoEstadoCivil.setBorder(null);

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Estado Civil:");

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Número:");

        CampoEndereco.setBackground(new java.awt.Color(255, 255, 255));
        CampoEndereco.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoEndereco.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Endereço:");

        CampoNumero.setBackground(new java.awt.Color(255, 255, 255));
        CampoNumero.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoNumero.setForeground(new java.awt.Color(0, 0, 0));

        CampoBairro.setBackground(new java.awt.Color(255, 255, 255));
        CampoBairro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoBairro.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Bairro:");

        CampoCidade.setBackground(new java.awt.Color(255, 255, 255));
        CampoCidade.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoCidade.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Cidade:");

        CampoEstado.setBackground(new java.awt.Color(255, 255, 255));
        CampoEstado.setForeground(new java.awt.Color(0, 0, 0));
        CampoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE" }));
        CampoEstado.setBorder(null);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Estado:");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("CEP:");

        CampoCep.setBackground(new java.awt.Color(255, 255, 255));
        CampoCep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        CampoCep.setForeground(new java.awt.Color(0, 0, 0));
        try {
            CampoCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CampoCep.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        CampoAtivo.setBackground(new java.awt.Color(238, 238, 238));
        CampoAtivo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoAtivo.setForeground(new java.awt.Color(0, 0, 0));
        CampoAtivo.setSelected(true);
        CampoAtivo.setText("Ativo");
        CampoAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoAtivoActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Cargo:");

        CampoBatizado.setBackground(new java.awt.Color(238, 238, 238));
        CampoBatizado.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoBatizado.setForeground(new java.awt.Color(0, 0, 0));
        CampoBatizado.setText("Batizado");
        CampoBatizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoBatizadoActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Data de Batismo:");

        CampoDataBatismo.setBackground(new java.awt.Color(255, 255, 255));
        CampoDataBatismo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        CampoDataBatismo.setForeground(new java.awt.Color(0, 0, 0));
        try {
            CampoDataBatismo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CampoDataBatismo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        CampoObservacoes.setBackground(new java.awt.Color(255, 255, 255));
        CampoObservacoes.setColumns(20);
        CampoObservacoes.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoObservacoes.setForeground(new java.awt.Color(0, 0, 0));
        CampoObservacoes.setLineWrap(true);
        CampoObservacoes.setRows(5);
        jScrollPane1.setViewportView(CampoObservacoes);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Observações:");

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

        CampoCargo.setBackground(new java.awt.Color(255, 255, 255));
        CampoCargo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoCargo.setForeground(new java.awt.Color(0, 0, 0));
        CampoCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CampoCargoKeyPressed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel16))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(CampoEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(218, 218, 218)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(CampoEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CampoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(CampoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CampoDtNasc, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(CampoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(Delimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BuscarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelImagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(CampoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(CampoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(CampoDataBatismo, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CampoAtivo)
                                    .addComponent(CampoBatizado)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CampoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(BotaoBuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoAdicionarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Salvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BotaoImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CampoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Delimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BuscarImg, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel15))
                        .addGap(26, 26, 26))
                    .addComponent(CampoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(CampoDataBatismo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CampoBatizado)))
                        .addComponent(CampoCep, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoBuscarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoAdicionarCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(CampoAtivo))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Salvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CampoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void CampoAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoAtivoActionPerformed
        
    }//GEN-LAST:event_CampoAtivoActionPerformed

    private void BotaoImprimirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoImprimirMouseEntered
        BotaoImprimir.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoImprimirMouseEntered

    private void BotaoImprimirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoImprimirMouseExited
        BotaoImprimir.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoImprimirMouseExited

    private void BotaoImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoImprimirActionPerformed
        ClasseMembros.CodigoMembros = Integer.parseInt(CampoCodigo.getText());

        Relatorios imprimir = new Relatorios();
        try {
            imprimir.CarteiraMembro();
            this.dispose();
        } catch (JRException | IOException ex) {
            Logger.getLogger(CadastroMembro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_BotaoImprimirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(ClasseMembros.CodigoMembros == 0){
            ImageIcon ico = new ImageIcon(path);
            ico.setImage(ico.getImage().getScaledInstance(labelImagem.getWidth(),labelImagem.getHeight(),1));
            labelImagem.setIcon(ico);

        }
        else{
            Povoar();
        }

    }//GEN-LAST:event_formWindowOpened

    private void Salvar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Salvar1MouseEntered
        Salvar1.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_Salvar1MouseEntered

    private void Salvar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Salvar1MouseExited
        Salvar1.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_Salvar1MouseExited

    private void Salvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salvar1ActionPerformed
 
        CamposObrigatorios();
    }//GEN-LAST:event_Salvar1ActionPerformed

   
    
    private void BuscarImgMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarImgMouseEntered
        BuscarImg.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BuscarImgMouseEntered

    private void BuscarImgMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarImgMouseExited
        BuscarImg.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BuscarImgMouseExited

    private void BuscarImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarImgActionPerformed
 
        clsRedimensionarImagem red = new clsRedimensionarImagem();
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
   
        ImageIcon ico = new ImageIcon(arqu.getPath());
        ico.setImage(ico.getImage().getScaledInstance(labelImagem.getWidth(),labelImagem.getHeight(),1));
        labelImagem.setIcon(ico);
        }

    }//GEN-LAST:event_BuscarImgActionPerformed

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
    private void CampoBatizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoBatizadoActionPerformed
        
    }//GEN-LAST:event_CampoBatizadoActionPerformed

    private void BotaoAdicionarCargoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAdicionarCargoMouseEntered
        BotaoAdicionarCargo.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoAdicionarCargoMouseEntered

    private void BotaoAdicionarCargoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoAdicionarCargoMouseExited
        BotaoAdicionarCargo.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoAdicionarCargoMouseExited

    private void BotaoAdicionarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAdicionarCargoActionPerformed
        CadastroCargo cargo = new CadastroCargo(null, true);
        cargo.setVisible(true);
    }//GEN-LAST:event_BotaoAdicionarCargoActionPerformed

    private void BotaoBuscarCargoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoBuscarCargoMouseEntered
        BotaoBuscarCargo.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoBuscarCargoMouseEntered

    private void BotaoBuscarCargoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoBuscarCargoMouseExited
        BotaoBuscarCargo.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoBuscarCargoMouseExited

    private void BotaoBuscarCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscarCargoActionPerformed
        PesquisaCargo cargo = new PesquisaCargo(null, true);
        cargo.setVisible(true);
    }//GEN-LAST:event_BotaoBuscarCargoActionPerformed

    private void DelimagenMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelimagenMouseEntered
        Delimagen.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_DelimagenMouseEntered

    private void DelimagenMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DelimagenMouseExited
        Delimagen.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_DelimagenMouseExited

    private void DelimagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelimagenActionPerformed

        ImageIcon ico = new ImageIcon(path);
        ico.setImage(ico.getImage().getScaledInstance(labelImagem.getWidth(),labelImagem.getHeight(),1));
        labelImagem.setIcon(ico);
    }//GEN-LAST:event_DelimagenActionPerformed

    private void CampoCargoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoCargoKeyPressed
        PesquisaCargo cargo = new PesquisaCargo(null, true);
        cargo.setVisible(true);
    }//GEN-LAST:event_CampoCargoKeyPressed

    public void salvar(){
        ClasseMembros.NomeCompleto = CampoNome.getText();
        ClasseMembros.DataNascimento = (java.sql.Date) dt.DataBd(CampoDtNasc.getDate());
        ClasseMembros.IDCargo = ClasseMembros.IdMembro;
        ClasseMembros.Telefone = CampoTelefone.getText();
        ClasseMembros.Endereco = CampoEndereco.getText();
        ClasseMembros.Bairro = CampoBairro.getText();
        ClasseMembros.UF = CampoEstado.getSelectedItem().toString();
        ClasseMembros.Cidade = CampoCidade.getText();
        ClasseMembros.Observacoes = CampoObservacoes.getText();
        ClasseMembros.Ativo = CampoAtivo.isSelected();
        ClasseMembros.DataBatismo = CampoDataBatismo.getText();
        if(img == true){
            ClasseMembros.Imagem = gravarbd.getImgBytes(imagem);
        }
        else{
            imagem = img(path);
            ClasseMembros.Imagem = gravarbd.getImgBytes(imagem);
        }
        
        ClasseMembros.Email = CampoEmail.getText();
        ClasseMembros.EstadoCivil = CampoEstadoCivil.getSelectedItem().toString();
        ClasseMembros.Cep = CampoCep.getText();
        ClasseMembros.Batizado = CampoBatizado.isSelected();

        verificar();
            
            
            if(CampoCodigo.getText().equals("")){
                ClasseMembros gravar = new ClasseMembros();
                gravar.InserirMembros();
                limparcampos();
                
            }
            else{
                ClasseMembros editar = new ClasseMembros();
                editar.AlterarMembros();
                this.dispose();
           }
    }
    
    public void Povoar(){
        
        String sql = "SELECT codigomembro, nomecompleto, datanascimento, telefone, endereco, bairro, cidade, numero, uf, ativo, cargo.descricao, observacoes, databatismo, cep, estadocivil, imagem, batizado, email,Membros.IDCargo\n" +
                    "FROM membros\n" +
                    "INNER JOIN cargo ON cargo.IDCargo = membros.IdCargo\n" +
                    "where codigomembro = "+ClasseMembros.CodigoMembros;
        Connection con = conectar.Conectar();
        ResultSet rs= null;
        PreparedStatement stmt = null;
        
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();
            
            CampoCodigo.setText(rs.getString("CodigoMembro"));
            CampoNome.setText(rs.getString("NomeCompleto"));
            CampoDtNasc.setDate(rs.getDate("DataNascimento"));
            CampoTelefone.setText(rs.getString("Telefone"));
            CampoEndereco.setText(rs.getString("Endereco"));
            CampoBairro.setText(rs.getString("Bairro"));
            CampoCidade.setText(rs.getString("Cidade"));
            CampoNumero.setText(rs.getString("Numero"));
            CampoEstado.setSelectedItem(rs.getString("UF"));
            CampoAtivo.setSelected(rs.getBoolean("Ativo"));
            CampoCargo.setText(rs.getString("descricao"));
            CampoObservacoes.setText(rs.getString("Observacoes"));  
            CampoDataBatismo.setText(rs.getString("DataBatismo"));
            ClasseMembros.Imagem = rs.getBytes("imagem");
            gravarbd.exibiImagemLabel(ClasseMembros.Imagem, labelImagem);
            CampoEmail.setText(rs.getString("Email"));
            CampoEstadoCivil.setSelectedItem(rs.getString("EstadoCivil"));
            CampoCep.setText(rs.getString("CEP"));
            CampoBatizado.setSelected(rs.getBoolean("Batizado"));
            ClasseMembros.IdMembro = Integer.parseInt(rs.getString("IDCargo"));
            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
        
    }
    public void verificar(){
        
        if(CampoNumero.getText().equals("")){
        ClasseMembros.Numero = 0;
        }
        else{
            ClasseMembros.Numero = Integer.parseInt(CampoNumero.getText());
        }
  
    }
    
    public void CamposObrigatorios(){
        
        if(CampoDtNasc.getDate() == null){
            JOptionPane.showMessageDialog(null, "O Campo Data Nascimento não pode ficar em branco");
            CampoDtNasc.setBackground(new Color(242,199,209));
        }
        else if(CampoCargo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "O Campo Cargo não pode ficar em branco");
            CampoCargo.setBackground(new Color(242,199,209));
        }
        else{
            salvar();
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
            java.util.logging.Logger.getLogger(CadastroMembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroMembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroMembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroMembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroMembro dialog = new CadastroMembro(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BotaoAdicionarCargo;
    private javax.swing.JButton BotaoBuscarCargo;
    private javax.swing.JButton BotaoImprimir;
    private javax.swing.JButton BuscarImg;
    private javax.swing.JCheckBox CampoAtivo;
    private javax.swing.JTextField CampoBairro;
    private javax.swing.JCheckBox CampoBatizado;
    public static javax.swing.JTextField CampoCargo;
    private javax.swing.JFormattedTextField CampoCep;
    private javax.swing.JTextField CampoCidade;
    private javax.swing.JTextField CampoCodigo;
    private javax.swing.JFormattedTextField CampoDataBatismo;
    private com.toedter.calendar.JDateChooser CampoDtNasc;
    private javax.swing.JTextField CampoEmail;
    private javax.swing.JTextField CampoEndereco;
    private javax.swing.JComboBox<String> CampoEstado;
    private javax.swing.JComboBox<String> CampoEstadoCivil;
    private javax.swing.JTextField CampoNome;
    private javax.swing.JTextField CampoNumero;
    private javax.swing.JTextArea CampoObservacoes;
    private javax.swing.JFormattedTextField CampoTelefone;
    private javax.swing.JButton Delimagen;
    private javax.swing.JButton Salvar1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelImagem;
    // End of variables declaration//GEN-END:variables
}
