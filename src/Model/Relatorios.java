
package Model;

import BancoDados.ConexaoBanco;
import java.awt.Dialog;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class Relatorios {
    
    ConexaoBanco conectar = new ConexaoBanco();
    String Titulo = "Relatórios AdonaiSoft - Igreja";
    
    
    
    

    public void CarteiraMembro() throws JRException, IOException{
        
        String sql ="SELECT membros.nomecompleto,\n" +
                    "	membros.databatismo,\n" +
                    "	cargo.descricao,\n" +
                    "	membros.Imagem,\n" +
                    "	pastorpresidente\n" +
                    "FROM membros\n" +
                    "	INNER JOIN cargo ON \n" +
                    "	 cargo.idcargo = membros.idcargo \n" +
                    "	INNER JOIN configuracoes ON \n" +
                    "	 configuracoes.pastorpresidente = configuracoes.pastorpresidente \n" +
                    "WHERE \n" +
                    "	 membros.codigomembro ="+ClasseMembros.CodigoMembros;
        
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("C:/Program Files/AdonaiSoft Igreja/Relatorios/CarteiraMembro.jasper", new HashMap(), jrrs);
                                                 
            JasperViewer jv = new JasperViewer(print,false);
            jv.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
            jv.setTitle(Titulo);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
            
            

            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao gerar o relatório por favor verifique -> " + e);
            System.out.println("Erro aqui"+e);
        }
        
    }
    public void MultiplosCarteirinha() throws JRException, IOException{
        String sql = "SELECT\n" +
                    "	membros.nomecompleto,\n" +
                    "	membros.databatismo,\n" +
                    "	cargo.descricao,\n" +
                    "	membros.Imagem,\n" +
                    "	configuracoes.pastorpresidente\n" +
                    "FROM membros\n" +
                    "	INNER JOIN cargo ON \n" +
                    "	 cargo.idcargo = membros.idcargo \n" +
                    "	INNER JOIN configuracoes ON \n" +
                    "	 configuracoes.pastorpresidente = configuracoes.pastorpresidente \n" +
                    "WHERE \n" +
                    "	 membros.batizado = true";
        
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("C:/Program Files/AdonaiSoft Igreja/Relatorios/Carteira.jasper", new HashMap(), jrrs);
                                                 
            JasperViewer jv = new JasperViewer(print,false);
            jv.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
            jv.setTitle(Titulo);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
            
            

            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao gerar o relatório por favor verifique -> " + e);
            System.out.println("Erro aqui"+e);
        }
        
    }
    
    public void Dizimistas() throws JRException, IOException{
        String sql = "SELECT \n" +
                    "   Duplicatas.DataC,\n" +
                    "	Duplicatas.valor,\n" +
                    "	Membros.Nomecompleto,\n" +
                    "	configuracoes.tesoureiroigreja,\n" +
                    "	configuracoes.pastorigreja,\n" +
                    "	globais.Imagem,\n" +
                    "	globais.testorelatorio\n" +
                    "	\n" +
                    "FROM Duplicatas\n" +
                    "	INNER JOIN configuracoes ON \n" +
                    "	 configuracoes.tesoureiroigreja = configuracoes.tesoureiroigreja \n" +
                    "	INNER JOIN configuracoes AS Config ON \n" +
                    "	Config.pastorigreja= configuracoes.pastorigreja \n" +
                    "	INNER JOIN caixas ON \n" +
                    "	 caixas.codigocaixa = Duplicatas.idcaixa \n" +
                    "	INNER JOIN tipo ON \n" +
                    "	 tipo.idtipo = Duplicatas.idtipo \n" +
                    "	INNER JOIN globais ON \n" +
                    "	 globais.Imagem = globais.Imagem\n" +
                    "	INNER JOIN globais AS Globa ON \n" +
                    "	 Globa.testorelatorio = globais.testorelatorio \n" +
                    "	INNER JOIN Membros ON \n" +
                    "	 Membros.CodigoMembro = Duplicatas.IdMembro\n" +
                    "WHERE \n" +
                    "	 caixas.codigocaixa = "+ClasseCaixas.CodigoCaixa+" \n" +
                    "	 AND Duplicatas.idtipo ="+ClasseTipo.IDTipo+" AND Duplicatas.Tipo = 0 \n" +
                    "ORDER BY tipo.idtipo DESC";
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("C:/Program Files/AdonaiSoft Igreja/Relatorios/dizimo.jasper", new HashMap(), jrrs);
                                                 
            JasperViewer jv = new JasperViewer(print,false);
            jv.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
            jv.setTitle(Titulo);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
            
            

            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao gerar o relatório por favor verifique -> " + e);
            System.out.println("Erro aqui"+e);
        }
        
    }
        
    public void Certificado() throws JRException, IOException{
         String sql = "SELECT\n" +
                    "\n" +
                    "     membros.nomecompleto,\n" +
                    "     configuracoes.pastorpresidente,\n" +
                    "     configuracoes.pastorigreja\n" +
                    "FROM\n" +
                    "    membros,\n" +
                    "    configuracoes\n" +
                    "\n" +
                    "where codigomembro ="+ClasseMembros.CodigoMembros;
        
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("C:/Program Files/AdonaiSoft Igreja/Relatorios/Certificado2.jasper", new HashMap(), jrrs);
                                                 
            JasperViewer jv = new JasperViewer(print,false);
            jv.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
            jv.setTitle(Titulo);
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
            
            
            

            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao gerar o relatório por favor verifique -> " + e);
            System.out.println("Erro aqui"+e);
        }
        
    }
    
    public void Caixas() throws JRException, IOException{
        
         String sql = "SELECT  Duplicatas.descricao, \n" +
                        "valor, \n" +
                        "Tipo.Pconta,\n" +
                        "configuracoes.tesoureiroigreja,\n" +
                        "configuracoes.pastorigreja,\n" +
                        "globais.Imagem,\n" +
                        "globais.testorelatorio,\n" +
                        "caixas.descricaocaixa,\n" +
                        "Caixas.DataAbertura,\n" +
                        "Caixas.DataFechamento,\n" +
                        "Caixas.Saldo,\n" +
                        "caixas.Entradas,\n" +
                        "Caixas.Saidas,\n" +
                        "Caixas.SaldoInicial\n" +
                        "FROM duplicatas\n" +
                        "INNER JOIN configuracoes ON \n" +
                        "	 configuracoes.tesoureiroigreja = configuracoes.tesoureiroigreja \n" +
                        "INNER JOIN configuracoes AS Config ON \n" +
                        "	Config.pastorigreja= configuracoes.pastorigreja \n" +
                        "INNER JOIN caixas ON \n" +
                        "	 caixas.codigocaixa = Duplicatas.idcaixa \n" +
                        "INNER JOIN tipo ON \n" +
                        "	 tipo.idtipo = Duplicatas.idtipo \n" +
                        "INNER JOIN globais ON \n" +
                        "	 globais.Imagem = globais.Imagem\n" +
                        "INNER JOIN globais AS Globa ON \n" +
                        "	 Globa.testorelatorio = globais.testorelatorio\n" +
                        "	 \n" +
                        " WHERE \n" +
                        "	 caixas.codigocaixa ="+ClasseCaixas.CodigoCaixa+"  AND Duplicatas.Status = 'Paga'\n" +
                        "	 \n" +
                        "ORDER BY DataC Desc";
        
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("C:/Program Files/AdonaiSoft Igreja/Relatorios/Caixas.jasper", new HashMap(), jrrs);
                                                 
            JasperViewer jv = new JasperViewer(print,false);
            
            jv.setExtendedState(MAXIMIZED_BOTH);
            jv.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
            jv.setTitle(Titulo);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);

            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao gerar o relatório por favor verifique -> " + e);
            System.out.println("Erro aqui"+e);
        }
        
    }
    
    public void Entradas() throws JRException, IOException{
        
        String sql = "SELECT tipo.descricao,\n" +
                    "	Duplicatas.valor,\n" +
                    "	Membros.Nomecompleto,\n" +
                    "	configuracoes.tesoureiroigreja,\n" +
                    "	Configuracoes.pastorigreja,\n" +
                    "	globais.Imagem,\n" +
                    "	globais.testorelatorio,\n" +
                    "	caixas.descricaocaixa\n" +
                    "	\n" +
                    "FROM Duplicatas\n" +
                    "	INNER JOIN configuracoes ON \n" +
                    "	 configuracoes.tesoureiroigreja = configuracoes.tesoureiroigreja \n" +
                    "	INNER JOIN configuracoes AS Config ON \n" +
                    "	 Config.pastorigreja = Configuracoes.pastorigreja \n" +
                    "	INNER JOIN caixas ON \n" +
                    "	 caixas.codigocaixa = Duplicatas.idcaixa \n" +
                    "	INNER JOIN tipo ON \n" +
                    "	 tipo.idtipo = Duplicatas.idtipo \n" +
                    "	INNER JOIN globais ON \n" +
                    "	 globais.Imagem = globais.Imagem \n" +
                    "	INNER JOIN globais AS Globa  ON \n" +
                    "	 Globa.testorelatorio = globais.testorelatorio\n" +
                    "	INNER JOIN Membros ON Membros.CodigoMembro = IDMembro \n" +
                    "WHERE \n" +
                    "	 caixas.codigocaixa = "+ClasseCaixas.CodigoCaixa+" AND Duplicatas.Tipo = 0\n" +
                    "ORDER BY tipo.idtipo DESC";
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("C:/Program Files/AdonaiSoft Igreja/Relatorios/Entradas.jasper", new HashMap(), jrrs);
                                                 
            JasperViewer jv = new JasperViewer(print,false);
            jv.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
            jv.setTitle(Titulo);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
            
            

            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao gerar o relatório por favor verifique -> " + e);
            System.out.println("Erro aqui"+e);
        }
        
    }
    
    public void Despesas() throws JRException, IOException{
        
        String sql = "SELECT tipo.descricao AS Tp,\n" +
                    "	duplicatas.valor,\n" +
                    "	duplicatas.descricao,\n" +
                    "	configuracoes.tesoureiroigreja,\n" +
                    "	Configuracoes.pastorigreja,\n" +
                    "	globais.imagem,\n" +
                    "	globais.testorelatorio,\n" +
                    "	caixas.descricaocaixa\n" +
                    "	\n" +
                    "FROM duplicatas\n" +
                    "	INNER JOIN configuracoes ON \n" +
                    "	 configuracoes.tesoureiroigreja = configuracoes.tesoureiroigreja \n" +
                    "	INNER JOIN configuracoes AS Config ON \n" +
                    "	 Config.pastorigreja = Configuracoes.pastorigreja \n" +
                    "	INNER JOIN caixas ON \n" +
                    "	 caixas.codigocaixa = duplicatas.idcaixa \n" +
                    "	INNER JOIN tipo ON \n" +
                    "	 tipo.idtipo = duplicatas.idtipo \n" +
                    "	INNER JOIN globais ON \n" +
                    "	 globais.Imagem = globais.Imagem \n" +
                    "	INNER JOIN globais AS Globa  ON \n" +
                    "	 Globa.testorelatorio = globais.testorelatorio \n" +
                    "WHERE \n" +
                    "	 caixas.codigocaixa = "+ClasseCaixas.CodigoCaixa+" AND duplicatas.Tipo = 1 AND duplicatas.Status = 'Paga'\n" +
                    "ORDER BY tipo.idtipo DESC";
        
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("C:/Program Files/AdonaiSoft Igreja/Relatorios/Despesas.jasper", new HashMap(), jrrs);
                                                 
            JasperViewer jv = new JasperViewer(print,false);
            jv.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Logo.png")));
            jv.setTitle(Titulo);
            jv.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            jv.setVisible(true);
            
            

            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao gerar o relatório por favor verifique -> " + e);
            System.out.println("Erro aqui"+e);
        }
        
    }
    
    public void CartaApresentacao(String sql) throws JRException, IOException{
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("C:/Program Files/AdonaiSoft Igreja/Relatorios/CartaApresentacao.jasper", new HashMap(), jrrs);
                                                 
            JasperViewer jv = new JasperViewer(print,false);
            jv.setVisible(true);
            
            

            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao gerar o relatório por favor verifique -> " + e);
            System.out.println("Erro aqui"+e);
        }
        
    }
    
    public void CartaMudanca(String sql) throws JRException, IOException{
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            JRResultSetDataSource jrrs = new JRResultSetDataSource(rs);
            JasperPrint print = JasperFillManager.fillReport("C:/Program Files/AdonaiSoft Igreja/Relatorios/CartaMudanca.jasper", new HashMap(), jrrs);
                                                 
            JasperViewer jv = new JasperViewer(print,false);
            jv.setVisible(true);
            
            

            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Falha ao gerar o relatório por favor verifique -> " + e);
            System.out.println("Erro aqui"+e);
        }
        
    }
    
}



        