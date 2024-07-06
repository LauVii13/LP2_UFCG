package br.edu.ufcg.computacao.complementaccc;

/**
 * Classe que define um Relatório Completo.
 * 
  * @author Vinícius Gabriel Laureano - 123111119
 */
public class RelatorioCompleto extends Relatorio{
	
	/**
	 * Constrói o relatório completo.
	 * @param e O estudante responsável ao relatório.
	 */
	public RelatorioCompleto(Estudante e) {
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
					textoEstagio += String.format("\n%s", atv.toString());
					break;
				case "monitoria":
					totCreditosMonitoria += atv.getCreditos();
					textoMonitoria += String.format("\n%s", atv.toString());
					break;
				case "pesquisa_extensao":
					totTempoPesquisaExtensao += atv.getValorAcumulado();
					textoPesquisaExtensao += String.format("\n%s", atv.toString());
					break;
				case "publicacao":
				case "Conferência":
				case "Periódico":
					totCreditosPublicacao += atv.getCreditos();
					textoPublicacao += String.format("\n%s", atv.toString());
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
		
		int somaCreditos = creditosEstagio + creditosMonitoria + creditosPublicacao + creditosPesquisaExtensao;
		texto += String.format("Créditos Acumulados ao todo: %d\n", somaCreditos);
		texto += "--------------------------------";
		texto += String.format("\nEstágios | Créditos Acumulados: %d\n%s", creditosEstagio, textoEstagio);
		texto += "--------------------------------";
		texto += String.format("\nMonitorias | Créditos Acumulados: %d\n%s", creditosMonitoria, textoMonitoria);
		texto += "--------------------------------";
		texto += String.format("\nPesquisas de Extensão | Créditos Acumulados: %d\n%s", creditosPesquisaExtensao, textoPesquisaExtensao);
		texto += "--------------------------------";
		texto += String.format("\nPublicações| Créditos Acumulados: %d\n%s", creditosPublicacao, textoPublicacao);
		texto += "--------------------------------";
		
		return texto;
	}
}
