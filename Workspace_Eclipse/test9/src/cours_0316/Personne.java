package cours_0316;

public class Personne {
	private int age = 18;
	private String nom = "Lopez";
	
	public void marcher() {
		
	}
	public void changer_nom() {
		nom = "moussa";
	}
	public void afficher() {
		
	}
	public void anniversaire() {
		age = age + 1;
	}
	public void montrer_var() {
		System.out.println(nom + " " + age + " ans");
	}
}
