package model;

public class ItemCardapio {
	private int idRestaurante;
	private int idPrato;
	private int idProduto;
	
	public ItemCardapio(int idRestaurante, int idPrato, int idProduto) {
		super();
		this.idRestaurante = idRestaurante;
		this.idPrato = idPrato;
		this.idProduto = idProduto;
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

