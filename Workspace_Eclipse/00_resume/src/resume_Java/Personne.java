package resume_Java;

public class Personne {
	//Attributs
	private int age = 18;
	private String prenom = "Cédric";
	
	//Méthodes
	public void marcher() {
		
	}
	public void changer_nom() {
		prenom = "Moussa";
	}
	public void afficher() {
		
	}
	public void anniversaire() {
		age = age + 1;
	}
	public void montrer_var() {
		System.out.println(prenom + " " + age + " ans");
	}
}

