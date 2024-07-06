package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que define uma Atividade de Pesquisa de Extensão no sistema (com base na classe Atividade).
 * 
  * @author Vinícius Gabriel Laureano - 123111119
 */
public class AtividadePesquisaExtensao extends Atividade {
	/**
	 * O total de Unidade Acumulada de cada atividade.
	 */
	private int unidadeAcumulada;
	
	/**
	 * A disciplina referente a atividade.
	 */
	private String disciplina;
	
	/**
	 * Unidade Minima para pode receber créditos nessa atividade.
	 */
	private final int UNIDADEMIN = 12;
	
	/**
	 * Total de créditos para a ativiade de estágio.
	 */
	private final int CREDMAX = 18;
	
	/**
	 * Estrutura a Atividade Extensão.
	 * @param id O id da atividade (definido na superclasse Atividade).
	 * @param tipo O tipo da atividade (definido na superclasse Atividade).
	 * @param unidadeAcumulada Total de unidade (tempo) acumulado realizando essa atividade.
	 * @param disciplina A disciplina em que a atividade foi realizada.
	 * @throws IllegalArgumentException Disciplina não pode ser vazia nem nula.
	 */
	public AtividadePesquisaExtensao(String id, String tipo, int unidadeAcumulada, String disciplina) throws IllegalArgumentException{
		super(id, tipo);
		if(disciplina == null || disciplina.isBlank())
			throw new IllegalArgumentException("Disciplina não pode ser nulo e nem vazio.");
		
		this.unidadeAcumulada = unidadeAcumulada;
		this.disciplina = disciplina;
		inicializaCreditos();
	}
	
	@Override
	public int getValorAcumulado() {
		return unidadeAcumulada;
	}
	
	@Override
	protected double calculaCreditos() {
		double valor = (unidadeAcumulada * 10) / 12;
		return verificaCreditos(valor);
	}
	
	@Override
	protected double verificaCreditos(double valorCalculado) {
		if(unidadeAcumulada < UNIDADEMIN)
			return 0;
		if(valorCalculado >= CREDMAX)
			return CREDMAX;
		return valorCalculado;
	}
	
	@Override
	public String toString() {
		return String.format("Disciplina: %s\n%s", this.disciplina, super.toString());
	}
}
