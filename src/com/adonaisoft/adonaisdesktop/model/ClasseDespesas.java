
package model;

import database.ConexaoBanco;
import model.Var.VarDespesas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClasseDespesas {
    
    ConexaoBanco conectar = new ConexaoBanco();
    VarDespesas despesas = new VarDespesas();
    
    public void InserirDespesa(){
    
       String sql = "INSERT INTO Duplicatas(Descricao,dataC,DataV,Status,Valor,Observacoes,IDCaixa,IDTipo,Tipo) VALUES(?,?,?,?,?,?,?,?,?)";
       
       try{
           Connection con = conectar.Conectar();
           PreparedStatement stmt = con.prepareStatement(sql);
           
           
           stmt.setString(1, despesas.getDescricao());
           stmt.setDate(2, despesas.getDataC());
           stmt.setDate(3, despesas.getDataV());
           stmt.setString(4, despesas.getStatus());
           stmt.setDouble(5, despesas.getValor());
           stmt.setString(6,despesas.getObservacoes());
           stmt.setInt(7, despesas.getIDCaixa());
           stmt.setInt(8,despesas.getIDTipo());
           stmt.setInt(9,1);
           stmt.execute();
           
           
           JOptionPane.showMessageDialog(null, "Despesa cadastrada com sucesso.");
       }
       catch(SQLException e){
           
           JOptionPane.showMessageDialog(null,"Houve um erro ao salvar a despesa por favor verifique aqui -> " +e);
           
       }
        
    }
    
    public void EditarDespesa(){
     
        String sql = "UPDATE Duplicatas SET  Descricao = ?, DataC = ?,\n" +
                    "DataV = ?,\n" +
                    "Status\n=?," +
                    "Valor =?,\n" +
                    "Observacoes =?,IDCaixa = ?,IDTipo =?, Tipo = ? WHERE ID = ?";
        
        try{
            
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
           
           stmt.setString(1, despesas.getDescricao());
           stmt.setDate(2, despesas.getDataC());
           stmt.setDate(3, despesas.getDataV());
           stmt.setString(4, despesas.getStatus());
           stmt.setDouble(5, despesas.getValor());
           stmt.setString(6,despesas.getObservacoes());
           stmt.setInt(7, despesas.getIDCaixa());
           stmt.setInt(8,despesas.getIDTipo());
           stmt.setInt(9,1);
           stmt.setInt(10, despesas.getID());
           
           stmt.executeUpdate();
           JOptionPane.showMessageDialog(null, "Despesa editada com sucesso.");
           stmt.close();
        }
        catch(SQLException e){
            
           JOptionPane.showMessageDialog(null, "Falha ao editar");
            
        }
                   
    
    
    }
    
    public void ExcluirDespesa(){
        
        String sql = "DELETE FROM Duplicatas WHERE ID = ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt =con.prepareStatement(sql);
            
            stmt.setInt(1,despesas.getID());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Despesa excluída com sucesso.");
            stmt.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void PagarDespesa(){
     
        String sql = "UPDATE Duplicatas SET Status = ?,Quempagou =?, dataP = ? WHERE ID = ?";
        
        try{
            
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
          
           stmt.setString(1, despesas.getStatus());
           stmt.setString(2, despesas.getQuemPagou());
           stmt.setDate(3, despesas.getDataP());
           stmt.setInt(4, despesas.getID());
           
           
           stmt.executeUpdate();
           
           
          JOptionPane.showMessageDialog(null, "Despesaa paga com sucesso.");
           stmt.close();
        }
        catch(SQLException e){
            
            JOptionPane.showMessageDialog(null, "Infelizmente ocorreu um erro por favor verifique -> " +e);
        }
    }
    public void Estornar(String sql){
     
        
        
        try{
            
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            

           stmt.setString(1, despesas.getStatus());
           stmt.setDate(2, null);

           
           stmt.executeUpdate();
           
           JOptionPane.showMessageDialog(null, "Despesa estornada com sucesso.");
           stmt.close();
        }
        catch(SQLException e){
            
           JOptionPane.showMessageDialog(null, "Falha ao estornar" + e);
            
        }
                   
    
    
    }


    
    
}
