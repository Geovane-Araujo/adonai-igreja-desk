
package Views;

import BancoDados.ConexaoBanco;
import Converter.DataHora;
import Model.ClasseChamada;
import Model.ClasseClasses;
import Model.ClasseRegistroChamada;
import Model.ClasseRotas;
import Model.VariaveisUniversais;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Chamada extends javax.swing.JDialog {
    ConexaoBanco conectar = new ConexaoBanco();
    DataHora dt = new DataHora();
    ClasseRegistroChamada add = new ClasseRegistroChamada();
    ClasseRotas rota = new ClasseRotas();
    String FormatoMoeda = "0.00";
    DecimalFormat df = new DecimalFormat(FormatoMoeda);
    VariaveisUniversais var = new VariaveisUniversais();
    public boolean check = false;
    public String tipo;
    int matriculados;
    int presentes;
    int ausentes;
    

   
    public Chamada(java.awt.Frame parent, boolean modal) {
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
        
        String sql = "SELECT Turma.IDTurma,Classe.IDClasse,Membros.NomeCompleto,Membros.Codigomembro,classe.Descricao,Turma.Tipo,turma.idAluno\n" +
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
            
            DefaultTableModel Model = (DefaultTableModel) TabelaChamada.getModel();
            Model.setNumRows(0);
            
            
            while(rs.next()){
                     
                
                Model.addRow(new Object[]{
                    rs.getString("NomeCompleto"),
                    check,
                    rs.getString("IDTurma"),
                    rs.getString("idaluno"),  
                });
            }
            
            rs.close();
            stmt.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public void ContarLinha(){
        
        int contar = TabelaChamada.getRowCount();
        presentes = 0;
        ausentes = 0;
        
        for(int i = 0;i < contar;i++){
              
            
            boolean p = Boolean.parseBoolean(TabelaChamada.getValueAt(i,1).toString());
            
            if(p == true){
                presentes = presentes + 1;
            }
            else{
                ausentes = ausentes + 1;
            }
            
        }  
    }
    
    public void calcular(){
        
        float resultado = (presentes*100)/matriculados;
        CampoTotal.setText(String.valueOf(resultado)+"%");
    }
    
    public void SalvarHistorico(){
        
        int contar = TabelaChamada.getRowCount();
        presentes = 0;
        ausentes = 0;
        
        for(int i = 0;i < contar;i++){
              
            int idMatriculado = Integer.parseInt(TabelaChamada.getValueAt(i,3).toString());
            boolean presente = Boolean.parseBoolean(TabelaChamada.getValueAt(i,1).toString());
            
            ClasseRegistroChamada.IDChamada = ClasseChamada.ID;
            ClasseRegistroChamada.IDMatriculado = idMatriculado;
            ClasseRegistroChamada.Presente = presente;
            
            add.Add();
        }
        JOptionPane.showMessageDialog(null,"Registrada com sucesso");
    }
    
    public void VerChamadaalunos(){

        String sql = "SELECT id, idchamada, idmatriculado, presente, Membros.nomecompleto\n" +
                    "FROM public.registrochamada\n" +
                    "INNER JOIN Membros ON Membros.CodigoMembro = IdMatriculado\n" +
                    "WHERE IDChamada ="+ClasseChamada.ID;
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            DefaultTableModel Model = (DefaultTableModel) TabelaChamada.getModel();
            Model.setNumRows(0);
            
            
            while(rs.next()){
                     
                
                Model.addRow(new Object[]{
                    rs.getString("NomeCompleto"),
                    rs.getBoolean("presente"),
                    rs.getString("ID"),
                    rs.getString("idmatriculado"),  
                });
            }
            CampoMatriculados.setText(String.valueOf(TabelaChamada.getRowCount()));
            rs.close();
            stmt.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public void verchamadaclasse(){
        String sql = "SELECT id,Classe.descricao,ausentes,presentes,datachamada,visitas,total,ofertas,chamada.idclasse    \n" +
                    "FROM public.chamada\n" +
                    "INNER JOIN Classe ON Classe.IDClasse = Chamada.IDClasse\n" +
                    "WHERE Chamada.ID ="+ClasseChamada.ID;
        
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            
            rs = stmt.executeQuery();
            
            rs.next();
            CampoClasse.setText(rs.getString("Descricao"));
            CampoAusentes.setText(rs.getString("Ausentes"));
            CampoPresentes.setText(rs.getString("presentes"));
            CampoData.setDate(rs.getDate("DataChamada"));
            campoVisitas.setText(rs.getString("visitas"));
            CampoTotal.setText(rs.getString("Total")+"%");
            double oferta = Double.parseDouble(rs.getString("Ofertas"));
            
            CampoOfertas.setText(String.valueOf(df.format(oferta)));

            rs.close();
            stmt.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProfessorAluno = new javax.swing.ButtonGroup();
        jPanel5 = new javax.swing.JPanel();
        CampoCodigoClasse = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaChamada = new javax.swing.JTable();
        BotaoSalvar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        CampoMatriculados = new javax.swing.JTextField();
        CampoCodigoAluno = new javax.swing.JTextField();
        CampoIdTurma = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        CampoPresentes = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        CampoAusentes = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        campoVisitas = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        CampoOfertas = new javax.swing.JTextField();
        Calcular = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        CampoTotal = new javax.swing.JTextField();
        CampoClasse = new javax.swing.JTextField();
        CampoData = new com.toedter.calendar.JDateChooser();

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

        TabelaChamada.setBackground(new java.awt.Color(255, 255, 255));
        TabelaChamada.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        TabelaChamada.setForeground(new java.awt.Color(0, 0, 0));
        TabelaChamada.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matriculados", "Presentes", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaChamada.setGridColor(new java.awt.Color(255, 255, 255));
        TabelaChamada.setSelectionBackground(new java.awt.Color(219, 230, 244));
        TabelaChamada.setSelectionForeground(new java.awt.Color(0, 0, 0));
        TabelaChamada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaChamadaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaChamada);
        if (TabelaChamada.getColumnModel().getColumnCount() > 0) {
            TabelaChamada.getColumnModel().getColumn(0).setPreferredWidth(250);
            TabelaChamada.getColumnModel().getColumn(1).setMinWidth(100);
            TabelaChamada.getColumnModel().getColumn(1).setPreferredWidth(100);
            TabelaChamada.getColumnModel().getColumn(1).setMaxWidth(100);
            TabelaChamada.getColumnModel().getColumn(2).setMinWidth(0);
            TabelaChamada.getColumnModel().getColumn(2).setPreferredWidth(0);
            TabelaChamada.getColumnModel().getColumn(2).setMaxWidth(0);
            TabelaChamada.getColumnModel().getColumn(3).setMinWidth(0);
            TabelaChamada.getColumnModel().getColumn(3).setPreferredWidth(0);
            TabelaChamada.getColumnModel().getColumn(3).setMaxWidth(0);
        }

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

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 34), 2, true));

        jPanel8.setBackground(new java.awt.Color(1, 1, 34));
        jPanel8.setMaximumSize(new java.awt.Dimension(73, 64));
        jPanel8.setMinimumSize(new java.awt.Dimension(73, 64));

        jLabel19.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Matriculados");

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

        CampoMatriculados.setEditable(false);
        CampoMatriculados.setBackground(new java.awt.Color(255, 255, 255));
        CampoMatriculados.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        CampoMatriculados.setForeground(new java.awt.Color(1, 1, 34));
        CampoMatriculados.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoMatriculados.setText("0");
        CampoMatriculados.setBorder(null);
        CampoMatriculados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoMatriculadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CampoMatriculados)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoMatriculados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

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

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 34), 2, true));

        jPanel10.setBackground(new java.awt.Color(1, 5, 69));
        jPanel10.setMaximumSize(new java.awt.Dimension(73, 64));
        jPanel10.setMinimumSize(new java.awt.Dimension(73, 64));

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Presentes");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CampoPresentes.setEditable(false);
        CampoPresentes.setBackground(new java.awt.Color(255, 255, 255));
        CampoPresentes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        CampoPresentes.setForeground(new java.awt.Color(1, 1, 34));
        CampoPresentes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoPresentes.setText("0");
        CampoPresentes.setBorder(null);
        CampoPresentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoPresentesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CampoPresentes)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoPresentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 34), 2, true));

        jPanel12.setBackground(new java.awt.Color(128, 3, 48));
        jPanel12.setMaximumSize(new java.awt.Dimension(73, 64));
        jPanel12.setMinimumSize(new java.awt.Dimension(73, 64));

        jLabel21.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Ausentes");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jLabel21)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CampoAusentes.setEditable(false);
        CampoAusentes.setBackground(new java.awt.Color(255, 255, 255));
        CampoAusentes.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        CampoAusentes.setForeground(new java.awt.Color(1, 1, 34));
        CampoAusentes.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoAusentes.setText("0");
        CampoAusentes.setBorder(null);
        CampoAusentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoAusentesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CampoAusentes)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoAusentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 34), 2, true));

        jPanel14.setBackground(new java.awt.Color(1, 74, 36));
        jPanel14.setMaximumSize(new java.awt.Dimension(73, 64));
        jPanel14.setMinimumSize(new java.awt.Dimension(73, 64));

        jLabel22.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Visitas");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        campoVisitas.setBackground(new java.awt.Color(255, 255, 255));
        campoVisitas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        campoVisitas.setForeground(new java.awt.Color(1, 1, 34));
        campoVisitas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        campoVisitas.setText("0");
        campoVisitas.setBorder(null);
        campoVisitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoVisitasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(campoVisitas)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoVisitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 34), 2, true));

        jPanel16.setBackground(new java.awt.Color(38, 1, 89));
        jPanel16.setMaximumSize(new java.awt.Dimension(73, 64));
        jPanel16.setMinimumSize(new java.awt.Dimension(73, 64));

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Ofertas");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CampoOfertas.setBackground(new java.awt.Color(255, 255, 255));
        CampoOfertas.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        CampoOfertas.setForeground(new java.awt.Color(1, 1, 34));
        CampoOfertas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoOfertas.setText("0,00");
        CampoOfertas.setBorder(null);
        CampoOfertas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoOfertasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CampoOfertas)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoOfertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        Calcular.setBackground(new java.awt.Color(1, 1, 34));
        Calcular.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        Calcular.setForeground(new java.awt.Color(255, 255, 255));
        Calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/icons8_Math_26px.png"))); // NOI18N
        Calcular.setText("Calcular");
        Calcular.setBorder(null);
        Calcular.setBorderPainted(false);
        Calcular.setFocusPainted(false);
        Calcular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CalcularMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CalcularMouseExited(evt);
            }
        });
        Calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalcularActionPerformed(evt);
            }
        });

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(1, 1, 34), 2, true));

        jPanel18.setBackground(new java.awt.Color(1, 89, 85));
        jPanel18.setMaximumSize(new java.awt.Dimension(73, 64));
        jPanel18.setMinimumSize(new java.awt.Dimension(73, 64));

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Total");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jLabel24)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        CampoTotal.setBackground(new java.awt.Color(255, 255, 255));
        CampoTotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        CampoTotal.setForeground(new java.awt.Color(1, 1, 34));
        CampoTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CampoTotal.setText("0");
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
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CampoTotal)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CampoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        CampoClasse.setEditable(false);
        CampoClasse.setBackground(new java.awt.Color(238, 238, 238));
        CampoClasse.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        CampoClasse.setForeground(new java.awt.Color(0, 0, 0));
        CampoClasse.setBorder(null);

        CampoData.setBackground(new java.awt.Color(255, 255, 255));
        CampoData.setForeground(new java.awt.Color(0, 0, 0));
        CampoData.setDateFormatString("dd/MM/yyyy");
        CampoData.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCodigoClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CampoCodigoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CampoIdTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(CampoClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CampoData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(CampoClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CampoData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Calcular, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoCodigoClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        
        if(VariaveisUniversais.getUsadochamada() == 1){
            verchamadaclasse();
            VerChamadaalunos();
            Calcular.setEnabled(false);
            BotaoSalvar.setEnabled(false);
            VariaveisUniversais.setUsadochamada(0);
            
        }
        else{
            BotaoSalvar.setEnabled(false);
            String sql = "SELECT * FROM Classe WHERE IdClasse = "+ClasseClasses.IDClasse;
            PovoarClasse(sql);
            Povoar();
            ContarLinha();
            CampoMatriculados.setText(String.valueOf(matriculados = TabelaChamada.getRowCount()));
            CampoPresentes.setText(String.valueOf(presentes));
            CampoAusentes.setText(String.valueOf(ausentes));
            Date dt = new Date();
            CampoData.setDate(dt);
        }
   
    }//GEN-LAST:event_formWindowOpened

    private void BotaoSalvarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseEntered
        BotaoSalvar.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_BotaoSalvarMouseEntered

    private void BotaoSalvarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoSalvarMouseExited
        BotaoSalvar.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_BotaoSalvarMouseExited

    private void BotaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoSalvarActionPerformed
        ClasseChamada add = new ClasseChamada();
        add.pegarid();
        ClasseChamada.IDClasse = Integer.parseInt(CampoCodigoClasse.getText());
        ClasseChamada.data = dt.DataBd(CampoData.getDate());
        ClasseChamada.Presentes = Integer.parseInt(CampoPresentes.getText());
        ClasseChamada.Ausentes = Integer.parseInt(CampoAusentes.getText());
        ClasseChamada.Visitas = Integer.parseInt(campoVisitas.getText());
        ClasseChamada.Ofertas = Double.parseDouble(CampoOfertas.getText().replace(",","."));
        ClasseChamada.Total = Double.parseDouble(CampoTotal.getText().replace("%","0"));
        add.Add();
        SalvarHistorico();
        
        
        this.dispose();

    }//GEN-LAST:event_BotaoSalvarActionPerformed

    private void CampoMatriculadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoMatriculadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoMatriculadosActionPerformed

    private void TabelaChamadaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaChamadaMouseClicked
       
       
       ContarLinha();
       
       CampoPresentes.setText(String.valueOf(presentes));
       CampoAusentes.setText(String.valueOf(ausentes));
       
    }//GEN-LAST:event_TabelaChamadaMouseClicked

    private void CampoPresentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoPresentesActionPerformed
        
    }//GEN-LAST:event_CampoPresentesActionPerformed

    private void CampoAusentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoAusentesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoAusentesActionPerformed

    private void campoVisitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoVisitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoVisitasActionPerformed

    private void CampoOfertasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoOfertasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoOfertasActionPerformed

    private void CalcularMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcularMouseEntered
        Calcular.setBackground(new Color (219,230,244));
    }//GEN-LAST:event_CalcularMouseEntered

    private void CalcularMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CalcularMouseExited
       Calcular.setBackground(new Color(1,1,34));
    }//GEN-LAST:event_CalcularMouseExited

    private void CalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalcularActionPerformed
        calcular();
        BotaoSalvar.setEnabled(true);
        
    }//GEN-LAST:event_CalcularActionPerformed

    private void CampoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoTotalActionPerformed
        
    }//GEN-LAST:event_CampoTotalActionPerformed

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
            java.util.logging.Logger.getLogger(Chamada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chamada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chamada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chamada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                Chamada dialog = new Chamada(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton Calcular;
    private javax.swing.JTextField CampoAusentes;
    public static javax.swing.JTextField CampoClasse;
    public static javax.swing.JTextField CampoCodigoAluno;
    public static javax.swing.JTextField CampoCodigoClasse;
    private com.toedter.calendar.JDateChooser CampoData;
    public static javax.swing.JTextField CampoIdTurma;
    private javax.swing.JTextField CampoMatriculados;
    private javax.swing.JTextField CampoOfertas;
    private javax.swing.JTextField CampoPresentes;
    private javax.swing.JTextField CampoTotal;
    private javax.swing.ButtonGroup ProfessorAluno;
    private javax.swing.JTable TabelaChamada;
    private javax.swing.JTextField campoVisitas;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
