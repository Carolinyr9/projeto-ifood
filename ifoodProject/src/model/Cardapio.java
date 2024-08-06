package model;

import java.util.List;

public class Cardapio {
	private int id;
    private List<ItemCardapio> itensCardapio;

    public Cardapio(List<ItemCardapio> itensCardapio) {
        this.itensCardapio = itensCardapio;
    }

    public List<ItemCardapio> getItensCardapio() {
        return itensCardapio;
    }

    public void setItensCardapio(List<ItemCardapio> itensCardapio) {
        this.itensCardapio = itensCardapio;
    }

    public String toString() {
        StringBuilder textoCardapio = new StringBuilder("\nCardápio:");
        for (ItemCardapio itemCardapio : itensCardapio) {
            textoCardapio.append("\n").append(itemCardapio.toString());
        }
        return textoCardapio.toString();
    }
    
    public int getidPrato(int id) {
    	return itensCardapio.get(id).getIdPrato();
    }
    
    public int getidProduto(int id) {
    	return itensCardapio.get(id).getIdProduto();
    }
    
    public int getidRestaurante(int id) {
    	return itensCardapio.get(id).getIdRestaurante();
    }
}
