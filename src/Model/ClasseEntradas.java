
package Model;

import BancoDados.ConexaoBanco;
import Model.Var.VarEntradas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ClasseEntradas {
    
    VarEntradas entradas = new VarEntradas();
    ConexaoBanco conectar = new ConexaoBanco();
       
    
    public void InserirEntrada(){
     
        String sql = "INSERT INTO Duplicatas(Descricao,DataC,IDTipo,Valor,IDCaixa,Observacoes,IDMembro,Tipo,Status) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1, entradas.getDescricao());
            stmt.setDate(2, entradas.getDataC());
            stmt.setInt(3, entradas.getIDTipo());
            stmt.setDouble(4, entradas.getValor());
            stmt.setInt(5, entradas.getIDCaixa());
            stmt.setString(6, entradas.getObservacoes());
            stmt.setInt(7, entradas.getIDMembro());
            stmt.setInt(8, 0);
            stmt.setString(9,"Paga");
            
            stmt.execute();
            
            JOptionPane.showMessageDialog(null, "Entrada cadastrada com sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Algo deu errado ao salvar a entrada por favor verifique -> " +e);
        }
    }
    
    public void EditarEntrada(){
        
        String sql = "UPDATE Duplicatas SET Descricao =?,\n" +
                    "DataC =?,\n" +
                    "IDTipo =?,\n" +
                    " Valor =?,"
                + "IDCaixa = ?,\n" +
                    "Observacoes = ?,IDMembro =?,Tipo = ? WHERE ID = ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, entradas.getDescricao());
            stmt.setDate(2, entradas.getDataC());
            stmt.setInt(3, entradas.getIDTipo());
            stmt.setDouble(4, entradas.getValor());
            stmt.setInt(5, entradas.getIDCaixa());
            stmt.setString(6, entradas.getObservacoes());
            stmt.setInt(7, entradas.getIDMembro());
            stmt.setInt(8, 0);
            stmt.setInt(9, entradas.getID());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Entrada alterada com sucesso");
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Algo deu errado ao salvar a entrada por favor verifique -> " +e);
        }
    }
    
    public void DeletarEntrada(){
        
        String sql = "DELETE FROM Duplicatas WHERE ID = ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, entradas.getID());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Entrada deletada com sucesso ");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
