package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Classe que define um Relatório e suas funcionalidades.
 * 
  * @author Vinícius Gabriel Laureano - 123111119
 */
public abstract class Relatorio {
	/**
	 * Dados do estudante para o qual foi gerado o relatório.
	 */
	protected Estudante dadosEstudante;
	
	/**
	 * Lista de atividades do relatório.
	 */
	protected ArrayList<Atividade> atividades;
	
	/**
	 * Constrói o padrão do relatório.
	 * @param e Estudante que gerou a atividade.
	 */
	public Relatorio(Estudante e) {
		this.dadosEstudante = e;
		this.atividades = new ArrayList<>();
	}
	
	/**
	 * Adiciona atividade ao relatorio.
	 * @param atv Objeto atividade para ser adiciona na lista.
	 */
	public void adicionaAtividade(Atividade atv) {
		atividades.add(atv);
		ordenaAtividades();
	}
	
	/**
	 * Lê o tamanho da lista de atividades.
	 * @return O valor inteiro do tamanho da lista de atividades.
	 */
	public int totalAtv() {
		return this.atividades.size();
	}
	
	/**
	 * Ordena a lista de atividades baseada no tipo (definida no comparador).
	 */
	private void ordenaAtividades() {
		Collections.sort(atividades, new AtividadeComparator());
	}
	
}
