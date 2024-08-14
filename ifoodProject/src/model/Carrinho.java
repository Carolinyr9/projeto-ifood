package model;

public class Carrinho implements ModelInterface {
	private Integer id;
	private int idCliente;
	private int idRestaurante;
	private int idPrato;
	private int idProduto;
	private double preco;
	private String enderecoEntrega;
	private int quantidade;
	
	public Carrinho() {
		
	}

	public Carrinho(int idCliente, int idRestaurante, int idPrato, int idProduto, double preco, String enderecoEntrega,
			int quantidade) {
		super();
		this.idCliente = idCliente;
		this.idRestaurante = idRestaurante;
		this.idPrato = idPrato;
		this.idProduto = idProduto;
		this.preco = preco;
		this.enderecoEntrega = enderecoEntrega;
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(String enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
	
	public Integer getId() {
		return id;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public void setId(Integer id) {
		this.id = id;		
	}
}
