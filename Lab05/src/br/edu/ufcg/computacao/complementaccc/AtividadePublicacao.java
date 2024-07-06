package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que define uma Atividade de Publicação no sistema (com base na classe Atividade).
 * 
  * @author Vinícius Gabriel Laureano - 123111119
 */
public class AtividadePublicacao extends Atividade{
	/**
	 * O titulo do artigo publicado.
	 */
	private String tituloArtigo;
	
	/**
	 * Identificador Digital de objetos.
	 */
	private String doi;
	
	/**
	 * O Código (Qualis) da atividade com referencia da CAPES na área de ciencia da computação.
	 */
	private String qualis;
	
	
	/**
	 * Constrói uma Atividade de Publicação.
	 * @param id O id da atividade (definido na superclasse Atividade).
	 * @param tipo O tipo da atividade (definido na superclasse Atividade).
	 * @param tituloArtigo O titulo do artigo publicado.
	 * @param doi O DOI do artigo publicado.
	 * @param qualis O codigo Qualis do artigo publicado.
	 * @throws IllegalArgumentException Qualis, Título, Doi, não podem ser vazio, Tipo deve ser ou periódico ou Conferência.
	 */
	public AtividadePublicacao(String id, String tipo, String tituloArtigo, String doi, String qualis) throws IllegalArgumentException{
		super(id, tipo);
		if(tituloArtigo == null || tituloArtigo.isBlank())
			throw new IllegalArgumentException("Título do artigo não pode ser nulo e nem vazio.");
		if(doi == null || doi.isBlank())
			throw new IllegalArgumentException("Doi não pode ser nulo e nem vazio.");
		if(qualis == null || qualis.isBlank())
			throw new IllegalArgumentException("Qualis não pode ser nulo e nem vazio.");
		
		if(!tipo.equals("Conferência") && !tipo.equals("Periódico"))
			throw new IllegalArgumentException("Tipo não identificado.");
		
		this.tituloArtigo = tituloArtigo;
		this.doi = doi;
		this.qualis = qualis;
		inicializaCreditos();
	}
	
	@Override
	protected double calculaCreditos() {
		double valor = selecionaCreditoQualis();
		return verificaCreditos(valor);
	}
	
	@Override
	protected double verificaCreditos(double valorCalculado) {
		return valorCalculado;
	}
	
	/**
	 * Lê o total de creditos para cada Qualis em cada tipo de Publicação.
	 * @return o valor de créditos referente a cada qualis.
	 * @throws IllegalArgumentException Qualis não compõe as opções existentes.
	 */
	private double selecionaCreditoQualis() throws IllegalArgumentException{
		double credito = 0;
		switch(this.qualis) {
		case "A1":
			credito = 4;
			break;
		case "A2":
			credito = 4;
			break;
		case "A3":
			credito = 3;
			break;
		case "A4":
			credito = (this.getTipo().equals("Conferencia") ? 2 : 1);
			break;
		case "B1":
			credito = (this.getTipo().equals("Conferencia") ? 2 : 1);
			break;
		default:
			throw new IllegalArgumentException("Qualis não identificado.");
		}
		
		if(this.getTipo().equals("Conferência"))
			credito--;
		return credito;
	}
	
	@Override
	public int getValorAcumulado() {
		return 1;
	}
	
	@Override
	public String toString() {
		return String.format("Título do Artigo: %s\nDOI: %s\nQualis: %s\n%s", this.tituloArtigo, this.doi, this.qualis , super.toString());
	}
}
