
package model;


public class Igrejas {

    private int id;  //ok

    private String nomeIgreja; // ok

    private String endereco; //ok

    private String bairro;  // ok

    private String cidade; // ok

    private int numero;

    private String estado;  //ok

    private String telefone; // ok

    private String pastorResponsavel;

    private String email;

    private String cep;

    public int getIdIgreja() {
        return id;
    }

    public void setIdIgreja(int idIgreja) {
        this.id = idIgreja;
    }

    public String getNomeIgreja() {
        return nomeIgreja;
    }

    public void setNomeIgreja(String nomeIgreja) {
        this.nomeIgreja = nomeIgreja;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPastorResponsavel() {
        return pastorResponsavel;
    }

    public void setPastorResponsavel(String pastorResponsavel) {
        this.pastorResponsavel = pastorResponsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
