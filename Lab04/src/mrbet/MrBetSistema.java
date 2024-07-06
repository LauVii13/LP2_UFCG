package mrbet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * Sistema que mantém as apostas nos times em diferentes campeonatos.
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 *
 */
public class MrBetSistema {
	/**
	* Mapa de times cadastrados no sistema.
	* Usa a String código do time (identificador único) como chave do mapa, e aponta para um objeto Time. 
	*/
	private HashMap<String, Time> times;
	
	/**
	* Mapa de campeonatos cadastrados no sistema.
	* Usa a String nome(identificador único) como chave do mapa, e aponta para um objeto Campeonato. 
	*/
	private HashMap<String, Campeonato> campeonatos;
	
	/**
	* Um ArrayList para salvar as apostas feitas no sistema sequencialmente. 
	*/
	private ArrayList<Aposta> apostas;
	
	/**
	* Cria sistema MrBet. 
	*/
	public MrBetSistema() {
		this.times = new HashMap<>();
		this.campeonatos = new HashMap<>();
		this.apostas = new ArrayList<>();
	}
	
	/**
	 * Cadastra um novo Time.
	 * @param id O código identificador do Time.
	 * @param nome O nome do Time.
	 * @param mascote O mascote do Time.
	 * @return Uma representação em String do status do cadastro.
	 */
	public String cadastrarTime(String id, String nome, String mascote) {
		Time novoTime = new Time(id, nome, mascote);
		
		if(!existeTime(id)) {
			times.put(id, novoTime);
			return "INCLUSÃO REALIZADA!";
		}else
			return "TIME JÁ EXISTE!";		
	}
	
	/**
	 * Busca o cadastro de um Time no sistema, com base no seu código identificador.
	 * @param id O código identificador do Time.
	 * @return uma representação em String do Time cadastrado (Caso não exista, retorna "TIME NÃO EXISTE!").
	 */
	public String recuperarTime(String id) {
		if(existeTime(id)) {
			return this.times.get(id).toString();
		}
		return "TIME NÃO EXISTE!";
	}
	
	/**
	 * Cadastra um novo Campeonato no sistema.
	 * @param nome O nome do campeonato.
	 * @param participantes O total de times que podem participar do Campeonato.
	 * @return Uma representação em String da situação do cadastro.
	 */
	public String cadastrarCampeonato(String nome, int participantes) {
		Campeonato novoCampeonato = new Campeonato(nome, participantes);
		
		if(!existeCampeonato(nome)) {
			campeonatos.put(nome, novoCampeonato);
			return "CAMPEONATO ADICIONADO!";
		}
		return "CAMPEONATO JÁ EXISTENTE!";
	}
	
	/**
	 * Adiciona um Time em um Campeonato.
	 * @param codigoTime O código identificador do time que será adicionado.
	 * @param nomeCampeonato O nome do Campeonato em que o Time vai participar.
	 * @return Uma representação em String da situação da inclusão.
	 */
	public String incluirTimeCampeonato(String codigoTime, String nomeCampeonato) {
		if(!existeTime(codigoTime))
			return "O TIME NÃO EXISTE!";
		
		if(!existeCampeonato(nomeCampeonato))
			return "O CAMPEONATO NÃO EXISTE!";
		
		if(limiteExcedido(nomeCampeonato))
			return "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!";
		
		this.campeonatos.get(nomeCampeonato).adicionarTime(codigoTime, this.times.get(codigoTime));
		return "TIME INCLUÍDO NO CAMPEONATO!";
	}
	
	/**
	 * Verifica se um time está no campeonato.
	 * @param codigoTime O código do Time a ser buscado.
	 * @param nomeCampeonato O nome do Campeonato que será verificado.
	 * @return Uma String para informar o resultado da verificação.
	 */
	public String verificarTimeCampeonato(String codigoTime, String nomeCampeonato) {
		if(!existeTime(codigoTime))
			return "O TIME NÃO EXISTE!";
		
		if(!existeCampeonato(nomeCampeonato))
			return "O CAMPEONATO NÃO EXISTE!";
		
		if(!timeNoCampeonato(codigoTime, nomeCampeonato))
			return "O TIME NÃO ESTÁ NO CAMPEONATO!";
		
		return "O TIME ESTÁ NO CAMPEONATO!";
	}
	
	/**
	 * Exibe os campeonatos em que o Time está participando.
	 * @param codigoTime O código identificador do Time.
	 * @return Uma String com os campeonatos que o Time está inscrito.
	 */
	public String exibeCampeonatosTime(String codigoTime) {
		if(!existeTime(codigoTime))
			return "O TIME NÃO EXISTE!";
		
		Set<String> chaves = this.campeonatos.keySet();
		StringBuffer texto = new StringBuffer();
		
		texto.append("Campeonatos do " + this.times.get(codigoTime).getNome() + ":\n");
		
		for(String chave : chaves) {
			if(timeNoCampeonato(codigoTime, chave)) {
				texto.append("* " + this.campeonatos.get(chave)).append("\n");
			}
		}
		return texto.toString();
	}
	
	/**
	 * Adiciona uma Aposta.
	 * @param codigoTime O código do Time que foi apostado.
	 * @param nomeCampeonato O campeonato em que foi feito a Aposta.
	 * @param posicao A posição que Time terminará o Campeonato de acordo com a aposta.
	 * @param valor O valor em reais da Aposta.
	 * @return Uma String que representa a situação da Aposta adicionada.
	 */
	public String fazAposta(String codigoTime, String nomeCampeonato, int posicao, double valor) {
		if(!existeTime(codigoTime))
			return "O TIME NÃO EXISTE!";
		
		if(!existeCampeonato(nomeCampeonato))
			return "O CAMPEONATO NÃO EXISTE!";
		
		if(!timeNoCampeonato(codigoTime, nomeCampeonato))
			return "O TIME NÃO ESTÁ NO CAMPEONATO!";
		
		if(excedeLimite(nomeCampeonato, posicao))
			return "APOSTA NÃO REGISTRADA!";
		
		Aposta novaAposta = new Aposta(this.times.get(codigoTime), this.campeonatos.get(nomeCampeonato), posicao, valor);
		this.apostas.add(novaAposta);
		return "APOSTA REGISTRADA!";
	}
	
	/**
	 * Busca todas as Apostas realizadas.
	 * @return Uma representação da lista(ArrayList), em String, das Apostas cadastradas.
	 */
	public String statusApostas() {
		StringBuffer texto = new StringBuffer();
		
		int contador = 1;
		for(Aposta a : apostas) {
			texto.append(contador + ". " + a).append("\n");
			contador++;
		}
		
		return texto.toString();
	}
	
	/**
	 * Verifica se o Time já está cadastrado no HashMap pelo seu código identificador.
	 * @param id O código verificador do Time.
	 * @return Um boolean, true para caso o Time ja esteja cadastrado, e false para caso contrário.
	 */
	private boolean existeTime(String id) {
		return this.times.containsKey(id);
	}
	
	/**
	 * Verifica se o Campeonato já está cadastrado no HashMap pelo seu nome (identificador).
	 * @param id O nome que identifica o Campeonato.
	 * @return Um boolean, true para caso o Campeonato já esteja cadastrado, e false para caso contrário.
	 */
	private boolean existeCampeonato(String id) {
		return this.campeonatos.containsKey(id);
	}
	
	/**
	 * Verifica se o limite de times do campeonato já foi excedido.
	 * @param id O nome (identificador) do Campeonato ser verificado.
	 * @return Um boolean, true para caso o total de times cadastrados seja = limite permitido, false caso contrário.
	 */
	private boolean limiteExcedido(String id) {
		return this.campeonatos.get(id).limiteExcedido();
	}
	
	/**
	 * Verifica se um Time já está incluso em um Campeonato.
	 * @param codigoTime O código identificador do Time.
	 * @param nomeCampeonato O nome (identificador) do Campeonato.
	 * @return Um boolean, true para caso o Time já esteja incluso no Campeonato, false caso contrário.
	 */
	private boolean timeNoCampeonato(String codigoTime, String nomeCampeonato) {
		return this.campeonatos.get(nomeCampeonato).verificarTime(codigoTime);
	}
	
	/**
	 * Verifica se a posição indicada ao apostar vai além do limite de participantes do campeonato.
	 * @param nomeCampeonato O nome (identificador) do Campeonato.
	 * @param posicao A posição na qual foi apostado que um Time terminará o campeonato.
	 * @return Um boolean, true para caso posição apostada seja maior que o limite de times, false caso contrário.
	 */
	private boolean excedeLimite(String nomeCampeonato, int posicao) {
		return posicao > this.campeonatos.get(nomeCampeonato).getLimiteParticipantes();
	}
}
