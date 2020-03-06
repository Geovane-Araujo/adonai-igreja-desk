
package BancoDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexaoBanco {
    public static int Id = 1;
    public static String Local;
    public static int Porta;
    public static String DataBase;
    public static String Senha;
    public static final String ur = "jdbc:sqlite:C:/Program Files/AdonaiSoft Igreja/warning/conexaobase.db";
    
    public boolean Conectando() throws ClassNotFoundException{
        
        try{
            
            Class.forName("org.sqlite.JDBC");

            this.AbrirConexao = DriverManager.getConnection(ur);
 
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            return false;
        }
        return true;
        
    }
    
    public Connection ConectarLocalBanco() {
        
        
    Connection con = null;
    
    try{
        con = DriverManager.getConnection(ur);
    }
    catch(SQLException e){
        
        System.err.println(e);
    }
    return con;
 }
    public void povoar(){
        
        String sql = "SELECT * FROM LocalBanco WHERE Id = 1";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            con = ConectarLocalBanco();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            rs.next();
            Local = rs.getString("Local");
            Porta = rs.getInt("Porta");
            DataBase = rs.getString("DataBase");
            Senha = rs.getString("Senha");
            
            rs.close();
            stmt.close();
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }
    
    private  String url = "jdbc:postgresql://"+Local+":"+Porta+"/"+DataBase;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection AbrirConexao;
    
    
    public boolean ConectandoBanco() throws ClassNotFoundException{
        
        try{
            
            Class.forName("org.postgresql.Driver");

            this.AbrirConexao = DriverManager.getConnection(getUrl(), "postgres", Senha);

            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Não foi Possível conectar a base de dados, verifique o status do servidor","Erro", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        return true;
    }
    
    public boolean FecharConexao(){
        
        try{
            
            if(this.AbrirConexao.isClosed()== false){
                
                this.AbrirConexao.isClosed();
                
                
            }
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Problemas na conexão com o servidor"+e);
        }
        return true;
    }
    
    
    
    
    public Connection Conectar() {
        
        
    Connection con = null;
    
    try{
        
        con = DriverManager.getConnection(getUrl(), "postgres",Senha);
        
    }
    catch(SQLException e){
        
        JOptionPane.showMessageDialog(null, "Problemas na conexão com o servidor");
    }
    return con;
 }
}


