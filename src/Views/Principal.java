
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseCaixas;
import Model.ClasseUsuario;
import Model.VariaveisUniversais;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;



public class Principal extends javax.swing.JFrame {
    ConexaoBanco conectar = new ConexaoBanco();
    String formato = "R$ 0.00";
    String form = "0.00";
    DecimalFormat df = new DecimalFormat(formato);
    DecimalFormat dt = new DecimalFormat(form);
    double valorInicial;
    double saldo;
    public double total;
    String nomeIgreja;
    
    
   public static int w;
   public static int h;
   public static Dimension te;
   
   public Principal() {
        initComponents();
       w = Painel.getWidth();
       h = Painel.getHeight();
       TabelaMembros tabMen = new TabelaMembros();
       
       int tm,ta,ti;
       
       ta = tabMen.ContarAtivos();
       ti = tabMen.ContarInativos();
       tm = ta+ti;
    
       TotalMembros.setText(String.valueOf(tm));
       MembrosInativos.setText(String.valueOf(ti));
       MembrosAtivos.setText(String.valueOf(ta));

        setExtendedState(MAXIMIZED_BOTH);
        setIcon();
        preencher();
        NomeUsuario.setText("Bem Vindo: "+ClasseUsuario.NomeUsuario);
        NomeIgreja.setText("Sistema Licenciado para uso da: "+nomeIgreja);
        
          
    }
    public void setIcon(){
    
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
}
    
    public void bloquear(){
        if(ClasseUsuario.Caixas == false){
            BotaoFinanceiro.setEnabled(false);
        }
        if(ClasseUsuario.Configuracoes == false){
            BotaoConfiguracoess.setEnabled(false);
        }
        if(ClasseUsuario.Despesas == false){
            BotaoFinanceiro.setEnabled(false);
        }
        if(ClasseUsuario.Entradas == false){
            BotaoFinanceiro.setEnabled(false);
        }
        if(ClasseUsuario.Membros == false){
            BotaoSecretaria.setEnabled(false);
        }
        if(ClasseUsuario.Relatorios == false){
            BotaoRelatorios.setEnabled(false);
        }
        if(ClasseUsuario.Usuarios == false){
            BotaoConfiguracoess.setEnabled(false);
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        BotaoDashBoard = new javax.swing.JButton();
        BotaoSecretaria = new javax.swing.JButton();
        BotaoFinanceiro = new javax.swing.JButton();
        BotaoEscola = new javax.swing.JButton();
        BotaoRelatorios = new javax.swing.JButton();
        BotaoConfiguracoess = new javax.swing.JButton();
        BotaoSobre = new javax.swing.JButton();
        PainelPrincipal = new javax.swing.JPanel();
        PainelMenus = new javax.swing.JPanel();
        Painel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        MembrosAtivos = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        MembrosInativos = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TotalMembros = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        CampoEntradas = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        CampoSaídas = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        CampoTotal = new javax.swing.JTextField();
        Adicionar = new javax.swing.JButton();
        NomeUsuario = new javax.swing.JLabel();
        NomeIgreja = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" AdonaiSoft  - Igreja   Versão: 1.0.35");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(1, 1, 34));

        jPanel4.setBackground(new java.awt.Color(1, 1, 34));
        jPanel4.setEnabled(false);

        BotaoDashBoard.setBackground(new java.awt.Color(1, 1, 34));
        BotaoDashBoard.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        BotaoDashBoard.setForeground(new java.awt.Color(255, 255, 255));
        BotaoDashBoard.setText("DashBoard");
        BotaoDashBoard.setToolTipText("DashBoard");
        BotaoDashBoard.setBorder(null);
        BotaoDashBoard.setBorderPainted(false);
        BotaoDashBoard.setFocusPainted(false);
        BotaoDashBoard.setFocusable(false);
        BotaoDashBoard.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BotaoDashBoardMouseMoved(evt);
            }
        });
        BotaoDashBoard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoDashBoardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoDashBoardMouseExited(evt);
            }
        });
        BotaoDashBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoDashBoardActionPerformed(evt);
            }
        });

        BotaoSecretaria.setBackground(new java.awt.Color(1, 1, 34));
        BotaoSecretaria.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        BotaoSecretaria.setForeground(new java.awt.Color(255, 255, 255));
        BotaoSecretaria.setText("Secretaria");
        BotaoSecretaria.setBorder(null);
        BotaoSecretaria.setFocusPainted(false);
        BotaoSecretaria.setFocusable(false);
        BotaoSecretaria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoSecretariaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoSecretariaMouseExited(evt);
            }
        });
        BotaoSecretaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSecretariaActionPerformed(evt);
            }
        });

        BotaoFinanceiro.setBackground(new java.awt.Color(1, 1, 34));
        BotaoFinanceiro.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        BotaoFinanceiro.setForeground(new java.awt.Color(255, 255, 255));
        BotaoFinanceiro.setText("Financeiro");
        BotaoFinanceiro.setBorder(null);
        BotaoFinanceiro.setFocusPainted(false);
        BotaoFinanceiro.setFocusable(false);
        BotaoFinanceiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoFinanceiroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoFinanceiroMouseExited(evt);
            }
        });
        BotaoFinanceiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoFinanceiroActionPerformed(evt);
            }
        });

        BotaoEscola.setBackground(new java.awt.Color(1, 1, 34));
        BotaoEscola.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        BotaoEscola.setForeground(new java.awt.Color(255, 255, 255));
        BotaoEscola.setText("Escola");
        BotaoEscola.setBorder(null);
        BotaoEscola.setFocusPainted(false);
        BotaoEscola.setFocusable(false);
        BotaoEscola.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoEscolaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoEscolaMouseExited(evt);
            }
        });
        BotaoEscola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEscolaActionPerformed(evt);
            }
        });

        BotaoRelatorios.setBackground(new java.awt.Color(1, 1, 34));
        BotaoRelatorios.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        BotaoRelatorios.setForeground(new java.awt.Color(255, 255, 255));
        BotaoRelatorios.setText("Relatórios");
        BotaoRelatorios.setBorder(null);
        BotaoRelatorios.setFocusPainted(false);
        BotaoRelatorios.setFocusable(false);
        BotaoRelatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoRelatoriosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoRelatoriosMouseExited(evt);
            }
        });
        BotaoRelatorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRelatoriosActionPerformed(evt);
            }
        });

        BotaoConfiguracoess.setBackground(new java.awt.Color(1, 1, 34));
        BotaoConfiguracoess.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        BotaoConfiguracoess.setForeground(new java.awt.Color(255, 255, 255));
        BotaoConfiguracoess.setText("Configurações");
        BotaoConfiguracoess.setBorder(null);
        BotaoConfiguracoess.setFocusPainted(false);
        BotaoConfiguracoess.setFocusable(false);
        BotaoConfiguracoess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoConfiguracoessMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoConfiguracoessMouseExited(evt);
            }
        });
        BotaoConfiguracoess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConfiguracoessActionPerformed(evt);
            }
        });

        BotaoSobre.setBackground(new java.awt.Color(1, 1, 34));
        BotaoSobre.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        BotaoSobre.setForeground(new java.awt.Color(255, 255, 255));
        BotaoSobre.setText("Sobre");
        BotaoSobre.setBorder(null);
        BotaoSobre.setFocusPainted(false);
        BotaoSobre.setFocusable(false);
        BotaoSobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoSobreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoSobreMouseExited(evt);
            }
        });
        BotaoSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSobreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BotaoDashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoConfiguracoess, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BotaoSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(BotaoConfiguracoess, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BotaoRelatorios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BotaoEscola, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BotaoFinanceiro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BotaoSecretaria, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BotaoDashBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(BotaoSobre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PainelPrincipal.setBackground(new java.awt.Color(1, 1, 34));
        PainelPrincipal.setPreferredSize(new java.awt.Dimension(992, 239));
        PainelPrincipal.setRequestFocusEnabled(false);
        PainelPrincipal.setVerifyInputWhenFocusTarget(false);

        PainelMenus.setBackground(new java.awt.Color(1, 1, 34));

        javax.swing.GroupLayout PainelMenusLayout = new javax.swing.GroupLayout(PainelMenus);
        PainelMenus.setLayout(PainelMenusLayout);
        PainelMenusLayout.setHorizontalGroup(
            PainelMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );
        PainelMenusLayout.setVerticalGroup(
            PainelMenusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Painel.setBackground(new java.awt.Color(219, 230, 244));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("DashBoard");

        jPanel1.setBackground(new java.awt.Color(219, 230, 244));

        jPanel5.setBackground(new java.awt.Color(0, 189, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(248, 116));

        jPanel8.setBackground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Membros Ativos");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        MembrosAtivos.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        MembrosAtivos.setForeground(new java.awt.Color(255, 255, 255));
        MembrosAtivos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MembrosAtivos.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(MembrosAtivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MembrosAtivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));

        jPanel9.setBackground(new java.awt.Color(219, 51, 51));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Membros Inativos");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        MembrosInativos.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        MembrosInativos.setForeground(new java.awt.Color(255, 255, 255));
        MembrosInativos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        MembrosInativos.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(MembrosInativos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MembrosInativos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jPanel2.setBackground(new java.awt.Color(1, 1, 70));

        jPanel7.setBackground(new java.awt.Color(1, 1, 34));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Total de Membros");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        TotalMembros.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        TotalMembros.setForeground(new java.awt.Color(255, 255, 255));
        TotalMembros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TotalMembros.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(TotalMembros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(TotalMembros, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(0, 189, 0));

        jPanel14.setBackground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Total de Entradas");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        CampoEntradas.setEditable(false);
        CampoEntradas.setBackground(new java.awt.Color(0, 189, 0));
        CampoEntradas.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoEntradas.setForeground(new java.awt.Color(255, 255, 255));
        CampoEntradas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoEntradas.setText("0,00");
        CampoEntradas.setBorder(null);
        CampoEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoEntradasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(CampoEntradas))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoEntradas)
                .addGap(19, 19, 19))
        );

        jPanel15.setBackground(new java.awt.Color(255, 51, 51));

        jPanel16.setBackground(new java.awt.Color(219, 51, 51));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Total de Despesas");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        CampoSaídas.setEditable(false);
        CampoSaídas.setBackground(new java.awt.Color(255, 51, 51));
        CampoSaídas.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoSaídas.setForeground(new java.awt.Color(255, 255, 255));
        CampoSaídas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoSaídas.setText("0,00");
        CampoSaídas.setBorder(null);
        CampoSaídas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoSaídasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CampoSaídas))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoSaídas)
                .addGap(19, 19, 19))
        );

        jPanel17.setBackground(new java.awt.Color(1, 1, 70));

        jPanel18.setBackground(new java.awt.Color(1, 1, 34));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total em Caixa");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        CampoTotal.setEditable(false);
        CampoTotal.setBackground(new java.awt.Color(1, 1, 70));
        CampoTotal.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoTotal.setForeground(new java.awt.Color(255, 255, 255));
        CampoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoTotal.setText("0,00");
        CampoTotal.setBorder(null);
        CampoTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(CampoTotal))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoTotal)
                .addGap(21, 21, 21))
        );

        Adicionar.setBackground(new java.awt.Color(1, 1, 34));
        Adicionar.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Adicionar.setForeground(new java.awt.Color(255, 255, 255));
        Adicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Busacar.png"))); // NOI18N
        Adicionar.setText("Buscar Saldo");
        Adicionar.setBorder(null);
        Adicionar.setBorderPainted(false);
        Adicionar.setFocusPainted(false);
        Adicionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdicionarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdicionarMouseExited(evt);
            }
        });
        Adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarActionPerformed(evt);
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
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(305, 305, 305)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addGroup(PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelLayout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLayout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        NomeUsuario.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        NomeUsuario.setForeground(new java.awt.Color(255, 255, 255));
        NomeUsuario.setToolTipText("");

        NomeIgreja.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        NomeIgreja.setForeground(new java.awt.Color(255, 255, 255));
        NomeIgreja.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        NomeIgreja.setToolTipText("");

        javax.swing.GroupLayout PainelPrincipalLayout = new javax.swing.GroupLayout(PainelPrincipal);
        PainelPrincipal.setLayout(PainelPrincipalLayout);
        PainelPrincipalLayout.setHorizontalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addComponent(PainelMenus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NomeIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PainelPrincipalLayout.setVerticalGroup(
            PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(PainelPrincipalLayout.createSequentialGroup()
                .addGroup(PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PainelMenus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sdona.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoDashBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoDashBoardActionPerformed
        TabelaDashBoard ch = new TabelaDashBoard();
        

        
        int l = Painel.getWidth();
        int a = Painel.getHeight();
        
        
        Painel.removeAll();
        Painel.add(ch);
        Painel.revalidate();
        Painel.repaint();
        
       ch.setSize(l  ,a);
    }//GEN-LAST:event_BotaoDashBoardActionPerformed

    private void BotaoDashBoardMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoDashBoardMouseMoved
        
    }//GEN-LAST:event_BotaoDashBoardMouseMoved

    private void BotaoDashBoardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoDashBoardMouseEntered
        BotaoDashBoard.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoDashBoardMouseEntered

    private void BotaoDashBoardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoDashBoardMouseExited
        BotaoDashBoard.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoDashBoardMouseExited

    private void BotaoSecretariaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSecretariaMouseEntered
        BotaoSecretaria.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoSecretariaMouseEntered

    private void BotaoSecretariaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSecretariaMouseExited
        BotaoSecretaria.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoSecretariaMouseExited

    private void BotaoSecretariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSecretariaActionPerformed

        MenuSecretaria chamar = new MenuSecretaria();
        //chamar.setLocation(5, 5);
        
        int l = PainelMenus.getWidth();
        int a = PainelMenus.getHeight();
                
        PainelMenus.removeAll();
        PainelMenus.add(chamar);
        PainelMenus.revalidate();
        PainelMenus.repaint();
        
       chamar.setSize(171 ,445);
    }//GEN-LAST:event_BotaoSecretariaActionPerformed

    private void BotaoFinanceiroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoFinanceiroMouseEntered
        BotaoFinanceiro.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoFinanceiroMouseEntered

    private void BotaoFinanceiroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoFinanceiroMouseExited
        BotaoFinanceiro.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoFinanceiroMouseExited

    private void BotaoFinanceiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoFinanceiroActionPerformed
        MenuFinanceiro chamar = new MenuFinanceiro();
        //chamar.setLocation(5, 5);
        
        int l = PainelMenus.getWidth();
        int a = PainelMenus.getHeight();
       
        
        PainelMenus.removeAll();
        PainelMenus.add(chamar);
        PainelMenus.revalidate();
        PainelMenus.repaint();
        
       chamar.setSize(171 ,445);
    }//GEN-LAST:event_BotaoFinanceiroActionPerformed

    private void BotaoEscolaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEscolaMouseEntered
       BotaoEscola.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoEscolaMouseEntered

    private void BotaoEscolaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoEscolaMouseExited
        BotaoEscola.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoEscolaMouseExited

    private void BotaoEscolaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEscolaActionPerformed
        MenuEscola chamar = new MenuEscola();
        
        int l = PainelMenus.getWidth();
        int a = PainelMenus.getHeight();
       
        
        PainelMenus.removeAll();
        PainelMenus.add(chamar);
        PainelMenus.revalidate();
        PainelMenus.repaint();
        
       chamar.setSize(171 ,445);
    }//GEN-LAST:event_BotaoEscolaActionPerformed

    private void BotaoRelatoriosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRelatoriosMouseEntered
        BotaoRelatorios.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoRelatoriosMouseEntered

    private void BotaoRelatoriosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoRelatoriosMouseExited
        BotaoRelatorios.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoRelatoriosMouseExited

    private void BotaoRelatoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRelatoriosActionPerformed

         
           TelaRelatorio chamar = new TelaRelatorio(null, true);
           chamar.setVisible(true);


    }//GEN-LAST:event_BotaoRelatoriosActionPerformed

    private void BotaoConfiguracoessMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoConfiguracoessMouseEntered
        BotaoConfiguracoess.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoConfiguracoessMouseEntered

    private void BotaoConfiguracoessMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoConfiguracoessMouseExited
        BotaoConfiguracoess.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoConfiguracoessMouseExited

    private void BotaoConfiguracoessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConfiguracoessActionPerformed
        MenuConfiguracoes chamar = new MenuConfiguracoes();
        //chamar.setLocation(5, 5);
       
        
        PainelMenus.removeAll();
        PainelMenus.add(chamar);
        PainelMenus.revalidate();
        PainelMenus.repaint();
        
       chamar.setSize(171 ,445);
    }//GEN-LAST:event_BotaoConfiguracoessActionPerformed

    private void CampoEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoEntradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoEntradasActionPerformed

    private void CampoSaídasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoSaídasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoSaídasActionPerformed

    private void AdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionarMouseEntered
        Adicionar.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_AdicionarMouseEntered

    private void AdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionarMouseExited
        Adicionar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_AdicionarMouseExited

    private void AdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarActionPerformed
        VariaveisUniversais saldo = new VariaveisUniversais();
        ClasseCaixas caixa = new ClasseCaixas();
        saldo.setEntrada(3);
        PesquisaCaixas valor = new PesquisaCaixas(null, true);
        
        valor.setVisible(true);
        caixa.SomarEntradas();
        caixa.SomarSaidas();
        caixa.pegarsaldo();
        total = caixa.getSomaEntradas() - caixa.SomaDespesas + caixa.getSaldoInicial();
        CampoTotal.setText(String.valueOf(dt.format(total)));
        CampoEntradas.setText(String.valueOf(dt.format(caixa.getSomaEntradas())));
        CampoSaídas.setText(String.valueOf(dt.format(caixa.getSomaDespesas())));
        
        
    }//GEN-LAST:event_AdicionarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
 
        preencher();
        
    }//GEN-LAST:event_formWindowOpened

    private void BotaoSobreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSobreMouseEntered
        BotaoSobre.setBackground(new Color(219,230,244));
    }//GEN-LAST:event_BotaoSobreMouseEntered

    private void BotaoSobreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSobreMouseExited
        BotaoSobre.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoSobreMouseExited

    private void BotaoSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSobreActionPerformed
        Sobre abrir = new Sobre(null, true);
        abrir.setVisible(true);
    }//GEN-LAST:event_BotaoSobreActionPerformed

    private void CampoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoTotalActionPerformed

    public void preencher(){
            String sql = "SELECT * FROM Configuracoes WHERE CodiIgreja = 1";
            Connection con = conectar.Conectar();
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try{
                stmt = con.prepareStatement(sql);
                stmt.execute();
                rs = stmt.executeQuery();
                rs.next();
                
                nomeIgreja = rs.getString("NomeIgreja");
                
                
                stmt.close();
                rs.close();
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adicionar;
    private javax.swing.JButton BotaoConfiguracoess;
    private javax.swing.JButton BotaoDashBoard;
    private javax.swing.JButton BotaoEscola;
    private javax.swing.JButton BotaoFinanceiro;
    private javax.swing.JButton BotaoRelatorios;
    private javax.swing.JButton BotaoSecretaria;
    private javax.swing.JButton BotaoSobre;
    private javax.swing.JTextField CampoEntradas;
    private javax.swing.JTextField CampoSaídas;
    private javax.swing.JTextField CampoTotal;
    private javax.swing.JLabel MembrosAtivos;
    private javax.swing.JLabel MembrosInativos;
    private javax.swing.JLabel NomeIgreja;
    private javax.swing.JLabel NomeUsuario;
    public static javax.swing.JPanel Painel;
    public static javax.swing.JPanel PainelMenus;
    public static javax.swing.JPanel PainelPrincipal;
    private javax.swing.JLabel TotalMembros;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
