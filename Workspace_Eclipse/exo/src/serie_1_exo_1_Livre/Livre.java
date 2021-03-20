package serie_1_exo_1_Livre;
/*
// On peut aussi utiliser AtomicInteger pour l'auto incrémentation.
import java.util.concurrent.atomic.AtomicInteger;

public class Livre {

    private static AtomicInteger id = new AtomicInteger(0);
    private int livreID;
    private String titre;
    private String auteur;
    private int prix;

    public Livre(String titre, String auteur, int prix) {
        this.livreID = id.incrementAndGet();    
        this.titre = titre;
        this.auteur = auteur;
        this.prix = prix;
}
 */
public class Livre {
	protected static int id;//static pour que ca reste pour le prochain
	protected String Titre;
	protected String Auteur;
	protected float Prix;
	
	//Getteurs et Setteurs
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
	@Override
		public String toString() {
			return "Le livre n°" + id + " s'appelle " + Titre + ",\nIl a été écrit par " + Auteur + " et\nIl coute " + Prix + " €";
		}
//return "Le livre n°" + id + " s'appelle " + Titre + ",\nIl a été écrit par " + Auteur + " et\nIl coute " + Prix + " €";
	//Constructeur
	public Livre(String titre, String auteur, float prix) {
		super();
		this.id = ++id;
		Titre = titre;
		Auteur = auteur;
		Prix = prix;
	}
	
	
	
	
}
