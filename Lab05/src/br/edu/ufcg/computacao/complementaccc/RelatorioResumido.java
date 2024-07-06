package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que define um Relatório de forma resumida e suas funcionalidades.
 * 
  * @author Vinícius Gabriel Laureano - 123111119
 */
public class RelatorioResumido extends Relatorio{
	
	/**
	 * Constrói o relatório resumido do estudante.
	 * @param e O estudante responsável pelo relatório.
	 */
	public RelatorioResumido(Estudante e) {
		super(e);
	}
	
	@Override
	public String toString() {
		String texto = String.format("Nome: %s\nCPF: %s\nMatrícula: %s\n", this.dadosEstudante.getNome(), this.dadosEstudante.getCpf(), this.dadosEstudante.getMatricula());
		String textoEstagio = "";
		String textoMonitoria = "";
		String textoPesquisaExtensao = "";
		String textoPublicacao = "";
		
		int totTempoEstagio = 0;
		int totTempoPesquisaExtensao = 0;
		
		double totCreditosMonitoria = 0;
		double totCreditosPublicacao = 0;
		for(Atividade atv : this.atividades) {
			switch(atv.getTipo()) {
				case "estagio":
					totTempoEstagio += atv.getValorAcumulado();
					break;
				case "monitoria":
					totCreditosMonitoria += atv.getCreditos();
					break;
				case "pesquisa_extensao":
					totTempoPesquisaExtensao += atv.getValorAcumulado();
					break;
				case "publicacao":
				case "Conferência":
				case "Periódico":
					totCreditosPublicacao += atv.getCreditos();
					break;
				default:
					throw new IllegalArgumentException("Tipo de atividade inexistente.");			
				}
		}
		
		double totCreditosEstagio = (totTempoEstagio >= 300) ? Math.min((totTempoEstagio / 60), 18) : 0;
		double totCreditosPesquisaExtensao = (totTempoPesquisaExtensao >= 12) ? Math.min(((totTempoPesquisaExtensao * 10) / 12), 18) : 0;
		
		int creditosEstagio = (int) (Math.floor(Math.min(totCreditosEstagio, 18)));
		int creditosMonitoria = (int) (Math.floor(Math.min(totCreditosMonitoria, 16)));
		int creditosPublicacao = (int) (Math.floor(Math.min(totCreditosPublicacao, 16)));		
		int creditosPesquisaExtensao = (int) (Math.floor(Math.min(totCreditosPesquisaExtensao, 18)));
		
		if(creditosEstagio == 0)
			texto += "Estágios | Créditos Acumulados: NAO ATINGIU AINDA O VALOR MÍNIMO\n";
		else
			texto += String.format("Estágios | Créditos Acumulados: %d/18\n", creditosEstagio);
		
		texto += String.format("Monitorias | Créditos Acumulados: %d/16\n", creditosMonitoria);
		if(creditosPesquisaExtensao == 0)
			texto += "Pesquisas de Extensão | Créditos Acumulados: NAO ATINGIU AINDA O VALOR MÍNIMO\n";
		else
			texto += String.format("Pesquisas de Extensão | Créditos Acumulados: %d/18\n", creditosPesquisaExtensao);
		
		texto += String.format("Publicações| Créditos Acumulados: %d/16\n", creditosPublicacao);
		
		return texto;
	}
}
