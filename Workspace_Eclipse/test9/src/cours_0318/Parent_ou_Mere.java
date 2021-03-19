package cours_0318;

public class Parent_ou_Mere {
	private String nom;
	private int departement;
	
	public String affichage_publique() {
		return "Je suis le parent public";
	}
	private String affichage_private() {
		return "Je suis le parent private";
	}
	protected String affichage_protected() {
		return "Je suis le parent protected";
	}
}
