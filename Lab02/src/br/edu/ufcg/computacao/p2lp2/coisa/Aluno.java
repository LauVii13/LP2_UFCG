package br.edu.ufcg.computacao.p2lp2.coisa;

/**
* Representação de um estudante, especificamente de computação, matriculado da 
* UFCG. Todo aluno precisa ter uma matrícula e é identificado unicamente
* por esta matrícula.
* 
* @author Vinícius Gabriel Laureano
*/
public class Aluno {
	
	/**
	* Nome do aluno.
	*/
	private String nome;
	
	/**
	* Ano de nascimento do aluno.
	*/
	private int anoNascimento;
	
	/**
	* CRA do aluno.
	*/
	private double cra;

	/**
	* Constrói um aluno a partir de sua matrícula e nome.
	* Todo aluno começa com o campo CRA como nulo.
	*
	* @param matricula a matrícula do aluno, no formato “0000000000”
	* @param nome o nome do aluno
	*/
	public Aluno(String nome, int anoNascimento) {
		this.nome = nome;
		this.cra = 0.0;
		this.anoNascimento = anoNascimento;
	}
	
	/**
	 * Define um novo valor para o cra do aluno.
	 * 
	 * @param cra O cra do Aluno.
	 */
	public void setCra(double cra) {
		this.cra = cra;
	}
	
	/**
	 * Retorna um inteiro que representa a idade do Aluno.
	 * Formato: 2024 - ano Nascimento.
	 * 
	 * @return o texto do Resumo.
	 */
	public int getIdade() {
		return 2024 - anoNascimento;
	}
	
	/**
	 * Retorna a String que representa o aluno. A representação segue o 
	 * formato “MATRICULA - Nome do Aluno”.
	 *
	 * @return a representação em String de um aluno.
	 */
	public String toString() {
		return "Aluno - "  + this.nome;
	}
}
