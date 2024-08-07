package model;

public class Produto extends ItemCardapio {
    private String nome;
    private String descricao;
    private int id;
 
	public Produto(int idRestaurante, Double preco, String nome, String descricao, int id) {
		super(idRestaurante, preco);
		this.nome = nome;
		this.descricao = descricao;
		this.id = id;
	}

	public Produto() {
    	
    }

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
