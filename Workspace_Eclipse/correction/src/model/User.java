package model;

public class User {

	//Les attributs 
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	
	//Les constructeurs
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String nom, String prenom, String email, String password) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
	}
	

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	//Les accesseurs et mutateurs --- get et set
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
