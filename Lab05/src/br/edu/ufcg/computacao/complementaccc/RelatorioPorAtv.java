package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que define um Relatório filtrando por tipo de atividade.
 * 
  * @author Vinícius Gabriel Laureano - 123111119
 */
public class RelatorioPorAtv extends Relatorio {
	
	/**
	 * Tipo do relatório que está sendo filtrado.
	 */
	private String tipo;
	
	/**
	 * Constrói o relatório por atividade.
	 * @param e Estudante que possui o relatório.
	 * @param tipo O tipo de relatório que está sendo filtrado.
	 */
	public RelatorioPorAtv(Estudante e, String tipo) {
		super(e);
		this.tipo = tipo;
	}

	/**
	 * Lê o tipo da atividade a que se refere o relatório.
	 * @return String sobre o tipo.
	 */
	public String getTipo() {
		return tipo;
	}
	
	@Override
	public String toString() {
		String texto = String.format("Nome: %s\nCPF: %s\nMatrícula: %s\n", this.dadosEstudante.getNome(), this.dadosEstudante.getCpf(), this.dadosEstudante.getMatricula());		
		int totTempoEstagio = 0;
		int totTempoPesquisaExtensao = 0;

		double totCreditosMonitoria = 0;
		double totCreditosPublicacao = 0;
		
		switch(this.tipo) {
			case "estagio":
				for(Atividade atv : this.atividades) {
					totTempoEstagio += atv.getValorAcumulado();
				}
				
				double totCreditosEstagio = (totTempoEstagio >= 300) ? Math.min((totTempoEstagio / 60), 18) : 0;
				int creditosEstagio = (int) (Math.floor(Math.min(totCreditosEstagio, 18)));
				
				if(creditosEstagio == 0)
					texto += "Estágios | Créditos Acumulados: NAO ATINGIU AINDA O VALOR MÍNIMO\n";
				else
					texto += String.format("Estágios | Créditos Acumulados: %d/18\n", creditosEstagio);
				break;
				
			case "monitoria":
				for(Atividade atv : this.atividades) {
					totCreditosMonitoria += atv.getCreditos();
				}
				int creditosMonitoria = (int) (Math.floor(Math.min(totCreditosMonitoria, 16)));
				texto += String.format("Monitorias | Créditos Acumulados: %d/16\n", creditosMonitoria);
				break;
			case "pesquisa_extensao":
				for(Atividade atv : this.atividades) {
					totTempoPesquisaExtensao += atv.getValorAcumulado();
				}
				
				double totCreditosPesquisaExtensao = (totTempoPesquisaExtensao >= 12) ? Math.max(((totTempoPesquisaExtensao * 10) / 12), 18) : 0;
				int creditosPesquisaExtensao = (int) (Math.floor(Math.min(totCreditosPesquisaExtensao, 18)));
				if(creditosPesquisaExtensao == 0)
					texto += "Pesquisas de Extensão | Créditos Acumulados: NAO ATINGIU AINDA O VALOR MÍNIMO\n";
				else
					texto += String.format("Pesquisas de Extensão | Créditos Acumulados: %d/18\n", creditosPesquisaExtensao);
				break;
			case "publicacao":
			case "Conferência":
			case "Periódico":
				for(Atividade atv : this.atividades) {
					totCreditosPublicacao += atv.getCreditos();
				}
				
				int creditosPublicacao = (int) (Math.floor(Math.max(totCreditosPublicacao, 16)));
				texto += String.format("Publicações| Créditos Acumulados: %d/16\n", creditosPublicacao);
				break;
		}
		return texto;
	}
}
