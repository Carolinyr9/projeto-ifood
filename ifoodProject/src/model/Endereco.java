package model;

public class Endereco {
	private String cep;
	private String rua;
	private String cidade;
	private String estado;
	private String numeroResidencial;
	private String segmento;
	
	public Endereco(String cep, String rua, String cidade, String estado, String numeroResidencial, String segmento) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.numeroResidencial = numeroResidencial;
		this.segmento = segmento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumeroResidencial() {
		return numeroResidencial;
	}

	public void setNumeroResidencial(String numeroResidencial) {
		this.numeroResidencial = numeroResidencial;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}
	
	
}
