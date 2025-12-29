package controller;

import database.ConexaoBanco;
import model.Igrejas;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IgrejaController {


    ConexaoBanco conectar = new ConexaoBanco();
    Connection con = null;


    public void onInsert(Igrejas igreja){

        String sql = "INSERT INTO igrejas(nomeigreja, telefone, email, pastorresponsavel, endereco, numero, bairro, cidade, uf, cep)\n" +
                "	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try{
            con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);


            stmt.setString(1, igreja.getNomeIgreja());
            stmt.setString(2, igreja.getTelefone());
            stmt.setString(3, igreja.getEmail());
            stmt.setString(4, igreja.getPastorResponsavel());
            stmt.setString(5, igreja.getEndereco());
            stmt.setInt(6, igreja.getNumero());
            stmt.setString(7, igreja.getBairro());
            stmt.setString(8, igreja.getCidade());
            stmt.setString(9, igreja.getEstado());
            stmt.setString(10, igreja.getCep());


            stmt.execute();


            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onUpdate(Igrejas igreja){// alterar aqui depois

        String sql = "UPDATE igrejas SET  nomeigreja=?, telefone=?, email=?, pastorresponsavel=?, endereco=?, numero=?, bairro=?, cidade=?, uf=?, cep=?\n" +
                "	WHERE id_igreja=?";

        try{
            con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, igreja.getNomeIgreja());
            stmt.setString(2, igreja.getTelefone());
            stmt.setString(3, igreja.getEmail());
            stmt.setString(4, igreja.getPastorResponsavel());
            stmt.setString(5, igreja.getEndereco());
            stmt.setInt(6, igreja.getNumero());
            stmt.setString(7, igreja.getBairro());
            stmt.setString(8, igreja.getCidade());
            stmt.setString(9, igreja.getEstado());
            stmt.setString(10, igreja.getCep());
            stmt.setInt(11, igreja.getIdIgreja());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Editado com sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onDelete(int id){// alterar aqui depois

        String sql = "DELETE FROM Igrejas WHERE id_igreja=?";

        try{
            con = conectar.Conectar();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
