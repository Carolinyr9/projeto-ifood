package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pedido {
    private Integer id;
    private List<Integer> idsPratos;
    private List<Integer> idsProdutos;
    private Double precoTotal;
    private StatusPedido status;
    private LocalDateTime dataPedido;
    private String endereco;
    private LocalDateTime estimativaTempo;
    private int idCliente;
    private int idRestaurante;
    private int idEntregador;
    private int idCarrinho;

	public Pedido() {
		
    }
	
	public Pedido(Integer id, List<Integer> idsPratos, List<Integer> idsProdutos, Double precoTotal,
			StatusPedido status, String endereco, int idCliente, int idRestaurante, int idEntregador, int idCarrinho) {
		super();
		this.id = id;
		this.idsPratos = idsPratos;
		this.idsProdutos = idsProdutos;
		this.precoTotal = precoTotal;
		this.status = status;
		this.endereco = endereco;
		this.idCliente = idCliente;
		this.idRestaurante = idRestaurante;
		this.idEntregador = idEntregador;
		this.idCarrinho = idCarrinho;
		this.dataPedido = LocalDateTime.now();
		this.estimativaTempo = dataPedido.plusMinutes(30);
	}

	private int generateRandomId() {
        Random random = new Random();
        return random.nextInt(10000) + 1;
    }

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public int getIdCarrinho() {
		return idCarrinho;
	}

	public void setIdCarrinho(int idCarrinho) {
		this.idCarrinho = idCarrinho;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDateTime getEstimativaTempo() {
        return estimativaTempo;
    }

    public void setEstimativaTempo(LocalDateTime estimativaTempo) {
        this.estimativaTempo = estimativaTempo;
    }

    
    public StatusPedido getStatus() {
		return status;
	}
    
    public String getStatusString() {
    	return status.getStatus().toString();
    }

	public void setStatus(Status novoStatus) {
		this.status.editarStatus(novoStatus);
	}

    public int getIdEntregador() {
		return idEntregador;
	}

	public void setIdEntregador(int idEntregador) {
		this.idEntregador = idEntregador;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public List<Integer> getIdsPratos() {
		return idsPratos;
	}

	public void setIdsPratos(List<Integer> idsPratos) {
		this.idsPratos = idsPratos;
	}

	public List<Integer> getIdsProdutos() {
		return idsProdutos;
	}

	public void setIdsProdutos(List<Integer> idsProdutos) {
		this.idsProdutos = idsProdutos;
	}
	
	public void setDataAtualizacao(LocalDateTime data) {
		status.setHorarioStatus(data);
	}
}
