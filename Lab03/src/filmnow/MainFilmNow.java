package filmnow;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular o sistema FilmNow.
 * 
 * @author eliane
 *
 */
public class MainFilmNow {

	public static void main(String[] args) {
		FilmNow fn = new FilmNow();

		System.out.println("Carregando filmes ...");
		try {
			carregaFilmes("filmes_inicial.csv", fn);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, fn, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário/a.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(A)Adicionar filme\n" + 
						"(M)Mostrar todos\n" + 
						"(D)Detalhar filme\n" + 
						"(E)Exibir HotList\n" +
						"(H)Atribuir Hot\n" +
						"(R)Remover Hot\n" +
						"(S)Sair\n" + 
						"\n" + 
						"Opção> ");
		return scanner.nextLine().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao Opção digitada.
	 * @param fn O sistema FilmNow que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, FilmNow fn, Scanner scanner) {
		switch (opcao) {
		case "A":
			adicionaFilme(fn, scanner);
			break;
		case "M":
			mostrarFilmes(fn);
			break;
		case "D":
			detalharFilme(fn, scanner);
			break;
		case "E":
			exibirHotList(fn);
			break;
		case "H":
			adicionaHotList(fn, scanner);
			break;
		case "R":
			removeHotList(fn, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}

	/**
	 * Imprime lista de filmes.
	 * Padrão: "POSICAO - NOME", um por linha
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 */
	private static void mostrarFilmes(FilmNow fn) {
		Filme[] listaFilmes = fn.getFilmes();
		for (int i = 0; i < listaFilmes.length; i++) {
			if (listaFilmes[i] != null) { 
				System.out.println(formataFilme(i+1, listaFilmes[i].getNome()));
			}
		}
	}
	
	/**
	 * Formata um filme para impressão. 
	 * 
	 * @param posicao A posição do filme (que é exibida)
	 * @param filme O filme a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataFilme(int posicao, String filme) {
		return posicao + " - " + filme;
	}

	/**
	 * Imprime os detalhes de um dos filmes. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para capturar qual a posição do filme a ser mostrado.
	 */
	private static void detalharFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nQual filme> ");
		int posicao = Integer.parseInt(scanner.nextLine());
		String filme = fn.getFilme(posicao);
		if(filme == "") {
			System.out.println("POSIÇÃO INVÁLIDA!");
		}else {
			System.out.println("Dados do filme:\n" + filme);			
		}
	}

	/**
	 * Cadastra um filme no sistema. 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaFilme(FilmNow fn, Scanner scanner) {
		System.out.print("\nPosição no sistema> ");
		String posicao = scanner.nextLine();
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		System.out.print("\nAno> ");
		String ano = scanner.nextLine();
		System.out.print("\nLocal> ");
		String local = scanner.nextLine();
		System.out.println(fn.cadastraFilme(Integer.parseInt(posicao), nome, ano, local));
	}
	
	/**
	 * Imprime lista de filmes da HotList.
	 * Padrão: "POSICAO - NOME, ANO", um por linha.
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 */
	private static void exibirHotList(FilmNow fn) {
		Filme[] listaFilmes = fn.getHotFilmes();
		for (int i = 0; i < listaFilmes.length; i++) {
			if (listaFilmes[i] != null) { 
				System.out.println(formataFilme(i+1, listaFilmes[i].getNome()) + ", " + listaFilmes[i].getAno());
			}
		}
	}
	/**
	 * Cadastra um filme na lista de prioridade (HotList). 
	 * 
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaHotList(FilmNow fn, Scanner scanner) {
		System.out.print("\nFilme> ");
		int posicaoFilme = Integer.parseInt(scanner.nextLine());
		System.out.print("\nPosicao> ");
		int posicaoHotList = Integer.parseInt(scanner.nextLine());

		System.out.println(fn.adicionaHotList(posicaoFilme, posicaoHotList));
	}
	
	/**
	 * Remove um filme da lista de prioridade (HotList).
	 * @param fn O sistema FilmNow a ser manipulado.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void removeHotList(FilmNow fn, Scanner scanner) {
		System.out.print("\nPosicao> ");
		int posicaoHotList = Integer.parseInt(scanner.nextLine());
		
		System.out.print(fn.removeHotList(posicaoHotList));
		
	}
	
	
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê carga de filmes de um arquivo csv. 
	 * 
	 * @param arquivoFilmes O caminho para o arquivo.
	 * @param fn O sistema FilmNow a ser populado com os dados.
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaFilmes(String arquivoFilmes, FilmNow fn) throws FileNotFoundException, IOException {
		LeitorFilmNow leitor = new LeitorFilmNow();
		
		int carregados =  leitor.carregaContatos(arquivoFilmes, fn);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
