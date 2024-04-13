package filmnow;

import java.util.Objects;

import org.junit.jupiter.api.Test;

public class Filme {
	/**
	 * Ano atual no momento do uso do sistema (para limitar filmes não lançados).
	 */
	private static final int ANOATUAL = 2024;
	
	/**
	 * Nome do filme.
	 */
	private String nome;
	
	/**
	 * Ano de lançamento do filme.
	 */
	private String ano;
	
	/**
	 * Local para se ver o filme.
	 */
	private String local;
	
	/**
	 * Filme está ou não na lista de prioridade (hotlist).
	 */
	private boolean ehHot;
	
	/**
	 * Constrói um novo Filme. 
	 * @param nome O nome do Filme.
	 * @param ano O ano de lançamento do filme.
	 * @param local O local para assistir o filme.
	 * @throws IllegalArgumentException Caso o nome e/ou local do filme nulos, ou ano de lançamento do filme  maior que  o ano atual.
	 */
	public Filme(String nome, String ano, String local) throws IllegalArgumentException{
		if(nome.equals("") || local.equals("")) {
			throw new IllegalArgumentException("FILME INVALIDO");
		}
		this.nome = nome;
		this.ano = ano;
		this.local = local;
		this.ehHot = false;
	}
	
	/**
	 * Método para pegar o nome do filme.
	 * @return O nome do filme.
	 */
	public String getNome(){
		return this.nome;
	}
	
	/**
	 * Método para pegar o ano do filme.
	 * @return O ano (String) do filme.
	 */
	public String getAno(){
		return this.ano;
	}
	
	/**
	 * Método para pegar o ano do filme.
	 * @return O ano (inteiro) do filme.
	 */
	public boolean getEhHot(){
		return this.ehHot;
	}
	
	/**
	 * Altera o status se o filme está ou não na HotList.
	 * @param ehHot O novo status do Filme (está ou não na HotList).
	 */
	public void setEhHot(boolean ehHot) {
		this.ehHot = ehHot;
	}

	/**
	 * Formatação textual de um Filme.
	 * @return String dos dados de um filme.
	 */
	@Override
	public String toString() {
		if(this.ehHot) {
			if(this.ano.equals("")) {
				return String.format("🔥 %s\n%s", this.nome, this.local);			
			}
			return String.format("🔥 %s, %s\n%s", this.nome, this.ano, this.local);			
		}else {
			if(this.ano.equals("")) {
				return String.format("%s\n%s", this.nome, this.local);			
			}
			return String.format("%s, %s\n%s", this.nome, this.ano, this.local);			
		}
	}

	/**
	 * Gerador do código hash do objeto filme (com base em ano + nome do filme).
	 * @return Código hash (inteiro).
	 */
	@Override
	public int hashCode() {
		return Objects.hash(ano, nome);
	}
	
	/**
	 * Método de comparação entre filmes.
	 * Verdadeiro para filmes iguais.
	 * Falso para filmes diferentes.
	 * @return Booleano da comparação entre dois filmes com base em seus nomes e anos.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filme other = (Filme) obj;
		return Objects.equals(ano, other.ano) && Objects.equals(nome, other.nome);
	}
	
}
