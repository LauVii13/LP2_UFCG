package filmnow;

/**
 * Sistema que mantém os seus filmes prediletos. Podem existir 100 filmes. 
 * 
 * @author eliane
 *
 */
public class FilmNow {
	
	/**
	* Total de filmes possíveis a cadastrar no sistema.
	* Como temos da posição 1 à 100, temos 100 de TOTFILMES (indice 0 - 99).
	*/
	private static final int TOTFILMES = 100;
	
	
	/**
	* Total de filmes possíveis a cadastrar na lista de prioridade.
	* Como temos da posição 1 à 10, temos 10 de TOTFILMES (indice 0 - 9).
	*/
	private static final int TOTHOTLIST = 10;
	
	/**
	* lista de filmes.
	*/
	private Filme[] filmes;
	
	/**
	 * Lista de filmes de maior prioridade
	 */
	private Filme[] hotList;

	/**
	 * Cria o FilmNow.
	 */
	public FilmNow() {
		this.filmes = new Filme[TOTFILMES];
		this.hotList = new Filme[TOTHOTLIST];
	}
	
	/**
	 * Acessa a lista de filmes mantida.
	 * @return O array de Strings com o nome de cada filme em sua respectiva posição.
	 */
	public Filme[] getFilmes() {
		return this.filmes.clone();
	}
	
	public Filme[] getHotFilmes() {
		return this.hotList.clone();
	}
	
	/**
	 * Acessa os dados de um filme específico.
	 * @param posicao Posição do filme no sistema.
	 * @return Dados do filme. Null se não há filme na posição.
	 */
	public String getFilme(int posicao) {
		try {
			return filmes[posicao-1].toString();			
		}
		catch(NullPointerException ex) {
			return "";
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			return "POSIÇÃO INVÁLIDA";
		}
	}

	/**
	 * Adiciona um filme em uma posição. Se já existir filme na posição, sobrescreve o anterior, não permitindo 
	 * a criação de filmes com mesmo nome e ano. 
	 * @param posicao Posição do filme.
	 * @param nome Nome do filme.
	 * @param ano Ano de lançamento do filme.
	 * @param local Local onde o filme pode ser assitido.
	 * @return A situação do cadastro do filme em formato de texto (adicionado ou deu erro).
	 */
	public String cadastraFilme(int posicao, String nome, String ano, String local){
		posicao--;
		Filme novoFilme;
		
		try {
			novoFilme = new Filme(nome, ano, local);
			verificaFilme(novoFilme);
			
			this.filmes[posicao] = novoFilme;
			return "FILME ADICIONADO";
			
		}catch(IllegalArgumentException ex) {
			return ex.getMessage();
		}catch(ArrayIndexOutOfBoundsException ex) {
			return "POSIÇÃO INVÁLIDA";
		}
		
	}
	
	/**
	 *  Adiciona um filme da lista de filmes na lista de prioridades (hotList).
	 * @param posicaoFilme A posição do filme na lista de filmes.
	 * @param posicaoHotList A posição desejada para adicionar o filme na hotlist.
	 * @return Uma String sobre erros da ação de adicionar à HotList ou sobre o sucesso da mesma.
	 */
	public String adicionaHotList(int posicaoFilme, int posicaoHotList){
		if (posicaoFilme < 1 || posicaoFilme > 100 || posicaoHotList < 1 || posicaoHotList > 10) {
			return "POSIÇÃO INVÁLIDA";
		}
		posicaoFilme--;
		posicaoHotList--;
		if(this.filmes[posicaoFilme] == null) {
			return "FILME INVÁLIDO";
		}
		
		this.hotList[posicaoHotList] = this.filmes[posicaoFilme];
		this.filmes[posicaoFilme].setEhHot(true);
		return "ADICIONADO À HOTLIST NA POSIÇÃO " + (posicaoHotList+1) +"!";
	}
	
	/**
	 * Remove um filme específico da lista de prioridade (hotList).
	 * @param posicaoHotList A posição do filma na hotList.
	 * @return Uma String com a informação se o filme foi removido com sucesso ou não da HotList.
	 */
	public String removeHotList(int posicaoHotList){
		if (posicaoHotList < 1 || posicaoHotList > 10) {
			return "POSIÇÃO INVÁLIDA\n";
		}
		posicaoHotList--;
		
		if(this.hotList[posicaoHotList] == null) {
			return "FILME INVÁLIDO\n";
		}
		
		this.hotList[posicaoHotList].setEhHot(false);
		this.hotList[posicaoHotList] = null;
		return "";
	}
	
	/**
	 * Verifica se o filme já está cadastrado na lista (identificação por nome + ano).
	 * Caso já exista, lança uma exceção.
	 * @param novoFilme Filme a ser verificado se já existe.
	 * @throws IllegalArgumentException Erro para o caso do filme já existir na lista.
	 */
	private void verificaFilme(Filme novoFilme) throws IllegalArgumentException{
		for (Filme f: this.filmes) {
			if(novoFilme.equals(f)) {
				throw new IllegalArgumentException("FILME JA ADICIONADO");
			}
		}
	}
	
	
}
