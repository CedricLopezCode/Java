package cours_0317;

public class Personne {
	private String prenom;
	private String nom;
	private String email;
	private int age = 18; //valeur par defaut
	//attributs toujours en private pour securité
	
	public void marcher() {
		
	}
	//source > generate toString()
	//pour pouvoir afficher les attributs de l'objet direct dans main
	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + ", email=" + email + ", age=" + age + "]";
	}

	//constructeur sans parametre
	//source > generate constructeur from superclass
	public Personne() {
		super(); //fonction magique qui permet d'acceder à tout
	}
	//constructeur avec parametre
	//source > generate constructeur using fields
	public Personne(String prenom_param, String nom_param, String email_param, int age_param) {
		super();
		this.prenom = prenom_param;
		this.nom = nom_param;
		this.email = email_param;
		this.age = age_param;
	}
	//getters (accesseurs) et setters (mutateurs)
	//source > generate getters and setters
	public String getPrenom() {//juste acceder et afficher
		return prenom;
	}
	public void setPrenom(String prenom_modif) {//juste modifier
		this.prenom = prenom_modif;
	}
		
		
}
