package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe que define um Item comparável que compõe o FAQ.
 * 
  * @author Vinícius Gabriel Laureano - 123111119
 */
public class Item implements Comparable<Item> {
	/**
	 * A pergunta do item.
	 */
	private String pergunta;
	
	/**
	 * A resposta para a pergunta do item.
	 */
	private String resposta;
	
	/**
	 * grau de destaque do item.
	 */
	private int valorDestaque;
	
	/**
	 * tags atribuídas ao item (limite de 3).
	 */
	private ArrayList<String> tags;
	
	/**
	 * Constrói o item. 
	 * @param pergunta A pergunta do item.
	 * @throws IllegalArgumentException A pergunta não pode ser vazia
	 */
	public Item(String pergunta) throws IllegalArgumentException {
		if(pergunta == null || pergunta.isBlank())
			throw new IllegalArgumentException("Pergunta não pode ser um texto null nem vazio.");
		
		this.pergunta = pergunta;
		this.resposta = "";
		this.valorDestaque = 0;
		this.tags = new ArrayList<>();
	}
	
	/**
	 * Constrói o item junto da resposta.
	 * @param pergunta A pergunta do item.
	 * @param resposta A resposta do item.
	 * @throws IllegalArgumentException A pergunta e a resposta não podem ser nulas e vazias.
	 */
	public Item(String pergunta, String resposta) throws IllegalArgumentException {
		if(pergunta == null || pergunta.isBlank())
			throw new IllegalArgumentException("Pergunta não pode ser um texto null nem vazio.");
		
		if(resposta == null || resposta.isBlank())
			throw new IllegalArgumentException("Resposta não pode ser um texto null nem vazio.");
		
		this.pergunta = pergunta;
		this.resposta = resposta;
		this.valorDestaque = 0;
		this.tags = new ArrayList<>();
	}
	
	/**
	 * Função para adicionar um ponto de destaque ao item.
	 */
	public void incrimentaDestaque() {
		this.valorDestaque++;
	}
	
	/**
	 * Adiciona uma nova tag (sem repetições e respeitando o limite de 3 tags). 
	 * @param novasTags Uma lista de tags para serem adicionadas.
	 */
	public void adicionaTag(String[] novasTags) {
		for(String tg : novasTags) {
			if(this.tags.size() >= 3)
				return;
			
			if(!this.tags.contains(tg))
				this.tags.add(tg);
		}	
	}
	
	/**
	 * Verifica se a tag ja existe njo item.
	 * @param tags
	 * @return
	 */
	public boolean contemTag(String[] tags) {
		for(String t : tags) {
			if(this.tags.contains(t))
				return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("Tags: [%s]\nPergunta: %s\nResposta: %s\nDestaque: %d", formataTags(), this.pergunta, this.resposta, this.valorDestaque);
	}
	
	/**
	 * Lê a pergunta do item.
	 * @return A pergunta do item.
	 */
	
	public String getPergunta() {
		return pergunta;
	}

	/**
	 * Lê a resposta do item.
	 * @return A String representando a resposta do item.
	 */
	public String getResposta() {
		return resposta;
	}
	
	/**
	 * Define uma nova resposta para o item.
	 * @param resposta A nova resposta do item.
	 */
	public void setResposta(String resposta) throws IllegalArgumentException{
		if(resposta == null || resposta.isBlank())
			throw new IllegalArgumentException("Resposta não pode ser um texto null nem vazio.");
	
		this.resposta = resposta;
	}
	
	/**
	 * Lê o valor de destaque do item.
	 * @return O valor inteiro do destaque.
	 */
	public int getValorDestaque() {
		return valorDestaque;
	}

	@Override
	public int hashCode() {
		return Objects.hash(pergunta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(pergunta, other.pergunta);
	}
	
	/**
	 * Formata as tags para a exibição.
	 * @return Uma string com a representação das tags.
	 */
	private String formataTags() {
		String texto = "";
		int i = 0;
		if(this.tags.size() > 0) {
			for(i = 0; i < this.tags.size() - 1; i++) {
				texto += this.tags.get(i) + ", ";
			}
			
			texto += this.tags.get(i);
		}
		return texto;
	}

	@Override
	public int compareTo(Item o) {
		if(this.valorDestaque > o.getValorDestaque())
			return -1;
		if(this.valorDestaque < o.getValorDestaque())
			return 1;
		
		return 0;
	}
}
