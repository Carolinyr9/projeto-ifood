package model;

public class Frete {
	private Double preco;
	private String endereco;
	
	public Frete(Double preco, String endereco) {
		super();
		this.preco = preco;
		this.endereco = endereco;
	}

	public Frete() {
		
	}
	
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void calcularFrete() {
		// Chamada para API
	}
}
