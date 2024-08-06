package model;

import java.util.List;

public class Prato extends ItemCardapio {
    private String nome;
    private String descricao;
    private int id;
    private int idRestaurante;
    private String ingredientes;

    public Prato(Double preco, String nome, String descricao, int id, int idRestaurante, String ingredientes) {
		super(preco);
		this.nome = nome;
		this.descricao = descricao;
		this.id = id;
		this.idRestaurante = idRestaurante;
		this.ingredientes = ingredientes;
	}

	public Prato() {
    	
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
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

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void editarItem(Double preco, String nome, String descricao, String ingredientes) {
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
