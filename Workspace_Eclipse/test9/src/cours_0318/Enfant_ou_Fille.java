package cours_0318;

public class Enfant_ou_Fille extends Parent_ou_Mere{
	public void affichage_enfant() {
		System.out.println("Je suis l'enfant");
	}
	public String fille() {
		return "Je suis la fille";
	}
	public String fillebis() {
		return "Je suis la fille" + affichage_publique();
	}
}
