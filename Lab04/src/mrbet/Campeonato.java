package mrbet;

import java.util.HashMap;
import java.util.Objects;

/**
 * Classe que define a estrutura de cada campeonato existente no sistema.
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 *
 */
public class Campeonato {
	/**
	* Nome do campeonato (identificação única).
	*/
	private String nome;
	
	/**
	* Número que define o total de times que podem participar do campeonato.
	*/
	private int limiteParticipantes;
	
	/**
	* Mapa que salva todos os times participantes do campeonato.
	* Mapeado com base no CODIGO DO TIME (String de identificação única de time) como chave, e o próprio TIME como valor.
	*/
	private HashMap<String, Time> times;

	/**
	* Constrói um novo campeonato no sistema.
	* O mapa de times inicia-se sem times.
	* @param nome O nome do campeonato que está sendo criado.
	* @param limiteParticipantes O valor inteiro referente à capacidade de times no campeonato.
	*/
	public Campeonato(String nome, int limiteParticipantes) {
		this.nome = nome;
		this.limiteParticipantes = limiteParticipantes;
		this.times = new HashMap<>();
	}
	
	/**
	* Verifica se o limite de times cadastrados foi excedido,
	* com base no tamanho do mapa de times e no limite de participantes no campeonato.
	* @return um booleano indicado se o limite foi excedido (true) ou não (false).
	 */
	public boolean limiteExcedido() {
		return this.times.size() >= this.limiteParticipantes ;
	}
	
	/**
	* Adiciona um novo time no mapa de times do campeonato.
	* @param codigoTime O código em String do time que será cadastrado (usado como chave do HashMap).
	* @param novoTime O objeto Time que participará do campeonato (salvo no valor correspondente do HashMap).
	*/
	public void adicionarTime(String codigoTime, Time novoTime) {
		this.times.put(codigoTime, novoTime);
	}
	
	/**
	* Verifica, por meio do código do time, se o mesmo já existe no mapa de times. 
	* @param codigoTime O código chave do time a ser buscado.
	* @return true para caso o time com o código em questão esteja no mapa de times, caso contrário, false.
	*/
	public boolean verificarTime(String codigoTime) {
		return this.times.containsKey(codigoTime);
	}
	
	
	/**
	* Método para pegar o limite de participantes no campeonato.
	 * @return O limite (inteiro) de participantes no campeonato.
	*/
	public int getLimiteParticipantes() {
		return limiteParticipantes;
	}
	
	/**
	* Método para pegar o nome do campeonato.
	 * @return O nome (String) do campeonato.
	*/
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna uma String que representa os detalhes do campeonato. 
	 * Formato:
	 * NOME CAMPEONATO - TOTAL DE PARTICIPANTES NO MOMENTO/LIMITE DE PARTICIPANTES
	 * @return A representação em String do Campeonato no momento.
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.times.size() + "/" + this.limiteParticipantes ;
	}
	
	/**
	 * Gerador do código hash do objeto campeonato (com base no nome do mesmo).
	 * @return Código hash (inteiro).
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}
	
	/**
	 * Método de comparação de Campeonatos.
	 * Verdadeiro para campeonatos iguais.
	 * Falso para campeonatos diferentes.
	 * @return Booleano da comparação entre dois campeonatos com base em seus nomes.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campeonato other = (Campeonato) obj;
		return Objects.equals(nome.toUpperCase(), other.nome.toUpperCase());
	}
}
