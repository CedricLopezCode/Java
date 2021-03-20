package serie_1_exo_2_Prof;

public class Specialite {
	
	protected int id_specialite;
	protected String nom_specialite;
	protected static int comptage;
	//Constructeur
	public Specialite() {
		super();
		this.id_specialite = ++comptage;
		this.nom_specialite = "Rien";
	}

	public Specialite(String nom_specialite) {
		super();
		this.id_specialite = ++comptage;
		this.nom_specialite = nom_specialite;
	}

	//Accesseurs
	public int getId_specialite() {
		return id_specialite;
	}
	
	public void setId_specialite(int id_specialite) {
		this.id_specialite = id_specialite;
	}
	
	public String getNom_specialite() {
		return nom_specialite;
	}
	
	public void setNom_specialite(String nom_specialite) {
		this.nom_specialite = nom_specialite;
	}
	
	//toString
	@Override
	public String toString() {
		return "Specialite n�" + id_specialite + " est " + nom_specialite;
	}
	
	
	
	
}
