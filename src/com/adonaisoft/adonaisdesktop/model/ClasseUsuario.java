
package model;

import database.ConexaoBanco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClasseUsuario {
    
    public static int CodigoUsuario;
    
    public static String NomeUsuario;
    
    public static String Senha;
    
    public static String ConfirmarSenha;
    
    public static boolean Membros;
    
    public static boolean Despesas;
    
    public static boolean Entradas;
    
    public static boolean Caixas;
    
    public static boolean Configuracoes;
    
    public static boolean Usuarios;
    
    public static boolean Relatorios;
    
    ConexaoBanco conectar = new ConexaoBanco();
    

    
    public void InserirUsuario(){
        
        String sql = "INSERT INTO Usuario(NomeUsuario,Senha,confirmarSenha,Membros,Despesas,"
                + "Entradas,Caixas,Configuracoes,Usuarios,Relatorios) VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        try{
            
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, NomeUsuario);
            stmt.setString(2 ,Senha);
            stmt.setString(3, ConfirmarSenha);
            stmt.setBoolean(4, Membros);
            stmt.setBoolean(5, Despesas);
            stmt.setBoolean(6, Entradas);
            stmt.setBoolean(7, Caixas);
            stmt.setBoolean(8, Configuracoes);
            stmt.setBoolean(9, Usuarios);
            stmt.setBoolean(10, Relatorios);
            
            stmt.execute();
            JOptionPane.showMessageDialog(null,"Usuário cadastrado com Sucesso");
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void AlterarUsuario(){
        
        String sql = "UPDATE Usuario SET NomeUsuario = ?,\n" +
                    "Senha =?,\n" +
                    "ConfirmarSenha =?,\n" +
                    "Membros =?,\n" +
                    "Despesas = ?,\n" +
                    "Entradas =?,\n" +
                    "Caixas =?,\n" +
                    "Configuracoes =?,\n" +
                    "Usuarios =?,\n" +
                    "Relatorios =? WHERE CodigoUsuario = ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, NomeUsuario);
            stmt.setString(2 ,Senha);
            stmt.setString(3, ConfirmarSenha);
            stmt.setBoolean(4, Membros);
            stmt.setBoolean(5, Despesas);
            stmt.setBoolean(6, Entradas);
            stmt.setBoolean(7, Caixas);
            stmt.setBoolean(8, Configuracoes);
            stmt.setBoolean(9, Usuarios);
            stmt.setBoolean(10, Relatorios);
            
            stmt.setInt(11, CodigoUsuario);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Usuário alterado com Sucesso");            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"falha ao alterar");
        }
        
    }
    
    public void DeletaUsuario(){
        
        String sql = "DELETE FROM Usuario WHERE CodigoUsuario = ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, CodigoUsuario);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Usuário Deletado com Sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
}
