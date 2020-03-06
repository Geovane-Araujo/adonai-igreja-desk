
package Model;

import BancoDados.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClasseTurma {
    
    public static int IDClasse;
    
    public static int IDAluno;
    
    public static int Tipo;
    
    public static int IDTurma;

    
    ConexaoBanco conectar = new ConexaoBanco();
    

    
    public void Add(){
        
        String sql = "INSERT INTO Turma(IdClasse,Idaluno,Tipo) VALUES (?,?,?)";
        
        try{
            
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, IDClasse);
            stmt.setInt(2,IDAluno);
            stmt.setInt(3, Tipo);
            stmt.execute();
            
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    
    
    public void Delete(){
        
        String sql = "DELETE FROM Turma WHERE IDturma = ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1,IDTurma);
            stmt.executeUpdate();
   
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Erro ao Excluir");
        }   
    }
}
