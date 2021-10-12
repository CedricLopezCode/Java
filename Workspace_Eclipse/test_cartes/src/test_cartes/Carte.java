package test_cartes;

public class Carte {
	
		//Attributs
	protected int force;
	protected String forme;
	
	
		//Méthodes
	
		
		//Constructeur
	public Carte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Carte(int force, String forme) {
		super();
		this.force = force;
		this.forme = forme;
	}

		//Accesseurs
	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public String getForme() {
		return forme;
	}

	public void setForme(String forme) {
		this.forme = forme;
	}

	@Override
	public String toString() {
		final String nom;
		switch (force) {
		case 11:
			nom = "Valet";
			break;
		case 12:
			nom = "Dame";
			break;
		case 13:
			nom = "Roi";
			break;
		case 14:
			nom = "As";
			break;

		default:
			nom = String.valueOf(force);
			break;
		}
		return nom + " de " + forme ;
	}
	
	


}
