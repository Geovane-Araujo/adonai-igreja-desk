
package Model.Var;

import java.sql.Date;


public class VarEntradas {
    
    private static  int ID;
    
    private static  String Descricao;
    
    private static  Date DataC;
    
    private static int IDTipo;
    
    private static double Valor;
    
    private static  int IDMembro;
    
    private static  String Observacoes;
    
    private static  int IDCaixa;

    public  int getID() {
        return ID;
    }

    public  void setID(int aID) {
        this.ID = aID;
    }

    public  String getDescricao() {
        return Descricao;
    }

    public  void setDescricao(String aDescricao) {
       this.Descricao = aDescricao;
    }

    public  Date getDataC() {
        return DataC;
    }

    public  void setDataC(Date aDataC) {
        this.DataC = aDataC;
    }

    public  int getIDTipo() {
        return IDTipo;
    }

    public  void setIDTipo(int aIDTipo) {
        this.IDTipo = aIDTipo;
    }

    public  double getValor() {
        return Valor;
    }

    public  void setValor(double aValor) {
        this.Valor = aValor;
    }

    public  int getIDMembro() {
        return IDMembro;
    }

    public  void setIDMembro(int aIDMembro) {
        this.IDMembro = aIDMembro;
    }

    public  String getObservacoes() {
        return Observacoes;
    }

    public  void setObservacoes(String aObservacoes) {
        this.Observacoes = aObservacoes;
    }

    public  int getIDCaixa() {
        return IDCaixa;
    }

    public  void setIDCaixa(int aIDCaixa) {
        this.IDCaixa = aIDCaixa;
    }
    
    
}
