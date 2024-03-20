package simulado;

import java.util.Objects;

public class Corredor {
	private String nome;
	private String cpf;
	private int anoNascimento;
	private Treino[] treinos;
	private int iTreino;
	
	public Corredor(String nome, String cpf, int anoNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.anoNascimento = anoNascimento;
		this.treinos = new Treino[10];
		this.iTreino = 0;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	public Treino[] getTreinos() {
		return treinos.clone();
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corredor other = (Corredor) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return (nome + " - " + cpf + " - " + exibirCategoriaCorredor());
	}
	
	public String exibirCategoriaCorredor() {
		int idade = calculaIdade(this.anoNascimento);
		
		if(idade >= 15 && idade <= 24)
			return "JOVEM";
		else if(idade >= 25 && idade <= 45)
			return "ADULTO";
		else if(idade >= 41 && idade <= 64)
			return "SUPER_ADULTO";
		else if(idade >= 41 && idade <= 64)
			return "SUPER_ADULTO";
		else
			return "MELHOR_IDADE";
	}
	
	private int calculaIdade(int anoNascimento) {

		return 2024 - anoNascimento;
	}
	
	public void setTreino(double distancia, int tempoEsperado, String descricao) throws IndexOutOfBoundsException{
		verificaITreino();
		this.treinos[this.iTreino] = new Treino(distancia, tempoEsperado, descricao);
		this.iTreino++;
	}
	
	public void finalizaTreino(int indice, int tempoGasto) {
		this.treinos[indice-1].setTempoConclusao(tempoGasto);
		this.treinos[indice-1].setStatus("terminado");
	}
	private void verificaITreino() throws IndexOutOfBoundsException{
		if (this.iTreino >= 10) {
			throw new IndexOutOfBoundsException("Limite de 10 tipos de treino por corredor atingido");
		}
	}
}
