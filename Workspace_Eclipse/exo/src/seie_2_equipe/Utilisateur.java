package seie_2_equipe;

public class Utilisateur {
	protected String nom;
	protected Roles role;
	@Override
	public String toString() {
		return  nom + " : " + role;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public Utilisateur(String nom, Roles role) {
		super();
		this.nom = nom;
		this.role = role;
	}
	
	
	
}
