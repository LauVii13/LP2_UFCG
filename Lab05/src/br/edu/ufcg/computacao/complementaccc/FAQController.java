package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Classe que controla o FAQ e todas suas funcionalidades.
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 */
public class FAQController {
	/**
	 * Lista de itens (perguntas) que compõe o faq.
	 */
	private ArrayList<Item> faq;
	
	/**
	 * Constrói o controlador do faq.
	 */
	public FAQController() {
		this.faq = new ArrayList<>();
	}
	
	/**
	 * Adiciona um novo item ao faq.
	 * @param pergunta A pergunta a ser cadastra.
	 * @return Um booleano que indica se foi um sucesso a ação.
	 */
	public boolean adicionarItem(String pergunta) {
		Item novaPergunta = new Item(pergunta);
		if(existeItem(novaPergunta))
			return false;
		
		this.faq.add(novaPergunta);
		return true;
	}
	
	
	/**
	 * Adicona um novo item ao faq (porém com resposta).
	 * @param pergunta A pergunta a ser cadastrada.
	 * @param resposta A resosta a ser cadastra para a pergunta em questão.
	 * @return Um booleano que indica se foi um sucesso a ação.
	 */
	public boolean adicionarItem(String pergunta, String resposta) {
		Item novaPergunta = new Item(pergunta, resposta);
		if(existeItem(novaPergunta))
			return false;
		
		this.faq.add(novaPergunta);
		return true;
	}
	
	/**
	 * Altera a resposta de um item já cadastrado no sistema.
	 * @param itemIndex O index referente a posição que o item está cadastrado.
	 * @param resposta A nova resposta ao item.
	 * @return Um booleano que indica se foi um sucesso a ação.
	 * @throws IllegalArgumentException
	 */
	public boolean alterarRespostaItem(int itemIndex, String resposta) throws IllegalArgumentException {
		if(itemIndex > this.faq.size())
			throw new IllegalArgumentException("O índice não corresponde a nehum item cadastrado.");
		
		Item item = this.faq.get(itemIndex - 1);
		item.setResposta(resposta);
		return true;
	}
	
	/**
	 * Lista todos os itens salvos na lista de FAQs.
	 * @return Uma lista de strings com a representação de cada um dos itens de FAQ.
	 */
	public String[] listarFAQ() {
		String[] valores = new String[this.faq.size()];
		int cont = 0;
		for(Item i : this.faq) {
			valores[cont] = i.toString();
			cont++;
		}
		return valores;
	}
	
	/**
	 * Lista todos os itens salvos em FAQ ordenados por ordem de relevância.
	 * @return Uma lista de Strings com a representação de cada um dos itens de FAQ ordenados.
	 */
	public String[] listarFAQPorDestaque() {
		String[] valores = new String[this.faq.size()];
		
		ArrayList<Item> listaCopia = (ArrayList<Item>) this.faq.clone();
		Collections.sort(listaCopia);
		
		int cont = 0;
		for(Item i : listaCopia) {
			valores[cont] = i.toString();
			cont++;
		}
		return valores;
	}
	
	/**
	 * Adiciona um ponto de destaque no item indicado.
	 * @param itemIndex O índice do item cadastrado na lista.
	 * @return Um booleano que indica se a ação foi um sucesso ou não.
	 * @throws IllegalArgumentException Índice não existe na lista de itens do FAQ.
	 */
	public boolean destacarItem(int itemIndex) throws IllegalArgumentException{
		if(itemIndex > this.faq.size())
			throw new IllegalArgumentException("O índice não corresponde a nehum item cadastrado.");
		
		this.faq.get(itemIndex - 1).incrimentaDestaque();
		return true;
	}
	
	/**
	 * Atribui nova(s) tag(s) nova a um item do FAQ.
	 * @param itemIndex O índice do item que receberá a(s) tag(s).
	 * @param tags Uma lista de String com a(s) tag(s) a serem atribuídas ao item.
	 * @return Um boolean que indica se a ação foi um sucesso.
	 * @throws IllegalArgumentException Índice não existe na lista de itens do FAQ.
	 */
	public boolean atribuirTagsItemFAQ(int itemIndex, String[] tags) throws IllegalArgumentException{
		if(itemIndex > this.faq.size())
			throw new IllegalArgumentException("O índice não corresponde a nehum item cadastrado.");
		
		this.faq.get(itemIndex-1).adicionaTag(tags);
		return true;
	}
	
	/**
	 * Busca todos os itens de FAQ que possuam ao menos uma das tags solicitadas.
	 * @param tags Uma lista de tags que servirão de filtro aos itens.
	 * @return Uma lista de Strings com a representação textual de cada elemento da FAQ filtrado pelas tags.
	 */
	public String[] buscaItemFAQ(String[] tags) {
		String[] valores = new String[this.faq.size()];
		int cont = 0;
		for(Item i : this.faq) {
			if(i.contemTag(tags)) {
				valores[cont] = i.toString();
				cont++;
			}
		}
		
		String[] valoresPreenchidos = Arrays.copyOf(valores, cont);
		return valoresPreenchidos;
	}
	
	/**
	 * Verifica se existe um item ja cadastrado na lista de FAQ.
	 * @param pergunta A pergunta (item) a ser procurado na lista.
	 * @return Um boolean que indica a veracidade da verificação.
	 */
	private boolean existeItem(Item pergunta) {
		return this.faq.contains(pergunta);
	}
}
