package model;

import java.util.List;

public class Restaurante extends Usuario {
    private String cnpj;
    private int id;
    private String nome;
    private String telefone;
    private Endereco endereco;
    private List<Cardapio> cardapios;

    public Restaurante(String email, String senha, String cnpj, String nome, 
    		           Endereco endereco, String telefone, List<Cardapio> cardapios) {
        super(email, senha);
        this.cnpj = cnpj;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cardapios = cardapios;
    }

    public Restaurante() {
    	
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Cardapio> getCardapios() {
        return cardapios;
    }

    public void setCardapios(List<Cardapio> cardapios) {
        this.cardapios = cardapios;
    }

    public void editarRestaurante(String cnpj, String nome, Endereco endereco, String telefone) {
        setCnpj(cnpj);
        setNome(nome);
        setEndereco(endereco);
        setTelefone(telefone);
        System.out.println("Restaurante editado: " + this.toString());
    }

    public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getCep() {
		return endereco.getCep();
	}
	
	public String getRua() {
		return endereco.getRua();
	}

	public String getCidade() {
		return endereco.getCidade();
	}
	public String getEstado() {
		return endereco.getEstado();
	}

	public String getNumeroResidencial() {
		return endereco.getNumeroResidencial();
	}

	public String getSegmento() {
		return endereco.getSegmento();
	}
	
	public void setCep(String cep) {
		endereco.setCep(cep);
	}
	
	public void setRua(String rua) {
		endereco.setRua(rua);
	}
	
	public void setCidade(String cidade) {
		endereco.setCidade(cidade);
	}
	
	public void setEstado(String estado) {
		endereco.setEstado(estado);
	}

	public void setNumeroResidencial(String numeroResidencial) {
		endereco.setSegmento(numeroResidencial);
	}

	public void setSegmento(String segmento) {
		endereco.setSegmento(segmento);
	}
	
	@Override
    public String toString() {
        return "Restaurante" +
               "\nCNPJ: " + cnpj +
               "\nNome: " + nome +
               "\nEndereço: " + endereco +
               "\nTelefone: " + telefone +
               "\nEmail: " + getEmail() +
               "\nSenha: " + getSenha();
    }
}