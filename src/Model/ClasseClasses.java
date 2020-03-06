
package Model;

import BancoDados.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClasseClasses {
    
    public static int IDClasse;
    
    public static String Descricao;

    
    ConexaoBanco conectar = new ConexaoBanco();
    

    
    public void Add(){
        
        String sql = "INSERT INTO Classe(descricao) VALUES (?)";
        
        try{
            
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, Descricao);
            stmt.execute();
            
            
            
            JOptionPane.showMessageDialog(null,"Classe cadastrado com Sucesso!");
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        } 
    }
    
    public void Edit(){
        
        String sql = "UPDATE Classe\n" +
                    "	SET descricao=? \n" +
                    "	WHERE IdClasse=? ";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, Descricao);
            stmt.setInt(2, IDClasse);
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null,"Alterado com Sucesso");            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"falha ao alterar verifique -> " +e );
        } 
    }
    
    public void Delete(){
        
        String sql = "DELETE FROM CLasse WHERE IDClasse = ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, IDClasse);
            
            stmt.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null,"Deletado com Sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Não é possível excluir pois já há registros vinculados com este Classe");
        }   
    }
}
