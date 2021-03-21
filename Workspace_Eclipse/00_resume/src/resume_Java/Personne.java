package resume_Java;

public class Personne implements Interface_Homme_Lion{
	//Attributs
	protected int age = 18;
	protected String prenom = "Cédric";
	protected static int comptage; 
	//static == partagé entre toustes les instances de cette classe
	
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
	//Constructeur
	//avec ou sans parametres
	//autant qu'on veut pour les adapter suivant les besoins
	public Personne() {
		super();
	}
	public Personne(int age, String prenom) {
		super();
		this.age = age;
		this.prenom = prenom;
	}
	//getters et setters
	//Pour y acceder et les modifier avec un minimum de sécurité
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public static int getComptage() {
		return comptage;
	}
	public static void setComptage(int comptage) {
		Personne.comptage = comptage;
	}
	//toString pour decrire // Personnalisable
	@Override
	public String toString() {
		return "Personne [age=" + age + ", prenom=" + prenom + "]";
	}
	
	//Interface
	@Override
	public String caresser() {
		return "Il est trop chou";
	}
	
	
	
	
}//Fiin Personne

