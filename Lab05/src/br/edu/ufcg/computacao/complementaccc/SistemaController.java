package br.edu.ufcg.computacao.complementaccc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Classe que define um Estudante e suas funcionalidades, se extendendo da classe de Usuário do sistema.
 * 
  * @author Vinícius Gabriel Laureano - 123111119
 */
public class SistemaController {
	/**
	 * Mapa de estudantes no sistema.
	 */
	private HashMap<String, Estudante> estudantes;
	
	/**
	 * Constrói controlador do sistema.
	 */
	public SistemaController() {
		this.estudantes = new HashMap<>();
	}
	
	/**
	 * Cria um novo estudante no sistema
	 * @param nome O nome de do estudante a ser criado.
	 * @param cpf O cpf do estudante.
	 * @param senha A senha do estudante a ser criado.
	 * @param matricula A matricula do estudante.
	 * @return Um boolean que indica se a ação foi um sucesso.
	 */
	public boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
		if(existeEstudante(cpf))
			return false;
		
		Estudante novoEstudante = new Estudante(nome, cpf, senha, matricula);	
		estudantes.put(cpf, novoEstudante);

		return true;
	}
	
	/**
	 * Altera dados do estudante (senha ou nome).
	 * @param cpf O cpf do estudante que será alterado.
	 * @param tipoAlteracao O tipo de alteração que será feita.
	 * @param novoValor O novo valor (nova senha ou novo nome).
	 * @return Um booleano indicando se a ação foi um sucesso.
	 * @throws IllegalArgumentException Limitação de senha para 8 caracteres e o tipo deve ser nome ou senha.
	 */
	public boolean alterarEstudante(String cpf, String tipoAlteracao, String novoValor) throws IllegalArgumentException{
		switch(tipoAlteracao) {
			case "nome":
				estudantes.get(cpf).setNome(novoValor);
				break;
			case "senha":
				int novaSenha;
				try {
					novaSenha = Integer.parseInt(novoValor);
				}catch(IllegalArgumentException e) {
					throw new IllegalArgumentException("A nova senha deve ter exatamente 8 caractéres numéricos.");
				}
				estudantes.get(cpf).setSenha(novaSenha);
				break;
			default:
				throw new IllegalArgumentException("Tipo de alteração deve ser:'nome' ou 'senha'");
			}
		
		return true;
	}
	
	/**
	 * Exibe a lista de estudantes.
	 * @return Uma lista de estudantes (Array de string).
	 */
	public String[] exibirEstudante() {
		ArrayList<Estudante> listaEstudantes = new ArrayList<>(estudantes.values());
		Collections.sort(listaEstudantes);
		
		String[] resultado = new String[listaEstudantes.size()];
		
		int contador = 0;
		for(Estudante e : listaEstudantes) {
			resultado[contador] = e.toString();
			contador++;
		}
		return resultado;
	}
	
	/**
	 * Valida o cpf e senha de um estudante.
	 * @param cpf O cpf a ser verificado.
	 * @param senha A senha do estudante a ser verificado.
	 * @return Um booleano que indica se a validação é validada ou nao.
	 */
	public boolean validarEstudante(String cpf, int senha) {
		if(!existeEstudante(cpf))
			return false;
		
		return estudantes.get(cpf).validaUsuario(senha);
	}
	
	/**
	 * Cria uma monitoria.
	 * @param cpf O cpf do estudante.
	 * @param tipo O tipo da ativiade.
	 * @param unidadeAcumulada A unidade acumulada da ativiade.
	 * @param disciplina A disciplina realizada.
	 * @return O id da atividade em String.
	 */
	public String criarAtvMonitoria(String cpf, String tipo, int unidadeAcumulada, String disciplina) {
		return this.estudantes.get(cpf).cadastrarAtividadeMonitoria(tipo, unidadeAcumulada, disciplina);
	}
	
	/**
	 *  Altera a descricao de uma atividade.
	 * @param cpf o cpf do estudante que será alterada a atividade.
	 * @param codigoAtividade o codigo da atividade.
	 * @param descricao a descricao a ser adicionada.
	 * @return Um bolleano indicando se a ação foi um sucesso.
	 */
	public boolean alterarDescricaoAtv(String cpf, String codigoAtividade, String descricao) {		
		return this.estudantes.get(cpf).editarDescricaoAtividade(codigoAtividade, descricao);
	}
	
	/**
	 *  Altera o comprovante de uma atividade.
	 * @param cpf o cpf do estudante que será alterada a atividade.
	 * @param codigoAtividade o codigo da atividade.
	 * @param descricao a descricao a ser adicionada.
	 * @return Um bolleano indicando se a ação foi um sucesso.
	 */
	public boolean alterarComprovacaoAtv(String cpf, String idAtv, String linkComprovacao) {		
		return this.estudantes.get(cpf).editarComprovacaoAtividade(idAtv, linkComprovacao);
	}
	
	/**
	 * Cria a atividade de pesquisa de extensão no estudante.
	 * @param cpf O cpf do estudante que receberá a atividade.
	 * @param tipo O tipo de atividade a ser cadastrada.
	 * @param unidadeAcumulada O total de tempo acumulado nessa atividade.
	 * @param disciplina A disciplina na qual a ativiade foi realizada
	 * @return O id da atividade.
	 */
	public String criarAtvPesquisaExtensao(String cpf, String tipo, int unidadeAcumulada, String disciplina) {
		return this.estudantes.get(cpf).cadastrarAtividadePesquisaExtensao(tipo, unidadeAcumulada, disciplina);
	}

	/**
	 * Cria a atividade de estágio no estudante.
	 * @param cpf O cpf do estudante que receberá a atividade.
	 * @param tipo O tipo de atividade a ser cadastrada.
	 * @param unidadeAcumulada O total de tempo acumulado nessa atividade.
	 * @param disciplina A disciplina na qual a ativiade foi realizada
	 * @return O id da atividade.
	 */
	public String criarAtvEstagio(String cpf, String tipo, int unidadeAcumulada, String disciplina) {
		return this.estudantes.get(cpf).cadastrarAtividadeEstagio(tipo, unidadeAcumulada, disciplina);
	}
	
	/**
	 * Cria a atividade de Publicação de artigo no estudante.
	 * @param cpf O cpf do estudante q receberá a atividade.
	 * @param tipo O tipo da atividade a ser cadastrada.
	 * @param tituloArtigo O titulo do artigo publicado.
	 * @param doi O DOI referente a publicação.
	 * @param qualis O codigo qualis que indica a quantidade de créditos a serem recebidos.
	 * @return O id da atividade.
	 */
	public String criarAtvPublicacao(String cpf, String tipo, String tituloArtigo, String doi, String qualis) {
		return this.estudantes.get(cpf).cadastrarAtividadePublicacao(tipo, tituloArtigo, doi, qualis);
	}
	
	/**
	 * Lê o total de créditos que o estudante especificado conseguiu com a atividade selecionada pelo código.
	 * @param cpf O cpf do estudante a ser analisado.
	 * @param codigoAtividade O código da atividade selecionada.
	 * @return Um double que indica o total de créditos calculados na referedia atividade.
	 */
	public double lerCreditos(String cpf, String codigoAtividade) {
		return this.estudantes.get(cpf).lerCreditos(codigoAtividade);
	}
	
	/**
	 * Cria e armazena um relatório com informações completas das atividades de um estudante especificado.
	 * @param cpf O cpf do estudante a gerar o relatório
	 * @return O index de onde o relatório está armazenado.
	 */
	public int gerarRelatorioCompleto(String cpf) {
		return this.estudantes.get(cpf).gerarRelatorioCompleto();
	}
	
	/**
	 * Cria e armazena um relatório com as informações das atividades de forma resumida, referente a um estudante especificado.
	 * @param cpf O cpf do estudante a gerar o relatório.
	 * @return O index de onde o relatório está armazenado.
	 */
	public int gerarRelatorioResumido(String cpf) {
		return this.estudantes.get(cpf).gerarRelatorioResumido();
	}
	
	/**
	 * Cria e armazena um relatório com as informações resumidas das atividades, filtrando por um tipo de atividade escolhida na solicitação, em um estudante especificado.
	 * @param cpf O cpf do estudante a gerar o relatório.
	 * @param tipoAtv O tipo de atividade a ser agrupado e filtrado no relatório.
	 * @return O index de onde o relatório está armazenado.
	 */
	public int criarRelatorioPorATV(String cpf, String tipoAtv) {
		return this.estudantes.get(cpf).criarRelatorioPorATV(tipoAtv);
	}
	
	/**
	 * Exibe o relatório de um estudante, armazenado na posição especificada, independente do tipo de relatório.
	 * @param cpf O cpf do estudante em que está armazenado o relatório de suas atividades.
	 * @param indexRelatorio A posição +1 da localização do relatório a ser exibido.
	 * @return Uma String com a demosntração textual do relatório da posição especificada.
	 */
	public String exibirRelatorio(String cpf, int indexRelatorio) {
		return this.estudantes.get(cpf).exibirRelatorio(indexRelatorio);
	}
	
	/**
	 * Valida se existe o estudante em questão no mapa de estudantes.
	 * @param id O cpf do estudante a ser validado.
	 * @return Um booleano que indica o resultado da validação.
	 */
	private boolean existeEstudante(String id) {
		return estudantes.containsKey(id);
	}
}
