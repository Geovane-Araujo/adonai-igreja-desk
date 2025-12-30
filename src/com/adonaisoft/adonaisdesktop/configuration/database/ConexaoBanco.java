
package com.adonaisoft.adonaisdesktop.configuration.database;

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
    public static String url = "jdbc:sqlite:"+System.getProperty("user.dir")+"/data/base.db";

    
    public Connection connectDatabase() {
       
        return DatabaseConnection.getInstance().getConnection();
    }
    
    public void povoar(){
        
        String sql = "SELECT * FROM localdb WHERE Id = 1";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            con = connectDatabase();
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
    
}


