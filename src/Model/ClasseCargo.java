
package Model;

import BancoDados.ConexaoBanco;
import Views.TabelaCadCargo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClasseCargo {
    
    public static int IDCargo;
    
    public static String Descricao;

    
    ConexaoBanco conectar = new ConexaoBanco();
    

    
    public void Add(){
        
        String sql = "INSERT INTO public.cargo(descricao) VALUES (?)";
        
        try{
            
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, Descricao);
            stmt.execute();
            
            
            
            JOptionPane.showMessageDialog(null,"Cargo cadastrado com Sucesso");
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
    }
    
    public void Edit(){
        
        String sql = "UPDATE public.cargo\n" +
                    "	SET descricao=?\n" +
                    "	WHERE idcargo=? ";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, Descricao);
            stmt.setInt(2, IDCargo);
            
            stmt.executeUpdate();
            TabelaCadCargo cad = new TabelaCadCargo();
            String sq = "SELECT IdCargo,Descricao FROM Cargo";
            cad.Povoar(sq);
            
            JOptionPane.showMessageDialog(null,"Alterado com Sucesso");            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"falha ao alterar verifique -> " +e );
        }
        
    }
    
    public void Delete(){
        
        String sql = "DELETE FROM Cargo WHERE IDCargo = ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, IDCargo);
            
            stmt.executeUpdate();
            TabelaCadCargo cad = new TabelaCadCargo();
            String sq = "SELECT IdCargo,Descricao FROM Cargo";
            cad.Povoar(sq);
            
            JOptionPane.showMessageDialog(null,"Deletado com Sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Não é possível excluir pois já há registros vinculados com este Cargo");
        }
        
    }
   

}
