package vehicules;

public class Voiture extends Vehicule {
	
			//Atributs
	protected final int nombre_roues = 4;
	
			//Constructeur
	public Voiture() {
		super();
		this.type_carburant = "essence";
		this.vitesse_max = 150;
		this.contenance_max_reservoir = 50;
		this.contenu_reservoir = 10;
	}
	public Voiture(String type_carburant) {
		super();
		this.type_carburant = type_carburant;
		this.vitesse_max = 150;
		this.contenance_max_reservoir = 50;
		this.contenu_reservoir = 10;
	}
	public Voiture(int vitesse_max) {
		super();
		this.type_carburant = "essence";
		this.vitesse_max = vitesse_max;
		this.contenance_max_reservoir = 50;
		this.contenu_reservoir = 10;
	}
	public Voiture(String type_carburant, int vitesse_max) {
		super();
		this.type_carburant = type_carburant;
		this.vitesse_max = vitesse_max;
		this.contenance_max_reservoir = 50;
		this.contenu_reservoir = 10;
	}
	
	
	
	
}	//Fin Voiture
