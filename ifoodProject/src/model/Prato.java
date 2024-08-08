package model;

import java.util.Random;

public class Prato extends ItemCardapio {
    private String descricao;
    private int id;
    private String ingredientes;

	public Prato(int idRestaurante, Double preco, String nome, String descricao, String ingredientes) {
		super(idRestaurante, preco, nome);
		this.descricao = descricao;
		this.id = generateRandomId();
		this.ingredientes = ingredientes;
	}

	public Prato() {
    	
    }
	
	private int generateRandomId() {
        Random random = new Random();
        return random.nextInt(10000) + 1;
    }

    public int getIdPrato() {
		return id;
	}

	public void setIdPrato(int id) {
		this.id = id;
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

    public String toString() {
        return "Prato" +
                "\nNome: " + getNome() +
                "\nDescrição: " + descricao +
                "\nIngredientes: " + ingredientes +
                "\nPreço: " + getPreco();
    }
}
