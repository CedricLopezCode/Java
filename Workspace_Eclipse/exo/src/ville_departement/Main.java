package ville_departement;

public class Main {

	public static void main(String[] args) {
		Ville paris = new Ville();
		Ville grenoble = new Ville("Grenoble","Isère");
		Ville lyon = new Ville("Lyon", "69");
		Ville parisbis = new Ville("Paris");
		
		System.out.println(paris);
		grenoble.afficher();
		lyon.afficher();
		parisbis.afficher();
		
		parisbis.setDepartement("75");
		parisbis.afficher();
		
		
	}

}
