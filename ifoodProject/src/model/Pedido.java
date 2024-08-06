package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Integer id;
    private List<ItemCardapio> itens;
    private Double precoTotal;
    private StatusPedido status;
    private LocalDateTime dataPedido;
    private String endereco;
    private Double estimativaTempo;
    private int idCliente;
    private int idRestaurante;
    private int idEntregador;
    private int idCarrinho;

	public Pedido() {
        this.itens = new ArrayList<>();
    }

	public Pedido(Integer id, List<ItemCardapio> itens, Double precoTotal, StatusPedido status,
			LocalDateTime dataPedido, String endereco, Double estimativaTempo, int idCliente, int idRestaurante,
			int idEntregador, int idCarrinho) {
		super();
		this.id = id;
		this.itens = itens;
		this.precoTotal = precoTotal;
		this.status = status;
		this.dataPedido = dataPedido;
		this.endereco = endereco;
		this.estimativaTempo = estimativaTempo;
		this.idCliente = idCliente;
		this.idRestaurante = idRestaurante;
		this.idEntregador = idEntregador;
		this.idCarrinho = idCarrinho;
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

    public List<ItemCardapio> getItens() {
        return itens;
    }

    public void setItens(List<ItemCardapio> itens) {
        this.itens = itens;
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

    public Double getEstimativaTempo() {
        return estimativaTempo;
    }

    public void setEstimativaTempo(Double estimativaTempo) {
        this.estimativaTempo = estimativaTempo;
    }


    public void adicionarItemPedido(ItemCardapio item) {
        itens.add(item);
    }

    
    public StatusPedido getStatus() {
		return status;
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

	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPedido");
        sb.append("\nNúmero do pedido: ").append(id);
        sb.append("\nItens:");
        
        for (ItemCardapio item : itens) {
        	sb.append("\n");
            sb.append(item.toString());
        }
        
        sb.append("\nPreco Total: ").append(precoTotal);
        sb.append("\nStatus: ").append(status);
        sb.append("\nEndereco de Entrega: ").append(endereco);
        sb.append("\nEstimativaTempo: ").append(estimativaTempo);
        sb.append("\nCliente: ").append(idCliente);
        sb.append("\nRestaurante: ").append(idRestaurante);

        return sb.toString();
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

//    private int verificarItem(ItemCardapio item) {
//    	for (ItemCardapio it : itens) {
//            if (it.getId().equals(item.getId())) {
//                return it.getId();
//            }
//        }
//    	return -1;
//    }
}
