package seie_2_equipe;

public class Roles {
	protected String nom_role;
	protected String acronyme;
	public String getNom_role() {
		return nom_role;
	}
	public void setNom_role(String nom_role) {
		this.nom_role = nom_role;
	}
	public String getAcronyme() {
		return acronyme;
	}
	public void setAcronyme(String acronyme) {
		this.acronyme = acronyme;
	}
	@Override
	public String toString() {
		return  nom_role + " (" + acronyme+ ")";
	}
	public Roles(String nom_role, String acronyme) {
		super();
		this.nom_role = nom_role;
		this.acronyme = acronyme;
	}
	
	
}
