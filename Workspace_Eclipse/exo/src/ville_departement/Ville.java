package ville_departement;

public class Ville {
	//Attributs
	private String nom;
	private String departement /*= "Paris"*/;

	public void afficher() {
		System.out.println("La ville " + nom + " est dans le département " + departement);
	}

	@Override
	public String toString() {
		return "Ville:" + nom + " Departement: " + departement;
	}

	//Constructeurs
	public Ville() {//inutile en pratique
		super();
		this.nom = "Paris";
		this.departement = "Paris";
	}
	public Ville(String nom) {
		super();
		this.nom = nom;
		this.departement = "Paris";
	}
	public Ville(String nom, String departement) {
		super();
		this.nom = nom;
		this.departement = departement;
	}

	//getters et setteurs
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getDepartement() {
		return departement;
	}
	
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	
}
