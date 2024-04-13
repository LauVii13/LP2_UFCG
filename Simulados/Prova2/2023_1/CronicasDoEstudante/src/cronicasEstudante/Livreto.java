package cronicasEstudante;

public class Livreto {
	public Cronica[] cronicas;

	public Livreto(Cronica[] cronicas) {
		this.cronicas = cronicas;
	}
	
	public Cronica[] getCronica() {
		return this.cronicas.clone();
	}
	
	
}
