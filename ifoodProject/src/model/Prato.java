package model;

import java.util.List;

public class Prato extends ItemCardapio {
    private String nome;
    private String descricao;
    private List<String> ingredientes;

    public Prato(Double preco, String nome, String descricao, List<String> ingredientes) {
        super(preco);
        this.nome = nome;
        this.descricao = descricao;
        this.ingredientes = ingredientes;
    }

    public Prato() {
    	
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void editarItem(Double preco, String nome, String descricao, List<String> ingredientes) {
        setPreco(preco);
        setNome(nome);
        setDescricao(descricao);
        setIngredientes(ingredientes);
    }

    public String toString() {
        return "Prato" +
                "\nNome: " + nome +
                "\nDescrição: " + descricao +
                "\nIngredientes: " + ingredientes +
                "\nPreço: " + getPreco();
    }
}
