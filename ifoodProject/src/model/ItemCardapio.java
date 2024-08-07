package model;

public class ItemCardapio {
	private int idRestaurante;
	private int idPrato;
	private int idProduto;
	private Double preco;
	
	
	public ItemCardapio(int idRestaurante, int idPrato, int idProduto, Double preco) {
		super();
		this.idRestaurante = idRestaurante;
		this.idPrato = idPrato;
		this.idProduto = idProduto;
		this.preco = preco;
	}
	
	public ItemCardapio(int idRestaurante, Double preco) {
		super();
		this.idRestaurante = idRestaurante;
		this.preco = preco;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public ItemCardapio() {
		
	}

	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public int getIdPrato() {
		return idPrato;
	}

	public void setIdPrato(int idPrato) {
		this.idPrato = idPrato;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
}

