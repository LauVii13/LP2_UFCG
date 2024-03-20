package simulado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteProgRunners {
	private ProgRunners progr;
	@BeforeEach 
    void init() {
        progr = new ProgRunners();
        progr.cadastrarCorredor("Vinicius", "123456789-10", 2002);
    }
	
	@Test
	void testeExibirCategoriaCorredor() {
		assertEquals(progr.exibirCategoriaCorredor("123456789-10"), "JOVEM");
	}
	
	@Test
	void testeResistenciaCorredor() {
		progr.cadastrarTreinoCorredor("123456789-10", 30.5, 20, "descircaio");
		progr.cadastrarTreinoCorredor("123456789-10", 10.2, 60, "descircaio");
		progr.finalizarTreino("123456789-10", 1, 10);
		progr.finalizarTreino("123456789-10", 2, 20);

		assertEquals(progr.resistenciaCorredor("123456789-10"), 1);
	}
}
