package vehicules;

public class Moto extends Vehicule{
	protected final int nombre_roues = 2;
		
				//Constructeur
		public Moto() {
			super();
			this.type_carburant = "essence";
			this.vitesse_max = 100;
			this.contenance_max_reservoir = 30;
			this.contenu_reservoir = 10;
		}
		public Moto(String type_carburant) {
			super();
			this.type_carburant = type_carburant;
			this.vitesse_max = 100;
			this.contenance_max_reservoir = 30;
			this.contenu_reservoir = 10;
		}
		public Moto(int vitesse_max) {
			super();
			this.type_carburant = "essence";
			this.vitesse_max = vitesse_max;
			this.contenance_max_reservoir = 30;
			this.contenu_reservoir = 10;
		}
		public Moto(String type_carburant, int vitesse_max) {
			super();
			this.type_carburant = type_carburant;
			this.vitesse_max = vitesse_max;
			this.contenance_max_reservoir = 30;
			this.contenu_reservoir = 10;
		}
	
	
}//Fin Moto
