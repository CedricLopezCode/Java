package heritage_Mario_Kart;

public class Carapace extends Arme{
	protected String couleur;
	protected String nom = "Carapace " /*+ couleur*/;
	protected String description = "Prend ça !!\nJe vais te dépasser";
	@Override
	public String toString() {
		return "Carapace [couleur=" + couleur + ", nom=" + nom + ", description=" + description + "]";
	}

	public Carapace() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
