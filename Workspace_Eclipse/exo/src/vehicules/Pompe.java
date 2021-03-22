package vehicules;

public class Pompe{
	//Atributs
	protected String type_carburant;
	protected int contenance_max;
	protected int contenu;
	
			//Constructeur
	public Pompe() {
		super();
		this.type_carburant = "essence";
		this.contenance_max = 10000;
		this.contenu = 5000;
	}
	public Pompe(String type_carburant) {
		super();
		this.type_carburant = type_carburant;
		this.contenance_max = 10000;
		this.contenu = 5000;
	}
	
	public String getType_carburant() {
		return type_carburant;
	}
	public void setType_carburant(String type_carburant) {
		this.type_carburant = type_carburant;
	}
	public int getContenance_max() {
		return contenance_max;
	}
	public void setContenance_max(int contenance_max) {
		this.contenance_max = contenance_max;
	}
	public int getContenu() {
		return contenu;
	}
	public void setContenu(int contenu) {
		this.contenu = contenu;
	}
	@Override
	public String toString() {
		return "Carburant= " + type_carburant + ",\n Contenance_max=" + contenance_max + " L,\nContient actuellement " + contenu
				+ " L";
	}

		
}//Fin Pompe
