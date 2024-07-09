package model;

public class ItemCardapio {
    private Double preco;
    private Integer id;
    private boolean ativo;

    public ItemCardapio(Double preco, Integer id) {
        this.preco = preco;
        this.id = id;
        this.ativo = true;
    }

    public ItemCardapio() {
        this.ativo = true; 
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public boolean isAtivo() {
        return ativo;
    }

    public void adicionarItemAoCardapio() {
        // Implementar lógica para adicionar item ao cardápio
        // Isso pode envolver adicioná-lo a uma coleção ou banco de dados
        this.ativo = true;
        System.out.println("Item adicionado ao cardápio: " + this.toString());
    }

    public void desativarItemDoCardapio() {
        // Implementar lógica para desativar item do cardápio
        this.ativo = false;
        System.out.println("Item desativado: " + this.toString());
    }
    
    public void editarItem() {
    	
    }

	public String toString() {
		return "Item do Cardápio"
				+ "\nPreço: "+ preco 
				+ "\nID: " + id 
				+ "\nSituação (está ativo?): " + ativo;
	}
}

