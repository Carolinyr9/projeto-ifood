package model;

public class Avaliacao {
	private Integer nota;
	private String comentário;
	
	public Avaliacao(Integer nota, String comentário) {
		super();
		this.nota = nota;
		this.comentário = comentário;
	}
	
	public Avaliacao() {
		
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	public String getComentário() {
		return comentário;
	}

	public void setComentário(String comentário) {
		this.comentário = comentário;
	}
}
