package serie_1_exo_1_Livre;

public class Livre {
	protected int id;
	protected String Titre;
	protected String Auteur;
	protected float Prix;
	
	//Getteurs et Setteurs
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return Titre;
	}
	public void setTitre(String titre) {
		Titre = titre;
	}
	public String getAuteur() {
		return Auteur;
	}
	public void setAuteur(String auteur) {
		Auteur = auteur;
	}
	public float getPrix() {
		return Prix;
	}
	public void setPrix(float prix) {
		Prix = prix;
	}
	//toString
		@Override
	public String toString() {
		return "Le livre n°" + id + " s'appelle " + Titre + ",\nIl a été écrit par " + Auteur + " et\nIl coute " + Prix + " €";
	}

	
	//Constructeur
	public Livre(int id, String titre, String auteur, float prix) {
		super();
		this.id = id++;
		Titre = titre;
		Auteur = auteur;
		Prix = prix;
	}
	public Livre(String titre, String auteur, float prix) {
		super();
		this.id = id++;
		Titre = titre;
		Auteur = auteur;
		Prix = prix;
	}
	
	
	
	
}
