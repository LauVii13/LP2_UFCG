package br.edu.ufcg.computacao.complementaccc;

public class ComplementaCCCFacade {
	private AdminController cAdmin;
	private SistemaController cSistema;
	private FAQController cFAQ;
	
	
	public ComplementaCCCFacade() {
		this.cAdmin = new AdminController();
		this.cSistema = new SistemaController();
		this.cFAQ = new FAQController();
	}
	
	//declarar controladores
	boolean criarEstudante(String nome, String cpf, int senha, String matricula) {
		return cSistema.criarEstudante(nome, cpf, senha, matricula);
	}
	
	String[] exibirEstudantes(String cpf, int senha){
		if(cAdmin.validarAdmin(cpf, senha))
			return cSistema.exibirEstudante();
		return new String[] {};
	}
	
	boolean alterarEstudante(String cpf, int senha, String tipoAlteracao, String novoValor) {
		if(cSistema.validarEstudante(cpf, senha))
			return cSistema.alterarEstudante(cpf, tipoAlteracao, novoValor);
		return false;
	}
	
	String exibirAdmin(String cpf, int senha){
		if(cAdmin.validarAdmin(cpf, senha))
			return cAdmin.exibirAdmin();
		return "";
		//ADMIN
	}
	
	boolean configurarNovoADMIN(String cpf, int senhaAtual, String nomeNovo, String cpfNovo, int senhaNova){
		return cAdmin.novoAdmin(cpf, senhaAtual, nomeNovo, cpfNovo, senhaNova);
		//ADMIN
	}
	
	boolean configurarSenhaADMIN(String cpf, int senhaAtual, int senhaNova){
		if(cAdmin.validarAdmin(cpf, senhaAtual))
			return cAdmin.mudarSenhaAdmin(senhaNova);
		return false;
		//ADMIN
	}
	
	boolean adicionarItemFAQ(String cpf, int senha, String pergunta) {
		if(cAdmin.validarAdmin(cpf, senha))
			return cFAQ.adicionarItem(pergunta);
		return false;
		//ADMIN
	}
	boolean adicionarItemFAQ(String cpf, int senha, String pergunta, String resposta) {
		if(cAdmin.validarAdmin(cpf, senha))
			return cFAQ.adicionarItem(pergunta, resposta);
		return false;
		//ADMIN
	}
	
	boolean alteraRespostaItem(String cpf, int senha, int itemIndex, String resposta) {
		if(cAdmin.validarAdmin(cpf, senha))
			return cFAQ.alterarRespostaItem(itemIndex, resposta);
		return false;
		//ADMIN
	}
	
	String[] listarFAQ() {
		return cFAQ.listarFAQ();
	}
	
	String[] listarFAQPorDestaque() {
		return cFAQ.listarFAQPorDestaque();
	}
	
	boolean destacarItem(int itemIndex) {
		return cFAQ.destacarItem(itemIndex);
	}
	
	boolean atribuirTagsItemFAQ(String cpf, int senha,int itemIndex, String[] tags) {
		if(cAdmin.validarAdmin(cpf, senha))
			return cFAQ.atribuirTagsItemFAQ(itemIndex, tags);
		return false;
		//ADMIN
	}
	
	String[] buscarItemFAQ(String[] tags) {
		return cFAQ.buscaItemFAQ(tags);
	}
	
	String criarAtividadeMonitoriaEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		if(cSistema.validarEstudante(cpf, senha))
			return cSistema.criarAtvMonitoria(cpf, tipo, unidadeAcumulada, disciplina);
		return "";
	}
	
	boolean alterarDescricaoAtividade(String cpf, int senha, String codigoAtividade, String descricao) {
		if(cSistema.validarEstudante(cpf, senha))
			return cSistema.alterarDescricaoAtv(cpf, codigoAtividade, descricao);
		return false;
	}
	
	boolean alterarComprovacaoAtividade(String cpf, int senha, String codigoAtividade, String linkComprovacao) {
		if(cSistema.validarEstudante(cpf, senha))
			return cSistema.alterarComprovacaoAtv(cpf, codigoAtividade, linkComprovacao);
		return false;
	}
	
	String criarAtividadePesquisaExtensaoEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		if(cSistema.validarEstudante(cpf, senha))
			return cSistema.criarAtvPesquisaExtensao(cpf, tipo, unidadeAcumulada, disciplina);
		return "";
	}
	
	String criarAtividadeEstagioEmEstudante(String cpf, int senha, String tipo, int unidadeAcumulada, String disciplina) {
		if(cSistema.validarEstudante(cpf, senha))
			return cSistema.criarAtvEstagio(cpf, tipo, unidadeAcumulada, disciplina);
		return "";
	}
	
	String criarAtividadePublicacaoEmEstudante(String cpf, int senha, String tipo, String tituloArtigo, String doi, String qualis) {
		if(cSistema.validarEstudante(cpf, senha))
			return cSistema.criarAtvPublicacao(cpf, tipo, tituloArtigo, doi, qualis);
		return "";
	}
	
	double creditosAtividade(String cpf, int senha, String codigoAtividade) {
		if(cSistema.validarEstudante(cpf, senha))
			return cSistema.lerCreditos(cpf, codigoAtividade);
		return 0;
	}
	
	int criarRelatorioCompleto(String cpf, int senha) {
		if(cSistema.validarEstudante(cpf, senha))
			return cSistema.gerarRelatorioCompleto(cpf);
		return 0;
	}
	
	int criarRelatorioResumido(String cpf, int senha) {
		if(cSistema.validarEstudante(cpf, senha))
			return cSistema.gerarRelatorioResumido(cpf);
		return 0;
	}
	
	int criarRelatorioPorATV(String cpf, int senha, String tipoAtividade) {
		if(cSistema.validarEstudante(cpf, senha))
			return cSistema.criarRelatorioPorATV(cpf, tipoAtividade);
		return 0;
	}
	
	String exibirRelatorio(String cpf, int senha, int indexRelatorio) {
		if(cSistema.validarEstudante(cpf, senha))
			return cSistema.exibirRelatorio(cpf, indexRelatorio);
		return "";
	}

}
