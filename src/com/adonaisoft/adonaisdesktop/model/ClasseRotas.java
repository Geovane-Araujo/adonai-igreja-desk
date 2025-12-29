
package model;
/*
  Abreviações:
  R = Rota
  T = Tabela
  
  
*/

public class ClasseRotas {
    
    // Secretaria
    private String RTCadMembros = "SELECT CodigoMembro,NomeCompleto,DataNascimento,Telefone,Endereco,Bairro,Cidade FROM Membros ORDER BY CodigoMembro DESC LIMIT 15" ;
    
    private String RTVisitantes =  "SELECT * FROM Visitantes ORDER BY CodigoVisitante DESC limit 15 ";
    
    private String RTHistoricoVisita = "SELECT HistoricoVisita.codigovisitante, HistoricoVisita.datavisita, anotacoes, Visitantes.NomeVisitante\n" +
                                        "FROM historicovisita\n" +
                                        "INNER JOIN Visitantes ON Visitantes.CodigoVisitante = IDVisitante ORDER BY CodigoVisitante DESC limit 15 ";
    

    private String RTIgrejas = "SELECT id_igreja, nomeigreja, telefone,pastorresponsavel ,email  FROM igrejas";
    
    private String RTNovoConvertido = "SELECT id_novoconverido, nomeconvertido, endereco, bairro, numero, cidade, uf, dataconversao, obs, telefone, cep\n" +
                                    "	FROM novoconvertido";
    
    private String RTCargo = "SELECT idcargo, descricao	FROM cargo";
    
    private String RTTipo = "SELECT idtipo, descricao, pconta FROM tipo ORDER BY IDTipo Desc";
    
    

    public String getRTCadMembros() {
        return RTCadMembros;
    }

    public String getRTVisitantes() {
        return RTVisitantes;
    }

    public String getRTHistoricoVisita() {
        return RTHistoricoVisita;
    }

    public String getRTIgrejas() {
        return RTIgrejas;
    }

    public String getRTNovoConvertido() {
        return RTNovoConvertido;
    }

    public String getRTCargo() {
        return RTCargo;
    }

    public String getRTTipo() {
        return RTTipo;
    }


    
    
    
    // Financeiro 
    
    private String RTTabEntradas = "SELECT id, Duplicatas.descricao, datac, valor, Tipo.descricao AS TpDesc,Caixas.descricaocaixa, membros.NomeCompleto,IDCaixa \n" +
                                    "FROM duplicatas\n" +
                                    "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                                    "INNER JOIN Membros ON Membros.codigomembro = Duplicatas.IDMembro\n" +
                                    "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                                    "WHERE tipo = 0 \n" +
                                    "ORDER BY ID DESC limit 15";
    
    private String RTDespesasTodas = "SELECT id, Duplicatas.descricao,valor, datac, Duplicatas.status,Caixas.descricaocaixa,IDCaixa\n" +
                                        "FROM duplicatas\n" +
                                        "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                                        "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                                        "WHERE Tipo = 1\n" +
                                        "ORDER BY ID DESC limit 15";
    
    private String RTDespesasPendentes = "SELECT id, Duplicatas.descricao,valor, dataV, Duplicatas.status,Caixas.descricaocaixa,IDCaixa\n" +
                                        "FROM duplicatas\n" +
                                        "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                                        "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                                        "WHERE Tipo = 1 AND Duplicatas.Status = 'Pendente'\n" +
                                        "ORDER BY ID DESC limit 15";
    
    private String RTDespesasPagas = "SELECT id, Duplicatas.descricao,valor, dataP, Duplicatas.status,Caixas.descricaocaixa,IDCaixa,QuemPagou\n" +
                                        "FROM duplicatas\n" +
                                        "INNER JOIN Caixas ON Caixas.codigocaixa = Duplicatas.idCaixa\n" +
                                        "INNER JOIN Tipo ON Tipo.IDTipo = Duplicatas.IDTipo\n" +
                                        "WHERE Tipo = 1 AND Duplicatas.Status = 'Paga'\n" +
                                        "ORDER BY ID DESC limit 15";
    
    private String RTCaixa = "SELECT CodigoCaixa,DescricaoCaixa,SaldoInicial,Saldo,DataAbertura,Status FROM Caixas WHERE Status = 'Caixa Aberto' ORDER BY CodigoCaixa desc";
    
    private String RTCXHistorico = "SELECT CodigoCaixa,DescricaoCaixa,DataAbertura,DataFechamento,Saldo,Status,QuemFechou FROM Caixas ORDER BY CodigoCaixa desc ";
    
    
    
   
    
    
    
    
    
    public String getRTTabEntradas() {
        return RTTabEntradas;
    }

    public String getRTDespesasTodas() {
        return RTDespesasTodas;
    }

    public String getRTDespesasPendentes() {
        return RTDespesasPendentes;
    }

    public String getRTDespesasPagas() {
        return RTDespesasPagas;
    }

    public String getRTCaixa() {
        return RTCaixa;
    }

    public String getRTCXHistorico() {
        return RTCXHistorico;
    }
    
    //Menu Escola 
    
    private String TabelaHistorico = "SELECT id, chamada.idclasse, datachamada,Classe.descricao\n" +
                                    "FROM chamada\n" +
                                    "INNER JOIN Classe ON Classe.IDClasse = Chamada.IDClasse\n" +
                                    "WHERE Chamada.ID > 0\n"
                                    + "ORDER BY Chamada.DataChamada DESC";
    
    private String TabelaClasses = "SELECT IdClasse,Descricao FROM Classe ORDER BY IdClasse DESC";

//    private String PovoarClasseChamada = "SELECT id,Classe.descricao,ausentes,presentes,datachamada,visitas,total,ofertas,chamada.idclasse    \n" +
//                                        "FROM chamada\n" +
//                                        "INNER JOIN Classe ON Classe.IDClasse = Chamada.IDClasse\n" +
//                                        "WHERE Chamada.ID ="+ClasseChamada.ID;
//            
//
//   private String PovoarAlunosChamada = "SELECT id, idchamada, idmatriculado, presente, Membros.nomecompleto\n" +
//                                            "FROM registrochamada\n" +
//                                            "INNER JOIN Membros ON Membros.CodigoMembro = IdMatriculado\n" +
//                                            "WHERE IDChamada ="+ClasseChamada.ID;
    
    
      
    public String getTabelaClasses() {
        return TabelaClasses;
    }
 
    public String getTabelaHistorico() {
        return TabelaHistorico;
    }

    
    
    
    
    
}
