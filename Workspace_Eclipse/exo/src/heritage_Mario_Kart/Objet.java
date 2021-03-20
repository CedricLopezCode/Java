package heritage_Mario_Kart;

abstract public class Objet {
	protected String nom;
	protected String description;
	protected String type;
	
	public void obtenir(String type, String nom, String description) {
		System.out.println(type +" "+ nom + " obtenu\n" + description); 
	}
	public void utiliser(String type, String nom, String description) {
		System.out.println(type +" "+ nom + " utilisé\n" + description); 
	}
}
