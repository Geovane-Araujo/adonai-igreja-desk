
package com.adonaisoft.adonaisdesktop.view;

import com.adonaisoft.adonaisdesktop.configuration.database.ConexaoBanco;
import com.adonaisoft.adonaisdesktop.model.ClasseCaixas;
import com.adonaisoft.adonaisdesktop.model.ClasseUsuario;
import com.adonaisoft.adonaisdesktop.model.VariaveisUniversais;
import com.adonaisoft.adonaisdesktop.view.gerais.TelaRelatorio;
import com.adonaisoft.adonaisdesktop.view.membros.list.TabelaMembros;

import com.adonaisoft.adonaisdesktop.model.ClasseRotas;
import com.adonaisoft.adonaisdesktop.view.aniversariantes.form.Aniversariantes;
import com.adonaisoft.adonaisdesktop.view.contatoIgrejas.list.TabelaIgrejas;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
        configurarMenus();
       w = painel.getWidth();
       h = painel.getHeight();
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

    // Menus construidos fora do codigo gerado para preservar as acoes no editor do NetBeans.
    private void configurarMenus() {
        JMenuBar barra = new JMenuBar();
        JMenu inicio = novoMenu(barra, "Início", 'I');
        adicionarItem(inicio, "Visão geral", () -> {
            TabelaMembros membros = new TabelaMembros();
            int ativos = membros.ContarAtivos();
            int inativos = membros.ContarInativos();
            TotalMembros.setText(String.valueOf(ativos + inativos));
            MembrosAtivos.setText(String.valueOf(ativos));
            MembrosInativos.setText(String.valueOf(inativos));
            mostrarTela(painelInicio);
        });
        menuSecretaria = novoMenu(barra, "Secretaria", 'S');
        menuFinanceiro = novoMenu(barra, "Financeiro", 'F');
        JMenu escola = novoMenu(barra, "Escola Bíblica", 'E');
        menuRelatorios = novoMenu(barra, "Relatórios", 'R');
        adicionarItem(menuRelatorios, "Abrir relatórios", () -> new TelaRelatorio(this, true).setVisible(true));
        menuConfiguracoes = novoMenu(barra, "Configurações", 'C');
        JMenu ajuda = novoMenu(barra, "Ajuda", 'A');
        adicionarItem(ajuda, "Sobre", () -> new Sobre(this, true).setVisible(true));
        adicionarItem(menuSecretaria, "Membros", this::abrirMembros);
        adicionarItem(menuSecretaria, "Visitantes", this::abrirVisitantes);
        adicionarItem(menuSecretaria, "Igrejas", this::abrirIgrejas);
        adicionarItem(menuSecretaria, "Tipos de contas", this::abrirTipos);
        adicionarItem(menuSecretaria, "Cargos", this::abrirCargo);
        adicionarItem(menuSecretaria, "Aniversariantes", this::abrirAniversariantes);
        adicionarItem(menuFinanceiro, "Entradas", this::abrirEntradas);
        adicionarItem(menuFinanceiro, "Despesas", this::abrirDespesas);
        adicionarItem(menuFinanceiro, "Caixas", this::abrirCaixas);
        adicionarItem(escola, "Classes e chamadas", this::abrirClasses);
        adicionarItem(menuConfiguracoes, "Igreja", this::abrirIgreja);
        adicionarItem(menuConfiguracoes, "Usuários", this::abrirUsuario);
        adicionarItem(menuConfiguracoes, "Globais", this::abrirGlobais);
        setJMenuBar(barra);
        setMinimumSize(new Dimension(800, 600));
    }

    private JMenu novoMenu(JMenuBar barra, String titulo, char atalho) {
        JMenu menu = new JMenu(titulo);
        menu.setMnemonic(atalho);
        barra.add(menu);
        return menu;
    }

    private void adicionarItem(JMenu menu, String titulo, Runnable acao) {
        JMenuItem item = new JMenuItem(titulo);
        item.addActionListener(event -> acao.run());
        menu.add(item);
    }

    private void mostrarTela(JPanel tela) {
        painel.removeAll();
        painel.add(tela, BorderLayout.CENTER);
        painel.revalidate();
        painel.repaint();
    }

    private void abrirMembros() {
       TabelaMembros chamar = new TabelaMembros();
        mostrarTela(chamar);
        chamar.ContarMembros();
        chamar.ContarAtivos();
        chamar.ContarInativos();
        String sql = rota.getRTCadMembros();
        chamar.preencher(sql);
        chamar.mimx();
        chamar.paginacao();
    }

    private void abrirVisitantes() {
        TabelaVisitantes chamar = new TabelaVisitantes();
        mostrarTela(chamar);
        String sql = rota.getRTVisitantes();
        String sq = rota.getRTHistoricoVisita();
        chamar.Povoar(sql);
        chamar.historico(sq);
        chamar.Povoar();
        chamar.paginacao();
        chamar.Povoarhistorico();
        chamar.paginacaoHistorico();
    }

    private void abrirIgrejas() {
        TabelaIgrejas chamar = new TabelaIgrejas();
        mostrarTela(chamar);
        String sql = rota.getRTIgrejas();
        chamar.preencher(sql);
    }

    private void abrirTipos() {
        TabelaTipo chamar = new TabelaTipo();
        mostrarTela(chamar);
        String sql = rota.getRTTipo();
        chamar.Povoar(sql);
    }

    private void abrirCargo() {
        TabelaCadCargo chamar = new TabelaCadCargo();
        mostrarTela(chamar);
        String sql = rota.getRTCargo();
        chamar.Povoar(sql);
    }

    private void abrirAniversariantes() {
        Aniversariantes ani = new Aniversariantes(this, true);
       ani.setVisible(true);
    }

    private void abrirEntradas() {

       TabelaEntradas chamar = new TabelaEntradas();
        mostrarTela(chamar);
        String sql = rota.getRTTabEntradas();
        chamar.Povoar(sql);
        chamar.Povoar();// povoa as variaveis minimo e máximo
        chamar.paginacao();
    }

    private void abrirDespesas() {
        TelaDespesas chamar = new TelaDespesas();
        mostrarTela(chamar);
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
    }

    private void abrirCaixas() {
       TabelaCaixas chamar = new TabelaCaixas();
        mostrarTela(chamar);
        String sql = rota.getRTCaixa();
        String sq = rota.getRTCXHistorico();
        chamar.povoarTabela(sql);
        chamar.povoarTabelaHistoarico(sq);
    }

    private void abrirClasses() {
      TabelaClasse chamar = new TabelaClasse();
        mostrarTela(chamar);
        String sql = rota.getTabelaClasses();
        chamar.PovoarHistorico();
        chamar.Povoar(sql);
    }

    private void abrirIgreja() {
       TabelaConfiguracoes chamar = new TabelaConfiguracoes();
        mostrarTela(chamar);
        String sql = "SELECT * FROM Configuracoes";
        chamar.Preencher(sql);
    }

    private void abrirUsuario() {
        TabelaUsuarios chamar = new TabelaUsuarios();
        mostrarTela(chamar);
        String sql = "SELECT CodigoUsuario,NomeUsuario FROM Usuario ORDER BY CodigoUsuario DESC";
        chamar.Povoar(sql);
    }

    private void abrirGlobais() {
        CadastroGlobais cha = new CadastroGlobais(this, true);
        cha.setVisible(true);
    }

    public void setIcon(){

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
}

    public void bloquear() {
        menuSecretaria.setEnabled(ClasseUsuario.Membros);
        menuFinanceiro.setEnabled(ClasseUsuario.Caixas && ClasseUsuario.Despesas && ClasseUsuario.Entradas);
        menuConfiguracoes.setEnabled(ClasseUsuario.Configuracoes && ClasseUsuario.Usuarios);
        menuRelatorios.setEnabled(ClasseUsuario.Relatorios);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelInicio = new javax.swing.JPanel();
        centroInicio = new javax.swing.JPanel();
        rodape = new javax.swing.JPanel();
        painel = new javax.swing.JPanel();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" AdonaiSoft  - Igreja   Versão: 1.0.35");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
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




        Adicionar.setText("Buscar Saldo");



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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(Adicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        getContentPane().setLayout(new java.awt.BorderLayout());
        painel.setLayout(new java.awt.BorderLayout());
        painelInicio.setLayout(new java.awt.BorderLayout());
        centroInicio.setLayout(new java.awt.GridBagLayout());
        centroInicio.add(jPanel1, new java.awt.GridBagConstraints());
        painelInicio.add(jLabel8, java.awt.BorderLayout.NORTH);
        painelInicio.add(centroInicio, java.awt.BorderLayout.CENTER);
        painel.add(painelInicio, java.awt.BorderLayout.CENTER);
        getContentPane().add(painel, java.awt.BorderLayout.CENTER);

        rodape.setLayout(new java.awt.BorderLayout(12, 0));
        NomeUsuario.setFont(new java.awt.Font("SansSerif", 0, 14));
        NomeIgreja.setFont(new java.awt.Font("SansSerif", 0, 14));
        NomeIgreja.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rodape.add(NomeUsuario, java.awt.BorderLayout.WEST);
        rodape.add(NomeIgreja, java.awt.BorderLayout.CENTER);
        getContentPane().add(rodape, java.awt.BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        preencher();

    }//GEN-LAST:event_formWindowOpened

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

    private void AdicionarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionarMouseExited

    }//GEN-LAST:event_AdicionarMouseExited

    private void AdicionarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionarMouseEntered

    }//GEN-LAST:event_AdicionarMouseEntered

    private void CampoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoTotalActionPerformed

    private void CampoSaídasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoSaídasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoSaídasActionPerformed

    private void CampoEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoEntradasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoEntradasActionPerformed

    public void preencher(){
            String sql = "SELECT * FROM Configuracoes WHERE CodiIgreja = 1";
            Connection con = conectar.connectDatabase();
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

    private JMenu menuSecretaria;
    private JMenu menuFinanceiro;
    private JMenu menuConfiguracoes;
    private JMenu menuRelatorios;
    private final ClasseRotas rota = new ClasseRotas();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel painelInicio;
    private javax.swing.JPanel centroInicio;
    private javax.swing.JPanel rodape;
    private javax.swing.JButton Adicionar;
    private javax.swing.JTextField CampoEntradas;
    private javax.swing.JTextField CampoSaídas;
    private javax.swing.JTextField CampoTotal;
    private javax.swing.JLabel MembrosAtivos;
    private javax.swing.JLabel MembrosInativos;
    private javax.swing.JLabel NomeIgreja;
    private javax.swing.JLabel NomeUsuario;
    private javax.swing.JLabel TotalMembros;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public static javax.swing.JPanel painel;
    // End of variables declaration//GEN-END:variables
}
