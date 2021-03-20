package serie_1_exo_2_Prof;

public class Enseignant {
	protected int id_enseignant;
	protected String nom_enseignant;
	protected Specialite specialite;
	protected static int comptage_enseignant;
	
	//Constructeur
	public Enseignant() {
		super();
		this.id_enseignant = ++comptage_enseignant;
	}
	public Enseignant(Specialite specialite) {
		super();
		this.id_enseignant = ++comptage_enseignant;
		this.specialite = specialite;
	}
	public Enseignant(String nom_enseignant, Specialite specialite) {
		super();
		this.id_enseignant = ++comptage_enseignant;
		this.nom_enseignant = nom_enseignant;
		this.specialite = specialite;
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
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	//toString
	@Override
	public String toString() {
		return "Enseignant [id_enseignant=" + id_enseignant + ",\nnom_enseignant=" + nom_enseignant + ",\nspecialite="
				+ specialite + "]";
	}
	
	
}
