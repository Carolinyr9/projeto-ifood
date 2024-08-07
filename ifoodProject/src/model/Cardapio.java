package model;

import java.util.List;

public class Cardapio {
    private int id;
    private List<ItemCardapio> itensCardapio;

    public Cardapio() {
    }

    public Cardapio(List<ItemCardapio> itensCardapio) {
        this.itensCardapio = itensCardapio;
    }

    public List<ItemCardapio> getItensCardapio() {
        return itensCardapio;
    }

    public void setItensCardapio(List<ItemCardapio> itensCardapio) {
        this.itensCardapio = itensCardapio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder textoCardapio = new StringBuilder("\nCardápio:");
        for (ItemCardapio itemCardapio : itensCardapio) {
            textoCardapio.append("\n").append(itemCardapio.toString());
        }
        return textoCardapio.toString();
    }
}
