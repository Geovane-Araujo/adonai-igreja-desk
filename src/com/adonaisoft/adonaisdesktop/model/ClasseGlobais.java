
package model;

import database.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClasseGlobais {

    public static int Id_Globais;

    public static String TestoRelatorio;

    public static String SMPT; 
    
    public static int Porta; 
    
    public static String Email;
    
    public static String Senha; 
    
    public static String Usuario; 
    
    public static String Autenticacao;
    
    public static byte[] imagem;
    

    
    ConexaoBanco conectar = new ConexaoBanco();

    
    public void AlterarGlobais(){// alterar aqui depois
        
        String sql = "UPDATE Globais SET imagem = ?,TestoRelatorio = ?,SMPT = ?,Porta = ?"
                + ",Email = ?,Senha = ?,Usuario = ?,Autenticacao = ? WHERE Id_Globais= ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setBytes(1, imagem);
            stmt.setString(2, TestoRelatorio);
            stmt.setString(3, SMPT);
            stmt.setInt(4, Porta);
            stmt.setString(5, Email);
            stmt.setString(6, Senha);
            stmt.setString(7, Usuario);
            stmt.setString(8, Autenticacao);
            
            stmt.setInt(9, Id_Globais);
            
            
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Editado com sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
      
}
