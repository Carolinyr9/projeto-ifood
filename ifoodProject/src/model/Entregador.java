package model;

import java.time.LocalDate;

public class Entregador extends Usuario {
    private LocalDate dataNascimento;
    private Long telefone;
    private String nome;
    private Long cpf;
    private Long cnh;
    private String endereco;

    public Entregador(String email, String senha, LocalDate dataNascimento, Long telefone, String nome, Long cpf, Long cnh, String endereco) {
        super(email, senha);
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.endereco = endereco;
    }

    public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Entregador() {
    	
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Long getCnh() {
        return cnh;
    }

    public void setCnh(Long cnh) {
        this.cnh = cnh;
    }

    @Override
    public String toString() {
        return "Entregador" +
               "\nNome: " + nome +
               "\nData de Nascimento: " + dataNascimento +
               "\nTelefone: " + telefone +
               "\nCPF: " + cpf +
               "\nCNH: " + cnh +
               "\nEmail: " + getEmail();
    }
}
