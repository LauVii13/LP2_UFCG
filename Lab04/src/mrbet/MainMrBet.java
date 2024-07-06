package mrbet;

import java.util.Scanner;

/**
 * Interface com menus texto para manipular o sistema MrBet.
 * 
 * @author Vinícius Gabriel Laureano - 123111119
 *
 */

public class MainMrBet {

	public static void main(String[] args) {
		MrBetSistema mrBet = new MrBetSistema();
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			String escolha = menu(scanner);
			System.out.println(escolha);
			try {
				executaAcao(mrBet, escolha, scanner);
			}
			catch(IllegalArgumentException ex) {
				System.out.println(ex.getMessage());
				sair();
			}
		}		
	}
	
	/**
	* Exibe o menu e captura a escolha do/a usuário/a.
	* 
	* @param scanner Para captura da opção do usuário/a.
	* @return O comando escolhido.
	*/
	private static String menu(Scanner scanner) {
		System.out.print("(M)Minha inclusão de times\n"
						+ "(R)Recuperar time\n"
						+ "(.)Adicionar campeonato\n"
						+ "(B)Bora incluir time em campeonato e Verificar se time está em campeonato\n"
						+ "(E)Exibir campeonatos que o time participa\n"
						+ "(T)Tentar a sorte e status\n"
						+ "(!)Já pode fechar o programa!\n"
						+ "\n"
						+ "Opção> ");
		
		return(scanner.nextLine().toUpperCase());
	}
	
	/**
	* Interpreta a opção escolhida por quem está usando o sistema.
	* 
	* @param opcao Opção digitada.
	* @param mrBet O sistema mrBet que estamos manipulando.
	* @param scanner Objeto scanner para o caso do comando precisar de mais input.
	*/
	private static void executaAcao(MrBetSistema mrBet, String escolha, Scanner scanner) throws IllegalArgumentException{
		switch(escolha) {
		case "M":
			incluirTimes(mrBet, scanner);
			break;
		case "R":
			recuperarTime(mrBet, scanner);
			break;
		case ".":
			adicionarCampeonato(mrBet, scanner);
			break;
		case "B":
			incluirOuVerificarTime(mrBet, scanner);
			break;
		case "E":
			exibirCampeonatoTime(mrBet, scanner);
			break;
		case "T":
			apostarOuVerificarAposta(mrBet, scanner);
			break;
		case "!":
			sair();
			break;
		default:
			throw new IllegalArgumentException("Opção Inválida!");
		}
	}
	
	/**
	* Inclui um novo Time no sistema.
	* @param mrBet O sistema mrBet que estamos manipulando.
	* @param scanner Objeto scanner para o caso do comando precisar de mais input.
	*/
	private static void incluirTimes(MrBetSistema mrBet, Scanner scanner) {
		System.out.print("Código: ");
		String codigo = scanner.nextLine();
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Mascote: ");
		String mascote = scanner.nextLine();
		System.out.println(mrBet.cadastrarTime(codigo, nome, mascote));
	}
	
	/**
	* Busca o cadastro de  um Time.
	* @param mrBet O sistema mrBet que estamos manipulando.
	* @param scanner Objeto scanner para o caso do comando precisar de mais input.
	*/
	private static void recuperarTime(MrBetSistema mrBet, Scanner scanner) {
		System.out.print("Código: ");
		String codigo = scanner.nextLine();
		System.out.println(mrBet.recuperarTime(codigo));
	}
	
	/**
	* Adiciona um novo Campeonato.
	* @param mrBet O sistema mrBet que estamos manipulando.
	* @param scanner Objeto scanner para o caso do comando precisar de mais input.
	*/
	private static void adicionarCampeonato(MrBetSistema mrBet, Scanner scanner) {
		System.out.print("Campeonato: ");
		String campeonato = scanner.nextLine();
		System.out.print("Participantes: ");
		String participantes = scanner.nextLine();
		System.out.println(mrBet.cadastrarCampeonato(campeonato, Integer.parseInt(participantes)));
	}
	
	/**
	* Interpreta a opção escolhida por quem está usando o sistema para incluir ou verificar um time em um campeonato.
	* @param mrBet O sistema mrBet que estamos manipulando.
	* @param scanner Objeto scanner para o caso do comando precisar de mais input.
	* @throws IllegalArgumentException Erro caso o usuário escolha uma opção diferente das indicadas.
	*/
	private static void incluirOuVerificarTime(MrBetSistema mrBet, Scanner scanner) throws IllegalArgumentException{
		System.out.print("(I) Incluir time em campeonato ou (V) Verificar se time está em campeonato? ");
		String escolha = scanner.nextLine().toUpperCase();
		
		switch(escolha) {
		case "I":
			incluirTime(mrBet, scanner);
			break;
		case "V":
			verificarTime(mrBet, scanner);
			break;
		default:
			throw new IllegalArgumentException("Opção Inválida!");
		}
	}
	
	/**
	* Adiciona um Time do sistema em um Campeonato.
	* @param mrBet O sistema mrBet que estamos manipulando.
	* @param scanner Objeto scanner para o caso do comando precisar de mais input.
	*/
	private static void incluirTime(MrBetSistema mrBet, Scanner scanner) {
		System.out.print("Código: ");
		String codigo = scanner.nextLine();
		System.out.print("Campeonato: ");
		String campeonato = scanner.nextLine();
		System.out.println(mrBet.incluirTimeCampeonato(codigo, campeonato));
	}
	
	/**
	* Verifica se o Times está inserido no Campeonato.
	* @param mrBet O sistema mrBet que estamos manipulando.
	* @param scanner Objeto scanner para o caso do comando precisar de mais input.
	*/
	private static void verificarTime(MrBetSistema mrBet, Scanner scanner) {
		System.out.print("Código: ");
		String codigo = scanner.nextLine();
		System.out.print("Campeonato: ");
		String campeonato = scanner.nextLine();
		System.out.println(mrBet.verificarTimeCampeonato(codigo, campeonato));
	}
	
	/**
	* Exibe todos os Campeonatos no qual o Time participa.
	* @param mrBet O sistema mrBet que estamos manipulando.
	* @param scanner Objeto scanner para o caso do comando precisar de mais input.
	*/
	private static void exibirCampeonatoTime(MrBetSistema mrBet, Scanner scanner) {
		System.out.print("Código: ");
		String codigo = scanner.nextLine();
		System.out.println(mrBet.exibeCampeonatosTime(codigo));
	}
	
	/**
	* Interpreta a opção escolhida por quem está usando o sistema para realizar ou verificar uma aposta.
	* @param mrBet O sistema mrBet que estamos manipulando.
	* @param scanner Objeto scanner para o caso do comando precisar de mais input.
	*/
	private static void apostarOuVerificarAposta(MrBetSistema mrBet, Scanner scanner) throws IllegalArgumentException{
		System.out.print("(A)Apostar ou (S)Status das Apostas? ");
		String escolha = scanner.nextLine().toUpperCase();
		switch(escolha) {
		case "A":
			apostar(mrBet, scanner);
			break;
		case "S":
			verificarAposta(mrBet, scanner);
			break;
		default:
			throw new IllegalArgumentException("Opção Inválida!");
		}
	}
	
	/**
	* Realizar uma nova Aposta.
	* @param mrBet O sistema mrBet que estamos manipulando.
	* @param scanner Objeto scanner para o caso do comando precisar de mais input.
	*/
	private static void apostar(MrBetSistema mrBet, Scanner scanner) {
		System.out.print("Código: ");
		String codigo = scanner.nextLine();
		System.out.print("Campeonato: ");
		String campeonato = scanner.nextLine();
		System.out.print("Colocação: ");
		String colocacao = scanner.nextLine();
		System.out.print("Valor da Apoista: R$");
		String valor = scanner.nextLine();
		System.out.println(mrBet.fazAposta(codigo, campeonato, Integer.parseInt(colocacao), Double.parseDouble(valor)));
	}
	
	/**
	* Busca todas as apostas salvas.
	* @param mrBet O sistema mrBet que estamos manipulando.
	* @param scanner Objeto scanner para o caso do comando precisar de mais input.
	*/
	private static void verificarAposta(MrBetSistema mrBet, Scanner scanner) {
		System.out.print(mrBet.statusApostas());
	}
	
	/**
	* Sai da aplicação.
	*/
	private static void sair() {
		System.exit(0);
	}
}
