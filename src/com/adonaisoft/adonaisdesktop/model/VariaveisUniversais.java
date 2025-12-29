
package model;


public class VariaveisUniversais {

    public static void getEntrada(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public VariaveisUniversais() {
    }


        public static int total;
        
        public int ativos;
        
        public int inativos;
        
        public static int relatorios;

        public static int despesa = 0;
        
        public static int Entrada;
        
        public static int validar;
        

    public static int getDespesa() {
        return despesa;
    }

    public static void setDespesa(int despesa) {
        VariaveisUniversais.despesa = despesa;
    }

    public static int getEntrada() {
        return Entrada;
    }

    public static void setEntrada(int Entrada) {
        VariaveisUniversais.Entrada = Entrada;
    }
        
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getAtivos() {
        return ativos;
    }

    public void setAtivos(int ativos) {
        this.ativos = ativos;
    }

    public int getInativos() {
        return inativos;
    }

    public void setInativos(int inativos) {
        this.inativos = inativos;
    }

    public int getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(int relatorios) {
        this.relatorios = relatorios;
    }

    public static int getValidar() {
        return validar;
    }

    public static void setValidar(int validar) {
        VariaveisUniversais.validar = validar;
    }
    
    

    // Variavel Usado na tela de Chamadas *Importante não apagar*
    
    public static int Usadochamada;

    public static int getUsadochamada() {
        return Usadochamada;
    }

    public static void setUsadochamada(int Usadochamada) {
        VariaveisUniversais.Usadochamada = Usadochamada;
    }
    

    // variavel que vai definir a escolha do caixa, membros e tipos nas telas das respectivas pesquisas
    // 0 entradas
    // 1 despesas
    // 2 relatórios
    public static int escolha;

    public static int getEscolha() {
        return escolha;
    }

    public static void setEscolha(int escolha) {
        VariaveisUniversais.escolha = escolha;
    }
    
    
    
}
