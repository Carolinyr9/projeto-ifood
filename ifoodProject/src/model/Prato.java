package model;

public class Prato extends ItemCardapio {
    private String nome;
    private String descricao;
    private int id;
    private String ingredientes;
    

	public Prato(int idRestaurante, Double preco, String nome, String descricao, String ingredientes) {
		super(idRestaurante, preco);
		this.nome = nome;
		this.descricao = descricao;
		this.id = id;
		this.ingredientes = ingredientes;
	}

	public Prato(int idRestaurante, Double preco, String nome, String descricao, int id, String ingredientes) {
		super(idRestaurante, preco);
		this.nome = nome;
		this.descricao = descricao;
		this.id = id;
		this.ingredientes = ingredientes;
	}

	public Prato() {
    	
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void editarItem(Double preco, String nome, String descricao, String ingredientes) {
        setPreco(preco);
        setNome(nome);
        setDescricao(descricao);
        setIngredientes(ingredientes);
    }

    public String toString() {
        return "Prato" +
                "\nNome: " + nome +
                "\nDescrição: " + descricao +
                "\nIngredientes: " + ingredientes +
                "\nPreço: " + getPreco();
    }
}
