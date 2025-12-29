/*
  Novo projeto baseado no modelo do wikiIgreja
  Projeto iniciado dia 04-11-2019
  Desenvolvedor: Geovane Araújo
  Versão: 1.0.40
  Data Ultima atualização: 25-02-2020
 */
package adonaisoft;

import database.ConexaoBanco;

import model.ClasseConfiguracoes;
import view.CadastroIgreja;
import view.Login;
import view.Principal;
import java.sql.SQLException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class AdonaiSoft {
    
   
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
       
        ConexaoBanco con = new ConexaoBanco();
        con.Conectando();
        con.ConectarLocalBanco();
        con.povoar();
        
        
        try {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (UnsupportedLookAndFeelException e) {
         
        System.out.println("Erro: " + e.getMessage());
        e.printStackTrace();
         
    } catch (ClassNotFoundException e) {
         
        System.out.println("Erro: " + e.getMessage());
        e.printStackTrace();
         
    } catch (InstantiationException e) {
         
        System.out.println("Erro: " + e.getMessage());
        e.printStackTrace();
         
    } catch (IllegalAccessException e) {
         
        System.out.println("Erro: " + e.getMessage());
        e.printStackTrace();
    }
        
        
        
        
        
        ConexaoBanco abrir = new ConexaoBanco();
        abrir.ConectandoBanco();
        
        
        ClasseConfiguracoes conf = new ClasseConfiguracoes();
        conf.verificar();
        
        
        
        
        if(ClasseConfiguracoes.total == 0){
            CadastroIgreja chamar = new CadastroIgreja(null, true);
            chamar.setVisible(true);
        }
        else{
            ClasseConfiguracoes ver = new ClasseConfiguracoes();
            ver.pedirsenha();
            
            
            if(ClasseConfiguracoes.PedirSenha == true){
                Login principal = new Login(null, true);
                principal.setVisible(true);
                
            }
            else{
                Principal chamar = new Principal();
                chamar.preencher();
                chamar.setVisible(true);
                
            }
            
        }
        
        abrir.FecharConexao();  
    }
    
}
