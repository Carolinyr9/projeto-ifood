package model;

public class Pagamento {
	String formaPagamento;

	public Pagamento(String formaPagamento) {
		super();
		this.formaPagamento = formaPagamento;
	}
	
	public Pagamento() {
		
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
}
