
package model;

import database.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClasseRegistroChamada {
    
    public static int ID;
    
    public static int IDChamada;
     
    public static int IDMatriculado;
    
    public static boolean Presente;
    


    ConexaoBanco conectar = new ConexaoBanco();
    

    
    public void Add(){
        
        String sql = "INSERT INTO RegistroChamada(IDChamada,IDMatriculado,Presente) VALUES (?,?,?)";
        
        try{
            
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setInt(1,IDChamada);
            stmt.setInt(2, IDMatriculado);
            stmt.setBoolean(3, Presente);
            
            stmt.execute();
            
            
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    
    
//    public void Delete(){
//        
//        String sql = "DELETE FROM Chamada WHERE ID = ?";
//        
//        try{
//            Connection con = conectar.Conectar();
//            PreparedStatement stmt = con.prepareStatement(sql);
//            
//            stmt.setInt(1,ID);
//            stmt.executeUpdate();
//   
//        }
//        catch(SQLException e){
//            JOptionPane.showMessageDialog(null,"Erro ao Excluir");
//        }   
//    }
}
