package uml_typ_entretien;

public class Maison {

	protected float surface;

	public Maison(float surface) {
		super();
		this.surface = surface;
	}
	
	@Override
	public String toString() {
		return "Je suis une maison ou appartement, ma surface est de " + surface + " m2";
	}

	
	
	
}
