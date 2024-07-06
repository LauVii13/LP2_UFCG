package mrbet;

import java.util.Objects;

/**
 * Classe que define a estrutura de cada time existente no sistema.
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 *
 */
public class Time {
	/**
	 * Código identificador (em formato de String) do Time.
	 */
	private String id;
	
	/**
	 * Nome do Time.
	 */
	private String nome;
	
	/**
	 * Mascote do Time.
	 */
	private String mascote;
	
	/**
	 * Constrói um novo Time no sistema.
	 * @param id O código identificador do Time.
	 * @param nome O nome do Time.
	 * @param mascote O mascote do Time.
	 */
	public Time(String id, String nome, String mascote) {
		this.id = id;
		this.nome = nome;
		this.mascote = mascote;
	}
	
	/**
	* Método para pegar o código verificador do time.
	 * @return O id (ou código verificador), em String, do Time.
	*/
	public String getId() {
		return id;
	}
	
	/**
	 * Método para pegar o nome do Time.
	 * @return O nome do Time.
	 */
	public String getNome() {
		return nome;
	}
	
	public String getMascote() {
		return mascote;
	}
	
	/**
	 * Retorna uma String que representa os detalhes do Time.
	 * Formato:
	 * [ID DO TIME] NOME / MASCOTE
	 * @return A representação em String do Time.
	 */
	public String toString() {
		return "[" + this.id + "] " + this.nome + " / " + this.mascote;
	}
	
	/**
	 * Gerador do código hash do objeto Time (com base no id do mesmo).
	 * @return Código hash (inteiro).
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	/**
	 * Método de comparação de Times.
	 * Verdadeiro para times iguais.
	 * Falso para times diferentes.
	 * @return Booleano da comparação entre dois times com base em seus IDs.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		return Objects.equals(id, other.id);
	}
	
}
