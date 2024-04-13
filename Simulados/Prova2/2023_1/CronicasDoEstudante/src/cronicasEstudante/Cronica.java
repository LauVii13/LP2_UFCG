package cronicasEstudante;

import java.util.Objects;

public class Cronica {
	private int id;
	private String titulo;
	private String texto;
	private String autor;
	private String dataCriacao;
	
	public Cronica(int id, String titulo, String texto, String autor, String dataCriacao) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.autor = autor;
		this.dataCriacao = dataCriacao;
	}
	
	
	public Cronica(int id, String titulo, String texto, String dataCriacao) {
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.dataCriacao = dataCriacao;
		this.autor = "Anônimo";
	}

	
	
	public String getTitulo() {
		return titulo;
	}


	public String getTexto() {
		return texto;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return String.format("Cronica #%d\n%s\nData: %s\nAutor: %s\n%s\n", id, titulo, dataCriacao, autor, texto);
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cronica other = (Cronica) obj;
		return Objects.equals(titulo, other.titulo);
	}
	
}
