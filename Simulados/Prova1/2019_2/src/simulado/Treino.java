package simulado;

public class Treino {
	private double distancia;
	private int tempoEsperado;
	private String descricao;
	private String status;
	private int tempoConclusao;
	
	
	
	public Treino(double distancia, int tempoEsperado, String descricao) {
		this.distancia = distancia;
		this.tempoEsperado = tempoEsperado;
		this.descricao = descricao;
		this.status = "não iniciado";
		this.tempoConclusao = 0;
	}
	
	@Override
	public String toString() {
		return String.format("%.0fkm - %dmin - %s", distancia, tempoEsperado, descricao);
	}

	public int getTempoConclusao() {
		return tempoConclusao;
	}

	public void setTempoConclusao(int tempoConclusao) {
		this.tempoConclusao = tempoConclusao;
	}

	public double getDistancia() {
		return distancia;
	}
	
	public int getTempoEsperado() {
		return tempoEsperado;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int calculaResistencia() {
		if(status.equals("terminado"))
			return 0;
		else if (this.tempoEsperado - this.tempoConclusao > 0)
			return 1;
		else if (this.tempoEsperado - this.tempoConclusao < 0)
			return -1;
		else
			return 0;
	}
	
}
