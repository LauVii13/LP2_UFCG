package br.edu.ufcg.computacao.p2lp2.coisa;

/**
* Representação de uma Disciplina e o progresso do aluno na mesma, 
* por meio de 4 notas e tempo de destudo dedicado.
* O aluno é dado como aprovado com uma média maior ou igual a 7.0.
* 
* @author Vinícius Gabriel Laureano
*/
public class Disciplina {
	
	/**
	* Nome da Disciplina em questão.
	*/
	private String nome;
	
	/**
	* Horas inteiras acumuladas de estudo.
	*/
	private int horasEstudo;
	
	/**
	* Array das notas do aluno na Disciplina em questão.
	*/
	private double[] notas; 
	
	/**
	* Constrói a Disciplina a partir de seu nome.
	* Todo aluno começa com zero(0) horas dedicadas ao estudo, e possui espaço para 
	* cadastrar até 4 notas. 
	* 
	* @param nomeDisciplina O nome da disciplina em questão.
	*/
	public Disciplina(String nomeDisciplina) {
		this.nome = nomeDisciplina;
		this.horasEstudo = 0;
		this.notas = new double[4];
	}
	
	/**
	 * Atribui horas a mais de estudo do aluno ao total de horas estudadas.
	 * 
	 * @param horas As horas a mais que o aluno estudou.
	 */
	public void cadastraHoras(int horas) {
		this.horasEstudo += horas;
	}
	
	/**
	 * Cadastra a nota do aluno no Array de acordo com o numero correspondente da prova.
	 * 
	 * @param nota Indica qual nota será atribuida ao Array de forma posicional (primeira, segunda, ...).
	 * @param valorNota O valor da nota da prova do aluno em ponto flutuante. 
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota-1] = valorNota;
	}
	
	/**
	 * Calcula e retorna se o aluno foi aprovado na disciplina.
	 * Verdadeiro para média maior ou igual a 7.0.
	 * Falso para média menor que 7.0.
	 * 
	 * @return Análise booleana se o aluno foi aprovado ou não na disciplina. 
	 */
	public boolean aprovado() {
		double media = calculaMedia();
		return  media >= 7.0;
	}
	
	/**
	 * Calcula e retorna a média aritmética das 4 notas do aluno na disciplina.
	 * 
	 * @return A média em ponto flutuante. 
	 */
	private double calculaMedia() {
		double soma = 0;
		
		for(double nota : this.notas) {
			soma += nota;
		}
		return (soma / 4);
	}
	
	/**
	 * Retorna uma String que representa os dados do aluno na Disciplina, 
	 * no formato "DISCIPLINA Tempo Investido Média [Notas]", sendo média e as notas
	 * com apenas uma casa decimal e ponto de marcação decimal, e a lista de notas com essas separadas
	 * por vírgula.
	 * Segue o formato "Nome da disciplina Tempo Investido / Tempo Esperado". 
	 * 
	 * @return a representação em String dos resgistros do desempenho do aluno na Disciplina.
	 */
	@Override
	public String toString() {
		 String mediaFormatada = String.format("%.1f", calculaMedia()).replace(',', '.');

		 StringBuilder notasString = new StringBuilder("[");
		 
		 for (int i = 0; i < notas.length; i++) {
			 notasString.append(String.format("%.1f", notas[i]).replace(',', '.'));
		     if (i < notas.length - 1) {
		    	 notasString.append(", ");
		     }
		 }
		    notasString.append("]");

		    return nome + " " + horasEstudo + " " + mediaFormatada + " " + notasString.toString();
	}	
}
