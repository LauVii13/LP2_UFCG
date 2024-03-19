package br.edu.ufcg.computacao.p2lp2.coisa;

/**
* Controle da quantidade de horas na internet que o aluno dedica às 
* aulas online, sendo desejável que esse seja o dobro do tempo de
* duração da disciplina em questão.
* 
* @author Vinícius Gabriel Laureano
*/
public class RegistroTempoOnline {
	/**
	* Nome da disciplina para qual será dedidaco o tempo de estudo.
	*/
	private String nomeDisciplina;
	
	/**
	* Total de horas investidas pelo aluno em estudo.
	*/
	private int horasInvestidas;
	
	/**
	* tempo esperado de dedicação do aluno para esse estudo.
	*/
	private int tempoOnlineEsperado;
	
	/**
	* Constrói o controle de Registro de Tempo Online de um aluno a partir do nome da disciplina.
	* Por padrão, o tempo esperado de estudo online de um aluno é de 120 horas
	* e sem horas dedicadas ao estudo.
	* 
	* @param nomeDisciplina O nome da disciplina estudada.
	*/
	public RegistroTempoOnline(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = 120;
		this.horasInvestidas = 0;
	}
	
	/**
	* Constrói o controle de Registro de Tempo Online de um aluno com base no
	* nome da disciplina e o tempo online esperado de dedicação.
	* O tempo investido inicia-se em zero.
	* @param nomeDisciplina O nome da disciplina estudada.
	* @param tempoOnlineEsperado O tempo online esperado de dedicação do aluno
	*/
	public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
		this.nomeDisciplina = nomeDisciplina;
		this.tempoOnlineEsperado = tempoOnlineEsperado;
		this.horasInvestidas = 0;
	}
	
	/**
	 * Adiciona a contagem de tempo online dedicado pelo aluno à uma matéria.
	 * 
	 * @param tempo O tempo em horas inteiras de estudo online.
	 */
	public void adicionaTempoOnline(int tempo){
		this.horasInvestidas += tempo;
	}
	
	/**
	 * Verifica se um aluno cumpriu ou não com a meta de tempo de estudo online esperada.
	 * 
	 * @return Análise booleana se o aluno atingiu a meta de tempo online prevista.
	 */
	public boolean atingiuMetaTempoOnline() {
		return this.horasInvestidas >= this.tempoOnlineEsperado;
	}
	
	/**
	 * Retorna uma String que representa o tempo online de um aluno.
	 * Segue o formato "Nome da disciplina Tempo Investido / Tempo Esperado". 
	 * 
	 * @return a representação em String dos resgistros de tempo de estudo online do aluno.
	 */
	@Override
	public String toString() {
		return (this.nomeDisciplina + " " + this.horasInvestidas + "/" + this.tempoOnlineEsperado);
	}

}
