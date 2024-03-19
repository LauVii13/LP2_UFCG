package br.edu.ufcg.computacao.p2lp2.coisa;

/**
* Controle de Resumos realizados pelo aluno.
* Composto por uma lista de (n) Resumos. 
* @author Vinícius Gabriel Laureano
*/
public class RegistroResumos {
	
	/**
	* Array de Resumos cadastrados (Composto por um conjunto de objetos 'Resumo')
	*/
	private Resumo[] resumos;
	
	/**
	* indice no qual será salvo o próximo resumo.
	*/
	private int iResumo;
	
	/**
	* Constrói a área de registro dos resumos com base no numero de resumos.
	* O indice do resumo começa em zero.
	* @param numeroDeResumos O numero da capacidade total de resumos.
	*/
	RegistroResumos(int numeroDeResumos){
		this.resumos = new Resumo[numeroDeResumos];
		this.iResumo = 0;
	}
	
	/**
	* Cria um novo Resumo e adiciona-o ao Array de resumos na posição indicada
	* pelo índice.
	* @param tema O tema do Resumo.
	* @param resumo O conteúdo do Resumo (texto).
	*/
	public void adiciona(String tema, String resumo) {
		Resumo novoResumo = new Resumo(tema, resumo);
        this.resumos[this.iResumo] = novoResumo;
        
		this.iResumo++;
		if(this.iResumo >= this.resumos.length) {
			iResumo = 0;
		}
	}
	
	/**
	 * Retorna um Array de Strings composto por Strings que representam cada Resumo,
	 * na estrutura: "TEMA: RESUMO" para cada resumo cadastrado
	 * 
	 * @return um Array com Strings represetnando cada Resumo cadastrado.
	 */
	public String[] pegaResumos() {
		int espacoUsado = conta();
		String[] listaTemasResumos= new String[espacoUsado];
		
		for(int i = 0; i < espacoUsado; i++) {
			listaTemasResumos[i] = this.resumos[i].getTema() + ": " + this.resumos[i].getTexto();
		}
		
		return listaTemasResumos;
	}
	
	/**
	 * Retorna uma String sobre o total de resumos salvos e seus temas.
	 * Formato: "Resumos:
	 * - TOTAL resumo(s) cadastrado(s)
	 * - TEMA1 | TEMA2 | ..."
	 * 
	 * @return a representação em String dos temas cadastrados.
	 */
	public String imprimeResumos() {
		int espacoUsado = conta();
		StringBuffer textoSaida = new StringBuffer("- " + espacoUsado + " resumo(s) cadastrado(s)\n- ");
		
		for (int i = 0; i < espacoUsado - 1; i++) {
			textoSaida.append(this.resumos[i].getTema()).append(" | ");
		}
		
		if (espacoUsado > 0) {
			textoSaida.append(this.resumos[espacoUsado - 1].getTema());
		}
		
		return textoSaida.toString();
	}
	
	/**
	 * Conta e retorna quantos resumos do Array resumos estão preenchidos.
	 * 
	 * @return a quantidade total (inteira) de Resumos existentes em Array resumos.
	 */
	public int conta() {
		int i = 0;
		for(; i < this.resumos.length; i++) {
			if(this.resumos[i] == null) {
				break;
			}
		}
		return i;
	}
	
	/**
	 * Verifica se existe o resumo com base no tema recebido registrado e retorna
	 * Verdadeiro para existe e Falso para não existe.
	 * 
	 * @param tema O tema do resumo a ser verificado
	 * @return se existe ou não o tema em questão registrado.
	 */
	public boolean temResumo(String tema) {
		for(Resumo objResumo : this.resumos) {
			if(objResumo != null && objResumo.getTema().equals(tema)) {
				return true;
			}
		}
		return false;
	}

}
