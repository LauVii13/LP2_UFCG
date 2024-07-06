package br.edu.ufcg.computacao.complementaccc;
/**
 * Classe Abstrata que define a estrutura e métodos geral das Atividades do sistema (com base na classe Atividade).
 * 
  * @author Vinícius Gabriel Laureano - 123111119
 */
public abstract class Atividade {
	/**
	 * Identificador único da Atividade, baseado no cpf do usuário que está adicionando a tarefa.
	 * Formato: cpfUsuario_Index
	 */
	private String id;
	
	/**
	 * O tipo de Atividade.
	 * Varia entre: estagio, monitoria, pesquisa_extensao, projeto (Periódico ou Conferência).
	 */
	private String tipo;
	
	/**
	 * A descrição textual da atividade.
	 */
	private String descricao;
	
	/**
	 * O comprovante de realização da atividade.
	 */
	private String comprovante;
	
	/**
	 * Os créditos recebidos gerados por essa atividade nas suas especificações.
	 */
	private double creditos;
	
	/**
	 * Constrói a atividade.
	 * @param id O identificador da atividade.
	 * @param tipo O tipo de atividade a qual se refere.
	 * @throws IllegalArgumentException 'Tipo' não pode ser nulo ou vazio.
	 */
	public Atividade(String id, String tipo) throws IllegalArgumentException {
		this.id = id;
		
		if(tipo == null || tipo.isBlank())
			throw new IllegalArgumentException("Tipo não pode ser nulo e nem vazio.");
		
		this.tipo = tipo;
		this.descricao = "";
		this.comprovante = "";
		this.creditos = 0;
	}

	/**
	 * Pega a descrição textual da atividade.
	 * @return A String que representa a descrição da atividade.
	 */
	public String getDescricao(){
		return descricao;
	}
	
	/**
	 * Define a descrição da atividade.
	 * @param descricao A descrição a ser atribuída.
	 * @throws IllegalArgumentException Descrição não pode ser nula ou vazia.
	 */
	public void setDescricao(String descricao) throws IllegalArgumentException{
		if(descricao == null || descricao.isBlank())
			throw new IllegalArgumentException("Descricao não pode ser nulo e nem vazio.");
		this.descricao = descricao;
	}
	
	/**
	 * Define o comprovante da atividade.
	 * @param comprovante O novo comprovante a ser adicionado à atividade.
	 * @throws IllegalArgumentException Comprovante não pode ser nulo ou vazio.
	 */
	public void setComprovante(String comprovante) throws IllegalArgumentException{
		if(comprovante == null || comprovante.isBlank())
			throw new IllegalArgumentException("Comprovante não pode ser nulo e nem vazio.");
		this.comprovante = comprovante;
	}

	/**
	 * Lê o id da atividade.
	 * @return Uma representacao em String do id da ativiade.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Lê o tipo da atividade.
	 * @return Uma representação em String do tipo da atividade.
	 */
	public String getTipo() {
		return tipo;
	}	
	
	/**
	 * Lê os creditos gerados pela atividade.
	 * @return Um valor Double referente a quantidade de créditos gerados pela atividade.
	 */
	public double getCreditos() {
		return creditos;
	}
	
	/**
	 * Método que invoca o cálculo de créditos no sistema.
	 */
	protected void inicializaCreditos() {
	    this.creditos = calculaCreditos();
	}
	
	/**
	 * Representação textual da atividade.
	 */
	@Override
	public String toString() {
		return String.format("Descrição: %s\nComprovante: %s\nCreditos na atividade: %.0f\n", this.descricao, this.comprovante, this.creditos);
	}
	
	/**
	 * Metodo para calcular Creditos de acordo com a respectiva atividade
	 * 
	 * @return O total de créditos concebidos pela atividade.
	 */
	protected abstract double calculaCreditos();
	
	/**
	 * Verifica se atingiu o valor mínimo ou maximo de credito de acordo com cada requisito de cada atividade.
	 * @param valorCalculado O valor de créditos calculado previamentes sem verificação.
	 * @return O valor final de créditos recebidos apos filtrar minimo e máximo.
	 */
	protected abstract double verificaCreditos(double valorCalculado);
	
	/**
	 * Recebe o valor acumulado de cada atividade para calculo.
	 * @return
	 */
	protected abstract int getValorAcumulado();
}
