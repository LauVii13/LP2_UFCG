package mrbet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mrbet.MrBetSistema;

class mrBetSistemaTest {
	private MrBetSistema mrBet;
	@BeforeEach
	void setUp() throws Exception {
		this.mrBet = new MrBetSistema();
		mrBet.cadastrarTime("250_PB", "Nacional de Patos", "Canário");
		mrBet.cadastrarTime("252_PB", "Sport Lagoa Seca", "Carneiro");
		mrBet.cadastrarTime("002_RJ", "Clube de Regatas do Flamengo", "Urubu");
		mrBet.cadastrarTime("105_PB", "Sociedade Recreativa de Monteiro (SOCREMO)", "Gavião");
	}
	
	@Test
	void testCadastrarTimeNovo(){
		assertEquals(mrBet.cadastrarTime("123_SP", "Santos", "Peixe"), "INCLUSÃO REALIZADA!");
	}
	
	@Test
	void testCadastrarTimeExistente(){
		assertEquals(mrBet.cadastrarTime("250_PB", "Treze", "Galo"), "TIME JÁ EXISTE!");
	}
	
	@Test
	void testRecuperarTime() {
		assertEquals(mrBet.recuperarTime("250_PB"), "[250_PB] Nacional de Patos / Canário");
	}
	
	@Test
	void testRecuperarTimeInexistente() {
		assertEquals(mrBet.recuperarTime("123_SP"), "TIME NÃO EXISTE!");
	}
	
	@Test
	void testCadastrarCampeonato() {
		assertEquals(mrBet.cadastrarCampeonato("Brasileirão série A 2023", 10), "CAMPEONATO ADICIONADO!");
	}
	
	@Test
	void testCadastrarCampeonatoExistente() {
		mrBet.cadastrarCampeonato("Brasileirão série A 2023", 10);
		assertEquals(mrBet.cadastrarCampeonato("Brasileirão série A 2023", 20), "CAMPEONATO JÁ EXISTENTE!");
	}
	
	@Test
	void testIncluirTimeCampeonato() {
		mrBet.cadastrarCampeonato("Brasileirão série A 2023", 10);
		assertEquals(mrBet.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"), "TIME INCLUÍDO NO CAMPEONATO!");
		assertEquals(mrBet.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"), "TIME INCLUÍDO NO CAMPEONATO!");
	}
	
	@Test
	void testIncluirTimeCampeonatoNovamente() {
		mrBet.cadastrarCampeonato("Brasileirão série A 2023", 10);
		mrBet.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023");
		mrBet.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023");
		assertEquals(mrBet.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023"), "TIME INCLUÍDO NO CAMPEONATO!");
	}
	
	@Test
	void testIncluirTimeInexistenteCampeonato() {
		mrBet.cadastrarCampeonato("Brasileirão série A 2023", 10);
		assertEquals(mrBet.incluirTimeCampeonato("005_PB", "Brasileirão série A 2023"), "O TIME NÃO EXISTE!");
	}
	
	@Test
	void testIncluirTimeCampeonatoInexistente() {
		mrBet.cadastrarCampeonato("Brasileirão série A 2023", 10);
		assertEquals(mrBet.incluirTimeCampeonato("252_PB", "Brasileirão série D 2023"), "O CAMPEONATO NÃO EXISTE!");
	}
	
	@Test
	void testIncluirTimeCampeonatoExcesso() {
		mrBet.cadastrarCampeonato("Brasileirão série A 2023", 1);
		mrBet.incluirTimeCampeonato("252_PB", "Brasileirão série A 2023");
		assertEquals(mrBet.incluirTimeCampeonato("250_PB", "Brasileirão série A 2023"), "TODOS OS TIMES DESSE CAMPEONATO JÁ FORAM INCLUÍDOS!");
	}
	
	@Test
	void testTimePertenceCampeonatoTrue() {
		mrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		mrBet.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		assertEquals(mrBet.verificarTimeCampeonato("250_PB", "Copa do Nordeste 2023"), "O TIME ESTÁ NO CAMPEONATO!");
	}
	
	@Test
	void testTimePertenceCampeonatoFalse() {
		mrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		assertEquals(mrBet.verificarTimeCampeonato("252_PB", "Copa do Nordeste 2023"), "O TIME NÃO ESTÁ NO CAMPEONATO!");
	}
	
	@Test
	void testTimePertenceCampeonatoInexistente() {
		assertEquals(mrBet.verificarTimeCampeonato("252_PB", "Brasileirão série D 2023"), "O CAMPEONATO NÃO EXISTE!");
	}
	
	@Test
	void testTimeInexistentePertenceCampeonato() {
		mrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		assertEquals(mrBet.verificarTimeCampeonato("005_PB", "Copa do Nordeste 2023"), "O TIME NÃO EXISTE!");
	}
	
	@Test
	void testExibeCampeonatosTime(){
		mrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		mrBet.cadastrarCampeonato("Brasileirão série A 2023", 20);
		mrBet.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		assertEquals(mrBet.exibeCampeonatosTime("250_PB"), "Campeonatos do Nacional de Patos:\n* Copa do Nordeste 2023 - 1/10\n");
	}
	
	@Test
	void testExibeCampeonatosTimeInexistente(){
		assertEquals(mrBet.exibeCampeonatosTime("123_SP"), "O TIME NÃO EXISTE!");
	}
	
	@Test
	void testFazAposta(){
		mrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		mrBet.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		assertEquals(mrBet.fazAposta("250_PB", "Copa do Nordeste 2023", 2, 50), "APOSTA REGISTRADA!");
	}
	
	@Test
	void testFazApostaTimeInexistente(){
		mrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		assertEquals(mrBet.fazAposta("123_SP", "Copa do Nordeste 2023", 2, 50), "O TIME NÃO EXISTE!");
	}
	
	@Test
	void testFazApostaCampeonatoInexistente(){
		assertEquals(mrBet.fazAposta("250_PB", "Copa do Nordeste 2023", 2, 50), "O CAMPEONATO NÃO EXISTE!");
	}
	
	@Test
	void testFazApostaTimeForaCampeonato(){
		mrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		assertEquals(mrBet.fazAposta("250_PB", "Copa do Nordeste 2023", 2, 50), "O TIME NÃO ESTÁ NO CAMPEONATO!");
	}
	
	@Test
	void testFazApostaExcedeLimite(){
		mrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		mrBet.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		assertEquals(mrBet.fazAposta("250_PB", "Copa do Nordeste 2023", 11, 50), "APOSTA NÃO REGISTRADA!");
	}
	
	@Test
	void testStatusAposta(){
		mrBet.cadastrarCampeonato("Copa do Nordeste 2023", 10);
		mrBet.incluirTimeCampeonato("250_PB", "Copa do Nordeste 2023");
		mrBet.fazAposta("250_PB", "Copa do Nordeste 2023", 2, 50);
		assertEquals(mrBet.statusApostas(), "1. [250_PB] Nacional de Patos / Canário\nCopa do Nordeste 2023\n2/10\nR$50,00\n\n");
	}
	
}
