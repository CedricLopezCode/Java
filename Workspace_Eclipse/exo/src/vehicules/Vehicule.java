package vehicules;

abstract public class Vehicule{
			//Atributs
	protected int nombre_roues;
	protected String type_carburant;
	protected int vitesse_max;
	protected int contenance_max_reservoir;
	protected int contenu_reservoir;
	
			//Méthode
	public String verif_roues() {return "Ce vehicule a " + nombre_roues +" roues";}
	public String verif_carburant() {return "Ce vehicule carbure au " + type_carburant;}
	public String verif_vitesse_max() {return "Ce vehicule peut aller jusqu'à " + vitesse_max +" km/h";}
	public String verif_reservoir() {
		return "Le réservoir est rempli à " + contenu_reservoir +" L sur les "+ contenance_max_reservoir +" L max ";
	}
	
	public int fairePlein(Pompe pompe) {
		if(this.type_carburant != pompe.getType_carburant()) {
			System.out.println("Erreur de carburant !");
			return 0;
		}
		int carburant_transfere = contenance_max_reservoir - contenu_reservoir;
		this.contenu_reservoir = contenance_max_reservoir;
		pompe.setContenu(pompe.getContenu() - carburant_transfere);
		return carburant_transfere;
	}
	
	
	@Override
	public String toString() {
		return "Ce vehicule a " + nombre_roues + " roues,\nIl carbure au " + type_carburant + ",\nIl peut aller jusqu'à "
				+ vitesse_max + " km/h";
	}
	
			//Get et set
	public int getNombre_roues() {
		return nombre_roues;
	}
	public void setNombre_roues(int nombre_roues) {
		this.nombre_roues = nombre_roues;
	}
	public String getType_carburant() {
		return type_carburant;
	}
	public void setType_carburant(String type_carburant) {
		this.type_carburant = type_carburant;
	}
	public int getVitesse_max() {
		return vitesse_max;
	}
	public void setVitesse_max(int vitesse_max) {
		this.vitesse_max = vitesse_max;
	}
	public int getContenance_max_reservoir() {
		return contenance_max_reservoir;
	}
	public void setContenance_max_reservoir(int contenance_max_reservoir) {
		this.contenance_max_reservoir = contenance_max_reservoir;
	}
	public int getContenu_reservoir() {
		return contenu_reservoir;
	}
	public void setContenu_reservoir(int contenu_reservoir) {
		this.contenu_reservoir = contenu_reservoir;
	}
	
	
	
	
	
}	//Fin Véhicule
