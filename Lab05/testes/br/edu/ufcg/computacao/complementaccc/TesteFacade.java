package br.edu.ufcg.computacao.complementaccc;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteFacade {
	private ComplementaCCCFacade facade;
	
	@BeforeEach
	void setUp() throws Exception {
		this.facade = new ComplementaCCCFacade();
	}
	
	
	//TESTES CRIAR ESTUDANTES
	@Test
	void testCriarEstudante() {
		assertEquals(facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119"), true);
	}
	
	@Test
	void testCriarEstudanteMultiplos() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		assertEquals(facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120"), true);
	}
	
	@Test
	void testCriarEstudanteMultiplosCPFIgual() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		assertEquals(facade.criarEstudante("Gabriel", "123123123-12", 12345678, "123111119"), false);
	}
	
	@Test
	void testCriarEstudanteNomeNull() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarEstudante(null, "123123123-12", 12345678, "123111119");});
		assertEquals(exception.getMessage(), "Nome não pode ser nulo e nem vazio.");
	}

	@Test
	void testCriarEstudanteNomeVazio() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarEstudante("", "123123123-12", 12345678, "123111119");});
		assertEquals(exception.getMessage(), "Nome não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarEstudanteCPFNull() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarEstudante("Vinícius", null, 12345678, "123111119");});
		assertEquals(exception.getMessage(), "CPF não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarEstudanteCPFVazio() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarEstudante("Vinícius", "", 12345678, "123111119");});
		assertEquals(exception.getMessage(), "CPF não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarEstudanteSenhaMaior() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarEstudante("Vinícius", "123123123-12", 123456789 , "123111119");});
		assertEquals(exception.getMessage(), "Senha deve ter exatamente 8 caractéres numéricos.");
	}
	
	@Test
	void testCriarEstudanteSenhaMenor() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarEstudante("Vinícius", "123123123-12", 1234567 , "123111119");});
		assertEquals(exception.getMessage(), "Senha deve ter exatamente 8 caractéres numéricos.");
	}
	
	@Test
	void testCriarEstudantematriculaNull() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarEstudante("Vinícius", "123123123-12", 12345678 , null);});
		assertEquals(exception.getMessage(), "Matrícula não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarEstudantematriculaVazio() {
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarEstudante("Vinícius", "123123123-12", 12345678 , "");});
		assertEquals(exception.getMessage(), "Matrícula não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarEstudanteDuplicado() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		assertEquals(facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119"), false);
	}
	
	//TESTES EXIBIR ESTUDANTES
	@Test
	void testExibirEstudantes() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarEstudante("Zinícius", "123123123-11", 12345678, "123111121");
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		assertArrayEquals(facade.exibirEstudantes("123456789-10", 12345678), new String[] {"Matrícula: 123111120 | Nome: Gabriel | CPF: 321321321-32", "Matrícula: 123111119 | Nome: Vinícius | CPF: 123123123-12", "Matrícula: 123111121 | Nome: Zinícius | CPF: 123123123-11"});
	}
	
	@Test
	void testExibirEstudantesSemAdmin() {
		assertArrayEquals(facade.exibirEstudantes("1231231231-23", 1231231), new String[] {});
	}
	
	@Test
	void testExibirEstudantesSemEstudantes() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertArrayEquals(facade.exibirEstudantes("123456789-10", 12345678), new String[] {});
	}
	
	
	//TESTE ALTERAR ESTUDANTE
	@Test
	void testAlterarEstudanteNome() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		assertEquals(facade.alterarEstudante("123123123-12", 12345678, "nome", "Gabriel"), true);
	}
	
	@Test
	void testAlterarEstudanteNomeNull() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.alterarEstudante("123123123-12", 12345678, "nome", null);});
		assertEquals(exception.getMessage(), "Nome não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testAlterarEstudanteNomeVazio() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.alterarEstudante("123123123-12", 12345678, "nome", "");});
		assertEquals(exception.getMessage(), "Nome não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testAlterarEstudanteSenha() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		assertEquals(facade.alterarEstudante("123123123-12", 12345678, "senha", "44444444"), true);
	}
	
	@Test
	void testAlterarEstudanteSenhaMaior() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.alterarEstudante("123123123-12", 12345678, "senha", "123456789");});
		assertEquals(exception.getMessage(), "Senha deve ter exatamente 8 caractéres numéricos.");
	}
	
	@Test
	void testAlterarEstudanteSenhaMenor() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.alterarEstudante("123123123-12", 12345678, "senha", "1234567");});
		assertEquals(exception.getMessage(), "Senha deve ter exatamente 8 caractéres numéricos.");
	}
	
	@Test
	void testAlterarEstudanteSenhaLetra() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.alterarEstudante("123123123-12", 12345678, "senha", "umaString");});
		assertEquals(exception.getMessage(), "A nova senha deve ter exatamente 8 caractéres numéricos.");
	}
	
	@Test
	void testAlterarEstudanteCPFNull() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		assertEquals(facade.alterarEstudante(null, 12345678, "nome", "Gabriel"), false);
	}
	
	@Test
	void testAlterarEstudanteCPFVazio() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		assertEquals(facade.alterarEstudante("", 12345678, "nome", "Gabriel"), false);
	}
	
	@Test
	void testAlterarEstudanteCPFErrado() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		assertEquals(facade.alterarEstudante("321321321-32", 12345678, "nome", "Gabriel"), false);
	}
	
	@Test
	void testAlterarEstudanteSenhaErrada() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		assertEquals(facade.alterarEstudante("123123123-12", 87654321, "nome", "Gabriel"), false);
	}
	
	@Test
	void testAlterarEstudanteTipoAlteracaoInvalida() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		assertEquals(facade.alterarEstudante("123123123-12", 87654321, "email", "Gabriel"), false);
	}
	
	@Test
	void testAlterarEstudanteTipoAlteracaoVazia() {
		facade.criarEstudante("Vinícius", "123123123-12", 12345678, "123111119");
		assertEquals(facade.alterarEstudante("123123123-12", 87654321, null , "Gabriel"), false);
	}
	
	//TESTE EXIBIR ADMIN
	@Test
	void testExibirAdminSemAdmin() {
		assertEquals(facade.exibirAdmin("12340", 12345678), "");
	}
	
	@Test
	void testExibirAdmin() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertEquals(facade.exibirAdmin("123456789-10", 12345678), "Nome: novoAdmin | CPF: 123456789-10");
	}
	
	@Test
	void testExibirAdminCredencialErrada() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertEquals(facade.exibirAdmin("111111111-10", 12345678), "");
	}
	
	//TESTE CONFIGURAR NOVO ADMIN
	@Test
	void testConfigurarNovoAdminPrimeiraVez() {
		assertEquals(facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678), true);
	}
	
	@Test
	void testConfigurarNovoAdminMudarAtual() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertEquals(facade.configurarNovoADMIN("123456789-10", 12345678, "novoAdmin", "111111111-10", 12341234), true);
	}
	
	@Test
	void testConfigurarNovoAdminMudarAtualErro() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertEquals(facade.configurarNovoADMIN("", 0, "Admin2", "111111111-10", 12341234), false);
	}
	
	//TESTE MUDAR SENHA ADMIN
	@Test
	void testMudarSenhaAdmin() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertEquals(facade.configurarSenhaADMIN("123456789-10", 12345678, 12341234), true);
	}
	
	@Test
	void testMudarSenhaAdminCPFInvalido() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertEquals(facade.configurarSenhaADMIN("123456789-00", 12345678, 12341234), false);
	}
	
	@Test
	void testMudarSenhaAdminSenhaInvalida() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertEquals(facade.configurarSenhaADMIN("123456789-10", 00000, 12341234), false);
	}
	
	
	//----------------------------------------//
	
	//TESTE ADICIONAR ITEM FAQ (1 e 2)
	
	@Test
	void testAdicionarItemFAQ1() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertEquals(facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta teste."), true);
	}
	
	@Test
	void testAdicionarItemFAQ1PerguntaNull() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.adicionarItemFAQ("123456789-10", 12345678, null);});
		assertEquals(exception.getMessage(), "Pergunta não pode ser um texto null nem vazio.");
	}
	
	@Test
	void testAdicionarItemFAQ1PerguntaVazia() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.adicionarItemFAQ("123456789-10", 12345678, "");});
		assertEquals(exception.getMessage(), "Pergunta não pode ser um texto null nem vazio.");
	}
	
	@Test
	void testAdicionarItemFAQ1Multiplas() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		assertEquals(facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 2"), true);
	}
	
	@Test
	void testAdicionarItemFAQ1Duplicado() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		assertEquals(facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1"), false);
	}
	
	@Test
	void testAdicionarItemFAQ2() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertEquals(facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1", "Resposta 1"), true);
	}
	
	@Test
	void testAdicionarItemFAQ2PerguntaNull() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.adicionarItemFAQ("123456789-10", 12345678, null, "Resposta 1");});
		assertEquals(exception.getMessage(), "Pergunta não pode ser um texto null nem vazio.");
	}
	
	@Test
	void testAdicionarItemFAQ2PerguntaVazia() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.adicionarItemFAQ("123456789-10", 12345678, "", "Resposta 1");});
		assertEquals(exception.getMessage(), "Pergunta não pode ser um texto null nem vazio.");
	}
	
	@Test
	void testAdicionarItemFAQ2RespostaNull() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1", null);});
		assertEquals(exception.getMessage(), "Resposta não pode ser um texto null nem vazio.");
	}
	
	@Test
	void testAdicionarItemFAQ2RespostaVazia() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1", "");});
		assertEquals(exception.getMessage(), "Resposta não pode ser um texto null nem vazio.");
	}
	
	@Test
	void testAdicionarItemFAQ2Multiplas() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1", "Resposta 1");
		assertEquals(facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 2", "Resposta 2"), true);
	}
	
	@Test
	void testAdicionarItemFAQ2Duplicado() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1", "Resposta 1");
		assertEquals(facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1", "Resposta 1"), false);
	}
	
	@Test
	void testAdicionarItemFAQ1E2Duplicado() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		assertEquals(facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1", "Resposta 1"), false);
	}
	
	//TESTE ALTERAR RESPOSTA ITEM
	
	@Test
	void testAlterarRespostaItem() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		assertEquals(facade.alteraRespostaItem("123456789-10", 12345678, 1, "Nova Resposta 1"), true);
	}
	
	@Test
	void testAlterarRespostaItemRespostaNull() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.alteraRespostaItem("123456789-10", 12345678, 1, null);});
		assertEquals(exception.getMessage(), "Resposta não pode ser um texto null nem vazio.");
	}
	
	@Test
	void testAlterarRespostaItemRespostaVazia() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.alteraRespostaItem("123456789-10", 12345678, 1, "");});
		assertEquals(exception.getMessage(), "Resposta não pode ser um texto null nem vazio.");
	}
	
	@Test
	void testAlterarRespostaItemIndiceErrado() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 2");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.alteraRespostaItem("123456789-10", 12345678, 3, "Resposta 3");});
		assertEquals(exception.getMessage(), "O índice não corresponde a nehum item cadastrado.");
	}
	
	//TESTE LISTAR FAQ 1 e 2 + DESTACAR ITEM
	@Test
	void testListarFAQ() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 2", "Resposta 2");
		facade.atribuirTagsItemFAQ("123456789-10", 12345678, 1, new String[]{"Dúvida 1", "Dúvida 2"});
		assertArrayEquals(facade.listarFAQ(), new String[] {String.format("Tags: [Dúvida 1, Dúvida 2]\nPergunta: Pergunta 1\nResposta: \nDestaque: 0"), String.format("Tags: []\nPergunta: Pergunta 2\nResposta: Resposta 2\nDestaque: 0")});
	}
	
	@Test
	void testListarFAQVazio() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertArrayEquals(facade.listarFAQ(), new String[] {});
	}
	
	@Test
	void listarFAQPorDestaque() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 2", "Resposta 2");
		facade.atribuirTagsItemFAQ("123456789-10", 12345678, 1, new String[]{"Dúvida 1", "Dúvida 2"});
		facade.destacarItem(2);
		facade.destacarItem(1);
		facade.destacarItem(2);
		assertArrayEquals(facade.listarFAQPorDestaque(), new String[] {String.format("Tags: []\nPergunta: Pergunta 2\nResposta: Resposta 2\nDestaque: 2"), String.format("Tags: [Dúvida 1, Dúvida 2]\nPergunta: Pergunta 1\nResposta: \nDestaque: 1")});
	}
	
	@Test
	void listarFAQPorDestaqueMesmaQtd() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 2", "Resposta 2");
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 3", "Resposta 3");
		facade.atribuirTagsItemFAQ("123456789-10", 12345678, 1, new String[]{"Dúvida 1", "Dúvida 2"});
		facade.atribuirTagsItemFAQ("123456789-10", 12345678, 3, new String[]{"Dúvida 3", "Dúvida 4", "Dúvida 4", "Dúvida 6"});
		facade.destacarItem(3);
		facade.destacarItem(1);
		assertArrayEquals(facade.listarFAQPorDestaque(), new String[] {String.format("Tags: [Dúvida 1, Dúvida 2]\nPergunta: Pergunta 1\nResposta: \nDestaque: 1"), String.format("Tags: [Dúvida 3, Dúvida 4, Dúvida 6]\nPergunta: Pergunta 3\nResposta: Resposta 3\nDestaque: 1"), String.format("Tags: []\nPergunta: Pergunta 2\nResposta: Resposta 2\nDestaque: 0")});
	}
	
	@Test
	void testListarFAQPorDestaqueVazio() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertArrayEquals(facade.listarFAQPorDestaque(), new String[] {});
	}
	

	//TESTE DESTACAR ITEM
	@Test
	void testDestacarItem() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		assertEquals(facade.destacarItem(1), true);
	}
	
	@Test
	void testDestacarItemIndiceErrado() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.destacarItem(2);});
		assertEquals(exception.getMessage(), "O índice não corresponde a nehum item cadastrado.");
	}
	
	//TESTE BUSCAR ITEM FAQ POR TAG
	@Test
	void testBuscarItemFAQ() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 2", "Resposta 2");
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 3", "Resposta 3");
		facade.atribuirTagsItemFAQ("123456789-10", 12345678, 1, new String[]{"Dúvida 1", "Dúvida 2"});
		facade.atribuirTagsItemFAQ("123456789-10", 12345678, 2, new String[]{"Dúvida 8"});
		facade.atribuirTagsItemFAQ("123456789-10", 12345678, 3, new String[]{"Dúvida 3", "Dúvida 4", "Dúvida 4", "Dúvida 6"});
		assertArrayEquals(facade.buscarItemFAQ(new String[] {"Dúvida 1", "Dúvida 4", "Dúvida 7"}), new String[] {String.format("Tags: [Dúvida 1, Dúvida 2]\nPergunta: Pergunta 1\nResposta: \nDestaque: 0"), String.format("Tags: [Dúvida 3, Dúvida 4, Dúvida 6]\nPergunta: Pergunta 3\nResposta: Resposta 3\nDestaque: 0")});
	}
	
	@Test
	void testBuscarItemFAQSemDestaque() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 1");
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 2", "Resposta 2");
		facade.adicionarItemFAQ("123456789-10", 12345678, "Pergunta 3", "Resposta 3");
		assertArrayEquals(facade.buscarItemFAQ(new String[] {"Dúvida 1", "Dúvida 4", "Dúvida 7"}), new String[] {});
	}
	
	@Test
	void testBuscarItemFAQSemItens() {
		facade.configurarNovoADMIN("", 0, "novoAdmin", "123456789-10", 12345678);
		assertArrayEquals(facade.buscarItemFAQ(new String[] {"Dúvida 1", "Dúvida 4", "Dúvida 7"}), new String[] {});
	}
	
	//----------------------------------------//
	
	//TESTE ATIVIDADE MONITORIA
	@Test
	void testCriarAtividadeMonitoria(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		assertEquals(facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 12, "LP2"), "321321321-32_1");
	}
	
	@Test
	void testCriarAtividadeMonitoriaValidacaoErro(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		assertEquals(facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 12345678, "Monitoria", 12, "LP2"), "");
	}
	
	@Test
	void testCriarAtividadeMonitoriaUnidadeAcumuladaErro(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 0, "LP2");});
		assertEquals(exception.getMessage(), "Unidade mínima para esta atividade ser contabilizada é 6 meses (1 semestre).");
		
	}
	
	@Test
	void testCriarAtividadeMonitoriaTipoVazio(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "", 12, "LP2");});
		assertEquals(exception.getMessage(), "Tipo não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadeMonitoriaTipoNulo(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, null, 12, "LP2");});
		assertEquals(exception.getMessage(), "Tipo não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadeMonitoriaDisciplinaVazia(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 12, "");});
		assertEquals(exception.getMessage(), "Disciplina não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadeMonitoriaDisciplinaNulo(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 0, null);});
		assertEquals(exception.getMessage(), "Disciplina não pode ser nulo e nem vazio.");
	}
	
	// TESTE ALTERAR DESCRICAO
	@Test
	void testAlterarDescricaoAtividade(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 12, "LP2");
		assertEquals(facade.alterarDescricaoAtividade("321321321-32", 87654321, "321321321-32_1", "Teste"), true);
	}
	
	@Test
	void testAlterarDescricaoAtividadeCodigoErrado(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 12, "LP2");
		assertEquals(facade.alterarDescricaoAtividade("321321321-32", 87654321, "321321321-32_2", "Teste"), false);
	}
	
	@Test
	void testAlterarDescricaoAtividadeCodigoNull(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 12, "LP2");
		assertEquals(facade.alterarDescricaoAtividade("321321321-32", 87654321, null, "Teste"), false);
	}
	
	@Test
	void testAlterarDescricaoAtividadeDescricaoNull(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 12, "LP2");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.alterarDescricaoAtividade("321321321-32", 87654321, "321321321-32_1", null);});
		assertEquals(exception.getMessage(), "Descricao não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testAlterarDescricaoAtividadeDescricaoVazio(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 12, "LP2");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.alterarDescricaoAtividade("321321321-32", 87654321, "321321321-32_1", "");});
		assertEquals(exception.getMessage(), "Descricao não pode ser nulo e nem vazio.");
	}
	
	// TESTE ALTERAR COMPROVACAO ATIVIDADE
	@Test
	void alterarComprovacaoAtv() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 12, "LP2");
		assertEquals(facade.alterarComprovacaoAtividade("321321321-32", 87654321, "321321321-32_1", "LINK 1"), true);
	}
	
	@Test
	void alterarComprovacaoAtvCodigoErrado() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 12, "LP2");
		assertEquals(facade.alterarComprovacaoAtividade("321321321-32", 87654321, "321321321-32_2", "LINK 1"), false);
	}
	
	@Test
	void alterarComprovacaoAtvCodigoNull() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 12, "LP2");
		assertEquals(facade.alterarComprovacaoAtividade("321321321-32", 87654321, null, "LINK 1"), false);
	}
	
	@Test
	void testAlterarDescricaoAtividadeLinkNull(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 12, "LP2");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.alterarComprovacaoAtividade("321321321-32", 87654321, "321321321-32_1", null);});
		assertEquals(exception.getMessage(), "Comprovante não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testAlterarDescricaoAtividadeLinkVazio(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 12, "LP2");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.alterarComprovacaoAtividade("321321321-32", 87654321, "321321321-32_1", "");});
		assertEquals(exception.getMessage(), "Comprovante não pode ser nulo e nem vazio.");
	}
	
	// TESTE CRIAR ATIVIDADE PESQUISA EXTENSAO
	void testCriarAtividadePesquisaExtensao(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		assertEquals(facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "Pesquisa de Extensão", 12, "LP2"), "321321321-32_1");
	}
	
	@Test
	void testCriarAtividadePesquisaExtensaoValidacaoErro(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		assertEquals(facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 12345678, "Pesquisa de Extensão", 12, "LP2"), "");
	}
	
	@Test
	void testCriarAtividadePesquisaExtensaoUnidadeAcumuladaZero(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		assertEquals(facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "Pesquisa de Extensão", 0, "LP2"), "321321321-32_1");
	}
	
	@Test
	void testCriarAtividadePesquisaExtensaoTipoVazio(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "", 0, "LP2");});
		assertEquals(exception.getMessage(), "Tipo não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadePesquisaExtensaoTipoNulo(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, null, 0, "LP2");});
		assertEquals(exception.getMessage(), "Tipo não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadePesquisaExtensaoDisciplinaVazia(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "Pesquisa de Extensão", 0, "");});
		assertEquals(exception.getMessage(), "Disciplina não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadePesquisaExtensaoDisciplinaNulo(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "Pesquisa de Extensão", 0, null);});
		assertEquals(exception.getMessage(), "Disciplina não pode ser nulo e nem vazio.");
	}
	
	// TESTE CRIAR ATIVIDADE ESTAGIO
	void testCriarAtividadeEstagio(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		assertEquals(facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "Estagio", 12, "LP2"), "321321321-32_1");
	}
	
	@Test
	void testCriarAtividadeEstagioValidacaoErro(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		assertEquals(facade.criarAtividadeEstagioEmEstudante("321321321-32", 12345678, "Estagio", 12, "LP2"), "");
	}
	
	@Test
	void testCriarAtividadeEstagioUnidadeAcumuladaZero(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		assertEquals(facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "Estagio", 0, "LP2"), "321321321-32_1");
	}
	
	@Test
	void testCriarAtividadeEstagioTipoVazio(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "", 0, "LP2");});
		assertEquals(exception.getMessage(), "Tipo não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadeEstagioTipoNulo(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, null, 0, "LP2");});
		assertEquals(exception.getMessage(), "Tipo não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadeEstagioDisciplinaVazia(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "Estagio", 0, "");});
		assertEquals(exception.getMessage(), "Disciplina não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadeEstagioDisciplinaNulo(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "Estagio", 0, null);});
		assertEquals(exception.getMessage(), "Disciplina não pode ser nulo e nem vazio.");
	}
	
	// TESTE CRIAR ATIVIDADE PUBLICACAO
	@Test
	void testCriarAtividadePublicacao(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		assertEquals(facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Titulo", "doi", "A1"), "321321321-32_1");
	}
	
	@Test
	void testCriarAtividadePublicacaoValidacaoErro(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		assertEquals(facade.criarAtividadePublicacaoEmEstudante("321321321-32", 12345678, "Periódico", "Titulo 1", "Doi", "A1"), "");
	}
	
	@Test
	void testCriarAtividadePublicacaoTituloVazio(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "CONFERÊNCIA", "", "Doi", "A1");});
		assertEquals(exception.getMessage(), "Título do artigo não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadePublicacaoTituloNull(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "PERIÓDICO", null, "Doi", "A1");});
		assertEquals(exception.getMessage(), "Título do artigo não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadePublicacaoDoiVazio(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "CONFERÊNCIA", "Título 1", "", "A1");});
		assertEquals(exception.getMessage(), "Doi não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadePublicacaoDoiNull(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Titulo 1", null, "A1");});
		assertEquals(exception.getMessage(), "Doi não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadePublicacaoQualisVazio(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Conferência", "Título 1", "Doi", "");});
		assertEquals(exception.getMessage(), "Qualis não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadePublicacaoQualisNull(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Título 1", "Doi", null);});
		assertEquals(exception.getMessage(), "Qualis não pode ser nulo e nem vazio.");
	}
	
	@Test
	void testCriarAtividadePublicacaoQualisNaoIdentificado(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Título 1", "Doi", "A7");});
		assertEquals(exception.getMessage(), "Qualis não identificado.");
	}
	
	//TESTE CREDITOS ATIVIDADE
	@Test
	void testCreditosAtividadeMonitoriaMin() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 6, "LP2");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 4);
	}
	
	@Test
	void testCreditosAtividadeMonitoriaMax() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 24, "LP2");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 16);
	}
	
	@Test
	void testCreditosAtividadeMonitoriaMaxMais() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 25, "LP2");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 16);
	}
	
	
	
	
	@Test
	void testCreditosAtividadeEstagioMin() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "Estagio", 300, "LP2");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 5);
	}
	
	@Test
	void testCreditosAtividadeEstagioMinMenos() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "Estagio", 299, "LP2");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 0);
	}
	
	@Test
	void testCreditosAtividadeEstagioMax() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "Estagio", 1080, "LP2");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 18);
	}
	
	@Test
	void testCreditosAtividadeEstagioMaxMais() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "Estagio", 2000, "LP2");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 18);
	}
	
	
	
	
	@Test
	void testCreditosAtividadePesquisaExtensaoMin() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "Pesquisa de Extensão", 12, "LP2");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 10);
	}
	
	@Test
	void testCreditosAtividadePesquisaExtensaoMinMenos() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "Pesquisa de Extensão", 11, "LP2");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 0);
	}
	
	@Test
	void testCreditosAtividadePesquisaExtensaoMax() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "Pesquisa de Extensão", 22, "LP2");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 18);
	}
	
	@Test
	void testCreditosAtividadePesquisaExtensaoMaxMais() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "Pesquisa de Extensão", 40, "LP2");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 18);
	}
	
	

	@Test
	void testCreditosAtividadePublicacao(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Titulo", "doi", "A1");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 4);
	}
	
	@Test
	void testCreditosAtividadePublicacaoConferencia(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Conferência", "Titulo", "doi", "A1");
		assertEquals(facade.creditosAtividade("321321321-32", 87654321, "321321321-32_1"), 3);
	}
	
	@Test
	void testCreditosAtividadePublicacaoErro(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		Throwable exception = assertThrows(IllegalArgumentException.class, ()->{facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Titulo", "doi", "A8");});
		assertEquals(exception.getMessage(), "Qualis não identificado.");
	}
	
	
	
	
	@Test
	void testCreditosAtividadeCodigoErro() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "Monitoria", 25, "LP2");
		Throwable exception = assertThrows(NullPointerException.class, ()->{facade.creditosAtividade("321321321-32", 87654321, "321321321-32_2");});
		assertEquals(exception.getMessage(), "Atividade não encontrada.");
	}
	
	//TESTE CRIAR RELATORIO COMPLETO
	@Test
	void testRelatorioCompleto(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "monitoria", 6, "LP2");
		facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Titulo", "doi", "A1");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 300, "LP2");
		facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "pesquisa_extensao", 12, "LP2");
		
		assertEquals(facade.criarRelatorioCompleto("321321321-32", 87654321), 1);
	}
	
	@Test
	void testRelatorioResumido(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "monitoria", 6, "LP2");
		facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Titulo", "doi", "A1");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 300, "LP2");
		facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "pesquisa_extensao", 12, "LP2");
		
		assertEquals(facade.criarRelatorioResumido("321321321-32", 87654321), 1);
	}
	
	@Test
	void testRelatorioPorAtv(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "monitoria", 6, "D1");
		facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Titulo", "doi", "A1");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 300, "D2");
		facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "pesquisa_extensao", 12, "D3");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 200, "D4");
		
		assertEquals(facade.criarRelatorioPorATV("321321321-32", 87654321, "publicacao"), 1);
	}
	
	@Test
	void testExibirRelatorio(){
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "monitoria", 6, "D1");
		facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Titulo", "doi", "A1");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 300, "D2");
		facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "pesquisa_extensao", 12, "D3");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 200, "D4");
		facade.alterarDescricaoAtividade("321321321-32", 87654321, "321321321-32_3", "Descricao Teste");
		facade.alterarComprovacaoAtividade("321321321-32", 87654321, "321321321-32_2", "linkComprovacao.com");
		facade.criarRelatorioCompleto("321321321-32", 87654321);
		assertEquals(facade.exibirRelatorio("321321321-32", 87654321, 1), String.format(""
				+ "Nome: Gabriel\n"
				+ "CPF: 321321321-32\n"
				+ "Matrícula: 123111120\n"
				+ "Créditos Acumulados ao todo: 26\n"
				+ "--------------------------------\n"
				+ "Estágios | Créditos Acumulados: 8\n"
				+ "\n"
				+ "Disciplina: D2\n"
				+ "Descrição: Descricao Teste\n"
				+ "Comprovante: \n"
				+ "Creditos na atividade: 5\n"
				+ "\n"
				+ "Disciplina: D4\n"
				+ "Descrição: \n"
				+ "Comprovante: \n"
				+ "Creditos na atividade: 0\n"
				+ "--------------------------------\n"
				+ "Monitorias | Créditos Acumulados: 4\n"
				+ "\n"
				+ "Disciplina: D1\n"
				+ "Descrição: \n"
				+ "Comprovante: \n"
				+ "Creditos na atividade: 4\n"
				+ "--------------------------------\n"
				+ "Pesquisas de Extensão | Créditos Acumulados: 10\n"
				+ "\n"
				+ "Disciplina: D3\n"
				+ "Descrição: \n"
				+ "Comprovante: \n"
				+ "Creditos na atividade: 10\n"
				+ "--------------------------------\n"
				+ "Publicações| Créditos Acumulados: 4\n"
				+ "\n"
				+ "Título do Artigo: Titulo\n"
				+ "DOI: doi\n"
				+ "Qualis: A1\n"
				+ "Descrição: \n"
				+ "Comprovante: linkComprovacao.com\n"
				+ "Creditos na atividade: 4\n"
				+ "--------------------------------"));
	}
	
	@Test
	void testExibirRelatorioResumido() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "monitoria", 6, "D1");
		facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Titulo", "doi", "A1");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 300, "D2");
		facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "pesquisa_extensao", 12, "D3");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 200, "D4");
		facade.alterarDescricaoAtividade("321321321-32", 87654321, "321321321-32_3", "Descricao Teste");
		facade.alterarComprovacaoAtividade("321321321-32", 87654321, "321321321-32_2", "linkComprovacao.com");
		facade.criarRelatorioResumido("321321321-32", 87654321);
		assertEquals(facade.exibirRelatorio("321321321-32", 87654321, 1), ""
				+ "Nome: Gabriel\n"
				+ "CPF: 321321321-32\n"
				+ "Matrícula: 123111120\n"
				+ "Estágios | Créditos Acumulados: 8/18\n"
				+ "Monitorias | Créditos Acumulados: 4/16\n"
				+ "Pesquisas de Extensão | Créditos Acumulados: 10/18\n"
				+ "Publicações| Créditos Acumulados: 4/16\n");
	}
	
	@Test
	void testExibirRelatorioResumidoMax() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "monitoria", 6, "D1");
		facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Titulo", "doi", "A1");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 500, "D2");
		facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "pesquisa_extensao", 12, "D3");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 900, "D4");
		facade.alterarDescricaoAtividade("321321321-32", 87654321, "321321321-32_3", "Descricao Teste");
		facade.alterarComprovacaoAtividade("321321321-32", 87654321, "321321321-32_2", "linkComprovacao.com");
		facade.criarRelatorioResumido("321321321-32", 87654321);
		assertEquals(facade.exibirRelatorio("321321321-32", 87654321, 1), ""
				+ "Nome: Gabriel\n"
				+ "CPF: 321321321-32\n"
				+ "Matrícula: 123111120\n"
				+ "Estágios | Créditos Acumulados: 18/18\n"
				+ "Monitorias | Créditos Acumulados: 4/16\n"
				+ "Pesquisas de Extensão | Créditos Acumulados: 10/18\n"
				+ "Publicações| Créditos Acumulados: 4/16\n");
	}
	
	@Test
	void testExibirRelatorioResumidoInsuficiente() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "monitoria", 6, "D1");
		facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Titulo", "doi", "A1");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 150, "D2");
		facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "pesquisa_extensao", 12, "D3");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 100, "D4");
		facade.alterarDescricaoAtividade("321321321-32", 87654321, "321321321-32_3", "Descricao Teste");
		facade.alterarComprovacaoAtividade("321321321-32", 87654321, "321321321-32_2", "linkComprovacao.com");
		facade.criarRelatorioResumido("321321321-32", 87654321);
		assertEquals(facade.exibirRelatorio("321321321-32", 87654321, 1), ""
				+ "Nome: Gabriel\n"
				+ "CPF: 321321321-32\n"
				+ "Matrícula: 123111120\n"
				+ "Estágios | Créditos Acumulados: NAO ATINGIU AINDA O VALOR MÍNIMO\n"
				+ "Monitorias | Créditos Acumulados: 4/16\n"
				+ "Pesquisas de Extensão | Créditos Acumulados: 10/18\n"
				+ "Publicações| Créditos Acumulados: 4/16\n");
	}
	
	@Test
	void testExibirRelatorioPorATV() {
		facade.criarEstudante("Gabriel", "321321321-32", 87654321, "123111120");
		facade.criarAtividadeMonitoriaEmEstudante("321321321-32", 87654321, "monitoria", 6, "D1");
		facade.criarAtividadePublicacaoEmEstudante("321321321-32", 87654321, "Periódico", "Titulo", "doi", "A1");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 150, "D2");
		facade.criarAtividadePesquisaExtensaoEmEstudante("321321321-32", 87654321, "pesquisa_extensao", 12, "D3");
		facade.criarAtividadeEstagioEmEstudante("321321321-32", 87654321, "estagio", 200, "D4");
		facade.alterarDescricaoAtividade("321321321-32", 87654321, "321321321-32_3", "Descricao Teste");
		facade.alterarComprovacaoAtividade("321321321-32", 87654321, "321321321-32_2", "linkComprovacao.com");
		facade.criarRelatorioPorATV("321321321-32", 87654321, "estagio");
		assertEquals(facade.exibirRelatorio("321321321-32", 87654321, 1), ""
				+ "Nome: Gabriel\n"
				+ "CPF: 321321321-32\n"
				+ "Matrícula: 123111120\n"
				+ "Estágios | Créditos Acumulados: 5/18\n");
	}	
}
