package model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Integer id;
    private List<ItemCardapio> itens;
    private Double precoTotal;
    private StatusPedido status;
    private String endereco;
    private Double estimativaTempo;
    private Cliente cliente;
    private Restaurante restaurante;

    public Pedido() {
        this.itens = new ArrayList<>();
    }

    public Pedido(Integer id, List<ItemCardapio> itens, Double precoTotal, StatusPedido status,
                  String endereco, Double estimativaTempo, Cliente cliente, Restaurante restaurante) {
        this.id = id;
        this.itens = itens;
        this.precoTotal = precoTotal;
        this.status = status;
        this.endereco = endereco;
        this.estimativaTempo = estimativaTempo;
        this.cliente = cliente;
        this.restaurante = restaurante;
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

    public Cliente getCliente() {
        return cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
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
        sb.append("\nCliente: ").append(cliente.getNome());
        sb.append("\nRestaurante: ").append(restaurante.getNome());

        return sb.toString();
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
