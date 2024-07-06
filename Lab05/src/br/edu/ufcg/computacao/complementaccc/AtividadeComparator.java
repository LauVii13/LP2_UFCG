package br.edu.ufcg.computacao.complementaccc;

import java.util.Comparator;

/**
 * Classe para definir o requisito de comparação entre as atividades.
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 */
public class AtividadeComparator implements Comparator<Atividade>{
	
	/**
	 * Implementação e definição da comparação de 2 atividades, comparando seu grau de prioridade com base no seu tipo.
	 * @param a1 Primeira Atividade a ser comparada
	 * @param a2 Segunda Atividade a ser comparada
	 * @return int O valor para a troca, neagativo para não trocar, Positivo para trocar.
	 */
	@Override
    public int compare(Atividade a1, Atividade a2) {
        int tipoCompare = getTipoPrioridade(a1.getTipo()) - getTipoPrioridade(a2.getTipo());
        return tipoCompare;
    }
	
	/**
	 * Verifica prioridade do tipo da atividade.
	 * @param tipo O tipo da atividade.
	 * @return O valor do grau de prioridade de cada tipo.
	 * @throws IllegalArgumentException Caso o tipo da atividade não conste nas opções.
	 */
    private int getTipoPrioridade(String tipo) throws IllegalArgumentException {
        switch (tipo) {
            case "estagio":
                return 1;
            case "monitoria":
                return 2;
            case "pesquisa_extensao":
                return 3;
            case "publicacao":
            case "Conferência":
            case "Periódico":
                return 4;
            default:
                throw new IllegalArgumentException("Tipo da atividade incosistente.");
        }
    }
}
