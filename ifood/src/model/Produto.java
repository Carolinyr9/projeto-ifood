package model;

public class Produto extends ItemCardapio {
    private String nome;

    public Produto(Double preco, Integer id, String nome) {
        super(preco, id);
        this.nome = nome;
    }

    public Produto() {
    	
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void editarItem(String nome) {
        setNome(nome);
        System.out.println("Produto editado: " + this.toString());
    }

    @Override
    public String toString() {
        return "Produto" +
               "\nNome: " + nome +
               "\nPreço: " + getPreco();
    }
}
