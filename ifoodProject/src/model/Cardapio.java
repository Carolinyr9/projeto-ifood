package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cardapio implements ModelInterface {
    private Integer id;
    private int id_restaurante;
    private List<ItemCardapio> itensCardapio;
    private List<ItemCardapio> produtosCardapios;
    private List<ItemCardapio> pratosCardapios;

    public Cardapio() {
        this.id = 1;
        itensCardapio = new ArrayList<ItemCardapio>();
    }

    public Cardapio(List<ItemCardapio> itensCardapio) {
        this.id = 1;
        this.itensCardapio = itensCardapio;
    }

    private int generateRandomId() {
        Random random = new Random();
        return random.nextInt(10000) + 1;
    }

    public List<ItemCardapio> getItensCardapio() {
        return itensCardapio;
    }

    public void setItensCardapio(List<ItemCardapio> itensCardapio) {
        this.itensCardapio = itensCardapio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    
    public void adicionarItem(ItemCardapio item) {
        itensCardapio.add(item);
    }
}

