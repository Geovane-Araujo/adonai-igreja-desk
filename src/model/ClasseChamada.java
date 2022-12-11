
package model;

import database.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;


public class ClasseChamada {
    
    public static int ID;
    
    public static int IDClasse;
    
    public static Date data;
    
    public static int Presentes;
    
    public static int Ausentes;
    
    public static int Visitas;
    
    public static double Ofertas;
    
    public static double Total;
    
   

    ConexaoBanco conectar = new ConexaoBanco();
    

    
    public void Add(){
        
        String sql = "INSERT INTO Chamada(ID,IDClasse,datachamada,Presentes,Ausentes,Visitas,Ofertas,Total) VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, ID);
            stmt.setInt(2,IDClasse);
            stmt.setDate(3, (java.sql.Date) data);
            stmt.setInt(4, Presentes);
            stmt.setInt(5, Ausentes);
            stmt.setInt(6, Visitas);
            stmt.setDouble(7, Ofertas);
            stmt.setDouble(8, Total);
            stmt.execute();
            
            
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    
    
    public void Delete(){
        
        String sql = "DELETE FROM Chamada WHERE ID = ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1,ID);
            stmt.executeUpdate();
   
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Excluir");
        }   
    }
    
    public void pegarid(){
        String sql = "SELECT MAX(ID)  FROM chamada";
        Connection con =null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
             con = conectar.Conectar();
             stmt = con.prepareStatement(sql);
             rs = stmt.executeQuery();
             rs.next();
            
             ID = rs.getInt(1);
             
             ID = ID + 1;
            
   
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        } 
    }
}
