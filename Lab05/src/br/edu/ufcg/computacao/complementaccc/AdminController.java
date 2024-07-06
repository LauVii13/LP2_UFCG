package br.edu.ufcg.computacao.complementaccc;
/**
 * Classe que controla as ações e manipulações pelas quais os Administradores são responosáveis.
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 *
 */
public class AdminController {
	/**
	 *  Administrador único no sistema.
	 */
	private Usuario admin;

	/**
	 * Construtor do sistema de controle do Administrador.
	 */
	public AdminController() {
		this.admin = null;
	}
	
	/**
	 * Exibe as características do Administrador atual.
	 * @return Uma String representando os dados do Administrador, no formato:
	 * "Nome: NOME | CPF: CPF
	 */
	public String exibirAdmin() {
		return admin.toString();
	}
	
	/**
	 * Cria um novo Admin, substituindo o atual ou, caso ainda não tenha sido cadastrado.
	 * @param cpf O cpf do administrador atual(qualquer valor caso não exista).
	 * @param senhaAntiga A senha do administrador atual (qualquer valor caso não exista).
	 * @param nomeNovo O nome do novo administrador.
	 * @param novoCpf O cpf do novo administrador.
	 * @param novaSenha A senha do novo administrador.
	 * @return Um booleano indicando se foi possível ou não adicionar o novo administrador.
	 */
	public boolean novoAdmin(String cpf, int senhaAntiga, String nomeNovo, String novoCpf, int novaSenha) {
		if(!existeAdmin()) {
			this.admin = new Admin(nomeNovo, novoCpf, novaSenha);
			return true;
		}else {
			if(validarAdmin(cpf, senhaAntiga)) {
				this.admin = new Admin(nomeNovo, novoCpf, novaSenha);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Altera a senha atual do administrador.
	 * @param novaSenha A nova senha a ser atribuída ao administrador.
	 * @return Um booleano indiicando se foi possível ou não alterar a senha.
	 */
	public boolean mudarSenhaAdmin(int novaSenha) {
		this.admin.setSenha(novaSenha);
		return true;
	}
	
	/**
	 * Valida se os dados recebidos condizem com o administrador atual do sistema.
	 * @param cpf O cpf a ser validado.
	 * @param senha A senha a ser validada.
	 * @return Verdadeiro para sucesso na validação, ou falso para quando os dados não condizem.
	 */
	public boolean validarAdmin(String cpf, int senha) {
		if(!existeAdmin() || cpf == null || !cpf.equals(admin.getCpf()))
			return false;
		return admin.validaUsuario(senha);
	}
	
	/**
	 * Verifica se existe administrador no momento.
	 * @return Verdadeiro para administrador definido, Falso para administrador nulo.
	 */
	private boolean existeAdmin() {
		return this.admin != null;
	}
}
