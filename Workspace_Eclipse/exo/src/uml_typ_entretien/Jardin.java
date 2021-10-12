package uml_typ_entretien;

public class Jardin {

	protected float surface;
	protected boolean piscine;
	
	public Jardin(float surface) {
		super();
		this.surface = surface;
		this.piscine = true;
	}

	@Override
	public String toString() {
		return "Je suis le jardin, ma surface est de " + surface + " m2 et une piscine";
	}
	
	
}
