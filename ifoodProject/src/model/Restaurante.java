package model;

import java.util.List;

public class Restaurante extends Usuario {
    private Long cnpj;
    private String nome;
    private String endereco;
    private Long telefone;
    private List<Cardapio> cardapios;

    public Restaurante(String email, String senha, Long cnpj, String nome, 
    		           String endereco, Long telefone, List<Cardapio> cardapios) {
        super(email, senha);
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cardapios = cardapios;
    }

    public Restaurante() {
    	
    }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public List<Cardapio> getCardapios() {
        return cardapios;
    }

    public void setCardapios(List<Cardapio> cardapios) {
        this.cardapios = cardapios;
    }

    public void editarRestaurante(Long cnpj, String nome, String endereco, Long telefone) {
        setCnpj(cnpj);
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
        System.out.println("Restaurante editado: " + this.toString());
    }

    @Override
    public String toString() {
        return "Restaurante" +
               "\nCNPJ: " + cnpj +
               "\nNome: " + nome +
               "\nEndereço: " + endereco +
               "\nTelefone: " + telefone +
               "\nEmail: " + getEmail() +
               "\nSenha: " + getSenha();
    }
}

