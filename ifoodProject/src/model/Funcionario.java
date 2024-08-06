package model;

public class Funcionario extends Usuario {
	private String codFuncional;
	private String nome;
	private int idRestaurante;
	private Long cpf;
	
	public Funcionario(String email, String senha, String codFuncional, String nome, int idRestaurante, Long cpf) {
		super(email, senha);
		this.codFuncional = codFuncional;
		this.nome = nome;
		this.idRestaurante = idRestaurante;
		this.cpf = cpf;
	}
	
	public Funcionario() {
		
	}

	public String getCodFuncional() {
		return codFuncional;
	}

	public void setCodFuncional(String codFuncional) {
		this.codFuncional = codFuncional;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getcpf() {
		return cpf;
	}

	public void setcpf(Long cpf) {
		this.cpf = cpf;
	}
	
	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public void aceitarPedido() {
		
	}
	
	public void editarDados(String email, String senha, String codFuncional, String nome, Long cpf) {
		setCodFuncional(codFuncional);
	}
	
	public String consultarDados() {
		return toString();
	}
	
	public String toString() {
		return "Funcionario [codFuncional=" + codFuncional + ", nome=" + nome + ", cpf=" + cpf + "]";
	}
	
}
