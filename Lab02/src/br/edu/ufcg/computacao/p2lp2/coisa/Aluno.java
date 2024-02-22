package br.edu.ufcg.computacao.p2lp2.coisa;

public class Aluno {

	private String nome;
	private int anoNascimento;
	private double cra;

	public Aluno(String nome, int anoNascimento) {
		this.nome = nome;
		this.cra = 0.0;
		this.anoNascimento = anoNascimento;
	}

	public void setCra(double cra) {
		this.cra = cra;
	}

	public int getIdade() {
		return 2021 - anoNascimento;
	}

	public String toString() {
		return "Aluno - "  + this.nome;
	}

}

