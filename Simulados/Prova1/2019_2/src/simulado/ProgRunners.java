package simulado;

public class ProgRunners {
	private Corredor[] corredores;
	private int iCorredor;
	
	public ProgRunners() {
		this.corredores = new Corredor[100];
		this.iCorredor = 0;
	}
	
	public void cadastrarCorredor(String nome, String cpf, int anoNascimento) {
		try {
			verificaICorredor();
			
			Corredor novoCorredor = new Corredor(nome, cpf, anoNascimento);
			verificaCorredorExiste(novoCorredor);
			
			this.corredores[this.iCorredor] = novoCorredor;
			this.iCorredor++;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	public String listarCorredores() {
		StringBuilder lista = new StringBuilder();
		for(Corredor c : this.corredores) {
			if(c != null) {
				lista.append(c.toString()).append("\n");
			}
		}
		return lista.toString();
	}
	
	public void cadastrarTreinoCorredor(String cpf, double distancia, int tempoEsperado, String descricao) {
		for(Corredor c : this.corredores) {
			if(cpf.equals(c.getCpf())) {
				try {
					c.setTreino(distancia, tempoEsperado, descricao);
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
				break;
			}
		}
	}
	
	public void finalizarTreino(String cpf, int indice, int tempoGasto) {
		for(Corredor c : this.corredores) {
			if(cpf.equals(c.getCpf())) {
				c.finalizaTreino(indice, tempoGasto);
				break;
			}
		}
	}
	
	public int contarTreinosFinalizadosCorredor(String cpf) {
		int tot = 0;
		
		for(Corredor c : this.corredores) {
			if(cpf.equals(c.getCpf())) {
				for(Treino t : c.getTreinos()) {
					if ("terminado".equals(t.getStatus())) {
						tot++;
					}
				}
				break;
			}
		}
		return tot;
	}
	
	public double resistenciaCorredor(String cpf) {
		
		int soma = 0;
		for(Corredor c : this.corredores) {
			if(cpf.equals(c.getCpf())) {
				for(Treino t : c.getTreinos()) {
					soma += t.calculaResistencia();
				}
				break;
			}
		}
		
		return (soma / contarTreinosFinalizadosCorredor(cpf));
	}
	
	
	public String exibirCategoriaCorredor(String cpf) {
		for(Corredor c : this.corredores) {
			if(cpf.equals(c.getCpf())) {
				return c.exibirCategoriaCorredor();
			}
		}
		return "Corredor não encontrado";
	}
	private void verificaICorredor() throws IndexOutOfBoundsException{
		if (this.iCorredor >= 100) {
			throw new IndexOutOfBoundsException("Limite de 100 corredores atingido");
		}
	}
	
	private void verificaCorredorExiste(Corredor novoCorredor) throws IndexOutOfBoundsException{
		if(this.iCorredor > 0) {
			for(Corredor c : this.corredores) {
				if(c.equals(novoCorredor)) {
					throw new IllegalArgumentException("Já existe um corredor com o mesmo CPF");
				}
			}
		}
	}
}
