
package Views;

import BancoDados.ConexaoBanco;
import Model.ClasseClasses;
import Model.ClasseTurma;
import Model.VariaveisUniversais;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CadastroTurma extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();
    public boolean check = false;
    public String tipo;
    int professores;
    int alunos;
    int validar;
    

   
    public CadastroTurma(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public void PovoarClasse(String sql){
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();

            CampoCodigoClasse.setText(rs.getString("IdClasse")); 
            CampoClasse.setText(rs.getString("Descricao"));

            rs.close();
            stmt.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public void Povoar(){
        
        String sql = "SELECT Turma.IDTurma,Classe.IDClasse,Membros.NomeCompleto,classe.Descricao,Turma.Tipo\n" +
                    "FROM Turma\n" +
                    "INNER JOIN Membros ON Membros.CodigoMembro = Turma.IDaluno\n" +
                    "INNER JOIN Classe ON Classe.IDClasse = Turma.IDClasse\n" +
                    "WHERE Turma.IDClasse = "+ClasseClasses.IDClasse;
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaTurma.getModel();
            Model.setNumRows(0);
            
            
            while(rs.next()){
                     
                
                Model.addRow(new Object[]{
                    check,
                    rs.getString("NomeCompleto"),
                    Alterar(rs.getInt("tipo")),
                    rs.getString("IDTurma"),
                });
            }
            
            rs.close();
            stmt.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }
    public String Alterar(int tipo){
        String retorno;
        if(tipo == 0){
            retorno = "Aluno";
        }
        else{
            retorno = "Professor";
        }
        return retorno;
    }
    
    public void Contar(){
        
        
        int contar = TabelaTurma.getRowCount();
        alunos = 0;
        professores = 0;
        
        for(int i = 0;i < contar;i++){
              
            
            String p = TabelaTurma.getValueAt(i,2).toString();
            
            if(p == "Aluno"){
                alunos = alunos + 1;
            }
            else{
                professores = professores + 1;
            }
            
        }
    }
    
    public void Verificar(){
        int i = 0;
        int contar = TabelaTurma.getRowCount();
        contar = contar;

        do{
            String Nome = TabelaTurma.getValueAt(i,1).toString();
            
            if(Nome.equals(CampoNomeAluno.getText())){
                validar = 0;
                
            }
            else{
               validar = 1;
            }
            
            i = i + 1;
            
        }while(validar == 1 && i < contar );
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProfessorAluno = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        CampoCodigoClasse = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CampoClasse = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaTurma = new javax.swing.JTable();
        CampoNomeAluno = new javax.swing.JTextField();
        PesquisarAluno = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        BotaoSalvar1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        Alunos = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        Professores = new javax.swing.JTextField();
        AdicionarAluno = new javax.swing.JButton();
        ExcluirAluno = new javax.swing.JButton();
        Aluno = new javax.swing.JRadioButton();
        Professor = new javax.swing.JRadioButton();
        CampoCodigoAluno = new javax.swing.JTextField();
        CampoIdTurma = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Detalhes da Classe");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(238, 238, 238));

        CampoCodigoClasse.setEditable(false);
        CampoCodigoClasse.setBackground(new java.awt.Color(238, 238, 238));
        CampoCodigoClasse.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        CampoCodigoClasse.setForeground(new java.awt.Color(238, 238, 238));
        CampoCodigoClasse.setBorder(null);
        CampoCodigoClasse.setEnabled(false);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome da Classe:");

        CampoClasse.setBackground(new java.awt.Color(255, 255, 255));
        CampoClasse.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoClasse.setForeground(new java.awt.Color(0, 0, 0));

        TabelaTurma.setBackground(new java.awt.Color(255, 255, 255));
        TabelaTurma.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaTurma.setForeground(new java.awt.Color(0, 0, 0));
        TabelaTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Matriculados", "TIpo", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaTurma.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaTurma.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaTurma.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TabelaTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaTurmaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaTurma);
        if (TabelaTurma.getColumnModel().getColumnCount() > 0) {
            TabelaTurma.getColumnModel().getColumn(0).setMinWidth(20);
            TabelaTurma.getColumnModel().getColumn(0).setPreferredWidth(20);
            TabelaTurma.getColumnModel().getColumn(0).setMaxWidth(20);
            TabelaTurma.getColumnModel().getColumn(1).setPreferredWidth(250);
            TabelaTurma.getColumnModel().getColumn(2).setPreferredWidth(50);
            TabelaTurma.getColumnModel().getColumn(3).setMinWidth(0);
            TabelaTurma.getColumnModel().getColumn(3).setPreferredWidth(0);
            TabelaTurma.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        CampoNomeAluno.setBackground(new java.awt.Color(255, 255, 255));
        CampoNomeAluno.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        CampoNomeAluno.setForeground(new java.awt.Color(0, 0, 0));
        CampoNomeAluno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CampoNomeAlunoKeyPressed(evt);
            }
        });

        PesquisarAluno.setBackground(new java.awt.Color(1, 1, 34));
        PesquisarAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        PesquisarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Search_15px.png"))); // NOI18N
        PesquisarAluno.setBorder(null);
        PesquisarAluno.setBorderPainted(false);
        PesquisarAluno.setFocusPainted(false);
        PesquisarAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PesquisarAlunoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PesquisarAlunoMouseExited(evt);
            }
        });
        PesquisarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarAlunoActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nome do Aluno ou Professor:");

        BotaoSalvar1.setBackground(new java.awt.Color(1, 1, 34));
        BotaoSalvar1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        BotaoSalvar1.setForeground(new java.awt.Color(255, 255, 255));
        BotaoSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Salvar.png"))); // NOI18N
        BotaoSalvar1.setText("Salvar");
        BotaoSalvar1.setBorder(null);
        BotaoSalvar1.setBorderPainted(false);
        BotaoSalvar1.setFocusPainted(false);
        BotaoSalvar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BotaoSalvar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BotaoSalvar1MouseExited(evt);
            }
        });
        BotaoSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoSalvar1ActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 34), 2, true));

        jPanel8.setBackground(new java.awt.Color(1, 1, 34));
        jPanel8.setMaximumSize(new java.awt.Dimension(73, 64));
        jPanel8.setMinimumSize(new java.awt.Dimension(73, 64));

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Alunos");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Alunos.setEditable(false);
        Alunos.setBackground(new java.awt.Color(255, 255, 255));
        Alunos.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Alunos.setForeground(new java.awt.Color(1, 1, 34));
        Alunos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Alunos.setText("0");
        Alunos.setBorder(null);
        Alunos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlunosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Alunos)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Alunos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 34), 2, true));

        jPanel12.setBackground(new java.awt.Color(1, 1, 34));

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Professores");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        Professores.setEditable(false);
        Professores.setBackground(new java.awt.Color(255, 255, 255));
        Professores.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Professores.setForeground(new java.awt.Color(1, 1, 34));
        Professores.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Professores.setText("0");
        Professores.setBorder(null);
        Professores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfessoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Professores)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Professores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        AdicionarAluno.setBackground(new java.awt.Color(1, 1, 34));
        AdicionarAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        AdicionarAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Plus_Math_15px.png"))); // NOI18N
        AdicionarAluno.setBorder(null);
        AdicionarAluno.setBorderPainted(false);
        AdicionarAluno.setFocusPainted(false);
        AdicionarAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AdicionarAlunoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AdicionarAlunoMouseExited(evt);
            }
        });
        AdicionarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdicionarAlunoActionPerformed(evt);
            }
        });

        ExcluirAluno.setBackground(new java.awt.Color(1, 1, 34));
        ExcluirAluno.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ExcluirAluno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Delete_15px.png"))); // NOI18N
        ExcluirAluno.setBorder(null);
        ExcluirAluno.setBorderPainted(false);
        ExcluirAluno.setFocusPainted(false);
        ExcluirAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExcluirAlunoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExcluirAlunoMouseExited(evt);
            }
        });
        ExcluirAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcluirAlunoActionPerformed(evt);
            }
        });

        Aluno.setBackground(new java.awt.Color(238, 238, 238));
        ProfessorAluno.add(Aluno);
        Aluno.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Aluno.setForeground(new java.awt.Color(0, 0, 0));
        Aluno.setSelected(true);
        Aluno.setText("Aluno");

        Professor.setBackground(new java.awt.Color(238, 238, 238));
        ProfessorAluno.add(Professor);
        Professor.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        Professor.setForeground(new java.awt.Color(0, 0, 0));
        Professor.setText("Professor");

        CampoCodigoAluno.setEditable(false);
        CampoCodigoAluno.setBackground(new java.awt.Color(238, 238, 238));
        CampoCodigoAluno.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        CampoCodigoAluno.setForeground(new java.awt.Color(238, 238, 238));
        CampoCodigoAluno.setBorder(null);
        CampoCodigoAluno.setEnabled(false);

        CampoIdTurma.setEditable(false);
        CampoIdTurma.setBackground(new java.awt.Color(238, 238, 238));
        CampoIdTurma.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        CampoIdTurma.setForeground(new java.awt.Color(238, 238, 238));
        CampoIdTurma.setBorder(null);
        CampoIdTurma.setEnabled(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel6))
                                        .addGap(0, 121, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(CampoNomeAluno)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(PesquisarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(CampoClasse))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(AdicionarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ExcluirAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Aluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(6, 6, 6))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(BotaoSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoCodigoClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CampoCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CampoIdTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Professor)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)
                        .addComponent(CampoClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PesquisarAluno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CampoNomeAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AdicionarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ExcluirAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Aluno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Professor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoCodigoClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoIdTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String sql = "SELECT * FROM Classe WHERE IdClasse = "+ClasseClasses.IDClasse;
        PovoarClasse(sql);
        Povoar();
        Contar();
        Alunos.setText(String.valueOf(alunos));
        Professores.setText(String.valueOf(professores));
        
    }//GEN-LAST:event_formWindowOpened

    private void PesquisarAlunoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PesquisarAlunoMouseEntered
        PesquisarAluno.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_PesquisarAlunoMouseEntered

    private void PesquisarAlunoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PesquisarAlunoMouseExited
        PesquisarAluno.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_PesquisarAlunoMouseExited

    private void PesquisarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarAlunoActionPerformed
        VariaveisUniversais search = new VariaveisUniversais();
        search.setEntrada(3);
        PesquisaMembros chamar = new PesquisaMembros(null, true);
        chamar.setVisible(true);

    }//GEN-LAST:event_PesquisarAlunoActionPerformed

    private void BotaoSalvar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvar1MouseEntered
        BotaoSalvar1.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoSalvar1MouseEntered

    private void BotaoSalvar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvar1MouseExited
        BotaoSalvar1.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoSalvar1MouseExited

    private void BotaoSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvar1ActionPerformed

        this.dispose();

    }//GEN-LAST:event_BotaoSalvar1ActionPerformed

    private void AlunosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlunosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlunosActionPerformed

    private void ProfessoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfessoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProfessoresActionPerformed

    private void AdicionarAlunoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionarAlunoMouseEntered
        AdicionarAluno.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_AdicionarAlunoMouseEntered

    private void AdicionarAlunoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AdicionarAlunoMouseExited
        AdicionarAluno.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_AdicionarAlunoMouseExited

    private void AdicionarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdicionarAlunoActionPerformed
       int v = TabelaTurma.getRowCount();
       
       if(CampoCodigoAluno.getText().equals("")){
           JOptionPane.showMessageDialog(null, "Por Favor selecione um aluno !");
       }
       else{
           if(v == 0){
            ClasseTurma add = new ClasseTurma();
            ClasseTurma.IDClasse = Integer.parseInt(CampoCodigoClasse.getText());
            ClasseTurma.IDAluno = Integer.parseInt(CampoCodigoAluno.getText());
            
            if(Aluno.isSelected() == true){
                ClasseTurma.Tipo = 0;
            }
            else{
                ClasseTurma.Tipo = 1;
            }
            add.Add();
            Povoar();
            CampoNomeAluno.setText("");
            CampoCodigoAluno.setText("");
            Contar();
            Alunos.setText(String.valueOf(alunos));
            Professores.setText(String.valueOf(professores));
            }
            else{
               Verificar();

                if(validar == 1){
                     ClasseTurma add = new ClasseTurma();
                     ClasseTurma.IDClasse = Integer.parseInt(CampoCodigoClasse.getText());
                     ClasseTurma.IDAluno = Integer.parseInt(CampoCodigoAluno.getText());
                     if(Aluno.isSelected() == true){
                         ClasseTurma.Tipo = 0;
                     }
                     else{
                         ClasseTurma.Tipo = 1;
                     }
                     add.Add();
                     Povoar();
                     CampoNomeAluno.setText("");
                     CampoCodigoAluno.setText("");
                     Contar();
                     Alunos.setText(String.valueOf(alunos));
                     Professores.setText(String.valueOf(professores));
                }
                else{
                    JOptionPane.showMessageDialog(null, "Este Aluno jé está matriculado nesta classe");
                } 
            }
       }
       
       
 
    }//GEN-LAST:event_AdicionarAlunoActionPerformed

    private void ExcluirAlunoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcluirAlunoMouseEntered
       ExcluirAluno.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_ExcluirAlunoMouseEntered

    private void ExcluirAlunoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExcluirAlunoMouseExited
        ExcluirAluno.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_ExcluirAlunoMouseExited

    private void ExcluirAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcluirAlunoActionPerformed
        if(CampoIdTurma.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Selecione um aluno");
        }
        else{
            ClasseTurma.IDTurma = Integer.parseInt(CampoIdTurma.getText());
            ClasseTurma add = new ClasseTurma();
            add.Delete();
            Povoar();
            Contar();
            Alunos.setText(String.valueOf(alunos));
            Professores.setText(String.valueOf(professores));
            
        }
    }//GEN-LAST:event_ExcluirAlunoActionPerformed

    private void TabelaTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaTurmaMouseClicked
       int linha = TabelaTurma.getSelectedRow();
       CampoIdTurma.setText(TabelaTurma.getValueAt(linha, 3).toString());
        
       
    }//GEN-LAST:event_TabelaTurmaMouseClicked

    private void CampoNomeAlunoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CampoNomeAlunoKeyPressed
       VariaveisUniversais search = new VariaveisUniversais();
        search.setEntrada(3);
        PesquisaMembros chamar = new PesquisaMembros(null, true);
        chamar.setVisible(true);
    }//GEN-LAST:event_CampoNomeAlunoKeyPressed

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
            java.util.logging.Logger.getLogger(CadastroTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroTurma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadastroTurma dialog = new CadastroTurma(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton AdicionarAluno;
    private javax.swing.JRadioButton Aluno;
    private javax.swing.JTextField Alunos;
    private javax.swing.JButton BotaoSalvar1;
    public static javax.swing.JTextField CampoClasse;
    public static javax.swing.JTextField CampoCodigoAluno;
    public static javax.swing.JTextField CampoCodigoClasse;
    public static javax.swing.JTextField CampoIdTurma;
    public static javax.swing.JTextField CampoNomeAluno;
    private javax.swing.JButton ExcluirAluno;
    private javax.swing.JButton PesquisarAluno;
    private javax.swing.JRadioButton Professor;
    private javax.swing.ButtonGroup ProfessorAluno;
    private javax.swing.JTextField Professores;
    private javax.swing.JTable TabelaTurma;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
