package filmnow;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilmNowTest {
	private FilmNow fn;
	@BeforeEach
	void setUp() throws Exception {
		this.fn = new FilmNow();
	}

	@Test
	void testCadastraFilme() {
		assertEquals(fn.cadastraFilme(1, "20 dias em Mariupol", "2023", "Cinema"), "FILME ADICIONADO");
	}
	
	@Test
	void testCadastraFilmeSobreescrever() {
		fn.cadastraFilme(1, "AVATAR", "2009", "Disney+");
		assertEquals(fn.cadastraFilme(1, "20 dias em Mariupol", "2023", "Cinema"), "FILME ADICIONADO");
	}

	@Test
	void testCadastraFilmeRepetido1() {
		fn.cadastraFilme(1, "AVATAR", "2009", "Disney+");
		assertEquals(fn.cadastraFilme(3, "AVATAR", "2009", "Disney+"), "FILME JA ADICIONADO");
	}
	
	@Test
	void testCadastraFilmeRepetido2() {
		fn.cadastraFilme(1, "AVATAR", "2009", "Disney+");
		assertEquals(fn.cadastraFilme(3, "AVATAR", "2009", "Popcornfilx"), "FILME JA ADICIONADO");
	}
	
	@Test
	void testCadastraFilmeLimiteSup() {
		assertEquals(fn.cadastraFilme(100, "AVATAR", "2009", "Disney+"), "FILME ADICIONADO");
	}
	
	@Test
	void testCadastraFilmeLimiteSupMais() {
		assertEquals(fn.cadastraFilme(101, "AVATAR", "2009", "Disney+"), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testCadastraFilmeLimiteInfMenos() {
		assertEquals(fn.cadastraFilme(0, "AVATAR", "2009", "Disney+"), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testCadastraFilmeSemLocal() {
		assertEquals(fn.cadastraFilme(1, "20 dias em Mariupol", "2023", ""), "FILME INVALIDO");
	}
	
	@Test
	void testCadastraFilmeSemAno() {
		assertEquals(fn.cadastraFilme(1, "20 dias em Mariupol", "", "Cinema"), "FILME ADICIONADO");
	}
	
	@Test
	void testCadastraFilmeSemNome() {
		assertEquals(fn.cadastraFilme(1, "", "2023", "Cinema"), "FILME INVALIDO");
	}
	
	// DETALHAR FILME
	
	@Test
	void testDetalharFilme() {
		fn.cadastraFilme(1, "AVATAR", "2009", "Disney+");
		assertEquals(fn.getFilme(1), "AVATAR, 2009\nDisney+");
	}
	
	@Test
	void testDetalharFilmeSemAno() {
		fn.cadastraFilme(1, "20 dias em Mariupol", "", "Cinema");
		assertEquals(fn.getFilme(1), "20 dias em Mariupol\nCinema");
	}
	
	@Test
	void testDetalharFilmePosicaoVazia() {
		assertEquals(fn.getFilme(1), "");
	}
	
	@Test
	void testDetalharFilmeLimiteInfMenos() {
		assertEquals(fn.getFilme(0), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testDetalharFilmeLimiteSupMais() {
		assertEquals(fn.getFilme(101), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testDetalharFilmeHotList() {
		fn.cadastraFilme(1, "AVATAR", "2009", "Disney+");
		fn.adicionaHotList(1, 1);
		assertEquals(fn.getFilme(1), "🔥 AVATAR, 2009\nDisney+");
	}
	
	@Test
	void testAdicionaHotList() {
		fn.cadastraFilme(1, "AVATAR", "2009", "Disney+");
		assertEquals(fn.adicionaHotList(1, 1), "ADICIONADO À HOTLIST NA POSIÇÃO 1!");
	}
	
	@Test
	void testAdicionaHotListPosicaoInvalida1() {
		fn.cadastraFilme(1, "AVATAR", "2009", "Disney+");
		assertEquals(fn.adicionaHotList(0, 1), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testAdicionaHotListPosicaoInvalida2() {
		fn.cadastraFilme(1, "AVATAR", "2009", "Disney+");
		assertEquals(fn.adicionaHotList(1, 11), "POSIÇÃO INVÁLIDA");
	}
	
	@Test
	void testAdicionaHotListFilmeInvalido() {
		fn.cadastraFilme(1, "AVATAR", "2009", "Disney+");
		assertEquals(fn.adicionaHotList(2, 1), "FILME INVÁLIDO");
	}
	
	@Test
	void testRemoveHotList() {
		fn.cadastraFilme(1, "AVATAR", "2009", "Disney+");
		fn.adicionaHotList(1, 1);
		assertEquals(fn.removeHotList(1), "");
	}
	
	@Test
	void testRemoveHotListPosicaoInvalidaInf() {
		assertEquals(fn.removeHotList(0), "POSIÇÃO INVÁLIDA\n");
	}
	
	@Test
	void testRemoveHotListPosicaoInvalidaSup() {
		assertEquals(fn.removeHotList(11), "POSIÇÃO INVÁLIDA\n");
	}
	
	@Test
	void testRemoveHotListFilmeInvalido() {
		assertEquals(fn.removeHotList(2), "FILME INVÁLIDO\n");
	}
	
	
}
