package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que define a estrutura do Administrador (extende as características de Usuário).
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 *
 */
public class Admin extends Usuario {
	
	/**
	 *  Constrói um Administrador, usando como base um 
	 * @param nome O nome do Administrador.
	 * @param cpf O cpf (identificador) do Administrador e também seu login, na estrutura XXXXXXXXX-XX.
	 * @param senha A senha de acesso, no formato inteiro de 8 dígitos (logo, não pode começar em zero).
	 */
	public Admin(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
	}
	
	
}
