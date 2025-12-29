
package model;

import database.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;


public class ClasseEmail {
    
    ConexaoBanco conectar = new ConexaoBanco();
    
    public static String SMPT;
    
    public static String athen;
    
    public static Boolean SSL;
    
    public static int Porta;
    
    public static String Email;
    
    public  static String Senha;
    
    public static String EmailDestinatario;
    
    public static String Assunto;
    
    public static String CorpoEmail;
    
    public static String anexo;
    
    public static boolean TSL;
    
    public static int loading;
    
    
    public void enviaremail(){
        
        Povoar();
        
        if(athen.equals("SSL")){
            SSL = true;
            TSL = false;
        }
        else if(athen.equals("TSL")){
            SSL = false;
            TSL = true;
        }
        else{
            SSL = false;
            TSL = false;
        }
        
        MultiPartEmail email = new MultiPartEmail();
        email.setHostName(SMPT);
        email.setSmtpPort(Porta);
        email.setSSLOnConnect(SSL);
        email.setStartTLSEnabled(TSL);
       // email.setStartTLSRequired(true);
        email.setAuthenticator(new DefaultAuthenticator(Email, Senha));
        
       
        
        
        try{
            email.setFrom(Email);
            email.setSubject(Assunto);
            email.setMsg(CorpoEmail);
            email.addTo(EmailDestinatario);
            EmailAttachment anex = new EmailAttachment();
            anex.setPath(anexo);
            email.attach(anex);
            email.send();
            
            
            
            
            JOptionPane.showMessageDialog(null,"Email enviado com sucesso");
            
        }
        catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Não foi possivel enviar o email verifiqu -> "+ e);
        }
        
        
    }
    
    
    
    public void Povoar(){
        
        String sql = "SELECT SMPT,Porta,Email,Senha,Autenticacao FROM Globais WHERE Id_Globais = 1";
        Connection con = conectar.Conectar();
        ResultSet rs= null;
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();
            
            
            SMPT = rs.getString("SMPT");
            
            Porta = Integer.parseInt(rs.getString("Porta"));
            Email = rs.getString("Email");
            Senha = rs.getString("Senha");
            athen = rs.getString("Autenticacao");
  
            rs.close();
            stmt.close();

        }
        catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    
    
}
