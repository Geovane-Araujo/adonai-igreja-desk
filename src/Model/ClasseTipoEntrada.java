
package Model;

import BancoDados.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClasseTipoEntrada {
    
    public static int IDTipo;
    
    public static String Descricao;

    
    ConexaoBanco conectar = new ConexaoBanco();
    

    
    public void Add(){
        
        String sql = "INSERT INTO public.TipoEntrada(descricao) VALUES (?)";
        
        try{
            
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, Descricao);

            
           
            
            stmt.execute();
            JOptionPane.showMessageDialog(null,"cadastrado com Sucesso");
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "O visitante que está tentando cadastrar já contém na base de dados");
        }
    }
    
    public void Edit(){
        
        String sql = "UPDATE public.TipoEntrada\n" +
                    "	SET descricao=?\n" +
                    "	WHERE IDTipo=? ";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, Descricao);
            stmt.setInt(2, IDTipo);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Alterado com Sucesso");            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"falha ao alterar verifique -> " +e );
        }
        
    }
    
    public void Delete(){
        
        String sql = "DELETE FROM TipoEntrada WHERE IDTipo = ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, IDTipo);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Deletado com Sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Não é possível excluir pois já há registros vinculados com este Registro");
        }
        
    }
   

}
