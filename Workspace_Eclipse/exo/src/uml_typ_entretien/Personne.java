package uml_typ_entretien;

public class Personne {

	protected String nom;
	protected String prenom;
	
	public Personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public void afficher(Maison maison, Jardin jardin){
		System.out.println("nom: "+ nom);
		System.out.println("Ma maison: "+ maison.toString());
		System.out.println("Mon jardin: "+ jardin.toString());
	}
}
