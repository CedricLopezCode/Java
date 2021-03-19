package serie_1_exo_2_Prof;

public class Enseignant {
	protected int id_enseignant;
	protected String nom_enseignant;
	protected int id_specialite;
	
	//Constructeur
	public Enseignant() {
		super();
	}
	public Enseignant(int id_specialite) {
		super();
		this.id_specialite = id_specialite;
	}
	public Enseignant(String nom_enseignant, int id_specialite) {
		super();
		this.nom_enseignant = nom_enseignant;
		this.id_specialite = id_specialite;
	}
	


	//Accesseurs
	public int getId_enseignant() {
		return id_enseignant;
	}
	public void setId_enseignant(int id_enseignant) {
		this.id_enseignant = id_enseignant;
	}
	public String getNom_enseignant() {
		return nom_enseignant;
	}
	public void setNom_enseignant(String nom_enseignant) {
		this.nom_enseignant = nom_enseignant;
	}
	public int getId_specialite() {
		return id_specialite;
	}
	public void setId_specialite(int id_specialite) {
		this.id_specialite = id_specialite;
	}
	//toString
	@Override
	public String toString() {
		return "Enseignant [id_enseignant=" + id_enseignant + ", nom_enseignant=" + nom_enseignant + ", id_specialite="
				+ id_specialite + "]";
	}
	
	
}
