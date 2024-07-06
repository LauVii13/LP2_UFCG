package br.edu.ufcg.computacao.complementaccc;

import java.util.Objects;

/**
 * Classe que define um Usuário e suas funcionalidades.
 */
public abstract class Usuario implements Comparable<Usuario>{
	/**
	 * O nome em String do usuário.
	 */
	private String nome;
	
	/**
	 * O cpf do usuário (identificador único).
	 */
	private String cpf;
	
	/**
	 * A senha de 8 dígitos inteira do Usuário.
	 */
	private int senha;
	
	/**
	 * Cosntrói um novo usuário.
	 * @param nome O nome a ser adicionado ao usuário.
	 * @param cpf O cpf do novo usuário.
	 * @param senha A senha do novo Usuário.
	 * @throws IllegalArgumentException Nome, CPF não podem ser nulos e Senha deve possuir 8 numeros.
	 */
	public Usuario(String nome, String cpf, int senha) throws IllegalArgumentException{
		if(nome == null || nome.isBlank())
			throw new IllegalArgumentException("Nome não pode ser nulo e nem vazio.");
		
		if(cpf == null || cpf.isBlank())
			throw new IllegalArgumentException("CPF não pode ser nulo e nem vazio.");
		
		if(senha < 10000000 || senha > 99999999)
			throw new IllegalArgumentException("Senha deve ter exatamente 8 caractéres numéricos.");
		
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	/**
	 * Lê o nome do usuário.
	 * @return Uma string com o nome do usuário.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Define um novo nome do usuário.
	 * @param nome O novo nome do usuário em String.
	 * @throws IllegalArgumentException Nome nao pode ser nulo nem vazio.
	 */
	public void setNome(String nome) throws IllegalArgumentException{
		if(nome == null || nome.isBlank())
			throw new IllegalArgumentException("Nome não pode ser nulo e nem vazio.");
		this.nome = nome;
	}

	/**
	 * Lê cpf do usuário.
	 * @return Uma string que representa o cpf do usuário.
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Lê a senha inteira do usuário.
	 * @return Um numero inteiro que define a senha.
	 */
	public int getSenha() {
		return senha;
	}
	
	/**
	 * Define a senha do usuário.
	 * @param senha A nova senha do usuário.
	 * @throws IllegalArgumentException Senha deve ter 8 caracteres.
	 */
	public void setSenha(int senha) throws IllegalArgumentException{
		if(senha < 10000000 || senha > 99999999)
			throw new IllegalArgumentException("Senha deve ter exatamente 8 caractéres numéricos.");
		this.senha = senha;
	}
	
	/**
	 * Valida o usuário comparando a senha.
	 * @param senha A senha a ser comparada.
	 * @return Um boolean indicado se a validação foi um sucesso.
	 */
	public boolean validaUsuario(int senha) {
		if(senha < 10000000 || senha > 99999999)
			return false;
		return this.getSenha() == senha;
	}

	/**
	 * Exibe as características do Administrador atual.
	 * @return Uma String representando os dados padrões do Usuário, no formato:
	 * "Nome: NOME | CPF: CPF
	 */
	@Override
	public String toString() {
		return "Nome: " + nome + " | CPF: " + cpf;
	}
	
	/**
	 * Compara o usuário com um outro pelo nome.
	 */
	@Override
	public int compareTo(Usuario o) {
		return this.nome.compareToIgnoreCase(o.getNome());
	}
	
	
}
