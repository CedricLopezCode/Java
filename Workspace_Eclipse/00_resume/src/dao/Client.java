package dao;

//Couche Métier
public class Client {
	protected int id; 
	protected String nom;
	protected String prenom;
	protected static int comptage=1;
	
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		comptage++;
	}
	//get set
	
	public String getNom() {
		return nom;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getComptage() {
		return comptage;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	
}
