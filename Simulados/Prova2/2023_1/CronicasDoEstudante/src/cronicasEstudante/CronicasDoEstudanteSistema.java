package cronicasEstudante;

public class CronicasDoEstudanteSistema {
	private static final int TOTALCRONICAS = 1000;
	private static final int TOTALLIVRETOS = 100;
	private Cronica[] cronicas;
	private int idCronica;
	private int[] qtdLidas;
	private Livreto[] livretos;
	private int idLivreto;
	
	
	public CronicasDoEstudanteSistema() {
		this.cronicas = new Cronica[TOTALCRONICAS];
		this.idCronica = 0;
		this.qtdLidas = new int[TOTALCRONICAS];
		this.livretos = new Livreto[TOTALLIVRETOS];
		this.idLivreto = 0;
	}

	public void cadastrarCronica(String titulo, String texto, String data, String autor) {
		this.cronicas[this.idCronica] = new Cronica(this.idCronica + 1, titulo, texto, data, autor);
		this.idCronica++;
	}
	
	public void cadastrarCronica(String titulo, String texto, String data) {
		this.cronicas[this.idCronica] = new Cronica(this.idCronica + 1, titulo, texto, data);
		this.idCronica++;
	}
	
	public String listarCronicas() {
		StringBuilder texto = new StringBuilder();
		
		for(Cronica c : cronicas) {
			if(c != null) {
				this.qtdLidas[c.getId() - 1]++;
				texto.append(c.toString()).append("\n");
			}
		}
		
		return texto.toString();
	}
	
	public String lerCronica(int i) {
		this.qtdLidas[i]++;
		return this.cronicas[i].getTexto();
	}
	
	public String exibirCronicaMaisLida() {
		int maior = 0;
		int idMaior = 0;
		for(int i = 0; i < TOTALCRONICAS; i++) {
			if(this.qtdLidas[i] > maior) {
				maior = this.qtdLidas[i];
				idMaior = i;
			}
		}
		return this.cronicas[idMaior].getTitulo() + " - lida " + maior + "vezes";
	}

	public void criarLivreto(int[] idCronicas){
		if (idCronicas.length < 3 && idCronicas.length > 5) {
			System.out.println("Erro ao criar Livreto!");
		}
		else {
			Cronica[] listaCronicas = new Cronica[idCronicas.length];
			int i = 0;
			for(int indice : idCronicas) {
				listaCronicas[i] = this.cronicas[indice];
				i++;
			}
			
			Livreto novoLivreto = new Livreto(listaCronicas);
			this.livretos[this.idLivreto] = novoLivreto;
			this.idLivreto++;
			
			if(this.idLivreto >= TOTALLIVRETOS) {
				idLivreto = 0;
			}
		}
		
	}
	
	public String lerLivreto(int i) {
		StringBuilder texto = new StringBuilder();
		
		Livreto l = this.livretos[i];
		for(Cronica c : l.getCronica()) {
			texto.append(lerCronica(c.getId()-1)).append("\n");
		}
		return texto.toString();
	}
	
	public boolean contemCronicaNoLivreto(String autor, int idLivreto) {
		Livreto l = this.livretos[idLivreto];
		for(Cronica c : l.getCronica()) {
			if(autor.equals(c.getTitulo())) {
				return true;
			}
		}
		return false;
	}
}
