package uml_typ_entretien;

public class Main_type_entretien {

	public static void main(String[] args) {

		Jardin jardin = new Jardin(200); 
		Maison maison = new Maison(60); 
		Personne moussa = new Personne("Camara","Moussa"); 
		
		moussa.afficher(maison, jardin);
	}

}
