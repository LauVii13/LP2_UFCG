package br.edu.ufcg.computacao.p2lp2.coisa;

/**
* Representação de um Resumo feito pelo aluno, sendo composto por um tema e um texto.
* 
* @author Vinícius Gabriel Laureano
*/
public class Resumo {
	
	/**
	* Tema do resumo.
	*/
	private String tema;

	/**
	* Texto que compõe o corpo do resumo.
	*/
	private String texto;

	/**
	* Constrói o Resumo com base em seu tema e texto.
	* 
	* @param tema O tema do Resumo.
	* @param texto O texto (corpo) do Resumo.
	*/
    public Resumo(String tema, String texto) {
        this.tema = tema;
        this.texto = texto;
    }

    /**
	 * Retorna uma String que representa o tema do Resumo.
	 * 
	 * @return o tema do Resumo em String.
	 */
	public String getTema() {
		return tema;
	}
	
	/**
	 * Retorna uma String que representa o texto do Resumo.
	 * 
	 * @return o texto do Resumo.
	 */
	public String getTexto() {
		return texto;
	}
}
