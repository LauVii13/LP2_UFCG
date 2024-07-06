package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Objects;

/**
 * Classe que define um Estudante e suas funcionalidades, se extendendo da classe de Usuário do sistema.
 * 
  * @author Vinícius Gabriel Laureano - 123111119
 */
public class Estudante extends Usuario{
	/**
	 * A matrícula em formato de texto do estudante.
	 */
	private String matricula;
	
	/**
	 * Lista de atividades realizadas pelo estudante em questão.
	 */
	private ArrayList<Atividade> atividades;
	
	/**
	 * Os relatórios gerados referente às atividades.
	 */
	private ArrayList<Relatorio> relatorios;
	
	/**
	 * Constrói um estudante no sistema
	 * @param nome O nome Estudante (Estruturado em Usuário).
	 * @param cpf O cpf do Estudante (Estruturado em Usuário).
	 * @param senha A senha do Estudante (Estruturado em Usuário).
	 * @param matricula A matrícula do Estudante em formato texttual.
	 * @throws IllegalArgumentException A matrícula não pode ser nula ou vazia.
	 */
	public Estudante(String nome, String cpf, int senha, String matricula) throws IllegalArgumentException {
		super(nome, cpf, senha);
		
		if(matricula == null || matricula.isBlank())
			throw new IllegalArgumentException("Matrícula não pode ser nulo e nem vazio.");
		
		this.matricula = matricula;
		this.atividades = new ArrayList<>();
		this.relatorios = new ArrayList<>();
	}
	
	/**
	 * Cadastra uma Atividade de Monitoria no Estudante.
	 * @param tipo O tipo da atividade a ser cadastrada.
	 * @param unidadeAcumulada O total de tempo acumulado nessa atividade.
	 * @param disciplina A disciplina em que a atividade foi realizada.
	 * @return O id da atividade que foi cadastrada.
	 */
	public String cadastrarAtividadeMonitoria(String tipo, int unidadeAcumulada, String disciplina) {
		String idAtividade = gerarIdAtividade();
		
		Atividade atv = new AtividadeMonitoria(idAtividade, tipo, unidadeAcumulada, disciplina);		
		this.atividades.add(atv);
		
		return idAtividade;
	}
	
	/**
	 * Cadastra uma Atividade de Pesquisa no Estudante.
	 * @param tipo O tipo da atividade a ser cadastrada.
	 * @param unidadeAcumulada O total de tempo acumulado nessa atividade.
	 * @param disciplina A disciplina em que a atividade foi realizada.
	 * @return O id da atividade que foi cadastrada.
	 */
	public String cadastrarAtividadePesquisaExtensao(String tipo, int unidadeAcumulada, String disciplina) {
		String idAtividade = gerarIdAtividade();
		
		Atividade atv = new AtividadePesquisaExtensao(idAtividade, tipo, unidadeAcumulada, disciplina);		
		this.atividades.add(atv);
		
		return idAtividade;
	}
	
	/**
	 * Cadastra uma Atividade de Estágio no Estudante.
	 * @param tipo O tipo da atividade a ser cadastrada.
	 * @param unidadeAcumulada O total de tempo acumulado nessa atividade.
	 * @param disciplina A disciplina em que a atividade foi realizada.
	 * @return O id da atividade que foi cadastrada.
	 */
	public String cadastrarAtividadeEstagio(String tipo, int unidadeAcumulada, String disciplina) {
		String idAtividade = gerarIdAtividade();
		
		Atividade atv = new AtividadeEstagio(idAtividade, tipo, unidadeAcumulada, disciplina);		
		this.atividades.add(atv);
		
		return idAtividade;
	}
	
	/**
	 * Cadastra uma Atividade de Publicação de artigo no Estudante.
	 * @param tipo O tipo da publicação realizada.
	 * @param tituloArtigo O titulo do artigo publicado.
	 * @param doi O doi referente a publicação.
	 * @param qualis O código qualis referente à publicação.
	 * @return O id da atividade cadastrada.
	 */
	public String cadastrarAtividadePublicacao(String tipo, String tituloArtigo, String doi, String qualis) {
		String idAtividade = gerarIdAtividade();
		
		Atividade atv = new AtividadePublicacao(idAtividade, tipo, tituloArtigo, doi, qualis);		
		this.atividades.add(atv);
		
		return idAtividade;
	}
		
	/**
	 *  Adiciona/Edita a descrição da atividade escolhida.
	 * @param idAtv O id da atividade que deve ser editada.
	 * @param descricao A descrição que será definida na atividade.
	 * @return Um booleano que indica o sucesso da ação.
	 */
	public boolean editarDescricaoAtividade(String idAtv, String descricao) {
		if(!existeAtividade(idAtv))
			return false;
		
		for(Atividade atv : this.atividades) {
			if(atv.getId().equals(idAtv)) {
				atv.setDescricao(descricao);
				break;
			}
		}
		
		return true;
	}
	
	/**
	 * Adiciona/Edita o link de comprovação da atividade. 
	 * @param idAtv O id da atividade que deve ser editada.
	 * @param linkComprovante A descrição que será definida na atividade.
	 * @return Um booleano que indica o sucesso da ação.
	 */
	public boolean editarComprovacaoAtividade(String idAtv, String linkComprovante) {
		if(!existeAtividade(idAtv))
			return false;
		
		for(Atividade atv : this.atividades) {
			if(atv.getId().equals(idAtv)) {
				atv.setComprovante(linkComprovante);
				break;
			}
		}
		return true;
	}
	
	/**
	 * Lê os créditos da atividade solicitada.
	 * @param idAtv O id da atividade solicitada.
	 * @return O valor de créditos ganhos naquela atividade.
	 * @throws NullPointerException Atividade solicitada não encontrada.
	 */
	public double lerCreditos(String idAtv) throws NullPointerException{
		if(!existeAtividade(idAtv))
			throw new NullPointerException("Atividade não encontrada.");
		
		for(Atividade atv : this.atividades) {
			if(atv.getId().equals(idAtv)) {
				return atv.getCreditos();
			}
		}
		return 0;
	}
	
	/**
	 * Gera o relatório ccompleto das atividades cadastradas até o momento no usuário.
	 * @return Um inteiro que representa o índice + 1 da posição na qual relatório foi armazenado.
	 */
	public int gerarRelatorioCompleto() {		
		Relatorio novoRelatorio = new RelatorioCompleto(this);
		for(Atividade atv : this.atividades) {
			novoRelatorio.adicionaAtividade(atv);
		}
		
		return atribuiRelatorio(novoRelatorio);
	}
	
	/**
	 * Gera o relatório resumido das atividades cadastradas até o momento no usuário.
	 * @return Um inteiro que representa o índice + 1 da posição na qual relatório foi armazenado.
	 */
	public int gerarRelatorioResumido() {		
		Relatorio novoRelatorio = new RelatorioResumido(this);
		for(Atividade atv : this.atividades) {
			novoRelatorio.adicionaAtividade(atv);
		}
		
		return atribuiRelatorio(novoRelatorio);
	}
	
	/**
	 * Gera o relatório específico para um tipo de atividade cadastradas até o momento no usuário.
	 * @param tipo O tipo de atividade a ser filtrado.
	 * @return Um inteiro que representa o índice + 1 da posição na qual relatório foi aramazenado.
	 */
	public int criarRelatorioPorATV(String tipo) {
		Relatorio novoRelatorio = new RelatorioPorAtv(this, tipo);
		
		for(Atividade atv : this.atividades) {
			if(atv.getTipo().equals(tipo) || (tipo.equals("publicacao") && (atv.getTipo().equals("Periódico") || atv.getTipo().equals("Conferência"))))
				novoRelatorio.adicionaAtividade(atv);
		}
		
		return atribuiRelatorio(novoRelatorio);
	}
	
	/**
	 * Exibe, de forma textual, o relatório salvo numa posição específico.
	 * @param indexRelatorio O índice + 1 do relatório a ser exibido.
	 * @return Retorna o texto de todo o relatorio solicitado.
	 */
	public String exibirRelatorio(int indexRelatorio) {
		return this.relatorios.get(indexRelatorio - 1).toString();
	}
	
	/**
	 * Gera o id do relatório baseado no cpf do estudante e na última posição (local em que o realtório foi salvo).
	 * @return A String referente ao id do relatório.
	 */
	private String gerarIdAtividade() {
		return this.getCpf() + "_" + (this.atividades.size() + 1);
	}
	
	/**
	 * Verifica se a atividade está cadastrada no estudante com base no id.
	 * @param idAtv O id da atividade que será verificada.
	 * @return Um booleano resultante da verificação (se a atividade está cadastrada).
	 */
	private boolean existeAtividade(String idAtv) {
		for(Atividade atv : this.atividades) {
			if(atv.getId().equals(idAtv))
				return true;
		}
		return false;
	}
	
	/**
	 * Lê a matrícula do aluno
	 * @return A String referente à matrícula do estudante.
	 */
	public String getMatricula() {
		return matricula;
	}
	
	/**
	 * Função que atribuí o relatório à lista (invocado após a criação do relatório).
	 * @param novoRelatorio O relatório a ser adicionado na lista.
	 * @return o inteiro referente ao tamanho da lista de relatorios (a posição + 1 na qual o relatório foi adicionado).
	 */
	private int atribuiRelatorio(Relatorio novoRelatorio) {
		if(novoRelatorio.totalAtv() <= 0)
			return -1;
		
		this.relatorios.add(novoRelatorio);
		return this.relatorios.size();
	}
	
	@Override
	public String toString() {
		return "Matrícula: " + this.matricula + " | " + super.toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.getCpf());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudante other = (Estudante) obj;
		return this.getCpf().equals(other.getCpf());	
	}
}
