
package model;

import database.ConexaoBanco;
import view.Principal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClasseConfiguracoes {

    public static int CodigoIgreja;  //ok
    
    public static String NomeIgreja; // ok
    
    public static String CNPJIgreja;
    
    public static String EnderecoIgreja; //ok
    
    public static String BairroIgreja;  // ok
    
    public static String CidadeIgreja; // ok
    
    public static int Numero;
    
    public static String EstadoIgreja;  //ok
    
    public static String TelefoneIgreja; // ok
    
    public static String PastorIgreja;
    
    public static String PastorPresidente;
    
    public static String IgrejaSede;
    
    public static String SecretarioIgreja;
    
    public static String TesoureiroIgreja;
    
    public static boolean PedirSenha;
    
    public static String Tema;
    
    public static int TamanhoFonte;
    
    public static int total;
    
    ConexaoBanco conectar = new ConexaoBanco();
    
   
    
    public void InserirIgreja(){
        
        String sql = "INSERT INTO Configuracoes(NomeIgreja,CNPJIgreja,EnderecoIgreja,BairroIgreja"
                + ",CidadeIgreja,Numero,EstadoIgreja,TelefoneIgreja,PastorIgreja,PastorPresidente"
                + ",IgrejaSede,SecretarioIgreja,TesoureiroIgreja,PedirSenha) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, NomeIgreja);
            stmt.setString(2, CNPJIgreja);
            stmt.setString(3, EnderecoIgreja);
            stmt.setString(4, BairroIgreja);
            stmt.setString(5, CidadeIgreja);
            stmt.setInt(6, Numero);
            stmt.setString(7, EstadoIgreja);
            stmt.setString(8, TelefoneIgreja);
            stmt.setString(9, PastorIgreja);
            stmt.setString(10, PastorPresidente);
            stmt.setString(11, IgrejaSede);
            stmt.setString(12, SecretarioIgreja);
            stmt.setString(13, TesoureiroIgreja);
            stmt.setBoolean(14, PedirSenha);
            
            
            stmt.execute();
            
            Principal chamar = new Principal();
            chamar.setVisible(true);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void AlterarConfiguraçoes(){// alterar aqui depois
        
        String sql = "UPDATE Configuracoes SET NomeIgreja = ?, CNPJIgreja = ?, EnderecoIgreja = ?, BairroIgreja = ?,"
                + "CidadeIgreja = ?, EstadoIgreja = ?, TelefoneIgreja =?, PastorIgreja = ?, SecretarioIgreja =?,"
                + "TesoureiroIgreja = ?,  PedirSenha = ?, PastorPresidente = ?, IgrejaSede = ?, Numero = ? WHERE CodiIgreja= ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            
            
            stmt.setString(1, NomeIgreja);
            stmt.setString(2, CNPJIgreja);
            stmt.setString(3, EnderecoIgreja);
            stmt.setString(4, BairroIgreja);
            stmt.setString(5, CidadeIgreja);
            stmt.setString(6, EstadoIgreja);
            stmt.setString(7, TelefoneIgreja);
            stmt.setString(8, PastorIgreja);
            stmt.setString(9, SecretarioIgreja);
            stmt.setString(10,TesoureiroIgreja);
            stmt.setBoolean(11, PedirSenha);
            stmt.setString(12, PastorPresidente);
            stmt.setString(13, IgrejaSede);
            stmt.setInt(14, Numero);
            stmt.setInt(15, CodigoIgreja);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Editado com sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void verificar(){
        String sql = "SELECT MAX(CodiIgreja) FROM Configuracoes";
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
             stmt = con.prepareStatement(sql);
             stmt.execute();
             rs = stmt.executeQuery();
             
             rs.next();
             total = rs.getInt(1);
             
             stmt.close();
             rs.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    public void pedirsenha(){
        String sql = "SELECT PedirSenha FROM Configuracoes WHERE CodiIgreja = 1";
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();
            PedirSenha = rs.getBoolean("PedirSenha");
            stmt.close();
            rs.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null," Um erro ocorreu durante a verificação de serviço Veja  ->"+e );
        }
    }
    
}
