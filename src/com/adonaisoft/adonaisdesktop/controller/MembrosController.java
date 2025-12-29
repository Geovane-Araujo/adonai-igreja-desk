package controller;

import database.ConexaoBanco;
import model.Membros;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MembrosController {


    ConexaoBanco conectar = new ConexaoBanco();
    Connection con = null;

    public void onInsert(Membros membro){
        con = null;
        String sql = "INSERT INTO Membros(NomeCompleto,DataNascimento,Telefone,Endereco,Bairro,\n" +
                "Cidade,\n" +
                "Numero,\n" +
                "UF,\n" +
                " Ativo,\n" +
                "IDCargo,\n" +
                "Observacoes,DataBatismo,imagem, EstadoCivil,Cep,Batizado,EMail)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try{

            con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setString(1, membro.getNome());
            stmt.setDate(2, membro.getDataNascimento());
            stmt.setString(3,membro.getTelefone());
            stmt.setString(4, membro.getEmail());
            stmt.setString(5, membro.getBairro());
            stmt.setString(6, membro.getCidade());
            stmt.setInt(7, membro.getNumero());
            stmt.setString(8, membro.getUf());
            stmt.setBoolean(9, membro.isAtivo());
            stmt.setInt(10, membro.getIdCargo());
            stmt.setString(11,membro.getObservacoes());
            stmt.setString(12,membro.getDataBatismo());
            stmt.setBytes(13,membro.getImagem());
            stmt.setString(14,membro.getEstadoCivil());
            stmt.setString(15, membro.getCep());
            stmt.setBoolean(16, membro.isBatizado());
            stmt.setString(17, membro.getEmail());


            stmt.executeUpdate();


            JOptionPane.showMessageDialog(null,"Membro Cadastrado com Sucesso");

        }
        catch(SQLException e){

            System.out.println("Problema aqui  " + e);
            JOptionPane.showMessageDialog(null,"O Membro que está tentando cadastrar já contém na base de dados");

        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Membros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void onUpdate(Membros membro){

        String sql = "UPDATE Membros SET NomeCompleto = ?,DataNascimento = ?,Telefone = ?,Endereco =?,Bairro =?,\n" +
                "Cidade =?,\n" +
                "Numero = ?,\n" +
                "UF =?,\n" +
                " Ativo =?,\n" +
                "IDCargo =?,\n" +
                "Observacoes =?,DataBatismo = ?,imagem = ?,EstadoCivil = ?,Cep = ?,Batizado = ?,EMail =? WHERE CodigoMembro = ?";

        try{

            con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setString(1, membro.getNome());
            stmt.setDate(2, membro.getDataNascimento());
            stmt.setString(3,membro.getTelefone());
            stmt.setString(4, membro.getEmail());
            stmt.setString(5, membro.getBairro());
            stmt.setString(6, membro.getCidade());
            stmt.setInt(7, membro.getNumero());
            stmt.setString(8, membro.getUf());
            stmt.setBoolean(9, membro.isAtivo());
            stmt.setInt(10, membro.getIdCargo());
            stmt.setString(11,membro.getObservacoes());
            stmt.setString(12,membro.getDataBatismo());
            stmt.setBytes(13,membro.getImagem());
            stmt.setString(14,membro.getEstadoCivil());
            stmt.setString(15, membro.getCep());
            stmt.setBoolean(16, membro.isBatizado());
            stmt.setString(17, membro.getEmail());

            stmt.setInt(18, membro.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Membro alterado com Sucesso!!");

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);

        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onDelete(int id){

        String sql = "DELETE FROM Membros WHERE CodigoMembro = ?";

        try{

            con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deletado com Sucesso!");

        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);

        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
