package model;

import java.util.Random;

public class Produto extends ItemCardapio {
    private String descricao;
    private int id;

	public Produto(int idRestaurante, Double preco, String nome, String descricao) {
		super(idRestaurante, preco, nome);
		this.descricao = descricao;
		this.id = generateRandomId();
	}

	public Produto() {
    	
    }
	
	private int generateRandomId() {
        Random random = new Random();
        return random.nextInt(10000) + 1;
    }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdProduto() {
		return id;
	}

	public void setIdProduto(int id) {
		this.id = id;
	}

    public void editarItem(String nome) {
        setNome(nome);
        System.out.println("Produto editado: " + this.toString());
    }

    @Override
    public String toString() {
        return "Produto" +
               "\nNome: " + getNome() +
               "\nPreço: " + getPreco();
    }
}
