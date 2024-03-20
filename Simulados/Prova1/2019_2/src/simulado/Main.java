package simulado;

public class Main {

	public static void main(String[] args) {
		ProgRunners progr = new ProgRunners();
		
		progr.cadastrarCorredor("Vinicius", "123456789-10", 2005);
		progr.cadastrarTreinoCorredor("123456789-10", 30.5, 20, "descircaio");
		progr.cadastrarTreinoCorredor("123456789-10", 10.2, 60, "descircaio");
		progr.finalizarTreino("123456789-10", 1, 10);
		progr.finalizarTreino("123456789-10", 2, 20);
		
		System.out.println(progr.resistenciaCorredor("123456789-10"));
	}

}
