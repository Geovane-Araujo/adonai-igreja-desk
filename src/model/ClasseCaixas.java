
package model;

import database.ConexaoBanco;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClasseCaixas {
    
    public static int CodigoCaixa;
    
    public static String DescricaoCaixa;
    
    public static Date DataAbertura;
    
    public static Date DataFechamento; 
    
    public static double Saldo;           
    
    public static double Entradas;  
    
    public static String Status;   
    
    public static double SaldoInicial;
    
    public static double Saidas;
    
    public static String QuemFechou; 
    

    public int getCodigoCaixa() {
        return CodigoCaixa;
    }

    public void setCodigoCaixa(int CodigoCaixa) {
        this.CodigoCaixa = CodigoCaixa;
    }

    public String getDescricaoCaixa() {
        return DescricaoCaixa;
    }

    public void setDescricaoCaixa(String DescricaoCaixa) {
        this.DescricaoCaixa = DescricaoCaixa;
    }

    public Date getDataAbertura() {
        return DataAbertura;
    }

    public void setDataAbertura(Date DataAbertura) {
        this.DataAbertura = DataAbertura;
    }

    public Date getDataFechamento() {
        return DataFechamento;
    }

    public void setDataFechamento(Date DataFechamento) {
        this.DataFechamento = DataFechamento;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

    public double getEntradas() {
        return Entradas;
    }

    public void setEntradas(double Entradas) {
        this.Entradas = Entradas;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public double getSaldoInicial() {
        return SaldoInicial;
    }

    public void setSaldoInicial(double SaldoInicial) {
        this.SaldoInicial = SaldoInicial;
    }

    public double getSaidas() {
        return Saidas;
    }

    public void setSaidas(double Saidas) {
        this.Saidas = Saidas;
    }

    public String getQuemFechou() {
        return QuemFechou;
    }

    public void setQuemFechou(String QuemFechou) {
        this.QuemFechou = QuemFechou;
    }

    public double getSomaEntradas() {
        return SomaEntradas;
    }

    public void setSomaEntradas(double SomaEntradas) {
        this.SomaEntradas = SomaEntradas;
    }

    public double getSomaDespesas() {
        return SomaDespesas;
    }

    public void setSomaDespesas(double SomaDespesas) {
        this.SomaDespesas = SomaDespesas;
    }

    public double getSomaEntradaSaida() {
        return SomaEntradaSaida;
    }

    public void setSomaEntradaSaida(double SomaEntradaSaida) {
        this.SomaEntradaSaida = SomaEntradaSaida;
    }
    
    public static double SomaEntradas;
    
    public static double SomaDespesas;
    
    public static double SomaEntradaSaida;
    
    ConexaoBanco conectar = new ConexaoBanco();
    
    public void inserircaixa(){
        
        String sql = "INSERT INTO Caixas (Descricaocaixa,DataAbertura,SaldoInicial,Status,Saldo)VALUES(?,?,?,?,?)";
        
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            stmt.setString(1,getDescricaoCaixa());
            stmt.setDate(2,getDataAbertura());
            stmt.setDouble(3,getSaldoInicial());
            stmt.setString(4, getStatus());
            stmt.setDouble(5, getSaldo());
            stmt.execute();
            stmt.close();
            
            
            JOptionPane.showMessageDialog(null,"Caixa criado com sucesso! " );

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Não é possível cadastrar dois caixas com o mesmo nome");
        }
    }
    
    public void DeletarCaixa(){
        
        String sql = "DELETE FROM Caixa WHERE CodigoCaixa = ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, getCodigoCaixa());
            stmt.executeUpdate();
            
            stmt.close();
            
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void FecharCaixa(){
        
        String sql = "UPDATE Caixas SET  DataFechamento = ?, Saldo = ?,"
                + " QuemFechou = ?,Entradas = ?, Status = ?, Saidas =? WHERE CodigoCaixa = ?";
        
        try{
            Connection con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);
            
            
            
            stmt.setDate(1, getDataFechamento());
            stmt.setDouble(2,getSaldo());
            stmt.setString(3, getQuemFechou());
            stmt.setDouble(4, getEntradas());
            stmt.setString(5, getStatus()); 
            stmt.setDouble(6, getSaidas());
            stmt.setInt(7, getCodigoCaixa());
            stmt.executeUpdate();
            
            stmt.close();

            JOptionPane.showMessageDialog(null, "Deu tudo certo! caixa fechado com sucesso.");
            
            
        }   
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Ihhh deu ruim, por vavor verifique  -> "+e);
        }
    }
    
    public void SomarEntradas(){
        
        String sql = "SELECT SUM(Valor) FROM duplicatas WHERE tipo = 0 AND IDCaixa = "+getCodigoCaixa();
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            con = conectar.Conectar();
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            while(rs.next()){
                SomaEntradas = rs.getDouble(1);
                
            }   
            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
      
    }
    
    public void SomarSaidas(){
        
        String sql = "SELECT SUM(Valor) FROM duplicatas WHERE tipo = 1 AND IDCaixa = "+getCodigoCaixa()+" AND Status = 'Paga'";
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            con = conectar.Conectar();
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            
            while(rs.next()){
                SomaDespesas = rs.getDouble(1);
            }
            rs.close();
            stmt.close();
        }
        catch(SQLException e){
            System.out.println(e);
        }
        
      
    }
    
    public void pegarsaldo(){
        
        String sql = "SELECT SaldoInicial FROM Caixas WHERE CodigoCaixa = " +this.getCodigoCaixa();
        Connection con = conectar.Conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try{
            stmt = con.prepareStatement(sql);
            stmt.execute();
            rs = stmt.executeQuery();
            rs.next();
            this.setSaldoInicial(Float.parseFloat(rs.getString("SaldoInicial"))); 
            rs.close();
            stmt.close();
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
}



