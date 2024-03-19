package br.edu.ufcg.computacao.p2lp2.coisa;

/**
* Representação da rotina de Descanso de um estudante, sendo analisado o 
* tempo de descanso em horas no decorrer de um número de semanas.
* Para 26h ou mais de descanso por semana, o aluno é dado como descansado,
* caso contrário, cansado.
* 
* @author Vinícius Gabriel Laureano
*/
public class Descanso {
	
	/**
	* Horas absolutas (inteiras) de descanso do aluno em um número de semanas.
	*/
	private int horasDescanso;
	
	/**
	* Semanas decorridas da rotina do aluno.
	*/
	private int numeroSemanas;
	
	/**
	* Constrói o controle de Descanso de um aluno.
	* Todo aluno começa com zero(0) horas de descanso, estando na sua primeira(1) semana de rotina.
	*/
	public Descanso() {
		this.horasDescanso = 0;
		this.numeroSemanas = 1;
	}
	
	/**
	 * Define o número de horas de descanso do aluno.
	 * 
	 * @param valor O valor inteiro representando o número de horas totais de descanso.
	 */
	public void defineHorasDescanso(int valor) {
		this.horasDescanso = valor;
	}
	
	/**
	 * Define o número de semanas decorridas.
	 * 
	 * @param valor O valor inteiro representando o número de semanas total.
	 */
	public void defineNumeroSemanas(int valor) {
		this.numeroSemanas = valor;
	}
	
	/**
	 * Calcula o status do aluno quanto a horas descansadas por semana.
	 * "descansado" para horas por semana >= 26.
	 * "cansado" para horas por semana < 26.
	 * 
	 * @return o status (cansado ou descansado) em String do aluno.
	 */
	public String getStatusGeral() {
		final int horasPorSemana = this.horasDescanso / this.numeroSemanas;
		if(horasPorSemana < 26) {
			return "cansado";
		}else {
			return "descansando";
		}
	}
}
