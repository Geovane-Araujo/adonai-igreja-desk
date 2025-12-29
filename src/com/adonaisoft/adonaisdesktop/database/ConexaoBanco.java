
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexaoBanco {
    public static int id = 1;
    public static String local;
    public static int porta;
    public static String database;
    public static String senha;
    public Connection openConnection;
    public static final String ur = "jdbc:sqlite:"+System.getProperty("user.dir")+"/data/conexaobase.db";
    public static String url = "jdbc:sqlite:"+System.getProperty("user.dir")+"/data/base.db";

   
    
    public boolean Conectando() throws ClassNotFoundException{
        
        try{
            Class.forName("org.sqlite.JDBC");

            this.openConnection = DriverManager.getConnection(ur);
 
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
        
        String sql = "SELECT * FROM localdb WHERE Id = 1";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            con = ConectarLocalBanco();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
               local = rs.getString("Local");
               porta = rs.getInt("Porta");
               database = rs.getString("DataBase");
               senha = rs.getString("Senha"); 
            }
            
            rs.close();
            stmt.close();
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }
    
    
    public boolean ConectandoBanco() throws ClassNotFoundException{
        
        try{
            
            Class.forName("org.sqlite.JDBC");

            this.openConnection = DriverManager.getConnection(url);

            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Não foi Possível conectar a base de dados, verifique o status do servidor","Erro", JOptionPane.ERROR_MESSAGE);
            
            return false;
        }
        return true;
    }
    
    public boolean FecharConexao(){
        
        try{
            
            if(this.openConnection.isClosed()== false){
                
                this.openConnection.isClosed();
                
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

            con = DriverManager.getConnection(url);

        }
        catch(SQLException e){

            JOptionPane.showMessageDialog(null, "Problemas na conexão com o servidor");
        }
        return con;
    }
}


