package dao;

//Couche Métier
public class Client {
	protected static int id =1; 
	protected String nom;
	protected String prenom;
	public Client(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		id++;
	}
	//get set
	public static int getId() {
		return id;
	}
	public String getNom() {
		return nom;
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
