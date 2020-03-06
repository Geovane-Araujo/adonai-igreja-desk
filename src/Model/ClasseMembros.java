
package Model;

import BancoDados.ConexaoBanco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClasseMembros {
    
    
    public static int CodigoMembros;
    
    public static String NomeCompleto;
    
    public static Date DataNascimento;
    
    public static String Telefone;
    
    public static String Endereco;
   
    public static String Bairro;
    
    public static String Cidade;
    
    public static int Numero;
    
    public static String UF;
    
    public static boolean Ativo;
    
    public static int IDCargo;
    
    public static String Observacoes;
    
    public static String DataBatismo;
    
    public static byte[] Imagem;
    
    public static String EstadoCivil;
    
    public static String Cep;
     
    public static String Email;
      
    public static boolean Batizado;
    
    public static int IdMembro;
    
    
    
    
    ConexaoBanco conectar = new ConexaoBanco();
    
    

    
    public void InserirMembros(){
        
        String sql = "INSERT INTO Membros(NomeCompleto,DataNascimento,Telefone,Endereco,Bairro,\n" +
                    "Cidade,\n" +
                    "Numero,\n" +
                    "UF,\n" +
                    " Ativo,\n" +
                    "IDCargo,\n" +
                    "Observacoes,DataBatismo,imagem, EstadoCivil,Cep,Batizado,EMail)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        try{
            
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
           
            stmt.setString(1,NomeCompleto);
            stmt.setDate(2, DataNascimento);
            stmt.setString(3,Telefone);
            stmt.setString(4, Endereco);
            stmt.setString(5, Bairro);
            stmt.setString(6, Cidade);
            stmt.setInt(7, Numero);
            stmt.setString(8, UF);
            stmt.setBoolean(9, Ativo);
            stmt.setInt(10, IDCargo);
            stmt.setString(11,Observacoes);
            stmt.setString(12,DataBatismo);
            stmt.setBytes(13,Imagem);
            stmt.setString(14,EstadoCivil);
            stmt.setString(15, Cep);
            stmt.setBoolean(16, Batizado);
            stmt.setString(17, Email);
            
            
            stmt.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null,"Membro Cadastrado com Sucesso");
            
        }
        catch(SQLException e){
            System.out.println("Problema aqui  " + e);
            JOptionPane.showMessageDialog(null,"O Membro que está tentando cadastrar já contém na base de dados");
            
        }      

    }  
    
    public void AlterarMembros(){
     
        String sql = "UPDATE Membros SET NomeCompleto = ?,DataNascimento = ?,Telefone = ?,Endereco =?,Bairro =?,\n" +
                    "Cidade =?,\n" +
                    "Numero = ?,\n" +
                    "UF =?,\n" +
                    " Ativo =?,\n" +
                    "IDCargo =?,\n" +
                    "Observacoes =?,DataBatismo = ?,imagem = ?,EstadoCivil = ?,Cep = ?,Batizado = ?,EMail =? WHERE CodigoMembro = ?";
        
        try{
            
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1,NomeCompleto);
            stmt.setDate(2,DataNascimento);
            stmt.setString(3,Telefone);
            stmt.setString(4, Endereco);
            stmt.setString(5, Bairro);
            stmt.setString(6, Cidade);
            stmt.setInt(7, Numero);
            stmt.setString(8, UF);
            stmt.setBoolean(9, Ativo);
            stmt.setInt(10, IDCargo);
            stmt.setString(11,Observacoes);
            stmt.setString(12,DataBatismo);
            stmt.setBytes(13,Imagem);
            stmt.setString(14,EstadoCivil);
            stmt.setString(15, Cep);
            stmt.setBoolean(16, Batizado);
            stmt.setString(17, Email);
            
            stmt.setInt(18, CodigoMembros);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Membro alterado com Sucesso!!");

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            
        } 
    }    
    
    public void DeletaMembros(){
     
        String sql = "DELETE FROM Membros WHERE CodigoMembro = ?";
        
        try{
         
            Connection con = conectar.Conectar();
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, CodigoMembros);
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com Sucesso!");
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
                    
        }
        
    } 
}