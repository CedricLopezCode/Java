package ennemis;

public class Feu extends Element<Feu>{

	protected final String nomElement = "feu";
	
	public void lanceFlamme() {
		System.out.println("Lance-Flamme");
	}
	
	public String getNom() {
		return nomElement;
	}

	public Feu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}// Fin Class
