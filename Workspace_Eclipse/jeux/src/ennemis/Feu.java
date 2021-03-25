package ennemis;

public class Feu extends Element<Feu>{

	protected final String nom = "feu";
	
	public void lanceFlamme() {
		System.out.println("Lance-Flamme");
	}
	
	public String getNom() {
		return nom;
	}
	
}// Fin Class
