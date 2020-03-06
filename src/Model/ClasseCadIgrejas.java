
package Model;

import BancoDados.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClasseCadIgrejas {

    public static int ID_Igreja;  //ok
    
    public static String NomeIgreja; // ok
    
    public static String Endereco; //ok
    
    public static String Bairro;  // ok
    
    public static String Cidade; // ok
    
    public static int Numero;
    
    public static String Estado;  //ok
    
    public static String Telefone; // ok
    
    public static String PastorResponsavel;
    
    public static String Email;
    
    public static String Cep;


    ConexaoBanco conectar = new ConexaoBanco();
    
   
    
    public void CadastrarIgreja(){
        
        String sql = "INSERT INTO igrejas(nomeigreja, telefone, email, pastorresponsavel, endereco, numero, bairro, cidade, uf, cep)\n" +
                    "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, NomeIgreja);
            stmt.setString(2, Telefone);
            stmt.setString(3, Email);
            stmt.setString(4, PastorResponsavel);
            stmt.setString(5, Endereco);
            stmt.setInt(6, Numero);
            stmt.setString(7, Bairro);
            stmt.setString(8, Cidade);
            stmt.setString(9, Estado);
            stmt.setString(10, Cep);
            
   
            stmt.execute();
            
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void AlterarIgreja(){// alterar aqui depois
        
        String sql = "UPDATE igrejas SET  nomeigreja=?, telefone=?, email=?, pastorresponsavel=?, endereco=?, numero=?, bairro=?, cidade=?, uf=?, cep=?\n" +
                    "	WHERE id_igreja=?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            
            
            stmt.setString(1, NomeIgreja);
            stmt.setString(2, Telefone);
            stmt.setString(3, Email);
            stmt.setString(4, PastorResponsavel);
            stmt.setString(5, Endereco);
            stmt.setInt(6, Numero);
            stmt.setString(7, Bairro);
            stmt.setString(8, Cidade);
            stmt.setString(9, Estado);
            stmt.setString(10, Cep);
            stmt.setInt(11, ID_Igreja);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Editado com sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void Deletar(){// alterar aqui depois
        
        String sql = "DELETE FROM Igrejas WHERE id_igreja=?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
    
            stmt.setInt(1, ID_Igreja);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Editado com sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
}
