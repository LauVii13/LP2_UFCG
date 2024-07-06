package mrbet;

/**
 * Classe que define a estrutura de cada aposta.
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 *
 */
public class Aposta {
	
	/**
	* Time escolhido na aposta.
	*/
	private Time timeApostado;
	
	/**
	* Campeonato no qual a aposta foi realizada.
	*/
	private Campeonato campeonatoApostado;
	
	/**
	* Colocação em que foi apostado que o time terminará o campeonato.
	*/
	private int colocacao;
	
	/**
	* Valor da aposta, em reais.
	*/
	private double valor;
	
	
	/**
	* Constrói a Aposta que foi realizada.
	* @param timeApostado O time em que foi feita a aposta.
	* @param campeonatoApostado O campeonato em que a está o time apostado.
	* @param colocacao A colocação em que foi apostado em que o time terminará o campeonato.
	* @param valor O valor (em real) apostado pelo usuário.
	*/
	public Aposta(Time timeApostado, Campeonato campeonatoApostado, int colocacao, double valor) {
		this.timeApostado = timeApostado;
		this.campeonatoApostado = campeonatoApostado;
		this.colocacao = colocacao;
		this.valor = valor;
	}
	
	/**
	 * Retorna uma String que representa os detalhes da aposta realizada. 
	 * Formato:
	 * TIME
	 * CAMPEONATO
	 * COLOCACAO / TOTAL TIMES NO CAMPEONATO
	 * R$ VALOR
	 * @return a representação em String do registro da aposta do usuário.
	 */
	@Override
	public String toString() {
		return String.format("%s\n%s\n%d/%d\nR$%.2f\n", 
				this.timeApostado, 
				this.campeonatoApostado.getNome(), 
				this.colocacao, 
				this.campeonatoApostado.getLimiteParticipantes(), 
				this.valor);			
	}
}
