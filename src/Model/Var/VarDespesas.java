
package Model.Var;

import java.sql.Date;


public class VarDespesas {
   
    private static   int ID;
    
    private static  String Descricao;
    
    private static  Date DataC;
    
    private static  Date DataV;
    
    private static  Date DataP;
    
    private static  String QuemPagou;
    
    private static  int IDCaixa;   
    
    private static  String Status;
    
    private static  double Valor;
    
    private static  String Observacoes;
    
    private static int IDTipo;

    public VarDespesas() {
        
        
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Date getDataC() {
        return DataC;
    }

    public void setDataC(Date DataC) {
        this.DataC = DataC;
    }

    public Date getDataV() {
        return DataV;
    }

    public void setDataV(Date DataV) {
        this.DataV = DataV;
    }

    public Date getDataP() {
        return DataP;
    }

    public void setDataP(Date DataP) {
        this.DataP = DataP;
    }

    public String getQuemPagou() {
        return QuemPagou;
    }

    public void setQuemPagou(String QuemPagou) {
        this.QuemPagou = QuemPagou;
    }

    public int getIDCaixa() {
        return IDCaixa;
    }

    public void setIDCaixa(int IDCaixa) {
        this.IDCaixa = IDCaixa;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String Observacoes) {
        this.Observacoes = Observacoes;
    }

    public int getIDTipo() {
        return IDTipo;
    }

    public void setIDTipo(int IDTipo) {
        this.IDTipo = IDTipo;
    }

  
}
